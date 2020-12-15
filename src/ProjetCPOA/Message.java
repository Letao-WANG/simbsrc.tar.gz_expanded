package ProjetCPOA;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Message extends JFrame implements ActionListener {
	
	Controle controle;
	
	public Message(Controle controle) {
		
		this.controle = controle;
		
		getContentPane().setLayout(null);
		
		JButton btnRestart = new JButton("Restart");
		btnRestart.setBounds(79, 100, 117, 58);
		getContentPane().add(btnRestart);
		btnRestart.addActionListener(this);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.setBounds(226, 100, 117, 58);
		getContentPane().add(btnQuit);
		btnQuit.addActionListener(this);
		
		JLabel lblGameOver = new JLabel("GAME OVER !");
		lblGameOver.setBounds(79, 37, 117, 17);
		getContentPane().add(lblGameOver);
		
		JLabel lblAgain = new JLabel("Want to try again ?");
		lblAgain.setBounds(77, 56, 151, 26);
		getContentPane().add(lblAgain);
		
		setBounds(100, 100, 400, 250);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
        if ("Quit".equals(command)) {
            controle.Quit();
        }
        if ("Restart".equals(command)) {
            controle.ShowMain();
            controle.disposeMessage();
        }
	}
}
