public class Solution
{
    public ListNode sortList(ListNode head)
    {
        if(head == null || head.next == null)
            return head;

        int length = 0;
        ListNode p = head;
        while(p != null)
        {
            length++;
            p = p.next;
        }

        int halfLength = length / 2;

        ListNode l = head;
        ListNode r = null;
        p = head;

        int half = 0;
        while(p != null)
        {
            half++;
            ListNode next = p.next;
            if(half == halfLength)
            {
                p.next = null;
                r = next;
            }
            p = next;
        }

        ListNode h1 = sortList(l);
        ListNode h2 = sortList(r);
        ListNode merged = merge(h1,h2);
        return merged;
    }

    private ListNode merge(ListNode l1,ListNode l2)
    {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;

        ListNode dummyNode = new ListNode(0);
        ListNode p = dummyNode;
        
        while(l1 != null && l2 != null)
        {
            if(l1.val < l2.val)
            {
                p.next = l1;
                l1 = l1.next;
            }
            else
            {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if(l1 != null)  p.next = l1;
        if(l2 != null)  p.next = l2;

        return dummyNode.next;
    }
}