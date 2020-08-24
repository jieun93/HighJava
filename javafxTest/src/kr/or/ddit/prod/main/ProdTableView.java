package kr.or.ddit.prod.main;

import java.io.IOException;

import org.omg.CORBA.PRIVATE_MEMBER;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ProdTableView extends Application {
	
	
	// 화면에 띄우는 거 
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(ProdTableView.class
					.getResource("../fxml/Prod.fxml"));
			
			Scene scene = new Scene(root);
				primaryStage.setScene(scene);
				primaryStage.setTitle("상품검색");
				primaryStage.show();
				
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
