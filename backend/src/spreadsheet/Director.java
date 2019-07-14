package spreadsheet;

import spreadsheet.content.Content;
import spreadsheet.content.Reference;
import spreadsheet.operator.Addition;
import spreadsheet.operator.Division;
import spreadsheet.operator.Multiplication;
import spreadsheet.operator.Subtraction;
import spreadsheet.sheet.Cell;
import spreadsheet.sheet.CellBuilder;
import spreadsheet.sheet.Spreadsheet;

public class Director {
    private Spreadsheet spreadsheet;
    public Director(Spreadsheet spreadsheet){
        this.spreadsheet = spreadsheet;
    }

    public void buildTextCell(int row, int col, String val){
        spreadsheet.addCell(row,col,val);
    }
    public void buildReferenceCell(int row, int col, Cell val){
        spreadsheet.addCellReference(row,col,val);
    }
    public void buildNumericCell(int row, int col, double val){
        spreadsheet.addCell(row,col,val);
    }

    public void buildExperssionCell(int row, int col, String expression){
        spreadsheet.addCellExpression(row,col,expression);
    }

    public void setCell(int row, int col, String val) {
        CellBuilder.newInstance()
                .setCoordinate(row, col)
                .setSpreadsheet(this.spreadsheet)
                .setContent(val)
                .build();

    }
    public void setCell(int row, int col, Content val) {
        CellBuilder.newInstance()
                .setCoordinate(row, col)
                .setSpreadsheet(this.spreadsheet)
                .setContent(val)
                .build();

    }
    public void buildSample(){

        setCell(1,1,"\"Airfare :\"");
        setCell(1,2,"485.7");
        setCell(1,3,"");
        setCell(1,4,"\"What we pay to the airline\"");
        setCell(2,1,"\"Taxi :\"");
        setCell(2,2,"118");

        setCell(3,1,"\"Rental Car :\"");
        setCell(3,2,"295.85");

        setCell(4,1,"Hotel :");
        setCell(4,2,"432");

        setCell(5,1,"Meals :");
        setCell(5,2,"150");
        setCell(5,3,"");
        setCell(5,4,"All our meals");

        setCell(7,1,"\"Sub-total:\"");

        Addition addition = new Addition();
        for (int i = 1; i <=5 ; i++) {
            addition.append(new Reference(spreadsheet.getCell(i,2)));
        }
        setCell(7,2, addition);
        setCell(7,3,"");
        setCell(7,4,"\"This is just reference to [1,2]\"");

        setCell(8,1,"\"Tax :\"");
        setCell(8,2,"0.15");

        setCell(9,1,"\"Total :\"");
        Multiplication multiplication = new Multiplication();
        multiplication.append(new Reference(spreadsheet.getCell(7,2)));

        Subtraction onePlusTaxFactor = new Subtraction();
        onePlusTaxFactor.append(1);
        onePlusTaxFactor.append(new Reference(spreadsheet.getCell(8,2)));

        multiplication.append(onePlusTaxFactor);
        setCell(9,2,multiplication);

        setCell(10,1,"\"Partners :\"");
        setCell(10,2,"4");

        setCell(11,1,"\"Months :\"");
        setCell(11,2,"12");
        setCell(12,1,"\"Installments :\"");
        Division division = new Division();
        division.append(new Reference(spreadsheet.getCell(9,2)));
        division.append(new Reference(spreadsheet.getCell(10,2)));
        division.append(new Reference(spreadsheet.getCell(11,2)));
        setCell(12,2,division);
        setCell(13,1,"\"Expression :\"");
        setCell(13,2,"[1,2]+[2,2]+[3,2]+[4,2]+[5,2]+200");


    }
    public void describe(){
        spreadsheet.describe();
    }
    public void examine(){
        spreadsheet.examine();
    }
}
