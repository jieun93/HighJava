package basic;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FxmlLayout extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		// fxml파일을 읽어와 현재의 Stage에 적용하는 방법
		
		// fxml 파일을 읽어오는 방법 1
		//(FXMLLoader.load 사용하는 방법)
		// VBox root = FXMLLoader.load(FxmlLayout.class.getResource("FxmlLayout.fxml"));
		// Parent root = FXMLLoader.load(FxmlLayout.class.getResource("FxmlLayout.fxml"));

		
		
		// fxml을 처리하는 객체를 controler객체가 필요하면 2번째 방법을 이용한다.
		// fxml 파일을 읽어오는 방법 2
		FXMLLoader loader = new FXMLLoader(FxmlLayout.class.getResource("FxmlLayout.fxml"));
		
		VBox  root = loader.load();
		// Parent root = loader.load();
		
		
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		
		primaryStage.setTitle("Fxml 파일을 이용한 레이아웃 연습");
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
