package br.com.ilibrary.view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import br.com.ilibrary.controller.Data;
import br.com.ilibrary.model.Cliente;
import br.com.ilibrary.persist.JDBCDAO;
import br.com.ilibrary.persist.jdbc.JDBCCliente;

import java.awt.Font;

public class Interface_InfoCliente extends JFrame {
	
	public Interface_InfoCliente(String registro) {
		
		super("..::     ILibrary - Informações Sobre Cliente     ::..");
		setSize(530, 473);
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
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(33, 100, 35, 15);
		getContentPane().add(lblTipo);
		
		JLabel lblApresentaTipo = new JLabel("New label");
		lblApresentaTipo.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblApresentaTipo.setBounds(80, 100, 227, 15);
		getContentPane().add(lblApresentaTipo);
		
		JLabel lblRegistro = new JLabel("Registro:");
		lblRegistro.setBounds(33, 125, 70, 15);
		getContentPane().add(lblRegistro);
		
		JLabel lblApresentaRegistro = new JLabel("New label");
		lblApresentaRegistro.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblApresentaRegistro.setBounds(110, 125, 384, 15);
		getContentPane().add(lblApresentaRegistro);
		
		JLabel lblDataNasc = new JLabel("Data Nasc:");
		lblDataNasc.setBounds(33, 150, 86, 15);
		getContentPane().add(lblDataNasc);
		
		JLabel lblApresentaDataNasc = new JLabel("New label");
		lblApresentaDataNasc.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblApresentaDataNasc.setBounds(124, 150, 370, 15);
		getContentPane().add(lblApresentaDataNasc);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(33, 175, 70, 15);
		getContentPane().add(lblSexo);
		
		JLabel lblApresentaSexo = new JLabel("New label");
		lblApresentaSexo.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblApresentaSexo.setBounds(85, 175, 409, 15);
		getContentPane().add(lblApresentaSexo);
		
		JLabel lblCep = new JLabel("Cep:");
		lblCep.setBounds(33, 200, 70, 15);
		getContentPane().add(lblCep);
		
		JLabel lblApresentaCep = new JLabel("New label");
		lblApresentaCep.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblApresentaCep.setBounds(78, 200, 416, 15);
		getContentPane().add(lblApresentaCep);
		
		JLabel lblEndereco = new JLabel("Endereço:");
		lblEndereco.setBounds(33, 225, 86, 15);
		getContentPane().add(lblEndereco);
		
		JLabel lblApresentaEndereco = new JLabel("New label");
		lblApresentaEndereco.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblApresentaEndereco.setBounds(116, 225, 378, 15);
		getContentPane().add(lblApresentaEndereco);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(33, 250, 117, 15);
		getContentPane().add(lblComplemento);
		
		JLabel lblApresentaComplemento = new JLabel("");
		lblApresentaComplemento.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblApresentaComplemento.setBounds(148, 250, 346, 15);
		getContentPane().add(lblApresentaComplemento);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(33, 275, 70, 15);
		getContentPane().add(lblBairro);
		
		JLabel lblApresentaBairro = new JLabel("New label");
		lblApresentaBairro.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblApresentaBairro.setBounds(94, 275, 400, 15);
		getContentPane().add(lblApresentaBairro);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(33, 300, 70, 15);
		getContentPane().add(lblCidade);
		
		JLabel lblApresentaCidade = new JLabel("New label");
		lblApresentaCidade.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblApresentaCidade.setBounds(101, 300, 393, 15);
		getContentPane().add(lblApresentaCidade);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(33, 325, 70, 15);
		getContentPane().add(lblTelefone);
		
		JLabel lblApresentaTelefone = new JLabel("New label");
		lblApresentaTelefone.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblApresentaTelefone.setBounds(115, 325, 379, 15);
		getContentPane().add(lblApresentaTelefone);
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(33, 350, 70, 15);
		getContentPane().add(lblCelular);
		
		JLabel lblApresentaCelular = new JLabel("New label");
		lblApresentaCelular.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblApresentaCelular.setBounds(101, 350, 393, 15);
		getContentPane().add(lblApresentaCelular);
		
		JLabel lblEmail = new JLabel("email:");
		lblEmail.setBounds(33, 375, 70, 15);
		getContentPane().add(lblEmail);
		
		JLabel lblApresentaEmail = new JLabel("New label");
		lblApresentaEmail.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblApresentaEmail.setBounds(90, 375, 404, 15);
		getContentPane().add(lblApresentaEmail);
		
		JLabel lblResponsvel = new JLabel("Responsável:");
		lblResponsvel.setBounds(33, 400, 117, 15);
		getContentPane().add(lblResponsvel);
		
		JLabel lblApresentaResponsavel = new JLabel("New label");
		lblApresentaResponsavel.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblApresentaResponsavel.setBounds(143, 400, 351, 15);
		getContentPane().add(lblApresentaResponsavel);
		
		JLabel lblSituao = new JLabel("Situação:");
		lblSituao.setBounds(319, 100, 70, 15);
		getContentPane().add(lblSituao);
		
		JLabel lblApresentaSituacao = new JLabel("New label");
		lblApresentaSituacao.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblApresentaSituacao.setBounds(399, 100, 70, 15);
		getContentPane().add(lblApresentaSituacao);
		
		Cliente cliente = new JDBCDAO<Cliente, String>(Cliente.class).read(registro);
		
		lblNome.setText(cliente.getNome().toUpperCase());
		lblApresentaTipo.setText(cliente.getTipo());
		lblApresentaRegistro.setText(cliente.getRegistro());
		lblApresentaDataNasc.setText(Data.convertString(cliente.getData_nasc().toString()));
		lblApresentaSexo.setText(cliente.getSexo());
		lblApresentaCep.setText(cliente.getCep());
		lblApresentaEndereco.setText(cliente.getLocalizacao().getEndereco() + ", " + cliente.getNum_residencia());
		lblApresentaBairro.setText(cliente.getLocalizacao().getBairro());
		lblApresentaCidade.setText(cliente.getLocalizacao().getCidade());
		lblApresentaTelefone.setText(cliente.getTelefone());
		lblApresentaCelular.setText(cliente.getCelular());
		lblApresentaEmail.setText(cliente.getEmail());
		lblApresentaResponsavel.setText(cliente.getResponsavel());
		
		if (cliente.getAtivo() == true) {
			lblApresentaSituacao.setText("Ativado");
		} else {
			lblApresentaSituacao.setText("Desativado");
		}
	}
}
