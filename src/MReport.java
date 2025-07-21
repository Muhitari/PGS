import java.io.Serializable;
import javafx.beans.property.*;

public class MReport implements Serializable {
    private static final long serialVersionUID = 1L;
    private StringProperty periode;
    private DoubleProperty totalAnggaranBiaya;
    private DoubleProperty totalKalori;

    public MReport(String periode, Double totalAnggaranBiaya, Double totalKalori) {
        this.periode = new SimpleStringProperty(periode);
        this.totalAnggaranBiaya = new SimpleDoubleProperty(totalAnggaranBiaya);
        this.totalKalori = new SimpleDoubleProperty(totalKalori);
    }

    // Getters
    public String getPeriode() { return periode.get(); }
    public Double getTotalAnggaranBiaya() { return totalAnggaranBiaya.get(); }
    public Double getTotalKalori() { return totalKalori.get(); }

    // Setters
    public void setPeriode(String periode) { this.periode.set(periode); }
    public void setTotalAnggaranBiaya(Double totalAnggaranBiaya) { this.totalAnggaranBiaya.set(totalAnggaranBiaya); }
    public void setTotalKalori(Double totalKalori) { this.totalKalori.set(totalKalori); }

    // Property methods for TableView
    public StringProperty periodeProperty() { return periode; }
    public DoubleProperty totalAnggaranBiayaProperty() { return totalAnggaranBiaya; }
    public DoubleProperty totalKaloriProperty() { return totalKalori; }
}