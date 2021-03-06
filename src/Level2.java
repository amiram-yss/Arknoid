import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Amiram Yassif
 * 314985474
 * ass6
 */
public class Level2 implements LevelInformation {
    private static final int INIT_BALLS_NUM = 3;
    private static final int PADDLE_SPEED = 5;
    private static final int PADDLE_WIDTH = 600;
    private static final String LEVEL_NAME = "Sunshininging";
    private static final int INIT_BLOCKS_NUM = 15;
    private static final int BORDER_WIDTH = 20;
    private static final int SCREEN_WIDTH = 800;
    private static final double BLOCK_WIDTH = (float) (760 / 15);

    /**
     * Number of balls.
     *
     * @return Number of balls.
     */
    @Override
    public int numberOfBalls() {
        return INIT_BALLS_NUM;
    }

    /**
     * The initial velocity of each ball.
     * Note that initialBallVelocities().size() == numberOfBalls()
     *
     * @return List of all velocities.
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> ltr = new ArrayList<>();
        //ltr.add(Velocity.fromAngleAndSpeed(0, BALL_SPEED));
        ltr.add(Velocity.fromAngleAndSpeed(10, 5));
        ltr.add(Velocity.fromAngleAndSpeed(20, 5));
        ltr.add(Velocity.fromAngleAndSpeed(30, 5));
        ltr.add(Velocity.fromAngleAndSpeed(40, 5));
        ltr.add(Velocity.fromAngleAndSpeed(-10, 5));
        ltr.add(Velocity.fromAngleAndSpeed(-20, 5));
        ltr.add(Velocity.fromAngleAndSpeed(-30, 5));
        ltr.add(Velocity.fromAngleAndSpeed(-40, 5));
        return ltr;
    }

    /**
     * @return Paddle speed.
     */
    @Override
    public int paddleSpeed() {
        return PADDLE_SPEED;
    }

    /**
     * @return Paddle width.
     */
    @Override
    public int paddleWidth() {
        return PADDLE_WIDTH;
    }

    /**
     * the level name will be displayed at the top of the screen.
     *
     * @return Level name.
     */
    @Override
    public String levelName() {
        return LEVEL_NAME;
    }

    /**
     * Returns a sprite with the background of the level.
     *
     * @return background sprite.
     */
    @Override
    public Sprite getBackground() {
        return new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                Point ctr = new Point(100, 100);
                d.setColor(Color.ORANGE);
                for (int i = 0; i < 50; i++) {
                    d.drawLine((int) ctr.getX(), (int) ctr.getY(), BORDER_WIDTH + (760 / 50) * i, 180);
                }
                d.fillCircle((int) ctr.getX(), (int) ctr.getY(), 80);
                d.setColor(Color.YELLOW);
                d.fillCircle((int) ctr.getX(), (int) ctr.getY(), 70);
                d.setColor(new Color(253, 223, 24));
                d.fillCircle((int) ctr.getX(), (int) ctr.getY(), 60);
            }

            @Override
            public void timePassed() {

            }
        };
    }

    /**
     * The Blocks that make up this level, each block contains
     * its size, color and location.
     *
     * @return Blocks list.
     */
    @Override
    public List<Block> blocks() {
        Block bta;
        List<Block> ltr = new ArrayList<>();
        for (int i = 1; i <= INIT_BLOCKS_NUM; i++) {
            ltr.add(
                    new Block(
                            new Rectangle(
                                    new Point(
                                            SCREEN_WIDTH - BORDER_WIDTH - (i * BLOCK_WIDTH),
                                            180),
                                    50,
                                    30),
                            blocksColorsArray()[i - 1]
                    ));
        }
        return ltr;
    }

    /**
     * Number of blocks that should be removed
     * before the level is considered to be "cleared".
     * This number should be <= blocks.size();
     *
     * @return Number of blocks that should be removed
     * before the level is considered to be "cleared".
     */
    @Override
    public int numberOfBlocksToRemove() {
        return INIT_BLOCKS_NUM;
    }

    /**
     * Return column colors in the order.
     *
     * @return column colors in the order.
     */
    private Color[] blocksColorsArray() {
        return new Color[]{
                Color.CYAN,
                Color.CYAN,
                Color.PINK,
                Color.PINK,
                Color.BLUE,
                Color.BLUE,
                Color.GREEN,
                Color.GREEN,
                Color.GREEN,
                Color.YELLOW,
                Color.YELLOW,
                Color.ORANGE,
                Color.ORANGE,
                Color.RED,
                Color.RED,
        };
    }

}
