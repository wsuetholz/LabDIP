package dip.lab2;

import dip.lab2.api.TipCalculator;
import dip.lab2.api.ServiceQuality;

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
    private double goodTipRate;
    private double fairTipRate;
    private double poorTipRate;

    private double totalBillAmount;
    private ServiceQuality serviceQuality;

    public FoodServiceTipCalculator(ServiceQuality serviceQuality, double totalBillAmount) {
	this.setServiceQuality(serviceQuality);
	this.setTotalBillAmount(totalBillAmount);
	minimumBillAmount = MIN_BILL;
	goodTipRate = GOOD_RATE;
	fairTipRate = FAIR_RATE;
	poorTipRate = POOR_RATE;
    }

    public final void setTotalBillAmount(double totalBillAmount) {
	if (totalBillAmount < MIN_BILL) {
	    throw new IllegalArgumentException(BILL_ENTRY_ERR);
	}
	this.totalBillAmount = totalBillAmount;
    }

    public double getMinimumBillAmount() {
	return minimumBillAmount;
    }

    public void setMinimumBillAmount(double minimumBillAmount) {
	this.minimumBillAmount = minimumBillAmount;
    }

    public double getGoodTipRate() {
	return goodTipRate;
    }

    public void setGoodTipRate(double goodTipRate) {
	this.goodTipRate = goodTipRate;
    }

    public double getFairTipRate() {
	return fairTipRate;
    }

    public void setFairTipRate(double fairTipRate) {
	this.fairTipRate = fairTipRate;
    }

    public double getPoorTipRate() {
	return poorTipRate;
    }

    public void setPoorTipRate(double poorTipRate) {
	this.poorTipRate = poorTipRate;
    }

    @Override
    public double calculateTip() {
	double tip = 0.00; // always initialize local variables

	switch (serviceQuality) {
	    case GOOD:
		tip = totalBillAmount * goodTipRate;
		break;
	    case FAIR:
		tip = totalBillAmount * fairTipRate;
		break;
	    case POOR:
		tip = totalBillAmount * poorTipRate;
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
