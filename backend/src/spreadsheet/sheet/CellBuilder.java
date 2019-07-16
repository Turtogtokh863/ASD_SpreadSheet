package spreadsheet.sheet;

import spreadsheet.content.Content;
import spreadsheet.content.ExperssionContent;
import spreadsheet.content.NumericContent;
import spreadsheet.content.TextContent;

public class CellBuilder {
    private int row;
    private int col;
    private Spreadsheet spreadsheet;
    private String expression;
    private Content content;
    private double calculation;

    private   CellBuilder(){
    }

    public static CellBuilder newInstance(){
        return new CellBuilder();
    }
    public CellBuilder setContent(Content value){
        this.content = value;
        return this;
    }
    public CellBuilder setContent(String value){
        if(value.matches("[0-9]+.[0-9]+") || value.matches("[0-9]+")){
            Content con = new NumericContent(Double.valueOf(value));
            this.content = con;
        }else if(value.matches("[a-zA-Z:\\\"\\s\\[\\],0-9]*")){
            Content con = new TextContent(value);
            this.content = con;
        }
        else if(value.matches("[0-9.\\s\\-\\+\\*\\/\\[\\](),]*")){
            Content con = new ExperssionContent(value);
            this.content = con;
            this.setExpression(value);

        }
//        System.out.println("val: " + value +"  asd "+value.matches("[0-9.\\s\\-\\+\\*\\/\\[\\](),]*"));
//        if(value.matches("[A-Za-z ]*")){
//            Content c = new TextContent(value);
//            this.content = c;
//        }

        return this;
    }

    public CellBuilder setCoordinate(int row, int col){
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
