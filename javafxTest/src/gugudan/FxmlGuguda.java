package gugudan;

import java.awt.TextArea;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FxmlGuguda extends Application {
	
	
	TextField submit = new TextField(); // 구구단 단수 입력 메서드
	TextArea content = new TextArea();	// 구구단 계산 해서 나오는 전체 창
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		VBox root = new VBox (10);
		root.setPadding(new Insets(10));   // vbox에 padding을 10으로 줌
		
		HBox hbox = new HBox (10);
		hbox.setPadding(new Insets(10));	// hbox에 padding을 10으로 줌
	
		
		Button btn = new Button("출력"); // btn에 버튼 기능을 넣어줌
		
		
		btn.setOnAction( // btn을  누르면 
				
				event->{
					content.setText("");
				}
				);
		
	}

	public static void main(String[] args) {
		launch(args);  //FxmlGuguda 객체 생성 및 윈도우 생성
	}
}
