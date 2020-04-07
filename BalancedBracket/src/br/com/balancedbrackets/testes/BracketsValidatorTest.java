package br.com.balancedbrackets.testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.balancedbrackets.validator.BracketsValidator;

class BracketsValidatorTest {
	private BracketsValidator validator;

	@BeforeEach
	void init() {
		validator = new BracketsValidator();
	}

	@Test
	void deveRetornarFalseComUmParenteseAberto() {
		assertFalse(validator.isBalanced("("));
	}

	@Test
	void deveRetornarFalseComUmaChaveAberta() {
		assertFalse(validator.isBalanced("{"));
	}

	@Test
	void deveRetornarFalseComUmColcheteAberto() {
		assertFalse(validator.isBalanced("["));
	}

	@Test
	void deveRetornarFalseComUmParenteseFechado() {
		assertFalse(validator.isBalanced(")"));
	}

	@Test
	void deveRetornarFalseComUmaChaveFechada() {
		assertFalse(validator.isBalanced("}"));
	}

	@Test
	void deveRetornarFalseComUmColcheteFechado() {
		assertFalse(validator.isBalanced("}"));
	}

	@Test
	void deveRetornarTrueComUmParenteseAbertoEOutroFechado() {
		assertTrue(validator.isBalanced("()"));
	}

	@Test
	void deveRetornarTrueComUmaChaveAbertaEOutraFechada() {
		assertTrue(validator.isBalanced("{}"));
	}

	@Test
	void deveRetornarTrueComUmColcheteAbertoEOutroFechado() {
		assertTrue(validator.isBalanced("[]"));
	}

	@Test
	void deveRetornarFalseComUmParenteseAbertoOutroFechadoEOutroAberto() {
		assertFalse(validator.isBalanced("()("));
	}
	
	@Test
	void deveRetornarFalseComParDeSimbolosDiferentesPrenteseEChave() {
		assertFalse(validator.isBalanced("(}"));
	}

	@Test
	void deveRetornarFalseComParDeSimbolosDiferentesChaveEColchete() {
		assertFalse(validator.isBalanced("{]"));
	}

	@Test
	void deveRetornarFalseComParDeSimbolosDiferentesColcheteEParentese() {
		assertFalse(validator.isBalanced("[)"));
	}

	@Test
	void deveRetornarTrueComUmParenteseAbertoOutroFechadoOutroAbertoEOutroFechad() {
		assertTrue(validator.isBalanced("()()"));
	}

	@Test
	void deveRetornarTrueComParesAlternadosCorretos() {
		assertTrue(validator.isBalanced("(){}[]"));
	}

	@Test
	void deveRetornarTrueComParesAninhadosCorretos() {
		assertTrue(validator.isBalanced("({[]})"));
	}



}
