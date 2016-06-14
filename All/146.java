class Node
{
	int key;
	int value;
	Node prev;
	Node next;

	Node(int key, int value)
	{
		this.key = key;
		this.value = value;
	}
}
public class LRUCache
{
	int capacity;
	Node head;
	Node tail;
	Map<Integer,Node> map;

	public LRUCache(int capacity)
	{
		this.capacity = capacity;
		map = new HashMap<>();
	}

	public int get(int key)
	{
		if(map.containsKey(key))
		{
			Node node = map.get(key);
			removeNode(node);
			setHead(node);
			return node.value;
		}
		else
		{
			return -1;
		}
	}

	public void set(int key, int value)
	{
		if(map.containsKey(key))
		{
			Node node = map.get(key);
			removeNode(node);
			setHead(node);
			node.value = value;
		}
		else
		{
			Node create = new Node(key,value);

			if(map.size() >= capacity)
			{
				map.remove(tail.key);
				removeNode(tail);

			}

			setHead(create);
			map.put(key,create);
		}
	}

	private void removeNode(Node node)
	{
		if(node.prev != null)
			node.prev.next = node.next;
		else
			head = node.next;
		
		if(node.next != null)
			node.next.prev = node.prev;
		else
			tail = node.prev;
	}

	private void setHead(Node node)
	{
		node.prev = null;
		node.next = head;

		if(head != null)
			head.prev = node;

		head = node;

		if(tail == null)
			tail = head;
	}
}