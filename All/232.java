class MyStack
{
	Queue<Integer> q1 = new LinkedList<>();
	Queue<Integer> q2 = new LinkedList<>();
	
	// Push element x onto stack
	public void push(int x)
	{
		if(empty())
			q1.offer(x);
		else
		{
			if(!q1.isEmpty())
			{
				q2.offer(x);
				int size = q1.size();
				while(size > 0)
				{
					q2.offer(q1.poll());
					size--;
				}
			}
			else if(!q2.isEmpty())
			{
				q1.offer(x);
				int size = q2.size();
				while(size > 0)
				{
					q1.offer(q2.poll());
					size--;
				}
			}
		}
	}

	// Removes the element on top of the stack
	public void pop()
	{
		if(q1.isEmpty())
			q2.poll();
		else if(q2.isEmpty())
			q1.poll();
	}

	// Get the top elememt
	public int top()
	{
		if(q1.isEmpty())
			return q2.peek();
		else if(q2.isEmpty())
			return q1.peek();

		throw new IllegalArgumentException("Empty stack");
	}

	// Return whether the stack is empty
	public boolean empty()
	{
		return q1.isEmpty() && q2.isEmpty();
	}
}