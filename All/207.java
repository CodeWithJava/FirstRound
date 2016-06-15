public class Solution
{
	public boolean canFinish(int numCourses, int [][] prerequisites)
	{
		if(prerequisites == null || prerequisites.length == 0)
			return true;

		int l = prerequisites.length;

		int [] inDegree = new int [numCourses];

		for(int i = 0;i < l;i++)
			inDegree[prerequisites[i][0]]++;

		Queue<Integer> q = new LinkedList<>();

		for(int i = 0;i < inDegree.length;i++)
		{
			if(inDegree[i] == 0)
				q.offer(i);
		}

		int numNoPre = q.size();

		while(!q.isEmpty())
		{
			int x = q.poll();

			for(int  i = 0;i < l;i++)
			{
				if(prerequisites[i][1] == x)
				{
					if(--inDegree[prerequisites[i][0]] == 0)
					{
						numNoPre++;
						q.offer(prerequisites[i][0]);
					}
				}
			}
		}

		return numNoPre == numCourses;
	}
}