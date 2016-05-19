public class Solution
{
	public ListNode getIntersectionNode(ListNode headA, ListNode headB)
	{
		if(headA == null || headB == null)
			return null;

		ListNode p = headA;
		ListNode q = headB;

		int m = 0;
		int n = 0;

		while(p != null)
		{
			p = p.next;
			m++;
		}

		while(q != null)
		{
			q = q.next;
			n++;
		}

		int d = m - n;

		p = headA;
		q = headB;

		if(d > 0)
		{
			for(int i = 0;i < d;i++)
				p = p.next;
		}
		else
		{
			for(int i = d;i < 0;i++)
				q = q.next;
		}

		while(p != null && q != null)
		{
			if(p == q)
				return p;
			p = p.next;
			q = q.next;
		}

		return null;
	}
}