class WordNode
{
	String word;
	int steps;
	WordNode pre;

	WordNode(String word, int steps, WordNode pre)
	{
		this.word = word;
		this.steps = steps;
		this.pre = pre;
	}
}
public class Solution
{
	public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList)
	{
		List<List<String>> result = new ArrayList<>();

		Queue<WordNode> q = new LinkedList<>();
		q.offer(new WordNode(beginWord,1,null));

		wordList.add(endWord);

		int minStep = 0;

		Set<String> visited = new HashSet<>();
		Set<String> unvisited = new HashSet<>();
		unvisited.addAll(wordList);

		int preSteps = 0;

		while(!q.isEmpty())
		{
			WordNode x = q.poll();
			String word = x.word;
			int curSteps = x.steps;

			if(word.equals(endWord))
			{
				if(minStep == 0)
					minStep = x.steps;

				if(x.steps == minStep && minStep != 0)
				{
					List<String> t = new ArrayList<>();
					t.add(x.word);

					while(x.pre != null)
					{
						t.add(0, x.pre.word);
						x = x.pre;
					}

					result.add(new ArrayList<>(t));
					continue;
				}
			}

			if(preSteps < curSteps)
				unvisited.removeAll(visited);

			preSteps = curSteps;

			char [] characters = word.toCharArray();

			for(int i = 0;i < characters.length;i++)
			{
				for(char c = 'a';c <= 'z';c++)
				{
					char t = characters[i];
					if(characters[i] != c)
						characters[i] = c;

					String newWord = new String(characters);

					if(unvisited.contains(newWord))
					{
						q.offer(new WordNode(newWord, x.steps + 1, x));
						visited.add(newWord);
					}

					characters[i] = t;
				}
			}
		}

		return result;
	}
}