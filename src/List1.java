/*
 * List 1: An unsorted linked list, in which additions always occur at the beginning (i.e., when a word 
 * read from the file is not already in the list, a new node, containing the word and a count of 1, 
 * becomes the list's first new node. This approach does the least amount of work on an addition
 */

public class List1 extends BaseList implements ListInterface
{
	private int size;

	public List1()
	{
		list = null;

		size = 0;
	}

	@Override
	public void add(String word) // add this word to the linked list
	{
		
		
		Node searchedNode = search(word);
		
		if (searchedNode != null) // if word exists already
		{
			searchedNode.setCount(searchedNode.getCount() + 1);
			
		} else
		{
			var newNode = new Node(word);

			if (list == null)
			{
				list = newNode;
				refChanges++;
			} else
			{
				newNode.setNextNode(list);
				list = newNode;
				refChanges+=2;

				

			}
			size++;
		}

	}

	public Node search(String word)
	{
		
		Node current = list;
		
		while (current != null)
		{
			keyCompare++;
			if (current.getValue().compareTo(word)==0)
			{
				return current;
			}
			
			current = current.getNextNode();
			
		}
		return null;

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
