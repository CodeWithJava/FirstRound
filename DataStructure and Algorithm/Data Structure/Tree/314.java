public class Solution
{
	public List<List<Integer>> verticalOrder(TreeNode root)
	{
		List<List<Integer>> result = new ArrayList<>();
		if(root == null)
			return result;

		Map<TreeNode,Integer> column = new HashMap<>();
		column.put(root,0);
		Map<Integer,List<Integer>> vertical = new TreeMap<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);

		while(!q.isEmpty())
		{
			TreeNode node = q.poll();
			int col = column.get(node);
			if(!vertical.containsKey(col))
				vertical.put(col,new ArrayList<>());
			vertical.get(col).add(node.val);

			if(node.left != null)
			{
				q.offer(node.left);
				column.put(node.left,col-1);
			}

			if(node.right != null)
			{
				q.offer(node.right);
				column.put(node.right,col+1);
			}
		}

		for(List<Integer> x: vertical.values())
			result.add(new ArrayList<>(x));
		return result;
	}
}