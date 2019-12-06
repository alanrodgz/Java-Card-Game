import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

//Model
public class Movment implements MouseListener, MouseMotionListener {

	private int X,Y;


	private String cardFace = "";

	private int counter = 0;


	
	JLabel[] bufferList = new JLabel[3];

	

	public Movment(Component... pns) {

		for(Component panel : pns) {
			panel.addMouseListener(this);
			panel.addMouseMotionListener(this);
		}
	}

	@Override
	public void mouseDragged(MouseEvent event) {

		event.getComponent().setLocation((event.getX()+event.getComponent().getX()) - X, (event.getY()+event.getComponent().getY()) - Y);


	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {



		System.out.println("-----------------------");

		JLabel myLabel = (JLabel)e.getSource();



		BufferedImage backOfImage;

		System.out.println("++" + myLabel.getName());





		
		
		if(counter != 2) {
			// If The Card is Facing UP
			if( !myLabel.getName().equals("redBack")) {


				cardFace = myLabel.getName();
				System.out.println("The card is given the name: " + cardFace);

				try {

					backOfImage = ImageIO.read(new File("/Users/mac/Downloads/PNG/red_back.png"));
					Image dimg = backOfImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
					ImageIcon icon = new ImageIcon(dimg);
					icon.setDescription("redBack");

					myLabel.setName("redBack");

					myLabel.setIcon(icon);



				} catch (IOException e1) {

					e1.printStackTrace();
				}

			} else { // If the Card is Facing Down



				System.out.println("CARD ON BACK TO FRONT");



				System.out.println("cardFace: " + cardFace);

				try {
					backOfImage = ImageIO.read(new File("/Users/mac/Downloads/PNG/" + cardFace + ".png"));
					Image dimg = backOfImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
					ImageIcon icon = new ImageIcon(dimg);

					myLabel.setName(cardFace);

					myLabel.setIcon(icon);
					
					bufferList[counter] = myLabel;
					
					

				} catch(IOException e1) {
					e1.printStackTrace();
					System.out.println("CANNOT READ THIS FILE");
				}



				counter++;

			}


			System.out.println("COUNTER::: " + counter);
			
		
			
		}
		else if(counter == 2) {
			
			
			
			
			
			try {
				backOfImage = ImageIO.read(new File("/Users/mac/Downloads/PNG/red_back.png"));
				Image dimg = backOfImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
				ImageIcon icon = new ImageIcon(dimg);
				
				if(bufferList[0].getName().equals(bufferList[1].getName())) {
					bufferList[0].setVisible(false);
					bufferList[1].setVisible(false);
					
					
					
					
					
					
				} else {
					bufferList[0].setIcon(icon);
					bufferList[0].setName("redBack");
					bufferList[1].setIcon(icon);
					bufferList[1].setName("redBack");
				}
				
				
				
				for(int i = 0; i < 1000; i++) {
					System.out.print(i + " ");
				} System.out.println();
				
			} catch(IOException e1) {
				e1.printStackTrace();
				System.out.println("CANNOT READ THIS FILE");
			}
			
			counter = 0;
			Arrays.fill(bufferList, null);
			
		}


	}   // 9, q, 6(), 3, 9, q

	@Override
	public void mousePressed(MouseEvent e) {

		X = e.getX();
		Y = e.getY();

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
