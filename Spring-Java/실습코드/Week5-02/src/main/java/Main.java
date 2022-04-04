import CarFactory.Car;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);

        Car car = ctx.getBean("car", Car.class);

    }
}
