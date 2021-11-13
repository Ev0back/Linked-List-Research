public abstract class BaseList implements ListInterface
{
	Node list;
	long refChanges;
	long keyCompare;

	BaseList() // constructor: empty list, counters set to zero
	{
		list = null;
		refChanges = 0;
		keyCompare = 0;
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

//	protected Node search(String word)
//	{
//		Node current = list;
//
//		while (current != null)
//		{
//			keyCompare++;
//			if (current.getValue().equals(word))
//			{
//				return current;
//			}
//			current = current.getNextNode();
//
//		}
//		return null;
//
//	}

	@Override
	public String toString()
	{
		String string = "";
		if (list == null)
		{ // List is empty, nothing to print
			return string;
		}
		Node current = list;
		while (current != null)
		{
			string += "\n\nKey: " + current.getValue() + "\nCount: " + current.getCount();
			current = current.getNextNode(); // Move to the next node
		}
		return string;
	}

}