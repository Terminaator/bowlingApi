package bowling.bowlingMechanic.player;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Player {
    private int id;
    private String name;

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
