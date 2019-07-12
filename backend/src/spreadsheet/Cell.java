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
    public Cell(int row, int col, Content content,String formula) {
        this.row = row;
        this.col = col;
        this.content = content;
        this.formula= formula;
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

    public boolean isFormulaContainsRef(){
        return getFormula().contains("[");
    }

    public double calculateFormula(){
        content.createExpression(this.formula);
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
        if(content.getReference()!=null){
            return getCoordinates()+ " = " +getContent().getReference();
        }
        if(getFormula()!=null){
            return getCoordinates()+ " = " +getFormula();
        }
        return  getCoordinates()+ " = " +getContentValue();
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }
}
