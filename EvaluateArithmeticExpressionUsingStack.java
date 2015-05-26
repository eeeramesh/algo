/*
Two-stack algorithm - Evaluate infix expression
( 1 + ( ( 2 + 3 ) * ( 4 * 5) ) )
Value: push onto the value stack 
Operator: push onto the operator stack
Left parenthesis: ignore
Right parenthesis: pop operator and two values
push the result of applying that operator to those values onto the oprator stack
*/￼


public class EvaluateArithmeticExpressionUsingStack {
	public static void main(String[] args) {
		Stack < String > ops = new Stack < String > ();
		Stack < Double > vals = new Stack < Double > ();
		while (!StdIn.isEmpty()) {
			String s = StdIn.readString();
			if (s.equals("("));
			else if (s.equals("+")) ops.push(s);
			else if (s.equals("*")) ops.push(s);
			else if (s.equals(")")) {
				String op = ops.pop();
				if (op.equals("+")) vals.push(vals.pop() + vals.pop());
				else if (op.equals("*")) vals.push(vals.pop() * vals.pop());
			} else vals.push(Double.parseDouble(s));
		}
		StdOut.println(vals.pop());
	}
}