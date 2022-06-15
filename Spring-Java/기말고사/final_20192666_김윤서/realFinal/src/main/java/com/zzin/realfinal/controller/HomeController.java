package com.zzin.realfinal.controller;

import com.zzin.realfinal.entities.User;
import com.zzin.realfinal.model.*;
import com.zzin.realfinal.service.OrderService;
import com.zzin.realfinal.service.ProductService;
import com.zzin.realfinal.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final ProductService productService;
    private final OrderService orderService;
    private final UserService userService;

    private LoginInfo login_info = new LoginInfo();
    private UserInfo user_info = new UserInfo();

    @GetMapping("/")
    public String root() {
        return "index";
    }

    /*
    회원 가입
     */
    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public String signUp(@ModelAttribute("userInfo")  UserInfo userInfo) {
        return "user/signUp/signUp";
    }

    @PostMapping("/submitsignup")
    public String signUpResult(@Valid UserInfo userInfo, Errors errors) {
        if(errors.hasErrors()) {
            return "user/signUp/signUp";
        }
        User user = new User();
        user.setUserId(userInfo.getUserid());
        user.setBirthday(userInfo.getBirthday());
        user.setEmail(userInfo.getEmail());
        user.setTel(userInfo.getTel());
        user.setPwd(userInfo.getPwd());
        user.setAddr(userInfo.getAddr());
        userService.insert(user);

        return "user/signUp/signUpSuccess";
    }


    /*
    로그인
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@ModelAttribute("loginInfo") LoginInfo loginInfo, Model model,
                        HttpSession session, @CookieValue(value="REMEMBERID", required=false) Cookie rCookie) {
        if(session == null || session.getAttribute("authInfo") == null) {
            if(rCookie != null) {
                loginInfo.setUserid(rCookie.getValue());
                loginInfo.setRememberId(true);
            }
        }

        return "userHome";
    }

    @PostMapping("/submit")
    public String loginResult(@Valid LoginInfo loginInfo, Errors errors,
                              HttpSession session, HttpServletResponse response) {
        if(errors.hasErrors()) {
            return "userHome";
        }

        session.setAttribute("authInfo", loginInfo);

        Cookie rememberCookie = new Cookie("REMEMBERID", loginInfo.getUserid());
        rememberCookie.setPath("/");

        if(loginInfo.getRememberId()) {
            rememberCookie.setMaxAge(60*60*24*30);
        } else {
            rememberCookie.setMaxAge(0);
        }
        response.addCookie(rememberCookie);

        login_info = loginInfo;
        return "user/login/loginSuccess";
    }

    // 리다이렉트 처리
    @GetMapping("/submit")
    public String loginRedirect() {
        return "redirect:/";
    }

    @RequestMapping("/userInfo/{id}")
    public String userinfo(@PathVariable("id") String userid, @ModelAttribute("userInfo") UserInfo userInfo) {
        if(userInfo == null)
            userInfo = new UserInfo();

        var user = userService.find(userid);
        userInfo.setAddr(user.getAddr());
        userInfo.setBirthday(user.getBirthday());
        userInfo.setEmail(user.getEmail());
        userInfo.setTel(user.getTel());
        userInfo.setUserid(user.getUserId());
        userInfo.setPwd(user.getPwd());
        return "user/info/userinfo";
    }

    @RequestMapping("/modifyUserInfo")
    public String modifyuserinfo(@ModelAttribute("userInfo") UserInfo userInfo) {
        return "user/info/modifyUserinfo";
    }

    @PostMapping("/submituserinfo")
    public String modifyUserInfoResult(@Valid UserInfo userInfo, Errors errors) {
        if(errors.hasErrors()) {
            return "user/info/modifyUserinfo";
        }
        if(userInfo != null) {
            User user = new User();
            user.setAddr(userInfo.getAddr());
            user.setBirthday(userInfo.getBirthday());
            user.setEmail(userInfo.getEmail());
            user.setTel(userInfo.getTel());
            user.setUserId(login_info.getUserid());
            user.setPwd(login_info.getPwd());
            userService.modify(user);
        }
        return "user/info/userinfo";
    }


    @RequestMapping(value = "/user/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "user/logout/logout";
    }

    @RequestMapping(value = "/user/withdraw", method = RequestMethod.GET)
    public String withdraw(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();

        var user = userService.find(login_info.getUserid());
        userService.withdraw(user);
        return "user/withdraw/withdrawSuccess";
    }


    /*
    쇼핑몰
     */

    @GetMapping("/shop")
    public ModelAndView shop() {
        List<ProductInfo> list = productService.getAllProducts().values().stream().toList();

        ModelAndView mav = new ModelAndView();
        mav.addObject("list", list);
        mav.setViewName("shop/allProduct");
        return mav;
    }

    @GetMapping("/detail")
    public ModelAndView detail(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("id"));
        var item = productService.get(id);

        ModelAndView mav = new ModelAndView();
        mav.addObject("productInfo", item);
        mav.addObject("authInfo", login_info);
        mav.setViewName("shop/productDetail");
        return mav;
    }

    @GetMapping("/search")
    public ModelAndView search(HttpServletRequest request, Model model) {
        List<ProductInfo> list = productService.searchWithName(request.getParameter("keyword"));

        ModelAndView mav = new ModelAndView();
        mav.addObject("list", list);
        mav.setViewName("shop/allProduct");
        return mav;
    }

    @PostMapping("/basket")
    public ModelAndView basket(HttpServletRequest request, Model model){
        List<ProductInfo> productInfoList = new ArrayList<>();
        for(String item: request.getParameterValues("item")) {
            productInfoList.add(productService.get(Integer.parseInt(item)));
        }

        ModelAndView mav = new ModelAndView();
        mav.addObject("list", productInfoList);
        mav.addObject("authInfo", login_info);
        mav.setViewName("shop/basket");
        return mav;
    }

    @GetMapping("/delivery")
    public ModelAndView delivery(HttpServletRequest request, Model model){
        ModelAndView mav = new ModelAndView();
        System.out.println("userid: "+login_info.getUserid());
        var order = orderService.get(login_info.getUserid());
        if(order!=null)
            mav.addObject("list", orderService.get(login_info.getUserid()).getProducts());
        mav.setViewName("shop/productDelivery");
        return mav;
    }

    @PostMapping("/userProduct")
    public ModelAndView userProduct(HttpServletRequest request, Model model){
        List<ProductInfo> productInfoList = new ArrayList<>();
        var sum = 0;
        for(String item: request.getParameterValues("item")) {
            var product = productService.get(Integer.parseInt(item));
            productInfoList.add(product);
            sum += product.getPrice();
        }
        var userInfo = userService.find(login_info.getUserid());
        var orderProduct = new OrderProductInfo();
        orderProduct.setId(login_info.getUserid());
        orderProduct.setUser(userInfo);
        orderProduct.setProducts(productInfoList);
        orderProduct.setOrderPrice(sum);
        orderProduct.setCount(productInfoList.size());
        orderService.add(orderProduct);

        ModelAndView mav = new ModelAndView();
        mav.addObject("list", productInfoList);
        mav.addObject("userInfo", userService.find(login_info.getUserid()));
        mav.addObject("totalCount", productInfoList.stream().count());
        mav.addObject("sum", sum);
        mav.setViewName("shop/userProduct");

        return mav;
    }

}
