package br.com.wendelsegadilha.testesunitarios;

public class App {
    public static void main(String[] args) {
        
    	Calculadora calc = new Calculadora();
    	Double resultado = calc.somar(10.0, 5.0);
    	System.out.println(resultado);
    	
    }
}
