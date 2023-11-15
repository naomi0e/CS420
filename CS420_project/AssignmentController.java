package application;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Labeled;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;



public class AssignmentController implements Initializable{
		
	ObservableList<String> list = FXCollections.observableArrayList();
	
	@FXML private TreeView<String> treeView;
	TreeItem<String> item;
	@FXML private ListView<String> listView;
	private String selectedOption;
	@FXML private Labeled label;
//	private String option1;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		treeViewManage();
		loadItems();
		
	}
	//TreeView
	private void treeViewManage() {
		TreeItem<String> root= new TreeItem<>("Root");
		TreeItem<String> node1 = new TreeItem<>("Command Center");
		root.getChildren().addAll(node1);
		treeView.setRoot(root);
	}
	@FXML
	private void selectedItem() {
		item = (TreeItem<String>) treeView.getSelectionModel().getSelectedItem();
//		System.out.println(item.getValue());
	}

	//items for ListVeiw
	private void loadItems() {
//		String[] item = {"Item Root Commands", "Add Item Container"};
//		listView.getItems().add("Item Root Commands");
//		listView.getItems().add("Add Item Container");
		list.removeAll(list);
		String option1 = "Item Root Commands";
		String option2 = "Add Item Container";
		list.addAll(option1,option2);
		listView.getItems().addAll(list);
//		listView.setItems(list);
	}
	private void loadItems2() {
		list.removeAll(list);
		String option1 = "Item Container Commands";
		String option2 = "Rename";
		String option3 = "Change Location X";
		String option4 = "Change Location Y";
		String option5 = "Change Price";
		String option6 = "Change Width";
		String option7 = "Change Height";
		String option8 = "Add Item";
		String option9 = "Add Item Contianer";
		String option10 = "Delete";
		list.addAll(option1,option2,option3,option4,option5,option6,option7,option8,option9,option10);
		listView.getItems().addAll(list);
	}
	@FXML
	private void displaySelected() {
		listView.setOnMouseClicked(event ->{
				
				selectedOption = listView.getSelectionModel().getSelectedItem();
				if(selectedOption != null) {
					if(selectedOption.equals("Add Item Container")) {
						try {
							confirmation();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				});				
	}
	
	private void confirmation() throws IOException {
		

		Stage popStage = new Stage();
		try {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Confirmation.fxml"));
		Parent root =  fxmlLoader.load();
		popStage.setScene(new Scene(root));
		PopupContentController popupContentController = fxmlLoader.getController();
		
		popStage.initModality(Modality.APPLICATION_MODAL);
		popStage.setTitle("Confirmation");
		popStage.show();
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
	
}
