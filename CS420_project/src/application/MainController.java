package application;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
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
import javafx.scene.shape.*;



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
//    private TreeItem<String> itemContainer;
    private ObservableList<TreeItem<String>> leafItems;
//    private TreeItem<String> item;
    private TreeItem<String> selectedTreeItem;
    
    private ObservableList<String> list = FXCollections.observableArrayList();
    
    @FXML private AnchorPane drawAnchorPane;	//holding rectangles on AnchorPane
	private Group drawGroup; //to hold the multiple rectangles 
	private Rectangle rectangle;
	private Text text;	//to hold rectangle label
    
    private String selectedOption;
    private  Label label;
    private String input;
    
    private ItemContainer newContainer;
    private List<ItemContainer> containersList= new ArrayList<ItemContainer>();
    
    private Item newItem;
    private List<Item> itemList;
    
  //using hashmap to track item info and their rectangle;
	private Map<ItemContainer, Group> drawnRectangles = new HashMap<>();

    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		List<Item> commandCenterItems = new ArrayList<>();
	    Item commandCenterItem = new Item("Drone", 10, 10, 10, 10);
	    commandCenterItems.add(commandCenterItem);
	    ItemContainer commandCenter = new ItemContainer("Command Center",commandCenterItems, 50, 50, 100, 100);
	    
    	List<Item> barnContainerItems = new ArrayList<>();
        Item barnItem = new Item("Cattle", 10, 10, 10, 10);
        barnContainerItems.add(barnItem);
        ItemContainer barnContainer = new ItemContainer("Barn",barnContainerItems,50,50,100,100);
        
    	containersList.add(commandCenter);
    	containersList.add(barnContainer);
		
		drawGroup = new Group();
		drawAnchorPane.getChildren().add(drawGroup);
		updateTreeView();
		listVeiw();
	}
		

    private void updateTreeView() {
    	root = new TreeItem<String>("root");
    	treeView.setRoot(root);
    
    	//Clear the existing items in the TreeView
    	root.getChildren().clear();
    	
     // Add the updated items to the TreeView
    	branchItems = root.getChildren();
    	for(ItemContainer container: containersList) {
    		TreeItem<String> itemContainer = new TreeItem<String>(container.getContainerName());
    		branchItems.add(itemContainer);
    		
    		if(container.getContainerItems() != null) {
    			leafItems = itemContainer.getChildren();
    			
    			for (Item item : container.getContainerItems()) {
                    TreeItem<String> itemTreeItem = new TreeItem<String>(item.getItemName());
                    leafItems.add(itemTreeItem);
                }
    		}
    	}
    }

    	
    @FXML
    private void selectedTreeItem() {
    	selectedTreeItem = treeView.getSelectionModel().getSelectedItem();
    	if(selectedTreeItem != null) {
    		loadList(selectedTreeItem);
    	}
    }
    
	public void listVeiw() {
		list.clear();
		String option1 = "Item Root Commands";
		String option2 = "Add Item Container";
		list.addAll(option1,option2);
		listView.setItems(list);;
	}
	
	
	public void loadList(TreeItem<String> selectedTreeItem) {
		String option = "Delete Item";
		String option1 = "Add Item Container";
		String option2 = "Add Item";
		String option3 = "Delete Item-container";
		String option4 = "Change Name";
		String option5 = "Change Price";
		String option6 = "Change Location X";
		String option7 = "Change Location Y";
		String option8 = "Change Length";
		String option9 = "Change Width";
		String option10 = "Change Height";
		if(selectedTreeItem.equals(root)) {
			listVeiw();
		}else if(branchItems.contains(selectedTreeItem)) {
			list.clear();
			list.addAll(option1,option2,option3,option4,option5,option6,option7,option8,option9,option10);
			listView.setItems(list);
		}else {
			list.clear();
			list.addAll(option,option4,option5,option6,option7,option8,option9,option10);
			listView.setItems(list);
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
					showPopup("Enter Width");
					showPopup("Enter Height");
					drawShape(newContainer);
					containersList.add(newContainer);
					updateTreeView();
				}else if(selectedOption.equals("Change Name")) {
					showPopup("Enter Container Name");
					drawShape(newContainer);
					updateTreeView();
				}else if(selectedOption.equals("Change Price")) {
					showPopup("Enter Price");
				}else if(selectedOption.equals("Change Location X")) {
					showPopup("Enter X Co-oridnate");
					drawShape(newContainer);
				}else if(selectedOption.equals("Change Location Y")) {
					showPopup("Enter Y Co-oridnate");
					drawShape(newContainer);
				}else if(selectedOption.equals("Change Width")) {
					showPopup("Enter Width");
					drawShape(newContainer);
				}else if(selectedOption.equals("Change Height")) {
					showPopup("Enter Height");
					drawShape(newContainer);
				}else if(selectedOption.equals("Add Item")) {
					newItem = new Item();
					showPopup("Enter Container Name");
					showPopup("Enter X Co-oridnate");
					showPopup("Enter Y Co-oridnate");
					showPopup("Enter Width");
					showPopup("Enter Height");
					ItemContainer seleContainer = findContainerByName(selectedTreeItem.getValue());	
					if (seleContainer != null) {
                        if (seleContainer.getContainerItems() == null) {
                        	seleContainer.setContainerItems(new ArrayList<>());
                        	
                        }
                        seleContainer.getContainerItems().add(newItem);
                    }

					drawShape(seleContainer);
					updateTreeView();
				}else if(selectedOption.equals("Change Name")) {
					showPopup("Enter Container Name");
					drawShape(newContainer);
					updateTreeView();
				}else if(selectedOption.equals("Change Price")) {
					showPopup("Enter Price");
				}else if(selectedOption.equals("Change Location X")) {
					showPopup("Enter X Co-oridnate");
					drawShape(newContainer);
				}else if(selectedOption.equals("Change Location Y")) {
					showPopup("Enter Y Co-oridnate");
					drawShape(newContainer);
				}else if(selectedOption.equals("Change Width")) {
					showPopup("Enter Width");
					drawShape(newContainer);
				}else if(selectedOption.equals("Change Height")) {
					showPopup("Enter Height");
					drawShape(newContainer);
				}
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
	}

	private void handleInput(String input) {
		
		String labelText = label.getText();

		if(labelText.equals("Enter Container Name")) {
			if(selectedOption.equals("Add Item Container")) {
				newContainer.setContainerName(input);				
			}else if(selectedOption.equals("Change Name")&&selectedTreeItem.getValue() != null ) {
				ItemContainer seleContainer = findContainerByName(selectedTreeItem.getValue());				
				seleContainer.setContainerName(input);					
			}else if(selectedOption.equals("Add Item")) {
				newItem.setItemName(input);
			}
			
				
		}else if(labelText.equals("Enter X Co-oridnate")) {
			int intInput = Integer.parseInt(input);
			if(selectedOption.equals("Add Item Container")) {
				newContainer.setContainerX(intInput);				
			}else if(selectedOption.equals("Change Location X")&&selectedTreeItem.getValue() != null ) {
				ItemContainer seleContainer = findContainerByName(selectedTreeItem.getValue());	
				seleContainer.setContainerX(intInput);
			}else if(selectedOption.equals("Add Item")) {
				newItem.setItemX(intInput);
			}
				
		}else if(labelText.equals("Enter Y Co-oridnate")) {
			int intInput = Integer.parseInt(input);
			if(selectedOption.equals("Add Item Container")) {				
				newContainer.setContainerY(intInput);
			}else if(selectedOption.equals("Change Location Y")&&selectedTreeItem.getValue() != null ) {
				ItemContainer seleContainer = findContainerByName(selectedTreeItem.getValue());	
				seleContainer.setContainerY(intInput);
			}else if(selectedOption.equals("Add Item")) {
				newItem.setItemY(intInput);
			}
			
			
		}else if(labelText.equals("Enter Width")) {
			int intInput = Integer.parseInt(input);
			if(selectedOption.equals("Add Item Container")) {
				newContainer.setContainerWidth(intInput);				
			}else if(selectedOption.equals("Change Width")&&selectedTreeItem.getValue() != null ) {
				ItemContainer seleContainer = findContainerByName(selectedTreeItem.getValue());	
				seleContainer.setContainerWidth(intInput);
			}else if(selectedOption.equals("Add Item")) {
				newItem.setItemWidth(intInput);
			}
			
			
		}else if(labelText.equals("Enter Height")) {
			int intInput = Integer.parseInt(input);
			if(selectedOption.equals("Add Item Container")) {				
				newContainer.setContainerHeight(intInput);
			}else if(selectedOption.equals("Change Height")&&selectedTreeItem.getValue() != null ) {
				ItemContainer seleContainer = findContainerByName(selectedTreeItem.getValue());	
				seleContainer.setContainerHeight(intInput);
			}else if(selectedOption.equals("Add Item")) {
				newItem.setItemHeight(intInput);
			}
			
			
		}else if(labelText.equals("Enter Price")) {
			int intInput = Integer.parseInt(input);
			if(selectedOption.equals("Add Item Container")) {				
				newContainer.setContainerHeight(intInput);
			}else if(selectedOption.equals("Change Price")&&selectedTreeItem.getValue() != null ) {
				ItemContainer seleContainer = findContainerByName(selectedTreeItem.getValue());	
				seleContainer.setContainerHeight(intInput);

			}
		}

		
	}
	private ItemContainer findContainerByName(String containerName) {
	    for (ItemContainer container : containersList) {
	        if (container.getContainerName().equals(containerName)) {
	            return container;
	        }
	    }
	    return null; // If not found, return null or handle it as needed
	}
	
	public void drawShape(ItemContainer newContainer) {
		
		try {
			//remove previous rectangle
			Group group2 = drawnRectangles.get(newContainer);
		    if (group2 != null) {
		        drawGroup.getChildren().remove(group2);
		        drawnRectangles.remove(newContainer);
		    }
	        // Check if container values are valid
	        if (newContainer != null && newContainer.getContainerWidth() > 0 && newContainer.getContainerHeight() > 0) {
	            rectangle = new Rectangle(newContainer.getContainerX(), newContainer.getContainerY(), newContainer.getContainerWidth(), newContainer.getContainerHeight());
	            rectangle.setFill(Color.TRANSPARENT);
	            rectangle.setStroke(Color.RED);

	            text = new Text(newContainer.getContainerName());
	            text.setLayoutX(newContainer.getContainerX() + 10);
	            text.setLayoutY(newContainer.getContainerY() + 20);

	            // Create a group to hold the rectangle and text
	            Group group = new Group(rectangle, text);
//	            drawGroup.getChildren().add(group);
	            
	          //update HashMap
				drawnRectangles.put(newContainer,group);
				drawGroup.getChildren().add(group);
				
				if(newContainer.getContainerItems() != null) {
					//containeritems rectangle
					for (Item item : newContainer.getContainerItems()) {
	                    Rectangle itemRectangle = new Rectangle(item.getItemX(), item.getItemY(), item.getItemWidth(), item.getItemHeight());
	                    itemRectangle.setFill(Color.TRANSPARENT);
	                    itemRectangle.setStroke(Color.BLUE);
	                    Text itemText = new Text(item.getItemName());
	                    itemText.setLayoutX(item.getItemX() + 10);
	                    itemText.setLayoutY(item.getItemY() + 20);

	                    Group itemGroup = new Group(itemRectangle, itemText);
	                    drawGroup.getChildren().add(itemGroup);
	                }
	            
				}
	        }
	    } catch (Exception e) {
	        // Handle any exceptions that might occur during rectangle creation
	        e.printStackTrace();
	    }

		
	}
	
}
	

	

	

