package spreadsheet;

public  class Reference {
    private Cell cell;
    public Reference(Cell cell){
        this.cell = cell;
    }

    public Cell getCell(){
        return cell;
    }

    @Override
    public String toString() {
        return  getCell().getCoordinates();
    }
}
