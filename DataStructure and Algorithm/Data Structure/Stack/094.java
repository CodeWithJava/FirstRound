// There are two ways to implement the method
// Must realisze the truth of the ways

//Way One 
public class Solution
{
	public List<Integer> inorderTraversal(TreeNode root)
	{
		List<Integer> result = new ArrayList<>();

		if(root == null)
			return result;

		inorderTraversal(root,result);

		return result;
	}

	public void inorderTraversal(TreeNode node, List<Integer> result)
	{
		if(node == null)
			return;
		inorderTraversal(node.left,result);
		result.add(node.val);
		inorderTraversal(node.right,result);
	}
}

//Way Two
public class Solution
{
	public List<Integer> inorderTraversal(TreeNode root)
	{
		List<Integer> result = new ArrayList<>();

		if(root == null)
			return result;

		Stack<TreeNode> stack = new Stack<>();
		TreeNode p = root;

		while(p != null || !stack.isEmpty())
		{
			if(p != null)
			{
				stack.push(p);
				p = p.left;
			}
			else if(!stack.isEmpty())
			{
				TreeNode t = stack.pop();
				result.add(t.val);
				p = t.right;
			}
		}

		return result;
	}
}