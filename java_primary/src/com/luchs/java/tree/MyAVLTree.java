package com.luchs.java.tree;

/**
 * @Author cheng
 * @Date 2020/9/30
 */
public class MyAVLTree<E extends Comparable<E>> {

    private TreeNode root;

    public MyAVLTree() {
        this.root = null;
    }

    public int height() {
        return height(root);
    }

    public int height(TreeNode t) {
        return t == null ? -1 : t.height;
    }

    public void insert(E e) {
        root = insert(e, root);
    }

    public TreeNode insert(E e, TreeNode t) {
        if (t == null) {
            return new TreeNode(e);
        }

        int compareResult = e.compareTo(t.element);
        if (compareResult < 0) {
            // 左子树
            t.left = insert(e, t.left);
            // 比较左子树和右子树的高度
            if (height(t.left) - height(t.right) == 2) {
                // 相差2，打破了平衡
                if (e.compareTo(t.left.element) < 0) {
                    // 插入到了左子树， LL型, 右旋
                    t = rightRotate(t);
                } else {
                    // 插入到了右子树， LR型, 先左旋，再右旋
                    t = leftAndRightRotate(t);
                }
            }
        } else if (compareResult > 0) {
            // 右子树
            t.right = insert(e, t.right);
            // 比较左子树和右子树的高度
            if (height(t.right) - height(t.left) == 2) {
                // 相差2，打破了平衡
                if (e.compareTo(t.right.element) > 0) {
                    // 插入到了右子树， RR型, 左旋
                    t = leftRotate(t);
                } else {
                    // 插入到了左子树， RL型, 先右旋，再左旋
                    t = rightAndLeftRotate(t);
                }
            }
        } else {
            // 已经存在
        }

        // 重新计算 t 的高度
        t.height = Math.max(height(t.left), height(t.right)) + 1;
        return t;
    }

    // 先右旋，再左旋
    private TreeNode rightAndLeftRotate(TreeNode t) {
        t.right = rightRotate(t.right);
        return leftRotate(t);
    }

    // 左旋
    private TreeNode leftRotate(TreeNode t) {
        TreeNode newTree = t.right;
        t.right = newTree.left;
        newTree.left = t;

        t.height = Math.max(height(t.left), height(t.right)) + 1;
        newTree.height = Math.max(height(newTree.left), height(newTree.right)) + 1;

        return newTree;
    }

    // 先左旋，再右旋
    private TreeNode leftAndRightRotate(TreeNode t) {
        t.left = leftRotate(t.left);
        return rightRotate(t);
    }

    // 右旋
    private TreeNode rightRotate(TreeNode t) {
        TreeNode newTree = t.left;
        t.left = newTree.right;
        newTree.right = t;

        t.height = Math.max(height(t.left), height(t.right)) + 1;
        newTree.height = Math.max(height(newTree.left), height(newTree.right)) + 1;

        return newTree;
    }

    public void remove(E e) {
        remove(e, root);
    }

