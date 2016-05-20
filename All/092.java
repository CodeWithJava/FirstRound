public class Solution
{
	public ListNode reverseBetween(ListNode head, int m, int n)
	{
		if(head == null || m > n )
			return head;

		ListNode dummyNode = new ListNode(0);
		dummyNode.next = head;
		ListNode p = dummyNode;

		for(int i = 0;i < m - 1;i++)
			p = p.next;

		ListNode x = p.next;
		ListNode y = x.next;

		for(int i = 0;i < n - m;i++)
		{
			ListNode t = y.next;
			y.next = x;
			x = y;
			y = t;
		}

		ListNode t = p.next;
		p.next = x;
		t.next = y;

		return dummyNode.next;
	}
}