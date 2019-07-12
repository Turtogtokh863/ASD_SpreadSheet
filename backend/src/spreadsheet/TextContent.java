package spreadsheet;

public  class TextContent extends Content {
    private String value;
    public TextContent(String value){
        this.value = value;
    }

    @Override
    public  String  getValue(){
        if(getReference()!=null){
            return getReference().getCell().getContentValue();
        }else
            return value;
    }
}
