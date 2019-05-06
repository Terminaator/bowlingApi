package bowling.bowlingMechanic.table;

import bowling.bowlingMechanic.frame.Frame;
import bowling.bowlingMechanic.frame.Frames;
import bowling.bowlingMechanic.player.Player;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
class Information {
    private List<String> result;
    private List<Integer> frameScore;
    private int total;

    Information(int score, List<Integer> frameScore, List<String> result) {
        this.total = score;
        this.frameScore = frameScore;
        this.result = result;
    }

    @Override
    public String toString() {
        return "total: " + total + " frame score: " + frameScore + " result: " + result;
    }
}

@Getter
@Setter
public class Table {
    private Player player;
    private Information information;

    public Table(Player player, Frames value) {
        this.player = player;
        this.information = new Information(value.score(), value.getFrameScore(new ArrayList<>()), createResult(value.getFrames()));
    }

    private List<String> createResult(List<Frame> frames) {
        return frames.stream().map(Frame::toString).collect(Collectors.toList());
    }

    public int getTotal() {
        return information.getTotal();
    }

    public List<Integer> getFrameScore() {
        return information.getFrameScore();
    }

    public List<String> getResult() {
        return information.getResult();
    }
}
