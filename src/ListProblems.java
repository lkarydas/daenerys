
public class ListProblems {

	ListElement<Integer> reverseIteratively(ListElement<Integer> list) {
		ListElement<Integer> currentElement, nextElement, previousElement;
		previousElement = null;
		currentElement = list;
		while (currentElement.getNext() != null) {
			nextElement = currentElement.getNext();
			currentElement.setNext(previousElement);
			previousElement = currentElement;
			currentElement = nextElement;
		}
		currentElement.setNext(previousElement);
		return currentElement;
	}
	
}
