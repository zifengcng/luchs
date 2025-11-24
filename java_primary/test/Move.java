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

        nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        m = 5;
        Move.move(nums, m);
        System.out.println(Arrays.toString(nums));
    }

    // 循环替换
    public static void move(int[] nums, int k) {
        int len = nums.length;
        k %= len;

        if (k == 0) {
            return;
        }

        int count = gcd(k, len);

        for (int i = 0; i < count; i++) {

            int next = (i + k) % len;
            int t = nums[i];

            while (next != i) {

                int nextVal = nums[next];
                nums[next] = t;
                t = nextVal;

                next = (next + k) % len;
            }
            nums[next] = t;
        }
    }

    public static int gcd(int a, int b) {
        while(b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
