import java.io.Serializable;
import javafx.beans.property.*;

public class MMenuItem implements Serializable {
    private static final long serialVersionUID = 1L;
    private StringProperty name;
    private DoubleProperty calories;
    private DoubleProperty protein;
    private DoubleProperty fat;
    private DoubleProperty carbs;
    private IntegerProperty quantity;
    private StringProperty notes;

    public MMenuItem(String name, Double calories, Double protein, Double fat, Double carbs, Integer quantity, String notes) {
        this.name = new SimpleStringProperty(name);
        this.calories = new SimpleDoubleProperty(calories);
        this.protein = new SimpleDoubleProperty(protein);
        this.fat = new SimpleDoubleProperty(fat);
        this.carbs = new SimpleDoubleProperty(carbs);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.notes = new SimpleStringProperty(notes);
    }

    // Getters
    public String getName() { return name.get(); }
    public Double getCalories() { return calories.get(); }
    public Double getProtein() { return protein.get(); }
    public Double getFat() { return fat.get(); }
    public Double getCarbs() { return carbs.get(); }
    public Integer getQuantity() { return quantity.get(); }
    public String getNotes() { return notes.get(); }

    // Setters
    public void setName(String name) { this.name.set(name); }
    public void setCalories(Double calories) { this.calories.set(calories); }
    public void setProtein(Double protein) { this.protein.set(protein); }
    public void setFat(Double fat) { this.fat.set(fat); }
    public void setCarbs(Double carbs) { this.carbs.set(carbs); }
    public void setQuantity(Integer quantity) { this.quantity.set(quantity); }
    public void setNotes(String notes) { this.notes.set(notes); }

    // Property methods for TableView
    public StringProperty nameProperty() { return name; }
    public DoubleProperty caloriesProperty() { return calories; }
    public DoubleProperty proteinProperty() { return protein; }
    public DoubleProperty fatProperty() { return fat; }
    public DoubleProperty carbsProperty() { return carbs; }
    public IntegerProperty quantityProperty() { return quantity; }
    public StringProperty notesProperty() { return notes; }
}