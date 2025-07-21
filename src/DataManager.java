import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DataManager {

    private static MProfile profile;
    private static ObservableList<MSchedule> scheduleData = FXCollections.observableArrayList();
    private static ObservableList<MReport> reportData = FXCollections.observableArrayList();
    private static ObservableList<MMenuItem> nutritionPlanItems = FXCollections.observableArrayList();
    private static ObservableList<MBudgetItem> budgetPlanItems = FXCollections.observableArrayList(); // Perubahan nama
    private static ObservableList<MRecipe> recommendedRecipes = FXCollections.observableArrayList();
    private static ObservableList<MMenuItem> nutritionReportData = FXCollections.observableArrayList(); // Baru
    private static ObservableList<MBudgetItem> budgetReportData = FXCollections.observableArrayList(); // Baru

    private static final String PROFILE_FILE = "profile.dat";
    private static final String SCHEDULE_FILE = "schedule.dat";
    private static final String REPORT_FILE = "report.dat";
    private static final String NUTRITION_PLAN_FILE = "nutritionPlan.dat";
    private static final String BUDGET_PLAN_FILE = "budgetPlan.dat";
    private static final String RECIPE_FILE = "recipes.dat";
    private static final String NUTRITION_REPORT_FILE = "nutritionReport.dat";
    private static final String BUDGET_REPORT_FILE = "budgetReport.dat";

    public static void loadData() {
        profile = loadObject(PROFILE_FILE);
        if (profile == null) {
            profile = new MProfile("Nama Pengguna", 170.0, 60.0, 25, "Pria", "Tidak ada");
        }

        List<MSchedule> loadedSchedule = loadObject(SCHEDULE_FILE);
        if (loadedSchedule != null) {
            scheduleData = FXCollections.observableArrayList(loadedSchedule);
        } else {
            scheduleData = FXCollections.observableArrayList(
                new MSchedule("Olahraga Pagi", LocalDate.now(), LocalTime.of(6, 0), "Lari 30 menit"),
                new MSchedule("Sarapan Sehat", LocalDate.now(), LocalTime.of(7, 30), "Smoothie buah dan oat"),
                new MSchedule("Meeting Kerja", LocalDate.now().plusDays(1), LocalTime.of(9, 0), "Persiapan presentasi")
            );
        }

        List<MReport> loadedReport = loadObject(REPORT_FILE);
        if (loadedReport != null) {
            reportData = FXCollections.observableArrayList(loadedReport);
        } else {
            reportData = FXCollections.observableArrayList(
                new MReport("Januari", 5000000.0, 25000.0),
                new MReport("Februari", 4800000.0, 26000.0),
                new MReport("Maret", 5200000.0, 27000.0)
            );
        }

        List<MMenuItem> loadedNutrition = loadObject(NUTRITION_PLAN_FILE);
        if (loadedNutrition != null) {
            nutritionPlanItems = FXCollections.observableArrayList(loadedNutrition);
        } else {
            nutritionPlanItems = FXCollections.observableArrayList();
        }

        List<MBudgetItem> loadedBudget = loadObject(BUDGET_PLAN_FILE);
        if (loadedBudget != null) {
            budgetPlanItems = FXCollections.observableArrayList(loadedBudget);
        } else {
            budgetPlanItems = FXCollections.observableArrayList();
        }

        List<MRecipe> loadedRecipes = loadObject(RECIPE_FILE);
        if (loadedRecipes != null) {
            recommendedRecipes = FXCollections.observableArrayList(loadedRecipes);
        } else {
            recommendedRecipes = FXCollections.observableArrayList(
                new MRecipe( "Salad Buah",  "Apel, Pisang, Anggur, Saus Yoghurt",  "Campur semua buah dan tuangkan saus."),
                new MRecipe( "Smoothie Hijau",  "Bayam, Pisang, Air Kelapa",  "Blender semua bahan hingga halus."),
                new MRecipe( "Nasi Putih",  "Nasi",  "Masak nasi dengan rice cooker atau kukus."),    
                new MRecipe( "Oatmeal Pisang",  "Oat, Pisang, Madu, Susu",  "Masak oat dengan susu, tambahkan pisang dan madu."),
                new MRecipe( "Tumis Brokoli",  "Brokoli, Bawang Putih, Minyak Zaitun",  "Tumis semua bahan hingga matang."),
                new MRecipe( "Telur Rebus",  "Telur",  "Rebus telur selama 8–10 menit."),
                new MRecipe( "Ikan Bakar",  "Ikan, Jeruk Nipis, Garam, Bawang Putih",  "Lumuri ikan dan panggang sampai matang."),
                new MRecipe( "Sup Ayam",  "Dada Ayam, Wortel, Kentang, Seledri",  "Rebus semua bahan hingga empuk."),
                new MRecipe( "Sarden Tomat",  "Sarden, Tomat, Bawang Merah",  "Masak semua bahan sampai matang."),
                new MRecipe( "Tempe Goreng",  "Tempe, Bawang Putih, Ketumbar, Garam",  "Iris tempe, bumbui, lalu goreng."),
                new MRecipe( "Tahu Kukus",  "Tahu, Wortel, Telur",  "Campur bahan dan kukus selama 20 menit."),
                new MRecipe( "Sop Sayur",  "Wortel, Buncis, Kol, Jagung",  "Rebus semua bahan dengan sedikit garam."),
                new MRecipe( "Smoothie Berry",  "Strawberry, Blueberry, Yoghurt",  "Blender hingga halus."),
                new MRecipe( "Kentang Rebus",  "Kentang",  "Rebus kentang hingga empuk."),                    new MRecipe( "Ayam Panggang Lemon",  "Dada Ayam, Lemon, Lada, Garam",  "Panggang ayam dengan bumbu selama 30 menit."),
                new MRecipe( "Roti Gandum Alpukat",  "Roti Gandum, Alpukat, Telur",  "Oleskan alpukat di roti, tambahkan telur."),
                new MRecipe( "Yoghurt Granola",  "Yoghurt, Granola, Madu",  "Campurkan semuanya dalam mangkuk."),
                new MRecipe( "Sayur Asem",  "Melinjo, Labu, Kacang Panjang, Asam",  "Rebus semua bahan sampai matang."),
                new MRecipe( "Pisang Bakar Coklat",  "Pisang, Coklat, Keju",  "Bakar pisang dan taburi coklat serta keju."),
                new MRecipe( "Jus Wortel Jeruk",  "Wortel, Jeruk, Madu",  "Blender bahan dan saring."),
                new MRecipe( "Edamame Rebus",  "Edamame, Garam",  "Rebus edamame dan taburi garam.")
            );
        }

        List<MMenuItem> loadedNutritionReport = loadObject(NUTRITION_REPORT_FILE);
        if (loadedNutritionReport != null) {
            nutritionReportData = FXCollections.observableArrayList(loadedNutritionReport);
        } else {
            nutritionReportData = FXCollections.observableArrayList(
                new MMenuItem("Nasi Padang", 800.0, 30.0, 40.0, 80.0, 1, "Makan siang 2025-07-15"),
                new MMenuItem("Indomie Goreng", 450.0, 10.0, 20.0, 50.0, 1, "Makan malam 2025-07-15"),
                new MMenuItem("Bubur Ayam", 300.0, 15.0, 10.0, 30.0, 1, "Sarapan 2025-07-16")
            );
        }

        List<MBudgetItem> loadedBudgetReport = loadObject(BUDGET_REPORT_FILE);
        if (loadedBudgetReport != null) {
            budgetReportData = FXCollections.observableArrayList(loadedBudgetReport);
        } else {
            budgetReportData = FXCollections.observableArrayList(
                new MBudgetItem("Makan Siang Restoran", 50000.0, "Makanan", "Bayar pakai tunai 2025-07-15"),
                new MBudgetItem("Ongkos Taksi", 35000.0, "Transportasi", "Pergi ke kantor 2025-07-15"),
                new MBudgetItem("Beli Kopi", 25000.0, "Hiburan", "Kopi Starbucks 2025-07-16")
            );
        }
    }

    public static void saveData() {
        saveObject(profile, PROFILE_FILE);
        saveObject(new ArrayList<>(scheduleData), SCHEDULE_FILE);
        saveObject(new ArrayList<>(reportData), REPORT_FILE);
        saveObject(new ArrayList<>(nutritionPlanItems), NUTRITION_PLAN_FILE);
        saveObject(new ArrayList<>(budgetPlanItems), BUDGET_PLAN_FILE);
        saveObject(new ArrayList<>(recommendedRecipes), RECIPE_FILE);
        saveObject(new ArrayList<>(nutritionReportData), NUTRITION_REPORT_FILE);
        saveObject(new ArrayList<>(budgetReportData), BUDGET_REPORT_FILE);
    }

    private static void saveObject(Object obj, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(obj);
            System.out.println("Data saved to " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving data to " + fileName + ": " + e.getMessage());
        }
    }

    private static <T> T loadObject(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            System.out.println("Loading data from " + fileName);
            return (T) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println(fileName + " not found. Creating new data.");
            return null;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading data from " + fileName + ": " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public static MProfile getProfile() {return profile;}
    public static void setProfile(MProfile p) {profile = p;}
    public static ObservableList<MSchedule> getScheduleData() {return scheduleData;}
    public static void setScheduleData(ObservableList<MSchedule> data) {scheduleData = data;}
    public static ObservableList<MReport> getReportData() {return reportData;}
    public static void setReportData(ObservableList<MReport> data) {reportData = data;}
    public static ObservableList<MMenuItem> getNutritionPlanItems() {return nutritionPlanItems;}
    public static void setNutritionPlanItems(ObservableList<MMenuItem> data) {nutritionPlanItems = data;}
    public static ObservableList<MBudgetItem> getBudgetPlanItems() {return budgetPlanItems;}
    public static void setBudgetPlanItems(ObservableList<MBudgetItem> data) {budgetPlanItems = data;}
    public static ObservableList<MRecipe> getRecommendedRecipes() {return recommendedRecipes;}
    public static void setRecommendedRecipes(ObservableList<MRecipe> data) {recommendedRecipes = data;}
    public static ObservableList<MMenuItem> getNutritionReportData() {return nutritionReportData;}
    public static void setNutritionReportData(ObservableList<MMenuItem> data) {nutritionReportData = data;}
    public static ObservableList<MBudgetItem> getBudgetReportData() {return budgetReportData;}
    public static void setBudgetReportData(ObservableList<MBudgetItem> data) {budgetReportData = data;}
}