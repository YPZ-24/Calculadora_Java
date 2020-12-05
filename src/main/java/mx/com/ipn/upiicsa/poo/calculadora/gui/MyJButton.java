package mx.com.ipn.upiicsa.poo.calculadora.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class MyJButton extends JButton{

	private static final long serialVersionUID = 1L;
	
	public MyJButton(String text) {
		this.setText(text);
		this.setBackground(new Color(230, 230, 230));
		this.setBorder(BorderFactory.createLineBorder(new Color(179, 179, 179), 1));
		this.setFont(new Font("Arial", Font.PLAIN, 20));
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				setBackground(new Color(230, 230, 230));
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setBackground(new Color(153, 204, 255));
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

}
