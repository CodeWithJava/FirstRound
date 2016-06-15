public class Solution
{
	public int [] findOrder(int numCourses,int [][] prerequisites)
	{
		if(prerequisites == null)
			throw new IllegalArgumentException("Input is invalid");

		int l = prerequisites.length;

		if(l == 0)
		{
			int [] result = new int [numCourses];
			for(int i = 0;i < numCourses;i++)
				result[i] = i;
			return result;
		}

		int [] inDegree = new int [numCourses];

		for(int i = 0;i < l;i++)
			inDegree[prerequisites[i][0]]++;

		Queue<Integer> q = new LinkedList<>();

		for(int i = 0;i < inDegree.length;i++)
			if(inDegree[i] == 0)
				q.offer(i);

		int numNoPre = q.size();
		int [] result = new int [numCourses];
		int j = 0;

		while(!q.isEmpty())
		{
			int x = q.poll();
			result[j++] = x;

			for(int i = 0;i < l;i++)
				if(prerequisites[i][1] == x)
					if(--inDegree[prerequisites[i][0]] == 0)
					{
						q.offer(prerequisites[i][0]);
						numNoPre++;
					}
		}

		if(numNoPre == numCourses)
			return result;
		else
			return new int [0];
	}
}