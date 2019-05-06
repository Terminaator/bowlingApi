package bowling.bowlingMechanic.frame;


import bowling.bowlingMechanic.frame.chance.roll.Roll;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Frames {
    @Getter
    private List<Frame> frames = createFrames();

    private static List<Frame> createFrames() {
        List<Frame> frames = new ArrayList<>();
        for (int x = 0; x < 9; x++) frames.add(new Frame());
        frames.add(new Frame(true));
        return frames;
    }

    public boolean addRoll(Roll roll) {
        for (Frame frame : frames) {
            if (!frame.isOver()) return frame.addRoll(roll);
        }
        return false;
    }

    boolean isOver() {
        for (Frame frame : frames) {
            if (!frame.isOver()) return false;
        }
        return true;
    }

    public int score() {
        return getFrameScore(new ArrayList<>()).stream().mapToInt(Integer::intValue).sum();
    }

    public List<Integer> getFrameScore(List<Integer> frameScores) {
        for (int x = 0; x < 10; x++) {
            if (x == 8) {
                frameScores.add(frames.get(x).calculate(frames.get(x + 1)));
            } else if (x == 9) {
                frameScores.add(frames.get(x).getScore());
            } else {
                frameScores.add(frames.get(x).calculate(frames.get(x + 1), frames.get(x + 2)));
            }

        }
        return frameScores;
    }

}
