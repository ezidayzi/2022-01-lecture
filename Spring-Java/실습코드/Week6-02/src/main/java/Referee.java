import org.springframework.beans.factory.annotation.Autowired;

public class Referee {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Referee() {
        System.out.println("심판 객체가 생성되었습니다.");
    }
}
