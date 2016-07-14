package br.com.ilibrary.view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.com.ilibrary.model.Operador;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;

@SuppressWarnings("serial")
public class Interface_Login extends JFrame {

	private JPanel contentPane;
	private JLabel lblRegistro, lbsenha, lbllogo;
	private JTextField txtusuario;
	private JPasswordField pwsenha;
	private JButton btentrar, btsair;

	private ImageIcon icone;
	private JLabel lblLogin;

	public Interface_Login() {

		super(".:: ILibrary - Login ::.");

		lblRegistro = new JLabel("Registro");
		lbsenha = new JLabel("Senha");
		txtusuario = new JTextField();
		pwsenha = new JPasswordField();
		btentrar = new JButton("Entrar");
		btsair = new JButton("Sair");
		lbllogo = new JLabel(new ImageIcon("images/logo_login.png"));

		
		setSize(600, 400);
		setVisible(true);
		setResizable(false);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		icone = new ImageIcon("images/logotitulo.png");
		setIconImage(icone.getImage());
		
		ImageIcon icon = new ImageIcon("images/fundo5.jpg");
		Image image = icon.getImage();
		
		contentPane = new JPanel(){
			public void paintComponent(Graphics g) {
			     super.paintComponent(g);
			     g.drawImage(image, 0, 0,getWidth(), getHeight(), this);
			}
		};
		
		contentPane.setLayout(null);
		contentPane.add(lblRegistro);
		lblRegistro.setBounds(280, 100, 100, 30);
		contentPane.add(txtusuario);
		txtusuario.setBounds(360, 100, 200, 25);

		contentPane.add(lbsenha);
		lbsenha.setBounds(280, 150, 100, 30);
		contentPane.add(pwsenha);
		pwsenha.setBounds(360, 150, 200, 25);

		contentPane.add(btentrar);
		btentrar.setBounds(460, 200, 100, 40);
		btentrar.setMnemonic(KeyEvent.VK_E);
		getRootPane().setDefaultButton(btentrar);

		contentPane.add(btsair);
		btsair.setBounds(460, 260, 100, 40);
		btsair.setMnemonic(KeyEvent.VK_S);

		contentPane.add(lbllogo);
		lbllogo.setBounds(26, 25, 280, 254);

		lblLogin = new JLabel("LOGIN");
		contentPane.add(lblLogin);
		lblLogin.setForeground(new Color(62, 139, 211));
		lblLogin.setFont(new Font("Arial", Font.BOLD, 20));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(26, 25, 534, 41);
		
		setContentPane(contentPane);
		
		btentrar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				Operador operador = Operador.logonSistema(txtusuario.getText(), pwsenha.getText());

				if (operador != null) {
					if (operador.getAtivo() == true) {

						if (operador.getPrivilegio().equals("Administrador")) {
							new Interface_MainAdministrator(operador);
							dispose();
						} else if (operador.getPrivilegio().equals("Atendente")) {
							new Interface_MainClerk(operador);
							dispose();
						}
					} else {
						JOptionPane.showMessageDialog(null, "Operador Desativado", "Aviso",
								JOptionPane.WARNING_MESSAGE);
					}

				} else {
					JOptionPane.showMessageDialog(null, "Registro ou Senha Incorretos!", "Aviso",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		btsair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
