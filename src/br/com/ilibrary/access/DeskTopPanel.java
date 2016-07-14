package br.com.ilibrary.access;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;

public class DeskTopPanel extends JFrame {
	
	public static void main(String[] args) {
		
		new DeskTopPanel();
		
	}
	
	@SuppressWarnings("serial")
	public DeskTopPanel() {
		
		setVisible(true);
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Menu 1");
		menuBar.add(mnMenu);
		
		JMenu mnMenu_1 = new JMenu("Menu 2");
		menuBar.add(mnMenu_1);
		
		ImageIcon icon = new ImageIcon("images/fundo.jpg");
		Image image = icon.getImage();
		
		JDesktopPane desktopPane = new JDesktopPane(){
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			}
		};
		desktopPane.repaint();
		getContentPane().add(desktopPane, BorderLayout.CENTER);
	}

}


