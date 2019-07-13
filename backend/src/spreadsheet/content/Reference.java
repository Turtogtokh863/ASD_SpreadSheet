package spreadsheet.content;

import spreadsheet.sheet.Cell;

public  class Reference extends Content {
    private Cell cell;
    public Reference(Cell cell){

        super(cell.getCoordinates());
        this.cell = cell;
    }

    public Cell getCell(){
        return cell;
    }

   @Override
    public String toString() {
        return  getCell().getCoordinates();
    }

    @Override
    public String getContentValue() {
        return getCell().getContentValue();
    }

    @Override
    public double getCalculation(){
        return getCell().getCalculation();
    }

}
