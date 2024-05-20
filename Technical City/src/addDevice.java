import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JRadioButton;

public class addDevice extends JPanel
{
	private ArrayList<deviceData> devices = new ArrayList<>();
	
	 JTextField txtName;
	 JTextField txtRam;
	 JTextField txtStorage;
	 JTextField txtProcessor;
	 JTextField txtPicAdd;
	 
	 public static String getSelectedButtonText(ButtonGroup buttonGroup) {
	        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
	            AbstractButton button = buttons.nextElement();

	            if (button.isSelected()) {
	                return button.getText();
	            }
	        }

	        return null; // No button is selected
	    }
	 
	 
	    private void writeUserToTechnoCSV(deviceData Data) 
	    {
	    	try (FileWriter writer = new FileWriter("D:\\Technical City\\Techno.csv", true)) 
	    	{
	    		String data = Data.getdeviceName() + "," + Data.getcompanyName() + "," + Data.getstorageSize() + "," + Data.getramSize() + "," + Data.getAvailability() + "," + Data.getProcessor() + "," + Data.getpicture();	            
	            writer.write(data);
	            writer.write("\n"); // Add a newline after each user data
	        } 
	    	catch (IOException ex) 
	    	{
	            // Handle potential exceptions during file writing
	            ex.printStackTrace();
	            JOptionPane.showMessageDialog(addDevice.this, "Error saving data!");
	        }
	    }
	    
	    private void writeUserToIphoneCSV(deviceData Data) 
	    {
	    	try (FileWriter writer = new FileWriter("D:\\Technical City\\Iphone.csv", true)) 
	    	{
	    		String data = Data.getdeviceName() + "," + Data.getcompanyName() + "," + Data.getstorageSize() + "," + Data.getramSize() + "," + Data.getAvailability() + "," + Data.getProcessor() + "," + Data.getpicture();	            
	            writer.write(data);
	            writer.write("\n"); // Add a newline after each user data
	        } 
	    	catch (IOException ex) 
	    	{
	            // Handle potential exceptions during file writing
	            ex.printStackTrace();
	            JOptionPane.showMessageDialog(addDevice.this, "Error saving data!");
	        }
	    }

	    private boolean deviceExists(String deviceName) 
	    {
	        for (deviceData Data : devices) 
	        {
	            if (Data.getdeviceName().equals(deviceName) ) {
	                return true;
	            }
	        }
	        return false;
	    }
	 
	public addDevice() 
	{
		
		setLayout(new BorderLayout()); // Use BorderLayout as a base container

        JLayeredPane LayeredPane = new JLayeredPane();
        LayeredPane.setPreferredSize(new Dimension(400, 100)); // Set preferred size
        add(LayeredPane, BorderLayout.CENTER);
        
        JLabel lbladd = new JLabel("-: Add New Device :-");
        lbladd.setHorizontalAlignment(SwingConstants.CENTER);
        lbladd.setFont(new Font("Trebuchet MS", Font.BOLD, 28));
        lbladd.setBounds(265, 11, 380, 58);
        LayeredPane.add(lbladd);
        
        JLabel lblInfo = new JLabel("* Enter all Details to Add a Device:");
        lblInfo.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
        lblInfo.setBounds(10, 80, 350, 37);
        LayeredPane.add(lblInfo);
        
        JLabel lblname = new JLabel("Device Name:");
        lblname.setHorizontalAlignment(SwingConstants.LEFT);
        lblname.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        lblname.setBounds(265, 152, 142, 37);
        LayeredPane.add(lblname);
        
        JLabel lblcomapany = new JLabel("Select Company:");
        lblcomapany.setHorizontalAlignment(SwingConstants.LEFT);
        lblcomapany.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        lblcomapany.setBounds(265, 200, 142, 37);
        LayeredPane.add(lblcomapany);
        
        JLabel lblRam = new JLabel("Size of RAM:");
        lblRam.setHorizontalAlignment(SwingConstants.LEFT);
        lblRam.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        lblRam.setBounds(265, 248, 142, 37);
        LayeredPane.add(lblRam);
        
        JLabel lblStorage = new JLabel("Storage Size:");
        lblStorage.setHorizontalAlignment(SwingConstants.LEFT);
        lblStorage.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        lblStorage.setBounds(265, 296, 142, 37);
        LayeredPane.add(lblStorage);
        
        JLabel lblProcessor = new JLabel("Processor:");
        lblProcessor.setHorizontalAlignment(SwingConstants.LEFT);
        lblProcessor.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        lblProcessor.setBounds(265, 344, 142, 37);
        LayeredPane.add(lblProcessor);
        
        JLabel lblAvailable = new JLabel("Availability:");
        lblAvailable.setHorizontalAlignment(SwingConstants.LEFT);
        lblAvailable.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        lblAvailable.setBounds(265, 392, 142, 37);
        LayeredPane.add(lblAvailable);
        
        JLabel lblPicture = new JLabel("Picture:");
        lblPicture.setHorizontalAlignment(SwingConstants.LEFT);
        lblPicture.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        lblPicture.setBounds(265, 441, 142, 37);
        LayeredPane.add(lblPicture);
        
        txtName = new JTextField();
        txtName.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
        txtName.setBounds(417, 158, 228, 27);
        LayeredPane.add(txtName);
        txtName.setColumns(10);
        
        JTextField txtRam = new JTextField();
        txtRam.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
        txtRam.setColumns(10);
        txtRam.setBounds(417, 258, 228, 27);
        LayeredPane.add(txtRam);
        
        txtStorage = new JTextField();
        txtStorage.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
        txtStorage.setColumns(10);
        txtStorage.setBounds(417, 306, 228, 27);
        LayeredPane.add(txtStorage);
        
        txtProcessor = new JTextField();
        txtProcessor.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
        txtProcessor.setColumns(10);
        txtProcessor.setBounds(417, 354, 228, 27);
        LayeredPane.add(txtProcessor);
        
        txtPicAdd = new JTextField();
        txtPicAdd.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
        txtPicAdd.setColumns(10);
        txtPicAdd.setBounds(417, 451, 228, 27);
        LayeredPane.add(txtPicAdd);
        
        String companies[]= {"Iphone","Techno","Infinix","Vivo","Pixel","Samsung"};
        JComboBox comboBoxCompany = new JComboBox(companies);
        comboBoxCompany.setBounds(417, 206, 142, 27);
        LayeredPane.add(comboBoxCompany);
        
        JRadioButton radBtnTrue = new JRadioButton("True");
        radBtnTrue.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        radBtnTrue.setBounds(456, 402, 68, 27);
        LayeredPane.add(radBtnTrue);
        
        JRadioButton radBtnFalse = new JRadioButton("False");
        radBtnFalse.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        radBtnFalse.setBounds(538, 402, 74, 27);
        LayeredPane.add(radBtnFalse);
        
        ButtonGroup group = new ButtonGroup();
        group.add(radBtnTrue);
        group.add(radBtnFalse);
        
        JButton btnAdd = new JButton("ADD");
        btnAdd.addActionListener(new ActionListener() 
        {
        	public void actionPerformed(ActionEvent e) 
        	{
        		
        		 JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(addDevice.this);	
        		 
        		 String deviceName=txtName.getText();

        		 String ramInt=txtRam.getText();
        		 int ramSize=Integer.parseInt(ramInt);

        		 String storage=txtStorage.getText();	
        		 int storageSize=Integer.parseInt(storage);

        		 String Processor=txtProcessor.getText();
        		 String availability = getSelectedButtonText(group);
        		 String picture=txtPicAdd.getText();


 	           
    		     String selectedItem = (String) comboBoxCompany.getSelectedItem();
    		     int selectedIndex = comboBoxCompany.getSelectedIndex();
    		     
 	            if (deviceExists(deviceName)) 
 	            {
 	                JOptionPane.showMessageDialog(addDevice.this, "Mobile already Present !  ");
 	   
 	            }
 	            else if (deviceName.isEmpty() || storage.isEmpty() || Processor.isEmpty() || picture.isEmpty() || availability == null || txtRam.getText().isEmpty()) 
 	            {
 	                JOptionPane.showMessageDialog(addDevice.this, "Please fill all fields.");
 	                return; // Exit the method if fields are empty
 	            } 
 	            else 
 	            {
	                deviceData device = new deviceData(  deviceName, selectedItem, ramSize, storageSize, Processor, availability, picture);
	                devices.add(device);
	                // Write user data to CSV file
	                if(selectedIndex == 0)
	                {
	                writeUserToIphoneCSV(device);
	                JOptionPane.showMessageDialog(addDevice.this, "Device Added successfully!");
	                }else if(selectedIndex == 1) {
	                writeUserToTechnoCSV(device);
	                JOptionPane.showMessageDialog(addDevice.this, "Device Added successfully!");
	                }else {
	                	 JOptionPane.showMessageDialog(addDevice.this, "Aukat me Reh!");
	                }
 	            }
 	        }
        });
        
        
        btnAdd.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        btnAdd.setBackground(Color.GRAY);
        btnAdd.setBounds(542, 507, 102, 37);
        LayeredPane.add(btnAdd);
       
        JButton btnBack = new JButton("Back");
        btnBack.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        btnBack.setBackground(Color.GRAY);
        btnBack.setBounds(755, 507, 86, 37);
        btnBack.setBackground(new Color(188, 188, 188));
        LayeredPane.add(btnBack);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to navigate to SignupPanel
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(addDevice.this);
                adminPanel admin = new adminPanel(); // Assuming SignupPanel exists
                frame.getContentPane().removeAll();
                frame.getContentPane().add(admin, BorderLayout.CENTER);
                frame.revalidate();
            }
        });
       
        
        JButton btnClear = new JButton("CLEAR");
        btnClear.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		txtName.setText("");
        	      txtRam.setText("");
        	      txtStorage.setText("");
        	      txtProcessor.setText("");
        	      txtPicAdd.setText("");
        	      // Clear radio button selection (assuming a group is used)
        	      group.clearSelection();
        	}
        });
        btnClear.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        btnClear.setBackground(Color.GRAY);
        btnClear.setBounds(417, 507, 102, 37);
        LayeredPane.add(btnClear);
        
	}
}
