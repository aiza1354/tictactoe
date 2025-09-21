import java.util.Scanner;

public class tictactoe {


    public static void printGrid(String[][] StringArray) {
        for (int row = 0; row < 3; row++) {
            System.out.println(StringArray[row][0] + " " + StringArray[row][1] + " " + StringArray[row][2]);
        }
        System.out.println();
    }


    public static boolean checkWin(String[][] b, String player) {

        for (int i = 0; i < 3; i++) {
            if (b[i][0].equals(player) && b[i][1].equals(player) && b[i][2].equals(player)) return true;
        }

        for (int i = 0; i < 3; i++) {
            if (b[0][i].equals(player) && b[1][i].equals(player) && b[2][i].equals(player)) return true;
        }

        if (b[0][0].equals(player) && b[1][1].equals(player) && b[2][2].equals(player)) return true;
        if (b[0][2].equals(player) && b[1][1].equals(player) && b[2][0].equals(player)) return true;

        return false;
    }


    public static void main(String[] args) {
        String[][] StringArray = {{"_", "_", "_"}, {"_", "_", "_"}, {"_", "_", "_"} , {"_", "_", "_"}};
        Scanner scanner = new Scanner(System.in);


        String currentPlayer = "X";
        boolean gameOn = true;

        printGrid(StringArray);

        while (gameOn) {
            System.out.println("Player " + currentPlayer + ", enter row (0-2) and column (0-2):");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            StringArray[row][col] = currentPlayer;
            printGrid(StringArray);


            if (checkWin(StringArray, currentPlayer)) {
                System.out.println("Player " + currentPlayer + " wins!");
                gameOn = false;
            } else {

                if (currentPlayer.equals("X")) {
                    currentPlayer = "O";
                } else {
                    currentPlayer = "X";
                }

            }
        }

        scanner.close();
    }
}
