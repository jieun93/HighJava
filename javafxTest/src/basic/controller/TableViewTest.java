package basic.controller;






import java.util.ArrayList;
import java.util.List;

import basic.util.AlertUtil;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TableViewTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		/*
		// 데이터 정보 넣어두기
		ObservableList<Member> data = FXCollections.observableArrayList(
				new Member("연지은","yje",33,"010-1234-1321","대전"),
				new Member("김태평","ktp",32,"010-8798-1321","대전"),
				new Member("정지오","jjo",34,"010-1234-5464","대전"),
				new Member("리정혁","ljh",36,"010-7987-8795","대전")
				);
		
		*/
		
// 데이터 베이스 부분 
		//initialize 부분에 넣는거
		List<Member> memList = new ArrayList<Member>();
		memList.add(new Member("연지은","yje",27,"010-3945-3681","청주"));
		memList.add(new Member("김태평","ktp",37,"010-4655-3681","청주"));
		memList.add(new Member("정지오","jjo",34,"010-3945-7775","청주"));
		memList.add(new Member("연지훈","yje",27,"010-3945-3681","청주"));
		memList.add(new Member("박서준","yje",27,"010-3945-3681","청주"));
		
		ObservableList<Member> data = FXCollections.observableArrayList(memList);
		
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(10));
		
	// 	TableView객체 생성 및 데이터 셋팅
	//  방법1	
		
	//	TableView<Member> table = new TableView<Member>();
	//	table.setItems(data);
		
	//  방법 2
//TableView 만들기 
		
		TableView<Member> table = new TableView<Member>(data); // data에 넣은 정보 가져오는 거 
		
		
		//----------------------------------------------------
		// TableView에 포함될 TableColumn 객체를 생성하고 출력할 데이터를 매핑한다.
		// ( 출력할 테이터  객체의 멤버변수의 컬럼을 연결한다)
		TableColumn<Member, String> nameCol = new TableColumn<Member, String>("이름"); // 이름 테이블 만들어 주는거
				
		TableColumn<Member, String> korNameCol= new TableColumn<Member, String>("한글");	// 한글 테이블 만들어 주는거
		korNameCol.setCellValueFactory(
				// korName ==> Member 객체 중 이 컬럼에 출력할 '멤버 변수명' 이다.
				new PropertyValueFactory<Member, String>("korName"));
		
		TableColumn<Member, String> engNameCol = new TableColumn<Member, String>("영문"); // 영문 테이블 만들어 주는거
		engNameCol.setCellValueFactory(
				new PropertyValueFactory<Member, String>("engName"));
		
		// '이름' 컬럼에 '한글 ' 컬럼과 '영문'컬럼을 추가한다.
		nameCol.getColumns().addAll(korNameCol, engNameCol);
		
		TableColumn<Member, Integer> ageCol = new TableColumn<Member, Integer>("나이");
		ageCol.setCellValueFactory(
				new PropertyValueFactory<Member, Integer>("age"));
		
		TableColumn<Member, String> telCol = new TableColumn<Member, String>("전화번호");
		telCol.setCellValueFactory(new PropertyValueFactory<Member, String>("tel"));
		
		TableColumn<Member, String> addrCol = new TableColumn<Member, String>("주소");
		addrCol.setCellValueFactory(new PropertyValueFactory<Member, String>("addr"));
		
		
		// 만들어진 각 컬럼객체들을 TableView에 추가한다.
		table.getColumns().addAll(nameCol,ageCol, telCol,addrCol);
		
		
		// GridPane 틀 잡아주는거 
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10));
		grid.setHgap(5);
		grid.setVgap(5);
		
		Text txt1 = new Text("한글이름");
		Text txt2 = new Text("영문이름");
		Text txt3 = new Text("나이");
		Text txt4 = new Text("전화번호");
		Text txt5 = new Text("주소");
		
	
	   TextField tfKorName = new TextField();
	   TextField tfEngName = new TextField();
	   TextField tfAge = new TextField();
	   TextField tfTel = new TextField();
	   TextField tfAddr= new TextField();
	   
	   
	   grid.add(txt1, 1, 1);
	   grid.add(txt2, 2, 1);
	   grid.add(txt3, 3, 1);
	   grid.add(txt4, 4, 1);
	   grid.add(txt5, 5, 1);
	
	   // 박스 만들어 주는거 
	   grid.add(tfKorName, 1, 2);
	   grid.add(tfEngName, 2, 2);
	   grid.add(tfAge, 3, 2);
	   grid.add(tfTel, 4, 2);
	   grid.add(tfAddr, 5, 2);
		
	   
	   VBox vbox = new VBox(5);
	   vbox.setPadding(new Insets(5));
	  
