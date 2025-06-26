package br.com.wendelsegadilha.testesunitarios;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculadoraUnitTest {

	private Calculadora calculadora;

	@BeforeAll
	static void ConfiguracaoGlobalStart() {
		System.out.println("Iniciando suíte de testes da Calculadora");
	}

	@BeforeEach
	void setUp() {
		calculadora = new Calculadora();
	}

	@Test
	void deveSomarComSucesso() {
		var resultado = calculadora.somar(10.0, 5.0);
		assertNotNull(resultado);
		assertTrue(resultado > 0);
		assertEquals(15.0, resultado);
	}
	
	@Test
	void deveSomarComFalhaNull() {
		var exception = assertThrows(IllegalArgumentException.class, () -> calculadora.somar(null, 5.0));
		assertEquals("Os parâmetros não podem ser nulos.", exception.getMessage());
	}
	
	@ParameterizedTest(name = "{0} + {1} = {2}")
	@CsvSource({
		"1, 2, 3",
        "5, 5, 10",
        "10, -2, 8"
	})
	void deveSomarComSucessoComParametros(Double a, Double b, Double esperado) {
		assertEquals(esperado, calculadora.somar(a, b));
	}
	
	@Test
	void deveSubtrairComSucesso() {
		var resultado = calculadora.subtrair(10.0, 5.0);
		assertEquals(5.0, resultado);
	}
	
	@Test
	void deveSubtrairComFalhaNull() {
		var exception = assertThrows(IllegalArgumentException.class, () -> calculadora.subtrair(10.0, null));
		assertEquals("Os parâmetros não podem ser nulos.", exception.getMessage());
	}
	
	@Test
	void deveMultiplicarComSucesso() {
		var resultado = calculadora.multiplicar(10.0, 5.0);
		assertAll(
				() -> assertNotNull(resultado),
				() -> assertTrue(resultado > 0),
				() -> assertEquals(50.0, resultado)
			);
	}
	
	@Test
	void deveDividirComSucesso() {
		var resultado = calculadora.dividir(10.0, 2.0);
		assertEquals(5.0, resultado);
	}
	
	@DisplayName("Teste de divisão com sucesso para vários valores")
    @ParameterizedTest(name = "{0} / {1} = {2}")
    @CsvSource({
        "10, 2, 5",
        "20, 4, 5",
        "9, 3, 3"
    })
    void deveDividirComSucessoComParametros(Double a, Double b, Double esperado) {
        assertEquals(esperado, calculadora.dividir(a, b));
    }
	
	@Test
	void deveDividirComFalhaDivizaoPorZero() {
		var exception = assertThrows(ArithmeticException.class, () -> calculadora.dividir(10.0, 0.0));
		assertEquals("Divisão por zero não é permitida.", exception.getMessage());
	}
	
	@Test
	void deveDividirComFalhaNull() {
		var exception = assertThrows(IllegalArgumentException.class, () -> calculadora.dividir(null, 10.0));
		assertEquals("Os parâmetros não podem ser nulos.", exception.getMessage());
	}
	
	@Test
	void deveMultiplicarComFalhaNull() {
		var exception = assertThrows(IllegalArgumentException.class, () -> calculadora.multiplicar(null, null));
		assertEquals("Os parâmetros não podem ser nulos.", exception.getMessage());
	}
	
	
	@AfterEach
	 void tearDown() {
        System.out.println("Teste finalizado.");
    }
	
	@AfterAll
	static void ConfiguracaoGlobalEnd() {
		System.out.println("Finalizando suíte de testes da Calculadora");
	}
	
	/**
	 | Anotação             | Explicação                                                                    |
	| -------------------- | ----------------------------------------------------------------------------- |
	| `@BeforeAll`         | Executa **uma vez antes** de todos os testes da classe. Precisa ser `static`. |
	| `@BeforeEach`        | Executa **antes de cada** teste individual. Usado para preparar o ambiente.   |
	| `@Test`              | Indica que o método é um **teste unitário** comum.                            |
	| `@ParameterizedTest` | Permite executar o mesmo teste com **diferentes parâmetros**.                 |
	| `@CsvSource`         | Fornece os valores dos parâmetros do `@ParameterizedTest`.                    |
	| `@AfterEach`         | Executa **depois de cada** teste. Útil para limpar ou mostrar mensagens.      |
	| `@AfterAll`          | Executa **uma única vez após** todos os testes. Precisa ser `static`.         |

	Dicas Extras para JUnit
	Use assertAll quando quiser verificar vários aspectos em um mesmo teste.
	
	Testes parametrizados são ótimos para evitar duplicação de código em testes repetitivos.
	
	Use @DisplayName("Descrição") para tornar o nome dos testes mais legível (opcional).
	
	assertNotEquals, assertFalse, assertArrayEquals, assertSame, entre outros, também são úteis.
	
	*/
	
}
