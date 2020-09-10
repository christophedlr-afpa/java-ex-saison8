import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int x = 0;
        int y = 0;
        int move = 0;
        int[][] checkerBoard = new int[8][8];

        System.out.print("Indiquez une ligne où vous positionner : ");
        x = Integer.parseInt(reader.readLine());

        System.out.print("Indiquez une colonne où vous positionner : ");
        y = Integer.parseInt(reader.readLine());

        if ( (x < 0 || x > 7) && (y < 0 || y > 7) ) {
            System.out.println("Position invalide");
        } else {
            while (true) {
                System.out.print("Indiquez le mouvement (0 => haut-gauche, 1 => haut-droite, 2 => bas-gauche, 3 => bas-droite) : ");
                move = Integer.parseInt(reader.readLine());

                /* Validation of move */
                if ( move == 0 && ( (x-1 <= 8 && x-1 >= 0) && (y-1 >= 0 && y-1 <= 8) ) ) {
                    checkerBoard[x][y] = 0;
                    x -= 1;
                    y -= 1;
                    checkerBoard[x][y] = 1;
                } else if ( move == 1 && ( (x-1 <= 8 && x-1 >= 0) && (y+1 <= 8 && y+1 >= 0) ) ) {
                    checkerBoard[x][y] = 0;
                    x -= 1;
                    y += 1;
                    checkerBoard[x][y] = 1;
                }  else if ( move == 2 && ( (x+1 >= 0 && x+1 <= 8) && (y-1 >= 0 && y-1 <= 8) ) ) {
                    checkerBoard[x][y] = 0;
                    x += 1;
                    y -= 1;
                    checkerBoard[x][y] = 1;
                } else if ( move == 3 && ( (x+1 >= 0 && x+1 <= 8) && (y+1 <= 8 && y+1 >= 0) ) ) {
                    checkerBoard[x][y] = 0;
                    x += 1;
                    y += 1;
                    checkerBoard[x][y] = 1;
                } else {
                    System.out.println("Déplacement impossible");
                    break;
                }

                /* Draw checkerboard */
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if (checkerBoard[i][j] == 0) {
                            if (j < 7) {
                                System.out.print("O");
                            } else {
                                System.out.println("O");
                            }
                        } else if (checkerBoard[i][j] == 1) {
                            if (j < 7) {
                                System.out.print("X");
                            } else {
                                System.out.println("X");
                            }
                        }
                    }
                }
            }
        }
    }
}
