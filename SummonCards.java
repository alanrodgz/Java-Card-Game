import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class SummonCards extends JFrame{

	JPanel s2 = new JPanel();

	public enum suit {
		diamonds, clubs, hearts, spades
	}

	suit mySuit = suit.diamonds;

	Assests myAss = new Assests();
	
	JPanel toolBarPanel = new JPanel();

	JButton myButton = new JButton("Reset Game");
	JButton exitButton = new JButton("Exit Game");
	
	List<JLabel> myList = new ArrayList<JLabel>();
	



	SummonCards() throws IOException {
		
		
		myButton.setPreferredSize(new Dimension(100, 50));
		myButton.setVisible(true);
		
		exitButton.setPreferredSize(new Dimension(100, 50));
		exitButton.setVisible(true);
		
		toolBarPanel.add(myButton, BorderLayout.SOUTH);
		toolBarPanel.add(exitButton, BorderLayout.SOUTH);
		
		
//		JPanel toolStatusPanel = new JPanel();
//		toolStatusPanel.setLayout(new BorderLayout());
//		
//		toolStatusPanel.add(toolBarPanel, BorderLayout.EAST);
		


		ArrayList<Card> deck = new ArrayList<Card>();

		int h = 0;

		// Creating the Cad Nodes 
		for(int i = 0; i < 25; i++) {

			//System.out.println("i: " + i);

			switch(mySuit) {

			case diamonds:

				//System.out.println("Diamonds");
				deck.add(new Card("D",myAss.getSuitName()[i], 14, ImageIO.read(new File("/Users/mac/Downloads/PNG/red_back.png"))));

				if(i == 12) {
					mySuit = suit.clubs;
				}
				break;

			case clubs:


				//System.out.println("clubs");
				deck.add(new Card("D",myAss.getSuitName()[h], 14, ImageIO.read(new File("/Users/mac/Downloads/PNG/red_back.png"))));
				if(i == 25) {
					mySuit = suit.hearts;
				}
				h++;
				break;

			case hearts:

				//System.out.println("hearts");
				deck.add(new Card("Spades","Ace", 14, ImageIO.read(new File("/Users/mac/Desktop/grid.png"))));
				if(i == 38) {
					mySuit = suit.spades;
				}
				break;

			case spades:

				//System.out.println("spades");
				break;
			}
		}




		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setSize(1200, 600);
		setSize(1000,700);
		//setSize(1000,1000);
		setLocationRelativeTo(this);
		setTitle("Memorization Game");


		JPanel back = new JPanel();
		back.setSize(getSize());
		back.setBackground( new Color(0,102,0));
		back.setLayout(null);
		back.setLocation(0,0);

		s2.setSize(getSize());
		s2.setLayout(null);
		s2.setLocation(20,20);
		s2.setName("pane");



		setCards(deck, back);

		Movment mv = new Movment(back.getComponents());
		Movment mv2 = new Movment(s2.getComponents());

		myButton.addActionListener(new ActionListener() { 

			public void actionPerformed(ActionEvent e) {
				
				for(int i = 0; i < myList.size(); i++) {
					myList.get(i).setVisible(true);
					
					BufferedImage backOfImage;
					try {
						backOfImage = ImageIO.read(new File("/Users/mac/Downloads/PNG/red_back.png"));
						Image dimg = backOfImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
						ImageIcon icon = new ImageIcon(dimg);
						icon.setDescription("redBack");
						myList.get(i).setIcon(icon);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						System.out.print("CANNOT LOAD IMAGE TO JPANEL");
						e1.printStackTrace();
					}
					
				}
			}

		});
		
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Thank you for playing!");
				System.exit(0);
			}
		});
		
		

		
	}

	private void setCards(ArrayList<Card> deck, JPanel back) {
		// Summon the Cards
		int m = 0, t = 0, z = 0, x =0;

		
		
		for(int i = 0; i< 25; i++) {
			Image dimg = deck.get(i).getCardImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			ImageIcon icon = new ImageIcon(dimg);

			JLabel panel = new JLabel(icon);
			panel.setName(deck.get(i).getFaceName() + deck.get(i).getSuit());
			panel.setSize(100, 100);


			if(i < 5) {
				panel.setLocation(50, 400 - (100 * i));
			} else if(i < 10){


				panel.setLocation(200, 400 - (100 * m));
				m++;
			} else if(i < 15){


				panel.setLocation(350, 400 - (100 * t));
				t++;
			} else if(i < 20){


				panel.setLocation(500, 400 - (100 * z));
				z++;
			} else {


				panel.setLocation(650, 400 - (100 * x));
				x++;
			}

			back.add(panel);	
			myList.add(panel);
			back.add(toolBarPanel);
		}

		add(back);
		//add(toolBarPanel);

		add(toolBarPanel, BorderLayout.SOUTH);
		toolBarPanel.setBackground(new Color(0,102,0));
		//toolBarPanel.setVisible(true);

		setVisible(true);
	}
	

}
