package manning.irlanda.domain.randomjokes.models;

import javax.persistence.*;

//specifies the object that is mapped to the database
@Entity
public class RandomJoke {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
//  stores long-form text strings
    @Column(columnDefinition = "TEXT")
    private String content;
    private String category;

//   manages Object creation & wiring dependencies
    public RandomJoke() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "RandomJoke{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
