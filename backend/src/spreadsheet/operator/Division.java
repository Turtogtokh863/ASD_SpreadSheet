package spreadsheet.operator;

public class Division extends Operator {
    public Division() {
        super("/");
    }
    public double apply(double right, double left){
        return right / left;
    }
}
