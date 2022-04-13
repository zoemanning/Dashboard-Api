package manning.irlanda.domain.inspirationalquotes.models;

public class InspirationalQuote {

    private String author;
    private String text;

    public InspirationalQuote() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "InspirationalQuote{" +
                " author='" + author + '\'' +
                " text='" + text + '\'' +
                '}';
    }
}
