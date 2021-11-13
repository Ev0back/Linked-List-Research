public class Node {
    private String value;
    private Node nextNode;
    private int count;
    
    public Node(String value){
        this.value = value;
        nextNode = null;
        count=1;
    }
    
    public void AddCount() {
    	count++;
    }
    
    public int getCount()
	{
		return count;
	}

	public void setCount(int count)
	{
		this.count = count;
	}

	public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
