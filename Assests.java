
//model
public class Assests {

	public enum suit {
		diamonds, clubs, hearts, spades
	}

	private suit mySuit = suit.diamonds;


	private String[] suitName;

	public Assests() {
		
		
		mySuit = suit.diamonds;
		

		suitName = new String[] {
				"A", "2", "3", "4", "5",
				"6", "7", "8", "9", "10",
				"J", "Q", "K"
		}; 
		
		
	}
	
	
	public String[] getSuitName(){
		return suitName;
	}
	
	public static <T extends Enum<T>> T getInstance(final String value, final Class<T> enumClass) {
	     return Enum.valueOf(enumClass, value);
	}

}
