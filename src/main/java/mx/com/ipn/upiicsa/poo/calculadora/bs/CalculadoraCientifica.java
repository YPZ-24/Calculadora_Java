package mx.com.ipn.upiicsa.poo.calculadora.bs;

import java.util.HashMap;
import java.util.Map;

import mx.com.ipn.upiicsa.poo.calculadora.exception.DivZeroException;

public class CalculadoraCientifica extends Calculadora {
	
	public static final Map<String,OperationEnum> operationsEnum = new HashMap<String,OperationEnum>();
	
	@Override
	public Double calculate(int operator, Double valor1, Double valor2) throws DivZeroException {
		Double resultado = super.calculate(operator, valor1, valor2);
	
		if(operator == OperationEnum.POTENCIA_2.getId()) {
			resultado = potencia2(valor2);
		}else if(operator == OperationEnum.POTENCIA_3.getId()) {
			resultado = potencia3(valor2);
		}else if(operator == OperationEnum.POTENCIA_Y.getId()) {
			resultado = potenciaY(valor1, valor2);
		}else if(operator == OperationEnum.POTENCIA_E.getId()) {
			resultado = potenciaE(valor2);
		}else if(operator == OperationEnum.NOTACION_EXPONENCIAL.getId()) {
			resultado = -1000d;
		}else if(operator == OperationEnum.INVERSA.getId()) {
			resultado = inversa(valor2);;
		}else if(operator == OperationEnum.RAIZ_2.getId()) {
			resultado = raiz2(valor2);
		}else if(operator == OperationEnum.RAIZ_3.getId()) {
			resultado = raiz3(valor2);
		}else if(operator == OperationEnum.RAIZ_Y.getId()) {
			resultado = raizY(valor1, valor2);
		}else if(operator == OperationEnum.LOG_NATURAL.getId()) {
			resultado = logNatural(valor2);
		}else if(operator == OperationEnum.LOG_BASE_10.getId()) {
			resultado = logBase10(valor2);
		}else if(operator == OperationEnum.FACTORIAL.getId()) {
			resultado = factorial(valor2);
		}else if(operator == OperationEnum.SENO.getId()) {
			resultado = seno(valor2);
		}else if(operator == OperationEnum.COSENO.getId()) {
			resultado = coseno(valor2);
		}else if(operator == OperationEnum.TANGENTE.getId()) {
			resultado = tangente(valor2);
		}
		
		return resultado;
	}

	public static boolean hasOneParam(Integer operation){
		boolean hasOne = false;
		OperationEnum operationEnum = operationsEnum.get(operation);
		for(OperationEnum o : OperationEnum.values()) {
	        if(o.getId()==operation) {
	        	hasOne = o.getParams()==1 ? true : false;
	        	break;
	        }
		}
		return hasOne;
	}
	
	public Double potencia2(Double base) {
		return Math.pow(base, 2);
	}
	
	public Double potencia3(Double base) {
		return Math.pow(base, 3);
	}
	
	public Double potenciaY(Double base, Double y) {
		return Math.pow(base, y);
	}
	
	public Double potenciaE(Double y) {
		return Math.pow(Math.E, y);
	}
	/*
	public Double notacionExponencial() {
		
	}*/
	public Double inversa(Double num) {
		return 1/num;
	}
	
	public Double raiz2(Double radicando) {
		return Math.sqrt(radicando);
	}
	
	public Double raiz3(Double radicando) {
		return Math.cbrt(radicando);
	}
	
	public Double raizY(Double indice, Double radicando) {
		return Math.pow(radicando, 1/indice);
	}
	
	public Double logNatural(Double num) {
		return Math.log1p(num);
	}
	
	public Double logBase10(Double num) {
		return Math.log10(num);
	}
	
	public Double factorial(Double num) {
		Integer facto = 1;
		for (int x=2;x<=Integer.parseInt(num.toString());x++) {
			  facto = facto * x;
		}
		return Double.valueOf(facto);
	}
	
	public Double seno(Double num) {
		return Math.sin(num);
	}
	
	public Double coseno(Double num) {
		return Math.cos(num);
	}
	
	public Double tangente(Double num) {
		return Math.tan(num);
	}
	
	
}
