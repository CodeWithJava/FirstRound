public class Solution
{
	public List<List<Integer>> zigzagLevelOrder(TreeNode root)
	{
		List<List<Integer>> result = new ArrayList<>();

		if(root == null)
			return result;

		boolean R2L = true;

		Stack<TreeNode> cur = new Stack<>();
		cur.push(root);

		while(!cur.isEmpty())
		{
			Stack<TreeNode> next = new Stack<>();
			List<Integer> t = new ArrayList<>();

			while(!cur.isEmpty())
			{
				TreeNode node = cur.pop();
				t.add(node.val);

				if(R2L)
				{
					if(node.left != null)
						next.push(node.left);
					if(node.right != null)
						next.push(node.right);
				}
				else
				{
					if(node.right != null)
						next.push(node.right);
					if(node.left != null)
						next.push(node.left);
				}
			}

			R2L = !R2L;

			result.add(new ArrayList<>(t));
			cur = next;
		}

		return result;
	}
}