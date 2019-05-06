package bowling.bowlingMechanic.frame;

import bowling.bowlingMechanic.frame.chance.Chance;
import bowling.bowlingMechanic.frame.chance.roll.Roll;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Frame {
    private boolean finalFrame = false, over = false;

    private List<Chance> chances = new ArrayList<>();

    Frame() {

    }

    Frame(boolean finalFrame) {
        this.finalFrame = finalFrame;
    }

    boolean addRoll(Roll roll) {
        if (over) return false;
        else {
            if (!finalFrame) {
                if (chances.size() == 1 && roll.getPins() + chances.get(0).getRoll().getPins() > 10) return false;
                else if (chances.size() == 0 && roll.getPins() == 10 || chances.size() == 1) {
                    over = true;
                }
                chances.add(new Chance(roll));
                return true;

            } else {
                if ((chances.size() == 1 && roll.getPins() + chances.get(0).getRoll().getPins() < 10)
                        || chances.size() == 2) {
                    over = true;
                }
                chances.add(new Chance(roll));
                return true;
            }
        }
    }


    int type() {
        if (chances.size() == 0)
            return -1;
        if (chances.get(0).getRoll().getPins() == 10)
            return 0;
        else if (chances.size() >= 2 && chances.get(0).getRoll().getPins() + chances.get(1).getRoll().getPins() == 10)
            return 1;
        else if (chances.size() >= 2 && chances.get(0).getRoll().getPins() + chances.get(1).getRoll().getPins() < 10)
            return 2;
        return 3;

    }

    int getScore() {
        return chances.stream().mapToInt(x -> x.getRoll().getPins()).sum();
    }

    int calculate(Frame frame, Frame frame1) {
        if (type() == 0 && frame.type() == 0 && frame1.type() == 0)
            return 30;
        else if (type() == 0 && frame.type() == 0)
            return 20 + frame1.getOne();
        else if (type() == 0)
            return 10 + frame.getScore();
        else if (type() == 1)
            return 10 + frame.getOne();
        else if (type() == 2)
            return getScore();
        else if (type() == 3)
            return getScore();
        return 0;
    }

    int calculate(Frame frame) {
        if (type() == 0)
            return 10 + frame.getTwo();
        else if (type() == 1)
            return 10 + frame.getOne();
        return getScore();
    }

    int getTwo() {
        if (chances.size() == 0) return 0;
        else if (chances.size() == 1) return chances.get(0).getRoll().getPins();
        return chances.get(0).getRoll().getPins() + chances.get(1).getRoll().getPins();
    }

    int getOne() {
        if (chances.size() == 0) return 0;
        else return chances.get(0).getRoll().getPins();
    }

    private String getString() {
        if (chances.get(1).getRoll().getPins() + chances.get(2).getRoll().getPins() == 10)
            return " " + chances.get(1).getRoll().getPins() + " /";
        else
            return " " + chances.get(1).getRoll().toString() + " " + chances.get(2).getRoll().toString();
    }

    @Override
    public String toString() {
        switch (type()) {
            case 0:
                return "X" + (chances.size() == 3 ? getString() : "");
            case 1:
                return chances.get(0).getRoll().getPins() + " /" + (chances.size() == 3 ? " " + chances.get(2).getRoll().toString() : "");
            case 2:
                return chances.get(0).getRoll().getPins() + " " + chances.get(1).getRoll().getPins();
            case 3:
                return chances.get(0).getRoll().getPins() + " ";
            default:
                return " ";
        }
    }
}
