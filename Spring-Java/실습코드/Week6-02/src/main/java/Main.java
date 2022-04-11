import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
        Sports aSports = ctx.getBean(Sports.class);
        System.out.println(aSports.getName());
        System.out.println(aSports.getTeam1().getName());
        System.out.println(aSports.getTeam2().getName());
        System.out.println(aSports.getTeam3().getName());
        System.out.println(aSports.getGame().getName());

        aSports.getTeam1().info();
        aSports.getTeam2().info();
        aSports.getTeam3().info();

    }
}
