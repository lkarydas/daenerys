
/**
 * A linear singly linked-list implementation using generics.
 */
public class ListElement<T> {
  private ListElement<T> next;
  private T data;
  
  public ListElement(T data) {
    this.data = data;
  }
  
  public void setData(T data) {
    this.data = data;
  }
  
  public void setNext(ListElement<T> next) {
    this.next = next;
  }
  
  public T getData() {
    return data;
  }
  
  public ListElement<T> getNext() {
    return next;
  }

  @Override
  public String toString() {
	  return data.toString();
  }
  
  /**
   * Prints the list.
   */
  public void print() {
	  System.out.print(this.toString() + " ");
	  ListElement<T> nextElement = this.getNext();
	  while (nextElement != null) {
		  System.out.print(nextElement.toString() + " ");
		  nextElement = nextElement.getNext();
	  }
	  System.out.println("");
  }
  
}
