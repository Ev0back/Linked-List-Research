
/*List 2:
 * A sorted (alphabetically) linked list. This list should have shorter average search times, because 
 * once you’ve determined where a word should be, if it’s not there, there is no use in searching the 
 * rest of the list (if you’re trying to add “absolute”, and you reach “absolve”, you know that
 * “absolute” isn’t in the list, and there’s no sense checking the remainder of the list. You do, 
 * however, have to create a new node and link it in between the two existing nodes (or perhaps this 
 * is a new first node, or a new last node).
 */

public class List2 extends BaseList implements ListInterface
{

	private int size;

	public List2()
	{
		list = null;

		size = 0;
	}

	@Override
	public void add(String word) // add this word to the linked list
	{

		var newNode = new Node(word);

		if (list == null)
		{
			list = newNode;
			refChanges++;
		} else
		{
			sortIns(word);
		}
		size++;

	}

	public void sortedInsert(String word)
	{
		Node current = list;
		Node newNode = new Node(word);

		// insert at beginning
		keyCompare++;
		if (current == null || current.getValue().compareTo(word) > 0)
		{
			refChanges += 2;
			newNode.setNextNode(current);
			list = newNode;
			return;
		}

		// insert in middle
		Node previous = null;
		while (current != null)
		{
			// word is already in list
			keyCompare++;
			if (current.getValue().compareTo(word) == 0)
			{
				current.setCount(current.getCount() + 1);
				return;
			}

			// word is alphabetically inserted
			keyCompare++;
			if (current.getValue().compareTo(word) > 0)
			{
				refChanges += 2;
				previous.setNextNode(newNode);
				newNode.setNextNode(current);
				return;
			}

			refChanges += 2;
			previous = current;
			current = current.getNextNode();
		}

		// insert at the end
		refChanges++;
		previous.setNextNode(newNode);
		return;

	}

	public void sortIns(String word)
	{
		Node previous = null;
		Node current = list;
		Node newNode = new Node(word);

		

		while (current != null && current.getValue().compareTo(word) <= 0)
		{
			keyCompare++;
			if (current.getValue().compareTo(word) == 0)
			{
				current.setCount(current.getCount() + 1);
				return;
			}
			
//			keyCompare++;
//			refChanges += 2;
			previous = current;
			current = current.getNextNode();
		}

		if (previous == null)
		{
			list = newNode;
			refChanges++;

		} else
		{

			newNode.setNextNode(current);
			previous.setNextNode(newNode);
			refChanges += 2;

		}
		
		newNode.setNextNode(current);
		return;

	}

	@Override
	public long getRefChanges()
	{
		// How many reference changes did we do (how much structural work)?

		return refChanges;
	}

	@Override
	public long getKeyCompare()
	{
		// How many key comparisons (how much work was done looking for things on the
		// list)?

		return keyCompare;
	}

	@Override
	public int getDistinctWords()
	{
		// How many nodes are there on the list? Each corresponds to a unique word

		int count = 0; // Alternate coding:
		Node p = list;
		while (p != null) // for (LLNode p = list; p != null; p = p.getNext()) count++;
		{ // return count;
			count++;
			p = p.getNextNode();
		}
		return count;
	}

	@Override
	public int getTotalWords()
	{
		// How many TOTAL words? That's the sum of the counts in each node.

		int count = 0;
		Node p = list;
		while (p != null)
		{
			count += p.getCount();
			p = p.getNextNode();
		}
		return count;
	}

}
