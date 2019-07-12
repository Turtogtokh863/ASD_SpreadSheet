package spreadsheet;


public abstract class Content {
    private String content;
    private String formulaString;
    private double calculation;
    private Reference reference;
    public Content(){

    }

    public Content(String content, String formulaString) {
        this.content = content;
        this.formulaString = formulaString;
    }

    public abstract String  getValue();

    public void   createExpression(){

    }
    public void   calculateFormula(){

    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Reference getReference() {
        return reference;
    }

    public void setReference(Reference reference) {
        this.reference = reference;
    }
}
