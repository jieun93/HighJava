package kr.or.ddit.main.adminmypage;



import java.io.IOException;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
// 회원정보 관리 화면 창 
public class memberInfoMain extends Application {

	
	@Override
	public void start(Stage primaryStage) throws IOException {
		
			Parent root = FXMLLoader.load(memberInfoMain.class.getResource("../../fxml/adminmypage/memberInfo.fxml"));
		
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("회원관리");
			primaryStage.show();
			
		
	}
	public static void main(String[] args) {
		launch(args);
	}

	
}

