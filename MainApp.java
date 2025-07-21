import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import src.DataManager;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        DataManager.loadData();

        Parent root = FXMLLoader.load(getClass().getResource("src.VProfile.fxml"));
        primaryStage.setTitle("Personalize Nutrition Plan");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        DataManager.saveData();
        super.stop();
    }

    public static void main(String[] args) {
        launch(args);
    }
}