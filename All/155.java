public class MinStack
{
	Node head;

	// initialize your data structure here.
	public MinStack()
	{
		head = null;
	}

	public void push(int x)
	{
		if(head == null)
			head = new Node(x);
		else
		{
			Node t = new Node(x);
			t.min = Math.min(x,head.min);
			t.next = head;
			head = t;
		}
	}

	public void pop()
	{
		if(head != null)
        {
            if(head.val != head.min)
                head.next.min = head.min;
			head = head.next;
        }
        else
            throw new IllegalArgumentException("Empty stack");
	}

	public int top()
	{
		if(head != null)
			return head.val;

		throw new IllegalArgumentException("Empty stack");
	}

	public int getMin()
	{
		if(head != null)
			return head.min;

		throw new IllegalArgumentException("Empty stack");
	}
}

class Node
{
	int val;
	int min;
	Node next;
	Node(int x)
	{
		val = x;
		min = x;
		next = null;
	}
}