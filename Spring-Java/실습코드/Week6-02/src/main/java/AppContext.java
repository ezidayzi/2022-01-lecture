import activity.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;


@Configuration
@ComponentScan(basePackages = {"activity"})
public class AppContext {

    @Bean
    @Qualifier("referee1")
    public Referee referee1() {
        Referee referee1 = new Referee();
        referee1.setName("referee1");
        return  referee1;
    }

    @Bean
    @Qualifier("referee2")
    public Referee referee2() {
        Referee referee2 = new Referee();
        referee2.setName("referee2");
        return  referee2;
    }

    @Bean
    @Qualifier("team1")
    public Team team1() {
        return team("team1");
    }

    @Bean
    @Qualifier("team2")
    public Team team2() {
        return team("team2");
    }

    @Bean
    @Qualifier("team3")
    public Team team3() {
        return team("team3");
    }

    public Team team(String teamName) {
        Team team = new Team();

        Owner owner = new Owner();
        owner.setName(teamName+"의 구단주");

        Coach coach = new Coach();
        coach.setName(teamName+"의 코치");

        Supervisor supervisor = new Supervisor();
        supervisor.setName(teamName+"의 감독");

        Player player1 = new Player();
        player1.setName(teamName+"의 player1");

        Player player2 = new Player();
        player2.setName(teamName+"의 player2");

        Player player3 = new Player();
        player3.setName(teamName+"의 player3");

        team.setOwner(owner);
        team.setCoach(coach);
        team.setPlayer1(player1);
        team.setPlayer2(player2);
        team.setPlayer3(player3);
        team.setSupervisor(supervisor);

        team.setName(teamName);
        return team;
    }

}