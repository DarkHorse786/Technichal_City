import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
//Import for simulated Excel data storage (replace with your actual data storage approach)
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SignupPanel extends JPanel
{
	private ArrayList<User> users = new ArrayList<>();
	
    private JTextField usernameField;
    private JPasswordField passwordField;
	
	public SignupPanel() 
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
        
        JButton createButton = new JButton("Create");
        createButton.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        createButton.setBackground(new Color(128, 128, 128));
        createButton.setBounds(490, 330, 100, 30);
        createButton.addActionListener(new CreateButtonListener());
        LayeredPane.add(createButton, JLayeredPane.DEFAULT_LAYER); // Add to default layer
        
        JButton goBackButton = new JButton("Go Back");
        goBackButton.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        goBackButton.setBackground(new Color(188, 188, 188));
        goBackButton.setBounds(490, 380, 100, 30);
        goBackButton.addActionListener(new GoBackButtonListener());
        LayeredPane.add(goBackButton, JLayeredPane.DEFAULT_LAYER); 

	        // Read existing user data from CSV on startup
       
	        readUsersFromCSV();
	    }

	    private class GoBackButtonListener implements ActionListener {

	        @Override
	        public void actionPerformed(ActionEvent e) 
	        {
	            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(SignupPanel.this);
	            frame.getContentPane().removeAll();
	            WelcomePanel welcomePanel = new WelcomePanel(); 
	            frame.getContentPane().add(welcomePanel, BorderLayout.CENTER);
	            frame.revalidate();
	        }
	    }

	    private class CreateButtonListener implements ActionListener {

	        @Override
	        public void actionPerformed(ActionEvent e) {
	            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(SignupPanel.this);

	            String username = usernameField.getText();
	            String password = passwordField.getText();

	            if (userExists(username)) 
	            {
	                JOptionPane.showMessageDialog(SignupPanel.this, "Username already exists!");
	            }
	            else if (username.isEmpty() || password.isEmpty()) 
	            {
	                JOptionPane.showMessageDialog(SignupPanel.this, "Please fill all fields (Username and Password).");
	                return; // Exit the method if fields are empty
	            }
	            else 
	            {
	                User newUser = new User(username, password);
	                users.add(newUser);
	                // Write user data to CSV file
	                writeUserToCSV(newUser);

	                JOptionPane.showMessageDialog(SignupPanel.this, "Account created successfully!");
	                
	                frame.getContentPane().removeAll();
	                WelcomePanel welcomePanel = new WelcomePanel(); // Assuming WelcomePanel exists
	                frame.getContentPane().add(welcomePanel, BorderLayout.CENTER);
	                frame.revalidate();
	            }
	        }
	    }
	    
	    private void writeUserToCSV(User user) 
	    {
	    	try (FileWriter writer = new FileWriter("D:\\Technical City\\user_data.csv", true)) 
	    	{
	    		String data = user.getUsername() + "," + user.getPassword();	            
	            writer.write(data);
	            writer.write("\n"); // Add a newline after each user data
	        } 
	    	catch (IOException ex) 
	    	{
	            // Handle potential exceptions during file writing
	            ex.printStackTrace();
	            JOptionPane.showMessageDialog(SignupPanel.this, "Error saving data!");
	        }
	    }

	    private boolean userExists(String username) 
	    {
	        for (User user : users) 
	        {
	            if (user.getUsername().equals(username) ) {
	                return true;
	            }
	        }
	        return false;
	    }

	    private void readUsersFromCSV() {
	        try (BufferedReader reader = new BufferedReader(new FileReader("D:\\Technical City\\user_data.csv"))) 
	        {
	            String line;
	            // Check if there's data to read
	            if ((line = reader.readLine()) != null) {
	                while ((line = reader.readLine()) != null) {
	                    String[] data = line.split(",");
	                    String username = data[0];
	                    String password = data[1];
	                    users.add(new User(username, password));
	                }
	            }
	        } 
	        catch (IOException ex) 
	        {
	            // Handle potential exceptions during file reading (optional)
	            ex.printStackTrace();
	        }
	    }
}
 

	  

