# 1.数组和链表

## 1.1 前缀和

前缀和技巧适⽤于快速、频繁地计算⼀个索引区间内的元素之和。

### 1.1.1 一维数组前缀和

例题：

![image-20251012105724800](/Users/wbc/Library/Application Support/typora-user-images/image-20251012105724800.png)

```java
class NumArray {
    // 前缀和数组
    private int[] preSum;
    /* 输⼊⼀个数组，构造前缀和 */
    public NumArray(int[] nums) {
        // preSum[0] = 0，便于计算累加和
        preSum = new int[nums.length + 1];
        // 计算 nums 的累加和
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
    }

    /* 查询闭区间 [left, right] 的累加和 */
    public int sumRange(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }
}

```

### 1.1.2 二维数组前缀和

例题：

![image-20251012105819952](/Users/wbc/Library/Application Support/typora-user-images/image-20251012105819952.png)

解：

![image-20251012105857342](/Users/wbc/Library/Application Support/typora-user-images/image-20251012105857342.png)

```java
class NumMatrix {
    // 定义：preSum[i][j] 记录 matrix 中⼦矩阵 [0, 0, i-1, j-1] 的元素和
    private int[][] preSum;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        if (m == 0 || n == 0) return;
        // 构造前缀和矩阵
        preSum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 计算每个矩阵 [0, 0, i, j] 的元素和
                preSum[i][j] = preSum[i-1][j] + preSum[i][j-1] + matrix[i
                    - 1][j - 1] - preSum[i-1][j-1];
            }
        }
    }

    // 计算⼦矩阵 [x1, y1, x2, y2] 的元素和
    public int sumRegion(int x1, int y1, int x2, int y2) {
        // ⽬标矩阵之和由四个相邻矩阵运算获得
        return preSum[x2+1][y2+1] - preSum[x1][y2+1] - preSum[x2+1][y1] +
            preSum[x1][y1];
    }
}

```



## 1.2 差分数组

差分数组的主要适⽤场景是频繁对原始数组的某个区间的元素进⾏增减。

![image-20251012110342383](/Users/wbc/Library/Application Support/typora-user-images/image-20251012110342383.png)

```java
// 差分数组⼯具类
class Difference {
    // 差分数组
    private int[] diff;

    /* 输⼊⼀个初始数组，区间操作将在这个数组上进⾏ */
    public Difference(int[] nums) {
        assert nums.length > 0;
        diff = new int[nums.length];
        // 根据初始数组构造差分数组
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }
    /* 给闭区间 [i, j] 增加 val（可以是负数）*/
    public void increment(int i, int j, int val) {
        diff[i] += val;
        if (j + 1 < diff.length) {
            diff[j + 1] -= val;
        }
    }
    /* 返回结果数组 */
    public int[] result() {
        int[] res = new int[diff.length];
        // 根据差分数组构造结果数组
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }
}

```

## 1.3 双指针

1、合并两个有序链表
2、合并 k 个有序链表
3、寻找单链表的倒数第 k 个节点
4、寻找单链表的中点
5、判断单链表是否包含环并找出环起点
6、判断两个单链表是否相交并找出交点

虚拟节点 dummy，避免空指针；

### 1.3.1 合并 k 个有序链表

例题：

![image-20251012114528574](/Users/wbc/Library/Application Support/typora-user-images/image-20251012114528574.png)

解：这⾥我们就要⽤到 优先级队列（⼆叉堆） 这种数据结构，把链表节点放⼊⼀个最⼩堆，就可以每次获得 k 个
节点中的最⼩节点：

```java
    ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        // 虚拟头结点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        // 优先级队列，最⼩堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            lists.length, (a, b) -> (a.val - b.val));
        // 将 k 个链表的头结点加⼊最⼩堆
        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }
        while (!pq.isEmpty()) {
            // 获取最⼩节点，接到结果链表中
            ListNode node = pq.poll();
            p.next = node;
            if (node.next != null) {
                pq.add(node.next);
            }
            // p 指针不断前进
            p = p.next;
        }
        return dummy.next;
    }
```

