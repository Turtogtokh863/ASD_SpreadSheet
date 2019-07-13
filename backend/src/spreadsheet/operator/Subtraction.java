package spreadsheet.operator;

public class Subtraction extends Operator {
    public Subtraction() {
        super("-");
    }
    public double apply(double right, double left){
        return right - left;
    }
}
