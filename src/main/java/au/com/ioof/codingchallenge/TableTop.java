package au.com.ioof.codingchallenge;

public class TableTop {
    private static final int WIDTH = 5;
    private static final int HEIGHT = 5;
    public final int x;
    public final int y;
    public final Direction direction;

    public TableTop() {
        this(0, 0, Direction.EAST);
    }

    public TableTop(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public boolean isValid() {
        return x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT;
    }
}