### 1.3.2 单链表的中点

我们让两个指针 slow 和 fast 分别指向链表头结点 head。
每当慢指针 slow 前进⼀步，快指针 fast 就前进两步，这样，当 fast ⾛到链表末尾时，slow 就指向了链
表中点。
上述思路的代码实现如下：

```java
    ListNode middleNode(ListNode head) {
        // 快慢指针初始化指向 head
        ListNode slow = head, fast = head;
        // 快指针⾛到末尾时停⽌
        while (fast != null && fast.next != null) {
            // 慢指针⾛⼀步，快指针⾛两步
            slow = slow.next;
            fast = fast.next.next;
        }
        // 慢指针指向中点
        return slow;
    }
```

### 1.3.3 判断链表是否包含环

每当慢指针 slow 前进⼀步，快指针 fast 就前进两步。
如果 fast 最终遇到空指针，说明链表中没有环；如果 fast 最终和 slow 相遇，那肯定是 fast 超过了
slow ⼀圈，说明链表中含有环。

```
    boolean hasCycle(ListNode head) {
        // 快慢指针初始化指向 head
        ListNode slow = head, fast = head;
        // 快指针⾛到末尾时停⽌
        while (fast != null && fast.next != null) {
            // 慢指针⾛⼀步，快指针⾛两步
            slow = slow.next;
            fast = fast.next.next;
            // 快慢指针相遇，说明含有环
            if (slow == fast) {
                return true;
            }
        }
        // 不包含环
        return false;
    }
```

这个问题还有进阶版：如果链表中含有环，如何计算这个环的起点？

![image-20251012115326305](/Users/wbc/Library/Application Support/typora-user-images/image-20251012115326305.png)

```
ListNode detectCycle(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        // 上⾯的代码类似 hasCycle 函数
        if (fast == null || fast.next == null) {
            // fast 遇到空指针说明没有环
            return null;
        }
        // 重新指向头结点
        slow = head;
        // 快慢指针同步前进，相交点就是环起点
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
```

### 1.3.4 两个链表是否相交

我们可以让 p1 遍历完链表 A 之后开始遍历链表 B，让 p2 遍历完链表 B 之后开始遍历链表 A，这样相
当于「逻辑上」两条链表接在了⼀起。
如果这样进⾏拼接，就可以让 p1 和 p2 同时进⼊公共部分，也就是同时到达相交节点 c1：

```
ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // p1 指向 A 链表头结点，p2 指向 B 链表头结点
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            // p1 ⾛⼀步，如果⾛到 A 链表末尾，转到 B 链表
            if (p1 == null) p1 = headB;
            else p1 = p1.next;
            // p2 ⾛⼀步，如果⾛到 B 链表末尾，转到 A 链表
            if (p2 == null) p2 = headA;
            else p2 = p2.next;
        }
        return p1;
    }
```

### 1.3.5 最⻓回⽂⼦串

![image-20251012121021518](/Users/wbc/Library/Application Support/typora-user-images/image-20251012121021518.png)

找回⽂串的难点在于，回⽂串的的⻓度可能是奇数也可能是偶数，解决该问题的核⼼是从中⼼向两端扩散的
双指针技巧。

```
    // 在 s 中寻找以 s[l] 和 s[r] 为中⼼的最⻓回⽂串
    String palindrome(String s, int l, int r) {
        // 防⽌索引越界
        while (l >= 0 && r < s.length()
            && s.charAt(l) == s.charAt(r)) {
            // 双指针，向两边展开
            l--; r++;
        }
        // 返回以 s[l] 和 s[r] 为中⼼的最⻓回⽂串
        return s.substring(l + 1, r);
    }
    
```

```
    String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 以 s[i] 为中⼼的最⻓回⽂⼦串
            String s1 = palindrome(s, i, i);
            // 以 s[i] 和 s[i+1] 为中⼼的最⻓回⽂⼦串
            String s2 = palindrome(s, i, i + 1);
            // res = longest(res, s1, s2)
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }
```

