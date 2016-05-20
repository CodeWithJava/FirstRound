/*

339. Nested List Weight Sum

Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list whose elements may also be integers or other lists.

Example:

Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)

*/

public class Solution
{
	public int depthSum(List<NestedInteger> nestedList)
	{
		return depthSum(nestedList,1);
	}

	private int depthSum(List<NestedInteger> nestedList, int depth)
	{
		if(nestedList == null || nestedList.size() == 0)
			return 0;

		int sum = 0;

		for(NestedInteger ni: nestedList)
		{
			if(ni,isInteger())
				sum += ni.getInteger() * depth;
			else
				sum += depthSum(ni.getList(), depth+1);
		}

		return sum;
	}
}