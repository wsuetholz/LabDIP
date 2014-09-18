/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dip.lab2;

import dip.lab2.api.TipCalculator;
import dip.lab2.api.ServiceQuality;

/**
 *
 * @author wsuetholz
 */
public class TipCalculationManager {

    private TipCalculator tipCalculator;

    public TipCalculationManager(TipCalculator tipCalculator) {
	this.tipCalculator = tipCalculator;
    }

    public TipCalculator getTipCalculator() {
	return tipCalculator;
    }

    public void setTipCalculator(TipCalculator tipCalculator) {
	if (tipCalculator == null) {
	    throw new IllegalArgumentException("TipCalculator object can not be null!");
	}
	this.tipCalculator = tipCalculator;
    }

    public void setServiceQuality(ServiceQuality serviceQuality) {
	tipCalculator.setServiceQuality(serviceQuality);	// Let the class being delegated to do the error checking
    }

    public ServiceQuality getServiceQuality() {
	return tipCalculator.getServiceQuality();
    }

    public double calculateTips() {
	return tipCalculator.calculateTip();
    }
}
