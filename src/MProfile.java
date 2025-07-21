import java.io.Serializable;
import javafx.beans.property.*;

public class MProfile implements Serializable {
    private static final long serialVersionUID = 1L;
    private StringProperty nama;
    private DoubleProperty tinggi;
    private DoubleProperty berat;
    private IntegerProperty umur;
    private StringProperty jenisKelamin;
    private StringProperty alergi;

    public MProfile(String nama, Double tinggi, Double berat, Integer umur, String jenisKelamin, String alergi) {
        this.nama = new SimpleStringProperty(nama);
        this.tinggi = new SimpleDoubleProperty(tinggi);
        this.berat = new SimpleDoubleProperty(berat);
        this.umur = new SimpleIntegerProperty(umur);
        this.jenisKelamin = new SimpleStringProperty(jenisKelamin);
        this.alergi = new SimpleStringProperty(alergi);
    }

    public MProfile() {
        this("", 0.0, 0.0, 0, "", "");
    }

    // Getters for properties
    public String getNama() { return nama.get(); }
    public double getTinggi() { return tinggi.get(); }
    public double getBerat() { return berat.get(); }
    public int getUmur() { return umur.get(); }
    public String getJenisKelamin() { return jenisKelamin.get(); }
    public String getAlergi() { return alergi.get(); }

    // Setters for properties
    public void setNama(String nama) { this.nama.set(nama); }
    public void setTinggi(double tinggi) { this.tinggi.set(tinggi); }
    public void setBerat(double berat) { this.berat.set(berat); }
    public void setUmur(int umur) { this.umur.set(umur); }
    public void setJenisKelamin(String jenisKelamin) { this.jenisKelamin.set(jenisKelamin); }
    public void setAlergi(String alergi) { this.alergi.set(alergi); }

    // Property methods for TableView (optional for profile, but good practice)
    public StringProperty namaProperty() { return nama; }
    public DoubleProperty tinggiProperty() { return tinggi; }
    public DoubleProperty beratProperty() { return berat; }
    public IntegerProperty umurProperty() { return umur; }
    public StringProperty jenisKelaminProperty() { return jenisKelamin; }
    public StringProperty alergiProperty() { return alergi; }
}