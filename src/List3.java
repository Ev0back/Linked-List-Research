
/* List 3:
 * A self-adjusting list in which, when a word is found to be already in the list, the node containing
 * that word is moved to become the first node of the list. For words NOT already in the list, they 
 * become the list's first word. The idea here is that the more-frequently-used words will stay closer 
 * to the beginning of the list. Moving a repeated word all the way back to the beginning of the list
 * is something of a “heavy-handed” adjustment, which leads us to the fourth list…
 */
public class List3<T> extends BaseList implements ListInterface
{

	private int size;

	public List3()
	{
		list = null;
		size = 0;
	}

	@Override
	public void add(String word) // add this word to the linked list
	{

		Node newNode = new Node(word);

		if (list == null) // empty list
		{

			list = newNode;
			refChanges++;

		} else // new word
		{
			sortInsert(word);
		}

		size++;

	}

	public void sortInsert(String word)
	{

		Node previous = null;
		Node current = list;
		Node newNode = new Node(word);

		// insert self adjust
		while (current != null)
		{
			keyCompare++;
			if (current.getValue().compareTo(word) == 0)
			{

				if (previous != null)
				{
					refChanges += 3;
					current.setCount(current.getCount() + 1);
					previous.setNextNode(current.getNextNode());
					current.setNextNode(list);
					list = current;
				} else
				{
					refChanges++;
					current.setCount(current.getCount() + 1);
					list = current;
				}

				return;

			}

			previous = current;
			current = current.getNextNode();
		}

		newNode.setNextNode(list);
		list = newNode;
		refChanges += 2;

		return;

	}

	@Override
	public long getRefChanges()
	{
		// How many reference changes did we do (how much structural work)?
		//
		return refChanges;
	}

	@Override
	public long getKeyCompare()
	{
		// How many key comparisons (how much work was done looking for things on the
		// list)?
		//
		return keyCompare;
	}

	@Override
	public int getDistinctWords()
	{
		// How many nodes are there on the list? Each corresponds to a unique word
		//
		int count = 0; // Alternate coding:
		Node p = list; //
		while (p != null) // for (LLNode p = list; p != null; p = p.getNext()) count++;
		{ // return count;
			count++; //
			p = p.getNextNode(); //
		} //
		return count; //
	}

	@Override
	public int getTotalWords()
	{
		// How many TOTAL words? That's the sum of the counts in each node.
		//
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
