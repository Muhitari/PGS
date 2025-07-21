import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.text.NumberFormat;
import java.util.Locale;


public class CMain {

    //  Profil Pengguna 
    @FXML private TextField namaField;
    @FXML private Spinner<Double> tinggiSpinner;
    @FXML private Spinner<Double> beratSpinner;
    @FXML private Spinner<Integer> umurSpinner;
    @FXML private ComboBox<String> jenisKelaminComboBox;
    @FXML private TextField alergiField;
    @FXML private Button editProfileButton;
    @FXML private Button simpanProfileButton;
    @FXML private Button batalProfileButton;

    //  Penjadwalan 
    @FXML private TableView<MSchedule> scheduleTable;
    @FXML private TableColumn<MSchedule, String> activityColumn;
    @FXML private TableColumn<MSchedule, LocalDate> dateColumn;
    @FXML private TableColumn<MSchedule, LocalTime> timeColumn;
    @FXML private TableColumn<MSchedule, String> notesColumn;
    @FXML private TextField scheduleActivityField;
    @FXML private DatePicker scheduleDateField;
    @FXML private Spinner<Integer> scheduleHourSpinner;
    @FXML private Spinner<Integer> scheduleMinuteSpinner;
    @FXML private TextField scheduleNotesField;
    @FXML private Button addScheduleButton;
    @FXML private Button editScheduleButton;
    @FXML private Button deleteScheduleButton;

    //  Laporan Umum 
    @FXML private BarChart<String, Number> reportBudgetChart;
    @FXML private CategoryAxis budgetXAxis;
    @FXML private NumberAxis budgetYAxis;
    @FXML private BarChart<String, Number> reportNutritionChart;
    @FXML private CategoryAxis nutritionXAxis;
    @FXML private NumberAxis nutritionYAxis;
    @FXML private TableView<MReport> reportDataTable;
    @FXML private TableColumn<MReport, String> reportPeriodColumn;
    @FXML private TableColumn<MReport, Double> reportBudgetColumn;
    @FXML private TableColumn<MReport, Double> reportCalorieColumn;

    //  Perencanaan Nutrisi 
    @FXML private ComboBox<String> nutriGoalComboBox;
    @FXML private ComboBox<String> nutriPeriodComboBox;
    @FXML private TableView<MMenuItem> nutritionPlanTable;
    @FXML private TableColumn<MMenuItem, String> nutriItemColumn;
    @FXML private TableColumn<MMenuItem, Double> nutriCaloriesColumn;
    @FXML private TableColumn<MMenuItem, Double> nutriProteinColumn;
    @FXML private TableColumn<MMenuItem, Double> nutriFatColumn;
    @FXML private TableColumn<MMenuItem, Double> nutriCarbsColumn;
    @FXML private TableColumn<MMenuItem, Integer> nutriQuantityColumn;
    @FXML private TableColumn<MMenuItem, String> nutriNotesColumn;
    @FXML private TextField nutriItemField;
    @FXML private Spinner<Double> nutriCaloriesSpinner;
    @FXML private Spinner<Integer> nutriQuantitySpinner;
    @FXML private TextField nutriNotesField;

    //  Laporan Konsumsi Nutrisi Harian  
    @FXML private TableView<MMenuItem> nutritionReportTable;
    @FXML private TableColumn<MMenuItem, String> reportNutriItemColumn;
    @FXML private TableColumn<MMenuItem, Double> reportNutriCaloriesColumn;
    @FXML private TableColumn<MMenuItem, Double> reportNutriProteinColumn;
    @FXML private TableColumn<MMenuItem, Double> reportNutriFatColumn;
    @FXML private TableColumn<MMenuItem, Double> reportNutriCarbsColumn;
    @FXML private TableColumn<MMenuItem, Integer> reportNutriQuantityColumn;
    @FXML private TableColumn<MMenuItem, String> reportNutriNotesColumn;

    //  Perencanaan Anggaran 
    @FXML private TextField monthlyBudgetField;
    @FXML private TableView<MBudgetItem> budgetPlanTable; 
    @FXML private TableColumn<MBudgetItem, String> budgetPlanItemColumn; 
    @FXML private TableColumn<MBudgetItem, Double> budgetPlanAmountColumn; 
    @FXML private TableColumn<MBudgetItem, String> budgetPlanCategoryColumn; 
    @FXML private TableColumn<MBudgetItem, String> budgetPlanNotesColumn; 
    @FXML private TextField budgetItemField;
    @FXML private Spinner<Double> budgetAmountSpinner;
    @FXML private ComboBox<String> budgetCategoryComboBox;
    @FXML private TextField budgetNotesField;

    //  Laporan Pengeluaran Harian 
    @FXML private TableView<MBudgetItem> budgetReportTable;
    @FXML private TableColumn<MBudgetItem, String> reportBudgetItemColumn;
    @FXML private TableColumn<MBudgetItem, Double> reportBudgetAmountColumn;
    @FXML private TableColumn<MBudgetItem, String> reportBudgetCategoryColumn;
    @FXML private TableColumn<MBudgetItem, String> reportBudgetNotesColumn;

