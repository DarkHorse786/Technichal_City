import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SigninPanel extends JPanel {
	
	 private JTextField usernameField;
	 private JPasswordField passwordField;
		

    private DashboardPanel dashboardPanel; // Reference to DashboardPanel

    public SigninPanel() 
    { 
    	
    	setLayout(new BorderLayout()); // Use BorderLayout as a base container

        JLayeredPane LayeredPane = new JLayeredPane();
        LayeredPane.setPreferredSize(new Dimension(400, 100)); // Set preferred size
        add(LayeredPane, BorderLayout.CENTER);
        
        JLabel lblNewLabel_1 = new JLabel("Create an Account");
        lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 28));
        lblNewLabel_1.setBounds(355, 20, 255, 58);
        LayeredPane.add(lblNewLabel_1);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        usernameLabel.setBackground(new Color(128, 128, 128));
        usernameLabel.setBounds(356, 207, 100, 30);
        LayeredPane.add(usernameLabel, JLayeredPane.DEFAULT_LAYER); // Add to default layer
        
        usernameField = new JTextField();
        usernameField.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        usernameField.setBounds(446, 207, 160, 30);
        LayeredPane.add(usernameField, JLayeredPane.DEFAULT_LAYER); // Add to default layer
        
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        passwordLabel.setBackground(new Color(128, 128, 128));
        passwordLabel.setBounds(356, 247, 100, 30);
        LayeredPane.add(passwordLabel, JLayeredPane.DEFAULT_LAYER); // Add to default layer
        
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
        passwordField.setBounds(446, 247, 160, 30);
        LayeredPane.add(passwordField, JLayeredPane.DEFAULT_LAYER); // Add to default layer
        
        JButton signinButton = new JButton("Sign In");
        signinButton.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        signinButton.setBackground(new Color(128, 128, 128));
        signinButton.setBounds(380, 330, 100, 30);
        signinButton.addActionListener(new SigninButtonListener());
        LayeredPane.add(signinButton, JLayeredPane.DEFAULT_LAYER); // Add to default layer
        
        JButton signupButton = new JButton("Sign Up");
        signupButton.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        signupButton.setBackground(new Color(128, 128, 128));
        signupButton.setBounds(510, 330, 100, 30);
        signupButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              // Code to navigate to SignupPanel
              JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(SigninPanel.this);
              SignupPanel signupPanel = new SignupPanel(); // Assuming SignupPanel exists
              frame.getContentPane().removeAll();
              frame.getContentPane().add(signupPanel, BorderLayout.CENTER);
              frame.revalidate();
          }
      });
        LayeredPane.add(signupButton, JLayeredPane.DEFAULT_LAYER); // Add to default layer
        
        JButton goBackButton = new JButton("Go Back");
        goBackButton.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        goBackButton.setBackground(new Color(188, 188, 188));
        goBackButton.setBounds(510, 380, 100, 30);
        goBackButton.addActionListener(new GoBackButtonListener());
        LayeredPane.add(goBackButton, JLayeredPane.DEFAULT_LAYER); 

    }

	    private class SigninButtonListener implements ActionListener 
	    {
	
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(SigninPanel.this);
	
	            String username = usernameField.getText();
	            String password = passwordField.getText();
	
	            if (authenticateUser(username, password)) 
	            {
	                JOptionPane.showMessageDialog(SigninPanel.this, "Welcome " + username + "!");
	                // Navigate to DashboardPanel or adminPanel
	                System.out.println(password);
	               if("admin".equals(username))
	               {
	            	   adminPanel admin = new adminPanel();
		               frame.getContentPane().removeAll();
		               frame.getContentPane().add(admin, BorderLayout.CENTER);
		               frame.revalidate();
	               }
	               else
	               {
	            	   DashboardPanel dashboardPanel = new DashboardPanel();
		               frame.getContentPane().removeAll();
		               frame.getContentPane().add(dashboardPanel, BorderLayout.CENTER);
		               frame.revalidate();
	               }
	                
	                
	            }
	            else if (username.isEmpty() || password.isEmpty()) 
	            {
	                JOptionPane.showMessageDialog(SigninPanel.this, "Please fill all fields (Username and Password).");
	                return; // Exit the method if fields are empty
	            } 
	            else 
	            {
	                JOptionPane.showMessageDialog(SigninPanel.this, "Invalid username or password.");
	            }
	        }
	    }
	
	    private boolean authenticateUser(String username, String password) 
	    {
	        try (BufferedReader reader = new BufferedReader(new FileReader("D:\\Technical City\\user_data.csv"))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                String[] data = line.split(",");
	                if (data.length >= 2 && data[0].equals(username) && data[1].equals(password)) {
	                    return true;
	                }
	            }
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	        return false;
	    }
	    
	    private class GoBackButtonListener implements ActionListener {
	
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(SigninPanel.this);
	            frame.getContentPane().removeAll();
	            WelcomePanel welcomePanel = new WelcomePanel(); // Assuming WelcomePanel exists
	            frame.getContentPane().add(welcomePanel, BorderLayout.CENTER);
	            frame.revalidate();
	        }
	    }
}
