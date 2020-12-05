package mx.com.ipn.upiicsa.poo.calculadora.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mx.com.ipn.upiicsa.poo.calculadora.bs.Calculadora;
import mx.com.ipn.upiicsa.poo.calculadora.bs.OperationEnum;
import mx.com.ipn.upiicsa.poo.calculadora.exception.DivZeroException;

public class VentanaCalculadoraBasica extends JPanel{
	
	private static final long serialVersionUID = 1L;
	protected static final Integer CERO = 0;
	protected static final Integer UNO = 1;
	protected static final Integer DOS = 2;
	protected static final Integer TRES = 3;
	protected static final Integer CUATRO = 4;
	protected static final Integer CINCO = 5;
	protected static final Integer SEIS = 6;
	protected static final Integer SIETE = 7;
	protected static final Integer OCHO = 8;
	protected static final Integer NUEVE = 9;
	protected static final String PUNTO = ".";
	protected static final String EMPTY_STRING = "";
	
	protected static final int STATE_INIT = 0;
	protected static final int STATE_CAPTURE = 1;
	protected static final int STATE_OPERATOR = 2;
	protected static final int STATE_CALCULATE = 3;
	protected static final int ACTION_NUMBER = 0;
	protected static final int ACTION_OPERATOR = 1;
	protected static final int ACTION_EQUAL = 2;
	protected static final int ACTION_CLEAN = 3;
	
	protected int state;
	protected Double valor1;
	protected Double valor2;
	protected Double resultado;
	protected Calculadora calculadora;
	protected int operator;
	
	protected JTextField display;
	protected JButton button0;
	protected JButton button1;
	protected JButton button2;
	protected JButton button3;
	protected JButton button4;
	protected JButton button5;
	protected JButton button6;
	protected JButton button7;
	protected JButton button8;
	protected JButton button9;
	protected JButton buttonPunto;
	protected JButton buttonLimpiar;
	protected JButton buttonPorcentaje;
	protected JButton buttonDivision;
	protected JButton buttonProducto;
	protected JButton buttonSuma;
	protected JButton buttonResta;
	protected JButton buttonIgual;
	
	public VentanaCalculadoraBasica() {
		state = STATE_INIT;
		calculadora = new Calculadora();
		initComponents();
	}
	
	protected void initComponents() {
		//setSize(600,400);
		instantiateComponents();
		buildGrid();
		initializeListener();
		setVisible(true);
	}
	
	protected void capturarNumero(String numero) {
		updateDisplay(numero);
		updateState(ACTION_NUMBER);
	}
	
	protected void capturarOperator(int operator) {
		setOperator(operator);
		updateState(ACTION_OPERATOR);
	}
	
