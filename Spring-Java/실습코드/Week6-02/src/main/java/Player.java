import org.springframework.beans.factory.annotation.Autowired;

public class Player {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Player() {
        System.out.println("선수 객체가 생성되었습니다.");
    }
}
