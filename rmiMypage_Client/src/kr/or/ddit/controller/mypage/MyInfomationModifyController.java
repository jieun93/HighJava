/*
 * package kr.or.ddit.controller.mypage;
 * 
 * import java.net.URL; import java.util.ResourceBundle; import
 * javafx.event.ActionEvent; import javafx.fxml.FXML; import
 * javafx.scene.control.Button; import javafx.scene.control.Label; import
 * javafx.scene.control.TextField; import javafx.scene.input.MouseEvent; import
 * javafx.scene.layout.AnchorPane;
 * 
 * // 내정보 화면 public class MyInfomationModifyController {
 * 
 * 
 * private IMymemberService service; private ObservableList<MemberVO>
 * memberList; private MemberVO memVO; private String confirmNumber = "";
 * private String result; private InterestVO interVO; private InterestArticleVO
 * intArtiVO; private Article_ResultVO aresutVO; private ImemberInfoService
 * service; private ObservableList<MemberInfoVO> data; private String
 * confirmNumber = ""; private MemberInfoVO memInfoVO; private InterestVO
 * interVO; private InterestArticleVO intArtiVO; private Article_ResultVO
 * aresutVO;
 * 
 * private MymemberController mymemberController;
 * 
 * public MymemberController getMymemberController() { return
 * mymemberController; }
 * 
 * public void setMyInfoController(MymemberController mymemberInfoCont) {
 * this.mymemberController = mymemberInfoCont; }
 * 
 * @FXML private ResourceBundle resources;
 * 
 * @FXML private URL location;
 * 
 * @FXML private AnchorPane memberView;
 * 
 * @FXML private TextField tfId;
 * 
 * @FXML private TextField tfPass;
 * 
 * @FXML private TextField tfRePass;
 * 
 * @FXML private TextField tfName;
 * 
 * @FXML private TextField tfReg;
 * 
 * @FXML private TextField tfAdd;
 * 
 * @FXML private TextField tfTel;
 * 
 * @FXML private TextField tfEmail;
 * 
 * @FXML private TextField tfInputNum;
 * 
 * @FXML private TextField tfAdd2;
 * 
 * @FXML private Button btnnumCom;
 * 
 * @FXML private Button btnAddSerach;
 * 
 * @FXML private Button btnemailCon;
 * 
 * @FXML private Button btnModify;
 * 
 * @FXML private Button btnOut;
 * 
 * @FXML private Label passLabel;
 * 
 * @FXML private Label idLabel;
 * 
 * @FXML private Label nameLabel;
 * 
 * @FXML private Label telLabel;
 * 
 * @FXML private Label regLabel;
 * 
 * 
 * // 주소 검색 버튼
 * 
 * @FXML void btnAddSearch(MouseEvent event) { try {
 * 
 * FXMLLoader fxmlLoader = new
 * FXMLLoader(getClass().getResource("../../fxml/adminmypage/AddSearch.fxml"));
 * Parent root = (Parent)fxmlLoader.load(); Stage primaryStage = (Stage)
 * btnAddSerach.getScene().getWindow();
 * 
 * Stage primaryStage2 = new Stage(StageStyle.DECORATED);
 * primaryStage2.initModality(Modality.WINDOW_MODAL);
 * primaryStage2.initOwner(primaryStage);
 * 
 * AddSearch controller = fxmlLoader.getController();
 * controller.setDialog(this);
 * 
 * Scene scene = new Scene(root); primaryStage2.setScene(scene);
 * primaryStage2.setTitle("주소 검색"); primaryStage2.show();
 * 
 * } catch (Exception e) { e.printStackTrace(); } }
 * 
 * 
 * public void inputAddr(String zipcode, String addr) { // 3번째 창한테 받은 정보
 * tfAdd.setText(zipcode); tfAdd2.setText(addr); }
 * 
 * 
 * 
 * // 이메일 전송 버튼
 * 
 * @FXML void btnEmailCon(MouseEvent event) { mail(); } private void mail() {
 * try {
 * 
 * String host = "smtp.naver.com"; String user = "xovud925@naver.com"; // 계정
 * String password = "wldms*36810"; // 패스워드
 * 
 * // SMTP 서버 정보를 설정 Properties props =new Properties();
 * props.put("mail.smtp.host", host); props.put("mail.smtp.port", 587);
 * props.put("mail.smtp.auth", "true");
 * 
 * Session session = Session.getDefaultInstance(props, new
 * javax.mail.Authenticator() { protected PasswordAuthentication
 * getPasswordAuthentication() { return new PasswordAuthentication(user,
 * password); } });
 * 
 * try { MimeMessage message = new MimeMessage(session); message.setFrom(new
 * InternetAddress(user));
 * message.addRecipient(javax.mail.Message.RecipientType.TO, new
 * InternetAddress(tfEmail.getText()));
 * 
 * // 메일 제목 message.setSubject("안녕하세요. 경매관리시스템 AIMS 입니다.");
 * 
 * // 메일 내용
 * 
 * for( int i = 0; i < 6; i++) { int a =(int)(Math.random()*10);
 * confirmNumber+=a+""; }
 * 
 * message.setText("인증번호는" + ""+confirmNumber+""+"입니다.");
 * 
 * 
 * 
 * 
 * // 메일 보내기 Transport.send(message); System.out.println(message);
 * System.out.println("메일 전송 완료!");
 * 
 * 
 * } catch (MessagingException e) { e.printStackTrace();
 * System.out.println("전송실패"); } } catch (Exception e) { e.printStackTrace(); }
 * 
 * // 메일 인증번호
 * 
 * @FXML void btnNumCon(MouseEvent event) {
 * if(tfInputNum.getText().equals(confirmNumber)) { //일치했을때 Stage currStage =
 * (Stage) btnnumCom.getScene().getWindow();
 * AlertUtil.showAlert((Stage)btnnumCom.getScene().getWindow(),"입력하신 인증번호가 "
 * ,"확인되었습니다.","확인","취소"); }else { //일치하지 않을때 Stage currStage = (Stage)
 * btnnumCom.getScene().getWindow();
 * AlertUtil.showAlert((Stage)btnnumCom.getScene().getWindow(),"입력하신 인증번호가 "
 * ,"틀렸습니다.","확인","취소"); } } // 정보 수정 버튼
 * 
 * @FXML void btnModify(ActionEvent event) {
 * 
 * if(tfId.getText().isEmpty() || tfPass.getText().isEmpty() ||
 * tfPass.getText().isEmpty() || tfRePass.getText().isEmpty()
 * ||tfEmail.getText().isEmpty() || tfName.getText().isEmpty() ||
 * tfReg.getText().isEmpty() || tfTel.getText().isEmpty() ||
 * tfAdd.getText().isEmpty() || tfAdd2.getText().isEmpty() ||
 * tfInputNum.getText().isEmpty()) {
 * 
 * Stage currentStage = (Stage) btnModify.getScene().getWindow();
 * if(AlertUtil.showAlert((Stage) btnModify.getScene().getWindow(),
 * "빈칸을 입력해주세요")); }else {
 * 
 * }
 * 
 * Stage currentStage = (Stage) btnModify.getScene().getWindow();
 * if(AlertUtil.showAlert((Stage) btnModify.getScene().getWindow(),
 * "회원정보를 수정하시겠습니까?")) {
 * 
 * // 수정한 데이터 저장하는거 memInfoVO = new MemberInfoVO();
 * memInfoVO.setMem_id(tfId.getText()); memInfoVO.setMem_pass(tfPass.getText());
 * memInfoVO.setMem_email(tfEmail.getText());
 * memInfoVO.setMem_name(tfName.getText());
 * memInfoVO.setMem_regno(tfReg.getText());
 * memInfoVO.setMem_tel(tfTel.getText()); memInfoVO.setMem_zip(tfAdd.getText());
 * memInfoVO.setMem_addr(tfAdd2.getText());
 * 
 * 
 * 
 * 
 * try { int cnt = service.updateMember(memInfoVO); } catch (RemoteException e)
 * { // TODO: handle exception e.printStackTrace(); }
 * 
 * 
 * 
 * 
 * }
 * 
 * try { FXMLLoader loader = new
 * FXMLLoader(MemberInfoController.class.getResource(
 * "../../fxml/adminmypage/memberInfo.fxml")); Parent root = loader.load();
 * MemberInfoController memif = loader.getController();
 * memif.setMainController(this); Scene scene = new Scene(root);
 * currentStage.setScene(scene); currentStage.show();
 * 
 * 
 * 
 * } catch (Exception e) { // TODO: handle exception }
 * 
 * 
 * 
 * 
 * 
 * 
 * }
 * 
 * try {
 * 
 * // 수정 버튼 눌렀을 때 처음 화면으로 이동 FXMLLoader loader = new
 * FXMLLoader(MySchedualController.class.getResource(
 * "../../fxml/mypage/MySchedual.fxml")); Parent root = loader.load();
 * 
 * for (int i = 1; i < memInfoView.getChildren().size(); i++) {
 * memInfoView.getChildren().remove(i); }
 * memInfoView.getChildren().addAll(root);
 * 
 * // memberList =
 * FXCollections.observableArrayList(service.getMyInfoList("jieun"));
 * 
 * // MyInformationController memif = loader.getController(); //
 * memif.setMyInfoController(this); // Scene scene = new Scene(root); //
 * currentStage.setScene(scene); // currentStage.show();
 * 
 * 
 * // memInfoView.setItems(memberList);
 * 
 * } catch (Exception e) {
 * 
 * }
 * 
 * }
 * 
 * // 회원 탈퇴
 * 
 * @FXML void btnOut(ActionEvent event) { Parent root =
 * FXMLLoader.load(MymemberController.class.getResource(
 * "../../fxml/mypage/Mymemtaltoe.fxml"));
 * 
 * for (int i = 0; i < memInfoView.getChildren().size(); i++) {
 * memInfoView.getChildren().remove(i); }
 * 
 * memInfoView.getChildren().addAll(root); }
 * 
 * // 화면 전환해서 보여지는거 public void show(MemberInfoVO mifVO) {
 * 
 * this.mifVO = mifVO; tfId.setText(mifVO.getMem_id());
 * tfPass.setText(mifVO.getMem_pass());
 * //textPassRe.setText(mifVO.getMem_pass());
 * tfName.setText(mifVO.getMem_name()); tfReg.setText(mifVO.getMem_regno());
 * tfTel.setText(mifVO.getMem_tel()); tfEmail.setText(mifVO.getMem_email());
 * blacklistLabel.setText(mifVO.getMem_blacklist());
 * tfAdd.setText(mifVO.getMem_zip()); tfAdd2.setText(mifVO.getMem_addr()); //
 * 아이디 값은 비활성화 tfId.setEditable(false);
 * 
 * 
 * 
 * }
 * 
 * 
 * @FXML void initialize() { // service 생성 try { Registry reg =
 * LocateRegistry.getRegistry(8888);
 * 
 * service = (ImemberInfoService) reg.lookup("ImemberInfoService"); } catch
 * (RemoteException e) { e.printStackTrace(); }catch (NotBoundException e) {
 * e.printStackTrace(); }
 * 
 * 
 * // // 입력 받는 값 저장하는거 // memInfoVO = new MemberInfoVO(); // //
 * memInfoVO.setMem_id(tfId.getText()); //
 * memInfoVO.setMem_name(tfName.getText()); //
 * memInfoVO.setMem_pass(tfPass.getText()); //
 * memInfoVO.setMem_regno(tfReg.getText()); //
 * memInfoVO.setMem_tel(tfTel.getText()); //
 * memInfoVO.setMem_email(tfEmail.getText()); //
 * memInfoVO.setMem_zip(tfAdd.getText()); //
 * memInfoVO.setMem_addr(tfAdd2.getText()); //
 * 
 * //
 * 정규식--------------------------------------------------------------------------
 * -------------------------------
 * 
 * // 패스워드 tfPass.textProperty().addListener((Observable, oldValue, newValue) ->
 * { if(!newValue.matches("[A-Za-z0-9_-]{5,15}")) {
 * if(!newValue.matches("\\d*")) {
 * tfPass.setText(newValue.replaceAll("[A-Za-z0-9_-]{5,15}", ""));
 * passLabel.setText("5-15자의 영문자, 숫자만 가능"); } } else
 * if(newValue.matches("[A-Za-z0-9_-]{5,15}")) { passLabel.setText(" "); } });
 * 
 * // 패스워드 일치 tfRePass.textProperty().addListener((Observable, oldValue,
 * newValue) -> { if(!tfPass.getText().equals(tfRePass.getText())) {
 * passLabel.setText("비밀번호가 일치하지 않습니다."); }else if
 * (newValue.equals(tfRePass.getText())) { passLabel.setText("");
 * 
 * } });
 * 
 * // 이름 tfName.textProperty().addListener((Observable, oldValue, newValue) -> {
 * if(!newValue.matches("^[A-Za-z가-힣]*$")) { if(!newValue.matches("\\d*")) {
 * tfName.setText(newValue.replaceAll("^[A-Za-z가-힣]*$", ""));
 * nameLabel.setText("정확한 이름을 입력해 주세요."); } }else
 * if(newValue.matches("^[A-Za-z가-힣]*$")) { nameLabel.setText(" "); } });
 * 
 * // 주민등록번호 tfReg.textProperty().addListener((Observable, oldValue, newValue)
 * -> { if(!newValue.matches("[0-9]{6}\\-[0-9]{7}$")) {
 * if(!newValue.matches("\\d*")) {
 * tfReg.setText(newValue.replaceAll("[0-9]{6}\\-[0-9]{7}$", ""));
 * regLabel.setText("주민번호 13자리를 입력해주세요. ex) 123456-1234567"); } }else
 * if(newValue.matches("[0-9]{6}\\-[0-9]{7}$")) { regLabel.setText(" "); } });
 * 
 * 
 * // 전화번호 tfTel.textProperty().addListener((Observable, oldValue, newValue) ->
 * { if(!newValue.matches("[0-9]{11}")) { if(!newValue.matches("\\d*")) {
 * tfTel.setText(newValue.replaceAll("[0-9]{11}", ""));
 * telLabel.setText("숫자만 입력해주세요."); } }else if(newValue.matches("[0-9]{11}")) {
 * telLabel.setText(" "); } });
 * 
 * 
 * 
 * 
 * } }
 */





