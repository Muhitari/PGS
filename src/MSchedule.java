import java.io.Serializable;
import javafx.beans.property.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class MSchedule implements Serializable {
    private static final long serialVersionUID = 1L;
    private StringProperty aktivitas;
    private ObjectProperty<LocalDate> tanggal;
    private ObjectProperty<LocalTime> waktu;
    private StringProperty catatan;

    public MSchedule(String aktivitas, LocalDate tanggal, LocalTime waktu, String catatan) {
        this.aktivitas = new SimpleStringProperty(aktivitas);
        this.tanggal = new SimpleObjectProperty<>(tanggal);
        this.waktu = new SimpleObjectProperty<>(waktu);
        this.catatan = new SimpleStringProperty(catatan);
    }

    // Getters
    public String getAktivitas() { return aktivitas.get(); }
    public LocalDate getTanggal() { return tanggal.get(); }
    public LocalTime getWaktu() { return waktu.get(); }
    public String getCatatan() { return catatan.get(); }

    // Setters
    public void setAktivitas(String aktivitas) { this.aktivitas.set(aktivitas); }
    public void setTanggal(LocalDate tanggal) { this.tanggal.set(tanggal); }
    public void setWaktu(LocalTime waktu) { this.waktu.set(waktu); }
    public void setCatatan(String catatan) { this.catatan.set(catatan); }

    // Property methods for TableView
    public StringProperty aktivitasProperty() { return aktivitas; }
    public ObjectProperty<LocalDate> tanggalProperty() { return tanggal; }
    public ObjectProperty<LocalTime> waktuProperty() { return waktu; }
    public StringProperty catatanProperty() { return catatan; }
}