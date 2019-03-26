package bag_and_balls;

import java.util.List;

class BallValidator {
    private final int MAX_BALL_LIMIT = 12;
    private final int MAX_GREEN_BALL_LIMIT = 3;


    boolean canBeAdded(Ball ball, List<Ball> balls) {
        if (balls.size() >= MAX_BALL_LIMIT) return false;
        if (ball.equals(Ball.GREEN)) return getBallCountInList(ball,balls) < MAX_GREEN_BALL_LIMIT;
        return true;
    }

    private int getBallCountInList(Ball ball, List<Ball> balls) {
        int ballCount = 0;
        for (Ball currentBall : balls) {
            if(ball.equals(currentBall)) ballCount += 1;
        }
        return ballCount;
    }
}
