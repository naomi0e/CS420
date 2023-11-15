package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class PopupContentController implements Initializable{

    @FXML private Button cancel;

    @FXML private Button ok;

    @FXML private Text popupLabel;

    @FXML private TextField textField;
    
    private StringProperty nameProperty = new SimpleStringProperty("");
    
    public StringProperty namProperty() {
    	return nameProperty;
    }

    @FXML
    void selectedCancel(ActionEvent event) {

    }

    @FXML
    void selectedOk(ActionEvent event) {
    	String name = textField.getText();
    	popupLabel.setText("Enter Container X");
    	int x = Integer.parseInt(textField.getText());
    	popupLabel.setText("Enter Container Y");
    	int y = Integer.parseInt(textField.getText());
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		popupLabel.setText("Enter Container Name");
	}
	 

}


//public class PopupContentController {
//	
//	@FXML private Label popupLabel;
//	@FXML private TextField textField;
//	
//	private TreeView<String> treeView;
//	
////	public void setTreeView(TreeView<String> treeView) {
////		this.treeView = treeView;
////	}
////	
//	public void name() {
//		
//	}
//}
