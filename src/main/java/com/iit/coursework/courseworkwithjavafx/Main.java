package com.iit.coursework.courseworkwithjavafx;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MyMethods choose = new MyMethods();
        Scanner input = new Scanner(System.in);

        String option;

        loop:
        while (true) {

            System.out.println("""
                    \n
                    **** Console Menu ****
                                    
                    Enter 100 or VFQ: View all Queues.
                    Enter 101 or VEQ: View all Empty Queues.
                    Enter 102 or ACQ: Add Customers to a Queue.
                    Enter 103 or RCQ: Remove a Customer from a Queue. (From a specific location)
                    Enter 104 or PCQ: Remove a Served Customer.
                    Enter 105 or VCS: View Customers Sorted in alphabetical order.
                    Enter 106 or SPD: Store Program Data into a file.
                    Enter 107 or LPD: Load Program Data from file.
                    Enter 108 or STK: View Remaining burgers Stock.
                    Enter 109 or AFS: Add burgers to Stock.
                    Enter 110 or IFQ: View the income of each queue.
                    Enter 112 or GUI: Open the GUI.
                    999 or EXT: Exit the Program.
                    """);

            option = input.nextLine();


            switch (option) {
                case "100", "VFQ" -> choose.viewAllQueues();
                case "101", "VEQ" -> choose.viewAllEmptyQueues();
                case "102", "ACQ" -> choose.addCustomerToAQueue();
                case "103", "RCQ" -> choose.removeCustomerFromAQueue();
                case "104", "PCQ" -> choose.removeAServedCustomer();
                case "105", "VCS" -> choose.viewCustomerSorted();
                case "106", "SPD" -> choose.storingDataIntoFile();
                case "107", "LPD" -> choose.loadProgramData();
                case "108", "STK" -> choose.viewRemainingBurgers();
                case "109", "AFS" -> choose.addBurgersToStock();
                case "110", "IFQ" -> choose.viewIncomeOfEachQueue();
                case "112", "GUI" -> CourseworkApplication.launch(CourseworkApplication.class, args);
                case "999", "EXT" -> {
                    System.out.println("You have exited the program.");
                    break loop;
                }

                default -> System.out.println("What you entered was not clear.");
            }
        }
    }
}
