package SBA6;

//To allow customers to rate and provide feedback on their orders.
public class CustomerReview {
	private int orderId;
    private int rating;
    private String feedback;
    
    public CustomerReview(int orderId, int rating, String feedback) {
        this.orderId = orderId;
        this.rating = rating;
        this.feedback = feedback;
    }
}