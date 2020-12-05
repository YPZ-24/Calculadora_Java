package mx.com.ipn.upiicsa.poo.calculadora.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import mx.com.ipn.upiicsa.poo.calculadora.bs.CalculadoraCientifica;
import mx.com.ipn.upiicsa.poo.calculadora.bs.OperationEnum;
import mx.com.ipn.upiicsa.poo.calculadora.exception.DivZeroException;

public class VentanaCalculadoraCientifica extends VentanaCalculadoraBasica{

	private static final long serialVersionUID = 1L;
	protected static final Double PI = Math.PI;
	protected static final Double E = Math.E;
	protected CalculadoraCientifica calculadoraCientifica;
	
	private JButton buttonPotencia2;
	private JButton buttonPotencia3;
	private JButton buttonPotenciaY;
	private JButton buttonPotenciaE;
	private JButton buttonNotacionExponencial;
	private JButton buttonInversa;
	private JButton buttonRaiz2;
	private JButton buttonRaiz3;
	private JButton buttonRaizY;
	private JButton buttonLogNatural;
	private JButton buttonLogBase10;
	private JButton buttonFactorial;
	private JButton buttonSeno;
	private JButton buttonCoseno;
	private JButton buttonTangente;
	private JButton buttonNumE;
	private JButton buttonPi;
	
	public VentanaCalculadoraCientifica(){
		super();
		calculadoraCientifica = new CalculadoraCientifica();
	}

	@Override
	protected void initComponents() {
		instantiateComponents();
		buildGrid();
		initializeListener();
		setVisible(true);
	}

