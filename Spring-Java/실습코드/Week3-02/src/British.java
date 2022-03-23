public class British implements Human{
    String name = "Dayzi ";

    @Override
    public void wakeUp() {
        System.out.println(name + "일어나는 중");
    }

    @Override
    public void eat() {
        System.out.println(name + "먹는 중");
    }

    @Override
    public void walk() {
        System.out.println(name + "걷는 중");
    }

    @Override
    public void sleep() {
        System.out.println(name + "잠자는 중");
    }

    @Override
    public void introduce() {
        System.out.println("Hello, I'm"+name);
    }

}
