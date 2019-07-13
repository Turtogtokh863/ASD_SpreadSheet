package spreadsheet.operator;

public class Addition extends Operator {

    public Addition() {
        super("+");
    }

    public double apply(double right, double left){
        return right + left;
    }
}
