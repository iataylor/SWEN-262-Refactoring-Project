package Scoring;

/**
 * Created by ian on 5/8/16.
 */
public class NormalFrame implements Frame {

    public int total_score, first_bowl, second_bowl = 0;
    public Frame next_frame = null;

    public NormalFrame(int first_bowl, int second_bowl) {
        this.total_score = first_bowl + second_bowl;
    }

    @Override
    public int getScore(int score) {
        return next_frame.getScore(total_score + score);

    }

}
