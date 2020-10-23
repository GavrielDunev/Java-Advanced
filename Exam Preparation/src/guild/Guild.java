package guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {
    private List<Player> roster;
    private String name;
    private int capacity;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (this.roster.size() < this.capacity) {
            this.roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                this.roster.remove(player);
                return true;
            }
        }
        return false;
    }

    public void promotePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                if (!player.getRank().equals("Member")) {
                    player.setRank("Member");
                }
            }
        }
    }

    public void demotePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                if (!player.getRank().equals("Trial")) {
                    player.setRank("Trial");
                }
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz) {
        List<Player> kickedPlayers = new ArrayList<>();
        for (Player player : roster) {
            if (player.getClazz().equals(clazz)) {
                kickedPlayers.add(player);
            }
        }
        Player[] kickedPlayersAsArray = new Player[kickedPlayers.size()];
        int i = 0;
        for (Player kickedPlayer : kickedPlayers) {
            kickedPlayersAsArray[i++] = kickedPlayer;
            this.roster.remove(kickedPlayer);
        }
        return kickedPlayersAsArray;
    }

    public int count() {
        return this.roster.size();
    }

    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append(System.lineSeparator());
        sb.append(String.format("Players in the guild: %s:%n", this.name));
        for (Player player : roster) {
            sb.append(player).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
