public class SumOfSubsets {

    int[] set = {5, 11, 12, 13, 16, 18};
    int target = 30;
    int size = set.length;

    void subset(int sum, int index, boolean[] selected) {

        if (sum == target) {
            System.out.print("Subset: ");
            for (int i = 0; i < size; i++) {
                if (selected[i])
                    System.out.print(set[i] + " ");
            }
            System.out.println();
            return;
        }

        if (sum > target || index == size)
            return;

        // Include element
        selected[index] = true;
        subset(sum + set[index], index + 1, selected);

        // Exclude element
        selected[index] = false;
        subset(sum, index + 1, selected);
    }

    public static void main(String[] args) {
        SumOfSubsets obj = new SumOfSubsets();
        boolean selected[] = new boolean[obj.size];

        obj.subset(0, 0, selected); // ✅ fixed
    }
}