import java.util.*;

public class ShannonCircuits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Number of gates
        int N = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        // Store gate definitions
        Map<String, String> gateOperations = new HashMap<>();
        Map<String, List<String>> gateInputs = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String definition = sc.nextLine();
            String[] parts = definition.split("=");
            String gate = parts[0].trim();
            String operation = parts[1].substring(0, parts[1].indexOf('(')).trim();
            String[] inputs = parts[1].substring(parts[1].indexOf('(') + 1, parts[1].indexOf(')')).split(",");
            gateOperations.put(gate, operation);
            gateInputs.put(gate, Arrays.asList(inputs));
        }

        // Number of clock cycles
        int T = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        // Store inputs and outputs
        Map<String, int[]> values = new HashMap<>();
        for (int i = 0; i < T; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            String variable = parts[0];
            int[] cycles = Arrays.stream(parts, 1, parts.length).mapToInt(Integer::parseInt).toArray();
            values.put(variable, cycles);
        }

        // Read the gate whose output is required
        String outputGate = sc.nextLine().trim();

        // Initialize outputs for all gates
        for (String gate : gateOperations.keySet()) {
            values.put(gate, new int[T]);
        }

        // Process each clock cycle
        for (int cycle = 1; cycle < T; cycle++) {
            for (String gate : gateOperations.keySet()) {
                List<String> inputs = gateInputs.get(gate);
                int input1 = values.get(inputs.get(0))[cycle - 1];
                int input2 = values.get(inputs.get(1))[cycle - 1];

                // Apply the gate operation
                String operation = gateOperations.get(gate);
                int result = 0;
                switch (operation) {
                    case "AND":
                        result = input1 & input2;
                        break;
                    case "OR":
                        result = input1 | input2;
                        break;
                    case "NAND":
                        result = ~(input1 & input2) & 1;
                        break;
                    case "NOR":
                        result = ~(input1 | input2) & 1;
                        break;
                    case "XOR":
                        result = input1 ^ input2;
                        break;
                }
                values.get(gate)[cycle] = result;
            }
        }

        // Print the output for the required gate
        System.out.println(Arrays.toString(values.get(outputGate)).replaceAll("[\\[\\],]", ""));
    }
}