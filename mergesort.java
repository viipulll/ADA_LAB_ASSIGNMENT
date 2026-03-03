import java.util.Random;
import java.util.Scanner;

class insertionsort {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        System.out.print("Enter number of elements (10/20/30/40): ");
        int n = sc.nextInt();

        int a[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt(100);
        }

        System.out.println("\nUnsorted Array:");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }

        int count = 0;

        for (int i = 1; i < n; i++) {
            int val = a[i];
            int j = i - 1;

            while (j >= 0 && val < a[j]) {
                a[j + 1] = a[j];
                j--;
                count++;
            }
            a[j + 1] = val;
        }

        System.out.println("\n\nSorted Array:");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println("\nStep count: " + count);
    }
}
