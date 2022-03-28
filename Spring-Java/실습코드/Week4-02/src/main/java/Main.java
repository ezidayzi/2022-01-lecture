import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);

        Greeter g1 = ctx.getBean("greeter", Greeter.class);

        Greeter g2 = ctx.getBean("greeter", Greeter.class);

        g1.setGuest("스프링");

        String msg1 = g1.greet();

        String msg2 = g2.greet();

        System.out.println(msg1);


        Introducer i = ctx.getBean("introducer", Introducer.class);
        i.setAge("23");

        i.setName("김윤서");

        String msg3 = i.introduce();

        System.out.println(msg3);

    }
}
