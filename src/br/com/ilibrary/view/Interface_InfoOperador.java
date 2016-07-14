package br.com.ilibrary.view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import br.com.ilibrary.controller.Data;
import br.com.ilibrary.model.Cliente;
import br.com.ilibrary.model.Operador;
import br.com.ilibrary.persist.JDBCDAO;
import br.com.ilibrary.persist.jdbc.JDBCCliente;

import java.awt.Font;

public class Interface_InfoOperador extends JFrame {
	
	public Interface_InfoOperador(String registro) {
		
		super("..::     ILibrary - Informações Sobre Operador     ::..");
		setSize(530, 385);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		setIconImage(new ImageIcon("images/logotitulo.png").getImage());
		
		JLabel lblNome = new JLabel("Texto");
		lblNome.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setBounds(33, 24, 461, 54);
		getContentPane().add(lblNome);
		
		JLabel lblPrivilegio = new JLabel("Privilégio:");
		lblPrivilegio.setBounds(33, 100, 79, 15);
		getContentPane().add(lblPrivilegio);
		
		JLabel lblApresentaPrivilegio = new JLabel("New label");
		lblApresentaPrivilegio.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblApresentaPrivilegio.setBounds(117, 100, 143, 15);
		getContentPane().add(lblApresentaPrivilegio);
		
		JLabel lblRegistro = new JLabel("Registro:");
		lblRegistro.setBounds(33, 125, 70, 15);
		getContentPane().add(lblRegistro);
		
		JLabel lblApresentaRegistro = new JLabel("New label");
		lblApresentaRegistro.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblApresentaRegistro.setBounds(110, 125, 384, 15);
		getContentPane().add(lblApresentaRegistro);
		
		JLabel lblCep = new JLabel("Cep:");
		lblCep.setBounds(33, 150, 70, 15);
		getContentPane().add(lblCep);
		
		JLabel lblApresentaCep = new JLabel("New label");
		lblApresentaCep.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblApresentaCep.setBounds(78, 150, 416, 15);
		getContentPane().add(lblApresentaCep);
		
		JLabel lblEndereco = new JLabel("Endereço:");
		lblEndereco.setBounds(33, 175, 86, 15);
		getContentPane().add(lblEndereco);
		
		JLabel lblApresentaEndereco = new JLabel("New label");
		lblApresentaEndereco.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblApresentaEndereco.setBounds(116, 175, 378, 15);
		getContentPane().add(lblApresentaEndereco);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(33, 200, 70, 15);
		getContentPane().add(lblBairro);
		
		JLabel lblApresentaBairro = new JLabel("New label");
		lblApresentaBairro.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblApresentaBairro.setBounds(94, 200, 400, 15);
		getContentPane().add(lblApresentaBairro);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(33, 225, 70, 15);
		getContentPane().add(lblCidade);
		
		JLabel lblApresentaCidade = new JLabel("New label");
		lblApresentaCidade.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblApresentaCidade.setBounds(101, 225, 393, 15);
		getContentPane().add(lblApresentaCidade);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(33, 250, 70, 15);
		getContentPane().add(lblTelefone);
		
		JLabel lblApresentaTelefone = new JLabel("New label");
		lblApresentaTelefone.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblApresentaTelefone.setBounds(115, 250, 379, 15);
		getContentPane().add(lblApresentaTelefone);
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(33, 275, 70, 15);
		getContentPane().add(lblCelular);
		
		JLabel lblApresentaCelular = new JLabel("New label");
		lblApresentaCelular.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblApresentaCelular.setBounds(101, 275, 393, 15);
		getContentPane().add(lblApresentaCelular);
		
		JLabel lblSituao = new JLabel("Situação:");
		lblSituao.setBounds(33, 300, 70, 15);
		getContentPane().add(lblSituao);
		
		JLabel lblApresentaSituacao = new JLabel("New label");
		lblApresentaSituacao.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblApresentaSituacao.setBounds(113, 300, 70, 15);
		getContentPane().add(lblApresentaSituacao);
		
		Operador operador = new JDBCDAO<Operador, String>(Operador.class).read(registro);
		
		lblNome.setText(operador.getNome().toUpperCase());
		lblApresentaPrivilegio.setText(operador.getPrivilegio());
		lblApresentaRegistro.setText(operador.getRegistro());
		lblApresentaCep.setText(operador.getCep());
		lblApresentaEndereco.setText(operador.getLocalizacao().getEndereco() + ", " + operador.getNum());
		lblApresentaBairro.setText(operador.getLocalizacao().getBairro());
		lblApresentaCidade.setText(operador.getLocalizacao().getCidade());
		lblApresentaTelefone.setText(operador.getTelefone());
		lblApresentaCelular.setText(operador.getCelular());
		
		if (operador.getAtivo() == true) {
			lblApresentaSituacao.setText("Ativado");
		} else {
			lblApresentaSituacao.setText("Desativado");
		}
	}
}
