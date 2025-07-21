import java.io.Serializable;
import javafx.beans.property.*;

public class MRecipe implements Serializable {
    private static final long serialVersionUID = 1L;
    private StringProperty name;
    private StringProperty ingredients;
    private StringProperty instructions;

    public MRecipe(String name, String ingredients, String instructions) {
        this.name = new SimpleStringProperty(name);
        this.ingredients = new SimpleStringProperty(ingredients);
        this.instructions = new SimpleStringProperty(instructions);
    }

    // Getters
    public String getName() { return name.get(); }
    public String getIngredients() { return ingredients.get(); }
    public String getInstructions() { return instructions.get(); }

    // Setters
    public void setName(String name) { this.name.set(name); }
    public void setIngredients(String ingredients) { this.ingredients.set(ingredients); }
    public void setInstructions(String instructions) { this.instructions.set(instructions); }

    // Property methods for TableView
    public StringProperty nameProperty() { return name; }
    public StringProperty ingredientsProperty() { return ingredients; }
    public StringProperty instructionsProperty() { return instructions; }
}