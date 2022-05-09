package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
public class HomeController {
    private static final String name = "김윤서";
    private static final String univ = "숭실대학교";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);
        model.addAttribute("serverTime", formattedDate);
        model.addAttribute("name", name);
        model.addAttribute("univ", univ);
        return "home";
    }

    @RequestMapping(value = "/kimyoonseo", method = RequestMethod.GET)
    public String kimyoonseo(Model model) {
        model.addAttribute("name", name);
        model.addAttribute("age","23");

        return "introduction";
    }

    @RequestMapping(value = "/soongsil", method = RequestMethod.GET)
    public String soongsil(Model model) {
        model.addAttribute("univ", univ);
        model.addAttribute("location","서울특별시 동작구 상도로 369 (상도동 551)");

        return "soongsil";
    }
}
