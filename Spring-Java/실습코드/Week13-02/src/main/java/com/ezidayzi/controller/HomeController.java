package com.ezidayzi.controller;

import com.ezidayzi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final UserService userService;

//    @PostMapping("/submitsignup")
//    public String signUpResult(@Valid UserInfo userInfo, Errors errors) {
//        if(errors.hasErrors()) {
//            return "user/signUp/signUp";
//        }
//        User user = new User();
//        user.setId(userInfo.getUserid());
//        user.setPwd(userInfo.getPwd());
//        user.setBirthday(userInfo.getBirthday());
//        user.setAddress(userInfo.getAddr());
//        user.setEmail(userInfo.getEmail());
//        user.setTel(userInfo.getTel());
//        System.out.println(user);
//        return "user/signUp/signUpSuccess";
//    }
//
//    @RequestMapping(value = "/logout", method = RequestMethod.GET)
//    public String logout(HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        session.invalidate();
//        return "user/logout/logout";
//    }
//
//    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
//    public String signUp(@Valid UserInfo userInfo) {
//        return "user/signUp/signUp";
//    }
//    private HashMap<String, UserInfo> userInfoMap;
//
//    private LoginInfo login_info;
//    private UserInfo user_info;
//
//    public HomeController() {
//        user_info = new UserInfo();
//        login_info = new LoginInfo();
//        userInfoMap = new HashMap<>();
//    }
//
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "home/home";
    }

//
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String login(@ModelAttribute("loginInfo") LoginInfo loginInfo, Model model, HttpSession session, @CookieValue(value="REMEMBERID", required=false) Cookie rCookie) {
//        if(session == null || session.getAttribute("authInfo") == null) {
//            if(rCookie != null) {
//                loginInfo.setUserid(rCookie.getValue());
//                loginInfo.setRememberId(true);
//            }
//        }
//        return "userHome";
//    }
//
//    @PostMapping("/submit")
//    public String loginResult(@Valid LoginInfo loginInfo, Errors errors,
//                              HttpSession session, HttpServletResponse response) {
//        if(errors.hasErrors()) {
//            return "userHome";
//        }
//
//        var user = userInfoMap.get(loginInfo.getUserid());
//
//        if (user == null) {
//            return "userHome";
//        }
//
//        System.out.println(loginInfo.getPwd());
//        if (!user.getPwd().equals(loginInfo.getPwd())) {
//            return "userHome";
//        }
//
//        session.setAttribute("authInfo", loginInfo);
//
//        Cookie rememberCookie = new Cookie("REMEMBERID", loginInfo.getUserid());
//        rememberCookie.setPath("/");
//
//        if(loginInfo.getRememberId()) {
//            rememberCookie.setMaxAge(60*60*24*30);
//        } else {
//            rememberCookie.setMaxAge(0);
//        }
//        response.addCookie(rememberCookie);
//
//        login_info = loginInfo;
//        return "loginSuccess";
//    }
//    // 리다이렉트 처리
//    @GetMapping("/submit")
//    public String loginRedirect() {
//        return "redirect:/";
//    }
//
//    @RequestMapping("/userInfo/{id}")
//    public String userinfo(@PathVariable("id") String userid, @Valid UserInfo userInfo) {
//        if(userInfo == null)
//            userInfo = new UserInfo();
//
//        var user = userInfoMap.get(userid);
//        System.out.println("user");
//        System.out.println(user);
//        userInfo.setAddr(user.getAddr());
//        userInfo.setBirthday(user.getBirthday());
//        userInfo.setEmail(user.getEmail());
//        userInfo.setTel(user.getTel());
//        userInfo.setUserid(user.getUserid());
//        System.out.println("userInfo");
//        System.out.println(userInfo);
//
//        return "user/info/userinfo";
//    }
//
//    @RequestMapping("/modifyUserInfo")
//    public String modifyuserinfo(@ModelAttribute("userInfo") UserInfo userInfo) {
//        return "user/info/modifyUserinfo";
//    }
//
//    @PostMapping("/submituserinfo")
//    public String modifyUserInfoResult(@Valid UserInfo userInfo, Errors errors) {
//        if(errors.hasErrors()) {
//            return "user/info/modifyUserinfo";
//        }
//        if(userInfo != null) {
//            user_info.setAddr(userInfo.getAddr());
//            user_info.setBirthday(userInfo.getBirthday());
//            user_info.setEmail(userInfo.getEmail());
//            user_info.setTel(userInfo.getTel());
//            userInfoMap.put(userInfo.getUserid(), userInfo);
//        }
//        return "user/info/userinfo";
//    }
//
//    @PostMapping("/submitsignup")
//    public String signUpResult(@Valid UserInfo userInfo, Errors errors) {
//        if(errors.hasErrors()) {
//            return "signUp";
//        }
//        userInfoMap.put(userInfo.getUserid(), userInfo);
//        System.out.println(userInfo);
//        return "signUpSuccess";
//    }
//
//    @RequestMapping(value = "/logout", method = RequestMethod.GET)
//    public String logout(HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        session.invalidate();
//        return "user/logout/logout";
//    }
//
//    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
//    public String signUp(@Valid UserInfo userInfo) {
//        return "signUp";
//    }
//
//    @RequestMapping(value = "/withdraw", method = RequestMethod.GET)
//    public String withdraw(HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        session.invalidate();
//        System.out.println(userInfoMap.remove(login_info.getUserid()));
//        userInfoMap.remove(login_info.getUserid());
//        return "withdrawSuccess";
//    }
}