package bowling.bowlingMechanic;


import bowling.bowlingMechanic.frame.chance.roll.Roll;
import bowling.bowlingMechanic.player.Player;
import bowling.bowlingMechanic.table.Table;

import java.util.List;


public interface BowlingMechanic {
    boolean addPlayer(Player player);

    boolean addRoll(Player player, Roll roll);

    Player getPlayer(int id);

    List<Table> gameStatus();

    Table playerStatus(Player player);
}
