package SBA6;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class OrderSystemMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		try  {
			String customerName="Praveen";
			String emailAddress="praveen@gmail.com";		
			CustomerOrder customerOrder=new CustomerOrder(customerName, emailAddress);
			ItemCategory itemCategory=new ItemCategory();		
			int choice = 0, option = 0;		
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("* Welcome to Order Processing System*");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			while (true) {
				System.out.println("1. Mobile");
				System.out.println("2. Clothes");
				System.out.println("3. Electronics");
				System.out.println("4. View Orders");
				System.out.println("5. HelpLine");				
				System.out.print("\nEnter your choice item category: ");
				choice = sc.nextInt();
				int itemNumber,itemQuantity;
				boolean isValidItem=false;
				switch (choice) {
				case 1:
					itemCategory.showMobilesMenu();
					//****** 		
					System.out.print("Enter item number: ");
					itemNumber = sc.nextInt();
					System.out.print("Enter quantity of item: ");
					itemQuantity = sc.nextInt();
					for (Item item :itemCategory.mobiles) {
						if (item.getNumber()==itemNumber) {
							item.quantity=itemQuantity;
							isValidItem=true;							
							System.out.println("\n1.Add To Cart");
							System.out.println("2.PlaceOrder");
							System.out.print("Enter option: ");
							option = sc.nextInt();
							if (option == 1) {
								System.out.println("");
								itemCategory.addToCart(item);
								itemCategory.showCartItems();
							} else if(option==2){
								System.out.println("");
								
								Calendar c = Calendar.getInstance();
								c.setTime(new Date());
								Date startDate= c.getTime();
								c.add(Calendar.DATE, 5); // Adding 5 days
								Date deliverDate = c.getTime();	
								
								DeliveryTimeline timeLine=new DeliveryTimeline(startDate,deliverDate);	
								OrderDetails order=new OrderDetails(timeLine);	
								order.addDeliveryDetails();
								itemCategory.placeOrder(item);
								order.addItems(itemCategory.cartItems);
								int orderId = order.placeOrder();
								order.showOrderItems();
								//Review order
								order.customerFeedback();									
								customerOrder.addOrderDetails(order);
								itemCategory.cartItems.clear();	
							}
							else {
								System.out.println("Invalid option");
							}
						}						
					}
					if(!isValidItem) {
						System.out.println("\nItem is not available. ");
					}					
					break;
				case 2:
					itemCategory.showClothesMenu();
					System.out.print("Enter item number: ");
					itemNumber = sc.nextInt();
					System.out.print("Enter quantity of item: ");
					itemQuantity = sc.nextInt();
					for (Item item :itemCategory.clothes) {
						if (item.getNumber()==itemNumber) {
							item.quantity=itemQuantity;
							isValidItem=true;							
							System.out.println("\n1.Add To Cart");
							System.out.println("2.PlaceOrder");
							System.out.print("Enter option: ");
							option = sc.nextInt();
							if (option == 1) {
								System.out.println("");
								itemCategory.addToCart(item);
								itemCategory.showCartItems();
							} else if(option==2){
								System.out.println("");
								
								Calendar c = Calendar.getInstance();
								c.setTime(new Date());
								Date startDate= c.getTime();
								c.add(Calendar.DATE, 5); // Adding 5 days
								Date deliverDate = c.getTime();
								
								DeliveryTimeline timeLine=new DeliveryTimeline(startDate,deliverDate);	
								OrderDetails order=new OrderDetails(timeLine);								
								//order.addItems(itemCategory.cartItems);								
								order.addDeliveryDetails();
								itemCategory.placeOrder(item);
								order.addItems(itemCategory.cartItems);
								int orderId = order.placeOrder();
								order.showOrderItems();									
								//Review order
								order.customerFeedback();
								customerOrder.addOrderDetails(order);
								itemCategory.cartItems.clear();
							}
							else {
								System.out.println("Invalid option");
							}
						}						
					}
					if(!isValidItem) {
						System.out.println("\nItem is not available. ");
					}					
					break;
				case 3:
					itemCategory.showElectronicsMenu();
					System.out.print("Enter item number: ");
					itemNumber = sc.nextInt();
					System.out.print("Enter quantity of item: ");
					itemQuantity = sc.nextInt();
					for (Item item :itemCategory.electronics) {
						if (item.getNumber()==itemNumber) {
							item.quantity=itemQuantity;
							isValidItem=true;							
							System.out.println("\n1.Add To Cart");
							System.out.println("2.PlaceOrder");
							System.out.print("Enter option: ");
							option = sc.nextInt();
							if (option == 1) {
								System.out.println("");
								itemCategory.addToCart(item);
								itemCategory.showCartItems();
							} else if(option==2){
								System.out.println("");
								
								Calendar c = Calendar.getInstance();
								c.setTime(new Date());
								Date startDate= c.getTime();
								c.add(Calendar.DATE, 5); // Adding 5 days
								Date deliverDate = c.getTime();
								
								DeliveryTimeline timeLine=new DeliveryTimeline(startDate,deliverDate);	
								OrderDetails order=new OrderDetails(timeLine);								
								//order.addItems(itemCategory.cartItems);								
								order.addDeliveryDetails();
								itemCategory.placeOrder(item);
								order.addItems(itemCategory.cartItems);
								int orderId = order.placeOrder();
								order.showOrderItems();									
								//Review order
								order.customerFeedback();
								customerOrder.addOrderDetails(order);
								itemCategory.cartItems.clear();
							}
							else {
								System.out.println("Invalid option");
							}
						}						
					}
					if(!isValidItem) {
						System.out.println("\nItem is not available. ");
					}					
					break;
				case 4:
					customerOrder.showCustomerDetails();
					break;
				case 5:					
					System.out.println("Please enter your complaint");
					sc.next();
					String complaint=sc.nextLine();
					CustomerHelpline.resolveComplaint(complaint);
					System.out.println("Thank you for your complaint. We will look into it and get back to you shortly.\"");
					break;
				default:
					System.out.println("Invalid Choice");					
				}
			}
			
		}
		catch (InputMismatchException ae) {
			System.out.println(ae);
		}

	}

}
