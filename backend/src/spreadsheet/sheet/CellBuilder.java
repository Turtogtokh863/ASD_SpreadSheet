package spreadsheet.sheet;

import spreadsheet.content.Content;

import java.security.SecurityPermission;

public class CellBuilder {
    private int row;
    private int col;
    private Spreadsheet spreadsheet;

    private String expression;
    private Content content;
    private double calculation;

    public  CellBuilder(Content content){
        this.content = content;
    }

    public CellBuilder setCell(int row, int col){
        this.row = row;
        this.col = col;
        return this;
    }
    public CellBuilder setSpreadsheet(Spreadsheet spreadsheet){
        this.spreadsheet = spreadsheet;
        return this;
    }

    public CellBuilder setExpression(String expression){
        this.expression = expression;
        return this;
    }

    public CellBuilder setCalculation(double calculation){
        this.calculation = calculation;
        return this;
    }

    public Cell build(){
        return new Cell(spreadsheet,row,col,content,expression);
    }


}
