package spreadsheet;

public class Application {

    public static void main(String[] args) {
        // write your code here

        Spreadsheet sp = new Spreadsheet(15,5);

        sp.addCell(1,1,"Airfare :");
        sp.addCell(1,2,485.7);
        sp.addCell(1,3,"");
        sp.addCell(1,4,"What we pay to the airline");

        sp.addCell(2,1,"Taxi :");
        sp.addCell(2,2,118);

        sp.addCell(3,1,"Rental Car :");
        sp.addCell(3,2,295.85);

        sp.addCell(4,1,"Hotel :");
        sp.addCell(4,2,432);

        sp.addCell(5,1,"Meals :");
        sp.addCell(5,2,150);
        sp.addCell(5,3,"");
        sp.addCell(5,4,"All our meals");

        sp.addCell(7,1,"Sub-total :");
        Reference ref = new Reference(sp.getCell(1,2));
        sp.addCell(7,2,"");
        sp.getCell(7,2).getContent().setReference(ref);
        sp.addCell(7,3,"");
        sp.addCell(7,4,"This is just reference to [1,2]");

        sp.addCell(8,1,"Tax :");
        sp.addCell(8,2,0.15);

        sp.addCell(9,1,"Total :");


        sp.addCell(10,1,"Partners :");
        sp.addCell(10,2,4);

        sp.addCell(11,1,"Months :");
        sp.addCell(11,2,12);

        sp.displaySheet();
        sp.examine();
    }
}
