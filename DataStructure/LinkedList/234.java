public class Solution
{
	public boolean isPalindrome(ListNode head)
	{
		if(head == null || head.next == null)
			return true;

		ListNode fast = head;
		ListNode slow = head;

		while(fast.next != null && fast.next.next != null)
		{
			fast = fast.next.next;
			slow = slow.next;
		}

		ListNode second = slow.next;
		slow.next = null;

		second = reverse(second);

		while(second != null)
		{
			if(head.val != second.val)
				return false;
			head = head.next;
			second = second.next;
		}

		return true;
	}

	private ListNode reverse(ListNode head)
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