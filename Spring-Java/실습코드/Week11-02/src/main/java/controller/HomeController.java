package Controller;

import model.BookInfo;
import model.CustomerInfo;
import model.UserInfo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import repository.UserRepository;
import service.QueryService;
import service.UserService;
import validator.UserInfoValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {
    private final QueryService queryService = new QueryService();

    @RequestMapping(value = "/")
    public String main() {
        return "index";
    }

    @RequestMapping(value = "/books")
    public String books() {
        return "books";
    }

    @RequestMapping(value = "/customers")
    public String customers() {
        return "customers";
    }



    @GetMapping("/orders")
    public ModelAndView orders() {
        List<CustomerInfo> customersInfo = queryService.getAllCustomers();
        List<BookInfo> booksInfo = queryService.getAllBooks();

        ModelAndView mav = new ModelAndView();
        mav.addObject("customersInfo", customersInfo);
        mav.addObject("booksInfo", booksInfo);
        mav.setViewName("orders");
        return mav;
    }

    @RequestMapping(value = "/submitCustomer", method = RequestMethod.POST)
    public String result(@ModelAttribute("customerData") CustomerInfo customerInfo, Model model) {
        queryService.insertCustomer(customerInfo);
        return "customerResult";
    }

    @RequestMapping(value = "/submitBook", method = RequestMethod.POST)
    public String bookTable(@ModelAttribute("bookData") BookInfo bookInfo, Model model) {
        queryService.insertBook(bookInfo);
        return "bookResult";
    }

    @GetMapping("/submit")
    public String dummyRedirect() {
        return "redirect:/";
    }

    @RequestMapping(value = "/sel", method = RequestMethod.POST)
    public String orderResult(HttpServletRequest request, Model model) {
        String[] book = request.getParameter("selectBook").split(",");

        int selectedCustId = Integer.parseInt(request.getParameter("selectCustomer"));
        int selectedBookId = Integer.parseInt(book[0]);
        int selectedBookPrice = Integer.parseInt(book[1]);

        queryService.insertOrder(selectedCustId, selectedBookId, selectedBookPrice);

        BookInfo bookinfo = queryService.getBookInfo(selectedBookId);
        CustomerInfo customerInfo = queryService.getCustomerInfo(selectedCustId);

        model.addAttribute("bookinfo", bookinfo);
        model.addAttribute("customerInfo", customerInfo);

        return "orderResult";
    }

}