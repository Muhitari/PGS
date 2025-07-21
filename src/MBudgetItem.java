import java.io.Serializable;
import javafx.beans.property.*;

public class MBudgetItem implements Serializable {
    private static final long serialVersionUID = 1L;
    private StringProperty item;
    private DoubleProperty amount;
    private StringProperty category;
    private StringProperty notes;

    public MBudgetItem(String item, Double amount, String category, String notes) {
        this.item = new SimpleStringProperty(item);
        this.amount = new SimpleDoubleProperty(amount);
        this.category = new SimpleStringProperty(category);
        this.notes = new SimpleStringProperty(notes);
    }

    // Getters
    public String getItem() { return item.get(); }
    public Double getAmount() { return amount.get(); }
    public String getCategory() { return category.get(); }
    public String getNotes() { return notes.get(); }

    // Setters
    public void setItem(String item) { this.item.set(item); }
    public void setAmount(Double amount) { this.amount.set(amount); }
    public void setCategory(String category) { this.category.set(category); }
    public void setNotes(String notes) { this.notes.set(notes); }

    // Property methods for TableView
    public StringProperty itemProperty() { return item; }
    public DoubleProperty amountProperty() { return amount; }
    public StringProperty categoryProperty() { return category; }
    public StringProperty notesProperty() { return notes; }
}