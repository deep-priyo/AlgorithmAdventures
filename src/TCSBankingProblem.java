import java.util.Scanner;

public class TCSBankingProblem {
    public static void main(String[] args) {
        System.out.println("Enter principal amount");
        Scanner sc = new Scanner(System.in);
        double principal = sc.nextDouble();
        System.out.println("Enter total tenure in years");
        int totalTenure = sc.nextInt();

        System.out.println("Enter N1");
        int n1 = sc.nextInt();
        double[] n1Interest = new double[n1];
        int[] n1Period = new int[n1];
        for (int i = 0; i < n1; i++) {
            n1Period[i] = sc.nextInt();
            n1Interest[i] = sc.nextDouble();
        }

        System.out.println("Enter N2");
        int n2 = sc.nextInt();
        double[] n2Interest = new double[n2];
        int[] n2Period = new int[n2];
        for (int i = 0; i < n2; i++) {
            n2Period[i] = sc.nextInt();
            n2Interest[i] = sc.nextDouble();
        }

        double n1Total = 0;
        double n2Total = 0;

        System.out.println("For Bank A: ");
        for (int i = 0; i < n1; i++) {
            double monthlyRate = (n1Interest[i] / 100) / 12;
            int months = n1Period[i] * 12;
            double emi = (principal * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -months));
            System.out.printf("EMI for slab %d: %.2f%n", i + 1, emi);
            n1Total += emi * months;
        }
        double interestA = ((n1Total - principal) / principal) * 100;
        System.out.println("\tTotal amount paid: " + n1Total);
        System.out.println("\tInterest for Bank A: " + String.format("%.2f", interestA));

        System.out.println("\nFor Bank B: ");
        for (int i = 0; i < n2; i++) {
            double monthlyRate = (n2Interest[i] / 100) / 12;
            int months = n2Period[i] * 12;
            double emi = (principal * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -months));
            System.out.printf("EMI for slab %d: %.2f%n", i + 1, emi);
            n2Total += emi * months;
        }
        double interestB = ((n2Total - principal) / principal) * 100;
        System.out.println("\tTotal amount paid: " + n2Total);
        System.out.println("\tInterest for Bank B: " + String.format("%.2f", interestB));

        if (interestA > interestB) {
            System.out.println("Bank B is better");
        } else {
            System.out.println("Bank A is better");
        }
    }
}
