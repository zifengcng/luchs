/**
 * 实现一个函数，完成二叉树的的左右翻转，
 * //二叉树结构示例
 * class TreeNode {  var val: Int  var left: TreeNode?  var right: TreeNode?    init(_ val: Int) {      self.val = val  }}
 *
 * func invertTree(_ root: TreeNode?) -> TreeNode? {}
 *
 * @author wbc
 * @date 2025/10/28 11:51
 */
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = invertTree(root.getLeft());
        TreeNode right = invertTree(root.getRight());

        root.setLeft(right);
        root.setRight(left);
        return root;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }
}


