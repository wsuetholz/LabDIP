package dip.lab1.student.solution1;

import dip.lab1.student.solution1.api.Employee;

/**
 * A simple implementation sub-class of ConcreteEmployee. These are low-level
 * classes in the DIP. Does it meet the rules of DIP? If not fix it.
 *
 * @author your name goes here
 */
public class SalariedEmployee implements Employee {

    private double annualSalary;
    private double annualBonus;

    /**
     * default constructor. Is this the best way to go?
     */
    public SalariedEmployee() {
    }

    /**
     * Convenience constructor. Is this the best way to go?
     *
     * @param annualSalary - the employee's annual salary
     * @param annualBonus - a bonus benefit, if any
     */
    public SalariedEmployee(double annualSalary, double annualBonus) {
	setAnnualSalary(annualSalary);
	setAnnualBonus(annualBonus);
    }
    
    /**
     * Returns annual bonus for salaried workers. Is this polymorphic?
     * Could it be? Does it belong here?
     *
     * @return annual bonus or zero if none.
     */
    public double getAnnualBonus() {
        return annualBonus;
    }

    /**
     * Is this polymorphic? Should it be? Does it belong here?
     * @param annualBonus -- think carefully about this
     */
    public void setAnnualBonus(double annualBonus) {
        this.annualBonus = annualBonus;
    }

    /**
     * Is this polymorphic? Should it be? Does it belong here?
     * @return
     */
    public double getAnnualSalary() {
        return annualSalary;
    }

    /**
     * Is this polymorphic? Should it be? Does it belong here?
     * @param annualSalary - think carefully about this
     */
    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    @Override
    public double getAnnualCompensation() {
	return getAnnualSalary();
    }

}
