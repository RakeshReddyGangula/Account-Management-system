package SBA6;

import java.util.Date;

//To allow customers to choose the delivery date and time
public class DeliveryTimeline {
	 private Date start;
	    private Date end;
	    
	    public DeliveryTimeline(Date start, Date end) {
	        this.start = start;
	        this.end = end;
	    }
	    
	    public Date getStartDate() {
	    	return this.start;
	    }
	    public Date getEndDate() {
	    	return this.end;
	    }
}