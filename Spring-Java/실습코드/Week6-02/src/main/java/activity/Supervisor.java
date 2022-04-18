package activity;

public class Supervisor {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Supervisor() {
        System.out.println("감독 객체가 생성되었습니다.");
    }
}
