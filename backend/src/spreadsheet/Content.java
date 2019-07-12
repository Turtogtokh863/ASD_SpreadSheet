package spreadsheet;


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

    public void   createExpression(String formula){

        expression = new Expression(new Addition());
        String[] values = formula.split("\\+"); // TODO extra operator
        for (int i = 0; i <values.length ; i++) {
            expression.append(Double.valueOf(values[i]));
        }
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
