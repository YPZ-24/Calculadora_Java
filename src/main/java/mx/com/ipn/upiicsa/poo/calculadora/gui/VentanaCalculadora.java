package mx.com.ipn.upiicsa.poo.calculadora.gui;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import mx.com.ipn.upiicsa.poo.calculadora.bs.Calculadora;

public class VentanaCalculadora extends JFrame{
	
	private static final Integer CERO = 0;
	private static final Integer UNO = 1;
	private static final Integer DOS = 2;
	private static final Integer TRES = 3;
	private static final Integer CUATRO = 4;
	private static final Integer CINCO = 5;
	private static final Integer SEIS = 6;
	private static final Integer SIETE = 7;
	private static final Integer OCHO = 8;
	private static final Integer NUEVE = 9;
	private static final String PUNTO = ".";
	private static final String EMPTY_STRING = "";
	
	private static final int STATE_INIT = 0;
	private static final int STATE_CAPTURE = 1;
	private static final int STATE_OPERATOR = 2;
	private static final int STATE_CALCULATE = 3;
	private static final int ACTION_NUMBER = 0;
	private static final int ACTION_OPERATOR = 1;
	private static final int ACTION_EQUAL = 2;
	private static final int ACTION_CLEAN = 3;
	
	private int state;
	private Double valor1;
	private Double valor2;
	private Double resultado;
	private Calculadora calculadora;
	private int operator;
	
	private JTextField display;
	private JButton button0;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	private JButton button7;
	private JButton button8;
	private JButton button9;
	private JButton buttonPunto;
	private JButton buttonLimpiar;
	private JButton buttonPorcentaje;
	private JButton buttonDivision;
	private JButton buttonProducto;
	private JButton buttonSuma;
	private JButton buttonResta;
	private JButton buttonIgual;
	
	public VentanaCalculadora() {
		state = STATE_INIT;
		calculadora = new Calculadora();
		initComponents();
	}
	
