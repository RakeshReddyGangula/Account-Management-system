package SBA6;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeliveryDetails {
	Scanner scanner = new Scanner(System.in);
	private String pickupNumber;
	private String alternativePickupNumber;

	public void setPickupNumber() {
		while (true) {
			System.out.print("Please enter pickup number: ");
			String number = scanner.nextLine();
			Pattern pattern = Pattern.compile("[6-9][0-9]{9}");
			Matcher matcher1 = pattern.matcher(number);
			if (matcher1.find()) {
				System.out.println("Valid number");
				this.pickupNumber = number;
				break;
			} else
				System.out.println("Invalid number");
		}
	}

	public String getPickupNumber() {
		return pickupNumber;
	}

	public void setAlternativePickupNumber() {
		while (true) {
			System.out.println("Please enter your alternative pickup number: ");
			String number = scanner.nextLine();
			Pattern pattern = Pattern.compile("[6-9][0-9]{9}");
			Matcher matcher1 = pattern.matcher(number);
			if (matcher1.find()) {
				System.out.println("Valid number");
				this.alternativePickupNumber = number;
				break;
			} else
				System.out.println("Invalid number");
		}
	}

	public String getAlternativePickupNumber() {
		return alternativePickupNumber;
	}

	public void printPickupDetails() {
		System.out.println("Pickup Number: " + this.getPickupNumber());
		System.out.println("Alternative Pickup Number: " + this.getAlternativePickupNumber());
	}
}
