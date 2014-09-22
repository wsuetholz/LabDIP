package dip.lab1.student.solution1;

import dip.lab1.student.solution1.api.Employee;
import javax.swing.JOptionPane;

/**
 * A high-level class that delegates to employee objects to do the work. Does
 * this class design follow the DIP? If not, fix it.
 *
 * @author your name goes here
 */
public class HRService {
    /** 
     * Constants can be used for retrieving annual wages of
     * various employee types. Is this the best way to go? Do we have
     * type safety?
     */
    public static final String SALARIED_TYPE = "Salaried";
    public static final String HOURLY_TYPE = "Hourly";

    /**
     * Alternatively to the above, we could use an enum. Does this improve
     * type safety?
     */
    public enum WageType {
        SALARIED,
        HOURLY
    }

    private static final String ERROR_MSG =
            "Cannot get annual wages because no valid employee type provided";
    private static final String ERROR_TITLE = "Employee Type Unknown";

    /**
     * This is a truly horrible way to make decisions. Very rigid and fragile!
     * @param e - an employee object (not truly polymorphic!)
     * employeeType - a String identifying the employee type. A constant
     * (see above) should be used for this, but can you guarantee it will be?
     * Are there other options? Hint: enum
     * @return the annual compensation for supported employee types
     */
    public double getAnnualCompensationForEmployee(Employee e)
    {
	return (e.getAnnualCompensation());
    }


}
