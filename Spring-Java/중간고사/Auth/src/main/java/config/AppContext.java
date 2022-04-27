package config;

import repository.UserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import printer.DetailInfoPrinter;
import printer.InfoPrinter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import mather.PatternMatcher;


@Configuration
@ComponentScan(basePackages = {"service", "printer"})
public class AppContext {

    /*
    User 객체들을 가지고 있는 repository
     */
    @Bean
    public UserRepository userList() {
        return new UserRepository();
    }


    /*
    유효성 검증을 위한 객체
     */
    @Bean
    public PatternMatcher matcher() {
        return new PatternMatcher();
    }

    /*
    세부 정보를 프린트하는 객체
     */
    @Bean
    @Qualifier("detail")
    public DetailInfoPrinter detailInfoPrinter() {
        return new DetailInfoPrinter();
    }

    /*
    간단한 정보를 프린트하는 객체
     */
    @Bean
    @Qualifier("normal")
    public InfoPrinter infoPrinter() {
        return new InfoPrinter();
    }

}
