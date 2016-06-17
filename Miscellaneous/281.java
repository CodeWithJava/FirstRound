public class ZigzagIterator
{
	List<Iterator<Integer>> itrs = new ArrayList<>();
	int pos = 0;

	public ZigzagIterator(List<Integer> v1,List<Integer> v2)
	{
		if(v1.size() != 0)
			itrs.add(v1.iterator());
		if(v2.size() != 0)
			itrs.add(v2.iterator());
	}

	public int next()
	{
		if(!hasNext())
			return -1;

		pos %= itrs.size();
		Iterator<Integer> cur = itrs.get(pos);

		int result = cur.next();

		if(!cur.hasNext())
		{
			itrs.remove(pos);
			pos--;
		}

		pos++;

		return result;
	}

	public boolean hasNext()
	{
		return itrs.size() > 0;
	}
}