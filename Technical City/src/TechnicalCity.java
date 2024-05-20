import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TechnicalCity {

	public static void main(String[] args) 
	{
		
	  	JFrame frame = new JFrame("Technical City");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(130, 30, 900, 600);
        
        WelcomePanel welcomePanel = new WelcomePanel();
        frame.getContentPane().add(welcomePanel, BorderLayout.CENTER);
      
        frame.setVisible(true);
	}

}
