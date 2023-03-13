package SBA6;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

//To maintain customer with orders details
public class CustomerOrder {
	private String name;
    private String email;
    List<OrderDetails> orders;
    
    public CustomerOrder(String name, String email) {
        this.name = name;
        this.email = email;
        this.orders = new ArrayList<>();
    }
    
    public void addOrderDetails(OrderDetails order) {
        orders.add(order);
    }
    public void showCustomerDetails()
    {
    	System.out.println("-----------------------------------------");
		System.out.println("Customer Name:"+this.name);
		System.out.println("Customer Email:"+this.email);
		System.out.println("-----------------------------------------");
		System.out.println("Customer Orders are");
		System.out.println("-----------------------------------------");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		for(OrderDetails order :this.orders) {			
			System.out.println("-----------------------------------------");
			System.out.println("Order Number:"+order.getId());
			order.showPickupDetails();
			System.out.println("Ordered Date:"+sdf.format(order.getDeliveryToimeLine().getStartDate()));
			System.out.println("Delivery Date:"+sdf.format(order.getDeliveryToimeLine().getEndDate()));
			System.out.println("-----------------------------------------");			
			List<Item> items = order.getItems();
			for (Item item : items) {
				System.out.println(item.getNumber() + ". " + item.getName() + " (" + item.getQuantity() + ") - Rs. "
						+ (item.getPrice() * item.getQuantity()));
			}
			System.out.println("-----------------------------------------");
		}
		System.out.println("-----------------------------------------");
    }
    
}