public class Solution
{
	public void connect(TreeLinkNode root)
	{
		TreeLinkNode lastHead = root;
		TreeLinkNode lastCurrent = null;
		TreeLinkNode currentHead = null;
		TreeLinkNode current = null;

		while(lastHead != null)
		{
			lastCurrent = lastHead;

			while(lastCurrent != null)
			{
				if(lastCurrent.left != null)
				{
					if(currentHead == null)
					{
						currentHead = lastCurrent.left;
						current = currentHead;
					}
					else
					{
						current.next = lastCurrent.left;
						current = current.next;
					}
				}

				if(lastCurrent.right != null)
				{
					if(currentHead == null)
					{
						currentHead = lastCurrent.right;
						current = currentHead;
					}
					else
					{
						current.next = lastCurrent.right;
						current = current.next;
					}
				}

				lastCurrent = lastCurrent.next;
			}

			lastHead = currentHead;
			currentHead = null;
		}
	}
}