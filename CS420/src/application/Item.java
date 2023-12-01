package application;

//import application.ItemContainer.ItemContainerHolder;

public class Item {
	
	//data shared between controllers
	private String itemName;
	private int itemPrice;
	private int itemX;
	private int itemY;
	private int itemLenght;
	private int itemWidth;
	private int itemHeight;
	

	public Item() {}
	
	public Item(String itemName, int itemX, int itemY, int itemWidth, int itemHeight) {
		this.itemName = itemName;
		this.itemX = itemX;
		this.itemY = itemY;
		this.itemWidth = itemWidth;
		this.itemHeight = itemHeight;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getItemX() {
		return itemX;
	}

	public void setItemX(int itemX) {
		this.itemX = itemX;
	}

	public int getItemY() {
		return itemY;
	}

	public void setItemY(int itemY) {
		this.itemY = itemY;
	}

	public int getItemLenght() {
		return itemLenght;
	}

	public void setItemLenght(int itemLenght) {
		this.itemLenght = itemLenght;
	}

	public int getItemWidth() {
		return itemWidth;
	}

	public void setItemWidth(int itemWidth) {
		this.itemWidth = itemWidth;
	}

	public int getItemHeight() {
		return itemHeight;
	}

	public void setItemHeight(int itemHeight) {
		this.itemHeight = itemHeight;
	}
	

}
