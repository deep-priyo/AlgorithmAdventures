import java.util.Scanner;

public class SamBrideHunt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        solution(arr, n, m);
    }

    public static void solution(int[][] arr, int n, int m) {
        int maxQuality = Integer.MIN_VALUE;
        int maxI = -1;
        int maxJ = -1;
        int minDistance = Integer.MAX_VALUE;
        boolean polygamy = false;

        // Process each potential bride
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {  // Found a potential bride
                    int qualityOfBride = 0;

                    // Check neighbors for qualities (8-directional check)
                    if (i > 0 && j > 0 && arr[i - 1][j - 1] == 1) qualityOfBride++;
                    if (i > 0 && j < m - 1 && arr[i - 1][j + 1] == 1) qualityOfBride++;
                    if (i < n - 1 && j < m - 1 && arr[i + 1][j + 1] == 1) qualityOfBride++;
                    if (i < n - 1 && j > 0 && arr[i + 1][j - 1] == 1) qualityOfBride++;
                    if (i > 0 && arr[i - 1][j] == 1) qualityOfBride++;
                    if (i < n - 1 && arr[i + 1][j] == 1) qualityOfBride++;
                    if (j > 0 && arr[i][j - 1] == 1) qualityOfBride++;
                    if (j < m - 1 && arr[i][j + 1] == 1) qualityOfBride++;

                    // Update the best bride if the current one is better
                    if (qualityOfBride > maxQuality) {
                        maxI = i;
                        maxJ = j;
                        maxQuality = qualityOfBride;
                        minDistance = Math.abs(i - 0) + Math.abs(j - 0);  // Manhattan distance
                        polygamy = false;  // Reset flag as we found a better candidate
                    }
                    // If qualities are the same, check distance
                    else if (qualityOfBride == maxQuality) {
                        int currentDistance = Math.abs(i - 0) + Math.abs(j - 0);
                        if (currentDistance < minDistance) {
                            maxI = i;
                            maxJ = j;
                            minDistance = currentDistance;
                            polygamy = false;
                        }
                        // If distance is the same, set polygamy flag
                        else if (currentDistance == minDistance) {
                            polygamy = true;
                        }
                    }

                    // Print qualities for each bride
                    System.out.println("The Bride present at (" + (i + 1) + ", " + (j + 1) + ") has " + qualityOfBride + " qualities.");
                }
            }
        }

        // Output the result based on the flags
        if (polygamy) {
            System.out.println("Polygamy not allowed");
        } else if (maxI != -1 && maxJ != -1) {
            System.out.println((maxI + 1) + ":" + (maxJ + 1) + ":" + maxQuality);
        } else {
            System.out.println("No suitable girl found");
        }
    }
}
