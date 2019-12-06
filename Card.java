import java.awt.image.BufferedImage;

//model
public class Card {
	
	private String faceName, suit;
	private BufferedImage cardImage;
	
	public Card(String suit, String faceName, int faceValue, BufferedImage cardImage) {
		this.suit = suit;
		this.faceName = faceName;
		this.cardImage = cardImage;
	}
	
	public String getFaceName() {return faceName;}
	public String getSuit() { return suit;}
	public BufferedImage getCardImage() { return this.cardImage;}
	
}
