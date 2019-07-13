package spreadsheet.service;

import spreadsheet.operator.Operator;

import java.util.ArrayList;
import java.util.List;

public class NumericExpression {
    private double leftValue;
    private double rightValue;
    private NumericExpression rightOperand;
    private NumericExpression leftOperand;
    private List<Double> groups;
    private Operator operator;

    public NumericExpression(Operator operator){
        groups = new ArrayList<>();
        this.operator =operator;
    }
    public void append(double val){
        groups.add(val);
    }
    public double evaluate(){
        double result = groups.get(0);
        for (int i = 1; i < groups.size(); i++) {

            result = operator.apply(result,groups.get(i));
        }
        return result;
    }

}
