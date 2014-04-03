import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;


public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(170, 11, 46, 14);
		contentPane.add(lblLogin);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblUsuario.setBounds(50, 81, 100, 50);
		contentPane.add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblPassword.setBounds(50, 128, 100, 50);
		contentPane.add(lblPassword);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		txtUsuario.setBounds(150, 78, 150, 50);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		txtPassword.setBounds(150, 135, 150, 50);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
	}
}
