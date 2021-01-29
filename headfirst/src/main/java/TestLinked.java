/**
 * @author wy
 * @date 2021/01/04
 */

class ListNode {
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
}

public class TestLinked {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode t = root;
        for (int i = 2; i <= 8; i++) {
            t.next = new ListNode(i);
            t = t.next;
        }
        TestLinked testLinked = new TestLinked();
        ListNode listNode = testLinked.reverseKGroup(root, 4);

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) { return head; }
        int cnt = 1;

        // 创建一个空节点
        ListNode root = new ListNode(0, head);
        ListNode end = head, begin = root;

        while (end != null && end.next != null) {
            end = end.next;
            if (++cnt == k) {
                begin.next = reverse(begin.next, end, cnt - 2);
                for (int i = 0; i < cnt; i++) {
                    end = end.next;
                    begin = begin.next;
                }
                cnt = 1;
            }
        }
        return root.next;
    }

    public ListNode reverse(ListNode begin, ListNode end, int cnt) {
        ListNode next = begin.next;
        begin.next = end.next;
        end.next = begin;
        while (cnt > 0) {
            ListNode tmp = next.next;
            next.next = begin;
            begin = next;
            end.next = begin;
            next = tmp;
            cnt--;
        }
        return end;
    }
}

