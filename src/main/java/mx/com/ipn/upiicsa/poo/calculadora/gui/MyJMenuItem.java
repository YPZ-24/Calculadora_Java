package mx.com.ipn.upiicsa.poo.calculadora.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JMenuItem;

public class MyJMenuItem extends JMenuItem{

	private static final long serialVersionUID = 1L;
	
	public MyJMenuItem(String text) {
		this.setText(text);
		this.setBackground(Color.WHITE);
		this.setFont(new Font("Arial", Font.PLAIN, 18));
	}
	
	
}
