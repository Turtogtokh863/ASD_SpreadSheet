package spreadsheet;

import java.util.ArrayList;
import java.util.List;

public class Expression {
    private double leftValue;
    private double rightValue;
    private Expression rightOperand;
    private Expression leftOperand;
    private List<Double> groups;
    private Operator operator;

    public Expression(Operator operator){
        groups = new ArrayList<>();
        this.operator =operator;
    }
    public void append(double val){
        groups.add(val);
    }
    public double evaluate(){
        double result = groups.get(0);
        for (int i = 0; i < groups.size(); i++) {
            result = operator.apply(result,groups.get(i));
        }
        return result;
    }

}
