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
import javax.swing.JTextField;

public class Window extends JFrame implements ActionListener{

	private JPanel containerPanel;
	
	private JTextField loginText;
	private JLabel loginLabel;
	private JLabel passwordLabel;
	private JTextField passwordText;
	private String[] lang = {"English","Français"};
	private JComboBox<String> languageComboBox;
	private JButton loginButton;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public Window() {
		this.setSize(300,300);
		this.setMinimumSize(new Dimension(300,300));
		
		this.setTitle("Safeguard");
		
		languageComboBox = new JComboBox<String>(lang);		
		
		containerPanel = new JPanel();
		
		languageComboBox.setMaximumSize(new Dimension(1920, 30));
		containerPanel.add(languageComboBox);
		containerPanel.add(Box.createRigidArea(new Dimension(0,this.getHeight()/6)));
		containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.PAGE_AXIS));
		
		loginLabel = new JLabel("Login : ");
		loginText=new JTextField();
		passwordLabel = new JLabel("Password : ");
		passwordText = new JTextField();
		
		loginText.setMaximumSize(new Dimension(1920, 30));
		passwordText.setMaximumSize(new Dimension(1920, 30));
		passwordText.setVisible(true);
		
		containerPanel.add(loginLabel);
		containerPanel.add(loginText);
		containerPanel.add(passwordLabel);
		containerPanel.add(passwordText);
		
		loginButton = new JButton("Login");
		loginButton.setMaximumSize(new Dimension(1920, 30));
		
		containerPanel.add(Box.createRigidArea(new Dimension(200,this.getHeight()/6)));
		containerPanel.add(loginButton);
		
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setContentPane(containerPanel);
		
		
		this.setVisible(true);
	}

}
