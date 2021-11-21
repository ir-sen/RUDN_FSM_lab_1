package Task;

import java.util.Random;

public class Task1 {


    static class Tiger{

        static private int state = 3;
        static private String status = "SearchForPrey";
        private int[][] matrix1;

        static int lineLength = 0;
        static int columnLength = 0;

        Random random = new Random();
        // start position
        Tiger(int[][] xMatrix) {
            matrix1 = xMatrix;
            //matrix1[0][0] = state;
            columnLength = xMatrix[0].length;
            lineLength = xMatrix.length;
        }

        void runAway() {
            for (int i = 0; i < matrix1.length; i++) {
                for(int j = 0; j < matrix1[i].length; j++) {

                }
            }
        }


        void moveRight() {
            try {
                for (int i = 0; i < matrix1.length; i++) {
                    for (int j = 0; j < matrix1[i].length; j++) {
                        if (matrix1[i][j] == state && matrix1[i][j + 1] == 0) {
                            matrix1[i][j] = matrix1[i][j+1];
                            matrix1[i][j+1] = state;
                            return;
                        }
                    }
                }
            } catch (Exception e) {
                return;
            }
        }

        void moveLeft() {
            try {
                for (int i = 0; i < matrix1.length; i++) {
                    for (int j = 0; j < matrix1[i].length; j++) {
                        if (matrix1[i][j] == state && matrix1[i][j - 1] == 0) {
                            matrix1[i][j] = matrix1[i][j - 1];
                            matrix1[i][j - 1] = state;
                            return;
                        }
                    }
                }
            } catch (Exception e) {
                return;
            }
        }

        void moveUp() {
            try {
                for (int i = 0; i < matrix1.length; i++) {
                    for (int j = 0; j < matrix1[i].length; j++) {
                        if (matrix1[i][j] == state && matrix1[i-1][j] == 0) {
                            matrix1[i][j] = matrix1[i-1][j];
                            matrix1[i-1][j] = state;
                            return;
                        }
                    }
                }
            } catch (Exception e) {
                return;
            }
        }

        void moveDown() {
            try {
                for (int i = 0; i < matrix1.length; i++) {
                    for (int j = 0; j < matrix1[i].length; j++) {
                        if (matrix1[i][j] == state && matrix1[i+1][j] == 0) {
                            matrix1[i][j] = matrix1[i+1][j];
                            matrix1[i+1][j] = state;
                            return;
                        }
                    }
                }
            } catch (Exception e) {
                return;
            }
        }

        void moveUpLeft() {
            try {
                for (int i = 0; i < matrix1.length; i++) {
                    for (int j = 0; j < matrix1[i].length; j++) {
                        if (matrix1[i][j] == state && matrix1[i-1][j-1] == 0) {
                            matrix1[i][j] = matrix1[i-1][j-1];
                            matrix1[i-1][j-1] = state;
                            return;
                        }
                    }
                }
            } catch (Exception e) {
                return;
            }
        }

        void moveUpRight() {
            try {
                for (int i = 0; i < matrix1.length; i++) {
                    for (int j = 0; j < matrix1[i].length; j++) {
                        if (matrix1[i][j] == state && matrix1[i-1][j+1] == 0) {
                            matrix1[i][j] = matrix1[i-1][j+1];
                            matrix1[i-1][j+1] = state;
                            return;
                        }
                    }
                }
            } catch (Exception e) {
                return;
            }
        }

        void moveDownRight() {
            try {
                for (int i = 0; i < matrix1.length; i++) {
                    for (int j = 0; j < matrix1[i].length; j++) {
                        if (matrix1[i][j] == state && matrix1[i+1][j+1] == 0) {
                            matrix1[i][j] = matrix1[i+1][j+1];
                            matrix1[i+1][j+1] = state;
                            return;
                        }
                    }
                }
            } catch (Exception e) {
                return;
            }
        }

        void moveDownLeft() {
            try {
                for (int i = 0; i < matrix1.length; i++) {
                    for (int j = 0; j < matrix1[i].length; j++) {
                        if (matrix1[i][j] == state && matrix1[i+1][j-1] == 0) {
                            matrix1[i][j] = matrix1[i+1][j-1];
                            matrix1[i+1][j-1] = state;
                            return;
                        }
                    }
                }
            } catch (Exception e) {
                return;
            }
        }

        void randomMove() {
            int move = random.nextInt(8);
            switch (move) {
                case 1:
                    moveRight();
                    break;
                case 2:
                    moveLeft();
                    break;
                case 3:
                    moveUp();
                    break;
                case 4:
                    moveDown();
                    break;
                case 5:
                    moveUpRight();
                    break;
                case 6:
                    moveUpLeft();
                    break;
                case 7:
                    moveDownRight();
                    break;
                case 8:
                    moveDownLeft();
                    break;
            }


        }


        int[][] stateInMatrix(){
            return matrix1;
        }
    }

    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.print("\n");
        }
        System.out.println("___________________________");

    }



    public static void main(String[] args) {
        int[][] arrMatrix = {
                {0,0,0,0,0,0},
                {0,0,3,0,0,0},
                {0,0,0,0,0,0},
        };

        System.out.println(arrMatrix[1+1][2-1]);

        Tiger tiger1 = new Tiger(arrMatrix);
//        System.out.println(arrMatrix[0][1]);
        for(int i = 0; i < 100; i++) {
            printMatrix(tiger1.stateInMatrix());
            tiger1.randomMove();
            printMatrix(tiger1.stateInMatrix());
        }




//        tiger1.moveLeft();
//        printMatrix(tiger1.stateInMatrix());
//

//        System.out.println(arrMatrix[0].length);
//        System.out.println(arrMatrix.length);

    }
}
