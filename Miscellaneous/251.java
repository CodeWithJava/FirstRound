// Way One
// Single Iterator
public class Vector2D implements Iterator<Integer>
{
	List<Iterator<Integer>> iterators;
	int cur;

	Vector2D(List<List<Integer>> vec2d)
	{
		if(vec2d == null || vec2d.size() == 0)
			return;

		iterators = new ArrayList<>();

		for(List<Integer> x: vec2d)
		{
			if(x.size() > 0)
				iterators.add(x.iterator());
		}
	}

	@Override
	public Integer next()
	{
		Integer result = iterators.get(cur).next();

		if(!iterators.get(cur).hasNext())
			cur++;

		return result;
	}

	@Override
	public boolean hasNext()
	{
		if(iterators == null)
			return false;

		if(cur < iterators.size())
			return iterators.get(cur).hasNext();
		else
			return false;
	}
}

// Way Two
// Two Iterators
public class Vector2D implements Iterator<Integer>
{
	Iterator<List<Integer>> iterator;
	Iterator<Integer> cur;

	Vector2D(List<List<Integer>> vec2d)
	{
		iterator = vec2d.iterator();
	}

	@Override
	public Integer next()
	{
		hasNext();

		return cur.next();
	}

	@Override
	public boolean hasNext()
	{
		while((cur == null || !cur.hasNext()) && iterator.hasNext())
			cur = iterator.next().iterator();

		return cur != null && cur.hasNext();
	}
}