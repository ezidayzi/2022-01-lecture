import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 스프링 설정 클래스로 지정하는 애노테이션
public class AppContext {
    @Bean // 해당 메서드가 생성한 객체를 스프링이 관리하도록 지정하는 애노테이션
    public Greeter greeter() {
        Greeter g = new Greeter();
        g.setFormat("%s, 안녕하세요!");
        return g;
    }

    @Bean
    public Introducer introducer() {
        Introducer i = new Introducer();
        i.setFormat("안녕하세요! 저는 %s이고 나이는 %s세 입니다.");
        return i;
    }

}