package manning.irlanda.domain.cocktails.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;


@JsonIgnoreProperties
public class Cocktail {

    private String name;
    private List<String> ingredients;

    public Cocktail() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Cocktail{" +
                "name='" + name + '\'' +
                ", ingredients='" + ingredients + '\'' +
                '}';
    }
}
