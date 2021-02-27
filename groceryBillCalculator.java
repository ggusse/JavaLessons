import java.util.Scanner;
import java.text.*;

public class groceryBillCalculator {
	
	public static void main (String args[]) {
		
		double couponValue = 0.0;
		double week1Bill = 0.0;
		double week2Bill = 0.0;
		double week3Bill = 0.0;
		double week4Bill = 0.0;
		double monthlyTotal = 0.0;
		double weeklyAverage = 0.0;
		
		Scanner scnr = new Scanner(System.in);
		DecimalFormat money = new DecimalFormat("#.##");
		
		System.out.println("Enter the coupon amount (as a decimal): ");
		couponValue = scnr.nextDouble();
		if (couponValue > 1.0 || couponValue <= 0.0) {couponValue = 0.1;}
		
		System.out.println("Enter week 1 grocery bill: ");
		week1Bill = scnr.nextDouble();
		
		System.out.println("Enter week 2 grocery bill: ");
		week2Bill = scnr.nextDouble();
		
		System.out.println("Enter week 3 grocery bill: ");
		week3Bill = scnr.nextDouble();
		
		System.out.println("Enter week 4 grocery bill: ");
		week4Bill = scnr.nextDouble();
		
		monthlyTotal = week1Bill + week2Bill + week3Bill + week4Bill;
		weeklyAverage = monthlyTotal / 4;
		
		System.out.println("Monthly total without coupon: $" + money.format(monthlyTotal));
		System.out.println("Weekly average without coupon: $" + money.format(weeklyAverage));
		System.out.println("Monthly total with coupon: $" + money.format(monthlyTotal - (monthlyTotal * couponValue)));
		System.out.println("Weekly average with coupon: $" + money.format(weeklyAverage - (weeklyAverage * couponValue)));
		
	}
}
