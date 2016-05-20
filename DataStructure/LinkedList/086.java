public class Solution
{
	public ListNode partition(ListNode head, int x)
	{
		if(head == null)
			return head;

		ListNode dummyNode1 = new ListNode(0);
		dummyNode1.next = head;
		ListNode m = dummyNode1;
		ListNode dummyNode2 = new ListNode(0);
		ListNode n = dummyNode2;
		ListNode p = head;

		while(p != null)
		{
			if(p.val < x)
				m = m.next;
			else
			{
				n.next = p;
				n = n.next;
				m.next = p.next;
			}
			p = p.next;
		}

		m.next = dummyNode2.next;
		n.next = null;

		return dummyNode1.next;
	}
}