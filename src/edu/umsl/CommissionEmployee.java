package edu.umsl;

import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;

public class CommissionEmployee extends Employee {

    /*********************
     Attributes
     *********************/
    int itemsSold = 0;
    float itemPrice = 0;

    //End Attributes

    /********************
     Constructors
     ********************/
    public CommissionEmployee(String firstName, String lastName, int itemsSold, float itemPrice) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.itemsSold = itemsSold;
        this.itemPrice = itemPrice;
    }

    /********************
     Methods
     ********************/

    public void computeGross() {
        this.gross = (float) ((itemPrice * itemsSold) * .5);
    }

    protected void displayEmployee() {
        System.out.println();
        System.out.println("***** Employee Info *****");
        displayFullName();
        System.out.println(
                        "\nItems Sold: " + this.getItemsSold() +
                        "\nUnit Price: " + this.getItemPrice() +
                        "\nTax Rate: " + this.taxRate + "\n");
        System.out.println("***** Payroll Info  *****");
        displayPayrollCalculations();
    }

    @Override
    public void writePayDetail(Writer writer) throws IOException {
        writer.write(
                        "\nItems Sold: " + this.getItemsSold() +
                        "\nUnit Price: " + this.getItemPrice() +
                        "\nTax Rate: " + this.taxRate + "\n\n");
    }


    public int getItemsSold() {
        return itemsSold;
    }

    public float getItemPrice() {
        return itemPrice;
    }

}
