public class Solution
{
	public ListNode rotateRight(ListNode head, int k)
	{
		if(head == null || k <= 0)
			return head;

		ListNode p = head;
		int l = 0;

		while(p != null)
		{
			p = p.next;
			l++;
		}

		k %= l;

		ListNode fast = head;
		ListNode slow = head;

		for(int i = 0;i < k;i++)
			fast = fast.next;

		while(fast.next != null)
		{
			fast = fast.next;
			slow = slow.next;
		}

		fast.next = head;
		ListNode t = slow.next;
		slow.next = null;

		return t;
	}
}