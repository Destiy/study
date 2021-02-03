import java.util.Arrays;
import java.util.SortedMap;

/**
 * @author wy
 * @date 2020/11/21
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        ListNode node4 = new ListNode(3);
//        ListNode node3 = new ListNode(1, node4);
//        ListNode node2 = new ListNode(2, node3);
//        ListNode head = new ListNode(4, node2);
//
//        solution.sortList(head);
        int[][] a = {{9,13},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}};
        solution.findMinArrowShots(a);
    }
}

class Solution {
    public ListNode sortList(ListNode head) {
//        return sort(head, null);
        return sort2(head);
    }

    public ListNode sort2(ListNode head) {
        if (head == null) {
            return null;
        }
        int length = 0;
        ListNode tmp = head;
        while (tmp != null) {
            tmp = tmp.next;
            length++;
        }
        ListNode dummyHead = new ListNode(0, head);
        for (int i = 1; i < length; i <<= 1) {
            ListNode prev = dummyHead, curr = dummyHead.next;
            while (curr != null) {
                ListNode node1 = curr;
                for (int j = 1; j < i && curr.next != null; j++) {
                    curr = curr.next;
                }
                ListNode node2 = curr.next;
                curr.next = null;
                curr = node2;
                for (int j = 1; j < i && curr != null && curr.next != null; j++) {
                    curr = curr.next;
                }
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                ListNode merged = merge(node1, node2);
                prev.next = merged;
                while (prev.next != null) {
                    prev = prev.next;
                }
                curr = next;
            }
        }
        return dummyHead.next;
    }

    public ListNode sort(ListNode head, ListNode tail) {
        if (head == null) {
            return null;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode node1 = sort(head, mid);
        ListNode node2 = sort(mid, tail);
        ListNode mergen = merge(node1, node2);
        return mergen;
    }

    public ListNode merge(ListNode node1, ListNode node2) {
        ListNode tmpHeadNode = new ListNode(0);
        ListNode temp = tmpHeadNode, tnode1 = node1, tnode2 = node2;
        while (tnode1 != null && tnode2 != null) {
            if (tnode1.val > tnode2.val) {
                temp.next = tnode2;
                tnode2 = tnode2.next;
            } else {
                temp.next = tnode1;
                tnode1 = tnode1.next;
            }
            temp = temp.next;
        }
        if (tnode1 != null) {
            temp.next = tnode1;
        } else if (tnode2 != null) {
            temp.next = tnode2;
        }
        return tmpHeadNode.next;
    }

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        int result = 0;
        Arrays.sort(points, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        for (int i = 0; i < points.length; i++) {
            int p1 = points[i][0];
            int p2 = points[i][1];
            result++;
            for (int j = i + 1; j < points.length; j++) {
                if (p1 > points[j][0]  || points[j][0] > p2) {
                    break;
                }
                p2 = Math.min(p2, points[j][1]);
                i++;
            }
        }
        return result;
    }


}