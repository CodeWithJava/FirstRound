// Way One
public class Solution
{
	int result;
	double minimum = Double.MAX_VALUE;

	public int closestValue(TreeNode root, double target)
	{
		if(root == null)
			throw new IllegalArgumentException("Input is invalid");

		traversal(root,target);

		return result;
	}

	private void traversal(TreeNode node, double target)
	{
		if(node == null)
			return;

		if(Math.abs(node.val - target) < minimum)
		{
			minimum = Math.abs(node.val - target);
			result = node.val;
		}

		if(target < node.val)
			traversal(node.left,target);
		else
			traversal(node.right,target);
	}
}

// Way Two
public class Solution
{
	public int closestValue(TreeNode root, double target)
	{
		if(root == null)
			throw new IllegalArgumentException("Input is invalid");

		int result = 0;
		double minimum = Double.MAX_VALUE;

		while(root != null)
		{
			if(root.val < target)
			{
				double difference = Math.abs(root.val - target);

				if(difference < minimum)
				{
					minimum = Math.min(minimum,difference);
					result = root.val;
				}

				root = root.right;
			}
			else if(target < root.val)
			{
				double difference = Math.abs(root.val - target);

				if(difference < minimum)
				{
					minimum = Math.min(minimum,difference);
					result = root.val;
				}

				root = root.left;
			}
			else
			{
				return root.val;
			}
		}

		return result;
	}
}

// Way Three
public class Solution
{
	public int closestValue(TreeNode root, double target)
	{
		if(root == null)	
			throw new IllegalArgumentException("Input is invalid");

		int result = root.val;

		while(root != null)
		{
			result = Math.abs(result - target) < Math.abs(root.val - target) ? result:root.val;

			root = target < root.val ? root.left:root.right;
		}

		return result;
	}
}