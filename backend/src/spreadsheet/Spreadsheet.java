package spreadsheet;

public class Spreadsheet {
    private int rowsize = 10;
    private int colsize = 5;
    Cell[][] cells = new Cell[rowsize][colsize];


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

    public void addCell(int row, int col , String val){

        cells[row][col] = new Cell(row,col,new TextContent(val));
    }
    public void addCell(int row, int col , double val){
        cells[row][col] = new Cell(row,col, new NumbericContent(val));
    }
    public String getCellValue(int row, int col){
        return cells[row][col].getContentValue();
    }
    public Cell getCell(int row, int col){
        return cells[row][col];
    }
    public void displaySheet() {
        for (int i = 0; i < rowsize; i++) {
            for (int j = 0; j < colsize; j++) {
                if (getCell(i, j) != null) {
                    System.out.printf("%20s", this.getCellValue(i, j));
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
