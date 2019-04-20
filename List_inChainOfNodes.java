/**
  Represent a list, implemented in a chain of nodes
 */

public class List_inChainOfNodes{
    private Node headReference;

    /**
      Construct an empty list
     */
    public List_inChainOfNodes(){
		headReference = new Node(null);
    } 
    
    /** 
      Construct a list given first element
     */
    public List_inChainOfNodes(Node firstNode){
        headReference.setReferenceToNextNode(firstNode);
    }

    /**
      @return the number of elements in this list
     */
    public int size() {
		Node node = headReference.getReferenceToNextNode();
		int size = 0; 
		
		while (node != null){
			size++;
			node = node.getReferenceToNextNode();
		}
		
		return size;
    }

    
     /**
       @return a string representation of this list,
       format:
           # elements [element0,element1,element2,] 
      */
    public String toString() {
        String result = "[";
        Node node = headReference.getReferenceToNextNode();
        for( int el = 0; el < size(); el++){
            result += node.getCargoReference() + ",";
            node = node.getReferenceToNextNode();
        }
        return result += "]";
    }
    
    
    /**
      Append @value to the head of this list.

      @return true, in keeping with conventions yet to be discussed
     */
     public boolean addAsHead( Object val) {
		Node el0 = headReference.getReferenceToNextNode(); 
		 
        // set new headRef to the param and set its nextRef to the former
        headReference.setReferenceToNextNode( new Node( val, el0));
       
        return true;
     }
     
    /**
     @return value corresponding to the given index
     */
     public Object get(int index){
         return getNode(index).getCargoReference();
         
     }

    /**
     Helper function for add and remove
     @return Node corresponding to the given index
     */
    private Node getNode(int index){
        Node node;
        int counter;
        for( counter = 0, node = headReference.getReferenceToNextNode()
            ; counter < index
            ; counter++, node = node.getReferenceToNextNode()
            )
            ;
        return node;

     }
     
    /**
      Append @value to the list at the given index. 
      
      @return true, in keeping with conventions. 
      
     */
    public boolean add(int index, Object val){
   
		Node preceeding = getNode( index - 1);
		Node addition = new Node(val);
		
		// set addition's next ref to former val at index
		Node replaced = preceeding.setReferenceToNextNode(new Node(val));
		preceeding.getReferenceToNextNode().setReferenceToNextNode( replaced);

        return true;
    }
    
    /**
      Sets @value at given index
      
      @return old value, in keeping with conventions
     */
    public Object set( int index, Object val){
		return getNode(index).setCargoReference(val);
	
        
    }
    
    /** 
      Removes @value at given index
      
      @return value removed, in keeping with conventions
     */
     
    public Node remove( int index){
		Node removed;
		
		if (index == 0){
			Node succeeding = 
			removed = headReference.setReferenceToNextNode( headReference.getReferenceToNextNode());
		}

		else{
			Node preceeding = getNode(index -1); 
			removed = preceeding.getReferenceToNextNode();
		
			preceeding.setReferenceToNextNode(removed.getReferenceToNextNode());
		}
		
		return removed;
        

    }
}
