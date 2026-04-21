import java.util.*;

class Product {
    int profit, mass;
    double density;

    Product(int profitVal, int weightVal) {
        profit = profitVal;
        mass = weightVal;
        density = (double) profitVal / weightVal;
    }
}

public class fractionalKnapsack {

    public static void calculateMax(Product[] items, int capacity) {

        Arrays.sort(items, (x, y) -> Double.compare(y.density, x.density));

        double totalProfit = 0.0;

        System.out.println("Selected Items (profit, weight, fraction):");

        for (int i = 0; i < items.length; i++) {

            Product current = items[i];

            if (capacity >= current.mass) {

                totalProfit += current.profit;
                capacity -= current.mass;

                System.out.println(current.profit + ", " + current.mass + ", 1.0");

            } else {

                double fraction = (double) capacity / current.mass;

                totalProfit += current.profit * fraction;

                System.out.println(current.profit + ", " + current.mass + ", " + fraction);

                break;
            }
        }

        System.out.println("Maximum Profit = " + totalProfit);
    }

    public static void main(String[] args) {

        // 🔥 Changed items (different from original)
        Product[] items = {
            new Product(60, 10),
            new Product(100, 20),
            new Product(120, 30),
            new Product(80, 25)
        };

        int capacity = 50;

        calculateMax(items, capacity);
    }
}