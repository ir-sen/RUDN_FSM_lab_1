package lab1_2;

import java.util.Iterator;


class Tiger {

    static private int state = 3;
    static private String status = "searchForPrey";

    final private String searchForPreyState = "searchForPrey";
    final private String goHome = "goHome";
    final private String attackState = "attack";
    final private String runAway = "runAway";
    final private String hontDownPrey = "finish";


}

public class TwoDIteratorTest {

    // An ubiquitous Point class
    static class Point {
        final int x;
        final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "{" + x + "," + y + "}";
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    // All possible directions.
    enum Direction {
        Right(0, 1),
        DownRight(1, 1),
        Down(1, 0),
        DownLeft(1, -1),
        Left(0, -1),
        UpLeft(-1, -1),
        Up(-1, 0),
        UpRight(-1, 1);
        private final int dx;
        private final int dy;

        Direction(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }

        // Step that way
        public Point step(Point p) {
            return new Point(p.x + dx, p.y + dy);
        }
    }

    static class TwoDIterator implements Iterable<Point> {
        // Where we are now
        Point i;
        // Direction to move in.
        private final Direction step;
        // Limits.
        private final Point min;
        private final Point max;
        // Next position to go to.
        Point next = null;

        // Normal constructor.
        public TwoDIterator(Point start, Direction step, Point min, Point max) {
            i = next = start;
            this.step = step;
            this.min = min;
            this.max = max;
        }

        // Some simplified constructors
        public TwoDIterator(int x, int y, Direction step, Point min, Point max) {
            this(new Point(x, y), step, min, max);
        }

        public TwoDIterator(int x, int y, Direction step, int minx, int miny, int maxx, int maxy) {
            this(new Point(x, y), step, new Point(minx, miny), new Point(maxx, maxy));
        }

        // The iterator.
        @Override
        public Iterator<Point> iterator() {
            return new Iterator<Point>() {
                // hasNext calculates next if necessary and checks it against the stabliched limits.
                @Override
                public boolean hasNext() {
                    if (next == null) {
                        // Step one.
                        next = step.step(i);
                        // Stop at limits.
                        if (next.x < min.x
                                || next.x > max.x
                                || next.y < min.y || next.y > max.y) {
                            next = null;
                        }
                    }
                    return next != null;
                }

                @Override
                public Point next() {
                    if (hasNext()) {
                        // Make our move.
                        i = next;
                        next = null;
                        return i;
                    }
                    return null;
                }

                @Override
                public void remove() {
                    throw new UnsupportedOperationException("Not supported.");
                }
            };
        }
    }

    public void test() {
        // Test all directions.
        for (Direction d : Direction.values()) {
            System.out.print(d + " - ");
            for (Point p : new TwoDIterator(0, 0, d, -5, -5, 5, 5)) {
                System.out.print(p + ",");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //new TwoDIteratorTest().test();
        int[][] matrix = {
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
        };

        final int minX = 0;
        final int minY = 0;
        final int maxX = matrix.length-1;
        final int maxY = matrix[0].length-1;


        for (Direction d : Direction.values()) {
            System.out.print(d + " - ");
            for(Point p : new TwoDIterator(1, 4, d, minX, minY, maxX, maxY)) {
                System.out.print(p + "   ");
                System.out.print( "X= " +p.x +" Y= " + p.y );
                System.out.print("   ");

            };
            System.out.println();
        }



    }
}