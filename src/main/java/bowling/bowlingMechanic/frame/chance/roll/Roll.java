package bowling.bowlingMechanic.frame.chance.roll;

import lombok.Getter;

@Getter
public class Roll {
    private int pins = 0;

    public Roll(int pins) {
        if (pins > 10 || pins < 0) pins = 0;
        this.pins = pins;
    }

    @Override
    public String toString() {
        return pins == 10 ? "X" : pins + "";
    }
}
