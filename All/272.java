public class Solution
{
	public List<Integer> closestKValues(TreeNode root, double target, int k)
	{
		Queue<Integer> q = new LinkedList<>();

		if(root == null)
			return (List<Integer>)q;

		Stack<TreeNode> stack = new Stack<>();

		while(root != null)
		{
			stack.push(root);
			root = root.left;
		}

		while(!stack.isEmpty())
		{
			TreeNode node = stack.pop();

			if(q.size() < k)
				q.offer(node.val);
			else
			{
				int head = q.peek();

				if(Math.abs(head - target) > Math.abs(node.val - target))
				{
					q.poll();
					q.offer(node.val);
				}
				else
					break;
			}

			if(node.right != null)
			{
				node = node.right;

				while(node != null)
				{
					stack.push(node);
					node = node.left;
				}
			}
		}

		return (List<Integer>)q;
	}
}