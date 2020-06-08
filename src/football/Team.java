package football;

import java.util.ArrayList;
import java.util.List;
/**
 * The Team class implements an application that creates team for the player, and modify it.
 */
public class Team {
    User teamLeader;
    List<User> players = new ArrayList<>();
    /**
     * This is parameterize constructor for this class to set team leader.
     * Creates team with its leader.
     * @param teamLeader This is the leader of team, who create the team.
     */
    public Team(User teamLeader) {
        this.teamLeader = teamLeader;
    }
    /**
     * This method gets the team leader.
     * @return User This returns team leader which created team.
     */
    public User getTeamLeader() {
        return teamLeader;
    }
    /**
     * This method gets players of team.
     * @return List<User> This returns team players.
     */
    public List<User> getPlayers() {
        return players;
    }
    /**
     * This method adds a player to the team.
     * @param player This is the player which will be added to team.
     */
    public void addPlayer(User player){
        players.add(player);
    }
    /**
     * This method removes a player from the team.
     * @param player This is the player which will be removed from team.
     */
    public void removePlayer(User player){
        players.remove(player);
    }
    /**
     * This method shows team information.
     * @return String This returns the string representation of the team information.
     */
    @Override
    public String toString(){
        StringBuilder teamInfo = new StringBuilder(
                "Team leader's name: " + this.teamLeader.getName() + '\n' +
                "Team members are: " + '\n');
        for(User player : this.players)
            teamInfo.append("player name: ").append(player.getName()).append("   player username: ").append(player.getUsername()).append('\n');
        return teamInfo.toString();
    }
}