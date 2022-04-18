package activity;

import org.springframework.beans.factory.annotation.Autowired;

public class Owner {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Owner() {
        System.out.println("구단주 객체가 생성되었습니다.");
    }
}
