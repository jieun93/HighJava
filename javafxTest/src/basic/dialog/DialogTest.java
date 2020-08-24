package basic.dialog;

import java.io.File;



import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DialogTest extends Application {
	//	DialogTest 파일을 새로 여는거
	
	@Override
	public void start(Stage primaryStage) {
		FlowPane root = new FlowPane();
		root.setPrefSize(400, 300);
		root.setPadding(new Insets(10));
		root.setVgap(10);
		root.setHgap(10);
		
		Button btnOpen = new Button("Open FileChooser연습");
		btnOpen.setOnAction(e->{
			FileChooser fileChooser = new FileChooser();
			
			// 화면에 보여줄 파일 종류를 결정하기
			fileChooser.getExtensionFilters().addAll(
					new ExtensionFilter("Text File", "*.txt"),
					new ExtensionFilter("Image File", "*.png","*.jpg","*.gif"),
					new ExtensionFilter("All Files", "*.*")
			);
			
			// 창이 열렸을 때 보여줄 폴더(디렉토리) 설정 
			File showDir = new File("d:/D_Other/");
			fileChooser.setInitialDirectory(showDir);
			

			// '열기 창' 을 보여주고  사용자가 선택한 파일 정보를 반환한다.
			File selectedFile = fileChooser.showOpenDialog(primaryStage);
			if(selectedFile!=null) {
				// 이 부분에서 실제 선택할 파일의 내용을 읽어오는 작업을 기술한다.
				System.out.println("선택한 정보:"+selectedFile.getPath());
			}
			
		});
		
		Button btnSave = new Button("Save FileChooser연습");
		btnSave.setOnAction(e->{
			FileChooser fileChooser = new FileChooser();
			
			// 화면에 보여줄 파일 종류를 결정하기
			fileChooser.getExtensionFilters().addAll(
					new ExtensionFilter("Text File", "*.txt"),
					new ExtensionFilter("Image", "*.png","*.jpg","*.gif")
					);
			
			// 파일을 선택하는거 까지만 도와주는 역할 주소는 사용자가 직접 줘야 한다. 
			File selectedFile = fileChooser.showSaveDialog(primaryStage);
			if(selectedFile!=null) {
				// 이 부분에서 실제 선택할 파일의 내용을 읽어오는 작업을 기술한다.
				System.out.println("선택한 정보:"+selectedFile.getPath());
			}
		});
		
		
		
		Button btnDir = new Button("DirectoryChooser연습");
		btnDir.setOnAction(e->{
			DirectoryChooser dirChooser = new DirectoryChooser();
			File selectedDir = dirChooser.showDialog(primaryStage);
			if(selectedDir!=null) {
				System.out.println("선택한 정보 : "+selectedDir.getPath());
			}
			
		});
		
		
		
		Button btnPop = new Button("Popup연습");
		btnPop.setOnAction(e->{
			// 알림창과 같이 간단한 내용을 보여줄 때 사용한다. 
			Popup popup = new Popup();
			
			HBox popRoot = new HBox();
			popRoot.setAlignment(Pos.CENTER_LEFT);
			popRoot.setStyle("-fx-background-color:black; -fx-background-radius:20;");
			
			ImageView imgView = new ImageView();
			imgView.setImage(
					new Image(
							DialogTest.class.getResourceAsStream("../../images/ok.png")));
			imgView.setFitHeight(30);
			imgView.setFitWidth(30);
			imgView.setOnMouseClicked(ee->{
				popup.hide();  // Popup 닫기
			});
			
			Label lblMsg = new Label("메세지가 왔습니다.");
			lblMsg.setTextFill(Color.RED);
			HBox.setMargin(lblMsg, new Insets(0,5,0,5));
			
			
			popRoot.getChildren().addAll(imgView, lblMsg);
			
			popup.getContent().add(popRoot);
			popup.setAutoHide(true); 	//Popup 영역 이외의 부분을 누르면 자동으로 실행한다.
			popup.show(primaryStage);	// 부모창 객체를 매개값으로 준다.
		});
		
		
		
		
		
		
		Button btnCustom = new Button("Custom Dialog 연습");
		btnCustom.setOnAction(e->{
			try {
			// 새 창을 만들떄 Stage 객체 생성 해야 한다. 	
			// 자식창의 Stage객체 생성
			//Stage dailog = new Stage(StageStyle.DECORATED);
			//Stage dailog = new Stage(StageStyle.UNDECORATED);
			Stage dailog = new Stage(StageStyle.TRANSPARENT);  // 배경 투명하게 1
			
			// 모달창 여부 지정   모달창 --> 부모랑 자식창 사이에  자식창을 닫기 전에는 부모창을 사용할 수 없다.
			 dailog.initModality(Modality.WINDOW_MODAL);
			
			// 부모창 지정 
			dailog.initOwner(primaryStage);
			
			Parent childRoot = 
					FXMLLoader.load(DialogTest.class.getResource("custom.fxml"));
			
			childRoot.setStyle("-fx-background-color:transparent;");   // 배경 투명 처리 2
			//------------------------------------------
			// 자식창의 컨트롤에  설정된 id값을 이용해서  해당 컨트롤 객체를 구할 수 있다.
			//  형식) fxml문서를 load한 Parent객체 변수.lookup("#컨트롤의id값");
			Button btnTest = (Button)childRoot.lookup("#btnOK"); 
			btnTest.setOnAction(ee->{
				// 프로그램 전제 종료
				//Platform.exit();
				
				// 자식창 닫기  
				dailog.close();
			});
			
			
			//------------------------------------------
			// 자식창에 추가할 Scene 객체생성
			Scene childScene = new Scene (childRoot);
			
			childScene.setFill(Color.TRANSPARENT); 	// 배경 투명 처리3
			
		
			
			// 자식창 Stage에 Scene 객체 추가
			dailog.setScene(childScene);
			dailog.setTitle("자식창 연습");
			dailog.show();
			
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		});
		
		
		root.getChildren().addAll(btnOpen, btnSave, btnDir, btnPop, btnCustom);
		
		Scene  scene = new Scene (root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Dialog 연습");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
