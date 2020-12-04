package mx.com.ipn.upiicsa.poo.calculadora.bs;

import java.util.HashMap;
import java.util.Map;

import mx.com.ipn.upiicsa.poo.calculadora.exception.DivZeroException;

public class Calculadora {
	
	public static final Map<String,OperationEnum> operationsEnum = new HashMap<String,OperationEnum>();
	
	public Double calculate(int operator, Double valor1, Double valor2) throws DivZeroException {
		Double resultado = 0d;
		if(operator == OperationEnum.SUMA.getId()) {
			resultado = suma(valor1, valor2);
		}else if(operator == OperationEnum.RESTA.getId()) {
			resultado = resta(valor1, valor2);
		}else if(operator == OperationEnum.PRODUCTO.getId()) {
			resultado = producto(valor1, valor2);
		}else if(operator == OperationEnum.DIVISION.getId()) {
			resultado = division(valor1, valor2);
		}else if(operator == OperationEnum.PORCENTAJE.getId()) {
			resultado = porcentaje(valor1, valor2);
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
	public Double division(Double dividendo, Double divisor) throws DivZeroException {
		if(divisor==0) {
			throw new DivZeroException();
		}
		return dividendo/divisor;
	}
	public Double porcentaje(Double cantidad, Double porcentaje) {
		return (cantidad*porcentaje)/100;
	}
	
}
