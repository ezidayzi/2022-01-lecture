import org.springframework.beans.factory.annotation.Autowired;

public class Team {

    private Owner owner;

    private Supervisor supervisor;

    private Coach coach;

    private Player player1;

    private Player player2;

    private Player player3;

    private String name;

    public Team() {
        System.out.println("팀 객체가 생성되었습니다.");
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getPlayer3() {
        return player3;
    }

    public void setPlayer3(Player player3) {
        this.player3 = player3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void info() {
        System.out.println("\n--------------------");
        System.out.println(name);
        System.out.println(owner.getName());
        System.out.println(supervisor.getName());
        System.out.println(coach.getName());
        System.out.println(player1.getName());
        System.out.println(player2.getName());
    }
}
