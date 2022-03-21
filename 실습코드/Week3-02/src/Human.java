public interface Human {
    public String mammal = "포유류";
    public void wakeUp();
    public void eat();
    public void walk();
    public void sleep();

    default void introduce() {
        System.out.println("Hello, I’m human");
    }
}
