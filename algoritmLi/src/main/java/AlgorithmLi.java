import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class AlgorithmLi {

    /**
     * Implement an algorithm.
     * Opening his eyes, the Prince of Persia found himself at the top of the underground Jaffar’s labyrinth.
     * The labyrinth contains H levels, located strictly one above the other. Each level is a rectangular area,
     * divided into m × n areas. In some areas there are pillars. In such areas the Prince can not go.
     * Prince can move from one area to another adjacent free area on the same level. He can also break through
     * the floor to be at a lower level (at the lowest level he can not break through the floor).
     * Any movement of the Prince takes 5 seconds.
     * There is a Princess waiting for the Prince at one of the areas on the lowest level.
     * Your task is to help the Prince to find the Princess as soon as possible.
     * Input format:
     * The first line of INPUT.TXT file contains digits H, M, N - count of levels and rectangle size of each level.
     * Then other lines contain H blocks, each of them describes one level from top to bottom.
     * Each block contains M rows and N columns. Every cell contains: “.”, “o”, “1”, 2”.
     * “.” means that it’s free space.
     * “o” means columns there.
     * “1” Prince position.
     * “2” Princes position.
     * Symbol “1” is always in the first block. Symbol “2” is always in the last block. Nearby blocks are separated by one blank line.
     * <p>
     * Output format:
     * The minimum time the Prince has to find the Princess in seconds.
     * As fairy tales always have happy ends it is guaranteed that the Prince can do it.
     * <p>
     * Examples:
     * <p>
     * Input:
     * 3 3 3
     * 1..
     * oo.
     * ...
     * <p>
     * ooo
     * ..o
     * .oo
     * <p>
     * ooo
     * o..
     * o.2
     * <p>
     * Output:
     * 60
     */

    public void game() {

        Hob d = new Hob();
        Hob d1 = new Hob();
        Queue<Hob> mq = new LinkedList<>();
        int n = 0;
        int m = 0;
        int k = 0;
        int[][][] lab = new int[3][4][4];
        String inputText = "input.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputText))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(inputText))) {

            String[] firstLineElements = reader.readLine().split(" ");
            n = Integer.parseInt(firstLineElements[0]);
            m = Integer.parseInt(firstLineElements[1]);
            k = Integer.parseInt(firstLineElements[2]);

            char item;

            for (int z = 0; z < n; z++) {
                for (int x = 0; x < m; x++) {
                    for (int c = 0; c < k; c++) {
                        item = (char) reader.read();
                        while (item == 13 || item == 10)
                            item = (char) reader.read();

                        if (item == '1') {
                            lab[z][x][c] = -1;
                            d.n = z;
                            d.m = x;
                            d.k = c;
                            d.step = 1;
                            mq.offer(d);
                        }
                        if (item == 'o')
                            lab[z][x][c] = -2;
                        if (item == '.')
                            lab[z][x][c] = 0;
                        if (item == '2')
                            lab[z][x][c] = -3;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean ch = false;

        do {

            try {
                d = mq.poll();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            if (d.n < n - 1 && lab[d.n + 1][d.m][d.k] == 0) {
                lab[d.n + 1][d.m][d.k] = d.step;
                d1.n = d.n + 1;
                d1.m = d.m;
                d1.k = d.k;
                d1.step = d.step + 1;
                mq.offer(d1);
            } else if (d.n < n - 1 && lab[d.n + 1][d.m][d.k] == -3) {
                ch = true;
                break;
            }

            if (d.m > 0 && lab[d.n][d.m - 1][d.k] == 0) {
                lab[d.n][d.m - 1][d.k] = d.step;
                d1.n = d.n;
                d1.m = d.m - 1;
                d1.k = d.k;
                d1.step = d.step + 1;
                mq.offer(d1);
            } else if (d.m > 0 && lab[d.n][d.m - 1][d.k] == -3) {
                ch = true;
                break;
            }

            if (d.m < m - 1 && lab[d.n][d.m + 1][d.k] == 0) {
                lab[d.n][d.m + 1][d.k] = d.step;
                d1.n = d.n;
                d1.m = d.m + 1;
                d1.k = d.k;
                d1.step = d.step + 1;
                mq.offer(d1);
            } else if (d.m < m - 1 && lab[d.n][d.m + 1][d.k] == -3) {
                ch = true;
                break;
            }

            if (d.k > 0 && lab[d.n][d.m][d.k - 1] == 0) {
                lab[d.n][d.m][d.k - 1] = d.step;
                d1.n = d.n;
                d1.m = d.m;
                d1.k = d.k - 1;
                d1.step = d.step + 1;
                mq.offer(d1);
            } else if (d.k > 0 && lab[d.n][d.m][d.k - 1] == -3) {
                ch = true;
                break;
            }

            if (d.k < k - 1 && lab[d.n][d.m][d.k + 1] == 0) {
                lab[d.n][d.m][d.k + 1] = d.step;
                d1.n = d.n;
                d1.m = d.m;
                d1.k = d.k + 1;
                d1.step = d.step + 1;
                mq.offer(d1);
            } else if (d.k < k - 1 && lab[d.n][d.m][d.k + 1] == -3) {
                ch = true;
                break;
            }
        } while (!ch);

        System.out.println(5 * d.step);
    }
}

class Hob {

    public int n;
    public int m;
    public int k;
    public int step;
}