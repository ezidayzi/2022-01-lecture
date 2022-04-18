package activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sports {

    private Team team1;

    private Team team2;

    private Team team3;

    private Game game;

    private String name;

    public Sports() {
        System.out.println("스포츠 객체가 생성되었습니다.");
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

    public Team getTeam3() {
        return team3;
    }

    @Autowired
    public void setTeam3(Team team3) {
        this.team3 = team3;
    }

    public Game getGame() {
        return game;
    }

    @Autowired
    public void setGame(Game game) {
        this.game = game;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}