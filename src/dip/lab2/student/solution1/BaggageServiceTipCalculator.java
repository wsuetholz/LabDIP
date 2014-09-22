package dip.lab2.student.solution1;

import dip.lab2.student.solution1.api.ServiceQuality;
import dip.lab2.student.solution1.api.TipCalculator;

/**
 * An example low-level class. Does this class definition follow the DIP? If
 * not, fix it.
 *
 * Any other best practice violations? Fix them too.
 *
 * @author your name goes here
 */
public class BaggageServiceTipCalculator implements TipCalculator {

//
//    private static final double MIN_BILL = 0.00;
//    private static final double MAX_BILL = 100.00;
//    private static final String BILL_ENTRY_ERR =
//            "Error: bill must be between " + MIN_BILL + " and "
//            + MAX_BILL;
    private static final double BASE_TIP_PER_BAG = 1.00;

    private static final double GOOD_RATE = 0.20;
    private static final double FAIR_RATE = 0.15;
    private static final double POOR_RATE = 0.10;

    private double goodTipRate;
    private double fairTipRate;
    private double poorTipRate;

    private double baseTipPerBag;
    private int bagCount;
    private ServiceQuality serviceQuality;

    public BaggageServiceTipCalculator() {
	this.setServiceQuality(ServiceQuality.GOOD); // perform validation
	this.setBagCount(0);
	goodTipRate = GOOD_RATE;
	fairTipRate = FAIR_RATE;
	poorTipRate = POOR_RATE;
	baseTipPerBag = BASE_TIP_PER_BAG; // set default value
    }

    public BaggageServiceTipCalculator(ServiceQuality serviceQuality, int bagCount) {
	this.setServiceQuality(serviceQuality); // perform validation
	this.setBagCount(bagCount);
	goodTipRate = GOOD_RATE;
	fairTipRate = FAIR_RATE;
	poorTipRate = POOR_RATE;
	baseTipPerBag = BASE_TIP_PER_BAG; // set default value
    }

    public int getBagCount() {
	return bagCount;
    }

    public final void setBagCount(int bagCount) {
	if (bagCount < 0) {
	    throw new IllegalArgumentException(
		    "bag count must be greater than or equal to zero");
	}
	this.bagCount = bagCount;
    }

    public double getBaseTipPerBag() {
	return baseTipPerBag;
    }

    public void setBaseTipPerBag(double baseTipPerBag) {
	if (baseTipPerBag < 0) {
	    throw new IllegalArgumentException(
		    "error: base tip must be greater than or equal to zero");
	}
	this.baseTipPerBag = baseTipPerBag;
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
    public double getCalculatedTip() {
	double tip = 0.00; // always initialize local variables

	switch (serviceQuality) {
	    case GOOD:
		tip = baseTipPerBag * bagCount * (1 + goodTipRate);
		break;
	    case FAIR:
		tip = baseTipPerBag * bagCount * (1 + fairTipRate);
		break;
	    case POOR:
		tip = baseTipPerBag * bagCount * (1 + poorTipRate);
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

    @Override
    public String getPromptString() {
	return "Total Number of Bags";
    }

    @Override
    public String getCustomValueAsString() {
	return (Integer.toString(bagCount));
    }

    @Override
    public void setCustomValueFromString(String newValue) {
	int oldCount = bagCount;
	try {
	    bagCount = Integer.parseInt(newValue);
	} catch (NumberFormatException e) {
	    bagCount = oldCount;
	}
    }

}
