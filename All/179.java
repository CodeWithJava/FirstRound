public class Solution
{
	public String largestNumber(int [] nums)
	{
		if(nums == null || nums.length == 0)
			return "";

		String [] strs = new String [nums.length];

		for(int i = 0;i < nums.length;i++)
			strs[i] = String.valueOf(nums[i]);

		Arrays.sort(strs,new StringComparator());

		StringBuilder sb = new StringBuilder();

		for(String str: strs)
			sb.append(str);

		while(sb.charAt(0) == '0' && sb.length() > 1)
			sb.deleteCharAt(0);

		return sb.toString();
	}
}
class StringComparator implements Comparator<String>
{
	public int compare(String s1, String s2)
	{
		String leftRight = s1 + s2;
		String rightLeft = s2 + s1;

		return rightLeft.compareTo(leftRight);
	}
}