package AlertDialog;

import java.io.IOException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertUtil {
	
 private static boolean state;
    
    public static boolean showAlert(Stage baseStage,String msg) {
    	try {
        	FXMLLoader loader = new FXMLLoader(AlertUtil.class.getResource("AlertDialog.fxml"));
    		Parent root = loader.load();
    		Scene scene = new Scene(root);
    		Stage dialog = new Stage();
    		dialog.initModality(Modality.WINDOW_MODAL);
    		dialog.initOwner(baseStage);
    		dialog.setScene(scene);
    		
    		AlertDialogController test = loader.getController();
    		test.alertSet(msg);
    		dialog.showingProperty().addListener(new ChangeListener<Boolean>() {
    
    			@Override
    			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
    				state = test.getState();
    			}
    		});
    		dialog.showAndWait();
        	} catch (IOException e) {
    			
    			e.printStackTrace();
    		}
    	return state;
    }

	public static boolean showAlert(Stage baseStage,String cotent1,String cotent2,String button1,String button2) {
    	try {
        	FXMLLoader loader = new FXMLLoader(AlertUtil.class.getResource("AlertDialog2.fxml"));
    		Parent root = loader.load();
    		Scene scene = new Scene(root);
    		Stage dialog = new Stage();
    		dialog.initModality(Modality.WINDOW_MODAL);
    		dialog.initOwner(baseStage);
    		dialog.setScene(scene);
    		
    		AlertDialog2Controller test = loader.getController();
    		test.alertMessageSet(cotent1,cotent2);
    		test.alertButtonSet(button1,button2);
    		dialog.showingProperty().addListener(new ChangeListener<Boolean>() {
    
    			@Override
    			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
    				state = test.getState();
    			}
    		});
    		dialog.showAndWait();
        	} catch (IOException e) {
    			
    			e.printStackTrace();
    		}
    	return state;
    }
   
   public static void showDonwload(Stage baseStage) {
		try {
			FXMLLoader loader = new FXMLLoader(AlertUtil.class.getResource("DirectoryChooseDialog.fxml"));
			Parent root;
			root = loader.load();
			Scene scene = new Scene(root);
			Stage dialog = new Stage();
			dialog.initModality(Modality.NONE);
			dialog.initOwner(baseStage);
			dialog.setScene(scene);
			dialog.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   }
   public static void sendDataDialog() {
	   HBox box = new HBox();
	   box.setPrefSize(100, 50);
	   
   }
}
