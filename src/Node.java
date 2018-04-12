public class Node {
	public Town from;
	public Town destination;
	public int weight;
	public Node next;


	public Node(Town from, Town destination, int weight) {
		this.from = from;
		this.destination = destination;
		this.weight = weight;
		this.next = null;
	}

	public Node next(Node edge) {
		this.next = edge;
		return this;
	}

	public double getWeight() {
		return weight;
	}

	public Town getFrom() {
		return from;
	}

	public void setFrom(Town from) {
		this.from = from;
	}

	public Town getDestination() {
		return destination;
	}

	public void setDestination(Town destination) {
		this.destination = destination;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}
