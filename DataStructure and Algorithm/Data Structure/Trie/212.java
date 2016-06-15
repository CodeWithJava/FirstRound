public class Solution
{
	Set<String> set = new HashSet<>();
	public List<String> findWords(char [][] board,String [] words)
	{
		Trie trie = new Trie();

		for(String word: words)
			trie.insert(word);

		int r = board.length;
		int c = board[0].length;

		boolean [][] visited = new boolean [r][c];

		for(int i = 0;i < r;i++)
		{
			for(int j = 0;j < c;j++)
			{
				exist(board,visited,"",i,j,trie);
			}
		}

		return new ArrayList<String>(set);
	}

	private void exist(char [][] board,boolean [][] visited,String subword,int i,int j,Trie trie)
	{
		if(i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1)
			return;

		if(visited[i][j])
			return;

		subword += board[i][j];

		if(!trie.initializeWith(subword))
			return;

		if(trie.search(subword))
			set.add(subword);

		visited[i][j] = true;

		exist(board,visited,subword,i-1,j,trie);
		exist(board,visited,subword,i+1,j,trie);
		exist(board,visited,subword,i,j-1,trie);
		exist(board,visited,subword,i,j+1,trie);

		visited[i][j] = false;
	}
}
class Node
{
	Node [] children;
	boolean isLeaf;
	Node()
	{
		children = new Node [26];
	}
}
class Trie
{
	Node root;

	Trie()
	{
		root = new Node();
	}

	public void insert(String word)
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
		Node node = root;

		for(char x: word.toCharArray())
		{
			if(node.children[x - 'a'] == null)
				return false;
			else
				node = node.children[x - 'a'];
		}

		return node.isLeaf;
	}

	public boolean initializeWith(String prefix)
	{
		Node node = root;

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