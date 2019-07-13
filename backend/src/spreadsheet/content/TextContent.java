package spreadsheet.content;

public  class TextContent extends Content {
    private String value;
    public TextContent(String value){
        super(value);
        this.value = value;
    }

    @Override
    public  String  getContentValue(){
            return value;
    }
}
