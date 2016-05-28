public class Solution
{
	public int maxPoints(Point [] points)
	{
		if(points == null || points.length == 0)
			return 0;

		Map<Double,Integer> map = new HashMap<>();
		int max = 0;

		for(int i = 0;i < points.length;i++)
		{
			int duplicate = 1;
			int vertical = 0;

			for(int j = i + 1;j < points.length;j++)
			{
				if(points[i].x == points[j].x)
				{
					if(points[i].y == points[j].y)
						duplicate++;
					else
						vertical++;
				}
				else
				{
					double slope = points[j].y == points[i].y ? 0.0:(1.0 * (points[j].y - points[i].y) / (points[j].x - points[i].x));

					if(map.get(slope) != null)
						map.put(slope,map.get(slope) + 1);
					else
						map.put(slope,1);
				}
			}

			for(int x: map.values())
				if(x + duplicate > max)
					max = x + duplicate;

			max = Math.max(max,vertical + duplicate);

			map.clear();
		}

		return max;
	}
}