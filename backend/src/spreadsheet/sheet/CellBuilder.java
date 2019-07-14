package spreadsheet.sheet;

import spreadsheet.content.Content;
import spreadsheet.content.ExperssionContent;
import spreadsheet.content.NumericContent;
import spreadsheet.content.TextContent;

import java.security.SecurityPermission;

public class CellBuilder {
    private int row;
    private int col;
    private Spreadsheet spreadsheet;

    private String expression;
    private Content content;
    private double calculation;

    public  CellBuilder(){
    }

    public CellBuilder setContent(String value){
        if(value.matches("\\d+")){
            content = new NumericContent(Double.valueOf(value));

        }else if(value.matches("^[a-zA-Z]*$")){
            content = new TextContent(value);
        } else if(value.matches("\\d+[\\-\\+\\*\\/]+\\d")){
            content = new ExperssionContent(value);
        }
        return this;
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
        Cell buildCell = new Cell(spreadsheet,row,col,content,expression);
        spreadsheet.addCell(buildCell);
        return buildCell;

    }


}
