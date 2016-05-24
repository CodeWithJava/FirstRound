public class Solution
{
	public List<TreeNode> generateTrees(int n)
	{
		if(n < 0)
			throw new IllegalArgumentException("Input must be non-negative");

		if(n == 0)
			return new ArrayList<TreeNode>();

		return generateTrees(1,n);
	}

	private List<TreeNode> generateTrees(int l, int r)
	{
		List<TreeNode> list = new ArrayList<>();

		if(l > r)
		{
			list.add(null);
			return list;
		}

		for(int i = l;i <= r;i++)
		{
			List<TreeNode> lefts = generateTrees(l,i-1);
			List<TreeNode> rights = generateTrees(i+1,r);

			for(TreeNode left: lefts)
			{
				for(TreeNode right: rights)
				{
					TreeNode root = new TreeNode(i);
					root.left = left;
					root.right = right;

					list.add(root);
				}
			}
		}

		return list;
	}
}