package edu.umsl;

import java.util.Scanner;

public class EmployeeFactory {

    public Employee createEmployee() {

        Scanner inputScanner = new Scanner(System.in);

        int employeeType = 0;
        Employee e = null;

        System.out.println("Select employee type:");
        System.out.println("1. Hourly");
        System.out.println("2. Salary");
        System.out.println("3. Commission");

        employeeType = inputScanner.nextInt();

        switch(employeeType) {
            case 1:
                e = createHourlyEmployee();
                break;
            case 2:
                e = createSalaryEmployee();
                break;
            case 3:
                e = createCommissionEmployee();
                break;
            default:
                System.out.println("Please select one of the indicated options");
                break;
        }

        return e;
    }

    private Employee createHourlyEmployee() {
        Scanner inputScanner = new Scanner(System.in);
        String firstName;
        String lastName;
        int hoursWorked;
        float payRate;

        System.out.println("Enter first name:");
        firstName = inputScanner.nextLine();

        System.out.println("Enter last name:");
        lastName = inputScanner.nextLine();

        System.out.println("Enter hours worked:");
        hoursWorked = inputScanner.nextInt();

        System.out.println("Enter pay rate:");
        payRate = inputScanner.nextFloat();

        return new HourlyEmployee(firstName, lastName, hoursWorked, payRate);
    }

    private Employee createSalaryEmployee() {
        Scanner inputScanner = new Scanner(System.in);
        String firstName;
        String lastName;
        float grossSalary = 0;

        System.out.println("Enter first name:");
        firstName = inputScanner.nextLine();

        System.out.println("Enter last name:");
        lastName = inputScanner.nextLine();

        int salaryType = 0;
        System.out.println("Indicate salary type:");
        System.out.println("1. Staff");
        System.out.println("2. Executive");
        salaryType = inputScanner.nextInt();

        Employee e = null;
        switch (salaryType) {
            case 1:
                e = new SalaryEmployee(firstName, lastName, 50000);
                break;
            case 2:
                e = new SalaryEmployee(firstName, lastName, 100000);
                break;
            default:
                System.out.println("Please select one of the indicated options");
                break;
        }

        return e;
    }

    private Employee createCommissionEmployee() {
        Scanner inputScanner = new Scanner(System.in);
        String firstName;
        String lastName;
        int itemsSold = 0;
        float itemPrice = 0f;

        System.out.println("Enter first name:");
        firstName = inputScanner.nextLine();

        System.out.println("Enter last name:");
        lastName = inputScanner.nextLine();

        System.out.println("Enter items sold:");
        itemsSold = inputScanner.nextInt();

        System.out.println("Enter price per item:");
        itemPrice = inputScanner.nextFloat();

        return new CommissionEmployee(firstName, lastName, itemsSold, itemPrice);
    }

}
