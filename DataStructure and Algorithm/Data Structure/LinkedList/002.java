public class Solution
{
	public ListNode addTwoNumbers(ListNode l1, ListNode l2)
	{
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;

		ListNode dummyNode = new ListNode(0);
		ListNode p = dummyNode;

		int carry = 0;
		while(l1 != null || l2 != null)
		{
			int x = l1 != null ? l1.val:0;
			int y = l2 != null ? l2.val:0;

			int digit = x + y + carry;
			carry = digit / 10;

			p.next = new ListNode(digit % 10);
			p = p.next;
			
			if(l1 != null)	l1 = l1.next;
			if(l2 != null)	l2 = l2.next;
		}

		if(carry != 0)
			p.next = new ListNode(carry);

		return dummyNode.next;
	}
}