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
import br.com.ilibrary.persist.IGenericDAO;
import br.com.ilibrary.persist.JDBCDAO;
import br.com.ilibrary.view.Interface_InfoAcervo;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class Panel_BuscarExemplares extends JPanel {

	private JLabel lblDetalheFisico;
	private TableModel modelExemplar;
	private JTable tblExemplar;
	private JScrollPane spExemplar;
	private JButton btnInformacoesAcervo;
	private String cod_acervo;
	@SuppressWarnings("rawtypes")
	private JComboBox cbOrdenarPor;
	private JLabel lblOrdenarPor;
	
	private String ordenarPor = "cod_acervo";
	private JScrollPane spDetalheFisico;
	private JTextArea areaDetalheFisico;
		
	private void filtrarExemplares() {

		if (cod_acervo != null) {
			String sql = null;
			switch (cbOrdenarPor.getSelectedItem().toString()) {

			case "Cod. Acervo":
				sql = "SELECT * FROM exemplar order by cod_acervo";
				break;

			case "Cod. Exemplar":
				sql = "SELECT * FROM exemplar order by cod_exemplar";
				break;
				
			case "Disponibilidade":
				sql = "SELECT * FROM exemplar order by disponibilidade";
				break;

			case "Emprestado":
				sql = "SELECT * FROM exemplar order by emprestado";
				break;

			case "Situação":
				sql = "SELECT * FROM exemplar order by ativo";
				break;

			case "Preço Compra":
				sql = "SELECT * FROM exemplar order by preco_compra";
				break;

			default:
				break;
			}

			carregarTable(sql);
		}
	}

	private void carregarTable(String sql) {

		modelExemplar.setNumRows(0);
		ArrayList<Exemplar> lista_exemplares = new JDBCDAO<Exemplar, String>(Exemplar.class).readAll(sql);
		if (lista_exemplares != null) {
			for (Exemplar e : lista_exemplares) {
				modelExemplar
						.addRow(new Object[] { e.getCod_acervo(), e.getCodigo_Exemplar(), e.getDisponibilidade(), e.getEmprestado(), e.getAtivo(), e.getPreco_compra() });
			}
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Panel_BuscarExemplares() {
		
		this.setSize(1360, 760);
		setOpaque(false);
		
		this.setLayout(new MigLayout("", "[167.00][35.00][43.00][173.00][184.00][104.00][44.00][324.00]", "[28.00][][20][23.00][][:150.00:238.00][::123.00]"));

		modelExemplar = new TableModel();
		modelExemplar.addColumn("Cod. Acervo");
		modelExemplar.addColumn("Cod. Exemplar");
		modelExemplar.addColumn("Disponibilidade");
		modelExemplar.addColumn("Emprestado");
		modelExemplar.addColumn("Situação");
		modelExemplar.addColumn("Preço Compra");

		tblExemplar = new JTable(modelExemplar);
		tblExemplar.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		tblExemplar.getColumnModel().getColumn(0).setPreferredWidth(120);
		tblExemplar.getColumnModel().getColumn(1).setPreferredWidth(100);
		tblExemplar.getColumnModel().getColumn(2).setPreferredWidth(150);
		tblExemplar.getColumnModel().getColumn(3).setPreferredWidth(150);
		tblExemplar.getColumnModel().getColumn(4).setPreferredWidth(150);
		tblExemplar.getColumnModel().getColumn(5).setPreferredWidth(150);
		tblExemplar.setRowHeight(25);
		
		lblOrdenarPor = new JLabel("Ordenar por");
		add(lblOrdenarPor, "cell 0 1");
		
		cbOrdenarPor = new JComboBox();
		cbOrdenarPor.addItem("Cod. Acervo");
		cbOrdenarPor.addItem("Cod. Exemplar");
		cbOrdenarPor.addItem("Disponibilidade");
		cbOrdenarPor.addItem("Emprestado");
		cbOrdenarPor.addItem("Situação");
		cbOrdenarPor.addItem("Preço Compra");
		add(cbOrdenarPor, "cell 0 2,growx");
		
		cbOrdenarPor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {			
				filtrarExemplares();
			}
		});

		btnInformacoesAcervo = new JButton("<html><p align='center'>Informações<br/>Acervo</p></html>");

		this.add(btnInformacoesAcervo, "cell 5 3 1 2,grow");

		lblDetalheFisico = new JLabel("Detalhe Físico");
		lblDetalheFisico.setHorizontalAlignment(SwingConstants.LEFT);
		this.add(lblDetalheFisico, "cell 7 4,grow");

		spExemplar = new JScrollPane(tblExemplar);
		this.add(spExemplar, "cell 0 5 6 2,grow");
		spExemplar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		spExemplar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		spDetalheFisico = new JScrollPane();
		add(spDetalheFisico, "cell 7 5,grow");
		
		areaDetalheFisico = new JTextArea();
		spDetalheFisico.setViewportView(areaDetalheFisico);
		
		carregarTable("select * from exemplar");
			
		tblExemplar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				int viewRow = tblExemplar.getSelectedRow();
				cod_acervo = tblExemplar.getValueAt(viewRow, 0).toString();
				;
				Exemplar exemplar = new JDBCDAO<Exemplar, String>(Exemplar.class).read(tblExemplar.getValueAt(viewRow, 1).toString());
				areaDetalheFisico.setText(exemplar.getDetalhe());
			}
		});
		
		btnInformacoesAcervo.addActionListener(new ActionListener() {
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