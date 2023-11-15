package application;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.shape.*;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;



public class MainController implements Initializable{
	
	private static MainController mainController = new MainController();
	
	private MainController() {}
	
	public static MainController getInstance() {
		return mainController;
	}


	
    @FXML
    private ListView<String> listView;
//    @FXML
//    private AnchorPane rootPane;
    @FXML
    private TreeView<String> treeView;
    private TreeItem<String> root;
    private ObservableList<TreeItem<String>> branchItems;
    private TreeItem<String> itemContainer;
    private ObservableList<TreeItem<String>> leafItems;
    private TreeItem<String> item;
    private TreeItem<String> selectedTreeItem;
    
    private ObservableList<String> list = FXCollections.observableArrayList();
    
    private String selectedOption;
    private  Label label;
    private String input;
    
    private ItemContainer newContainer;
    private List<ItemContainer> containersList= new ArrayList<ItemContainer>();

    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		
		
		treeVieInitial();
		listVeiw();
	}
		
    private void treeVieInitial() {
    	root = new TreeItem<String>("root");
    	treeView.setRoot(root);
    	
    	ItemContainer commandCenter = new ItemContainer("Command Center",50,50,100,100);
    	ItemContainer barnContainer = new ItemContainer("Barn",50,50,100,100);
    	containersList.add(commandCenter);
    	containersList.add(barnContainer);
    	
    	branchItems = root.getChildren();
    	itemContainer = new TreeItem<String>(commandCenter.getContainerName());
    	TreeItem<String> itemContainer2 = new TreeItem<String>(barnContainer.getContainerName());
    	branchItems.addAll(itemContainer,itemContainer2);
    	
    	leafItems = itemContainer.getChildren();
    	item = new TreeItem<String>("Drone");
//    	TreeItem<String> item2 = new TreeItem<String>("Cattle");

    	leafItems.addAll(item);
    }
    @FXML
    private void selectedTreeItem() {
    	selectedTreeItem = treeView.getSelectionModel().getSelectedItem();
//    	System.out.println(selectedTreeItem.getValue());
    	loadList(selectedTreeItem);
    }
    
	public void listVeiw() {
		list.clear();
		String option1 = "Item Root Commands";
		String option2 = "Add Item Container";
		list.addAll(option1,option2);
		listView.setItems(list);;
	}
	
	
	public void loadList(TreeItem<String> selectedTreeItem2) {
		if(selectedTreeItem2.equals(root)) {
//			System.out.println("hello");
			listVeiw();
		}if(branchItems.contains(selectedTreeItem2)) {
			list.clear();
			String option1 = "Add Item Container";
			String option2 = "Add Item";
			String option3 = "Delete item-container";
			String option4 = "Change name";
			String option5 = "Change Prive";
			String option6 = "Change Location X";
			String option7 = "Change Location Y";
			String option8 = "Change Length";
			String option9 = "Change Width";
			String option10 = "Change Height";
			list.addAll(option1,option2,option3,option4,option5,option6,option7,option8,option9,option10);
			listView.setItems(list);;
		}
	}
	
	@FXML
	private void selectedListView() throws IOException{
		listView.setOnMouseClicked(EventHandler ->{
			selectedOption = listView.getSelectionModel().getSelectedItem();
			if(selectedOption != null) {
				if(selectedOption.equals("Add Item Container")) {
					newContainer = new ItemContainer();
					showPopup("Enter Container Name");
					showPopup("Enter X Co-oridnate");
					showPopup("Enter Y Co-oridnate");
					showPopup("Enter width");
					showPopup("Enter height");
					containersList.add(newContainer);
				}
//				System.out.println(containersList.toString());
				
				

			}
		});
	}
	
	//references: chatGPT
	private void showPopup(String popupLabel) {
		// Create a new stage for the popup
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.initStyle(StageStyle.UTILITY);
        popupStage.setTitle("Confirmation");

        // Create UI elements for the popup
        label = new Label(popupLabel);
        TextField textField = new TextField();
        Button okButton = new Button("OK");
        Button cancelButton = new Button("Cancel");

        // Define the action for the OK button
        okButton.setOnAction(event -> {
            input = textField.getText();
            popupStage.close();
        });

        // Define the action for the Cancel button
        cancelButton.setOnAction(event -> popupStage.close());

        // Create a layout for the popup
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, textField, okButton, cancelButton);
        layout.setAlignment(Pos.CENTER);

        // Create a scene and set it to the stage
        Scene scene = new Scene(layout, 300, 150);
        popupStage.setScene(scene);

        // Show the popup and wait for it to be closed
        popupStage.showAndWait();

        // Handle the input value (inputValue) here
        if (input != null && !input.isEmpty()) {
            // Handle the input value (containerName) here
            handleInput(input);
//            System.out.println(newContainer.getContainerName());
        }
        
//        return input;
	}

	private void handleInput(String input) {
		
//		newContainer = new ItemContainer();
		String labelText = label.getText();
//		
//		if(currentPopupLabel != null) {
//			
//		}
		
		if(labelText.equals("Enter Container Name")) {
			newContainer.setContainerName(input);
			if(containersList.contains(selectedTreeItem.getValue())) {
				System.out.println(selectedTreeItem.getValue());
			}
//			else if(!(containersList.contains(selectedTreeItem.getValue())) ) {	
//			}
				
		}
			
		else if(labelText.equals("Enter X Co-oridnate")) {
			int intInput = Integer.parseInt(input);
			newContainer.setContainerX(intInput);
				
		}
		else if(labelText.equals("Enter Y Co-oridnate")) {
			int intInput = Integer.parseInt(input);
			newContainer.setContainerY(intInput);

		}
		else if(labelText.equals("Enter Width")) {
			int intInput = Integer.parseInt(input);
			newContainer.setContainerWidth(intInput);

		}
		else if(labelText.equals("Enter Height")) {
			int intInput = Integer.parseInt(input);
			newContainer.setContainerHeight(intInput);;
//			newContainer.setHeight(intInput);
//			updateTreeView(newContainer.getcontainerName());
//			displayListView.loadItems2();
//			currentPopupLabel = null;
//			drawShape(newContainer);
//			loadItems2();
		}
//		branchItems.addAll(new TreeItem<String>(newContainer.getContainerName()));
//		return newContainer;
		
		
	}

	

	
}