package kr.or.ddit.controller.mypage;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class MyInfomationModifyController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane memberView;

    @FXML
    private TextField tfId;

    @FXML
    private TextField tfPass;

    @FXML
    private TextField tfRePass;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfReg;

    @FXML
    private TextField tfAdd;

    @FXML
    private TextField tfTel;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfInputNum;

    @FXML
    private Button btnnumCom;

    @FXML
    private Button btnAddSerach;

    @FXML
    private TextField tfAdd2;

    @FXML
    private Button btnemailCon;

    @FXML
    private Label passLabel;

    @FXML
    private Label idLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Label telLabel;

    @FXML
    private Label regLabel;

    @FXML
    private Button btnModify;

    @FXML
    private Button btnOut;

    @FXML
    void btnAddSearch(MouseEvent event) {

    }

    @FXML
    void btnEmailCon(MouseEvent event) {

    }

    @FXML
    void btnModify(ActionEvent event) {

    }

    @FXML
    void btnNumCon(MouseEvent event) {

    }

    @FXML
    void btnOut(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert memberView != null : "fx:id=\"memberView\" was not injected: check your FXML file 'MyInformaionMo.fxml'.";
        assert tfId != null : "fx:id=\"tfId\" was not injected: check your FXML file 'MyInformaionMo.fxml'.";
        assert tfPass != null : "fx:id=\"tfPass\" was not injected: check your FXML file 'MyInformaionMo.fxml'.";
        assert tfRePass != null : "fx:id=\"tfRePass\" was not injected: check your FXML file 'MyInformaionMo.fxml'.";
        assert tfName != null : "fx:id=\"tfName\" was not injected: check your FXML file 'MyInformaionMo.fxml'.";
        assert tfReg != null : "fx:id=\"tfReg\" was not injected: check your FXML file 'MyInformaionMo.fxml'.";
        assert tfAdd != null : "fx:id=\"tfAdd\" was not injected: check your FXML file 'MyInformaionMo.fxml'.";
        assert tfTel != null : "fx:id=\"tfTel\" was not injected: check your FXML file 'MyInformaionMo.fxml'.";
        assert tfEmail != null : "fx:id=\"tfEmail\" was not injected: check your FXML file 'MyInformaionMo.fxml'.";
        assert tfInputNum != null : "fx:id=\"tfInputNum\" was not injected: check your FXML file 'MyInformaionMo.fxml'.";
        assert btnnumCom != null : "fx:id=\"btnnumCom\" was not injected: check your FXML file 'MyInformaionMo.fxml'.";
        assert btnAddSerach != null : "fx:id=\"btnAddSerach\" was not injected: check your FXML file 'MyInformaionMo.fxml'.";
        assert tfAdd2 != null : "fx:id=\"tfAdd2\" was not injected: check your FXML file 'MyInformaionMo.fxml'.";
        assert btnemailCon != null : "fx:id=\"btnemailCon\" was not injected: check your FXML file 'MyInformaionMo.fxml'.";
        assert passLabel != null : "fx:id=\"passLabel\" was not injected: check your FXML file 'MyInformaionMo.fxml'.";
        assert idLabel != null : "fx:id=\"idLabel\" was not injected: check your FXML file 'MyInformaionMo.fxml'.";
        assert nameLabel != null : "fx:id=\"nameLabel\" was not injected: check your FXML file 'MyInformaionMo.fxml'.";
        assert telLabel != null : "fx:id=\"telLabel\" was not injected: check your FXML file 'MyInformaionMo.fxml'.";
        assert regLabel != null : "fx:id=\"regLabel\" was not injected: check your FXML file 'MyInformaionMo.fxml'.";
        assert btnModify != null : "fx:id=\"btnModify\" was not injected: check your FXML file 'MyInformaionMo.fxml'.";
        assert btnOut != null : "fx:id=\"btnOut\" was not injected: check your FXML file 'MyInformaionMo.fxml'.";

    }
}
