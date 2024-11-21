public class LC2257 {
    public static void main(String[] args) {
        int[][] guards = {{0,0},{1,1},{2,3}};
        int[][] walls= {{ 0,1},{2,2},{1,4}};
        System.out.println("\nUnguarded count: "+countUnguarded(4,6,guards,walls));
    }
    public static int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char[][] arr = new char[m][n];

        // Mark guards on the grid
        for (int i = 0; i < guards.length; i++) {
            int x = guards[i][0]; // extract the x co-ordinate
            int y = guards[i][1]; // extract the y co-ordinate
            arr[x][y] = 'G'; // mark as G for guard
        }

        // Mark walls on the grid
        for (int i = 0; i < walls.length; i++) {
            int x = walls[i][0];
            int y = walls[i][1];
            arr[x][y] = 'W'; // marks as W for wall
        }

        // Mark cells guarded by each guard
        for (int i = 0; i < guards.length; i++) {
            int x = guards[i][0];// get the x co-ordinate for guards
            int y = guards[i][1];// get the y co-ordinate for guards

            // Right direction
            for (int j = y + 1; j < n; j++) {
                if (arr[x][j] == 'W' || arr[x][j] == 'G') break; // Stop at walls or guards
                arr[x][j] = 'C'; // Mark cell as guarded
            }

            // Left direction
            for (int j = y - 1; j >= 0; j--) {
                if (arr[x][j] == 'W' || arr[x][j] == 'G') break; // Stop at walls or guards
                arr[x][j] = 'C'; // Mark cell as guarded
            }

            // Down direction
            for (int j = x + 1; j < m; j++) {
                if (arr[j][y] == 'W' || arr[j][y] == 'G') break; // Stop at walls or guards
                arr[j][y] = 'C'; // Mark cell as guarded
            }

            // Up direction
            for (int j = x - 1; j >= 0; j--) {
                if (arr[j][y] == 'W' || arr[j][y] == 'G') break; // Stop at walls or guards
                arr[j][y] = 'C'; // Mark cell as guarded
            }
        }

        // Count unguarded cells
        int unguarded = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == '\0') { // Unoccupied and unguarded
                    unguarded++;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
                            }
            System.out.println();
        }

        return unguarded;
    }
}