## 1.4 滑动窗⼝

```java
## 大致逻辑    
    int left = 0, right = 0;
    while (right < s.size()) {
        // 增⼤窗⼝
        window.add(s[right]);
        right++;

        while (window needs shrink) {
            // 缩⼩窗⼝
            window.remove(s[left]);
            left++;
        }
    }
```

```java
/* 滑动窗⼝算法框架 */
    void slidingWindow(string s, string t) {
        unordered_map<char, int> need, window;
        for (char c : t) need[c]++;

        int left = 0, right = 0;
        int valid = 0;
        while (right < s.size()) {
            // c 是将移⼊窗⼝的字符
            char c = s[right];
            // 增⼤窗⼝
            right++;
            // 进⾏窗⼝内数据的⼀系列更新
 ...
            /*** debug 输出的位置 ***/
            printf("window: [%d, %d)\n", left, right);
            /********************/

            // 判断左侧窗⼝是否要收缩
            while (window needs shrink) {
                // d 是将移出窗⼝的字符
                char d = s[left];
                // 缩⼩窗⼝
                left++;
                // 进⾏窗⼝内数据的⼀系列更新
 ...
            }
        }
    }
```

### 1.4.1 最小覆盖子串

![image-20251012122812217](/Users/wbc/Library/Application Support/typora-user-images/image-20251012122812217.png)

```c++
string minWindow(string s, string t) {
        unordered_map<char, int> need, window;
        for (char c : t) need[c]++;
        int left = 0, right = 0;
        int valid = 0;
        // 记录最⼩覆盖⼦串的起始索引及⻓度
        int start = 0, len = INT_MAX;
        while (right < s.size()) {
            // c 是将移⼊窗⼝的字符
            char c = s[right];
            // 扩⼤窗⼝
            right++;
            // 进⾏窗⼝内数据的⼀系列更新
            if (need.count(c)) {
                window[c]++;
                if (window[c] == need[c])
                    valid++;
            }
            // 判断左侧窗⼝是否要收缩
            while (valid == need.size()) {
                // 在这⾥更新最⼩覆盖⼦串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d 是将移出窗⼝的字符
                char d = s[left];
                // 缩⼩窗⼝
                left++;
                // 进⾏窗⼝内数据的⼀系列更新
                if (need.count(d)) {
                    if (window[d] == need[d])
                        valid--;
                    window[d]--;
                }
            }
        }
        // 返回最⼩覆盖⼦串
        return len == INT_MAX ?
            "" : s.substr(start, len);
    }
```

## 1.5 二分搜索

```
# 框架
int binarySearch(int[] nums, int target) {
       int left = 0, right = ...;
       while(...) {
           int mid = left + (right - left) / 2;
           if (nums[mid] == target) {
...
           } else if (nums[mid] < target) {
               left = ...
           } else if (nums[mid] > target) {
               right = ...
           }
       }
       return ...;
   }
```

```java
# 搜索一个数    
int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // 注意
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1; // 注意
            else if (nums[mid] > target)
                right = mid - 1; // 注意
        }
        return -1;
    }
```

```
# 寻找左侧边界的⼆分搜索
    int left_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length; // 注意

        while (left < right) { // 注意
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid; // 注意
            }
        }
        return left;
    }
```

```
# 寻找右侧边界的⼆分查找
int right_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1; // 注意
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left - 1; // 注意
    }
```

## 1.6 递归反转整个链表

![image-20251012143217047](/Users/wbc/Library/Application Support/typora-user-images/image-20251012143217047.png)

```
ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
```





# 附录

最小生成树算法：kruskal， https://mp.weixin.qq.com/s/dJ9gqR3RVoeGnATlpMG39w

Prim

最短路径算法： Dijkstra

排列组合：

![image-20251019112038126](/Users/wbc/Library/Application Support/typora-user-images/image-20251019112038126.png)