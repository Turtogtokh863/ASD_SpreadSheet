package spreadsheet.sheet;

import spreadsheet.content.Content;
import spreadsheet.service.NumericExpression;

public class Cell {
    private int row;
    private int col;
    private Spreadsheet spreadsheet;

    private String formula;
    private Content content;
    public Cell(){

    }
    public Cell(Spreadsheet spreadsheet,int row, int col, Content content) {
        this.row = row;
        this.col = col;
        this.content = content;
        this.spreadsheet = spreadsheet;
    }
    public Cell(Spreadsheet spreadsheet,int row, int col, Content content,String formula) {
        this.row = row;
        this.col = col;
        this.content = content;
        this.formula= formula;
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
        return getFormula().contains("[");
    }

    public double calculateFormula(){
        NumericExpression numericExpression = content.createExpression(this.formula);
        String[] values = formula.split("\\+"); // TODO extra operator
        for (int i = 0; i <values.length ; i++) {
            if(values[i].contains("[")){
                numericExpression.append(spreadsheet.getCellValueFromDouble(values[i]));
            }else{
                numericExpression.append(Double.valueOf(values[i]));
            }

        }
        return content.calculateFormula();
    }

    public void setContent(Content content) {
        this.content = content;
    }



    public Content getContent(){
        return content;
    }

    public String getCoordinates() {
        return "["+getRow()+","+getCol()+"]";
    }
    @Override
    public String toString() {
        if(getFormula()!=null){
            return getCoordinates()+ " = " +getFormula();
        }

        return  getCoordinates()+ " = " +getContentData();
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public Spreadsheet getSpreadsheet() {
        return spreadsheet;
    }

    public void setSpreadsheet(Spreadsheet spreadsheet) {
        this.spreadsheet = spreadsheet;
    }
}
