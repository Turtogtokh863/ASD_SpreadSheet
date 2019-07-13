package spreadsheet.operator;

public class Multiplication extends Operator {
    public Multiplication() {
        super("*");
    }
    public double apply(double right, double left){
        return right * left;
    }
}
