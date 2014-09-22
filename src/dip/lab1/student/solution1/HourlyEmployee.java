package dip.lab1.student.solution1;

import dip.lab1.student.solution1.api.Employee;

/**
 * An implementation sub-class of an Employee. These are low-level classes in
 * the DIP. Does it meet the rules of DIP? If not fix it.
 *
 * @author your name goes here
 */
public class HourlyEmployee implements Employee {

    private double hourlyRate;
    private double totalHrsForYear;

    /**
     * default constructor. Is this the best way to go?
     */
    public HourlyEmployee() {
    }

    /**
     * Convenience constructor. Is this the best way to go?
     *
     * @param hourlyRate - the rate per hour that the employee is paid
     * @param totalHrsForYear - total hours worked or predicted per year
     */
    public HourlyEmployee(double hourlyRate, double totalHrsForYear) {
	setHourlyRate(hourlyRate);
	setTotalHrsForYear(totalHrsForYear);
    }
    /**
     * Returns annual wages for hourly workers. Is this polymorphic?
     * Could it be? Does it belong here?
     *
     * @return annual wages for hourly workers using the formula
     * annualWages = hourlyRate * totalHrsForYear
     */
    public double getAnnualWages() {
        return hourlyRate * totalHrsForYear;
    }
    
    /**
     * Is this polymorphic? Should it be? Does it belong here?
     * @return
     */
    public double getHourlyRate() {
        return hourlyRate;
    }

    /**
     * Is this polymorphic? Should it be? Does it belong here?
     * @param hourlyRate -- think carefully about this
     */
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    /**
     * Is this polymorphic? Should it be? Does it belong here?
     * @return
     */
    public double getTotalHrsForYear() {
        return totalHrsForYear;
    }

    /**
     * Is this polymorphic? Should it be? Does it belong here?
     * @param totalHrsForYear -- think carefully about this
     */
    public void setTotalHrsForYear(double totalHrsForYear) {
        this.totalHrsForYear = totalHrsForYear;
    }

    @Override
    public double getAnnualCompensation() {
	return getAnnualWages();
    }

}
