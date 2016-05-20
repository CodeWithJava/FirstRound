public class Solution
{
	public ListNode swapPairs(ListNode head)
	{
		if(head == null || head.next == null)
			return head;

		ListNode dummyNode = new ListNode(0);
		dummyNode.next = head;
		ListNode p = dummyNode;

		while(p.next != null && p.next.next != null)
		{
			ListNode t1 = p;
			p = p.next;
			t1.next = p.next;
			ListNode t2 = p.next.next;
			p.next.next = p;
			p.next = t2;
		}

		return dummyNode.next;
	}
}