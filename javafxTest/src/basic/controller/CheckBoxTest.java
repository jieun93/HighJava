package basic.controller;



import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class CheckBoxTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		String[] names = new String[] {"Security","Project","Chart"};
		Image[] images = new Image[names.length]; // 이미지파일 이름
		ImageView[] icons = new ImageView[names.length]; // 이미지 아이콘
		CheckBox[] chboxs = new CheckBox[names.length]; //체크박스 
		
		Rectangle rect = new Rectangle(90, 30); // 4각형 만들기
		rect.setArcHeight(10);
		rect.setArcWidth(10); 	// 4각형의 꼭지점을 둥글게 만드는거
		 //rect.setFill(Color.rgb(41, 41, 41)); // 도형의 내부에 색칠하기
		
		
		for(int i = 0; i<names.length; i++) {
			final Image img = images[i] = new Image(
				CheckBoxTest.class.getResourceAsStream("../../images/"+names[i]+".png"));
					
			final ImageView icon = icons[i] = new ImageView();
			
			chboxs[i] = new CheckBox(names[i]);
			
			
			//  방법 2 CheckBox의 상태 값을 감시하고 , 이 값이 변경되었을 때 처리하기
			chboxs[i].selectedProperty().addListener(
					new ChangeListener<Boolean>() {
						@Override
						public void changed(ObservableValue<? extends Boolean> observable, 
								Boolean oldValue,Boolean newValue) {
							// oldValue ==> 상태값이 변경되기 전 값이 저장되는 변수
							// newValue ==> 상태값이 변경된 후의 값이 저장되는 변수
							icon.setImage(newValue ? img : null);
							
						}
			});
			
			
			
			/*
			// 방법 1
			// CheckBox를 클릭했을 때  이벤트 처리하기 
			chboxs[i].setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					
					CheckBox chk = (CheckBox)event.getSource(); //이벤트가 최초로 발생한 객체를 반환한다.
					
					
					//icons[i].setImage(chk.isSelected() ? images[i] : null);
					icon.setImage(chk.isSelected() ? img : null);
				}

			
			});
		
			*/
		
		}
		
	
		Button btn = new Button("확인");
		btn.setOnAction(e->{
			
			//CheckBox의 check여부를 확인하는 방법 ==> isSelected() 메서드 이용
			if(chboxs[0].isSelected() == true) {
				System.out.println("선택됨");
			}else {
				System.out.println("선택 해제");
			}
			
			
			
			//CheckBox의 check상태를 변경하는 방법 ==> setSelected()메서드 이용
			//==> 이 메서드에 true 값을 주면 'check'되고, false값을 주면 'check가 해제' 된다.
			chboxs[1].setSelected(true);
			chboxs[2].setSelected(true);
		});
		
		
		
		
	
		VBox vbox = new VBox();
		vbox.getChildren().addAll(chboxs);
		vbox.getChildren().add(btn);
		
		HBox hbox = new HBox();
		hbox.getChildren().addAll(icons);
		hbox.setPadding(new Insets(0,0,0,5));
		
		StackPane stack = new StackPane();
		stack.getChildren().addAll(rect, hbox);
		StackPane.setAlignment(rect, Pos.TOP_CENTER);
		
		
		HBox root = new HBox(40);
		root.setPadding(new Insets(20, 10, 10, 20));
		root.getChildren().addAll(vbox, stack);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("CheckBox 연습");
		primaryStage.show();
	
		}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
