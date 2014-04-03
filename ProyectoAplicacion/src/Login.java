import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class Login extends JFrame {

	private static JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtPassword;
	private static Connection conection;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					
					try{
						Class.forName("com.mysql.jdbc.Driver");
						conection = DriverManager.getConnection("jdbc:mysql://localhost/prueba", "root", "");
						JOptionPane.showMessageDialog(contentPane, "Conexión realizada con éxito.");
					}
					catch(ClassNotFoundException e){
						JOptionPane.showMessageDialog(contentPane, e.getMessage());
					}
					catch(SQLException e){
						JOptionPane.showMessageDialog(contentPane, e.getMessage());
					}
					catch(Exception e){
						JOptionPane.showMessageDialog(contentPane, e.getMessage());
					}
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
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblUsuario.setBounds(50, 49, 100, 50);
		contentPane.add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblPassword.setBounds(50, 110, 100, 50);
		contentPane.add(lblPassword);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		txtUsuario.setBounds(150, 50, 150, 50);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		txtPassword.setBounds(150, 110, 150, 50);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(contentPane, "Conectando...");
			
				String consulta2 = "select * from clientes where Usuario='"
						+ txtUsuario.getText() + "' AND Password='" + txtPassword.getText() + "'";
				
				try {
					Statement consulta = conection.createStatement();
					ResultSet resultado = consulta.executeQuery(consulta2);
					
					if(resultado.next())
						JOptionPane.showMessageDialog(contentPane, "¡Correcto!");
					else
						JOptionPane.showMessageDialog(contentPane, "Datos incorrectos");
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(contentPane, e.getMessage());
				}
				
			}
		});
		btnLogin.setBounds(180, 212, 89, 23);
		contentPane.add(btnLogin);
	}
}
