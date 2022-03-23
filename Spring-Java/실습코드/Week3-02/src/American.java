public class American implements Human {
    String name = "Dayzi";

    @Override
    public void wakeUp() {
        System.out.println("일어나는 중");
    }

    @Override
    public void eat() {
        System.out.println("먹는 중");
    }

    @Override
    public void walk() {
        System.out.println("걷는 중");
    }

    @Override
    public void sleep() {
        System.out.println("자는 중");
    }

    @Override
    public void introduce() {
        System.out.println("Hello, I'm"+name);
    }
}
