package SBA6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ItemCategory{
	List<Item> mobiles;
	List<Item> clothes;
	List<Item> electronics;
	List<Item> cartItems;
	List<Item> orderItems;
	Scanner sc = new Scanner(System.in);	

	public ItemCategory() {
		mobiles = new ArrayList<>();
		mobiles.add(new Item(1, "Red Mi Note	", "Red Mi Note 5	",8000,1));
		mobiles.add(new Item(2, "Red Mi 9	", "Red Mi 9A	",12000,1));
		mobiles.add(new Item(3, "Real Me Narzo", "Real Me 9i NARZO",15000,1));
		mobiles.add(new Item(4, "SAMSUNG	", "Samsung S20 ULTRA",25000,1));
		mobiles.add(new Item(5, "NOKIA	", "Nokia Basic	",1500,1));

		clothes = new ArrayList<>();
		clothes.add(new Item(1, "Shirt	", "Mens Casuals 	",1000,1));
		clothes.add(new Item(2, "Trouser	", "Jeans or Formals",1200,1));
		clothes.add(new Item(3, "T-Shirt	", "T-Shirt		",500,1));
		clothes.add(new Item(4, "Kurtha	", "Kurtha 		",2000,1));
		clothes.add(new Item(5, "Saree	", "Fancy Saree	",3000,1));

		electronics=new ArrayList<>();	
		electronics.add(new Item(1, "T.V		", "LG TV		",1000,1));
		electronics.add(new Item(2, "Fridge	", "WhirlPool Fridge",1200,1));
		electronics.add(new Item(3, "Machine	", "ITC front load ",500,1));

		cartItems = new ArrayList<>();
		orderItems = new ArrayList<>();		
	}	
	public void showMobilesMenu() {
		System.out.println("-----------------------------------------");
		System.out.println(" Mobile Category ");

		for (Item item : mobiles) {
			System.out.println(item.getNumber() + ". " + item.getName() +"  	 "+item.getDescription() + "   - Rs. " + item.getPrice());
		}
		System.out.println("-----------------------------------------");
	}

	public void showClothesMenu() {

		System.out.println("-----------------------------------------");
		System.out.println(" Clothes Category ");
		for (Item item : clothes) {
			System.out.println(item.getNumber() + ". " + item.getName() +"	"+item.getDescription() + " - Rs. " + item.getPrice());
		}
		System.out.println("-----------------------------------------");
	}
	
	public void showElectronicsMenu() {

		System.out.println("-----------------------------------------");
		System.out.println(" Electronics Category ");
		for (Item item : electronics) {
			System.out.println(item.getNumber() + ". " + item.getName() +"	"+item.getDescription() + " - Rs. " + item.getPrice());
		}
		System.out.println("-----------------------------------------");
	}

	public void addToCart(Item item) {
		cartItems.add(item);
		System.out.println("Item added to Cart: " + item.getName() + " - Rs. " + item.getPrice() + " ("
				+ item.getQuantity() + ")");
	}

	public void placeOrder(Item item) {
		//Add item to cart
		cartItems.add(item);
		System.out.println("Item Placed for order: " + item.getName() + " (" + item.getQuantity() + ") - Rs. "
						+ (item.getPrice() * item.getQuantity()));
	}
	public void showCartItems() {
		System.out.println("-----------------------------------------");
		System.out.println(" Cart Items");
		for (Item item : cartItems) {
			System.out.println(item.getNumber() + ". " + item.getName() + "	"+item.getDescription() +" - Rs. " + item.getPrice() + " ("
					+ item.getQuantity() + ")");
		}
		System.out.println("-----------------------------------------");
	}	
}
