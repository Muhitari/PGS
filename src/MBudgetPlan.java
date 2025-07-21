import java.util.Map;

public class MBudgetPlan {
    private double anggaranPerBulan;
    private Map<String, Double> pembagianAnggaran;

    public MBudgetPlan(double anggaranPerBulan, Map<String, Double> pembagianAnggaran) {
        this.anggaranPerBulan = anggaranPerBulan;
        this.pembagianAnggaran = pembagianAnggaran;
    }
    
    public MBudgetPlan() {
    }

    public double getAnggaranPerBulan() { return anggaranPerBulan; }
    public void setAnggaranPerBulan(double anggaranPerBulan) { this.anggaranPerBulan = anggaranPerBulan; }
    public Map<String, Double> getPembagianAnggaran() { return pembagianAnggaran; }
    public void setPembagianAnggaran(Map<String, Double> pembagianAnggaran) { this.pembagianAnggaran = pembagianAnggaran; }
}