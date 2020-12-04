package mx.com.ipn.upiicsa.poo.calculadora.bs;

public class Calculadora {
	public static final int OPERATOR_SUMA = 1;
	public static final int OPERATOR_RESTA = 2;
	public static final int OPERATOR_PRODUCTO = 3;
	public static final int OPERATOR_DIVISION = 4;
	public static final int OPERATOR_PORCENTAJE = 5;
	
	
	public Double calculate(int operator, Double valor1, Double valor2) {
		Double resultado = 0d;
		switch (operator) {
		case OPERATOR_SUMA:
			resultado = suma(valor1, valor2);
			break;
		case OPERATOR_RESTA:
			resultado = resta(valor1, valor2);
			break;
		case OPERATOR_PRODUCTO:
			resultado = producto(valor1, valor2);
			break;
		case OPERATOR_DIVISION:
			resultado = division(valor1, valor2);
			break;
		case OPERATOR_PORCENTAJE:
			resultado = porcentaje(valor1, valor2);
			break;
		default:
			resultado = -1d;
			break;
		}
		return resultado;
	}
	
	public Double suma(Double sumando1, Double sumando2) {
		return sumando1 + sumando2;
	}
	public Double resta(Double minuendo, Double sustraendo) {
		return minuendo - sustraendo;
	}
	public Double producto(Double factor1, Double factor2) {
		return factor1 * factor2;
	}
	public Double division(Double dividendo, Double divisor) {
		return dividendo/divisor;
	}
	public Double porcentaje(Double cantidad, Double porcentaje) {
		return (cantidad*porcentaje)/100;
	}
	
}
