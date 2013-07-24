
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

}
