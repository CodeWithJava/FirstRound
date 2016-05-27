class WordNode
{
	String word;
	int steps;

	WordNode(String word, int steps)
	{
		this.word = word;
		this.steps = steps;
	}
}
public class Solution
{
	public int ladderLength(String beginWord, String endWord, Set<String> wordList)
	{
		Queue<WordNode> q = new LinkedList<>();
		q.offer(new WordNode(beginWord,1));

		wordList.add(endWord);

		while(!q.isEmpty())
		{
			WordNode x = q.poll();
			String word = x.word;

			if(word.equals(endWord))
				return x.steps;

			char [] characters = word.toCharArray();

			for(int i = 0;i < characters.length;i++)
			{
				for(char c = 'a';c <= 'z';c++)
				{
					char t = characters[i];
					if(characters[i] != c)
						characters[i] = c;

					String newWord = new String(characters);

					if(wordList.contains(newWord))
					{
						q.offer(new WordNode(newWord,x.steps + 1));
						wordList.remove(newWord);
					}

					characters[i] = t;
				}
			}
		}

		return 0;
	}
}