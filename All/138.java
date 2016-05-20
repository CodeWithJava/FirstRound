public class Solution
{
	public RandomListNode copyRandomList(RandomListNode head)
	{
		if(head == null)
			return head;

		RandomListNode p = head;
		while(p != null)
		{
			RandomListNode clone = new RandomListNode(p.label);
			clone.next = p.next;
			p.next = clone;
			p = clone.next;
		}

		p = head;
		while(p != null)
		{
			if(p.random != null)
				p.next.random = p.random.next;
			p = p.next.next;
		}

		p = head;
		RandomListNode newHead = head.next;
		while(p != null)
		{
			RandomListNode t = p.next;
			p.next = t.next;
			if(t.next != null)
				t.next = t.next.next;
			p = p.next;
		}

		return newHead;
	}
}