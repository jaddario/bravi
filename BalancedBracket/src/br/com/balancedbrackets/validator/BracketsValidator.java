package br.com.balancedbrackets.validator;

import java.util.Stack;

public class BracketsValidator {

	public Boolean isBalanced(String input) {
		char[] caracteres = input.toCharArray();
		boolean valido = true;
		Stack<Character> pilha = new Stack<Character>();
		for (Character simboloDaVez : caracteres) {
			if (simboloDaVez.equals('(') || simboloDaVez.equals('{') || simboloDaVez.equals('['))
				pilha.push(simboloDaVez);
			else {
				if (pilha.isEmpty()) {
					valido = false;
					break;
				}
				Character topoDaPilha = pilha.peek();
				if ((simboloDaVez == ')' && topoDaPilha == '(') || (simboloDaVez == '}' && topoDaPilha == '{')
						|| (simboloDaVez == ']' && topoDaPilha == '['))
					pilha.pop();
			}
		}
		return valido && pilha.isEmpty();
	}
}
