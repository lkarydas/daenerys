
public class ListProblems {

	/**
	 * Iteratively reverse a single linked list.
	 * @param list The head of the list.
	 * @return the new head of the list.
	 */
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
	
	/**
	 * Recursively reverse a single linked list.
	 * @param list The head of the list.
	 * @return the new head of the list.
	 */
	ListElement<Integer> reverseRecursively(ListElement<Integer> list) {
		if (list == null) {
			return null;
		}
		if (list.getNext() == null) {
			return list;
		}
		ListElement<Integer> secondElement = list.getNext();
		list.setNext(null);
		ListElement<Integer> reversedList = reverseRecursively(secondElement);
		secondElement.setNext(list);
		return reversedList;
	}
	
}
