import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ServerConnection {
	Scanner userIn = new Scanner(System.in);
	static int portNumber;
	private JFrame frame;
	private JTextField portInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerConnection window = new ServerConnection();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ServerConnection() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Please enter a port number for server to be opened on.");
		lblNewLabel.setBounds(72, 46, 352, 55);
		frame.getContentPane().add(lblNewLabel);
		
		portInput = new JTextField();
		portInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		portInput.setToolTipText("Enter port number here");
		portInput.setBounds(170, 112, 86, 20);
		frame.getContentPane().add(portInput);
		portInput.setColumns(10);
		
		JButton portNumButton = new JButton("Submit");
		portNumButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if(userIn.hasNextInt()){
					JOptionPane.showMessageDialog(null, "Server opened on port.");
				//}
				//else{
					//System.out.println("Please enter a valid number");
				//}
				//MTEchoServer es = new MTEchoServer();
				//es.startServer(portNumber);
			}
		});
		portNumButton.setBounds(167, 172, 89, 23);
		frame.getContentPane().add(portNumButton);
	}
}
