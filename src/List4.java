
/* List 4:
 * A self-adjusting list in which, when a word is found to be already in the list, the word’s position 
 * moves back up towards the start of the list by one node (rather than all the way to the beginning, 
 * as in list #3). In order to implement this functionality, you will need to have a previous reference
 * (not a doubly-linked list) to keep track of the predecessor of the node containing the word in 
 * question. Words NOT already in the list become the list's first word
 */
public class List4<T> extends BaseList implements ListInterface
{

	private int size;

	public List4()

	{
		list = null;
		size = 0;
	}

	@Override
	public void add(String word) // add this word to the linked list
	{
		

		Node newNode= new Node(word);
		
			if (list == null)
			{
				newNode.setNextNode(list);
				list = newNode;
				refChanges+=2;
			} else
			{
				sortIns(word);

			}
			size++;

		}
	
	

	public void sortIns(String word)
	{
		Node current = list;
		Node previous = null;
		Node newNode = new Node(word);
		
		keyCompare++;
		if (current.getValue().compareTo(word) == 0) // if word is already in list
		{
			current.setCount(current.getCount()+1);
			return;
		}
		

		while (current.getNextNode() != null)
		{
			Node next = current.getNextNode(); // grabbing one node ahead
			keyCompare++;
			if (next.getValue().compareTo(word) == 0) // if word is already in list
			{
				next.setCount(next.getCount() + 1);
				if(previous==null)
				{
					return;
				}else {
					previous.setNextNode(next);
					current.setNextNode(next.getNextNode());
					next.setNextNode(current);
					refChanges += 3;
					return;
				}
				
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
