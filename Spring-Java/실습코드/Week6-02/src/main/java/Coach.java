import org.springframework.beans.factory.annotation.Autowired;

public class Coach {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Coach() {
        System.out.println("코치 객체가 생성되었습니다.");
    }
}
