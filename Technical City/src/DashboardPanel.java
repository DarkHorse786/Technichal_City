
import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DashboardPanel extends JPanel {

    public DashboardPanel() 
    	{
    	
    	setLayout(new BorderLayout()); // Use BorderLayout as a base container

        JLayeredPane dasboardPane = new JLayeredPane();
        dasboardPane.setPreferredSize(new Dimension(400, 100)); // Set preferred size
        add(dasboardPane, BorderLayout.CENTER);
        dasboardPane.setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("Search or Filter the Devices");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(322, 11, 349, 38);
        lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
        dasboardPane.add(lblNewLabel_1);
        
        ImageIcon icon = new ImageIcon("D:\\Technical City\\Devices\\iphone12promax.JPG");
        Image image = icon.getImage(); // get the image from the ImageIcon
        Image scaledImage = image.getScaledInstance(180, 150,  java.awt.Image.SCALE_SMOOTH); // scale the image
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
        JButton IPhone = new JButton(scaledImageIcon);
        IPhone.setBounds(98, 91, 180, 150);
        IPhone.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        IPhone.setBackground(new Color(128, 128, 128));
        IPhone.addActionListener(new ActionListener() {
        	
        	
        	public void actionPerformed(ActionEvent e) {
        		JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(DashboardPanel.this);
	            frame.getContentPane().removeAll();
	            try {
					frame.getContentPane().add(new TechnoMobileData("D:\\Technical City\\Iphone.csv"), BorderLayout.CENTER);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            frame.revalidate();
        	}
        });
        dasboardPane.add(IPhone);


        ImageIcon icon2 = new ImageIcon("D:\\\\Technical City\\\\Devices\\\\iphone12promax.JPG");
        Image image2 = icon2.getImage(); // get the image from the ImageIcon
        Image scaledImage2 = image2.getScaledInstance(180, 150,  java.awt.Image.SCALE_SMOOTH); // scale the image
        ImageIcon scaledImageIcon2 = new ImageIcon(scaledImage2);
        JButton Samsung = new JButton(scaledImageIcon2);
        Samsung.setBounds(354, 91, 180, 150);
        Samsung.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        Samsung.setBackground(new Color(128, 128, 128));
    //    Samsung.addActionListener(new SignInButtonListener());
        dasboardPane.add(Samsung); // Add to default layer
        
//      
        
        
        ImageIcon icon3 = new ImageIcon("D:\\Technical City\\Devices\\iphone12promax.JPG");
        Image image3 = icon3.getImage(); // get the image from the ImageIcon
        Image scaledImage3 = image3.getScaledInstance(180, 150,  java.awt.Image.SCALE_SMOOTH); // scale the image
        ImageIcon scaledImageIcon3 = new ImageIcon(scaledImage3);
        JButton Redmi = new JButton(scaledImageIcon3);
        Redmi.setBounds(605, 91, 180, 150);
        Redmi.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        Redmi.setBackground(new Color(128, 128, 128));
    //    Redmi.addActionListener(new SignInButtonListener());
        dasboardPane.add(Redmi); // Add to default layer

        
        ImageIcon icon4 = new ImageIcon("D:\\Technical City\\Devices\\iphone12promax.JPG");
        Image image4 = icon4.getImage(); // get the image from the ImageIcon
        Image scaledImage4 = image4.getScaledInstance(180, 150,  java.awt.Image.SCALE_SMOOTH); // scale the image
        ImageIcon scaledImageIcon4 = new ImageIcon(scaledImage4);
        
        JButton Techno = new JButton(scaledImageIcon4);
       
       
        Techno.setBounds(98, 319, 180, 150);
        Techno.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        Techno.setBackground(new Color(128, 128, 128));
        
        Techno.addActionListener(new ActionListener() {
        	
        	
        	public void actionPerformed(ActionEvent e) {
        		JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(DashboardPanel.this);
	            frame.getContentPane().removeAll();
	            try {
					frame.getContentPane().add(new TechnoMobileData("D:\\Technical City\\Techno.csv"), BorderLayout.CENTER);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            frame.revalidate();
        	}
        });
        dasboardPane.add(Techno); // Add to default layer
               
        
        ImageIcon icon5 = new ImageIcon("D:\\Technical City\\Devices\\iphone12promax.JPG");
        Image image5 = icon5.getImage(); // get the image from the ImageIcon
        Image scaledImage5 = image5.getScaledInstance(180, 150,  java.awt.Image.SCALE_SMOOTH); // scale the image
        ImageIcon scaledImageIcon5 = new ImageIcon(scaledImage5);
        JButton Vivo = new JButton(scaledImageIcon5);
        Vivo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        Vivo.setBounds(354, 319, 180, 150);
        Vivo.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        Vivo.setBackground(new Color(128, 128, 128));
    //    Redmi.addActionListener(new SignInButtonListener());
        dasboardPane.add(Vivo); // Add to default layer
        
        
        ImageIcon icon6 = new ImageIcon("D:\\Technical City\\Devices\\iphone12promax.JPG");
        Image image6 = icon6.getImage(); // get the image from the ImageIcon
        Image scaledImage6 = image6.getScaledInstance(180, 150,  java.awt.Image.SCALE_SMOOTH); // scale the image
        ImageIcon scaledImageIcon6 = new ImageIcon(scaledImage6);
        JButton Infinix = new JButton(scaledImageIcon6);
        Infinix.setBounds(605, 319, 180, 150);
        Infinix.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        Infinix.setBackground(new Color(128, 128, 128));
     //   Redmi.addActionListener(new SignInButtonListener());
        dasboardPane.add(Infinix);
        
        JLabel lblIphone = new JLabel("Iphone");
        lblIphone.setHorizontalAlignment(SwingConstants.CENTER);
        lblIphone.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        lblIphone.setBounds(150, 252, 69, 36);
        dasboardPane.add(lblIphone);
        
        JLabel lblSamsung = new JLabel("Samsung");
        lblSamsung.setHorizontalAlignment(SwingConstants.CENTER);
        lblSamsung.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        lblSamsung.setBounds(406, 252, 69, 36);
        dasboardPane.add(lblSamsung);
        
        JLabel lblRedmi = new JLabel("Redmi");
        lblRedmi.setHorizontalAlignment(SwingConstants.CENTER);
        lblRedmi.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        lblRedmi.setBounds(673, 252, 69, 36);
        dasboardPane.add(lblRedmi);
        
        JLabel lblInfinix = new JLabel("Infinix");
        lblInfinix.setHorizontalAlignment(SwingConstants.CENTER);
        lblInfinix.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        lblInfinix.setBounds(673, 480, 69, 36);
        dasboardPane.add(lblInfinix);
        
        JLabel lblVivo = new JLabel("Vivo");
        lblVivo.setHorizontalAlignment(SwingConstants.CENTER);
        lblVivo.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        lblVivo.setBounds(406, 480, 69, 36);
        dasboardPane.add(lblVivo);
        
        JLabel lblTechno = new JLabel("Tehno");
        lblTechno.setHorizontalAlignment(SwingConstants.CENTER);
        lblTechno.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        lblTechno.setBounds(150, 480, 69, 36);
        
        dasboardPane.add(lblTechno);
        
        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {
        		 // Code to navigate to SignupPanel
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(DashboardPanel.this);
                frame.getContentPane().removeAll();
                frame.getContentPane().add(new SigninPanel(), BorderLayout.CENTER);
                frame.revalidate();
        	}
        });
        btnBack.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        btnBack.setBackground(new Color(188, 188, 188));
        btnBack.setBounds(757, 512, 89, 38);
        dasboardPane.add(btnBack);
        

    }
    
   }

