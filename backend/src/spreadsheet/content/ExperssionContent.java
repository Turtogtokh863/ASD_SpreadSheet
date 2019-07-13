package spreadsheet.content;

public class ExperssionContent extends Content{
    private String expression;

    public ExperssionContent(String expression) {
        super(expression);
        this.expression = expression;
    }

    @Override
    public String getContentValue() {
        return null;
    }
}
