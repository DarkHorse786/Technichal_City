

///////////////////////////////////////////////////////////////
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

public class IphoneMobileData extends JPanel {

  private ArrayList<String[]> mobileData; // Stores data from CSV file
  private JPanel dataPanel; // Panel to display mobile data
  private JScrollPane scrollPane; // Scroll pane to hold the data panel
  private JTextField searchField; // Search field for entering the device name
  private JButton btnBack;

  public IphoneMobileData(String csvFilePath) throws IOException {
      this.mobileData = readCSVData(csvFilePath);

      setLayout(null); // Use null layout for manual positioning

      // Create a search panel
      JPanel searchPanel = new JPanel();
      searchPanel.setLayout(null);
      searchPanel.setBounds(10, 10, 990, 50);
      add(searchPanel);

      searchField = new JTextField();
      searchField.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
      searchField.setBounds(300, 10, 300, 30);
      searchPanel.add(searchField);

      JButton searchButton = new JButton("Search");
      searchButton.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
      searchButton.setBackground(new Color(188, 188, 188));
      searchButton.setBounds(610, 10, 100, 30);
      searchButton.addActionListener(e -> displaySearchedEntries(searchField.getText()));
      searchPanel.add(searchButton);
      
      btnBack = new JButton("Back");
      btnBack.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(IphoneMobileData.this);
	            frame.getContentPane().removeAll();
	            DashboardPanel d = new DashboardPanel(); // Assuming WelcomePanel exists
	            frame.getContentPane().add(d, BorderLayout.CENTER);
	            frame.revalidate();
      	}
      });
      btnBack.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
      btnBack.setBackground(new Color(188, 188, 188));
      btnBack.setBounds(811, 9, 79, 30);
      searchPanel.add(btnBack);

      // Create a scrollable panel to hold multiple mobile data entries
      dataPanel = new JPanel();
      dataPanel.setLayout(null); // Use null layout for manual positioning

      scrollPane = new JScrollPane(dataPanel);
      scrollPane.setBounds(10, 70, 990, 700); // Adjust as needed
      add(scrollPane);

      displayAllEntries();
  }

  private ArrayList<String[]> readCSVData(String filePath) throws IOException {
      ArrayList<String[]> data = new ArrayList<>();
      try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
          String line;
          while ((line = br.readLine()) != null) {
              data.add(line.split(",")); // Assuming CSV columns are separated by commas
          }
      }
      return data;
  }

  private void displayAllEntries() {
      dataPanel.removeAll();
      int yPosition = 40; // Initial vertical position

      for (String[] mobileInfo : mobileData) {
          yPosition = addMobileEntry(dataPanel, mobileInfo, yPosition);
      }

      dataPanel.setPreferredSize(new Dimension(960, yPosition)); // Set preferred size based on content
      dataPanel.revalidate();
      dataPanel.repaint();
  }

  private void displaySearchedEntries(String query) {
      dataPanel.removeAll();
      int yPosition = 10; // Initial vertical position

      for (String[] mobileInfo : mobileData) {
          if (mobileInfo[0].toLowerCase().contains(query.toLowerCase())) {
              yPosition = addMobileEntry(dataPanel, mobileInfo, yPosition);
          }
      }

      dataPanel.setPreferredSize(new Dimension(960, yPosition)); // Set preferred size based on content
      dataPanel.revalidate();
      dataPanel.repaint();
  }

  private int addMobileEntry(JPanel panel, String[] mobileInfo, int yPosition) 
  {
      // Create and set up the image label
      JLabel imgBtn = new JLabel();
      imgBtn.setBounds(150, yPosition, 150, 150); // Adjust size as needed
      String imagePath = mobileInfo[6]; // Assuming image path is at index 6

      // Load the image or use a placeholder if an exception occurs
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
      } 
      catch (Exception e) 
      {
          // Use a placeholder image (replace with a valid placeholder path)
          String placeholderPath = "D:\\Technical City\\Devices\\Spark 6.jpg";
          icon = new ImageIcon(placeholderPath);
          Image image = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
          imgBtn.setIcon(new ImageIcon(image));
      }

      panel.add(imgBtn);

      JLabel[] labels = new JLabel[]{
              new JLabel("Device Name:"),
              new JLabel("Select Company:"),
              new JLabel("Size of RAM:"),
              new JLabel("Storage Size:"),
              new JLabel("Processor:"),
              new JLabel("Availability:")
      };

      JTextField[] textFields = new JTextField[labels.length];
      for (int i = 0; i < labels.length; i++) {
          labels[i].setHorizontalAlignment(SwingConstants.LEFT);
          labels[i].setFont(new Font("Trebuchet MS", Font.BOLD, 16));
          labels[i].setBounds(320, yPosition + i * 30, 150, 19);
          panel.add(labels[i]);

          textFields[i] = new JTextField(mobileInfo[i]);
          textFields[i].setBounds(480, yPosition + i * 30, 200, 19);
          textFields[i].setEditable(false); // Make text fields read-only
          panel.add(textFields[i]);
      }

      return yPosition + 200; // Increment vertical position for next entry
  }

  public static void main(String[] args) {
      SwingUtilities.invokeLater(() -> {
          try {
              // Specify the path to your CSV file here
              String csvFilePath = "D:\\Technical City\\Iphone.csv";
              JFrame frame = new JFrame("Techno Mobile Data");
              frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              frame.setBounds(130, 30, 900, 600);
              frame.getContentPane().add(new TechnoMobileData(csvFilePath));
              frame.setVisible(true);
          } catch (IOException e) {
              e.printStackTrace();
          }
      });
  }
}
