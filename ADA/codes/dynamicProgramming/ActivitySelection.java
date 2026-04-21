import java.util.*;

class Activity {
    int start, finish;

    Activity(int s, int f) {
        start = s;
        finish = f;
    }
}

public class ActivitySelection {

    public static void selectActivities(Activity nums[]) {

        Arrays.sort(nums, (a, b) -> a.finish - b.finish);

        System.out.println("Selected Activities:");

        int lastFinish = nums[1].finish;
        System.out.println("(" + nums[1].start + ", " + nums[1].finish + ")");

        for (int idx = 1; idx < nums.length; idx++) {
            if (nums[idx].start >= lastFinish) {
                System.out.println("(" + nums[idx].start + ", " + nums[idx].finish + ")");
                lastFinish = nums[idx].finish;
            }
        }
    }

    public static void main(String[] args) {

       Activity nums[] = {
    new Activity(3, 6),
    new Activity(2, 4),
    new Activity(5, 6),
    new Activity(7, 9),
    new Activity(6, 10),
    new Activity(8, 11)
};
        selectActivities(nums);
    }
}