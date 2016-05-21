public class Solution
{
	ListNode h;
	public TreeNode sortedListToBST(ListNode head)
	{
		if(head == null)
			return null;

		h = head;

		ListNode p = head;
		int l = 0;
		while(p != null)
		{
			p = p.next;
			l++;
		}

		return sortedListToBST(0,l - 1);
	}

	private TreeNode sortedListToBST(int l, int r)
	{
		if(l > r)
			return null;

		int m = l + (r - l) / 2;

		TreeNode left = sortedListToBST(l,m-1);
		TreeNode root = new TreeNode(h.val);
		h = h.next;
		TreeNode right = sortedListToBST(m+1,r);
		root.left = left;
		root.right = right;
		return root;
	}
}