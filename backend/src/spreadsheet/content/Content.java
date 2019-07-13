package spreadsheet.content;


import spreadsheet.service.NumericExpression;
import spreadsheet.operator.Addition;

public abstract class Content {
    private String data;
    private String value;
    private String formulaString;
    private double calculation;
    private NumericExpression numericExpression;
    public Content(){

    }

    public Content(String data) {
        this.data = data;
    }

    public NumericExpression createExpression(String formula){
        numericExpression = new NumericExpression(new Addition());
        return numericExpression;
    }

    public abstract String  getContentValue();

    public double   calculateFormula(){
        calculation = numericExpression.evaluate();
        return this.calculation;
    }

    public String getData() {
        return data;
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

    public void setNumericExpression(NumericExpression numericExpression){
        this.numericExpression = numericExpression;
    }

    public NumericExpression getNumericExpression() {
        return numericExpression;
    }
}
