public enum RoomType {
	SINGLE("Single King"),
	DOUBLE("Double Beds"),
	SUITE("Suite");
	
	private String desc;
	private RoomType(String d) {
		this.desc = d;
	}
}