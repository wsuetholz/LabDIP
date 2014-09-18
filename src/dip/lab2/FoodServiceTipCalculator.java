package dip.lab2;

import dip.lab2.BaggageServiceTipCalculator.ServiceQuality;
import static dip.lab2.BaggageServiceTipCalculator.ServiceQuality.FAIR;
import static dip.lab2.BaggageServiceTipCalculator.ServiceQuality.GOOD;
import static dip.lab2.BaggageServiceTipCalculator.ServiceQuality.POOR;
import dip.lab2.api.TipCalculator;

/**
 * An example low-level class. Does this class definition follow the DIP? If
 * not, fix it.
 *
 * Any other best practice violations? Fix them too.
 *
 * @author your name goes here
 */
public class FoodServiceTipCalculator implements TipCalculator {

    private static final double MIN_BILL = 0.00;
    private static final String BILL_ENTRY_ERR
				= "Error: bill must be greater than or equal to " + MIN_BILL;
    private static final double GOOD_RATE = 0.20;
    private static final double FAIR_RATE = 0.15;
    private static final double POOR_RATE = 0.10;
    
    private double minimumBillAmount;
    private double goodRate;
    private double fairRate;
    private double poorRate;

    private double totalBillAmount;
    private ServiceQuality serviceQuality;

    public FoodServiceTipCalculator(ServiceQuality serviceQuality, double totalBillAmount) {
	this.setServiceRating(serviceQuality);
	this.setTotalBillAmount(totalBillAmount);
	minimumBillAmount = MIN_BILL;
	goodRate = GOOD_RATE;
	fairRate = FAIR_RATE;
	poorRate = POOR_RATE;
    }

    public final void setTotalBillAmount(double TotalBillAmount) {
	if (TotalBillAmount < MIN_BILL) {
	    throw new IllegalArgumentException(BILL_ENTRY_ERR);
	}
	bill = billAmt;
    }

    public final void setServiceRating(ServiceQuality q) {
	serviceQuality = q;
    }

    @Override
    public double calculateTip() {
	double tip = 0.00; // always initialize local variables

	switch (serviceQuality) {
	    case GOOD:
		tip = bill * GOOD_RATE;
		break;
	    case FAIR:
		tip = bill * FAIR_RATE;
		break;
	    case POOR:
		tip = bill * POOR_RATE;
		break;
	}

	return tip;
    }

    @Override
    public ServiceQuality getServiceQuality() {
	return serviceQuality;
    }

    @Override
    public void setServiceQuality(ServiceQuality serviceQuality) {
	// No need to validate because enums provide type safety!
	// BUT, since an enum is an object, you STILL need to validate against non-null!
	if (serviceQuality == null) {
	    throw new IllegalArgumentException("New Service Quality must not be null!");
	}
	this.serviceQuality = serviceQuality;
    }
}
