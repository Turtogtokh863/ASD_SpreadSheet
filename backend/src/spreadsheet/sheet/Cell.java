package spreadsheet.sheet;

import spreadsheet.content.Content;
import spreadsheet.operator.Operator;
import spreadsheet.service.ExpressionParser;

public class Cell {
    private int row;
    private int col;
    private Spreadsheet spreadsheet;

    private String expression;
    private Content content;
    private double calculation;

    public Cell(){

    }
    public Cell(Spreadsheet spreadsheet, int row, int col){
        this.spreadsheet = spreadsheet;
        this.row = row;
        this.col = col;
    }
    public Cell(Spreadsheet spreadsheet,int row, int col, Content content) {
        this.row = row;
        this.col = col;
        this.content = content;
        this.spreadsheet = spreadsheet;
    }
    public Cell(Spreadsheet spreadsheet,int row, int col, Content content,String expression) {
        this.row = row;
        this.col = col;
        this.content = content;
        this.expression = expression;
        this.spreadsheet = spreadsheet;
    }
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public String getContentValue() {
        return content.getContentValue();
    }
    public String getContentData(){
        return content.getData();
    }


    public boolean isFormulaContainsRef(){
        return getExpression().contains("[");
    }

    public double calculateFormula(){
        ExpressionParser expressionParser = new ExpressionParser();
        double result = expressionParser.evaluate(expression,spreadsheet);
        content.setCalculation(result);
        return content.getCalculation();
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public double getCalculation() {
        return content.getCalculation();
    }

    public void setCalculation(double calculation) {
        this.calculation = calculation;
    }

    public Content getContent(){
        return content;
    }

    public String getCoordinates() {
        return "["+getRow()+","+getCol()+"]";
    }
    @Override
    public String toString() {
//        if(getContent()==null){
//
//        }
        if(getExpression()!=null ){
            return getCoordinates()+ " = []--> " + getExpression();
        }
        // TODO fix instanceOF
        if(content instanceof Operator){
            return getCoordinates()+ " = []--> " + getContentData();
        }

        return  getCoordinates()+ " = [" +getContentData() + "]" + "-->" + getContentValue();
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public Spreadsheet getSpreadsheet() {
        return spreadsheet;
    }

    public void setSpreadsheet(Spreadsheet spreadsheet) {
        this.spreadsheet = spreadsheet;
    }
}