    //  Rekomendasi Resep 
    @FXML private ComboBox<String> availableIngredientsComboBox;
    @FXML private TableView<MRecipe> recipeTable;
    @FXML private TableColumn<MRecipe, String> recipeNameColumn;
    @FXML private TableColumn<MRecipe, String> recipeIngredientsColumn;
    @FXML private TableColumn<MRecipe, String> recipeInstructionsColumn;
    @FXML private TextField recipeNameField;
    @FXML private TextField recipeIngredientsField;
    @FXML private TextField recipeInstructionsField;

    @FXML private TabPane mainTabPane;

    //  Data Model List 
    private MProfile currentProfile;
    private ObservableList<MSchedule> scheduleData;
    private ObservableList<MReport> reportData;
    private ObservableList<MMenuItem> nutritionPlanItems;
    private ObservableList<MBudgetItem> budgetPlanItems;
    private ObservableList<MRecipe> recommendedRecipes;
    private ObservableList<MMenuItem> nutritionReportData;
    private ObservableList<MBudgetItem> budgetReportData;


    @FXML
    public void initialize() {
        // Inisialisasi Profil Pengguna
        currentProfile = DataManager.getProfile();
        tinggiSpinner.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(100.0, 250.0, 170.0, 0.5));
        beratSpinner.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(10.0, 200.0, 60.0, 0.5));
        umurSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(18, 70, 25));
        jenisKelaminComboBox.getItems().addAll("Pria", "Wanita", "Lainnya");
        loadProfileData();
        setProfileEditable(false);

        // Inisialisasi Penjadwalan
        activityColumn.setCellValueFactory(new PropertyValueFactory<>("aktivitas"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("tanggal"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("waktu"));
        notesColumn.setCellValueFactory(new PropertyValueFactory<>("catatan"));
        scheduleData = DataManager.getScheduleData();
        scheduleTable.setItems(scheduleData);
        scheduleHourSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, 7));
        scheduleMinuteSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, 0, 5));
        scheduleTable.getSelectionModel().selectedItemProperty().addListener(
            (obs, oldSelection, newSelection) -> {
                if (newSelection != null) {
                    scheduleActivityField.setText(newSelection.getAktivitas());
                    scheduleDateField.setValue(newSelection.getTanggal());
                    scheduleHourSpinner.getValueFactory().setValue(newSelection.getWaktu().getHour());
                    scheduleMinuteSpinner.getValueFactory().setValue(newSelection.getWaktu().getMinute());
                    scheduleNotesField.setText(newSelection.getCatatan());
                } else {
                    clearScheduleFields();
                }
            });

        // Inisialisasi Laporan Umum
        reportPeriodColumn.setCellValueFactory(new PropertyValueFactory<>("periode"));
        reportBudgetColumn.setCellValueFactory(new PropertyValueFactory<>("totalAnggaranBiaya"));
        reportCalorieColumn.setCellValueFactory(new PropertyValueFactory<>("totalKalori"));
        reportData = DataManager.getReportData();
        reportDataTable.setItems(reportData);
        populateCharts();

        reportBudgetColumn.setCellFactory(column -> new TableCell<MReport, Double>() {
            @Override
            protected void updateItem(Double item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    NumberFormat nf = NumberFormat.getNumberInstance(new Locale("id", "ID"));
                    nf.setMinimumFractionDigits(0);
                    nf.setMaximumFractionDigits(2);
                    setText(nf.format(item));
                }
            }
        });

        // Inisialisasi Perencanaan Nutrisi
        nutriItemColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nutriCaloriesColumn.setCellValueFactory(new PropertyValueFactory<>("calories"));
        nutriProteinColumn.setCellValueFactory(new PropertyValueFactory<>("protein"));
        nutriFatColumn.setCellValueFactory(new PropertyValueFactory<>("fat"));
        nutriCarbsColumn.setCellValueFactory(new PropertyValueFactory<>("carbs"));
        nutriQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        nutriNotesColumn.setCellValueFactory(new PropertyValueFactory<>("notes"));
        nutritionPlanItems = DataManager.getNutritionPlanItems();
        nutritionPlanTable.setItems(nutritionPlanItems); 

        nutriCaloriesSpinner.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0.0, 5000.0, 100.0, 10.0));
        nutriQuantitySpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1));
        nutritionPlanTable.getSelectionModel().selectedItemProperty().addListener( 
            (obs, oldSelection, newSelection) -> {
                if (newSelection != null) {
                    nutriItemField.setText(newSelection.getName());
                    nutriCaloriesSpinner.getValueFactory().setValue(newSelection.getCalories());
                    nutriQuantitySpinner.getValueFactory().setValue(newSelection.getQuantity());
                    nutriNotesField.setText(newSelection.getNotes());
                } else {
                    clearNutritionFields();
                }
            });
        nutriGoalComboBox.getItems().addAll("Diet", "Hemat Biaya", "Bulking");
        nutriPeriodComboBox.getItems().addAll("Harian", "Mingguan", "Bulanan");

        // Inisialisasi Laporan Konsumsi Nutrisi Harian 
        reportNutriItemColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        reportNutriCaloriesColumn.setCellValueFactory(new PropertyValueFactory<>("calories"));
        reportNutriProteinColumn.setCellValueFactory(new PropertyValueFactory<>("protein"));
        reportNutriFatColumn.setCellValueFactory(new PropertyValueFactory<>("fat"));
        reportNutriCarbsColumn.setCellValueFactory(new PropertyValueFactory<>("carbs"));
        reportNutriQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        reportNutriNotesColumn.setCellValueFactory(new PropertyValueFactory<>("notes"));
        nutritionReportData = DataManager.getNutritionReportData(); 
        nutritionReportTable.setItems(nutritionReportData);

        // Inisialisasi Perencanaan Anggaran
        budgetPlanItemColumn.setCellValueFactory(new PropertyValueFactory<>("item")); 
        budgetPlanAmountColumn.setCellValueFactory(new PropertyValueFactory<>("amount")); 
        budgetPlanCategoryColumn.setCellValueFactory(new PropertyValueFactory<>("category")); 
        budgetPlanNotesColumn.setCellValueFactory(new PropertyValueFactory<>("notes")); 
        budgetPlanItems = DataManager.getBudgetPlanItems(); 
        budgetPlanTable.setItems(budgetPlanItems); 

        budgetPlanAmountColumn.setCellFactory(column -> new TableCell<MBudgetItem, Double>() { 
            @Override
            protected void updateItem(Double item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    NumberFormat nf = NumberFormat.getNumberInstance(new Locale("id", "ID"));
                    nf.setMinimumFractionDigits(0);
                    nf.setMaximumFractionDigits(2);
                    setText(nf.format(item));
                }
            }
        });

        budgetAmountSpinner.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0.0, 10000000.0, 10000.0, 1000.0));
        budgetCategoryComboBox.getItems().addAll("Makanan", "Transportasi", "Hiburan", "Lain-lain", "Tagihan & Utilitas", "Tabungan");
        budgetPlanTable.getSelectionModel().selectedItemProperty().addListener( 
            (obs, oldSelection, newSelection) -> {
                if (newSelection != null) {
                    budgetItemField.setText(newSelection.getItem());
                    budgetAmountSpinner.getValueFactory().setValue(newSelection.getAmount());
                    budgetCategoryComboBox.setValue(newSelection.getCategory());
                    budgetNotesField.setText(newSelection.getNotes());
                } else {
                    clearBudgetFields();
                }
            });

        // Inisialisasi Laporan Pengeluaran Harian 
        reportBudgetItemColumn.setCellValueFactory(new PropertyValueFactory<>("item"));
        reportBudgetAmountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        reportBudgetCategoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        reportBudgetNotesColumn.setCellValueFactory(new PropertyValueFactory<>("notes"));
        budgetReportData = DataManager.getBudgetReportData(); 
        budgetReportTable.setItems(budgetReportData);

        reportBudgetAmountColumn.setCellFactory(column -> new TableCell<MBudgetItem, Double>() {
            @Override
            protected void updateItem(Double item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    NumberFormat nf = NumberFormat.getNumberInstance(new Locale("id", "ID"));
                    nf.setMinimumFractionDigits(0);
                    nf.setMaximumFractionDigits(2);
                    setText(nf.format(item));
                }
            }
        });


        // Inisialisasi Rekomendasi Resep
        recipeNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        recipeIngredientsColumn.setCellValueFactory(new PropertyValueFactory<>("ingredients"));
        recipeInstructionsColumn.setCellValueFactory(new PropertyValueFactory<>("instructions"));
        recommendedRecipes = DataManager.getRecommendedRecipes();
        recipeTable.setItems(recommendedRecipes);

        recipeTable.getSelectionModel().selectedItemProperty().addListener(
            (obs, oldSelection, newSelection) -> {
                if (newSelection != null) {
                    recipeNameField.setText(newSelection.getName());
                    recipeIngredientsField.setText(newSelection.getIngredients());
                    recipeInstructionsField.setText(newSelection.getInstructions());
                } else {
                    clearRecipeFields();
                }
            });
        availableIngredientsComboBox.getItems().addAll(
            "ayam", "sapi", "telur", "tempe", "tahu", "ikan", "udang", "kambing", "salmon","brokoli", "wortel", "bayam", "kangkung", "buncis", "kol", "tomat", "labu", "kentang", "jagung","nasi", "roti gandum", "oat", "mie", "ubi","pisang", "apel", "anggur", "jeruk", "strawberry", "blueberry", "pepaya", "alpukat", "kelapa","yoghurt", "susu", "keju","kacang", "edamame","minyak zaitun", "madu","bawang putih", "bawang merah", "seledri", "cabai", "jahe", "kunyit", "lengkuas", "asam jawa", "garam", "lada", "kecap manis"
        );
    }

    //  Metode Handler untuk Profil Pengguna 
    private void loadProfileData() {
        if (currentProfile != null) {
            namaField.setText(currentProfile.getNama());
            tinggiSpinner.getValueFactory().setValue(currentProfile.getTinggi());
            beratSpinner.getValueFactory().setValue(currentProfile.getBerat());
            umurSpinner.getValueFactory().setValue(currentProfile.getUmur());
            jenisKelaminComboBox.setValue(currentProfile.getJenisKelamin());
            alergiField.setText(currentProfile.getAlergi());
        } else {
            namaField.setText("");
            tinggiSpinner.getValueFactory().setValue(170.0);
            beratSpinner.getValueFactory().setValue(60.0);
            umurSpinner.getValueFactory().setValue(25);
            jenisKelaminComboBox.setValue(null);
            alergiField.setText("");
        }
    }

    @FXML
    private void handleEditProfile(ActionEvent event) {
        System.out.println("Tombol Edit Profil ditekan");
        setProfileEditable(true);
    }

    @FXML
    private void handleSimpanProfile(ActionEvent event) {
        System.out.println("Tombol Simpan Profil ditekan");
        try {
            if (currentProfile == null) {
                currentProfile = new MProfile();
            }
            currentProfile.setNama(namaField.getText());
            currentProfile.setTinggi(tinggiSpinner.getValue());
            currentProfile.setBerat(beratSpinner.getValue());
            currentProfile.setUmur(umurSpinner.getValue());
            currentProfile.setJenisKelamin(jenisKelaminComboBox.getValue());
            currentProfile.setAlergi(alergiField.getText());

            DataManager.setProfile(currentProfile);
            DataManager.saveData();

            setProfileEditable(false);
            showAlert("Informasi", "Profil berhasil disimpan!");
        } catch (Exception e) {
            showAlert("Error", "Gagal menyimpan profil. Pastikan semua data diisi dengan benar: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    private void handleBatalProfile(ActionEvent event) {
        System.out.println("Tombol Batal Profil ditekan");
        DataManager.loadData();
        currentProfile = DataManager.getProfile();
        loadProfileData();
        setProfileEditable(false);
    }

    private void setProfileEditable(boolean editable) {
        namaField.setEditable(editable);
        alergiField.setEditable(editable);
        tinggiSpinner.setEditable(editable);
        beratSpinner.setEditable(editable);
        umurSpinner.setEditable(editable);
        jenisKelaminComboBox.setDisable(!editable);
        simpanProfileButton.setDisable(!editable);
        batalProfileButton.setDisable(!editable);
        editProfileButton.setDisable(editable);
    }

    //  Metode Handler untuk Penjadwalan 
    @FXML
    private void handleAddSchedule(ActionEvent event) {
        System.out.println("Tombol Tambah Jadwal ditekan");
        try {
            String activity = scheduleActivityField.getText();
            LocalDate date = scheduleDateField.getValue();
            LocalTime time = LocalTime.of(scheduleHourSpinner.getValue(), scheduleMinuteSpinner.getValue());
            String notes = scheduleNotesField.getText();

            if (activity.isEmpty() || date == null) {
                showAlert("Peringatan", "Mohon lengkapi Aktivitas dan Tanggal.");
                return;
            }

            MSchedule newSchedule = new MSchedule(activity, date, time, notes);
            scheduleData.add(newSchedule);
            DataManager.setScheduleData(scheduleData);
            DataManager.saveData();
            clearScheduleFields();
            showAlert("Informasi", "Jadwal berhasil ditambahkan!");
        }
        // ... (sisanya sama seperti sebelumnya)
        catch (Exception e) {
            showAlert("Error", "Gagal menambahkan jadwal: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    private void handleEditSchedule(ActionEvent event) {
        System.out.println("Tombol Edit Jadwal ditekan");
        MSchedule selectedSchedule = scheduleTable.getSelectionModel().getSelectedItem();
        if (selectedSchedule != null) {
            try {
                selectedSchedule.setAktivitas(scheduleActivityField.getText());
                selectedSchedule.setTanggal(scheduleDateField.getValue());
                selectedSchedule.setWaktu(LocalTime.of(scheduleHourSpinner.getValue(), scheduleMinuteSpinner.getValue()));
                selectedSchedule.setCatatan(scheduleNotesField.getText());
                scheduleTable.refresh();
                DataManager.setScheduleData(scheduleData);
                DataManager.saveData();
                showAlert("Informasi", "Jadwal berhasil diperbarui!");
            } catch (Exception e) {
                showAlert("Error", "Gagal memperbarui jadwal: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            showAlert("Peringatan", "Pilih jadwal yang ingin diedit.");
        }
    }

    @FXML
    private void handleDeleteSchedule(ActionEvent event) {
        System.out.println("Tombol Hapus Jadwal ditekan");
        MSchedule selectedSchedule = scheduleTable.getSelectionModel().getSelectedItem();
        if (selectedSchedule != null) {
            scheduleData.remove(selectedSchedule);
            DataManager.setScheduleData(scheduleData);
            DataManager.saveData();
            showAlert("Informasi", "Jadwal berhasil dihapus!");
            clearScheduleFields();
        } else {
            showAlert("Peringatan", "Pilih jadwal yang ingin dihapus.");
        }
    }

    private void clearScheduleFields() {
        scheduleActivityField.clear();
        scheduleDateField.setValue(null);
        scheduleHourSpinner.getValueFactory().setValue(7);
        scheduleMinuteSpinner.getValueFactory().setValue(0);
        scheduleNotesField.clear();
        scheduleTable.getSelectionModel().clearSelection();
    }

    //  Metode untuk Laporan Umum (Chart) 
    private void populateCharts() {
        reportBudgetChart.getData().clear();
        reportNutritionChart.getData().clear();

        XYChart.Series<String, Number> budgetSeries = new XYChart.Series<>();
        budgetSeries.setName("Anggaran Biaya");
        for (MReport report : reportData) {
            budgetSeries.getData().add(new XYChart.Data<>(report.getPeriode(), report.getTotalAnggaranBiaya()));
        }
        reportBudgetChart.getData().add(budgetSeries);

        XYChart.Series<String, Number> nutritionSeries = new XYChart.Series<>();
        nutritionSeries.setName("Total Kalori");
        for (MReport report : reportData) {
            nutritionSeries.getData().add(new XYChart.Data<>(report.getPeriode(), report.getTotalKalori()));
        }
        reportNutritionChart.getData().add(nutritionSeries);
    }

    //  Metode Handler untuk Perencanaan Nutrisi 
    @FXML
    private void handlePlanNutrition(ActionEvent event) {
        System.out.println("Tombol Rencanakan Nutrisi ditekan");
        String selectedGoal = nutriGoalComboBox.getValue();
        String selectedPeriod = nutriPeriodComboBox.getValue();

        if (selectedGoal == null || selectedGoal.isEmpty()) {
            showAlert("Peringatan", "Mohon pilih Tujuan Nutrisi.");
            return;
        }
        if (selectedPeriod == null || selectedPeriod.isEmpty()) {
            showAlert("Peringatan", "Mohon pilih Periode Nutrisi.");
            return;
        }

        nutritionPlanItems.clear();

        if ("Diet".equals(selectedGoal)) {
            if ("Harian".equals(selectedPeriod)) {
                generateDailyDietPlan();
            } else if ("Mingguan".equals(selectedPeriod)) {
                generateWeeklyDietPlan();
            } else if ("Bulanan".equals(selectedPeriod)) {
                generateMonthlyDietPlan();
            }
        } else if ("Hemat Biaya".equals(selectedGoal)) {
            if ("Harian".equals(selectedPeriod)) {
                generateDailyBudgetPlan();
            } else if ("Mingguan".equals(selectedPeriod)) {
                generateWeeklyBudgetPlan();
            } else if ("Bulanan".equals(selectedPeriod)) {
                generateMonthlyBudgetPlan();
            }
        } else if ("Bulking".equals(selectedGoal)) {
            if ("Harian".equals(selectedPeriod)) {
                generateDailyBulkingPlan();
            } else if ("Mingguan".equals(selectedPeriod)) {
                generateWeeklyBulkingPlan();
            } else if ("Bulanan".equals(selectedPeriod)) {
                generateMonthlyBulkingPlan();
            }
        } else {
            showAlert("Rencana Nutrisi", "Kombinasi tujuan '" + selectedGoal + "' dan periode '" + selectedPeriod + "' belum didukung.");
        }

        nutritionPlanTable.setItems(nutritionPlanItems); 
        DataManager.setNutritionPlanItems(nutritionPlanItems);
        DataManager.saveData();

        showAlert("Rencana Nutrisi", "Rencana nutrisi untuk tujuan '" + selectedGoal + "' dan periode '" + selectedPeriod + "' telah dihasilkan.");
    }

    private void generateDailyDietPlan() {
        nutritionPlanItems.add(new MMenuItem("Oatmeal", 150.0, 5.0, 3.0, 25.0, 1, "Sarapan ringan"));
        nutritionPlanItems.add(new MMenuItem("Salad Ayam Bakar", 300.0, 30.0, 10.0, 15.0, 1, "Makan siang"));
        nutritionPlanItems.add(new MMenuItem("Sup Sayuran", 100.0, 5.0, 2.0, 10.0, 1, "Makan malam ringan"));
        nutritionPlanItems.add(new MMenuItem("Buah Apel", 80.0, 0.0, 0.0, 20.0, 1, "Cemilan"));
    }

    private void generateWeeklyDietPlan() {
        nutritionPlanItems.add(new MMenuItem("Menu Diet Senin", 1200.0, 80.0, 30.0, 150.0, 1, "Total per hari"));
        nutritionPlanItems.add(new MMenuItem("Menu Diet Selasa", 1300.0, 85.0, 35.0, 160.0, 1, "Total per hari"));
        nutritionPlanItems.add(new MMenuItem("Total Diet Mingguan", 8500.0, 550.0, 200.0, 1000.0, 1, "Estimasi total kalori/makro mingguan"));
    }

    private void generateMonthlyDietPlan() {
        nutritionPlanItems.add(new MMenuItem("Ringkasan Diet Bulan Ini", 35000.0, 2500.0, 800.0, 4000.0, 1, "Estimasi total kalori/makro bulanan"));
    }

    private void generateDailyBudgetPlan() {
        nutritionPlanItems.add(new MMenuItem("Nasi Goreng Sederhana", 400.0, 15.0, 10.0, 60.0, 1, "Sarapan/Makan siang murah"));
        nutritionPlanItems.add(new MMenuItem("Tempe Penyet", 350.0, 20.0, 15.0, 40.0, 1, "Makan siang/Makan malam"));
        nutritionPlanItems.add(new MMenuItem("Air Putih", 0.0, 0.0, 0.0, 0.0, 2, "Minuman"));
    }

    private void generateWeeklyBudgetPlan() {
        nutritionPlanItems.add(new MMenuItem("Paket Makan Murah (7 Hari)", 8000.0, 300.0, 200.0, 1200.0, 1, "Rencana makan ekonomis 7 hari"));
    }

    private void generateMonthlyBudgetPlan() {
        nutritionPlanItems.add(new MMenuItem("Rencana Makanan Bulanan Hemat", 30000.0, 1200.0, 800.0, 4800.0, 1, "Estimasi total bulanan"));
    }

    private void generateDailyBulkingPlan() {
        nutritionPlanItems.add(new MMenuItem("Telur dan Roti Gandum", 400.0, 20.0, 15.0, 40.0, 1, "Sarapan berat"));
        nutritionPlanItems.add(new MMenuItem("Nasi, Ayam, Brokoli", 600.0, 40.0, 20.0, 60.0, 1, "Makan siang utama"));
        nutritionPlanItems.add(new MMenuItem("Protein Shake", 250.0, 30.0, 5.0, 20.0, 1, "Pasca-latihan"));
        nutritionPlanItems.add(new MMenuItem("Daging Merah dan Kentang", 700.0, 50.0, 25.0, 70.0, 1, "Makan malam berat"));
    }

    private void generateWeeklyBulkingPlan() {
        nutritionPlanItems.add(new MMenuItem("Menu Bulking Intensif (7 Hari)", 15000.0, 800.0, 400.0, 2000.0, 1, "Rencana bulking 7 hari"));
    }

    private void generateMonthlyBulkingPlan() {
        nutritionPlanItems.add(new MMenuItem("Ringkasan Bulking Bulan Ini", 60000.0, 3200.0, 1600.0, 8000.0, 1, "Estimasi total bulanan"));
    }

    @FXML
    private void handleAddNutritionItem(ActionEvent event) {
        System.out.println("Tombol Tambah Item Nutrisi ditekan");
        try {
            String item = nutriItemField.getText();
            double calories = nutriCaloriesSpinner.getValue();
            double protein = 0.0;
            double fat = 0.0;   
            double carbs = 0.0;
            int quantity = nutriQuantitySpinner.getValue();
            String notes = nutriNotesField.getText();

            if (item.isEmpty()) {
                showAlert("Peringatan", "Nama Item Makanan tidak boleh kosong.");
                return;
            }
            MMenuItem newItem = new MMenuItem(item, calories, protein, fat, carbs, quantity, notes);
            nutritionPlanItems.add(newItem);
            DataManager.setNutritionPlanItems(nutritionPlanItems);
            DataManager.saveData();
            clearNutritionFields();
            showAlert("Informasi", "Item nutrisi berhasil ditambahkan!");
        } catch (Exception e) {
            showAlert("Error", "Gagal menambahkan item nutrisi: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    private void handleEditNutritionItem(ActionEvent event) {
        System.out.println("Tombol Edit Item Nutrisi ditekan");
        MMenuItem selectedItem = nutritionPlanTable.getSelectionModel().getSelectedItem(); 
        if (selectedItem != null) {
            try {
                selectedItem.setName(nutriItemField.getText());
                selectedItem.setCalories(nutriCaloriesSpinner.getValue());
                selectedItem.setQuantity(nutriQuantitySpinner.getValue());
                selectedItem.setNotes(nutriNotesField.getText());
                nutritionPlanTable.refresh(); 
                DataManager.setNutritionPlanItems(nutritionPlanItems);
                DataManager.saveData();
                showAlert("Informasi", "Item nutrisi berhasil diperbarui!");
            } catch (Exception e) {
                showAlert("Error", "Gagal memperbarui item nutrisi: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            showAlert("Peringatan", "Pilih item nutrisi yang ingin diedit.");
        }
    }

    @FXML
    private void handleDeleteNutritionItem(ActionEvent event) {
        System.out.println("Tombol Hapus Item Nutrisi ditekan");
        MMenuItem selectedItem = nutritionPlanTable.getSelectionModel().getSelectedItem(); 
        if (selectedItem != null) {
            nutritionPlanItems.remove(selectedItem);
            DataManager.setNutritionPlanItems(nutritionPlanItems);
            DataManager.saveData();
            showAlert("Informasi", "Item nutrisi berhasil dihapus!");
            clearNutritionFields();
        } else {
            showAlert("Peringatan", "Pilih item nutrisi yang ingin dihapus.");
        }
    }

    private void clearNutritionFields() {
        nutriItemField.clear();
        nutriCaloriesSpinner.getValueFactory().setValue(100.0);
        nutriQuantitySpinner.getValueFactory().setValue(1);
        nutriNotesField.clear();
        nutritionPlanTable.getSelectionModel().clearSelection(); 
    }

    //  Metode Handler untuk Perencanaan Anggaran 
    @FXML
    private void handlePlanBudget(ActionEvent event) {
        System.out.println("Tombol Rencanakan Anggaran ditekan");
        try {
            double totalBudget = Double.parseDouble(monthlyBudgetField.getText().replace(".", "").replace(",", ""));

            if (totalBudget <= 0) {
                showAlert("Peringatan", "Anggaran bulanan harus lebih besar dari 0.");
                return;
            }

            budgetPlanItems.clear(); 

            Map<String, Double> budgetAllocation = new HashMap<>();
            budgetAllocation.put("Makanan", totalBudget * 0.50);
            budgetAllocation.put("Transportasi", totalBudget * 0.25);
            budgetAllocation.put("Tagihan & Utilitas", totalBudget * 0.25);

            for (Map.Entry<String, Double> entry : budgetAllocation.entrySet()) {
                String category = entry.getKey();
                Double amount = entry.getValue();
                budgetPlanItems.add(new MBudgetItem(category, amount, category, "Anggaran bulanan untuk " + category.toLowerCase()));
            }

            DataManager.setBudgetPlanItems(budgetPlanItems); 
            DataManager.saveData();
            budgetPlanTable.refresh(); 
            showAlert("Informasi", "Perencanaan anggaran bulanan berhasil dibuat!");

        } catch (NumberFormatException e) {
            showAlert("Error", "Masukkan anggaran bulanan dalam format angka yang valid. Contoh: 5000000");
        } catch (Exception e) {
            showAlert("Error", "Gagal merencanakan anggaran: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    private void handleAddBudgetItem(ActionEvent event) {
        System.out.println("Tombol Tambah Item Anggaran ditekan");
        try {
            String item = budgetItemField.getText();
            double amount = budgetAmountSpinner.getValue();
            String category = budgetCategoryComboBox.getValue();
            String notes = budgetNotesField.getText();

            if (item.isEmpty() || category == null) {
                showAlert("Peringatan", "Item Anggaran dan Kategori tidak boleh kosong.");
                return;
            }
            MBudgetItem newItem = new MBudgetItem(item, amount, category, notes);
            budgetPlanItems.add(newItem); 
            DataManager.setBudgetPlanItems(budgetPlanItems); 
            DataManager.saveData();
            clearBudgetFields();
            showAlert("Informasi", "Item anggaran berhasil ditambahkan!");
        } catch (Exception e) {
            showAlert("Error", "Gagal menambahkan item anggaran: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    private void handleEditBudgetItem(ActionEvent event) {
        System.out.println("Tombol Edit Item Anggaran ditekan");
        MBudgetItem selectedItem = budgetPlanTable.getSelectionModel().getSelectedItem(); 
        if (selectedItem != null) {
            try {
                selectedItem.setItem(budgetItemField.getText());
                selectedItem.setAmount(budgetAmountSpinner.getValue());
                selectedItem.setCategory(budgetCategoryComboBox.getValue());
                selectedItem.setNotes(budgetNotesField.getText());
                budgetPlanTable.refresh(); 
                DataManager.setBudgetPlanItems(budgetPlanItems); 
                DataManager.saveData();
                showAlert("Informasi", "Item anggaran berhasil diperbarui!");
            } catch (Exception e) {
                showAlert("Error", "Gagal memperbarui item anggaran: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            showAlert("Peringatan", "Pilih item anggaran yang ingin diedit.");
        }
    }

    @FXML
    private void handleDeleteBudgetItem(ActionEvent event) {
        System.out.println("Tombol Hapus Item Anggaran ditekan");
        MBudgetItem selectedItem = budgetPlanTable.getSelectionModel().getSelectedItem(); 
        if (selectedItem != null) {
            budgetPlanItems.remove(selectedItem); 
            DataManager.setBudgetPlanItems(budgetPlanItems); 
            DataManager.saveData();
            showAlert("Informasi", "Item anggaran berhasil dihapus!");
            clearBudgetFields();
        } else {
            showAlert("Peringatan", "Pilih item anggaran yang ingin dihapus.");
        }
    }

    private void clearBudgetFields() {
        budgetItemField.clear();
        budgetAmountSpinner.getValueFactory().setValue(10000.0);
        budgetCategoryComboBox.setValue(null);
        budgetNotesField.clear();
        budgetPlanTable.getSelectionModel().clearSelection(); 
    }

    //  Metode Handler untuk Rekomendasi Resep 
    @FXML
    private void handleSearchRecipes(ActionEvent event) {
        System.out.println("Tombol Cari Resep ditekan");
        String selectedIngredient = availableIngredientsComboBox.getValue();
        if (selectedIngredient == null || selectedIngredient.isEmpty()) {
            showAlert("Peringatan", "Pilih bahan makanan terlebih dahulu.");
            return;
        }

        ObservableList<MRecipe> filteredRecipes = FXCollections.observableArrayList();
        for (MRecipe recipe : DataManager.getRecommendedRecipes()) {
            if (recipe.getIngredients().toLowerCase().contains(selectedIngredient.toLowerCase())) {
                filteredRecipes.add(recipe);
            }
        }
        recipeTable.setItems(filteredRecipes);

        if (filteredRecipes.isEmpty()) {
            showAlert("Informasi", "Tidak ada resep yang ditemukan dengan bahan '" + selectedIngredient + "'.");
        }
    }

    @FXML
    private void handleAddRecipe(ActionEvent event) {
        System.out.println("Tombol Tambah Resep ditekan");
        try {
            String name = recipeNameField.getText();
            String ingredients = recipeIngredientsField.getText();
            String instructions = recipeInstructionsField.getText();

            if (name.isEmpty() || ingredients.isEmpty()) {
                showAlert("Peringatan", "Nama Resep dan Bahan-bahan tidak boleh kosong.");
                return;
            }
            MRecipe newRecipe = new MRecipe(name, ingredients, instructions);
            recommendedRecipes.add(newRecipe);
            DataManager.setRecommendedRecipes(recommendedRecipes);
            DataManager.saveData();
            clearRecipeFields();
            showAlert("Informasi", "Resep berhasil ditambahkan!");
        } catch (Exception e) {
            showAlert("Error", "Gagal menambahkan resep: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    private void handleEditRecipe(ActionEvent event) {
        System.out.println("Tombol Edit Resep ditekan");
        MRecipe selectedRecipe = recipeTable.getSelectionModel().getSelectedItem();
        if (selectedRecipe != null) {
            try {
                selectedRecipe.setName(recipeNameField.getText());
                selectedRecipe.setIngredients(recipeIngredientsField.getText());
                selectedRecipe.setInstructions(recipeInstructionsField.getText());
                recipeTable.refresh();
                DataManager.setRecommendedRecipes(recommendedRecipes);
                DataManager.saveData();
                showAlert("Informasi", "Resep berhasil diperbarui!");
            } catch (Exception e) {
                showAlert("Error", "Gagal memperbarui resep: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            showAlert("Peringatan", "Pilih resep yang ingin diedit.");
        }
    }

    @FXML
    private void handleDeleteRecipe(ActionEvent event) {
        System.out.println("Tombol Hapus Resep ditekan");
        MRecipe selectedRecipe = recipeTable.getSelectionModel().getSelectedItem();
        if (selectedRecipe != null) {
            recommendedRecipes.remove(selectedRecipe);
            DataManager.setRecommendedRecipes(recommendedRecipes);
            DataManager.saveData();
            showAlert("Informasi", "Resep berhasil dihapus!");
            clearRecipeFields();
        } else {
            showAlert("Peringatan", "Pilih resep yang ingin dihapus.");
        }
    }

    private void clearRecipeFields() {
        recipeNameField.clear();
        recipeIngredientsField.clear();
        recipeInstructionsField.clear();
        recipeTable.getSelectionModel().clearSelection();
    }

    //  Navigasi Tab 
    @FXML public void goToProfileTab(ActionEvent event) {mainTabPane.getSelectionModel().select(0);}
    @FXML public void goToScheduleTab(ActionEvent event) {mainTabPane.getSelectionModel().select(1);}
    @FXML public void goToReportTab(ActionEvent event) {mainTabPane.getSelectionModel().select(2);}
    @FXML public void goToNutritionPlanTab(ActionEvent event) {mainTabPane.getSelectionModel().select(3);}
    @FXML public void goToBudgetPlanTab(ActionEvent event) {mainTabPane.getSelectionModel().select(4);}
    @FXML public void goToRecipeRecommendationTab(ActionEvent event) {mainTabPane.getSelectionModel().select(5);}

    //  Metode Bantuan Umum 
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}