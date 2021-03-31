import java.util.Arrays;

/**
 * @Author cheng
 * @Date 2021/3/30
 * 移动数组
 */
public class Move {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        int m = 2;
        Move.move(nums, m);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 2, 3, 4, 5, 6};
        m = 4;
        Move.move(nums, m);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 2, 3, 4, 5, 6};
        m = 3;
        Move.move(nums, m);
        System.out.println(Arrays.toString(nums));
    }

    public static void move(int[] nums, int k) {
        int len = nums.length;
        int m = Math.min(k, len - k);

        if (len % m == 0) {
            int start;
            for (int i = 0; i < m; i++) {
                start = i;
                int nextIndex = (start + k) % len;
                int notMoveVal = nums[i];
                while (nextIndex != start) {
                    int t = nums[nextIndex];
                    nums[nextIndex] = notMoveVal;
                    notMoveVal = t;
                    nextIndex = (nextIndex + k) % len;
                }
                nums[nextIndex] = notMoveVal;
            }
        } else {
            int start = 0;
            int nextIndex = (start + k) % len;
            int notMoveVal = nums[start];

            while (nextIndex != start) {
                int t = nums[nextIndex];
                nums[nextIndex] = notMoveVal;
                notMoveVal = t;
                nextIndex = (nextIndex + k) % len;
            }
        }
    }
}
