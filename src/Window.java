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

	private int wid = 500, hei = 500;
	
	//login
	private JPanel loginPanel;
	private JTextField loginText;
	private JLabel loginLabel;
	private JLabel passwordLabel;
	private JPasswordField passwordText;
	
	//header
	private JPanel header;
	private String[] lang = {"English","Français"};
	private JComboBox<String> languageComboBox;
	private JButton loginButton;
	private JButton homePageButton;
	private JButton stockManagementButton;
	private JButton patientButton;
	private JButton staffButton;
	private JButton disconnectButton;
	
	//home
	private JPanel homePanel;
	private JLabel dailyStatsLabel;
	
	//stocks
	private JPanel stockPanel;
	
	//staff
	private JPanel staffPanel;
	
	//patients
	private JPanel patientPanel;
	
	public Window() {
		
		this.setSize(wid,hei);
		this.setMinimumSize(new Dimension(wid,hei));
		
		this.setTitle("Safeguard");
		
		//instantiations
		homePageButton = new JButton("Home");
		homePageButton.addActionListener(this);
		stockManagementButton = new JButton("Stocks");
		stockManagementButton.addActionListener(this);
		patientButton = new JButton("Patients");
		patientButton.addActionListener(this);
		staffButton = new JButton("Staff");
		staffButton.addActionListener(this);
		disconnectButton = new JButton("Disconnect");
		disconnectButton.addActionListener(this);
		languageComboBox = new JComboBox<String>(lang);	
		languageComboBox.setMaximumSize(new Dimension(1920, 30));
		
		dailyStatsLabel = new JLabel("Daily Stats :");
		
		//header
		header = new JPanel();
		
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		header.add(homePageButton);
		header.add(stockManagementButton);
		header.add(patientButton);
		header.add(staffButton);
		header.add(languageComboBox);
		header.add(disconnectButton);
		//end header
		
		//home
		homePanel = new JPanel();
		homePanel.setLayout(new BoxLayout(homePanel, BoxLayout.Y_AXIS));
		//end home
		
		//stock
		stockPanel = new JPanel();
		stockPanel.setLayout(new BoxLayout(stockPanel, BoxLayout.Y_AXIS));
		//end stock
		
		//staff
		staffPanel = new JPanel();
		staffPanel.setLayout(new BoxLayout(staffPanel, BoxLayout.Y_AXIS));
		//end staff
		
		//patients
		patientPanel = new JPanel();
		patientPanel.setLayout(new BoxLayout(staffPanel, BoxLayout.Y_AXIS));
		//end patients
			
		// login
		loginPanel = new JPanel();
		
		loginPanel.add(languageComboBox);
//		loginPanel.add(Box.createRigidArea(new Dimension(0,this.getHeight()/6)));
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
		
//		loginPanel.add(Box.createRigidArea(new Dimension(200,this.getHeight()/6)));
		loginPanel.add(loginButton);
		//end login
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setContentPane(loginPanel);
		
		this.setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == loginButton) {
			if(loginText.getText().equals("root") && PASS.equals(String.valueOf(passwordText.getPassword()))) {
				loginText.setText("");
				passwordText.setText("");
				initHomePanel();
			}
		}else if(e.getSource() == disconnectButton) {
			initLoginPanel();
		}else if(e.getSource() == homePageButton) {
			initHomePanel();
		}else if(e.getSource() == stockManagementButton){
			initStockPanel();
		}else if(e.getSource() == patientButton) {
			initPatientPanel();
		}else if(e.getSource() == staffButton) {
			initStaffPanel();
		}

	}	
	
	private void initStaffPanel() {
		staffPanel.add(header);
		this.setContentPane(staffPanel);
		this.revalidate();
	}


	private void initPatientPanel() {
		patientPanel.add(header);
		this.setContentPane(patientPanel);
		this.revalidate();
	}


	private void initHomePanel() {
		homePanel.add(header);
		homePanel.add(dailyStatsLabel);
		this.setContentPane(homePanel);
		this.revalidate();
	}
	
	private void initLoginPanel() {
		loginPanel.add(languageComboBox);
		loginPanel.add(loginLabel);
		loginPanel.add(loginText);
		loginPanel.add(passwordLabel);
		loginPanel.add(passwordText);
		loginPanel.add(loginButton);
		this.setContentPane(loginPanel);
		this.revalidate();
	}
	
	private void initStockPanel() {
		stockPanel.add(header);
		this.setContentPane(stockPanel);
		this.revalidate();
	}

}


