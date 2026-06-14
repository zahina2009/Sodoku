import java.util.*;
public class Sudoku{
    public static void main(String[] args){
        int[][] game = new int[9][9];
        ArrayList<Integer> row = generateRow();
        fill(game, row);
        print(game);
    }

    public static ArrayList<Integer> generateRow() {
        ArrayList<Integer> row = new ArrayList<Integer>();
        for (int i = 1; i <= 9; i++) {
            row.add(i);
        }
        for (int i = 0; i < 9; i++) {
            int random = (int)(Math.random() * 9);
            int temp = row.get(i);
            row.set(i, row.get(random));
            row.set(random, temp);
        }
        return row;
    }

    public static void fill(int[][] game, ArrayList<Integer> row) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int a = i * 3;
                int b = i / 3;
                int index = (a+ b + j) %9;
                game[i][j] = row.get(index);
            }
        }
    }

    public static void print(int[][] game) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(game[i][j] + " ");
                if (j % 3 == 2 && j < 8) {
                    System.out.print("| ");
                }
            }
            System.out.println();
            if (i % 3 == 2 && i < 8) {
                System.out.println("---------------------");
            }
        }
    }
}

