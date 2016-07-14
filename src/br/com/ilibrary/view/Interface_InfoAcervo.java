package br.com.ilibrary.view;

import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import br.com.ilibrary.model.Acervo;
import br.com.ilibrary.persist.JDBCDAO;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;

@SuppressWarnings("serial")
public class Interface_InfoAcervo extends JFrame {
	
	private JScrollPane spSobreLivro;
	private JPanel panelSobreLivro;
	private JLabel lblSobre;
	private JLabel lblEditora;
	private JLabel lblApresentaEditora;
	private JLabel lblEdicao;
	private JLabel lblApresentaEdicao;
	private JLabel lblVolume;
	private JLabel lblApresentaVolume;
	private JLabel lblAutor;
	private JLabel lblApresentaAutor;
	private JLabel lblIdioma;
	private JLabel lblApresentaIdioma;
	private JLabel lblNumPaginas;
	private JLabel lblApresentaNumPaginas;
	private JLabel lnlAnoPublicacao;
	private JLabel lblApresentaAnoPublicacao;
	private JLabel lblLocalPublicao;
	private JLabel lblIsbn;
	private JLabel lblApresentaLocalPublicacao;
	private JLabel lblApresentaIsbn;
	private JLabel lblDimenes;
	private JLabel lblApresentaDimencoes;
	private JLabel lblAssunto;
	private JLabel lblApresentaAssunto;
	private JLabel lblCodigoAcervo;
	private JLabel lblApresentaCodigoAcervo;
	private JLabel lblImagem;
	private JLabel lblTitulo;
	private JScrollPane spResumo;
	private JTextArea areaResumo;
	private JLabel lblTipoMaterial;
	private JLabel lblApresentaTipoMaterial;
	private JLabel lblSubtitulo;
	
