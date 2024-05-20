import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;


public class adminPanel extends JPanel
{

    public adminPanel()
    {
    	setLayout(new BorderLayout()); // Use BorderLayout as a base container

        JLayeredPane LayeredPane = new JLayeredPane();
        LayeredPane.setPreferredSize(new Dimension(400, 100)); // Set preferred size
        add(LayeredPane, BorderLayout.CENTER);
        
        JLabel lblAdmin = new JLabel("Admin DashBoard");
        lblAdmin.setFont(new Font("Trebuchet MS", Font.BOLD, 28));
        lblAdmin.setBounds(355, 20, 255, 58);
        LayeredPane.add(lblAdmin);
        

        
        JButton btnAddDevice = new JButton("Add Device");
        btnAddDevice.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        btnAddDevice.setBackground(new Color(128, 128, 128));
        btnAddDevice.setBounds(399, 156, 152, 45);
        btnAddDevice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to navigate to AddDevice
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(adminPanel.this);
                addDevice AddDevice = new addDevice(); // Assuming SignupPanel exists
                frame.getContentPane().removeAll();
                frame.getContentPane().add(AddDevice, BorderLayout.CENTER);
                frame.revalidate();
            }
        });
        LayeredPane.add(btnAddDevice, JLayeredPane.DEFAULT_LAYER); // Add to default layer
        
        
        JButton btnRemove_UpdateDevice = new JButton("Remove/Update Device");
        btnRemove_UpdateDevice.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        btnRemove_UpdateDevice.setBackground(Color.GRAY);
        btnRemove_UpdateDevice.setBounds(355, 244, 241, 45);
        btnRemove_UpdateDevice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to navigate to SignupPanel
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(adminPanel.this);
                remove_updateDevice Remove_updateDevice = new remove_updateDevice(); // Assuming SignupPanel exists
                frame.getContentPane().removeAll();
                frame.getContentPane().add(Remove_updateDevice, BorderLayout.CENTER);
                frame.revalidate();
            }
        });
        LayeredPane.add(btnRemove_UpdateDevice);
        
        
        JButton btnBack = new JButton("Back");
        btnBack.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        btnBack.setBackground(Color.GRAY);
        btnBack.setBounds(431, 355, 86, 37);
        btnBack.setBackground(new Color(188, 188, 188));
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to navigate to SignupPanel
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(adminPanel.this);
                SigninPanel signinPanel = new SigninPanel(); // Assuming SignupPanel exists
                frame.getContentPane().removeAll();
                frame.getContentPane().add(signinPanel, BorderLayout.CENTER);
                frame.revalidate();
            }
        });
        LayeredPane.add(btnBack);
        
      
    }
}
