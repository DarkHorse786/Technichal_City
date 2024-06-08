import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MobileData extends JPanel {



	 private ArrayList<String[]> mobileData;
	
	    private JPanel dataPanel; 
	    private JScrollPane scrollPane;
	    private JTextField searchField;
	    private JButton searchButton;
	    private JComboBox<String> ramFilter;
	    private JComboBox<String> priceFilter;
	    private JButton filterButton;
	    private JButton btnBack;

	    public MobileData(String csvFilePath) throws IOException {
	        this.mobileData = readCSVData(csvFilePath);

	        setLayout(null);

	        JPanel searchPanel = new JPanel();
	        searchPanel.setLayout(null);
	        searchPanel.setBounds(10, 10, 861, 50);
	        add(searchPanel);

	        searchField = new JTextField();
	        searchField.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
	        searchField.setBounds(10, 11, 300, 30);
	        searchPanel.add(searchField);

	        searchButton = new JButton("Search");
	        searchButton.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
	        searchButton.setBackground(new Color(188, 188, 188));
	        searchButton.setBounds(320, 10, 100, 30);
	        searchButton.addActionListener(e -> displaySearchedEntries(searchField.getText()));
	        searchPanel.add(searchButton);

	        ramFilter = new JComboBox<>(new String[]{"All", "4", "6", "8", "12"});
	        ramFilter.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
	        ramFilter.setBounds(430, 11, 100, 30);
	        searchPanel.add(ramFilter);
	        
	        priceFilter = new JComboBox<>(new String[]{"All", "20000", "60000", "80000"});
	        priceFilter.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
	        priceFilter.setBounds(550, 11, 100, 30);
	        searchPanel.add(priceFilter);

	        filterButton = new JButton("Filter");
	        filterButton.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
	        filterButton.setBackground(new Color(188, 188, 188));
	        filterButton.setBounds(660, 10, 100, 30);
	        filterButton.addActionListener(e -> filterEntries());
	        searchPanel.add(filterButton);
	        
	        btnBack = new JButton("Back");
	        btnBack.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                 JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(MobileData.this);
	                 frame.getContentPane().removeAll();
	                 frame.getContentPane().add(new DashboardPanel(), BorderLayout.CENTER);
	                 frame.revalidate();
	            }
	        });
	        btnBack.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
	        btnBack.setBackground(new Color(188, 188, 188));
	        btnBack.setBounds(767, 11, 84, 30);
	        searchPanel.add(btnBack);

	        dataPanel = new JPanel();
	        dataPanel.setLayout(null);

	        scrollPane = new JScrollPane(dataPanel);
	        scrollPane.setBounds(10, 70, 861, 700);
	        add(scrollPane);

	        displayAllEntries();
	    }
	    
	    /////////////////////////////////

	    private ArrayList<String[]> readCSVData(String filePath) throws IOException {
	        ArrayList<String[]> data = new ArrayList<>();
	        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                data.add(line.split(","));
	            }
	        }
	        return data;
	    }

	    private void displayAllEntries() {
	        dataPanel.removeAll();
	        int yPosition = 40;

	        for (String[] mobileInfo : mobileData) {
	            yPosition = addMobileEntry(dataPanel, mobileInfo, yPosition);
	        }

	        dataPanel.setPreferredSize(new Dimension(960, yPosition)); 
	        dataPanel.revalidate();
	        dataPanel.repaint();
	    }

	    private void displaySearchedEntries(String query) {
	        dataPanel.removeAll();
	        int yPosition = 10; 

	        for (String[] mobileInfo : mobileData) {
	            if (mobileInfo[0].toLowerCase().contains(query.toLowerCase())) {
	                yPosition = addMobileEntry(dataPanel, mobileInfo, yPosition);
	            }
	        }

	        dataPanel.setPreferredSize(new Dimension(960, yPosition)); 
	        dataPanel.revalidate();
	        dataPanel.repaint();
	    }

	    private void filterEntries() {
	        String query = searchField.getText().toLowerCase();
	        String selectedRam = ramFilter.getSelectedItem().toString();

	        dataPanel.removeAll();
	        int yPosition = 10; 

	        for (String[] mobileInfo : mobileData) {
	            boolean matchesSearch = mobileInfo[0].toLowerCase().contains(query.toLowerCase());
	            boolean matchesRam = selectedRam.equals("All") || mobileInfo[3].contains(selectedRam);
	            if (matchesSearch && matchesRam) {
	                yPosition = addMobileEntry(dataPanel, mobileInfo, yPosition);
	            }
	        }

	        dataPanel.setPreferredSize(new Dimension(960, yPosition)); 
	        dataPanel.revalidate();
	        dataPanel.repaint();
	    }

	    private int addMobileEntry(JPanel panel, String[] mobileInfo, int yPosition) {
	        JLabel imgBtn = new JLabel();
	        imgBtn.setBounds(150, yPosition, 150, 150); 
	        String imagePath = mobileInfo[6]; 

	        ImageIcon icon;
	        try {
	            File imgFile = new File(imagePath);
	            if (imgFile.exists()) {
	                icon = new ImageIcon(imagePath);
	                Image image = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
	                imgBtn.setIcon(new ImageIcon(image));
	            } else {
	                throw new IOException("Image not found");
	            }
	        } catch (Exception e) {
	            String placeholderPath = "D:\\Technical City\\Devices\\Spark 6.jpg";
	            icon = new ImageIcon(placeholderPath);
	            Image image = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	            imgBtn.setIcon(new ImageIcon(image));
	        }
	        panel.add(imgBtn);

	        JLabel[] labels = new JLabel[]{
	                new JLabel("Device Name:"),
	                new JLabel("Company Name:"),
	                new JLabel("Storage Size:"),
	                new JLabel("Size of RAM:"),
	                new JLabel("Availability:"),
	                new JLabel("Processor:")
	        };

	        JTextField[] textFields = new JTextField[labels.length];
	        for (int i = 0; i < labels.length; i++) {
	            labels[i].setHorizontalAlignment(SwingConstants.LEFT);
	            labels[i].setFont(new Font("Trebuchet MS", Font.BOLD, 16));
	            labels[i].setBounds(320, yPosition + i * 30, 150, 19);
	            panel.add(labels[i]);

	            textFields[i] = new JTextField(mobileInfo[i]);
	            textFields[i].setBounds(480, yPosition + i * 30, 200, 19);
	            textFields[i].setEditable(false); 
	            panel.add(textFields[i]);
	        }

	        return yPosition + 200; 
	    }
  
}