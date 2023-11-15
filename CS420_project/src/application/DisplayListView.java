//package application;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.scene.control.ListView;
//import javafx.scene.control.TreeView;
//
//public class DisplayListView {
//	
//	ObservableList<String> list = FXCollections.observableArrayList();
//	private TreeView<String> treeView;
//	private ListView<String> listView;
//	private String popupLable;
//	private MainController mainController;
//	private List<Item> containerItems;
//	private ItemContainer newContainer ;
//	
//	public void setMainController(MainController mainController) {
//		this.mainController = mainController;
//	}
//	
//	public void setListView(ListView<String> listView) {
//        this.listView = listView;
//    }
//
//	public void nextPopup(MainController mainController) {
//		mainController.nextPopup(popupLable);
//	}
//
//	public void selectedList(String selectedOption) {
//		
//
//		if("Add Item Container".equals(selectedOption)) {
//			containerItems = new ArrayList<Item>();
//			popupLable = "Enter Container Name";
//			nextPopup(mainController);
////		}else if("Change Location X".equals(selectedOption)){
////			popupLable = "Enter X Co-oridnate";
////			nextPopup(mainController);
//		}else if("Change Location X".equals(selectedOption)){
//			popupLable = "Enter X Co-oridnate";
//			nextPopup(mainController);
////			mainController.removeRectangle(newContainer);
//		}else if("Change Location Y".equals(selectedOption)){
//			popupLable = "Enter Y Co-oridnate";
//			nextPopup(mainController);
//		}
////		mainController.drawShape(newContainer);
//		newContainer.setContainerItems(containerItems);
//	}
//	public void loadItems() {
//		String option1 = "Item Root Commands";
//		String option2 = "Add Item Container";
//		list.addAll(option1,option2);
//		listView.getItems().addAll(list);
//	}
//	
//	public void loadItems2() {
//		list.clear();
//		String option1 = "Add Item Container";
//		String option2 = "Add Item";
//		String option3 = "Delete item-container";
//		String option4 = "Change name";
//		String option5 = "Change Prive";
//		String option6 = "Change Location X";
//		String option7 = "Change Location Y";
//		String option8 = "Change Length";
//		String option9 = "Change Width";
//		String option10 = "Change Height";
//		list.addAll(option1,option2,option3,option4,option5,option6,option7,option8,option9,option10);
//		listView.setItems(list);;
//	}
//}
