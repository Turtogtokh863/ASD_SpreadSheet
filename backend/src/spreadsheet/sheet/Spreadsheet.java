package spreadsheet.sheet;

import spreadsheet.content.ExperssionContent;
import spreadsheet.content.NumericContent;
import spreadsheet.content.Reference;
import spreadsheet.content.TextContent;

public class Spreadsheet {
    private int rowsize = 10;
    private int colsize = 5;
    Cell[][] cells;


    public Spreadsheet(int row, int col) {
        rowsize = row;
        colsize = col;
        cells = new Cell[rowsize][colsize];
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }
    public void addCell(Cell cll){
        cells[cll.getRow()][cll.getCol()] = cll;
    }

    public void addCell(int row, int col , String val){
        cells[row][col] = new Cell(this,row,col,new TextContent(val));
    }
    public void addCellReference(int row, int col, Cell val){
        cells[row][col] = new Cell(this,row,col,new Reference(val));
    }
    public void addCellExpression(int row, int col, String expression){
        cells[row][col] = new Cell(this,row,col,new ExperssionContent(expression));
        cells[row][col].setExpression(expression);
    }
    public void addCell(int row, int col , String val,String formula){
        cells[row][col] = new Cell(this,row,col,new TextContent(val),formula);
    }
    public void addCell(int row, int col , double val){
        cells[row][col] = new Cell(this, row,col, new NumericContent(val));
    }
    public String getCellValue(int row, int col){
        return cells[row][col].getContentValue();
    }
    public Cell getCell(int row, int col){
        return cells[row][col];
    }
    public Cell getCellFromString(String coordinats){
        String[] vals= coordinats.replaceAll("[\\[\\]]", "").split(",");
        int row = Integer.parseInt(vals[0]);
        int col = Integer.parseInt(vals[1]);
        return cells[row][col];
    }
    public String getCellValueFromString(String coordinats){
        return getCellFromString(coordinats).getContentValue();
    }
    public Double getCellValueFromDouble(String coordinats){
        return Double.valueOf(getCellFromString(coordinats).getContentValue());
    }
    public void describe() {
        for (int i = 0; i < rowsize; i++) {
            for (int j = 0; j < colsize; j++) {
                if (getCell(i, j) != null) {
                    if(getCell(i,j).getExpression()!=null){
//                        System.out.println("i = "+i +" j="+j);
//                        System.out.println(getCell(i,j).getExpression());
                        System.out.printf("%20s",getCell(i,j).calculateFormula());
                    }else {
                        System.out.printf("%20s", this.getCellValue(i, j));
                    }
                }
            }
            System.out.println();
        }
    }
    public void examine(){
        for (int i = 0; i <rowsize ; i++) {
            for (int j = 0; j <colsize ; j++) {
                if(getCell(i,j) !=null){
                    System.out.println(this.getCell(i,j));
                }
            }
        }
    }

}
