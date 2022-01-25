import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;

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
	private JPanel bottomLine;
	private JLabel dateLabel;
	private JTextField dateField;
	private JLabel stockLabel;
	private JLabel nbMaskLabel;
	private JLabel nbPcrLabel;
	private JLabel nbAntigenLabel;
	private JLabel nbVacPfizerLabel;
	private JLabel nbVaccineModernaLabel;
	private JLabel stockModLabel;
	private JTextField newStockField;
	private String[] stockStr = {"Mask","PCR","Antigen","Pfizer","Moderna"};
	private String currentDay;
	private JComboBox<String> stockComboBox;
	private JButton submitStocksButton;
	
	//staff
	private JPanel staffPanel;
	
	//patients
	private JPanel patientPanel;
	private JPanel patientResearchPanel;
	private JLabel patientResearchLabel;
	private JTextField patientResearchField, 
		patientLastNameField, 
		patientFirstNameField,
		patientPhoneNbField, 
		patientIDField, 
		patientVaccineTypeField, 
		patientLastDoseDateField, 
		patientMailField, 
		patientAddressField, 
		patientCoverageField;
	private JButton patientResearchButton, patientSubmitButton;
	private JLabel patientLastNameLabel, 
		patientFirstNameLabel, 
		patientPhoneNbLabel, 
		patientIDLabel, 
		patientVaccineTypeLabel, 
		patientLastDoseDateLabel, 
		patientMailLabel, 
		patientAddressLabel, 
		patientCoverageLabel;
	
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
		
		dateLabel = new JLabel("date :");
		dateField = new JTextField();
		dateField.setMaximumSize(new Dimension(1920, 30));
		stockLabel = new JLabel("Stocks of the day :");
		stockModLabel = new JLabel("Stock modification");
		stockComboBox = new JComboBox<String>(stockStr);
		stockComboBox.setMaximumSize(new Dimension(1920, 30));
		
		nbMaskLabel = new JLabel();
		nbMaskLabel.setMaximumSize(new Dimension(1920, 30));
		nbPcrLabel = new JLabel();
		nbAntigenLabel = new JLabel();
		nbVacPfizerLabel = new JLabel();
		nbVaccineModernaLabel = new JLabel();
		
		newStockField =new JTextField();
		newStockField.setMaximumSize(new Dimension(1920, 30));
		newStockField.addKeyListener((KeyListener) new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
					newStockField.setEditable(true);
				} else {
					newStockField.setEditable(false);
				}
			}
		});
		submitStocksButton =new JButton("Submit");
		submitStocksButton.addActionListener(this);
		bottomLine =new JPanel();
		bottomLine.setLayout(new BoxLayout(bottomLine, BoxLayout.X_AXIS));
		bottomLine.add(stockModLabel);
		bottomLine.add(newStockField);
		bottomLine.add(stockComboBox);
		bottomLine.add(submitStocksButton);
		
		patientResearchLabel = new JLabel("Research panel :");
		patientResearchField = new JTextField();
		patientResearchField.setMaximumSize(new Dimension(1920, 30));
		
		patientLastNameField= new JTextField();
		patientFirstNameField= new JTextField();
		patientPhoneNbField= new JTextField();
		patientIDField= new JTextField();
		patientVaccineTypeField= new JTextField();
		patientLastDoseDateField= new JTextField();
		patientMailField= new JTextField();
		patientAddressField= new JTextField();
		patientCoverageField= new JTextField();
		
		patientLastNameField.setMaximumSize(new Dimension(1920, 30));
		patientFirstNameField.setMaximumSize(new Dimension(1920, 30));
		patientPhoneNbField.setMaximumSize(new Dimension(1920, 30));
		patientIDField.setMaximumSize(new Dimension(1920, 30));
		patientVaccineTypeField.setMaximumSize(new Dimension(1920, 30));
		patientLastDoseDateField.setMaximumSize(new Dimension(1920, 30));
		patientMailField.setMaximumSize(new Dimension(1920, 30));
		patientAddressField.setMaximumSize(new Dimension(1920, 30));
		patientCoverageField.setMaximumSize(new Dimension(1920, 30));
		
		patientResearchButton = new JButton("Research");
		patientResearchButton.addActionListener(this);
		patientSubmitButton = new JButton("Submit");
		patientSubmitButton.addActionListener(this);
		patientLastNameLabel = new JLabel("Last Name"); 
		patientFirstNameLabel = new JLabel("First Name");
		patientPhoneNbLabel = new JLabel("Phone Number");
		patientIDLabel = new JLabel("ID");
		patientVaccineTypeLabel = new JLabel("Vaccine Type");
		patientLastDoseDateLabel = new JLabel("Last Dose Date");
		patientMailLabel = new JLabel("Mail");
		patientAddressLabel = new JLabel("Address");
		patientCoverageLabel = new JLabel("Coverage");
		
		patientResearchPanel = new JPanel();
		patientResearchPanel.setLayout(new BoxLayout(patientResearchPanel, BoxLayout.X_AXIS));
		patientResearchPanel.add(patientResearchLabel);
		patientResearchPanel.add(patientResearchField);
		patientResearchPanel.add(patientResearchButton);
		
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
		patientPanel.setLayout(new BoxLayout(patientPanel, BoxLayout.Y_AXIS));
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
			try {
				initStockPanel();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("error stocks");
			}
		}else if(e.getSource() == patientButton) {
			initPatientPanel();
		}else if(e.getSource() == staffButton) {
			initStaffPanel();
		}else if(e.getSource() == submitStocksButton) {
			if(!newStockField.getText().toString().equals("") == !dateField.getText().toString().equals("")) {
				String s = String.valueOf(stockComboBox.getSelectedItem());
				try {
					switch(s) {
					case "Mask":
						Stock.replaceMask(Integer.parseInt(newStockField.getText().toString()));
						break;
					case "Pfizer":
						Stock.replaceVaccinFizer(Integer.parseInt(newStockField.getText().toString()));
						break;
					case "Moderna":
						Stock.replaceVaccinModerna(Integer.parseInt(newStockField.getText().toString()));
						break;
					case "PCR":
						Stock.replaceTestPcr(Integer.parseInt(newStockField.getText().toString()));
						break;
					case "Antigen":
						Stock.replaceTestAnti(Integer.parseInt(newStockField.getText().toString()));
						break;

					}
				}catch(NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					initStockPanel();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}else if(e.getSource() == patientResearchButton) {
			initPatientPanel();
		}else if(e.getSource() == patientSubmitButton) {
			
		}

	}	
	
	private void initStaffPanel() {
		staffPanel.add(header);
		this.setContentPane(staffPanel);
		this.revalidate();
	}


	private void initPatientPanel() {
		patientPanel.add(header);
		patientPanel.add(patientResearchPanel);
		patientPanel.add(patientLastNameLabel);
		patientPanel.add(patientLastNameField);
		patientPanel.add(patientFirstNameLabel);
		patientPanel.add(patientFirstNameField);
		patientPanel.add(patientPhoneNbLabel);
		patientPanel.add(patientPhoneNbField);
		patientPanel.add(patientIDLabel);
		patientPanel.add(patientIDField);
		patientPanel.add(patientVaccineTypeLabel);
		patientPanel.add(patientVaccineTypeField);
		patientPanel.add(patientLastDoseDateLabel);
		patientPanel.add(patientLastDoseDateField);
		patientPanel.add(patientMailLabel);
		patientPanel.add(patientMailField);
		patientPanel.add(patientAddressLabel);
		patientPanel.add(patientAddressField);
		patientPanel.add(patientCoverageLabel);
		patientPanel.add(patientCoverageField);
		
		patientPanel.add(patientSubmitButton);
		
		
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
	
	private void initStockPanel() throws SQLException {
		stockPanel.add(header);
		stockPanel.add(stockLabel);
		stockPanel.add(dateLabel);
		stockPanel.add(dateField);
		if(dateField.getText().toString().equals("")) {
			dateField.setText("2022-01-24");
		}
		currentDay  = dateField.getText().toString();
		int tempVar = Stock.getMaskByDay(currentDay);
		nbMaskLabel.setText("Number of masks : "+String.valueOf(tempVar));
		stockPanel.add(nbMaskLabel);
		
		tempVar = Stock.getTestPcrByDay(currentDay);
		nbPcrLabel.setText("Number of PCR tests : "+String.valueOf(tempVar));
		stockPanel.add(nbPcrLabel);
		
		tempVar = Stock.getTestAntiByDay(currentDay);
		nbAntigenLabel.setText("Number of Antigen tests : "+String.valueOf(tempVar));
		stockPanel.add(nbAntigenLabel);
		
		tempVar = Stock.getVaccinFizerByDay(currentDay);
		nbVacPfizerLabel.setText("Number of Pfizer Vaccines : "+String.valueOf(tempVar));
		stockPanel.add(nbVacPfizerLabel);
		
		tempVar = Stock.getVaccinModernaByDay(currentDay);
		nbVaccineModernaLabel.setText("Number of Moderna Vaccines : "+String.valueOf(tempVar));
		stockPanel.add(nbVaccineModernaLabel);
		
		stockPanel.add(bottomLine);

		this.setContentPane(stockPanel);
		
		this.revalidate();
//		System.out.println("stocks updated");
	}

}


