public class Solution
{
	public ListNode removeElements(ListNode head, int val)
	{
		if(head == null)
			return head;

		ListNode dummyNode = new ListNode(0);
		dummyNode.next = head;
		ListNode p = dummyNode;
		while(p.next != null)
		{
			if(p.next.val == val)
				p.next = p.next.next;
			else
				p = p.next;
		}

		return dummyNode.next;
	}
}