/**
 * @Author cheng
 * @Date 2021/4/2
 * 全排列
 */
public class Perm {

    public static void main(String[] args) {
        Perm p = new Perm();
        p.perm(new int[]{1, 2, 3, 4}, 0, 4);
    }

    public void perm(int[] nums, int p, int q) {
        if (p == q) {
            printAll(nums, q);
        } else {
            for (int i = p; i < q; i++) {
                swap(nums, i, p);
                perm(nums, p + 1, q);
                swap(nums, i, p);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private void printAll(int[] nums, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

}
