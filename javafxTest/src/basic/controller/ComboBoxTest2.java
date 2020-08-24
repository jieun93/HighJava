package basic.controller;



import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ComboBoxTest2 extends Application {

	@Override
	public void start(Stage primaryStage) {
		VBox vbox = new VBox(10);
		vbox.setPadding(new Insets(10));
		vbox.setAlignment(Pos.TOP_CENTER);
		
		ComboBox<MyFriend> combo = new ComboBox<MyFriend>();
		TextArea taResult = new TextArea();
		
		ObservableList<MyFriend> dataList = FXCollections.observableArrayList(
				new MyFriend("a001", "홍길동","010-1234-2658","대전"),
				new MyFriend("a002", "연지은","010-1231-2456","청주"),
				new MyFriend("a003", "이제경","010-1234-7987","공주"),
				new MyFriend("a004", "전다희","010-1234-5645","부산"),
				new MyFriend("a005", "남아름","010-1234-3685","서울"),
				new MyFriend("a006", "김우경","010-1234-9845","목포"),
				new MyFriend("a007", "김태평","010-1234-8754","경기")
				);
		
		combo.setItems(dataList);
		
		//ComboBox의 목록이 보여지는 곳의 내용을 변경하기
		// 화면에 나타나는 셀의 내용을 변경하는 부분을 말한다.
		combo.setCellFactory(new Callback<ListView<MyFriend>, ListCell<MyFriend>>() {
			
			@Override
			public ListCell<MyFriend> call(ListView<MyFriend> param) {
				return new ListCell<MyFriend>() {
					@Override
					protected void updateItem(MyFriend item, boolean empty) {
						super.updateItem(item, empty);
						if(item==null ||empty) {
							setText(null);
						}else {
							setText(item.getId()+"["+item.getName()+"]");
						}
						
					}
				};
			}
		});
		
		
		// ComboBox에서 항복을  선택하면 선택된 내용이 나타나는 곳을 ButtonCell이라고 하는데
		// 이곳의 데이터도 변경되도록 해야  한다.
		combo.setButtonCell(new ListCell<MyFriend>() {
			@Override
			protected void updateItem(MyFriend item, boolean empty) {
				super.updateItem(item, empty);
				if(item==null || empty) {
					setText(null);
				}else {
					setText(item.getId()+"["+item.getName()+"]");
				}
			}
		});
		
		
		//ComboBox의 데이터를 선택했을 때 이벤트 처리
		// 람다식으로 하는 방법
		combo.setOnAction(e->{
			// ComboBox에서 현재 선택된 값 구하기
			// 방법1
			//MyFriend selData = combo.getSelectionModel().getSelectedItem();
			
			// 방법 2
			MyFriend selData = combo.getValue();
			
			taResult.setText("ID :"+selData.getId()+"\n");
			taResult.appendText("이름:"+selData.getName()+"\n");
			taResult.appendText("전화 :"+selData.getTel()+"\n");
			taResult.appendText("주소:"+ selData.getAddr()+"\n");
			
			
		});
		
		
		vbox.getChildren().addAll(combo, taResult);
		
		Scene scene = new Scene(vbox,400,300);
		primaryStage.setScene(scene);
		primaryStage.setTitle("combo2연습");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	// innerclass로 만드는 방법
	class MyFriend{
		private String id;
		private String name;
		private String tel;
		private String  addr;
		
		// 기본 생성자
		public MyFriend() {
		}
		
		//  생성자
		public MyFriend(String id, String name, String tel, String addr) {
			super();
			this.id = id;
			this.name = name;
			this.tel = tel;
			this.addr = addr;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getTel() {
			return tel;
		}

		public void setTel(String tel) {
			this.tel = tel;
		}

		public String getAddr() {
			return addr;
		}

		public void setAddr(String addr) {
			this.addr = addr;
		}
		
		
		
		
		
		
	}
	
	
	
	
	
	
}






