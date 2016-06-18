class PeekingIterator implements Iterator<Integer>
{
	Iterator<Integer> itrs;
	Integer next;

	public PeekingIterator(Iterator<Integer> iterator)
	{
		itrs = iterator;

		if(itrs.hasNext())
			next = itrs.next();
	}

	public Integer peek()
	{
		return next;
	}

	public Integer next()
	{
		int result = next;
		next = itrs.hasNext() ? itrs.next():null;
		return result;
	}

	public boolean hasNext()
	{
		return next != null;
	}
}