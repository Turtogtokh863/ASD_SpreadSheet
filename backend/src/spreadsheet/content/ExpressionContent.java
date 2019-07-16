package spreadsheet.content;

public class ExpressionContent extends Content{
    private String expression;

    public ExpressionContent(String expression) {
        super(expression);
        this.expression = expression;
    }

    @Override
    public String getContentValue() {
        return null;
    }
}
