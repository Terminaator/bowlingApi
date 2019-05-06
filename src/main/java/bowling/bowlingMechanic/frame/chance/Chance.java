package bowling.bowlingMechanic.frame.chance;

import bowling.bowlingMechanic.frame.chance.roll.Roll;
import lombok.Getter;

@Getter
public class Chance {
    private Roll roll;

    public Chance(Roll roll) {
        this.roll = roll;
    }

}
