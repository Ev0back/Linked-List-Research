public interface ListInterface 
{
	void add(String word); // add this word to the linked list

	long getKeyCompare(); // Get the number of key comparisons

	long getRefChanges(); // Get the number of reference changes

	int getDistinctWords(); // Get the # of distinct words on the list

	int getTotalWords(); // Get the total number of ALL words
}
