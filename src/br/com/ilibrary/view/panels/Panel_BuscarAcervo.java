package br.com.ilibrary.view.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import br.com.ilibrary.controller.TableModel;
import br.com.ilibrary.model.Acervo;
import br.com.ilibrary.model.Exemplar;
import br.com.ilibrary.persist.JDBCDAO;
import br.com.ilibrary.view.Interface_InfoAcervo;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class Panel_BuscarAcervo extends JPanel {

	private JLabel lblExemplares;
	private JLabel lblPesquisarPor;
	private JTextField txtBusca;
	@SuppressWarnings("rawtypes")
	private JComboBox cbPesquisarPor;
	private TableModel modeloAcervo;
	private TableModel modeloExemplar;
	private JTable tblAcervo;
	private JTable tblExemplar;
	private JScrollPane spAcervo;
	private JScrollPane spExemplares;
	private JButton btnMaisInformacoes;
	private String cod_acervo;
	@SuppressWarnings("rawtypes")
	private JComboBox cbApresentarExemplares;
	@SuppressWarnings("rawtypes")
	private JComboBox cbOrdenarPor;
	private JLabel lblApresentarExemplares;
	private JLabel lblOrdenarPor;
	
	
	
	private String ordenarPor = "cod_acervo";
	
	private void filtrarAcervo() {
		String sql;
		switch(cbPesquisarPor.getSelectedItem().toString()) {
		
		case "Código Acervo":
			sql = "SELECT * FROM acervo where cod_acervo like '" + txtBusca.getText() + "%' order by " + ordenarPor;
			carregarTableAcervo(sql);
			break;
						
		case "Material":
			sql = "SELECT * FROM acervo where tipo_material like '" + txtBusca.getText() + "%' order by " + ordenarPor;			
			carregarTableAcervo(sql);
			break;
			
		case "Título":
			sql = "SELECT * FROM acervo where titulo like '" + txtBusca.getText() + "%' order by " + ordenarPor;
			carregarTableAcervo(sql);
			break;
			
		case "Subtítulo":
			sql = "SELECT * FROM acervo where subtitulo like '" + txtBusca.getText() + "%' order by " + ordenarPor;
			carregarTableAcervo(sql);
			break;
			
		case "Assunto":
			sql = "SELECT * FROM classificacao INNER JOIN acervo ON classificacao.cod_classificacao = acervo.cod_classificacao WHERE classificacao.assunto like '" + txtBusca.getText() + "%' order by " + ordenarPor;
			carregarTableAcervo(sql);
			break;
			
		case "Nome Autor":
			sql = "SELECT * FROM acervo where nome_autor like '" + txtBusca.getText() + "%' order by " + ordenarPor;
			carregarTableAcervo(sql);
			break;
			
		case "Editora":
			sql = "SELECT * FROM acervo where editora like '" + txtBusca.getText() + "%' order by " + ordenarPor;
			carregarTableAcervo(sql);
			break;
		}
	}
	
	private void filtrarExemplares() {

		if (cod_acervo != null) {
			String sql = null;
			switch (cbApresentarExemplares.getSelectedItem().toString()) {

			case "Todos":
				sql = "SELECT * FROM exemplar WHERE cod_acervo = '" + cod_acervo + "'";
				break;

			case "Para Consulta":
				sql = "SELECT * FROM exemplar WHERE cod_acervo='" + cod_acervo + "' AND disponibilidade='Consulta'";
				break;

			case "Para Empréstimo":
				sql = "SELECT * FROM exemplar WHERE cod_acervo = '" + cod_acervo + "' AND disponibilidade='Empréstimo'";
				break;

			case "Emprestados":
				sql = "SELECT * FROM exemplar WHERE cod_acervo = '" + cod_acervo + "' AND emprestado=true";
				break;

			case "Disponíveis Para Empréstimo":
				sql = "SELECT * FROM exemplar WHERE cod_acervo = '" + cod_acervo
						+ "' AND disponibilidade='Empréstimo' AND emprestado=false";
				break;

			case "Ativados":
				sql = "SELECT * FROM exemplar WHERE cod_acervo = '" + cod_acervo + "' AND ativo=true";
				break;

			case "Desativados":
				sql = "SELECT * FROM exemplar WHERE cod_acervo = '" + cod_acervo + "' AND ativo=false";
				break;

			default:
				break;
			}

			carregarTableExemplares(sql);
		}
	}

	private void carregarTableAcervo(String sql) {

		modeloAcervo.setNumRows(0);
		ArrayList<Acervo> lista_acervo = new JDBCDAO<Acervo, String>(Acervo.class).readAll(sql);

		if (lista_acervo != null) {
			for (Acervo a : lista_acervo) {
				modeloAcervo.addRow(new Object[] { a.getCodigo_acervo(), a.getMaterial(), a.getTitulo(),
						a.getSubtitulo(), a.getClassificacao().getAssunto(), a.getAutor(), a.getEditora() });
			}
		}
	}

	private void carregarTableExemplares(String sql) {

		modeloExemplar.setNumRows(0);
		ArrayList<Exemplar> lista_exemplares = new JDBCDAO<Exemplar, String>(Exemplar.class).readAll(sql);
		if (lista_exemplares != null) {
			for (Exemplar e : lista_exemplares) {
				modeloExemplar
						.addRow(new Object[] { e.getCodigo_Exemplar(), e.getDisponibilidade(), e.getPreco_compra() });
			}
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Panel_BuscarAcervo() {
		
		this.setSize(1360, 760);
		setOpaque(false);
		
		this.setLayout(new MigLayout("", "[167.00][35.00][43.00][173.00][184.00][104.00][20][214.00][:121.00:115.00]", "[28.00][][20][23.00][][:201.00:238.00][::123.00]"));

		modeloAcervo = new TableModel();
		modeloAcervo.addColumn("Cod. Acervo");
		modeloAcervo.addColumn("Material");
		modeloAcervo.addColumn("Titulo");
		modeloAcervo.addColumn("Subtitulo");
		modeloAcervo.addColumn("Assunto");
		modeloAcervo.addColumn("Nome Autor");
		modeloAcervo.addColumn("Editora");

		modeloExemplar = new TableModel();
		modeloExemplar.addColumn("Cod. Exemplar");
		modeloExemplar.addColumn("Disponibilidade");
		modeloExemplar.addColumn("Preço Compra");

		tblAcervo = new JTable(modeloAcervo);
		tblAcervo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		tblAcervo.getColumnModel().getColumn(0).setPreferredWidth(120);
		tblAcervo.getColumnModel().getColumn(1).setPreferredWidth(100);
		tblAcervo.getColumnModel().getColumn(2).setPreferredWidth(150);
		tblAcervo.getColumnModel().getColumn(3).setPreferredWidth(150);
		tblAcervo.getColumnModel().getColumn(4).setPreferredWidth(150);
		tblAcervo.getColumnModel().getColumn(5).setPreferredWidth(150);
		tblAcervo.getColumnModel().getColumn(6).setPreferredWidth(120);
		tblAcervo.setRowHeight(25);

		tblExemplar = new JTable(modeloExemplar);
		tblExemplar.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		tblExemplar.getColumnModel().getColumn(0).setPreferredWidth(112);
		tblExemplar.getColumnModel().getColumn(1).setPreferredWidth(110);
		tblExemplar.getColumnModel().getColumn(2).setPreferredWidth(110);
		tblExemplar.setRowHeight(20);

		lblPesquisarPor = new JLabel("Pesquisar por");
		this.add(lblPesquisarPor, "cell 0 1");
		
		lblOrdenarPor = new JLabel("Ordenar por");
		add(lblOrdenarPor, "cell 3 1");
		
		lblApresentarExemplares = new JLabel("Apresentar Exemplares");
		add(lblApresentarExemplares, "cell 7 1");

		cbPesquisarPor = new JComboBox();
		cbPesquisarPor.addItem("Código Acervo");
		cbPesquisarPor.addItem("Material");
		cbPesquisarPor.addItem("Título");
		cbPesquisarPor.addItem("Subtítulo");
		cbPesquisarPor.addItem("Assunto");
		cbPesquisarPor.addItem("Nome Autor");
		cbPesquisarPor.addItem("Editora");
		this.add(cbPesquisarPor, "cell 0 2,growx");
		
		cbOrdenarPor = new JComboBox();
		cbOrdenarPor.addItem("Código Acervo");
		cbOrdenarPor.addItem("Material");
		cbOrdenarPor.addItem("Título");
		cbOrdenarPor.addItem("Subtítulo");
		cbOrdenarPor.addItem("Assunto");
		cbOrdenarPor.addItem("Nome Autor");
		cbOrdenarPor.addItem("Editora");
		add(cbOrdenarPor, "cell 3 2,growx");
		
		cbApresentarExemplares = new JComboBox();
		cbApresentarExemplares.addItem("Todos");
		cbApresentarExemplares.addItem("Para Consulta");
		cbApresentarExemplares.addItem("Para Empréstimo");
		cbApresentarExemplares.addItem("Emprestados");
		cbApresentarExemplares.addItem("Disponíveis Para Empréstimo");
		cbApresentarExemplares.addItem("Ativados");
		cbApresentarExemplares.addItem("Desativados");
		add(cbApresentarExemplares, "cell 7 2,growx");

		txtBusca = new JTextField();

		this.add(txtBusca, "cell 0 3 2 1,grow");
		txtBusca.setColumns(10);

		btnMaisInformacoes = new JButton("<html><p align='center'>Mais<br/>Informações</p></html>");

		this.add(btnMaisInformacoes, "cell 5 3 1 2,grow");

		lblExemplares = new JLabel("Exemplares");
		lblExemplares.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(lblExemplares, "cell 7 4 2 1,grow");

		spAcervo = new JScrollPane(tblAcervo);
		this.add(spAcervo, "cell 0 5 6 2,grow");
		spAcervo.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		spAcervo.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		
		spExemplares = new JScrollPane(tblExemplar);
		this.add(spExemplares, "cell 7 5 2 1,alignx leading,growy");
		spExemplares.setViewportView(tblExemplar);
		spExemplares.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		spExemplares.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		carregarTableAcervo("select * from acervo");
		

		txtBusca.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (txtBusca.getText() != null) {
					filtrarAcervo();
				}
			}
		});
		
		cbOrdenarPor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				switch(cbOrdenarPor.getSelectedItem().toString()) {
					
				case "Código Acervo":
					ordenarPor = "cod_acervo";
					break;
					
				case "Material":
					ordenarPor = "tipo_material";
					break;
					
				case "Título":
					ordenarPor = "titulo";
					break;
					
				case "Subtitulo":
					ordenarPor = "subtitulo";
					break;
					
				case "Assunto":
					ordenarPor = "classificacao.assunto";
					break;
									
				case "Nome Autor":
					ordenarPor = "nome_autor";
					break;
					
				case "Editora":
					ordenarPor = "editora";
					break;	
				}
			
				filtrarAcervo();
			}
		});
			
		tblAcervo.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				int viewRow = tblAcervo.getSelectedRow();
				cod_acervo = tblAcervo.getValueAt(viewRow, 0).toString();
				filtrarExemplares();
			}
		});
		
		cbApresentarExemplares.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				filtrarExemplares();			
			}
		});
		
		btnMaisInformacoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (cod_acervo != null) {
					new Interface_InfoAcervo(cod_acervo);
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um acervo", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
	}
}