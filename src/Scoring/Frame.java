package Scoring;

/**
 * Created by ian on 5/8/16.
 */
public interface Frame { // Singular value

    public int first_bowl = 0;
    public int second_bowl = 0;
    public int total_score = first_bowl + second_bowl;
    public Frame next_Frame = null;

    public int getScore(int score);

}
