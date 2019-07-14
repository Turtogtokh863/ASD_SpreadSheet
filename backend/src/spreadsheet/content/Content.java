package spreadsheet.content;


public abstract class Content {
    private String data;
    private String value;
    private String formulaString;
    protected double calculation;
    public Content(){

    }

    public Content(String data) {
        this.data = data;
    }
    public abstract String  getContentValue();
    public String getData() {
        return data;
    }
    public void appendToData(String append) {
         this.data+=append;
    }
    public void setData(String data) {
        this.data = data;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getFormulaString() {
        return formulaString;
    }

    public void setFormulaString(String formulaString) {
        this.formulaString = formulaString;
    }

    public double getCalculation() {
        return calculation;
    }

    public void setCalculation(double calculation) {
        this.calculation = calculation;
    }

}