	private void initComponents() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(500,400);
		setResizable(false);
		instantiateComponents();
		buildGrid();
		initializeListener();
		setVisible(true);
	}
	
	private void capturarNumero(String numero) {
		updateDisplay(numero);
		updateState(ACTION_NUMBER);
	}
	
	private void capturarOperator(int operator) {
		setOperator(operator);
		updateState(ACTION_OPERATOR);
	}
	
	private void initializeListener() {
		button0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				capturarNumero(CERO.toString());
			}
		});
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				capturarNumero(UNO.toString());
			}
		});
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				capturarNumero(DOS.toString());
			}
		});
		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				capturarNumero(TRES.toString());
			}
		});
		button4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				capturarNumero(CUATRO.toString());
			}
		});
		button5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				capturarNumero(CINCO.toString());
			}
		});
		button6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				capturarNumero(SEIS.toString());
			}
		});
		button7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				capturarNumero(SIETE.toString());
			}
		});
		button8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				capturarNumero(OCHO.toString());
			}
		});
		button9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				capturarNumero(NUEVE.toString());
			}
		});
		buttonPunto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				capturarNumero(PUNTO.toString());
			}
		});
		buttonLimpiar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cleanDisplay();
			}
		});
		buttonSuma.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				capturarOperator(Calculadora.OPERATOR_SUMA);
			}
		});
		buttonResta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				capturarOperator(Calculadora.OPERATOR_RESTA);
			}
		});
		buttonProducto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				capturarOperator(Calculadora.OPERATOR_PRODUCTO);
			}
		});
		buttonDivision.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				capturarOperator(Calculadora.OPERATOR_DIVISION);
			}
		});
		buttonPorcentaje.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				capturarOperator(Calculadora.OPERATOR_PORCENTAJE);
			}
		});	
		buttonIgual.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				updateState(ACTION_EQUAL);
				updateDisplay("");
			}
		});	
	}
	
	private void updateState(int action) {
		if(action == ACTION_CLEAN) {
			state = STATE_INIT;
		}else if(state == STATE_INIT && action == ACTION_NUMBER || state == STATE_OPERATOR && action == ACTION_NUMBER || state == STATE_CALCULATE && action == ACTION_NUMBER) {
			state = STATE_CAPTURE;
		}else if(state == STATE_CAPTURE && action == ACTION_OPERATOR || state == STATE_CALCULATE && action == ACTION_OPERATOR) {
			state = STATE_OPERATOR;
		}else if(state == STATE_CAPTURE && action == ACTION_EQUAL) {
			state = STATE_CALCULATE;
		}
	}
	
	private void cleanDisplay() {
		display.setText(EMPTY_STRING);
		updateState(ACTION_CLEAN);
	}
	
	
	private void updateDisplay(String valor) {
		if(state == STATE_CAPTURE || state == STATE_INIT) {
			display.setText( display.getText() + valor );
		}else if(state == STATE_OPERATOR) {
			valor1 = Double.parseDouble(display.getText());
			display.setText(valor);
		}else if(state == STATE_CALCULATE) {
			valor2 = Double.parseDouble(display.getText());
			resultado = calculadora.calculate(operator, valor1, valor2);
			display.setText(resultado.toString());
			//cleanDisplay();
		}
	}
	
	
	private void buildGrid() {
		Container pane = getContentPane();
		GridBagLayout calculadoraGrid = new GridBagLayout();
		GridBagConstraints calculadoraGridConstraints = new GridBagConstraints();
		pane.setLayout(calculadoraGrid);
		calculadoraGridConstraints.fill = GridBagConstraints.HORIZONTAL;
		calculadoraGridConstraints.weightx = 0.5;
		calculadoraGridConstraints.ipady = 30;
		
		calculadoraGridConstraints.gridx = 0;
		calculadoraGridConstraints.gridy = 0;
		calculadoraGridConstraints.gridwidth = 4;
		pane.add(display, calculadoraGridConstraints);
		
		calculadoraGridConstraints.gridwidth = 1;
		calculadoraGridConstraints.gridx = 0;
		calculadoraGridConstraints.gridy = 1;
		pane.add(buttonLimpiar, calculadoraGridConstraints);
		calculadoraGridConstraints.gridx = 1;
		calculadoraGridConstraints.gridy = 1;
		pane.add(buttonPorcentaje, calculadoraGridConstraints);
		calculadoraGridConstraints.gridx = 2;
		calculadoraGridConstraints.gridy = 1;
		pane.add(buttonDivision, calculadoraGridConstraints);
		calculadoraGridConstraints.gridx = 3;
		calculadoraGridConstraints.gridy = 1;
		pane.add(buttonProducto, calculadoraGridConstraints);
		
		calculadoraGridConstraints.gridx = 0;
		calculadoraGridConstraints.gridy = 2;
		pane.add(button7, calculadoraGridConstraints);
		calculadoraGridConstraints.gridx = 1;
		calculadoraGridConstraints.gridy = 2;
		pane.add(button8, calculadoraGridConstraints);
		calculadoraGridConstraints.gridx = 2;
		calculadoraGridConstraints.gridy = 2;
		pane.add(button9, calculadoraGridConstraints);
		calculadoraGridConstraints.gridx = 3;
		calculadoraGridConstraints.gridy = 2;
		pane.add(buttonSuma, calculadoraGridConstraints);
		
		calculadoraGridConstraints.gridx = 0;
		calculadoraGridConstraints.gridy = 3;
		pane.add(button4, calculadoraGridConstraints);
		calculadoraGridConstraints.gridx = 1;
		calculadoraGridConstraints.gridy = 3;
		pane.add(button5, calculadoraGridConstraints);
		calculadoraGridConstraints.gridx = 2;
		calculadoraGridConstraints.gridy = 3;
		pane.add(button6, calculadoraGridConstraints);
		calculadoraGridConstraints.gridx = 3;
		calculadoraGridConstraints.gridy = 3;
		pane.add(buttonResta, calculadoraGridConstraints);
		
		calculadoraGridConstraints.gridx = 0;
		calculadoraGridConstraints.gridy = 4;
		pane.add(button1, calculadoraGridConstraints);
		calculadoraGridConstraints.gridx = 1;
		calculadoraGridConstraints.gridy = 4;
		pane.add(button2, calculadoraGridConstraints);
		calculadoraGridConstraints.gridx = 2;
		calculadoraGridConstraints.gridy = 4;
		pane.add(button3, calculadoraGridConstraints);
		
		calculadoraGridConstraints.gridx = 3;
		calculadoraGridConstraints.gridy = 4;
		calculadoraGridConstraints.gridheight = 2;
		calculadoraGridConstraints.ipady = 85;
		pane.add(buttonIgual, calculadoraGridConstraints);
		
		calculadoraGridConstraints.ipady = 30;
		calculadoraGridConstraints.gridheight = 1;
		calculadoraGridConstraints.gridwidth = 2;
		calculadoraGridConstraints.gridx = 0;
		calculadoraGridConstraints.gridy = 5;
		pane.add(button0, calculadoraGridConstraints);
		
		calculadoraGridConstraints.gridwidth = 1;
		calculadoraGridConstraints.gridx = 2;
		calculadoraGridConstraints.gridy = 5;
		pane.add(buttonPunto, calculadoraGridConstraints);
		
	}
	
	
	private void instantiateComponents() {
		display = new JTextField("");
		display.setEditable(false);
		display.setHorizontalAlignment(JTextField.RIGHT);
		button0 = new JButton("0");
		button1 = new JButton("1");
		button2 = new JButton("2");
		button3 = new JButton("3");
		button4 = new JButton("4");
		button5 = new JButton("5");
		button6 = new JButton("6");
		button7 = new JButton("7");
		button8 = new JButton("8");
		button9 = new JButton("9");
		buttonPunto = new JButton(".");
		buttonLimpiar = new JButton("AC");
		buttonPorcentaje = new JButton("%");
		buttonDivision = new JButton("/");
		buttonProducto = new JButton("X");
		buttonSuma = new JButton("+");
		buttonResta = new JButton("-");
		buttonIgual = new JButton("=");
	}
	
	
	public void setOperator(int operator) {
		this.operator = operator;
	}
	
	
	
	
	
}
