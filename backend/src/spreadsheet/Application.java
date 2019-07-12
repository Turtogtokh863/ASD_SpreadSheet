package spreadsheet;

public class Application {

    public static void main(String[] args) {
        // write your code here
        Director director = new Director(new Spreadsheet(15,5));
        director.displaySheet();
        director.examine();
    }
}
