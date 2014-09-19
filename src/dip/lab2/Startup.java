package dip.lab2;

import dip.lab2.api.ServiceQuality;
// An useful import if you need it.
import dip.lab2.api.TipCalculator;

/**
 * Just a test class for input and output.
 *
 * 1. Create instances of low-level classes using Liskov Substitution principle.
 * 2. Create an instance of your high-level class.
 * 3. Pass one of your calculator instances to the high-level class and
 *    check the results.
 * 4. Now switch to a different calculator instance and pass that to the
 *    high-level class. Did it work? Are the low-level instances
 *    interchangeable? The DIP requires this.
 * 
 * @author your name goes here
 */
public class Startup {
    public static void main(String[] args) {
	BaggageServiceTipCalculator baggageTips;
	FoodServiceTipCalculator foodTips;
	TipCalculator tipCalculator;
	
	TipCalculationManager tipCalculationManager;
	
	baggageTips = new BaggageServiceTipCalculator (ServiceQuality.GOOD, 4);

	tipCalculationManager = new TipCalculationManager (baggageTips);
	
	System.out.println ( "The Baggage Tip for 4 bags, with Good service is $" + tipCalculationManager.calculateTips() + ".");

	foodTips = new FoodServiceTipCalculator (ServiceQuality.GOOD, 15.00);
	
	tipCalculationManager.setTipCalculator(foodTips);

	System.out.println ( "The Food Tip for a $15.00 total bill, with Good service is $" + tipCalculationManager.calculateTips() + ".");	
    }

}
