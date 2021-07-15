package simple;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CurrencyConverter{
		
	public static void main(String[] args) {
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		JFrame f = new JFrame("Currency Converter");
		
		JLabel lb_rupees, lb_dollars, lb_clickRupees, lb_clickDollars, lb_check1, lb_check2;
		
		JTextField txt_rupees, txt_dollars;
		
		JButton b_RupeeToDollar, b_DollarToRupee, b_close;
		
		//label for giving the converted value or alert if wrong input entered by the suer in the rupees textfeild
		lb_check1 = new JLabel(" ");
		lb_check1.setBounds(20,60, 350, 20);
		f.add(lb_check1);
		
		//label for giving the converted value or alert if wrong input entered by the user in the dollars textfeild
		lb_check2 = new JLabel(" ");
		lb_check2.setBounds(20, 170, 350, 20);
		f.add(lb_check2);
		
		//label named "Rupees"
		lb_rupees = new JLabel("RUPEES: ");
		lb_rupees.setBounds(20, 20, 100, 20);
		lb_rupees.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		f.add(lb_rupees);
		
		//textfield to enter the amount of Rs.
		txt_rupees = new JTextField();
		txt_rupees.setBounds(110, 20, 100, 20);
		f.add(txt_rupees);
		
		//KeyListener to check if the content entered in the textfield is a number or not.
		txt_rupees.addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent e) {
				
				char c = e.getKeyChar();

				if(Character.isLetter(c) || Character.isWhitespace(c)) {
					txt_rupees.setEditable(false);
					lb_check1.setText("Enter a numerical value only");
				}
				if((!Character.isDigit(c)) || (Character.isLetter(c)) || (Character.isWhitespace(c))) {
					txt_rupees.setEditable(false);
					lb_check1.setText("Enter a numerical value only");
				}
				else {
					txt_rupees.setEditable(true);
				}
			}	
		});
							
		//button to convert Rs. to $.
		b_RupeeToDollar = new JButton("Rs. to $");
		b_RupeeToDollar.setBounds(275, 20, 100, 20);
		f.add(b_RupeeToDollar);
		
		//label placed below  Rs. to $ button
		lb_clickRupees = new JLabel("(Click this button to convert Rs. to $)");
		lb_clickRupees.setBounds(220, 40, 250, 20);
		lb_clickRupees.setFont(new Font("Arial", Font.BOLD|Font.ITALIC, 12));
		f.add(lb_clickRupees);
		
		//label named "Dollars"
		lb_dollars = new JLabel("DOLLARS: ");
		lb_dollars.setBounds(20, 120, 100, 20);
		lb_dollars.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		f.add(lb_dollars);
		
		//textfield to enter the number of $
		txt_dollars = new JTextField();
		txt_dollars.setBounds(110, 120, 100, 20);
		f.add(txt_dollars);
		
		//KeyListener to check if the content entered in the textfield is a number or not.
		txt_dollars.addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent e) {								

				String splChar = txt_dollars.getText();
				char c = e.getKeyChar();
				
				if(Character.isLetter(c) || Character.isWhitespace(c)) {
					txt_dollars.setEditable(false);
					lb_check2.setText("Enter a numerical value only");
				}
				if((!Character.isDigit(c)) || (Character.isLetter(c)) || (Character.isWhitespace(c))) {
					txt_dollars.setEditable(false);
					lb_check2.setText("Enter a numerical value only");
				}
				else {
					txt_dollars.setEditable(true);
				}				
			}
			
		});
						
		//button to convert $ to Rs.
		b_DollarToRupee = new JButton("$ to Rs.");
		b_DollarToRupee.setBounds(275, 120, 100, 20);
		f.add(b_DollarToRupee);
		
		//label placed below $ to Rs. button
		lb_clickDollars = new JLabel("(Click this button to convert $ to Rs.)");
		lb_clickDollars.setBounds(220, 140, 250, 20);
		lb_clickDollars.setFont(new Font("Arial", Font.BOLD|Font.ITALIC, 12));
		f.add(lb_clickDollars);
		
		//Button to close the currency converter application
		b_close = new JButton("Close");
		b_close.setBounds(180, 200, 100, 20);
		f.add(b_close);
		
		f.setSize(480, 300);
		f.setLayout(null);
		f.setVisible(true);
		
		//Close the frame output 
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Action listener for b_RupeeToDollar button
		b_RupeeToDollar.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//convert the string value entered in the textfield into float value
				float rupees = Float.parseFloat(txt_rupees.getText());
				
				//even if the user enters a negative value by mistake, the app should give the answer as a positive number
				if(rupees < 0) {
					rupees = rupees * -1;
				}
				
				//conversion formula for rupees to dollars
				float valueRsToDollar = (float) (rupees / 74.49);
				
				//after conversion, the store the value upto 2 decimal places
				String TwoDecimalDollar = String.format("%.2f", valueRsToDollar);
				
				//get the string value of the converted value
		        String RsToDollar = String.valueOf(TwoDecimalDollar);
		        
		        //get the converted dollar value in the textbox for dollars
		        txt_dollars.setText(RsToDollar);
		        		       
		        lb_check1.setText("Rs. " + rupees + " = " + "$" +RsToDollar);
		        
		        lb_check2.setText("");
						
			}
		});
		
		//Action listener for b_DollarToRupee button
		b_DollarToRupee.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
								
				float dollars = Float.parseFloat(txt_dollars.getText());
				
				//even if the user enters a negative value by mistake, the app should give the answer as a positive number
				if(dollars < 0) {
					dollars = dollars * -1;
				}
								
				float valueDollarRoRupees = (float) (dollars * 74.49);
				
				String TwoDecimalRupees = String.format("%.2f", valueDollarRoRupees);
								
				String DollarToRupees = String.valueOf(TwoDecimalRupees);
				  
				txt_rupees.setText(DollarToRupees);
				
				lb_check2.setText("$ " + dollars + " = " + "Rs. " +DollarToRupees);
				
				lb_check1.setText("");
			}
		});
		
		// Action listener to close the application using b_close button
        b_close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                f.dispose();
            }
        });
		
	}
}