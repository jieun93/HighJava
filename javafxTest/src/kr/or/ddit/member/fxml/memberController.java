package kr.or.ddit.member.fxml;
import java.lang.reflect.Member;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import basic.util.AlertUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

public class memberController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField memid;

    @FXML
    private TextField memName;

    @FXML
    private TextField memTel;

    @FXML
    private TextField memAddr;

    @FXML
    private Button add;

    @FXML
    private Button mod;

    @FXML
    private Button del;

    @FXML
    private Button input;

    @FXML
    private Button cancel;
    
    @FXML
    private TableView<MemberVO> tableView;

    @FXML
    private TableColumn<MemberVO, String> vmemid;

    @FXML
    private TableColumn<MemberVO, String> vmemName;

    @FXML
    private TableColumn<MemberVO, String> vmemTel;

    @FXML
    private TableColumn<MemberVO, String> vmemAddr;
    
    
    // 추가,수정 버튼 눌렀을 때  확인, 취소 확인하는거
    private String strWork = "";
    

    //추가버튼
    @FXML
    void add(ActionEvent event) {
    	
    	// 입력 상자들을 편집가능상태로 만들기	
    	// 추가버튼을 누르면  입력창이 활성화 되는거 
    	memid.setEditable(true);
    	memName.setEditable(true);
    	memTel.setEditable(true);
    	memAddr.setEditable(true);
    	
    	// 추가,삭제,수정 버튼이 비활성화 되는거
    	add.setDisable(true);
    	mod.setDisable(true);
    	del.setDisable(true);
    	
    	// 확인 , 취소버튼 활성화
    	input.setDisable(false);
    	cancel.setDisable(false);
    	
    	//입력상자의 내용 모두 삭제
    	memid.clear();
    	memName.clear();
    	memTel.clear();
    	memAddr.clear();
    	
    	//TableView 비활성화
    	tableView.setDisable(true);
    	
    	memid.requestFocus(); // 포커스주기
    	
    	strWork="추가";
    
    }
    
    
    //취소 버튼
    @FXML
    void cancel(ActionEvent event) {
    	
    	AlertUtil.infoMsg("작업취소", "작업이 취소되었습니다");
    	workCancel();
    	    	
    }
    
    
    
    //삭제버튼
    @FXML
    void del(ActionEvent event) {
    	if(tableView.getSelectionModel().isEmpty()) {
    		AlertUtil.errorMsg("작업오류", "삭제할 데이터를 선택한 후 작업하세요");
    		return;
    	}
    	// 현재 선택한 데이터 구하기
    	MemberVO mem = tableView.getSelectionModel().getSelectedItem();
    	String memid = mem.getMem_id();
    	
    	if(AlertUtil.confirm("삭제여부확인", memid+"정보를 정말로 삭제하시겠습니까?")){
    		int cnt = service.deleteMember(memid);
    		
    		if(cnt>0){
    			AlertUtil.infoMsg("작업성공", memid+"회원정보를 삭제 했습니다.");
    			setMemberData(); // 삭제 후의 회원정보들을 다시 가져온다.
    		}else {
    			AlertUtil.infoMsg("작업실패", "삭제 작업 실패");
    		}
    	}
    }
    
    
    
    
    // 확인 버튼
    @FXML
    void input(ActionEvent event) {
    	String memiid = memid.getText();
    	String memNName = memName.getText();
    	String memTTel = memTel.getText();
    	String memaaddr = memAddr.getText();
    	
    	if(memiid.isEmpty()) {
    		AlertUtil.errorMsg("입력오류", "회원 ID를 입력하세요.");
    		//memid.requestFocus();
    		return;
    	}
    	if(memNName.isEmpty()) {
    		AlertUtil.errorMsg("입력오류", "회원 이름을 입력하세요.");
    		return;
    	}
    	if(memTTel.isEmpty()) {
    		AlertUtil.errorMsg("입력오류", "전화번호를 입력하세요.");
    		return;
    	}
    	if(memaaddr.isEmpty()) {
    		AlertUtil.errorMsg("입력오류", "주소를 입력하세요");
    		return;
    	}
    	
    	// vo객체에 자료 저장
    	MemberVO mem = new MemberVO();
    	mem.setMem_id(memiid);
    	mem.setMem_name(memNName);
    	mem.setMem_tel(memTTel);
    	mem.setMem_addr(memaaddr);
    	
    	
    	if("추가".equals(strWork)) { //추가 작업 상태인지 검사
    		int count = service.getMemberCount(memiid);
    		if(count>0) {
    			AlertUtil.warnMsg("ID중복오류", memiid+"는 이미 있는 회원입니다.");
    			//vmemid.clear();
    			return;
    		}
   
    		int cnt = service.insertMember(mem);
    		
    		if(cnt>0) {
    			AlertUtil.infoMsg("작업성공", memiid+"회원을 추가했습니다.");
    		}else {
    			AlertUtil.infoMsg("작업실패", "추가작업실패!!");
    		}
    		
    	}else if("수정".equals(strWork)) { // 수정 작업
    		int cnt = service.updateMember(mem);
    		
    		if(cnt>0) {
    			AlertUtil.infoMsg("작업성공", memiid+"회원정보를 수정했습니다.");
    		} else {
    			AlertUtil.infoMsg("작업실패", "수정 작업 실패");
    		}
    	}
    	
    	setMemberData();
    	workCancel();
    	
    	    
    }
    
    
    //수정버튼
    @FXML
    void mod(ActionEvent event) {
    
    	
    	// 수정버튼을 누르면  입력창이 활성화 되는거 
    	memid.setEditable(true);
    	memName.setEditable(true);
    	memTel.setEditable(true);
    	memAddr.setEditable(true);   	
    	
    	// 수정버튼을 누르면  추가,삭제,수정버튼이 비활성화 되는거
    	add.setDisable(true);
    	mod.setDisable(true);
    	del.setDisable(true);
    	
    	// 확인 취소 버튼 활성화 
    	input.setDisable(false);
    	cancel.setDisable(false);
    	
    	// tableView도 비활성화시키는 거 
    	tableView.setDisable(true);
    	
    	if(tableView.getSelectionModel().isEmpty()) {
    		AlertUtil.errorMsg("작업오류", "수정할데이터를 선택한 후 진행하세요");
    		return;
    	}
    	memName.requestFocus(); //  입력창에 포커스 주기
    	strWork="수정";
    			
    }
    
    
    private void workCancel() {
    	
    	// 버튼  기본값으로  비활성화 시키는거 
    	cancel.setDisable(true);
    	input.setDisable(true);
    	
    	// 입력창 기본값으로 비활성화 시키는거 
    	memid.setEditable(false);
    	memName.setEditable(false);
    	memTel.setEditable(false);
    	memAddr.setEditable(false);
    	
    	// 기본 입력창이 text 띄우는거
    	memid.setPromptText("회원ID");
    	memName.setPromptText("회원이름");
    	memTel.setPromptText("회원번호");
    	memAddr.setPromptText("회원주소");
    	
    	//추가,삭제,수정 버튼 활성화
    	add.setDisable(false);
    	mod.setDisable(false);
    	del.setDisable(false);
    	             
    	
    	// 입력 상자의 내용을 모두 삭제
    	memid.clear();
    	memName.clear();
    	memTel.clear();
    	memAddr.clear();
    	
    	// 데이터를 이전 상태로 만들기
    	 if(!tableView.getSelectionModel().isEmpty()) {
    		 MemberVO mem = tableView.getSelectionModel().getSelectedItem();
    		 
    		 memid.setText(mem.getMem_id());
    		 memName.setText(mem.getMem_name());
    		 memTel.setText(mem.getMem_tel());
    		 memAddr.setText(mem.getMem_addr());
    	 }
    	 strWork ="";
    	 }
    
    
    
    
    
    // TableView를 클릭했을 때 이벤트 처리 
    @FXML
    void tableClick(MouseEvent event) {
    	if(tableView.getSelectionModel().isEmpty()) {
    		return;
    	}
    	
    	// 선택한 곳의 데이터 구하기 
    	MemberVO mem = tableView.getSelectionModel().getSelectedItem();
    	
    	memid.setText(mem.getMem_id());
    	memName.setText(mem.getMem_name());
    	memTel.setText(mem.getMem_tel());
    	memAddr.setText(mem.getMem_addr());
    }
    
    
    //전역 변수로 꼭 넣어줘야 한다. ==>
    private ObservableList<MemberVO> data;  // TableView에 셋팅될 ObservableList 객체 변수 
    private IMemberService service; // Service객체가 저장될 변수 
    
    
    //DB의 전체 데이터를 가져와 TableView에 출력하는 메서드
    private void setMemberData() {
    	/// 서비스를 통해서 가져오는게 데이터 베이스랑 연동되는 부분
    	List<MemberVO> memList = service.getAllMember();
    	data = FXCollections.observableArrayList(memList);
    	tableView.setItems(data);
    	
    	
    	// 입력 상자의 내용을 모두 삭제
    	memid.clear();
    	memName.clear();
    	memTel.clear();
    	memAddr.clear();
    	
    }
    
    //초기화 시키는 부분
    @FXML
    void initialize() {
    	
    	
    	//출력할 테이터  객체의 멤버변수의 컬럼을 연결한다   TableView의 각 컬럼과 vo 객체의 멤버변수를 매핑시킨다.
    	// MemberVO 의  변수를 넣어주는거 
    	vmemid.setCellValueFactory(new PropertyValueFactory<MemberVO, String>("mem_id"));
    	vmemName.setCellValueFactory(new PropertyValueFactory<MemberVO, String>("mem_name"));
    	vmemTel.setCellValueFactory(new PropertyValueFactory<MemberVO, String>("mem_tel"));
    	vmemAddr.setCellValueFactory(new PropertyValueFactory<MemberVO, String>("mem_addr"));
    	
    	
    	
    	//Service 객체 생성
    	service = MemberServiceImpl.getInstance();
    	
    	setMemberData();
		
    	/*
		 * //TableView에서 선택한 데이터 객체 구하기 MemberVO mem =
		 * tableView.getSelectionModel().getSelectedItem();
		 * memid.setText(mem.getMem_id()); memName.setText(mem.getMem_name());
		 * memTel.setText(mem.getMem_tel()); memAddr.setText(mem.getMem_addr());
		 */
    	
    	
    	
    	// 테이블 뷰에 정보 보여지는거  이미 신빌더에서 넣어줌 
    	//tableView.getColumns().addAll(vmemid,vmemName,vmemTel,vmemAddr);
    	
    	
    }
}
