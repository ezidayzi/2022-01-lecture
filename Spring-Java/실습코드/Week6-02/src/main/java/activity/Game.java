package activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Game {
    private String name;

    private Team team1;

    private Team team2;

    private Referee referee1;

    private Referee referee2;

    public Game() {
        System.out.println("경기 객체가 생성되었습니다.");
    }

    public Team getTeam1() {
        return team1;
    }

    @Autowired
    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    @Autowired
    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public Referee getReferee1() {
        return referee1;
    }

    @Autowired
    public void setReferee1(Referee referee1) {
        this.referee1 = referee1;
    }

    public Referee getReferee2() {
        return referee2;
    }

    @Autowired
    public void setReferee2(Referee referee2) {
        this.referee2 = referee2;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
