public class Town {
	private String name;
	private boolean isVisited;

	public Town(String name) {
		this.name = name;
		this.isVisited = false;
	}

	public String getName() {
		return this.name;
	}

	public boolean getVisited() {
		return this.isVisited;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	@Override
	public boolean equals(Object obj) {
		if (obj.getClass() != getClass() || obj == null) {
			return false;
		}

		Town anotherTown = (Town) obj;
		return this.name.equals(anotherTown.name);
	}

	@Override
	public int hashCode() {

		return this.name.hashCode();
	}

	@Override
	public String toString() {
		return this.name.toString();
	}

}
