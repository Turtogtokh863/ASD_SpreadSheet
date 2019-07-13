package spreadsheet.content;


import spreadsheet.service.Expression;
import spreadsheet.sheet.Reference;
import spreadsheet.operator.Addition;

public abstract class Content {
    private String content;
    private String formulaString;
    private double calculation;
    private Reference reference;
    private Expression expression;
    public Content(){

    }

    public Content(String content) {
        this.content = content;
    }

    public Expression   createExpression(String formula){
        expression = new Expression(new Addition());
        return expression;
    }

    public abstract String  getContentValue();

    public double   calculateFormula(){
        calculation = expression.evaluate();
        return this.calculation;
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

    public void setExpression(Expression expression){
        this.expression = expression;
    }
}
