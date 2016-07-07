// There are three ways to implement the method
// Must realisze the truth of the ways

//Way One
public class Solution
{
	public List<Integer> postorderTraversal(TreeNode root)
	{
		List<Integer> result = new ArrayList<>();

		if(root == null)
			return result;

		postorderTraversal(root,result);

		return result;
	}

	public void postorderTraversal(TreeNode node, List<Integer> result)
	{
		if(node == null)
			return;

		postorderTraversal(node.left,result);
		postorderTraversal(node.right,result);
		result.add(node.val);
	}
}

//Way Two
public class Solution
{
	public List<Integer> postorderTraversal(TreeNode root)
	{
		List<Integer> result = new ArrayList<>();

		if(root == null)
			return result;

		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		TreeNode pre = null;

		while(!stack.isEmpty())
		{
			TreeNode cur = stack.peek();

			if(pre == null || pre.left == cur || pre.right == cur)
			{
				if(cur.left != null)
					stack.push(cur.left);
				else if(cur.right != null)
					stack.push(cur.right);
				else
				{
					stack.pop();
					result.add(cur.val);
				}
			}
			else if(cur.left == pre)
			{
				if(cur.right != null)
					stack.push(cur.right);
				else
				{
					stack.pop();
					result.add(cur.val);
				}
			}
			else if(cur.right == pre)
			{
				stack.pop();
				result.add(cur.val);
			}

			pre = cur;
		}

		return result;
	}
}

//Way Three
public class Solution
{
	public List<Integer> postorderTraversal(TreeNode root) 
	{    
		List<Integer> result = new ArrayList<Integer>();

		TreeNode dummy = new TreeNode(0);
		dummy.left = root;
		TreeNode cur = dummy;
		TreeNode pre = null;

		while(cur != null)
		{
			if (cur.left == null)
				cur = cur.right;
			else
			{
				pre = cur.left;

				while (pre.right != null && pre.right != cur)
					pre = pre.right;

				if (pre.right == null)
				{
					pre.right = cur;
					cur = cur.left;
				}
				else
				{
					reverse(cur.left, pre);
					TreeNode temp = pre;

					while (temp != cur.left)
					{
						res.add(temp.val);
						temp = temp.right;
					}

					res.add(temp.val);
					reverse(pre, cur.left);
					pre.right = null;
					cur = cur.right;
				}
			}
		}     
		return res;
	}

	public void reverse(TreeNode start, TreeNode end)
	{
		if (start == end)
			return;

		TreeNode pre = start;
		TreeNode cur = start.right;
		TreeNode next;

		while (pre != end)
		{
			next = cur.right;
			cur.right = pre;
			pre = cur;
			cur = next;
		}
	}
}