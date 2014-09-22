
package dip.lab2.student.solution1.api;

/**
 *
 * @author wsuetholz
 */
public interface TipCalculator {
    public abstract double getCalculatedTip () ;
    public abstract ServiceQuality getServiceQuality();
    public abstract void setServiceQuality(ServiceQuality serviceQuality);
    public abstract String getPromptString ();
    public abstract String getCustomValueAsString();
    public abstract void setCustomValueFromString(String newValue);
}
