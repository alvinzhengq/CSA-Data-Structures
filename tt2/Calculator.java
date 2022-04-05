
package tt2;

import java.util.*;

public class Calculator {
    private final String expression;
    private ArrayList<String> tokens;
    private ArrayList<String> reverse_polish;
    private Double result;

    private final Map<String, Integer> OPERATORS = new HashMap<>();
    {
        OPERATORS.put("^", 2);
        OPERATORS.put(",", 2);
        OPERATORS.put("*", 3);
        OPERATORS.put("/", 3);
        OPERATORS.put("%", 3);
        OPERATORS.put("+", 4);
        OPERATORS.put("-", 4);
    }

    private final Map<String, Integer> FUNCTIONS = new HashMap<>();
    {
        FUNCTIONS.put("SQRT", 1);
    }

    private final Map<String, Integer> SEPARATORS = new HashMap<>();
    {
        SEPARATORS.put(" ", 0);
        SEPARATORS.put("(", 0);
        SEPARATORS.put(")", 0);
    }

    public Calculator(String expression) {
        this.expression = expression;

        this.termTokenizer();

        this.tokensToReversePolishNotation();

        this.rpnToResult();
    }

    private boolean isOperator(String token) {
        return OPERATORS.containsKey(token);
    }

    private boolean isSeperator(String token) {
        return SEPARATORS.containsKey(token);
    }

    private boolean isFunction(String token) {
        return FUNCTIONS.containsKey(token);
    }

    private Boolean isPrecedent(String token1, String token2) {
        Boolean t1 = isOperator(token1);
        Boolean t2 = isOperator(token2);
    
        if (t1 && !t2) {
            return OPERATORS.get(token1) >= FUNCTIONS.get(token2);

        } else if (!t1 && t2) {
            return FUNCTIONS.get(token1) >= OPERATORS.get(token2);

        } else if (t1 && t2) {
            return OPERATORS.get(token1) >= OPERATORS.get(token2);

        }

        return FUNCTIONS.get(token1) >= FUNCTIONS.get(token2);
    }

    public String toString() {
        return ("Original expression: " + this.expression + "\n" +
                "Tokenized expression: " + this.tokens.toString() + "\n" +
                "Reverse Polish Notation: " + this.reverse_polish.toString() + "\n" +
                "Final result: " + String.format("%.2f", this.result));
    }

    private void rpnToResult() {
        Stack<Double> stack = new Stack<>();

        for (String token : reverse_polish) {
            if (isOperator(token)) {
                Double operand2 = stack.pop();
                Double operand1 = stack.pop();
                Double result = 0.0;

                switch (token) {
                    case "+":
                        result = operand1 + operand2;
                        break;
                    case "-":
                        result = operand1 - operand2;
                        break;
                    case "*":
                        result = operand1 * operand2;
                        break;
                    case "/":
                        result = operand1 / operand2;
                        break;
                    case "%":
                        result = operand1 % operand2;
                        break;
                    case "^":
                        result = Math.pow(operand1, operand2);
                        break;
                    case ",":
                        result = Math.sqrt((Math.pow(operand1, 2) + Math.pow(operand2, 2)));
                        break;
                }
                stack.push(result);

            } else if (isFunction(token)) {
                Double operand = stack.pop();
                Double result = 0.0;

                switch (token) {
                    case "SQRT":
                        result = Math.sqrt(operand);
                        break;
                }
                stack.push(result);

            } else {
                stack.push(Double.parseDouble(token));

            }
        }

        this.result = stack.pop();
    }

    private void tokensToReversePolishNotation() {
        this.reverse_polish = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        for (String token : this.tokens) {
            if (isOperator(token) || isFunction(token)) {
                while (!stack.empty() && (isOperator(stack.peek()) || isFunction(stack.peek()))) {
                    if (isPrecedent(token, stack.peek())) {
                        reverse_polish.add(stack.pop());
                    } else {
                        break;
                    }
                }
                stack.push(token);
            } else if (isSeperator(token)) {
                if (token.equals("(")) {
                    stack.push(token);
                } else if (token.equals(")")) {
                    while (!stack.empty() && !stack.peek().equals("(")) {
                        reverse_polish.add(stack.pop());
                    }
                    stack.pop();
                }
            } else {
                reverse_polish.add(token);
            }
        }
        while (!stack.empty()) {
            reverse_polish.add(stack.pop());
        }
    }

    private void termTokenizer() {

        this.tokens = new ArrayList<>();

        int start = 0;
        StringBuilder multiCharTerm = new StringBuilder();
        for (int i = 0; i < this.expression.length(); i++) {
            Character c = this.expression.charAt(i);
            if (isOperator(c.toString()) || isSeperator(c.toString())) {

                if (multiCharTerm.length() > 0) {
                    tokens.add(this.expression.substring(start, i));
                }

                if (c != ' ') {
                    tokens.add(c.toString());
                }

                start = i + 1;
                multiCharTerm = new StringBuilder();
            } else {

                multiCharTerm.append(c);
            }

        }

        if (multiCharTerm.length() > 0) {
            tokens.add(this.expression.substring(start));
        }
    }

}
