package edu.umsl;

import java.io.*;
import java.util.Scanner;

public abstract class Employee implements Serializable {

    private static final long serialVersionUID = 04110413L;

    /*********************
     Attributes
     *********************/
    String firstName;
    String lastName;
    float taxRate = 0.2f;
    float gross = 0.0f;
    float tax = 0.0f;
    float net = 0.0f;
    float netPercent = 0.0f;

    //End Attributes


    /********************
     Methods
     ********************/
    public void menu() {

        displayFullName();

        int selection = 0;

        do {
            System.out.println(
                    "\nPlease make a selection:\n" +
                            "1) Calculate Gross Pay\n" +
                            "2) Calculate Tax\n" +
                            "3) Calculate Net Pay\n" +
                            "4) Calculate Net Percent\n" +
                            "5) Calculate All\n" +
                            "6) Display Employee\n" +
                            "7) Go Back\n");

            selection = new Scanner(System.in).nextInt();
            switch (selection) {
                case 1:
                    computeGross();
                    displayGross();
                    break;
                case 2:
                    computeTax();
                    displayTax();
                    break;
                case 3:
                    computeNet();
                    displayNet();
                    break;
                case 4:
                    computeNetPercent();
                    displayNetPercent();
                    break;
                case 5:
                    computeAll();
                    displayPayrollCalculations();
                    break;
                case 6:
                    displayEmployee();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Please enter a valid selection\n");
                    break;
            }
        } while (selection !=7);

    }

    public abstract void computeGross();

    protected void computeTax() {
        computeGross();
        this.tax = this.gross * this.taxRate;

    }

    protected void computeNet(){
        computeTax();
        this.net = this.gross - this.tax;

    }

    protected void computeNetPercent() {
        computeNet();
        this.netPercent = this.net / this.gross;

    }

    protected void computeAll() {
        computeNetPercent();
    }

    private void displayNetPercent() {
        System.out.println("Net Percent: " + this.netPercent);
    }

    private void displayNet() {

        System.out.println("Net: " + this.net);
    }

    private void displayTax() {

        System.out.println("Tax: " + this.tax);
    }

    private void displayGross() {

        System.out.println("Gross: " + this.gross);
    }

    public void displayPayrollCalculations() {
        displayGross();
        displayTax();
        displayNet();
        displayNetPercent();
    }

    protected abstract void displayEmployee();

    public void displayFullName() {
        System.out.println(
                "Employee: " + this.getFirstName() + " " + this.getLastName());
    }

    public void saveEmployeeReport() {
        computeAll();

        try{
            File file = new File(getFirstName() + "-" + getLastName() + ".txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file, false);
            BufferedWriter bw = new BufferedWriter(fw);
            {


                bw.write("***** Employee Info *****");
                bw.write("\nEmployee: " + this.getFirstName() + " " + this.getLastName());
                writePayDetail(bw);
                bw.write("***** Payroll Info  *****");
                bw.write(
                        "\nGross Pay: " + this.gross +
                                "\nTax: " + this.tax +
                                "\nNet: " + this.net +
                                "\nNet Percent: " + this.netPercent);
                bw.newLine();

            }


            bw.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public abstract void writePayDetail(Writer writer) throws IOException;



    /********************
     Properties
     ********************/

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