    public TreeNode remove(E x, TreeNode t) {
        if (t == null)
            return null;
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) {
            t.left = remove(x, t.left);
            //完了之后验证该子树是否平衡
            if (t.right != null) {        //若右子树为空，则一定是平衡的，此时左子树相当对父节点深度最多为1, 所以只考虑右子树非空情况
                if (t.left == null) {     //若左子树删除后为空，则需要判断右子树
                    if (height(t.right) - t.height == 2) {
                        TreeNode k = t.right;
                        if (k.right != null) {        //右子树存在，按正常情况单旋转
                            t = leftRotate(t);
                        } else {                      //否则是右左情况，双旋转
                            t = rightAndLeftRotate(t);
                        }
                    }
                }
                if (t.left!=null){                  //否则判断左右子树的高度差
                    //左子树自身也可能不平衡，故先平衡左子树，再考虑整体
                    TreeNode k = t.left;
                    //删除操作默认用右子树上最小节点补删除的节点
                    //k的左子树高度不低于k的右子树
                    if (k.right != null) {
                        if (height(k.left) - height(k.right) == 2) {
                            TreeNode m = k.left;
                            if (m.left != null) {     //左子树存在，按正常情况单旋转
                                k = rightRotate(k);
                            } else {                      //否则是左右情况，双旋转
                                k = leftAndRightRotate(k);
                            }
                        }
                    } else {
                        if (height(k.left) - k.height == 2) {
                            TreeNode m = k.left;
                            if (m.left != null) {     //左子树存在，按正常情况单旋转
                                k = rightRotate(k);
                            } else {                      //否则是左右情况，双旋转
                                k = leftAndRightRotate(k);
                            }
                        }
                    }
                    if (height(t.right) - height(t.left) == 2) {
                        //右子树自身一定是平衡的，左右失衡的话单旋转可以解决问题
                        t = leftRotate(t);
                    }
                }
            }
            //完了之后更新height值
            t.height = Math.max(height(t.left), height(t.right)) + 1;
        } else if (compareResult > 0) {
            t.right = remove(x, t.right);
            //下面验证子树是否平衡
            if (t.left != null) {         //若左子树为空，则一定是平衡的，此时右子树相当对父节点深度最多为1
                t = balanceChild(t);
            }
            //完了之后更新height值
            t.height = Math.max(height(t.left), height(t.right)) + 1;
        } else if (t.left != null && t.right != null) {
            //默认用其右子树的最小数据代替该节点的数据并递归的删除那个节点
            TreeNode min = t.right;
            while (min.left != null) {
                min = min.left;
            }
//            t.element = findMin(t.right).element;
            t.element = min.element;
            t.right = remove(t.element, t.right);
            t = balanceChild(t);
            //完了之后更新height值
            t.height = Math.max(height(t.left), height(t.right)) + 1;
        } else {
            t = (t.left != null) ? t.left : t.right;
        }
        return t;
    }

    private TreeNode balanceChild(TreeNode t) {
        if (t.right == null) {        //若右子树删除后为空，则只需判断左子树与根的高度差
            if (height(t.left) - t.height == 2) {
                TreeNode k = t.left;
                if (k.left != null) {
                    t = rightRotate(t);
                } else {
                    t = leftAndRightRotate(t);
                }
            }
        } else {              //若右子树删除后非空，则判断左右子树的高度差
            //右子树自身也可能不平衡，故先平衡右子树，再考虑整体
            TreeNode k = t.right;
            //删除操作默认用右子树上最小节点（靠左）补删除的节点

            if (k.left != null) {
                if (height(k.right) - height(k.left) == 2) {
                    TreeNode m = k.right;
                    if (m.right != null) {        //右子树存在，按正常情况单旋转
                        k = leftRotate(k);
                    } else {                      //否则是右左情况，双旋转
                        k = rightAndLeftRotate(k);
                    }
                }
            } else {
                if (height(k.right) - k.height == 2) {
                    TreeNode m = k.right;
                    if (m.right != null) {        //右子树存在，按正常情况单旋转
                        k = leftRotate(k);
                    } else {                      //否则是右左情况，双旋转
                        k = rightAndLeftRotate(k);
                    }
                }
            }
            //左子树自身一定是平衡的，左右失衡的话单旋转可以解决问题
            if (height(t.left) - height(t.right) == 2) {
                t = rightRotate(t);
            }
        }
        return t;
    }


    public class TreeNode {
        E element;
        TreeNode left;
        TreeNode right;
        int height;

        public TreeNode() {
        }

        public TreeNode(E element) {
            this.element = element;
        }
    }

    public static void main(String[] args) {
        MyAVLTree<Integer> myAVLTree = new MyAVLTree<>();
        myAVLTree.insert(8);
        myAVLTree.insert(5);
        myAVLTree.insert(1);

        System.out.println(myAVLTree);
    }
}
