package strings;

public enum EStrings {
	CONFIRM_IF_QUIT("Do you want to quit?"),
	YES("Yes"),
	NO("No"),
	CREATE_PLAYER("Create player"),
	CHOOSE_PLAYER("Choose player"),
	QUIT("Quit"),
	BACK("Back"),
	CREATE_NEW_PLAYER("Create new player"),
	NICKNAME_LABEL("What is your player nickname?"),
	NICKNAME_TEXTFIELD_HINT("NICKNAME"),
	SCORES("SCORES: "),
	ESC_BATTLE_PANEL("To exit press esc"),
	CREATE_BUTTON("Create"),
	PROVIDE_NICKNAME("Provide player nickname:"),
	NICKNAME_INUSE_WARNING("UPS! This nichname is used by other user. Choose something else"),
	START_BATTLE("Start battle"),
	LVL("Lvl. "),
	PLAYER("PLAYER: "),
	PLAY_AGAIN("Play again!");

	public String text;

	private EStrings(String text) {
		this.text = text;
	}
}
