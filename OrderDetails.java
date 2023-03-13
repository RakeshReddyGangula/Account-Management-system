package SBA6;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;



//To maintain an order number, use a counter to generate a unique ID for each new order:
public class OrderDetails {
	private static int counter = 0;
	private int id;
    List<Item> items;
    private DeliveryTimeline deliveryTimeline;
    private boolean isDelivered;
    private CustomerReview review;
    private DeliveryDetails deliveryDetails;
    
    public OrderDetails(DeliveryTimeline deliveryTimeline) {
        this.id =  ++counter;
        this.deliveryTimeline = deliveryTimeline;
        this.isDelivered = false;
    }
    
    public void addItems(List<Item> items)
    {
    	List<Item> orderItems =new ArrayList<>();
    	for(Item item:items) {
    		Item ind =new Item(item.getNumber(),item.getName(),item.getDescription(),item.getPrice(),item.getQuantity());
    		orderItems.add(ind);
    	}
    	this.items=orderItems;
    }
    
    public void markAsDelivered() {
        this.isDelivered = true;
    }
    
    public void addReview(int rating, String feedback) {
        this.review = new CustomerReview(this.id, rating, feedback);
    }
    
    public void addDeliveryDetails() {
    	this.deliveryDetails=new DeliveryDetails();	     
	      // Set the pickup number
    	deliveryDetails.setPickupNumber();	     
	      // Request the alternative pickup number
    	deliveryDetails.setAlternativePickupNumber();	
    }
    public void showPickupDetails()
    {
    	if(deliveryDetails!=null) {
    		// Print the pickup details
        	deliveryDetails.printPickupDetails();
    	}    	
    }    
    
    public int getId() {
        return id;
    }
    public List<Item> getItems() {
        return items;        
    }    
    
    public DeliveryTimeline getDeliveryToimeLine() {
        return deliveryTimeline;
    }
    public int placeOrder()
    {
    	System.out.println("-----------------------------------------");
		System.out.println(" Placed Items order with Order Number:"+this.id);
		System.out.println("-----------------------------------------");
    	return this.id;
    }
    
    public void showOrderItems() {
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("-----------------------------------------");
		System.out.println("Order Number:"+this.id);
		System.out.println("Ordered Date:"+sdf.format(this.deliveryTimeline.getStartDate()));
		System.out.println("Delivery Date:"+sdf.format(this.deliveryTimeline.getEndDate()));
		System.out.println("-----------------------------------------");
		for (Item item : items) {
			System.out.println(item.getNumber() + ". " + item.getName() + " (" + item.getQuantity() + ") - Rs. "
					+ (item.getPrice() * item.getQuantity()));
		}
		System.out.println("-----------------------------------------");
		System.out.println("Thank you for your order");		
	}
    
    public void customerFeedback()
    {
    	Scanner sc = new Scanner(System.in);
    	int rating=0;
    	String feedback;
    	try {  	
    	System.out.println("Please give your valuable feedback. The ratings are \n 5.Very Good \n4.Good \n3.Average \n2.Below Average \n1.Poor");
		while(true) {
			System.out.print("Enter your rating number:");
			rating=sc.nextInt();
			if(rating<1 && rating>6)
			{
				System.out.print("Please enter valid rating number");
			}
			else
			{
				break;
			}
		}
    	
		System.out.print("Enter your feed back:");
		feedback=sc.next();		
		CustomerReview customerReview = new CustomerReview(this.id, rating, feedback);
		System.out.println("Thank you for giving your valuable feedback.");
    	}    	
    	catch (InputMismatchException ae) {
			System.out.println(ae);
		}
    }
}