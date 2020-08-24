package AlertDialog;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

public class DownloadDialogController {
	private String filePath;
	private String fileName;
	private String downloadFilePath;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ProgressBar pgSend;

    @FXML
    private Button btnConfirm;

    @FXML
    private Button btnCancle;

    @FXML
    private Label tfFileName;

    @FXML
    void onClickBtnCancle(ActionEvent event) {
    	Stage stage=(Stage)btnConfirm.getScene().getWindow();
    	
    	if(AlertUtil.showAlert(stage, "파일 전송이 진행중입니다 취소하시겠습니까?")) {
    		File file = new File(filePath); // 수정해야함
    		file.delete();
    		stage.close();
    	}
    }

    @FXML
    void onClickedBtnConfirm(ActionEvent event) {
    	Stage stage = (Stage)btnCancle.getScene().getWindow();
    	stage.close();
    }
    
    
    public void setFilePath(String downloadFilePath,String filePath,String fileName) {    	
    	this.downloadFilePath = downloadFilePath;
    	this.filePath = filePath;
    	this.fileName = fileName;
    }
        
    
    public void startFileSend(byte[] data) {
    	File file =  new File("");
    	//파일의 쿠기 구하기
		long fSize = file.length();
		
		//파일 내용을 읽어와 저장할 byte형 배열 선언 : 배열의 크기는 파일크기와 같게 한다.
		
		try {
			byte[] buffer = new byte[1024];
			int length = 0;
			
			FileOutputStream fout = new FileOutputStream(file.getPath());
			BufferedOutputStream bos = new BufferedOutputStream(fout);
			
			bos.write(data);
//			while((length=bos.write(buffer)))
//			data);
			fout.flush();
			fout.close();
		}catch(IOException ee) {
			ee.printStackTrace();
		}
    	
    	
    }

    @FXML
    void initialize() {
    	btnConfirm.setDisable(true);
        
    	
    }
}
