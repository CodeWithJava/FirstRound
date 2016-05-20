public class Solution
{
	public ListNode insertionSortList(ListNode head)
	{
		if(head == null || head.next == null)
			return;

		ListNode dummyNode = new ListNode(0);

		while(head != null)
		{
			ListNode p = dummyNode;
			while(p.next != null && p.next.val < head.val)
				p = p.next;

			ListNode t = head.next;
			head.next = p.next;
			p.next = head;
			head = t;
		}

		return dummyNode.next;
	}
}