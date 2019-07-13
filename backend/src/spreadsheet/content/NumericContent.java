package spreadsheet.content;

public  class NumericContent extends Content {
    private double number;
    public NumericContent(double value){
        super(String.valueOf(value));
        this.number = value;
        this.calculation = value;

    }

    @Override
    public  String  getContentValue(){
        return String.valueOf(number);
    }

    public double getNumber() {
        return number;
    }
}
