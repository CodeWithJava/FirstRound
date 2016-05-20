public class Solution
{
	public ListNode reverseList(ListNode head)
	{
		if(head == null || head.next == null)
			return head;

		ListNode p = head;
		ListNode q = p.next;

		while(p != null && q != null)
		{
			ListNode t = q.next;
			q.next = p;
			p = q;

			if(t != null)
				q = t;
			else
				break;
		}

		head.next = null;

		return p;
	}
}