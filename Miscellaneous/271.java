public class Codec
{
	public String encode(List<String> strs)
	{
		StringBuilder sb = new StringBuilder();

		for(String str: strs)
			sb.append(String.valueOf(str.length()) + "*" + str);

		return sb.toString();
	}

	public List<String> decode(String s)
	{
		List<String> result = new ArrayList<>();

		if(s == null || s.length() == 0)
			return result;

		int i = 0;
		while(i < s.length())
		{
			int index = s.indexOf("*",i);
			int size = Integer.valueOf(s.substring(i,index));
			result.add(s.substring(index+1,index+1+size));
			i = index + 1 + size;
		}

		return result;
	}
}