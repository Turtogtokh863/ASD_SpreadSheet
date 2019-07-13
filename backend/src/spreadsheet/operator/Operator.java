package spreadsheet.operator;

import spreadsheet.content.Content;
import spreadsheet.content.NumericContent;
import spreadsheet.content.Reference;

public abstract class Operator extends Content {

    private String operator;

    public Operator(){

    }

    public Operator(String operator) {
        super("");
        this.operator = operator;
    }

    public abstract double apply(double right, double left);

    public void append(double value){
        if(calculation==0){
            calculation = value;
            this.appendToData(String.valueOf(value));
        }else{
            calculation = apply(calculation,value);
            this.appendToData(getOperator()+value);
        }
    }
    public void append(Content content){
        if(calculation==0){
            calculation = content.getCalculation();
            this.appendToData(content.getData());
        }else{
            calculation = apply(calculation,content.getCalculation());
            this.appendToData(getOperator()+content.getData());
        }
    }
    public  String  getContentValue(){
        return String.valueOf(getCalculation());
    }
    public String getOperator(){
        return operator;
    }
    @Override
    public String getData(){
        return "("+super.getData()+")";
    }
}
