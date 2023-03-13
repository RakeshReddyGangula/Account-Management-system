package SBA6;

public class Item {
	private int itemId;
	private String name;
	private String description;
	private float price;
	int quantity;

	public Item(int id, String name, String description, float price,int quantity) {
		this.itemId = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity=quantity;
	}	
	public int getNumber() {
		return itemId;
	}

	public String getName() {
		return name;
	}

	public float getPrice() {
		return price;
	}
	public String getDescription() {
		return description;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity=quantity;
	}
}
