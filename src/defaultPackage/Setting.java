package defaultPackage;

public enum Setting {
	OFF("[---]"),
	LOW("[--+]"),
	MEDIUM("[-++]"),
	HIGH("[+++]");
	
	private String setting;
	
	Setting(String setting) {
		this.setting = setting;
	}
	
	public String toString() {
		return setting;
	}
}
