package spreadsheet;

public  class NumbericContent extends Content {
    private double value;
    public NumbericContent(double value){
        this.value = value;
    }

    @Override
    public  String  getValue(){
        return String.valueOf(value);
    }
}
