package spreadsheet;

import spreadsheet.content.NumericContent;
import spreadsheet.service.NumericExpression;
import spreadsheet.sheet.Spreadsheet;

public class Application {

    public static void main(String[] args) {
        // write your code here
        Spreadsheet sp =new Spreadsheet(15,5);
        Director director = new Director(sp);
        director.buildSample();
        director.describe();
        director.examine();
        NumericExpression numericExpression = new NumericExpression();

        System.out.println(numericExpression.evaluate("[1,2] + ( 21 + 21 * ( 2+1 )) / 7 /3",sp));
    }
}
