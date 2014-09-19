
package dip.lab2.api;

/**
 *
 * @author wsuetholz
 */
public interface TipCalculator {
    public abstract double calculateTip () ;
    public abstract ServiceQuality getServiceQuality();
    public abstract void setServiceQuality(ServiceQuality serviceQuality);
    public abstract String getPromptString ();
    public abstract String getCustomValueAsString();
    public abstract void setCustomValueFromString(String newValue);
}
