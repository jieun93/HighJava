 package gugudansam;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FxmlGuguDan extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(FxmlGuguDan.class
					.getResource("fxmlGuguDan.fxml")); // 신빌터 파일을 불러오는거 
			
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("구구단 연습"); // 입력창 윗부분에 나타나는거 
			primaryStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);  //FxmlGuguDan을 보여지게 하는거
	}
}
