import java.util.List;

public class MNutritionPlan {
    public enum Tujuan { DIET, BULKING, HEMAT_BIAYA }
    public enum Periode { HARI, PEKAN, BULAN }

    private Tujuan tujuan;
    private Periode periode;
    private List<MMenuItem> daftarMenu;

    public MNutritionPlan(Tujuan tujuan, Periode periode, List<MMenuItem> daftarMenu) {
        this.tujuan = tujuan;
        this.periode = periode;
        this.daftarMenu = daftarMenu;
    }

    public Tujuan getTujuan() { return tujuan; }
    public void setTujuan(Tujuan tujuan) { this.tujuan = tujuan; }
    public Periode getPeriode() { return periode; }
    public void setPeriode(Periode periode) { this.periode = periode; }
    public List<MMenuItem> getDaftarMenu() { return daftarMenu; }
    public void setDaftarMenu(List<MMenuItem> daftarMenu) { this.daftarMenu = daftarMenu; }
}