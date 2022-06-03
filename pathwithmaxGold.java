//Similar to path with min cost, just some added constraints

import java.util.*;


public class Main {

  private static class Pair {
    String psf;
    int i;
    int j;

    public Pair(String psf, int i, int j) {
      this.psf = psf;
      this.i = i;
      this.j = j;
    }
  }
  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner (System.in);
    int n = scn.nextInt();
    int m = scn.nextInt();

    int[][] arr = new int[n][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        arr[i][j] = scn.nextInt();
      }
    }

    scn.close();

    int[][] dp = new int[arr.length][arr[0].length];

    for (int j = arr[0].length - 1; j >= 0; j--) {
      for (int i = 0; i < arr.length; i++) {
        if (j == arr[0].length - 1) {
          dp[i][j] = arr[i][j];
        } else if (i == 0) {
          dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j + 1]);
        } else if (i == arr.length - 1) {
          dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], dp[i - 1][j + 1]);
        } else {
          dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], Math.max(dp[i - 1][j + 1], dp[i + 1][j + 1]));
        }
      }
    }

    int max = Integer.MIN_VALUE;
    for (int i = 0; i < dp.length; i++) {
      if (dp[i][0] > max) {
        max = dp[i][0];
      }
    }

    System.out.println(max);

    ArrayDeque< Pair> que = new ArrayDeque< >();

    for (int i = 0; i < dp.length; i++) {
      if (dp[i][0] == max) {
        que.add(new Pair(i + " ", i, 0));
      }
    }

    while (que.size() > 0) {
      Pair rem = que.removeFirst();

      if (rem.j == arr[0].length - 1) {
        System.out.println(rem.psf);
      } else if (rem.i == 0) {
        int g = Math.max(dp[rem.i][rem.j + 1], dp[rem.i + 1][rem.j + 1]);


        if (g == dp[rem.i][rem.j + 1]) {
          que.add(new Pair(rem.psf + "d2 ", rem.i, rem.j + 1));
        }

        if (g == dp[rem.i + 1][rem.j + 1]) {
          que.add(new Pair(rem.psf + "d3 ", rem.i + 1, rem.j + 1));
        }
      } else if (rem.i == arr.length - 1) {
        int g = Math.max(dp[rem.i][rem.j + 1], dp[rem.i - 1][rem.j + 1]);


        if (g == dp[rem.i - 1][rem.j + 1]) {
          que.add(new Pair(rem.psf + "d1 ", rem.i - 1, rem.j + 1));
        }

        if (g == dp[rem.i][rem.j + 1]) {
          que.add(new Pair(rem.psf + "d2 ", rem.i, rem.j + 1));
        }
      } else {
        int g = Math.max(dp[rem.i][rem.j + 1], Math.max(dp[rem.i - 1][rem.j + 1], dp[rem.i + 1][rem.j + 1]));

        if (g == dp[rem.i - 1][rem.j + 1]) {
          que.add(new Pair(rem.psf + "d1 ", rem.i - 1, rem.j + 1));
        }

        if (g == dp[rem.i][rem.j + 1]) {
          que.add(new Pair(rem.psf + "d2 ", rem.i, rem.j + 1));
        }

        if (g == dp[rem.i + 1][rem.j + 1]) {
          que.add(new Pair(rem.psf + "d3 ", rem.i + 1, rem.j + 1));
        }
      }


    }
  }

}
