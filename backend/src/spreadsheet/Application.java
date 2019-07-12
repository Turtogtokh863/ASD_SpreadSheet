package spreadsheet;

public class Application {

    public static void main(String[] args) {
        // write your code here
        Spreadsheet sp =new Spreadsheet(15,5);
        Director director = new Director(sp);
        director.buildSample();
        director.describe();
        director.examine();

        System.out.println(sp.getCellFromString("[1,2]").getContentValue());
    }
}
