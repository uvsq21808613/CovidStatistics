import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public Window() {
		this.setSize(300,300);
		
		this.setTitle("loginScreen");
		
		containerPanel = new JPanel();
		containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.PAGE_AXIS));
		
		loginLabel = new JLabel("Login : ");
		loginText=new JTextField();
		passwordLabel = new JLabel("Password : ");
		passwordText = new JTextField();
		
		containerPanel.add(loginLabel);
		containerPanel.add(loginText);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setContentPane(containerPanel);
		
		
		this.setVisible(true);
	}

}