/* !!! Controller 부분  Action에 기능 넣어주는거 */
	   
	   // 아래 칸에 정보를 입력하고 추가 버튼을 눌러서 정보 추가하는거 
	   
	   Button btnAdd = new Button("추가");
	   btnAdd.setOnAction(e->{
		   //
		   String korName = tfKorName.getText();
		   String engName = tfEngName.getText();
		   String age = tfAge.getText();
		   String tel = tfTel.getText();
		   String addr = tfAddr.getText();
		   
		   
		   // 비어 있으면 오류메세지
		   if( korName.isEmpty() || engName.isEmpty() ||age.isEmpty() ||tel.isEmpty() || addr.isEmpty()) {
			   AlertUtil.errorMsg("입력오류","빈 항목이 있습니다.");
			   return;
		   }
		   //
		   Member mem = new Member(korName,engName, Integer.parseInt(age),tel,addr);
		   
		   // TableView의 data에 셋팅한 List에 넣어주기
		   data.add(mem);
		   
		   AlertUtil.infoMsg("작업결과", korName+"씨의 정보를 추가했습니다.");
		   
	   });
	   
	   
	   // 데이터 수정하는거 
	   
	   Button btnEdit = new Button("수정");
	   btnEdit.setOnAction(e->{
		   // 수정할 데이터를 먼저 선택해야지 수정이 가능함
		   if(table.getSelectionModel().isEmpty()) {
			   AlertUtil.errorMsg("작업오류",	"수정할 데이터를 선택한 후 진행하세요.");
			   return;
		   }
		   
		   // 데이터를 getText를 가져와서 
		   String korName = tfKorName.getText();
		   String engName = tfEngName.getText();
		   String age = tfAge.getText();
		   String tel = tfTel.getText();
		   String addr = tfAddr.getText();
		   
		   
		   // 비어 있으면 오류메세지
		   if( korName.isEmpty() || engName.isEmpty() ||age.isEmpty() ||tel.isEmpty() || addr.isEmpty()) {
			   AlertUtil.errorMsg("입력오류","빈 항목이 있습니다.");
			   return;
		   }
		   // 수정된 데이터 
		   Member mem = new Member(korName,engName, Integer.parseInt(age),tel,addr);
		   // 수정하려면 인덱스가 필요함
		   // 테이블 뷰에서 현재 선택된 데이터의 index값 구하기 ==> getSelectedIndex 메서드 이용
		   int index = table.getSelectionModel().getSelectedIndex();
		  
		   data.set(index, mem);
		   
		   AlertUtil.infoMsg("작업결과", korName+"씨의 정보를 수정했습니다.");
		   
	   });
	   
	   
	   
	   Button btnDel = new Button("삭제");
	   btnDel.setDisable(true); // true로  넣으면 기본적으로 삭제버튼의 기능이 비활성화 
	   btnDel.setOnAction(e->{
		   if(table.getSelectionModel().isEmpty()) {
			   AlertUtil.errorMsg("작업오류", "삭제할 데이터를 선택한 후 작업하세요");
			   return;
		   }
		   // 삭제할 인덱스
		   int index = table.getSelectionModel().getSelectedIndex();
		   
		   // 삭제될 Member의 korName 값 구하기
		   String korName = table.getSelectionModel().getSelectedItem().getKorName();
		   
		   data.remove(index);
		   
		   AlertUtil.infoMsg("작업결과", korName+"씨의 정보를 삭제했습니다.");
		   
	   });
	   
	   Button btnTest = new Button("기타");
	   btnTest.setOnAction(e->{
		   //TextField나 TextArea, PasswordField등의 값을 편집할 수 있게 하거나  편집할 수 없게 하기 
		   // ==> setEditable()메서드에 true을 설정하면 편집가능, false를 설정하면 편집 불가
		   // setEditable ==> 편집 불가능 기능 만드는거 
		   //tfKorName.setEditable(false);  // 이름을 입력하고 기타를 넣으면 편집 불가 상태가 된다.
		   
		   
		   // 컨트롤 객체를  활성화 및 비활성화 상태로 만들기
		   // ==> setDisable()메서드에 true를 설정하면 '비활성화', false를 설정하면 '활성화'
		   // ==> 컨트롤 객체가 비활성화되면 설정된 이벤트가 처리되지 않는다. 
		   // 버튼을 비활성화 하는거 
		   btnAdd.setDisable(true); //  기타 버튼을 누르면 추가 버튼이 비활성화 되는거 
		   btnDel.setDisable(false);// 기타 버튼을 누르면  삭제버튼이 활성화되게 만드는거
		   
		   
		  // tfEngName.setPromptText("영어이름입력");
		   
	   });
	   
	   
	   
	   
		// 오른쪽 버튼 만들는거   데이터를 눌렀을 떄 아래에 데이터가 나오는거
		vbox.getChildren().addAll(btnAdd,btnEdit,btnDel,btnTest );
		
		//TableView를 클릭했을 때 이벤트 처리
		// 람다식으로 하는 방법
		table.setOnMouseClicked(e->{
			// 데이터 있는곳을 클릭했는지를 검사하는거
			// 데이터가 없는 곳을 선택하면 
			if(table.getSelectionModel().isEmpty()) {
				AlertUtil.warnMsg("경고", "TableView에서  데이터가 있는 곳을 선택하세요.");
				return;
			}
			
			
			//TableView에서 선택한 데이터 객체 구하기
			Member mem = table.getSelectionModel().getSelectedItem();
			tfKorName.setText(mem.getKorName());
			tfEngName.setText(mem.getEngName());
			tfAge.setText(String.valueOf(mem.getAge()));
			tfTel.setText(mem.getTel());
			tfAddr.setText(mem.getAddr());
			
		});
		
		
		
		root.setCenter(table);
		root.setBottom(grid);
		root.setRight(vbox);
		
		Scene scene  = new Scene(root, 500, 400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("TableView 연습");
		primaryStage.show();
		
		
	}
// ** MAIN 부분 **
	public static void main(String[] args) {
		launch(args);
	}
	
// 변수 선언하기 1  ** VO 부분 **
	public class Member{
		private String korName;
		private String engName;
		private int age;
		private String tel;
		private String addr;
	
	// 기본 생성자 만들어 주기 2
	public Member() {}
	
	// getter setter 만들어 주기 3
	public Member(String korName, String engName, int age, String tel, String addr) {
			super();
			this.korName = korName;
			this.engName = engName;
			this.age = age;
			this.tel = tel;
			this.addr = addr;
		}

		public String getKorName() {
			return korName;
		}

		public void setKorName(String korName) {
			this.korName = korName;
		}

		public String getEngName() {
			return engName;
		}

		public void setEngName(String engName) {
			this.engName = engName;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
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
