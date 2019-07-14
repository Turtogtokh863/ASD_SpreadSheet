package spreadsheet.service;

import spreadsheet.operator.Addition;
import spreadsheet.operator.Division;
import spreadsheet.operator.Multiplication;
import spreadsheet.operator.Subtraction;
import spreadsheet.sheet.Spreadsheet;

import java.util.Stack;

public class NumericExpression {
    private Stack<Character> operators;
    private Stack<Double> values;
    public NumericExpression(){
        operators = new Stack<>();
        values = new Stack<>();
    }
    public void addValue(double val){
        values.push(val);
    }
    public void addOperator(char c){
        operators.push(c);
    }
    public double evaluate(String expression, Spreadsheet spreadsheet){

        char[] tokens = expression.toCharArray();
        for (int i = 0; i < tokens.length; i++){
            // get value from reference
            if(tokens[i]=='[') {
                StringBuilder ref = new StringBuilder();
                while (tokens[i] != ']' && i < tokens.length){
                    ref.append(tokens[i++]);
                }
                this.addValue(spreadsheet.getCellValueFromDouble(ref.toString()));
            }
            else if(tokens[i] >= '0' && tokens[i] <= '9'){
                StringBuilder sbuf = new StringBuilder();
                while (i < tokens.length && ((tokens[i] >= '0' && tokens[i] <= '9')|| tokens[i]=='.')) {
                    sbuf.append(tokens[i++]);
                }
                this.addValue(Double.valueOf(sbuf.toString()));
            }
           // Current token is an opening brace, push it to 'operators'
            else if (tokens[i] == '('){
                addOperator(tokens[i]);
                // Closing brace encountered, solve entire brace
            }else if (tokens[i] == ')') {
                while (operators.peek() != '(')
                    this.addValue(applyOperator(operators.pop(), values.pop(), values.pop()));
                operators.pop();
            }

            if( i < tokens.length && (tokens[i]=='+' || tokens[i]=='-' || tokens[i]=='*' ||tokens[i]=='/') ){
                // While top of 'operators' has same or greater precedence to current
                // token, which is an operator. Apply operator on top of 'operators'
                // to top two elements in values stack
                while (!operators.empty() && hasPrecedence(tokens[i],operators.peek())) {
                    double value1 = values.pop();
                    double value2 = values.pop();
                    this.addValue(applyOperator(operators.pop(), value2, value1));
                }
                // Push current token to 'operators'.
                addOperator(tokens[i]);
            }
        }
        while(!operators.empty()){
            double value1 = values.pop();
            double value2 = values.pop();
            double result = applyOperator(operators.pop(),value2,value1);
            values.push(result);
        }
        return values.pop();

    }
    // Returns true if 'operator2' has higher or same precedence as 'operator1',
    // otherwise returns false.
    public static boolean hasPrecedence(char operator1, char operator2)
    {
        if (operator2 == '(' || operator2 == ')')
            return false;
        if ((operator1 == '*' || operator1 == '/') && (operator2 == '+' || operator2 == '-'))
            return false;
        else
            return true;
    }
    public double applyOperator(char c, double right, double left){
        switch (c){
            case '+' : return (new Addition()).apply(right,left);
            case '-' : return (new Subtraction()).apply(right,left);
            case '*' : return (new Multiplication()).apply(right,left);
            case '/' : return (new Division()).apply(right,left);
        }
        return 0;
    }
}
