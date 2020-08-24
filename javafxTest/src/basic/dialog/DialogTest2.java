package basic.dialog;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.WritableDoubleValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class DialogTest2 extends Application {

	@Override
	public void start(Stage primaryStage) {
		
	BorderPane root = new BorderPane();
	
	MenuBar menuBar = new MenuBar();
	
	menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
	root.setTop(menuBar);
	
	// textarea 만들어 주기 
	TextArea textarea = new TextArea();
	
	menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
	root.setCenter(textarea);
	
	// menu객체 생성 
	Menu fileMenu = new Menu("File");
	
	
	// 새로만들기  
	MenuItem newMenuItem = new MenuItem("새로만들기");
	newMenuItem.setOnAction(e->{
		
		textarea.clear();  //textarea창을 지워주는 거 
		primaryStage.setTitle("NoName.txt");
		
	});
	
	
	// 열기
	MenuItem openMenuItem = new MenuItem("열기");
	openMenuItem.setOnAction(e->{
		FileChooser fileChooser = new FileChooser();
		
		fileChooser.getExtensionFilters().addAll(
				new ExtensionFilter("Text File","*.txt"),
				new ExtensionFilter("ALL Files", "*.*")
				);
		// 창이 열렸을 때 보여줄 폴더(디렉토리) 설정
		File showDir = new File("d:/D_Other/");
		fileChooser.setInitialDirectory(showDir);
		
		// '열기' 창을 보여주고 사용자가 선택한 파일 정보를 반환한다. 
		File selectedFile =  fileChooser.showOpenDialog(primaryStage);
		
		String ss = null;
		if(selectedFile !=null) {
			try {
				primaryStage.setTitle(selectedFile.getName());
				FileInputStream fin = new FileInputStream(selectedFile);
				
				int s = 0; // 읽어온 자료를 저장 할 변수 
				
				
				while((s=fin.read()) != -1) {
					 ss += (char)s;
				}
				 textarea.setText(ss);
				
				fin.close(); // 작업 완류 후 스트림 닫기 
				
			} catch (IOException e2) {
				System.out.println("파일이 없거나 읽기 오류입니다.");
			}
			
			
		}
				
	});
	
	// 새이름으로 저장하기 
	MenuItem saveMenuItem = new MenuItem("새이름으로 저장");
	saveMenuItem.setOnAction(e->{
		
		
		
		// 파일 탐색기 같은 기능 
		FileChooser fileChooser = new FileChooser();
		// 어떤 확장자를 선택할지를 결정 
		fileChooser.getExtensionFilters().addAll(
				new ExtensionFilter("Text File", "*.txt"),
				new ExtensionFilter("Image", "*.png","*.jpg","*.gif")
				);
		// 해당된 파일의 경로만 가지고 있는 거 
		File selectedFile = fileChooser.showSaveDialog(primaryStage);
		
		if(selectedFile !=null) {
			try {
				// System.out.println(selectedFile.toString());
				primaryStage.setTitle(selectedFile.getName());
			
		FileOutputStream fout = new FileOutputStream(selectedFile);
		
		fout.write(textarea.getText().getBytes());
		fout.close();
		
		
		
	} catch (IOException e2) {
		// TODO: handle exception
	}
		}
		
	});
	
	
	// exit를 누르면 나가는거 
	MenuItem exitMenuItem = new MenuItem("닫기");	
	exitMenuItem.setOnAction(e->{
		Platform.exit();
	});
	
	
	
	// menuBar에  file 붙이는거 
	menuBar.getMenus().addAll(fileMenu);
	
	//filemenu에 붙이기 
	fileMenu.getItems().addAll(newMenuItem,openMenuItem,saveMenuItem,
			new SeparatorMenuItem(),exitMenuItem);
		
	
	Scene scene = new Scene(root,300,250);
	primaryStage.setScene(scene);
	primaryStage.setTitle("NoName.txt");
	primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
