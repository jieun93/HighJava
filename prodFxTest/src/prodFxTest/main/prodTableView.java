package prodFxTest.main;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class prodTableView extends Application{

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(prodTableView.class.getResource("../fxml/prodFxTest.fxml"));
			
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("물건선택");
			primaryStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	 
	
	public static void main(String[] args) {
		launch(args);
	}
}
