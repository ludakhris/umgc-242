public class Guest {
	private String name;
	private int age;
	
	public Guest(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String toString() {
		return String.format("Guest: %s, Age: %d", this.name, this.age);
	}
}