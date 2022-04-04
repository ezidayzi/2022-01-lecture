import CarFactory.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {

    // 자동차
    @Bean
    public Car car() {
        Wheel[] wheels = {wheel1(), wheel2(), wheel3(), wheel4()};
        return new Car(wheels, body());
    }

    @Bean
    public Body body() {
        return new Body();
    }

    @Bean
    public Tube tube1() {
        return new Tube();
    }

    @Bean
    public Tube tube2() {
        return new Tube();
    }

    @Bean
    public Tube tube3() {
        return new Tube();
    }

    @Bean
    public Tube tube4() {
        return new Tube();
    }

    @Bean
    public Tire tire1() {
        return new Tire(tube1());
    }

    @Bean
    public Tire tire2() {
        return new Tire(tube2());
    }

    @Bean
    public Tire tire3() {
        return new Tire(tube3());
    }

    @Bean
    public Tire tire4() {
        return new Tire(tube4());
    }

    @Bean
    public Wheel wheel1() {
        return new Wheel(tire1(), wheelFrame1());
    }

    @Bean
    public Wheel wheel2() {
        return new Wheel(tire2(), wheelFrame2());
    }

    @Bean
    public Wheel wheel3() {
        return new Wheel(tire3(), wheelFrame3());
    }

    @Bean
    public Wheel wheel4() {
        return new Wheel(tire4(), wheelFrame4());
    }

    @Bean
    public WheelFrame wheelFrame1() {
        return new WheelFrame();
    }

    @Bean
    public WheelFrame wheelFrame2() {
        return new WheelFrame();
    }

    @Bean
    public WheelFrame wheelFrame3() {
        return new WheelFrame();
    }

    @Bean
    public WheelFrame wheelFrame4() {
        return new WheelFrame();
    }

}