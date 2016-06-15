class Node
{
	Node [] children;
	boolean isLeaf;
	Node()
	{
		children = new Node [26];
		isLeaf = false;
	}
}
public class WordDictionary
{
	Node root;

	WordDictionary()
	{
		root = new Node();
	}

	public void addWord(String word)
	{
		Node node = root;
		for(char x: word.toCharArray())
		{
			if(node.children[x - 'a'] == null)
				node.children[x - 'a'] = new Node();
			node = node.children[x - 'a'];
		}
		node.isLeaf = true;
	}

	public boolean search(String word)
	{
		return search(root,0,word);
	}

	private boolean search(Node node,int k,String word)
	{
		if(node == null)
			return false;
		else if(k == word.length())
			return node.isLeaf;

		char c = word.charAt(k);

		if(c == '.')
		{
			for(Node x: node.children)
			{
				if(search(x,k+1,word))
					return true;
			}
			return false;
		}
		else
		{
			Node x = node.children[c - 'a'];
			return search(x,k+1,word);
		}
	}
}