public class Solution
{
	public List<List<Integer>> pathSum(TreeNode root, int sum)
	{
		List<List<Integer>> result = new ArrayList<>();

		if(root == null)
			return result;

		List<Integer> t = new ArrayList<>();
		t.add(root.val);

		pathSum(root,sum - root.val,t,result);

		return result;
	}

	private void pathSum(TreeNode node, int sum, List<Integer> t, List<List<Integer>> result)
	{
		if(node.left == null && node.right == null && sum == 0)
			result.add(new ArrayList<>(t));
		else
		{
			if(node.left != null)
			{
				t.add(node.left.val);
				pathSum(node.left,sum - node.left.val,t,result);
				t.remove(t.size() - 1);
			}

			if(node.right != null)
			{
				t.add(node.right.val);
				pathSum(node.right,sum - node.right.val,t,result);
				t.remove(t.size() - 1);
			}
		}
	}
}