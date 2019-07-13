package spreadsheet;

import spreadsheet.content.Reference;
import spreadsheet.operator.Addition;
import spreadsheet.operator.Division;
import spreadsheet.operator.Multiplication;
import spreadsheet.operator.Subtraction;
import spreadsheet.sheet.Cell;
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
    public void buildSample(){
        buildTextCell(1,1,"Airfare :");
        buildNumericCell(1,2,485.7);
        buildTextCell(1,3,"");
        buildTextCell(1,4,"What we pay to the airline");

        buildTextCell(2,1,"Taxi :");
        buildNumericCell(2,2,118);

        buildTextCell(3,1,"Rental Car :");
        buildNumericCell(3,2,295.85);

        buildTextCell(4,1,"Hotel :");
        buildNumericCell(4,2,432);

        buildTextCell(5,1,"Meals :");
        buildNumericCell(5,2,150);
        buildTextCell(5,3,"");
        buildTextCell(5,4,"All our meals");

        buildTextCell(7,1,"Sub-total :");
//        buildReferenceCell(7,2,spreadsheet.getCell(1,2));
        buildNumericCell(7,2,0);
        Addition addition = new Addition();
        for (int i = 1; i <6 ; i++) {
            addition.append(new Reference(spreadsheet.getCell(i,2)));
        }
        spreadsheet.getCell(7,2).setContent(addition);
        buildTextCell(7,3,"");
        buildTextCell(7,4,"This is just reference to [1,2]");

        buildTextCell(8,1,"Tax :");
        buildNumericCell(8,2,0.15);

        buildTextCell(9,1,"Total :");
        // add formula

//        buildExperssionCell(9,2,"[1,2]+[2,2]+[3,2]+[4,2]+[5,2]+200");
        buildNumericCell(9,2,0);
        Multiplication multiplication = new Multiplication();
        multiplication.append(new Reference(spreadsheet.getCell(7,2)));

        Subtraction onePlusTaxFactor = new Subtraction();
        onePlusTaxFactor.append(1);
        onePlusTaxFactor.append(new Reference(spreadsheet.getCell(8,2)));

        multiplication.append(onePlusTaxFactor);

        spreadsheet.getCell(9,2).setContent(multiplication);

        buildTextCell(10,1,"Partners :");
        buildNumericCell(10,2,4);

        buildTextCell(11,1,"Months :");
        buildNumericCell(11,2,12);
        buildTextCell(12,1,"Installments :");
        buildNumericCell(12,2,0);
        Division division = new Division();
        division.append(new Reference(spreadsheet.getCell(9,2)));
        division.append(new Reference(spreadsheet.getCell(10,2)));
        division.append(new Reference(spreadsheet.getCell(11,2)));
        spreadsheet.getCell(12,2).setContent(division);
    }
    public void describe(){
        spreadsheet.describe();
    }
    public void examine(){
        spreadsheet.examine();
    }
}
