package edu.umsl;

import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;

public class SalaryEmployee extends Employee {

    /********************
     Constructors
     ********************/
    public SalaryEmployee(String firstName, String lastName, float gross) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gross = gross;
    }

    /********************
     Methods
     ********************/

    public void computeGross() { };

    protected void displayEmployee() {
        System.out.println();
        System.out.println("***** Employee Info *****");
        displayFullName();
        System.out.println(
                        "\nGross Salary: " + this.gross +
                        "\nTax Rate: " + this.taxRate + "\n");
        System.out.println("***** Payroll Info  *****");
        displayPayrollCalculations();
    }

    @Override
    public void writePayDetail(Writer writer) throws IOException {
        writer.write(
                    "\nGross Salary: " + this.gross +
                        "\nTax Rate: " + this.taxRate + "\n\n");
    }

}
