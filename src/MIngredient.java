public class MIngredient {
    private String namaBahan;
    private double jumlah;
    private String unit;

    public MIngredient(String namaBahan, double jumlah, String unit) {
        this.namaBahan = namaBahan;
        this.jumlah = jumlah;
        this.unit = unit;
    }

    public String getNamaBahan() {return namaBahan;}
    public void setNamaBahan(String namaBahan) {this.namaBahan = namaBahan;}
    public double getJumlah() {return jumlah;}
    public void setJumlah(double jumlah) {this.jumlah = jumlah;}
    public String getUnit() {return unit;}
    public void setUnit(String unit) {this.unit = unit;}
}