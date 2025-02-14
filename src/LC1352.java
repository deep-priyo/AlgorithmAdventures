import java.util.ArrayList;

public class LC1352 {
    public static void main(String[] args) {
        ProductOfNumbers productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(3);        // [3]
        productOfNumbers.add(1);        // [3,0]
        productOfNumbers.add(2);        // [3,0,2]
        productOfNumbers.add(5);        // [3,0,2,5]
        productOfNumbers.add(4);        // [3,0,2,5,4]
        System.out.println( productOfNumbers.getProduct(2)); // return 20. The product of the last 2 numbers is 5 * 4 = 20
        System.out.println(productOfNumbers.getProduct(3)); // return 40. The product of the last 3 numbers is 2 * 5 * 4 = 40
        System.out.println(productOfNumbers.getProduct(4)); // return 0. The product of the last 4 numbers is 0 * 2 * 5 * 4 = 0
        productOfNumbers.add(8);        // [3,0,2,5,4,8]
        System.out.println(productOfNumbers.getProduct(5));
        System.out.println(productOfNumbers.getProduct(6));
        System.out.println();
        for (int i = 1; i < 7; i++) {
            System.out.println(productOfNumbers.getProduct(i));
        }// return 32. The product of the last 2 numbers is 4 * 8 = 32
    }
    static class ProductOfNumbers {
        ArrayList<Integer> numbers;
        public ProductOfNumbers() {
            numbers = new ArrayList<>();
        }

//        public void add(int num) {
//            numbers.add(num);
//        }
        public void add(int num) {
            if(num==0) {
                numbers.clear();
                return;
            }
                if(numbers.isEmpty())
                numbers.add(num);
            else
                numbers.add(num * numbers.get(numbers.size() - 1));
        }

//        public int getProduct(int k) {
//            int product = 1;
//            for (int i = 0; i <k; i++)
//            {
//                product *= numbers.get(numbers.size()-1-i);
//            }
//            return product;
//        }
        public int getProduct(int k) {
            if(k>numbers.size())
                return 0;
            if(k==numbers.size())
                return numbers.getLast();
            int product = numbers.getLast()/numbers.get(numbers.size() - k-1);

            return product;
        }
    }
}
