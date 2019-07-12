package spreadsheet.content;

public  class NumericContent extends Content {
    private double value;
    public NumericContent(double value){
        this.value = value;
    }

    @Override
    public  String  getContentValue(){
        return String.valueOf(value);
    }
}
