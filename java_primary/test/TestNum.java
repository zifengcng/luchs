import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wbc
 * @date 2025/10/30 15:40
 */
public class TestNum {

    public static void main(String[] args) {
        List<List<Integer>> res = new TestNum().test(new int[]{1, 2, 3});
        System.out.println(res.toString());
    }


    public List<List<Integer>> test(int[] nums) {
        List<Integer> nodes = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        traverse(nums, 0, nums.length, nodes, res, visited);
        return res;
    }

    private void traverse(int[] nums, int index, int len, List<Integer> nodes, List<List<Integer>> res, Set<String> visited) {
        String key = buildKey(nodes);
        if (!visited.contains(key)) {
            res.add(new ArrayList<>(nodes));
            visited.add(key);
        }

        if (index >= len) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            nodes.add(nums[i]);
            traverse(nums, i + 1, len, nodes, res, visited);
            nodes.remove(nodes.size() - 1);
        }

    }

    private String buildKey(List<Integer> nodes) {
        if (nodes.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        nodes.forEach(node -> sb.append(node).append(","));
        return sb.toString();
    }
}
