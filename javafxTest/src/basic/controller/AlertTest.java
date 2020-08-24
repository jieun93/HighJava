package basic.controller;

import java.util.Optional;

import org.omg.CORBA.PRIVATE_MEMBER;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AlertTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		VBox root = new VBox(10);
		root.setPadding(new Insets(20));	
		
		
		HBox hbTop = new HBox(10);
		hbTop.setPadding(new Insets(10));
	
		HBox hbBottom = new HBox(10);
		hbBottom.setPadding(new Insets(10));
		hbBottom.setAlignment(Pos.CENTER); // 가운데 맞추는 거
		
		// 버튼 생성 하는 객체 만들기 
		Button btnInfo = new Button("Info");
		Button btnError = new Button("Error");
		Button btnWarn = new Button("Warn");
		Button btnConfirm = new Button("Confirm");
		Button btnProm = new Button("Prom");
		
		
		// "Info"버튼을 누르면  Alert 창 띄우는거 람다식으로 표현하는 방법
		btnInfo.setOnAction(e->{
			//Information 창 띄우는거 만드는거 
			Alert info = new Alert(AlertType.INFORMATION); //AlertType.INFORMATION 이미지를 나타내는거 
			// 창이 나타 났을 때 각각의 텍스트 나오는 거 
			info.setTitle("INFORMATION");   
			info.setHeaderText("INFORMATION 보기");
			info.setContentText("INFORMATION Alert창  입니다.");
			
			
			info.showAndWait(); // 창을 보여주고 제어를 창이 닫힐때까지 멈춘다.
			
			System.out.println("안녕");
		});
		
		
		btnError.setOnAction(e->{
			//Error 창 띄우는거
			Alert err = new Alert(AlertType.ERROR);
			err.setTitle("INFORMATION");
			err.setHeaderText("INFORMATION 보기");
			err.setContentText("INFORMATION Alert창  입니다.");
			
			err.showAndWait();
		});
		
		btnWarn.setOnAction(e->{
			
			//Warn 창 띄우는거
			Alert warn = new Alert(AlertType.WARNING);
			warn.setTitle("INFORMATION");
			warn.setHeaderText("INFORMATION 보기");
			warn.setContentText("INFORMATION Alert창  입니다.");
			
			warn.showAndWait();
		});
		
		btnConfirm.setOnAction(e->{
			// CONFIRMATION 창  버튼 이 두개가 생성된다.  둘 중 하나를 선택할 때  사용 하는 방법 
			Alert Conf = new Alert(AlertType.CONFIRMATION);
			Conf.setTitle("CONFIRMATION");
			Conf.setHeaderText("CONFIRMATION 보기");
			Conf.setContentText("CONFIRMATION Alert창  입니다.");
			
			// Confirmation창을 보여주고 사용자가 누른 버튼  값 읽어오기		
			ButtonType confResult = Conf.showAndWait().get();
			
			// OK버튼  또는 취소버튼 중 클릭한 버튼  구분하기
			if(confResult == ButtonType.OK) {
				System.out.println("OK버튼을 눌렀습니다.");
			}else if(confResult == ButtonType.CANCEL) {
				System.out.println("취소버튼을 눌렀습니다.");
			}
			
		});
		
		
		btnProm.setOnAction(e->{
			// 자바스크립트의 prompt창과 같은 기능  창에 입력 받는거 
			
			TextInputDialog prompt = new TextInputDialog("기본값"); // 기본값은 생략 가능  TextInputDialog 타입 자체가 ? 이미지 생성해준다.
			
			
			prompt.setTitle("prompt");
			prompt.setHeaderText("prompt 자료 입력");
			prompt.setContentText("입력 :");
			
			// 창을 보여주고, 창에서 입력한 값 가져오기
			Optional<String> result = prompt.showAndWait();
			
			// 입력한 값 출력하기 
			String strData = null;	// 입력한 값이 저장될 변수 
			if(result.isPresent()) { // 값이 있으면 ....
				strData = result.get(); // 실제 입력한 값 가져오기
			}
			
			System.out.println("입력 값 : "+strData);
			
			
			
		});
		
		
		
		
		hbTop.getChildren().addAll(btnInfo, btnError, btnWarn);
		hbBottom.getChildren().addAll(btnConfirm, btnProm);
		
		root.getChildren().addAll(hbTop, hbBottom);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Alert 연습");
		primaryStage.show();
		
		
	}
	

	public static void main(String[] args) {
		launch(args);
	}
}
