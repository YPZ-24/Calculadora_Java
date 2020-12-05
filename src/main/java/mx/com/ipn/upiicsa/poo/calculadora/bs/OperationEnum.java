package mx.com.ipn.upiicsa.poo.calculadora.bs;

public enum OperationEnum{
	SUMA(0, 2),
	RESTA(1, 2),
	PRODUCTO(3, 2),
	DIVISION(4, 2),
	PORCENTAJE(5, 2),
	POTENCIA_2(6, 1),
	POTENCIA_3(7, 1),
	POTENCIA_Y(8, 2),
	POTENCIA_E(9, 1),
	NOTACION_EXPONENCIAL(10, 1),
	INVERSA(11, 1),
	RAIZ_2(12, 1),
	RAIZ_3(13, 1),
	RAIZ_Y(14, 2),
	LOG_NATURAL(15, 1),
	LOG_BASE_10(16, 1),
	FACTORIAL(17, 1),
	SENO(18, 1),
	COSENO(19, 1),
	TANGENTE(20, 1);
	
	private int id;
	private int params;

	private OperationEnum(int id, int params) {
		this.id = id;
		this.params = params;
	}

	public int getId() {
		return id;
	}

	public int getParams() {
		return params;
	}
	
}