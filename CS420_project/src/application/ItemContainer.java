package application;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.PopupControl;
import javafx.scene.control.TextField;

public class ItemContainer {
	
	
	private List<Item> containerItems = new ArrayList<Item>();
	private String containerName;
	private int containerX;
	private int containerY;
	private int containerLength;
	private int containerWidth;
	private int containerHeight;
	
	public ItemContainer() {}

	public ItemContainer(String containerName, int containerX, int containerY, int containerWidth, int containerHeight){
		this.containerName = containerName;
		this.containerX = containerX;
		this.containerY = containerY;
		this.containerWidth = containerWidth;
		this.containerHeight = containerHeight;
	}
	
	


	
	public void setContainerItems(List<Item> containerItems) {
		this.containerItems = containerItems;
	}
	public List<Item> getContainerItems() {
		return containerItems;
	}

	public String getContainerName(){
		return containerName;
	}
	
	public void setContainerName(String containerName){
		this.containerName = containerName;
	}

	public int getContainerX() {
		return containerX;
	}

	public void setContainerX(int containerX) {
		this.containerX = containerX;
	}

	public int getContainerY() {
		return containerY;
	}

	public void setContainerY(int containerY) {
		this.containerY = containerY;
	}
	public int getContainerWidth() {
		return containerWidth;
	}

	public int getContainerHeight() {
		return containerHeight;
	}

	
	public void setContainerWidth(int containerWidth) {
		this.containerWidth = containerWidth;
	}
	
	public void setContainerHeight(int containerHeight) {
		this.containerHeight = containerHeight;
	}



	public int getContainerLength() {
		return containerLength;
	}

	public void setContainerLength(int containerLength) {
		this.containerLength = containerLength;
	}
	
}
