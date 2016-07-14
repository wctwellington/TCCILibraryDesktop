package br.com.ilibrary.view;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class Interface_About extends JFrame {

	private JPanel contentPane;
	private JLabel lblLogo;
	private JLabel lblDescricao;
	private ImageIcon icone;
	
	public Interface_About() {
		super("..::   I.Library - Sobre   ::..");
		
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
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setSize(435, 450);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		lblLogo = new JLabel(new ImageIcon("images/image_media.png"));
		contentPane.add(lblLogo);
		lblLogo.setBounds(38, 50, 355, 116);
		
		lblDescricao = new JLabel("<html> <p align='center'>Sistema para gerenciamento de bibliotecas.<br/><br/><br/>Desenvolvido por:<br/>Lucas Bezerra<br/>Lucas Henrique<br/>Oseias Reis<br/>Rodrigo Santos<br/>Wellington Cruz Tavares </p></html>");
		contentPane.add(lblDescricao);
		lblDescricao.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescricao.setBounds(50, 180, 320, 164);
		
	}
}
