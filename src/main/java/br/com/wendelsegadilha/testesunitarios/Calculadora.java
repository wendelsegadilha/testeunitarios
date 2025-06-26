package br.com.wendelsegadilha.testesunitarios;

import java.util.Objects;

public class Calculadora {

	public Double somar(Double a, Double b) {
		this.validar(a, b);
		return a + b;
	}

	public Double subtrair(Double a, Double b) {
		this.validar(a, b);
		return a - b;
	}

	public Double multiplicar(Double a, Double b) {
		this.validar(a, b);
		return a * b;
	}

	public Double dividir(Double a, Double b) {
		this.validar(a, b);
		if (b == 0) {
			throw new ArithmeticException("Divisão por zero não é permitida.");
		}
		return a / b;
	}

	private void validar(Double a, Double b) {
		if (Objects.isNull(a) || Objects.isNull(b)) {
			throw new IllegalArgumentException("Os parâmetros não podem ser nulos.");
		}
	}

}
