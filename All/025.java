public class Solution
{
	public ListNode reverseKGroup(ListNode head, int k)
	{
		if(head == null || k <= 1)
			return head;

		ListNode dummyNode = new ListNode(0);
		dummyNode.next = head;
		ListNode p = dummyNode;

		while(p.next != null)
			p = reverse(p,k);

		return dummyNode.next;
	}

	private ListNode reverse(ListNode node, int k)
	{
		ListNode p = node;

		for(int i = 0;i < k;i++)
		{
			if(p.next == null)
				return p;
			p = p.next;
		}

		ListNode x = node;
		ListNode y = x.next;

		for(int i = 0;i < k;i++)
		{
			ListNode t = y.next;
			y.next = x;
			x = y;
			y = t;
		}

		ListNode t = node.next;
		node.next = x;
		t.next = y;
		return t;
	}
}