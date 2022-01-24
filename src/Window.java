import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Window extends JFrame implements ActionListener{
	
	private String PASS = "root"; //bad security

	private JPanel loginPanel;
	private JPanel header;
	private JPanel mainPanel;
	
	private int wid = 500, hei = 500;
	
	
	private JTextField loginText;
	private JLabel loginLabel;
	private JLabel passwordLabel;
	private JPasswordField passwordText;
	private String[] lang = {"English","Français"};
	private JComboBox<String> languageComboBox;
	private JButton loginButton;
	private JButton homePageButton;
	private JButton stockManagementButton;
	private JButton patientButton;
	private JButton staffButton;
	private JButton disconnectButton;
	
	
	public Window() {
		
		homePageButton = new JButton("Home");
		stockManagementButton = new JButton("Stocks");
		patientButton = new JButton("Patients");
		staffButton = new JButton("Staff");
		disconnectButton = new JButton("Disconnect");
		languageComboBox = new JComboBox<String>(lang);	
		languageComboBox.setMaximumSize(new Dimension(1920, 30));
		
		this.setSize(wid,hei);
		this.setMinimumSize(new Dimension(wid,hei));
		
		this.setTitle("Safeguard");
		
		header = new JPanel();
		
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		header.add(homePageButton);
		header.add(stockManagementButton);
		header.add(patientButton);
		header.add(staffButton);
		header.add(languageComboBox);
		header.add(disconnectButton);
		
		mainPanel = new JPanel();
		mainPanel.add(header);
		
		
			
		
		loginPanel = new JPanel();
		
		
		loginPanel.add(languageComboBox);
		loginPanel.add(Box.createRigidArea(new Dimension(0,this.getHeight()/6)));
		loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.PAGE_AXIS));
		
		loginLabel = new JLabel("Login : ");
		loginText=new JTextField();
		passwordLabel = new JLabel("Password : ");
		passwordText = new JPasswordField();
		
		loginText.setMaximumSize(new Dimension(1920, 30));
		passwordText.setMaximumSize(new Dimension(1920, 30));
		passwordText.setVisible(true);
		
		loginPanel.add(loginLabel);
		loginPanel.add(loginText);
		loginPanel.add(passwordLabel);
		loginPanel.add(passwordText);
		
		loginButton = new JButton("Login");
		loginButton.setMaximumSize(new Dimension(1920, 30));
		loginButton.addActionListener(this);
		
		loginPanel.add(Box.createRigidArea(new Dimension(200,this.getHeight()/6)));
		loginPanel.add(loginButton);
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setContentPane(loginPanel);
		
		
		this.setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == loginButton) {
			if(loginText.getText().equals("root") && PASS.equals(String.valueOf(passwordText.getPassword()))) {
				initializeContent(mainPanel);
			}
		}else if(e.getSource() == homePageButton) {
			initializeContent(loginPanel);
		}
	}
	
	private void initializeContent(JPanel jp) {
		this.setSize(wid,hei);
		this.setMinimumSize(new Dimension(wid,hei));
		
		this.setContentPane(jp);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(new JPanel());
		this.setVisible(true);
	}
	

}


