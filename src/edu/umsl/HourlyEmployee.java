package edu.umsl;

import java.io.*;
import java.util.Scanner;

public class HourlyEmployee extends Employee {

    private static final int REGULAR_HOURS = 40;

    /*********************
     Attributes
     *********************/
    float payRate = 30.0f;
    int hours = 45;

    //End Attributes

    /********************
     Constructors
     ********************/
    public HourlyEmployee(String firstName, String lastName, int hoursWorked, float payRate) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.hours = hoursWorked;
      this.payRate = payRate;
    }

    /********************
     Methods
     ********************/

    public void computeGross() {
        int overtimeHours = this.getHours() - REGULAR_HOURS;

        if (overtimeHours > 0) {
            this.gross = (float)((REGULAR_HOURS * this.getPayRate()) + (overtimeHours * (this.getPayRate() * 1.5)));
        } else {
            this.gross = this.getHours() * this.getPayRate();
        }

    }

    protected void displayEmployee() {
        System.out.println();
        System.out.println("***** Employee Info *****");
        displayFullName();
        System.out.println(
                "Hours Worked: " + this.getHours() +
                "\nPay Rate: " + this.getPayRate() +
                "\nTax Rate: " + this.taxRate + "\n");
        System.out.println("***** Payroll Info  *****");
        displayPayrollCalculations();
    }

    @Override
    public void writePayDetail(Writer writer) throws IOException {
        writer.write(
                "\nHours Worked: " + this.getHours() +
                        "\nPay Rate: " + this.getPayRate() +
                        "\nTax Rate: " + this.taxRate + "\n\n");
    }


    /********************
     Properties
     ********************/


    public float getPayRate() {
        return payRate;
    }

    public void setPayRate(float payRate) {
        this.payRate = payRate;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

}
