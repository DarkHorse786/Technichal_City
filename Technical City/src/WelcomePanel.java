import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePanel extends JPanel
{
	public WelcomePanel() 
	{

		
		setLayout(new BorderLayout()); // Use BorderLayout as a base container

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(400, 100)); // Set preferred size
        
        JLabel lblNewLabel_1 = new JLabel("What Mobile");
        lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
        lblNewLabel_1.setBounds(355, 20, 205, 58);
        layeredPane.add(lblNewLabel_1);

        JButton signupButton = new JButton("Sign Up");
        signupButton.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        signupButton.setBackground(new Color(128, 128, 128));
        signupButton.setBounds(396, 207, 100, 30);
        signupButton.addActionListener(new SignupButtonListener());
        layeredPane.add(signupButton, JLayeredPane.DEFAULT_LAYER); // Add to default layer

        JButton signinButton = new JButton("Log In");
        signinButton.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        signinButton.setBackground(new Color(128, 128, 128));
        signinButton.setBounds(396, 265, 100, 30);
        signinButton.addActionListener(new SignInButtonListener());
        layeredPane.add(signinButton, JLayeredPane.DEFAULT_LAYER); // Add to default layer

        add(layeredPane, BorderLayout.CENTER);
        
        JLabel lblNewLabel = new JLabel("LogIn or SignUp to continue");
        lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        lblNewLabel.setBounds(345, 390, 215, 20);
        layeredPane.add(lblNewLabel);
            
    	
    }

    private class SignupButtonListener implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
        	 JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(WelcomePanel.this);
             frame.getContentPane().removeAll();
             frame.getContentPane().add(new SignupPanel(), BorderLayout.CENTER);
             frame.revalidate();
        }
    }
    
    private class SignInButtonListener implements ActionListener 
    { 
        public void actionPerformed(ActionEvent e) 
        {
        	 JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(WelcomePanel.this);
             frame.getContentPane().removeAll();
             frame.getContentPane().add(new SigninPanel(), BorderLayout.CENTER);
             frame.revalidate();
        }
    }
}