	protected void initializeListener() {
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
				capturarOperator(OperationEnum.SUMA.getId());
			}
		});
		buttonResta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				capturarOperator(OperationEnum.RESTA.getId());
			}
		});
		buttonProducto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				capturarOperator(OperationEnum.PRODUCTO.getId());
			}
		});
		buttonDivision.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				capturarOperator(OperationEnum.DIVISION.getId());
			}
		});
		buttonPorcentaje.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				capturarOperator(OperationEnum.PORCENTAJE.getId());
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
	
	protected void updateState(int action) {
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
	
	protected void cleanDisplay() {
		display.setText(EMPTY_STRING);
		updateState(ACTION_CLEAN);
	}
	
	
	protected void updateDisplay(String valor) {
		if(state == STATE_INIT) {
			display.setText(valor);
		}else if(state == STATE_CAPTURE) {
			display.setText( display.getText() + valor );
		}else if(state == STATE_OPERATOR) {
			valor1 = Double.parseDouble(display.getText());
			display.setText(valor);
		}else if(state == STATE_CALCULATE) {
			String resultadoString = null;
			valor2 = Double.parseDouble(display.getText());
			try {
				resultado = calculateResult();
				resultadoString = resultado.toString();
			}catch(DivZeroException e) {
				resultadoString = "SYNTAX ERROR";
				updateState(ACTION_CLEAN);
				JOptionPane.showMessageDialog(this, "SYNTAX ERROR", "ERROR", JOptionPane.ERROR_MESSAGE);
			} finally {
				display.setText(resultadoString);
			}
		}
	}
	
	protected Double calculateResult() throws DivZeroException {
		return calculadora.calculate(operator, valor1, valor2);
	}
	
	
	protected void buildGrid() {
		GridBagLayout calculadoraGrid = new GridBagLayout();
		GridBagConstraints calculadoraGridConstraints = new GridBagConstraints();
		setLayout(calculadoraGrid);
		calculadoraGridConstraints.fill = GridBagConstraints.HORIZONTAL;
		calculadoraGridConstraints.weightx = 0.5;
		calculadoraGridConstraints.ipady = 30;
		
		calculadoraGridConstraints.gridx = 0;
		calculadoraGridConstraints.gridy = 0;
		calculadoraGridConstraints.gridwidth = 4;
		add(display, calculadoraGridConstraints);
		
		calculadoraGridConstraints.gridwidth = 1;
		calculadoraGridConstraints.gridx = 0;
		calculadoraGridConstraints.gridy = 1;
		add(buttonLimpiar, calculadoraGridConstraints);
		calculadoraGridConstraints.gridx = 1;
		calculadoraGridConstraints.gridy = 1;
		add(buttonPorcentaje, calculadoraGridConstraints);
		calculadoraGridConstraints.gridx = 2;
		calculadoraGridConstraints.gridy = 1;
		add(buttonDivision, calculadoraGridConstraints);
		calculadoraGridConstraints.gridx = 3;
		calculadoraGridConstraints.gridy = 1;
		add(buttonProducto, calculadoraGridConstraints);
		
		calculadoraGridConstraints.gridx = 0;
		calculadoraGridConstraints.gridy = 2;
		add(button7, calculadoraGridConstraints);
		calculadoraGridConstraints.gridx = 1;
		calculadoraGridConstraints.gridy = 2;
		add(button8, calculadoraGridConstraints);
		calculadoraGridConstraints.gridx = 2;
		calculadoraGridConstraints.gridy = 2;
		add(button9, calculadoraGridConstraints);
		calculadoraGridConstraints.gridx = 3;
		calculadoraGridConstraints.gridy = 2;
		add(buttonSuma, calculadoraGridConstraints);
		
		calculadoraGridConstraints.gridx = 0;
		calculadoraGridConstraints.gridy = 3;
		add(button4, calculadoraGridConstraints);
		calculadoraGridConstraints.gridx = 1;
		calculadoraGridConstraints.gridy = 3;
		add(button5, calculadoraGridConstraints);
		calculadoraGridConstraints.gridx = 2;
		calculadoraGridConstraints.gridy = 3;
		add(button6, calculadoraGridConstraints);
		calculadoraGridConstraints.gridx = 3;
		calculadoraGridConstraints.gridy = 3;
		add(buttonResta, calculadoraGridConstraints);
		
		calculadoraGridConstraints.gridx = 0;
		calculadoraGridConstraints.gridy = 4;
		add(button1, calculadoraGridConstraints);
		calculadoraGridConstraints.gridx = 1;
		calculadoraGridConstraints.gridy = 4;
		add(button2, calculadoraGridConstraints);
		calculadoraGridConstraints.gridx = 2;
		calculadoraGridConstraints.gridy = 4;
		add(button3, calculadoraGridConstraints);
		
		calculadoraGridConstraints.gridx = 3;
		calculadoraGridConstraints.gridy = 4;
		calculadoraGridConstraints.gridheight = 2;
		calculadoraGridConstraints.ipady = 85;
		add(buttonIgual, calculadoraGridConstraints);
		
		calculadoraGridConstraints.ipady = 30;
		calculadoraGridConstraints.gridheight = 1;
		calculadoraGridConstraints.gridwidth = 2;
		calculadoraGridConstraints.gridx = 0;
		calculadoraGridConstraints.gridy = 5;
		add(button0, calculadoraGridConstraints);
		
		calculadoraGridConstraints.gridwidth = 1;
		calculadoraGridConstraints.gridx = 2;
		calculadoraGridConstraints.gridy = 5;
		add(buttonPunto, calculadoraGridConstraints);
	}
	
	
	protected void instantiateComponents() {
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
