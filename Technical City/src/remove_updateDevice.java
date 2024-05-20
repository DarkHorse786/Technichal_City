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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.ButtonGroup;

public class remove_updateDevice extends JPanel {
    private JTextField txtName;
    private JTextField txtRam;
    private JTextField txtStorage;
    private JTextField txtProcessor;
    private JTextField txtPicAdd;

    public remove_updateDevice() {
        setLayout(new BorderLayout()); // Use BorderLayout as a base container

        JLayeredPane LayeredPane = new JLayeredPane();
        LayeredPane.setPreferredSize(new Dimension(400, 100)); // Set preferred size
        add(LayeredPane, BorderLayout.CENTER);

        JLabel lblremove = new JLabel("-: Remove or Update Device :-");
        lblremove.setHorizontalAlignment(SwingConstants.CENTER);
        lblremove.setFont(new Font("Trebuchet MS", Font.BOLD, 28));
        lblremove.setBounds(254, 11, 452, 58);
        LayeredPane.add(lblremove);

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

        txtRam = new JTextField();
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

        String companies[] = {"Iphone", "Samsung", "Infinix", "Vivo", "Pixel", "Techno"};
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
        
        JButton btnFindDevice = new JButton("Find Device");
        btnFindDevice.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        btnFindDevice.setBackground(Color.GRAY);
        btnFindDevice.setBounds(190, 507, 132, 37);
        LayeredPane.add(btnFindDevice);

        btnFindDevice.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            String deviceName = txtName.getText();
            String selectedItem = (String) comboBoxCompany.getSelectedItem();
            String filePath = "D:\\Technical City\\" + selectedItem + ".csv";

            try {
              // Read existing data from the CSV file
              ArrayList<String> deviceList = new ArrayList<>();
              BufferedReader reader = new BufferedReader(new FileReader(filePath));
              String line;
              while ((line = reader.readLine()) != null) {
                deviceList.add(line);
              }
              reader.close();

              // Search for the device and fill the form if found
              boolean deviceFound = false;
              for (int i = 0; i <= deviceList.size(); i++) {
                String[] deviceData = deviceList.get(i).split(",");
                if (deviceData[0].equals(deviceName)) {
                  txtName.setText(deviceData[0]);
                  // Set the selected company based on the data (assuming company is in the second column)
                  comboBoxCompany.setSelectedItem(deviceData[1]);
                  txtRam.setText(deviceData[2]);
                  txtStorage.setText(deviceData[3]);
                  txtProcessor.setText(deviceData[4]);
                  // Assuming availability is in the fifth column (set other fields based on data structure)
                  String availability = deviceData[5];
                  if (availability.equals("True")) {
                    radBtnTrue.setSelected(true);
                  } else {
                    radBtnFalse.setSelected(true);
                  }
             //    xtPicAdd.setText(deviceData.length > 6 ? deviceData[6] : "");
                  txtPicAdd.setText(deviceData[6]); // Assuming picture path is in the seventh column
                  deviceFound = true;
                  break;
                }
              }

              if (deviceFound) {
                JOptionPane.showMessageDialog(remove_updateDevice.this, "Device details found!");
              } else {
                JOptionPane.showMessageDialog(remove_updateDevice.this, "Device not found!");
                // Clear form fields if device not found (optional)
                txtName.setText("");
                txtRam.setText("");
                txtStorage.setText("");
                txtProcessor.setText("");
                radBtnTrue.setSelected(false);
                radBtnFalse.setSelected(false);
                txtPicAdd.setText("");
              }
            } catch (IOException ex) {
              ex.printStackTrace();
              JOptionPane.showMessageDialog(remove_updateDevice.this, "Error accessing data!");
            }
          }
        });
        
        JButton btnUpdate = new JButton("Update");
        btnUpdate.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        btnUpdate.setBackground(Color.GRAY);
        btnUpdate.setBounds(422, 507, 102, 37); // Adjust position as needed
        LayeredPane.add(btnUpdate);

        btnUpdate.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            String deviceName = txtName.getText();
            String selectedItem = (String) comboBoxCompany.getSelectedItem();
            String filePath = "D:\\Technical City\\" + selectedItem + ".csv";

            // Check if device was found before updating
            if (!txtName.getText().isEmpty()) {
              // Update logic
              try {
                // Read existing data from the CSV file
                ArrayList<String> deviceList = new ArrayList<>();
                BufferedReader reader = new BufferedReader(new FileReader(filePath));
                String line;
                while ((line = reader.readLine()) != null) {
                  deviceList.add(line);
                }
                reader.close();

                boolean deviceFound = false;
                for (int i = 0; i < deviceList.size(); i++) {
                  String[] deviceData = deviceList.get(i).split(",");
                  if (deviceData[0].equals(deviceName)) {
                    // Update device details in the list
                    deviceData[1] = (String) comboBoxCompany.getSelectedItem(); // Update company
                    deviceData[2] = txtRam.getText(); // Update RAM
                    deviceData[3] = txtStorage.getText(); // Update storage
                    deviceData[4] = txtProcessor.getText(); // Update processor
                    String availability = radBtnTrue.isSelected() ? "True" : "False";
                    deviceData[5] = availability; // Update availability
                    deviceData[6] = txtPicAdd.getText(); // Update picture path

                    deviceList.set(i, String.join(",", deviceData)); // Update the line in the list
                    deviceFound = true;
                    break;
                  }
                }

                // Write the updated list back to the CSV file
                if (deviceFound) {
                  FileWriter writer = new FileWriter(filePath);
                  for (String device : deviceList) {
                    writer.write(device + "\n");
                  }
                  writer.close();
                  JOptionPane.showMessageDialog(remove_updateDevice.this, "Device updated successfully!");
                } else {
                  JOptionPane.showMessageDialog(remove_updateDevice.this, "Device not found!");
                }
              } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(remove_updateDevice.this, "Error accessing data!");
              }
            } else {
              JOptionPane.showMessageDialog(remove_updateDevice.this, "Please find the device first!");
            }
          }
        });

        JButton btnRemove = new JButton("Remove");
        btnRemove.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        btnRemove.setBackground(Color.GRAY);
        btnRemove.setBounds(542, 507, 102, 37);
        LayeredPane.add(btnRemove);

        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String deviceName = txtName.getText();
                String selectedItem = (String) comboBoxCompany.getSelectedItem();
                String filePath = "D:\\Technical City\\" + selectedItem + ".csv";

                try {
                    // Read existing data from the CSV file
                    ArrayList<String> deviceList = new ArrayList<>();
                    BufferedReader reader = new BufferedReader(new FileReader(filePath));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        deviceList.add(line);
                    }
                    reader.close();

                    // Search for the device and remove it if found
                    boolean deviceFound = false;
                    for (int i = 0; i < deviceList.size(); i++) {
                        String[] deviceData = deviceList.get(i).split(",");
                        if (deviceData[0].equals(deviceName)) {
                            deviceList.remove(i);
                            deviceFound = true;
                            break;
                        }
                    }

                    // Write the updated list back to the CSV file
                    FileWriter writer = new FileWriter(filePath);
                    for (String device : deviceList) {
                        writer.write(device + "\n");
                    }
                    writer.close();

                    if (deviceFound) 
                    {
                        JOptionPane.showMessageDialog(remove_updateDevice.this, "Device removed successfully!");
                    } 
                    else 
                    {
                        JOptionPane.showMessageDialog(remove_updateDevice.this, "Device not found!");
                    }
                } catch (IOException ex) 
                {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(remove_updateDevice.this, "Error accessing data!");
                }
                	txtName.setText("");
	      	      txtRam.setText("");
	      	      txtStorage.setText("");
	      	      txtProcessor.setText("");
	      	      txtPicAdd.setText("");
	      	      // Clear radio button selection (assuming a group is used)
	      	      group.clearSelection();
            }
        });

        JButton btnBack = new JButton("Back");
        btnBack.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        btnBack.setBackground(Color.GRAY);
        btnBack.setBounds(755, 507, 86, 37);
        btnBack.setBackground(new Color(188, 188, 188));
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to navigate to SignupPanel
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(remove_updateDevice.this);
                adminPanel admin = new adminPanel(); // Assuming SignupPanel exists
                frame.getContentPane().removeAll();
                frame.getContentPane().add(admin, BorderLayout.CENTER);
                frame.revalidate();
            }
        });
        LayeredPane.add(btnBack);
    }

}
