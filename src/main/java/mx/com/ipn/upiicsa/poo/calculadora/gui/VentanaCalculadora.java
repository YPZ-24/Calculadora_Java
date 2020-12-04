package mx.com.ipn.upiicsa.poo.calculadora.gui;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class VentanaCalculadora extends JFrame{

	private static final long serialVersionUID = 1L;
	private static final Integer KEY_CALCULADORA_BASICA = 1;
	private static final Integer KEY_CALCULADORA_CIENTIFICA = 2;
	
	private VentanaCalculadoraBasica ventanaCalculadoraBasica;
	private VentanaCalculadoraCientifica ventanaCalculadoraCientifica;
	private JMenuBar menuBar;
	private JMenu menuVer;
	private JMenuItem calculadoraBasicaMenuItem;
	private JMenuItem calculadoraCientificaMenuItem;
	private JPanel calculadoraPanel;
	
	public VentanaCalculadora() {
		initComponents();
	}
	
	private void initComponents() {
		setTitle("Calculadora Básica");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(500,400);
		setResizable(false);
		instantiateComponents();
		initListeners();
		buildGrid();
		setVisible(true);
	}
	
	private void buildGrid() {
		Container pane = getContentPane();
		pane.add(calculadoraPanel);
	}

	private void instantiateComponents() {
		menuBar = new JMenuBar();
		menuVer = new JMenu("Ver");
		menuBar.add(menuVer);
		calculadoraBasicaMenuItem = new JMenuItem("Calculadora Básica");
		calculadoraBasicaMenuItem.setEnabled(false);
		calculadoraCientificaMenuItem = new JMenuItem("Calculadora Cientifica");
		calculadoraCientificaMenuItem.setEnabled(true);
		menuVer.add(calculadoraBasicaMenuItem);
		menuVer.add(calculadoraCientificaMenuItem);
		setJMenuBar(menuBar);
		ventanaCalculadoraBasica = new VentanaCalculadoraBasica();
		ventanaCalculadoraCientifica = new VentanaCalculadoraCientifica();
		calculadoraPanel = new JPanel(new CardLayout());
		calculadoraPanel.add(ventanaCalculadoraBasica, KEY_CALCULADORA_BASICA.toString());
		calculadoraPanel.add(ventanaCalculadoraCientifica, KEY_CALCULADORA_CIENTIFICA.toString());
	}
	
	
	private void initListeners() {
		calculadoraBasicaMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setTitle("Calculadora Basica");
				calculadoraBasicaMenuItem.setEnabled(false);
				calculadoraCientificaMenuItem.setEnabled(true);
				CardLayout cardLayout = (CardLayout)calculadoraPanel.getLayout();
				cardLayout.show(calculadoraPanel, KEY_CALCULADORA_BASICA.toString());
			}
		});
		calculadoraCientificaMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setTitle("Calculadora Cientifica");
				calculadoraBasicaMenuItem.setEnabled(true);
				calculadoraCientificaMenuItem.setEnabled(false);
				CardLayout cardLayout = (CardLayout)calculadoraPanel.getLayout();
				cardLayout.show(calculadoraPanel, KEY_CALCULADORA_CIENTIFICA.toString());
			}
		});
	}
	
	
}
