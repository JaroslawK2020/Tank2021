package strings;

public enum EStrings {
	CONFIRM_IF_QUITE("Do you want to quit?"),
	YES("Yes"),
	NO("No"),
	CREATE_PLAYER("Create player"),
	CHOOSE_PLAYER("Choose player"),
	QUITE("Quite");
	public String text;

	private EStrings(String text) {
		this.text = text;
	}
}
