package bowling;


import bowling.bowlingMechanic.BowlingMechanic;
import bowling.bowlingMechanic.frame.Frames;
import bowling.bowlingMechanic.frame.chance.roll.Roll;
import bowling.bowlingMechanic.player.Player;
import bowling.bowlingMechanic.table.Table;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class PlayerFrames {
    private Map<Player, Frames> frames = new LinkedHashMap<>();

    boolean add(Player player) {
        Player pl = frames.keySet().stream().filter(x -> x.getId() == player.getId()).findFirst().orElse(null);
        if (pl != null)
            return false;
        else {
            frames.put(player, new Frames());
            return frames.containsKey(player);
        }
    }

    boolean addRoll(Player player, Roll roll) {
        return frames.containsKey(player) && frames.get(player).addRoll(roll);
    }

    List<Table> getTables() {
        return frames.entrySet().stream().map(x -> new Table(x.getKey(), x.getValue())).collect(Collectors.toList());
    }

    Player getPlayer(int id) {
        return frames.keySet().stream().filter(player -> player.getId() == id).findFirst().orElse(null);
    }

    Table getPlayerTable(Player player) {
        return new Table(player, frames.get(player));
    }
}

public class Bowling implements BowlingMechanic {
    private PlayerFrames playerFrames = new PlayerFrames();

    @Override
    public boolean addPlayer(Player player) {
        return playerFrames.add(player);
    }

    @Override
    public boolean addRoll(Player player, Roll roll) {
        return playerFrames.addRoll(player, roll);
    }

    @Override
    public Player getPlayer(int id) {
        return playerFrames.getPlayer(id);
    }

    @Override
    public List<Table> gameStatus() {
        return playerFrames.getTables();
    }

    @Override
    public Table playerStatus(Player player) {
        return playerFrames.getPlayerTable(player);
    }


}
