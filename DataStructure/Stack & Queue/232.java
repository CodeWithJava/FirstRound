class MyQueue
{
	Stack<Integer> queue = new Stack<>();
	Stack<Integer> temp = new Stack<>();

	// Push element x to the back of queue.
	public void push(int x)
	{
		if(empty())
			queue.push(x);
		else
		{
			while(!queue.isEmpty())
				temp.push(queue.pop());
			queue.push(x);
		}

		while(!temp.isEmpty())
			queue.push(temp.pop());
	}

	// Removes the element from in front of queue.
	public void pop()
	{
		if(!empty())
			queue.pop();
	}

	// Get the front element.
	public int peek()
	{
		if(!empty())
			return queue.peek();

		throw new IllegalArgumentException("Empty queue");
	}

	// Return whether the queue is empty.
	public boolean empty()
	{
		return queue.isEmpty();
	}
}