package spreadsheet;

public class Cell {
    private int row;
    private int col;
    private String formula;
    private Content content;
    public Cell(){

    }
    public Cell(int row, int col, Content content) {
        this.row = row;
        this.col = col;
        this.content = content;
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
        return content.getValue();
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
        if(content.getReference()!=null){
            return getCoordinates()+ " = " +getContent().getReference();
        }
        return  getCoordinates()+ " = " +getContentValue();
    }
}