	@Override
	protected void initializeListener() {
		super.initializeListener();
		
		buttonNumE.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				capturarNumero(E.toString());
			}
		});
		
		buttonPi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				capturarNumero(PI.toString());
			}
		});
		
		buttonPotencia2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				capturarOperator(OperationEnum.POTENCIA_2.getId());
			}
		});
		
		buttonPotencia3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				capturarOperator(OperationEnum.POTENCIA_3.getId());
			}
		});
		
		buttonPotenciaY.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				capturarOperator(OperationEnum.POTENCIA_Y.getId());
			}
		});
		
		buttonPotenciaE.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				capturarOperator(OperationEnum.POTENCIA_E.getId());
			}
		});
		
		buttonNotacionExponencial.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				capturarOperator(OperationEnum.NOTACION_EXPONENCIAL.getId());
			}
		});
		
		buttonInversa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				capturarOperator(OperationEnum.INVERSA.getId());
			}
		});
		buttonRaiz2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				capturarOperator(OperationEnum.RAIZ_2.getId());
			}
		});
		buttonRaiz3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				capturarOperator(OperationEnum.RAIZ_3.getId());
			}
		});
		buttonRaizY.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				capturarOperator(OperationEnum.RAIZ_Y.getId());
			}
		});
		buttonLogNatural.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				capturarOperator(OperationEnum.LOG_NATURAL.getId());
			}
		});
		buttonLogBase10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				capturarOperator(OperationEnum.LOG_BASE_10.getId());
			}
		});
		buttonFactorial.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				capturarOperator(OperationEnum.FACTORIAL.getId());
			}
		});
		buttonSeno.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				capturarOperator(OperationEnum.SENO.getId());
			}
		});
		buttonCoseno.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				capturarOperator(OperationEnum.COSENO.getId());
			}
		});
		buttonTangente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				capturarOperator(OperationEnum.TANGENTE.getId());
			}
		});
	}
	
	@Override
	protected Double calculateResult() throws DivZeroException {
		return calculadoraCientifica.calculate(operator, valor1, valor2);
	}

	@Override
	protected void updateState(int action) {
		if(state == STATE_CAPTURE && action == ACTION_OPERATOR || state == STATE_CALCULATE && action == ACTION_OPERATOR) {
			boolean oneParam = CalculadoraCientifica.hasOneParam((Integer)operator);
			if(oneParam) {
				state = STATE_CALCULATE;
			}else {
				state = STATE_OPERATOR;
			}
		}else if(action == ACTION_CLEAN) {
			state = STATE_INIT;
		}else if(state == STATE_INIT && action == ACTION_NUMBER || state == STATE_CALCULATE && action == ACTION_NUMBER || state == STATE_OPERATOR && action == ACTION_NUMBER) {
			state = STATE_CAPTURE;
		
		}else if(state == STATE_CAPTURE && action == ACTION_EQUAL) {
			state = STATE_CALCULATE;
		}
	}

	@Override
	protected void buildGrid() {
		GridBagLayout calculadoraGrid = new GridBagLayout();
		GridBagConstraints calculadoraGridConstraints = new GridBagConstraints();
		setLayout(calculadoraGrid);
		calculadoraGridConstraints.fill = GridBagConstraints.HORIZONTAL;
		calculadoraGridConstraints.weightx = 0.5;
		calculadoraGridConstraints.ipady = 30;
		
		calculadoraGridConstraints.gridx = 0;
		calculadoraGridConstraints.gridy = 0;
		calculadoraGridConstraints.gridwidth = 8;
		add(display, calculadoraGridConstraints);
		
		calculadoraGridConstraints.gridwidth = 1;
		calculadoraGridConstraints.gridx = 4;
		calculadoraGridConstraints.gridy = 1;
		add(buttonLimpiar, calculadoraGridConstraints);
		calculadoraGridConstraints.gridx = 5;
		calculadoraGridConstraints.gridy = 1;
		add(buttonPorcentaje, calculadoraGridConstraints);
		calculadoraGridConstraints.gridx = 6;
		calculadoraGridConstraints.gridy = 1;
		add(buttonDivision, calculadoraGridConstraints);
		calculadoraGridConstraints.gridx = 7;
		calculadoraGridConstraints.gridy = 1;
		add(buttonProducto, calculadoraGridConstraints);
		
		calculadoraGridConstraints.gridx = 4;
		calculadoraGridConstraints.gridy = 2;
		add(button7, calculadoraGridConstraints);
		calculadoraGridConstraints.gridx = 5;
		calculadoraGridConstraints.gridy = 2;
		add(button8, calculadoraGridConstraints);
		calculadoraGridConstraints.gridx = 6;
		calculadoraGridConstraints.gridy = 2;
		add(button9, calculadoraGridConstraints);
		calculadoraGridConstraints.gridx = 7;
		calculadoraGridConstraints.gridy = 2;
		add(buttonSuma, calculadoraGridConstraints);
		
		calculadoraGridConstraints.gridx = 4;
		calculadoraGridConstraints.gridy = 3;
		add(button4, calculadoraGridConstraints);
		calculadoraGridConstraints.gridx = 5;
		calculadoraGridConstraints.gridy = 3;
		add(button5, calculadoraGridConstraints);
		calculadoraGridConstraints.gridx = 6;
		calculadoraGridConstraints.gridy = 3;
		add(button6, calculadoraGridConstraints);
		calculadoraGridConstraints.gridx = 7;
		calculadoraGridConstraints.gridy = 3;
		add(buttonResta, calculadoraGridConstraints);
		
		calculadoraGridConstraints.gridx = 4;
		calculadoraGridConstraints.gridy = 4;
		add(button1, calculadoraGridConstraints);
		calculadoraGridConstraints.gridx = 5;
		calculadoraGridConstraints.gridy = 4;
		add(button2, calculadoraGridConstraints);
		calculadoraGridConstraints.gridx = 6;
		calculadoraGridConstraints.gridy = 4;
		add(button3, calculadoraGridConstraints);
		
		calculadoraGridConstraints.gridx = 7;
		calculadoraGridConstraints.gridy = 4;
		calculadoraGridConstraints.gridheight = 2;
		calculadoraGridConstraints.ipady = 85;
		add(buttonIgual, calculadoraGridConstraints);
		
		calculadoraGridConstraints.ipady = 30;
		calculadoraGridConstraints.gridheight = 1;
		calculadoraGridConstraints.gridwidth = 2;
		calculadoraGridConstraints.gridx = 4;
		calculadoraGridConstraints.gridy = 5;
		add(button0, calculadoraGridConstraints);
		
		calculadoraGridConstraints.gridwidth = 1;
		calculadoraGridConstraints.gridx = 6;
		calculadoraGridConstraints.gridy = 5;
		add(buttonPunto, calculadoraGridConstraints);
		
		/*CIENTIFICA*/
		calculadoraGridConstraints.gridwidth = 1;
		calculadoraGridConstraints.gridx = 0;
		calculadoraGridConstraints.gridy = 1;
		add(buttonPotencia2, calculadoraGridConstraints);
		calculadoraGridConstraints.gridx = 1;
		calculadoraGridConstraints.gridy = 1;
		add(buttonPotencia3, calculadoraGridConstraints);
		calculadoraGridConstraints.gridx = 2;
		calculadoraGridConstraints.gridy = 1;
		add(buttonPotenciaY, calculadoraGridConstraints);
		calculadoraGridConstraints.gridx = 3;
		calculadoraGridConstraints.gridy = 1;
		add(buttonPotenciaE, calculadoraGridConstraints);
		
		calculadoraGridConstraints.gridwidth = 1;
		calculadoraGridConstraints.gridx = 0;
		calculadoraGridConstraints.gridy = 2;
		add(buttonInversa, calculadoraGridConstraints);
		calculadoraGridConstraints.gridx = 1;
		calculadoraGridConstraints.gridy = 2;
		add(buttonRaiz2, calculadoraGridConstraints);
		calculadoraGridConstraints.gridx = 2;
		calculadoraGridConstraints.gridy = 2;
		add(buttonRaiz3, calculadoraGridConstraints);
		calculadoraGridConstraints.gridx = 3;
		calculadoraGridConstraints.gridy = 2;
		add(buttonRaizY, calculadoraGridConstraints);
		
		calculadoraGridConstraints.gridwidth = 1;
		calculadoraGridConstraints.gridx = 0;
		calculadoraGridConstraints.gridy = 3;
		add(buttonLogNatural, calculadoraGridConstraints);
		calculadoraGridConstraints.gridx = 1;
		calculadoraGridConstraints.gridy = 3;
		add(buttonLogBase10, calculadoraGridConstraints);
		calculadoraGridConstraints.gridx = 2;
		calculadoraGridConstraints.gridy = 3;
		add(buttonFactorial, calculadoraGridConstraints);
		calculadoraGridConstraints.gridx = 3;
		calculadoraGridConstraints.gridy = 3;
		add(buttonNumE, calculadoraGridConstraints);
		
		calculadoraGridConstraints.gridwidth = 1;
		calculadoraGridConstraints.gridx = 0;
		calculadoraGridConstraints.gridy = 4;
		add(buttonSeno, calculadoraGridConstraints);
		calculadoraGridConstraints.gridx = 1;
		calculadoraGridConstraints.gridy = 4;
		add(buttonCoseno, calculadoraGridConstraints);
		calculadoraGridConstraints.gridx = 2;
		calculadoraGridConstraints.gridy = 4;
		add(buttonTangente, calculadoraGridConstraints);
		calculadoraGridConstraints.gridx = 3;
		calculadoraGridConstraints.gridy = 4;
		add(buttonPi, calculadoraGridConstraints);
		
		calculadoraGridConstraints.gridwidth = 4;
		calculadoraGridConstraints.gridx = 0;
		calculadoraGridConstraints.gridy = 5;
		add(buttonNotacionExponencial, calculadoraGridConstraints);
		
	}

	@Override
	protected void instantiateComponents() {
		super.instantiateComponents();
		buttonPotencia2 = new MyJButton("x\u00B2");
		buttonPotencia3 = new MyJButton("x\u00B3");
		buttonPotenciaY = new MyJButton("x^y");
		buttonPotenciaE = new MyJButton("e^x");
		buttonNotacionExponencial = new MyJButton("10^x");
		buttonInversa = new MyJButton("1/X");
		buttonRaiz2 = new MyJButton("\u00B2√");
		buttonRaiz3 = new MyJButton("\u00B3√");
		buttonRaizY = new MyJButton("x√y");
		buttonLogNatural = new MyJButton("ln");
		buttonLogBase10 = new MyJButton("log10");
		buttonFactorial = new MyJButton("x!");
		buttonSeno = new MyJButton("sen");
		buttonCoseno = new MyJButton("cos");
		buttonTangente = new MyJButton("tan");
		buttonNumE = new MyJButton("e");
		buttonPi = new MyJButton("π");
	}
	
	
	
	
	
	
	
}
