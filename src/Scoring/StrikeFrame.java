package Scoring;

/**
 * Created by ian on 5/8/16.
 */
public class StrikeFrame implements Frame { // Next two

    public int total_score, first_bowl, second_bowl = 0;
    public Frame next_frame = null;

    public StrikeFrame(int first_bowl, int second_bowl) {
        this.total_score = first_bowl + second_bowl;
    }

    @Override
    public int getScore(int score) {
        return next_frame.getScore(((next_frame != null) ? (total_score + next_frame.second_bowl + next_frame.first_bowl) : total_score) + score);
    }

}
