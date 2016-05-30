// Way One
public class NestedIterator implements Iterator<Integer>
{
	Stack<NestedInteger> stack = new Stack<>();

	public NestedIterator(List<NestedInteger> nestedList)
	{
		if(nestedList == null)
			return;
		else
			for(int i = nestedList.size() - 1;i >= 0;i--)
				stack.push(nestedList.get(i));
	}

	@Override
	public Integer next()
	{
		return stack.pop().getInteger();
	}

	@Override
	public boolean hasNext()
	{
		while(!stack.isEmpty())
		{
			NestedInteger top = stack.peek();

			if(top.isInteger())
				return true;
			else
			{
				stack.pop();
				for(int i = top.getList().size() - 1;i >= 0;i--)
					stack.push(top.getList().get(i));
			}
		}

		return false;
	}
}

// Way Two
public class NestedIterator implements Iterator<Integer>
{
	Stack<Iterator<NestedInteger>> stack = new Stack<>();
	Integer current;

	public NestedIterator(List<NestedInteger> nestedList)
	{
		if(nestedList == null)
			return;
		else
			stack.push(nestedList.iterator());
	}

	@Override
	public Integer next()
	{
		Integer result = current;
		current = null;

		return result;
	}

	@Override
	public boolean hasNext()
	{
		while(!stack.isEmpty() && current == null)
		{
			Iterator<NestedInteger> top = stack.peek();

			if(!top.hasNext())
			{
				stack.pop();
				continue;
			}

			NestedInteger x = top.next();

			if(x.isInteger())
			{
				current = x.getInteger();
				return true;
			}
			else
				stack.push(x.getList().iterator());
		}

		return false;
	}
}