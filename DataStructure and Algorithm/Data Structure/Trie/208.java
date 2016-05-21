class TrieNode
{
	TrieNode [] children;
	boolean isLeaf;
	// Initialize your data structure here.
	public TrieNode()
	{
		children = new TrieNode[26];
		isLeaf = false;
	}
}

public class Trie
{
	private TrieNode root;

	public Trie()
	{
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word)
	{
		TrieNode node = root;

		for(char x: word.toCharArray())
		{
			if(node.children[x - 'a'] == null)
				node.children[x - 'a'] = new TrieNode();
			node = node.children[x - 'a'];
		}

		node.isLeaf = true;
	}

	// Returns if the word is in the trie.
	public boolean search(String word)
	{
		TrieNode node = root;

		for(char x: word.toCharArray())
		{
			if(node.children[x - 'a'] == null)
				return false;
			else
				node = node.children[x - 'a'];
		}
		
		return node.isLeaf;
	}

	//Returns if there is any word in the trie
	// that starts with the given prefix
	public boolean startsWith(String prefix)
	{
		TrieNode node = root;

		for(char x: prefix.toCharArray())
		{
			if(node.children[x - 'a'] == null)
				return false;
			else
				node = node.children[x - 'a'];
		}

		return true;
	}
}