public class Solution
{
	public List<String> restoreIpAddresses(String s)
	{
		List<String> result = new ArrayList<>();

		if(s == null || s.length() < 4 || s.length() > 12)
			return result;

		List<List<String>> candidates = new ArrayList<>();
		List<String> t = new ArrayList<>();

		restoreIpAddresses(s,0,t,candidates);

		for(List<String> x: candidates)
		{
			StringBuilder sb = new StringBuilder();

			for(String str: x)
				sb.append(str + ".");

			sb.setLength(sb.length() - 1);

			result.add(sb.toString());
		}

		return result;
	}

	private void restoreIpAddresses(String s, int start, List<String> t, List<List<String>> candidates)
	{
		if(t.size() >= 4 && start != s.length())
			return;

		if(t.size() + s.length() - start < 4)
			return;

		if(t.size() == 4 && start == s.length())
			candidates.add(new ArrayList<>(t));
		else
		{
			for(int i = 1;i <= 3;i++)
			{
				if(start + i > s.length())
					return;

				String sub = s.substring(start,start + i);

				if(i > 1 && sub.charAt(0) == '0')
					return;

				if(Integer.valueOf(sub) > 255)
					return;

				t.add(sub);
				restoreIpAddresses(s,start + i,t,candidates);
				t.remove(t.size() - 1);
			}
		}
	}
}