	private void apresentarTxt(String codAcervo) {

		Acervo acervo = new JDBCDAO<Acervo, String>(Acervo.class).read(codAcervo); 
		lblTitulo.setText("<html><p align='center'>" + acervo.getTitulo() + "</p></html>");
		lblSubtitulo.setText(acervo.getSubtitulo());
		lblApresentaCodigoAcervo.setText(acervo.getCodigo_acervo());
		lblApresentaEdicao.setText(acervo.getEdicao());
		lblApresentaAutor.setText(acervo.getAutor());
		lblApresentaLocalPublicacao.setText(acervo.getLocal());
		lblApresentaVolume.setText(acervo.getVolume());
		lblApresentaIsbn.setText(acervo.getIsbn());
		lblApresentaTipoMaterial.setText(acervo.getMaterial());
		lblApresentaEditora.setText(acervo.getEditora());
		lblApresentaAnoPublicacao.setText(acervo.getAno());
		lblApresentaDimencoes.setText(acervo.getDimensoes());
		lblApresentaAssunto.setText(acervo.getClassificacao().getAssunto());
		lblApresentaNumPaginas.setText(acervo.getPaginas());
		lblApresentaIdioma.setText(acervo.getIdioma());
		areaResumo.setText(acervo.getResumo());
		
		Image image = null;

		try {
			if (acervo.getImagem() != null) {
				image = ImageIO.read(acervo.getImagem());
				lblImagem.setIcon(new ImageIcon(image.getScaledInstance(154, 204, 100)));
			} else {
				lblImagem.setIcon(new ImageIcon("images/semImagem.png"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public Interface_InfoAcervo(String codAcervo) {
		
		super("..::    ILibrary - Informações Sobre Acervo    ::..");
		
		Container pane = getContentPane();
		setSize(654, 587);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);

		setIconImage(new ImageIcon("images/logotitulo.png").getImage());
		
		spSobreLivro = new JScrollPane();
		spSobreLivro.setBounds(26, 252, 595, 282);
		
		panelSobreLivro = new JPanel();
		spSobreLivro.setViewportView(panelSobreLivro);
		spSobreLivro.setBorder(null);
	
		lblSobre = new JLabel("Sobre");
		lblSobre.setForeground(SystemColor.activeCaption);
		lblSobre.setFont(new Font("Arial", Font.BOLD, 18));
		
		lblEditora = new JLabel("Editora:");
		lblEditora.setFont(new Font("Arial", Font.BOLD, 13));
		
		lblApresentaEditora = new JLabel("New label");
		lblApresentaEditora.setFont(new Font("Arial", Font.PLAIN, 13));
		
		lblEdicao = new JLabel("Edição:");
		lblEdicao.setFont(new Font("Arial", Font.BOLD, 13));
		
		lblApresentaEdicao = new JLabel("New label");
		lblApresentaEdicao.setFont(new Font("Arial", Font.PLAIN, 13));
		
		lblVolume = new JLabel("Volume:");
		lblVolume.setFont(new Font("Arial", Font.BOLD, 13));
		
		lblApresentaVolume = new JLabel("New label");
		lblApresentaVolume.setFont(new Font("Arial", Font.PLAIN, 13));
		
		lblAutor = new JLabel("Autor:");
		lblAutor.setFont(new Font("Arial", Font.BOLD, 13));
		
		lblApresentaAutor = new JLabel("New label");
		lblApresentaAutor.setFont(new Font("Arial", Font.PLAIN, 13));
		
		lblIdioma = new JLabel("Idioma:");
		lblIdioma.setFont(new Font("Arial", Font.BOLD, 13));
		
		lblApresentaIdioma = new JLabel("New label");
		lblApresentaIdioma.setFont(new Font("Arial", Font.PLAIN, 13));
		
		lblNumPaginas = new JLabel("Número de Páginas:");
		lblNumPaginas.setFont(new Font("Arial", Font.BOLD, 13));
		
		lblApresentaNumPaginas = new JLabel("New label");
		lblApresentaNumPaginas.setFont(new Font("Arial", Font.PLAIN, 13));
		
		lnlAnoPublicacao = new JLabel("Ano de Publicação:");
		lnlAnoPublicacao.setFont(new Font("Arial", Font.BOLD, 13));
		
		lblApresentaAnoPublicacao = new JLabel("New label");
		lblApresentaAnoPublicacao.setFont(new Font("Arial", Font.PLAIN, 13));
		
		lblLocalPublicao = new JLabel("Local de Publicação:");
		lblLocalPublicao.setFont(new Font("Arial", Font.BOLD, 13));
		
		lblIsbn = new JLabel("I.S.B.N:");
		lblIsbn.setFont(new Font("Arial", Font.BOLD, 13));
		
		lblApresentaLocalPublicacao = new JLabel("New label");
		lblApresentaLocalPublicacao.setFont(new Font("Arial", Font.PLAIN, 13));
		
		lblApresentaIsbn = new JLabel("New label");
		lblApresentaIsbn.setFont(new Font("Arial", Font.PLAIN, 13));
		
		lblDimenes = new JLabel("Dimenções:");
		lblDimenes.setFont(new Font("Arial", Font.BOLD, 13));
		
		lblApresentaDimencoes = new JLabel("New label");
		lblApresentaDimencoes.setFont(new Font("Arial", Font.PLAIN, 13));
		
		lblAssunto = new JLabel("Assunto:");
		lblAssunto.setFont(new Font("Arial", Font.BOLD, 13));
		
		lblApresentaAssunto = new JLabel("New label");
		lblApresentaAssunto.setFont(new Font("Arial", Font.PLAIN, 13));
		
		lblCodigoAcervo = new JLabel("Código do Acervo:");
		lblCodigoAcervo.setFont(new Font("Arial", Font.BOLD, 13));
		
		lblApresentaCodigoAcervo = new JLabel("New label");
		lblApresentaCodigoAcervo.setFont(new Font("Arial", Font.PLAIN, 13));
		
		lblImagem = new JLabel("Imagem");
		lblImagem.setBounds(26, 36, 154, 204);
		
		lblTitulo = new JLabel("Titulo");
		lblTitulo.setFont(new Font("Dialog", Font.BOLD, 13));
		lblTitulo.setBounds(198, 36, 423, 50);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		
		spResumo = new JScrollPane();
		spResumo.setBounds(198, 113, 423, 127);
		
		areaResumo = new JTextArea();
		areaResumo.setLineWrap(true);
		areaResumo.setWrapStyleWord(true);
		areaResumo.setBackground(null);
		areaResumo.setBorder(null);
		areaResumo.setEditable(false);
		spResumo.setViewportView(areaResumo);
		spResumo.setBorder(null);
		pane.setLayout(null);
		
		lblTipoMaterial = new JLabel("Tipo de Material:");
		lblTipoMaterial.setFont(new Font("Arial", Font.BOLD, 13));
		
		lblApresentaTipoMaterial = new JLabel("New label");
		lblApresentaTipoMaterial.setFont(new Font("Arial", Font.PLAIN, 13));
		GroupLayout gl_panelSobreLivro = new GroupLayout(panelSobreLivro);
		gl_panelSobreLivro.setHorizontalGroup(
			gl_panelSobreLivro.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSobreLivro.createSequentialGroup()
					.addGap(12)
					.addGroup(gl_panelSobreLivro.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSobre, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelSobreLivro.createSequentialGroup()
							.addComponent(lblTipoMaterial)
							.addGap(6)
							.addComponent(lblApresentaTipoMaterial, GroupLayout.PREFERRED_SIZE, 435, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelSobreLivro.createSequentialGroup()
							.addComponent(lblCodigoAcervo)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblApresentaCodigoAcervo, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_panelSobreLivro.createSequentialGroup()
							.addComponent(lblAssunto)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblApresentaAssunto, GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_panelSobreLivro.createSequentialGroup()
							.addComponent(lblEditora)
							.addGap(6)
							.addComponent(lblApresentaEditora, GroupLayout.PREFERRED_SIZE, 506, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelSobreLivro.createSequentialGroup()
							.addComponent(lblEdicao)
							.addGap(6)
							.addComponent(lblApresentaEdicao, GroupLayout.PREFERRED_SIZE, 508, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelSobreLivro.createSequentialGroup()
							.addComponent(lblVolume)
							.addGap(6)
							.addComponent(lblApresentaVolume, GroupLayout.PREFERRED_SIZE, 502, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelSobreLivro.createSequentialGroup()
							.addComponent(lblAutor)
							.addGap(6)
							.addComponent(lblApresentaAutor, GroupLayout.PREFERRED_SIZE, 517, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelSobreLivro.createSequentialGroup()
							.addComponent(lblIdioma)
							.addGap(6)
							.addComponent(lblApresentaIdioma, GroupLayout.PREFERRED_SIZE, 507, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelSobreLivro.createSequentialGroup()
							.addComponent(lblNumPaginas)
							.addGap(6)
							.addComponent(lblApresentaNumPaginas, GroupLayout.PREFERRED_SIZE, 426, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelSobreLivro.createSequentialGroup()
							.addComponent(lnlAnoPublicacao)
							.addGap(6)
							.addComponent(lblApresentaAnoPublicacao, GroupLayout.PREFERRED_SIZE, 431, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelSobreLivro.createSequentialGroup()
							.addComponent(lblLocalPublicao)
							.addGap(6)
							.addComponent(lblApresentaLocalPublicacao, GroupLayout.PREFERRED_SIZE, 421, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelSobreLivro.createSequentialGroup()
							.addComponent(lblIsbn)
							.addGap(6)
							.addComponent(lblApresentaIsbn, GroupLayout.PREFERRED_SIZE, 508, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelSobreLivro.createSequentialGroup()
							.addComponent(lblDimenes)
							.addGap(6)
							.addComponent(lblApresentaDimencoes, GroupLayout.PREFERRED_SIZE, 481, GroupLayout.PREFERRED_SIZE)))
					.addGap(2))
		);
		gl_panelSobreLivro.setVerticalGroup(
			gl_panelSobreLivro.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSobreLivro.createSequentialGroup()
					.addGap(12)
					.addComponent(lblSobre)
					.addGap(18)
					.addGroup(gl_panelSobreLivro.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTipoMaterial)
						.addComponent(lblApresentaTipoMaterial))
					.addGap(6)
					.addGroup(gl_panelSobreLivro.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCodigoAcervo)
						.addComponent(lblApresentaCodigoAcervo))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelSobreLivro.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAssunto)
						.addComponent(lblApresentaAssunto))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelSobreLivro.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEditora)
						.addComponent(lblApresentaEditora))
					.addGap(6)
					.addGroup(gl_panelSobreLivro.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEdicao)
						.addComponent(lblApresentaEdicao))
					.addGap(6)
					.addGroup(gl_panelSobreLivro.createParallelGroup(Alignment.LEADING)
						.addComponent(lblVolume)
						.addComponent(lblApresentaVolume))
					.addGap(6)
					.addGroup(gl_panelSobreLivro.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAutor)
						.addComponent(lblApresentaAutor))
					.addGap(6)
					.addGroup(gl_panelSobreLivro.createParallelGroup(Alignment.LEADING)
						.addComponent(lblIdioma)
						.addComponent(lblApresentaIdioma))
					.addGap(6)
					.addGroup(gl_panelSobreLivro.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNumPaginas)
						.addComponent(lblApresentaNumPaginas))
					.addGap(6)
					.addGroup(gl_panelSobreLivro.createParallelGroup(Alignment.LEADING)
						.addComponent(lnlAnoPublicacao)
						.addComponent(lblApresentaAnoPublicacao))
					.addGap(6)
					.addGroup(gl_panelSobreLivro.createParallelGroup(Alignment.LEADING)
						.addComponent(lblLocalPublicao)
						.addComponent(lblApresentaLocalPublicacao))
					.addGap(6)
					.addGroup(gl_panelSobreLivro.createParallelGroup(Alignment.LEADING)
						.addComponent(lblIsbn)
						.addComponent(lblApresentaIsbn))
					.addGap(6)
					.addGroup(gl_panelSobreLivro.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDimenes)
						.addComponent(lblApresentaDimencoes)))
		);
		panelSobreLivro.setLayout(gl_panelSobreLivro);
		pane.add(spSobreLivro);
		pane.add(lblImagem);
		pane.add(lblTitulo);
		pane.add(spResumo);
		
		lblSubtitulo = new JLabel("Subtitulo");
		lblSubtitulo.setForeground(Color.BLUE);
		lblSubtitulo.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblSubtitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubtitulo.setBounds(195, 86, 426, 15);
		pane.add(lblSubtitulo);
		
		apresentarTxt(codAcervo);
	}
}
