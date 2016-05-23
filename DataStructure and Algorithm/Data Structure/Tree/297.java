import java.util.StringTokenizer;
public class Codec
{
	// Encodes a tree to a single string.
	public String serialize(TreeNode root)
	{
		StringBuilder sb = new StringBuilder();

		if(root == null)
			return sb.toString();

		serialize(root,sb);

		return sb.substring(0,sb.length() - 1);
	}

	private void serialize(TreeNode node, StringBuilder sb)
	{
		if(node == null)
			sb.append("#*");
		else
		{
			sb.append(node.val + "*");
			serialize(node.left,sb);
			serialize(node.right,sb);
		}
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data)
	{
		if(data == null || data.length() == 0)
			return null;

		StringTokenizer st = new StringTokenizer(data,"*");

		return deserialize(st);
	}

	private TreeNode deserialize(StringTokenizer st)
	{
		if(!st.hasMoreTokens())
			return null;
		else
		{
			String value = st.nextToken();
			if(value.equals("#"))
				return null;

			TreeNode root = new TreeNode(Integer.valueOf(value));
			root.left = deserialize(st);
			root.right = deserialize(st);

			return root;
		}
	}
}