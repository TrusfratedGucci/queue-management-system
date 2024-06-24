package com.iit.coursework.courseworkwithjavafx;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MyMethods {

    // returning the waitingList array for the GUI
    public FoodQueue[] getWaitingList() {
        return waitingList;
    }

    //returning a Map containing queue names as keys and corresponding FoodQueue arrays as values for the GUI.
    public Map<String, FoodQueue[]> getFoodQueues() {
        Map<String, FoodQueue[]> values = new HashMap<>();
        values.put("queue1", queue1);
        values.put("queue2", queue2);
        values.put("queue3", queue3);
        return values;
    }

    private final FoodQueue[] queue1 = new FoodQueue[2];
    private final FoodQueue[] queue2 = new FoodQueue[3];
    private final FoodQueue[] queue3 = new FoodQueue[5];


    static int size = 10;
    private static final FoodQueue[] waitingList = new FoodQueue[size];


    // Creating below arrays to build the display menu format
    String[] display1 = new String[2];
    String[] display2 = new String[3];
    String[] display3 = new String[5];

    int burgerStock = 50;

    //number of customers served in queue1
    int servedCustomers1 = 0;

    //number of customers served in queue2
    int servedCustomers2 = 0;

    //number of customers served in queue3
    int servedCustomers3 = 0;

    //number of burgers sold in queue1
    int soldBurgers1 = 0;

    //number of burgers sold in queue2
    int soldBurgers2 = 0;

    //number of burgers sold in queue3
    int soldBurgers3 = 0;


    //Variables to maintain the front and rear pointers of the circular queue
    int front = -1;

    int rear = -1;

    public void viewAllQueues() {

        // Calling method to store elements to the arrays
        displayArrayFilling(display1, display2, display3);


        System.out.println();
        System.out.println("******************");
        System.out.println("*    Cashiers    *");
        System.out.println("******************");

        int i = 0;

        while (i < 2) {
            // Printing the first 2 rows
            System.out.format("%5s%5s%5s%n", display1[i], display2[i], display3[i]);
            i++;
        }

        while (i < 3) {
            // Printing the 3rd row
            System.out.format("%10s%5s%n", display2[i], display3[i]);
            i++;
        }

        while (i < 5) {
            // Printing the last 2 rows
            System.out.format("%15s%n", display3[i]);
            i++;
        }
    }


    public void displayArrayFilling(String[] display1, String[] display2, String[] display3) {

        // Storing appropriate elements to display1 array when conditions are met
        for (int i = 0; i < 2; i++) {
            if (queue1[i] == null) {
                display1[i] = "X";
            } else {
                display1[i] = "O";
            }
        }

        // Storing appropriate elements to display2 array when conditions are met
        for (int i = 0; i < 3; i++) {
            if (queue2[i] == null) {
                display2[i] = "X";
            } else {
                display2[i] = "O";
            }
        }

        // Storing appropriate elements to display3 array when conditions are met
        for (int i = 0; i < 5; i++) {
            if (queue3[i] == null) {
                display3[i] = "X";
            } else {
                display3[i] = "O";
            }
        }

    }


    public void viewAllEmptyQueues() {

        int i = 0;

        boolean found1 = false;  // Track if empty slot found in queue1 array
        boolean found2 = false; // Track if empty slot found in queue2 array
        boolean found3 = false; // Track if empty slot found in queue3 array

        while (i < 2) {
            if (queue1[i] == null) {
                found1 = true; // Empty slot found in cashier1
                break;
            } else {
                i++;
            }
        }

        while (i < 3) {
            if (queue2[i] == null) {
                found2 = true; // Empty slot found in cashier2
                break;
            } else {
                i++;
            }
        }

        while (i < 5) {
            if (queue3[i] == null) {
                found3 = true; // Empty slot found in cashier3
                break;
            } else {
                i++;
            }
        }

        // Filling the slots of arrays with appropriate elements when conditions are met
        displayArrayFilling(display1, display2, display3);


        System.out.println();
        System.out.println("******************");
        System.out.println("*    Cashiers    *");
        System.out.println("******************");


        for (i = 0; i < 5; i++) {
            if (i < display1.length && found1) {
                // Printing values from array1
                System.out.format("%5s", display1[i]);

            } else {
                System.out.format("%5s", ""); // Empty space
            }

            if (i < display2.length && found2) {
                // Printing values from array2
                System.out.format("%5s", display2[i]);

            } else {
                System.out.format("%5s", ""); // Empty space
            }

            if (i < display3.length && found3) {
                // Printing values from array3
                System.out.format("%5s", display3[i]);

            } else {
                System.out.format("%5s", ""); // Empty space
            }

            System.out.println();
        }


    }



    public void addCustomerToAQueue() {
        FoodQueue foodie = new FoodQueue(); // Creating a new object of the FoodQueue class
        Scanner input = new Scanner(System.in);


        System.out.println("\nEnter customer first name: "); // storing the customer first name entered by the user
        foodie.customerInfo.firstName = input.nextLine();

        System.out.println("\nEnter customer last name: "); // storing the customer last name entered by the user
        foodie.customerInfo.lastName = input.nextLine();

        System.out.println("\nEnter the number of burgers required by the customer: "); // storing the no.of burgers entered by the user
        foodie.customerInfo.numberOfBurgers = input.nextInt();


        // Checking if all queues are full
        if (queue1[1] != null && queue2[2] != null && queue3[4] != null) {
            System.out.println("The queues are full!.");
            addingToWaitingQueue(foodie);


        } else {
            int index1 = queue1.length - 1;
            int index2 = queue2.length - 1;
            int index3 = queue3.length - 1;


            for (int i = 0; i < 2; i++) {
                if (queue1[i] == null) {
                    index1 = i;
                    break;
                }
            }

            for (int i = 0; i < 3; i++) {
                if (queue2[i] == null) {
                    index2 = i;
                    break;
                }
            }

            for (int i = 0; i < 5; i++) {
                if (queue3[i] == null) {
                    index3 = i;
                    break;
                }
            }


            // Finding the shortest queue among the available positions
            int shortest = Math.min(index1, Math.min(index2, index3));


            // Adding the customer to the shortest queue
            if (shortest == index1) {
                if (queue1[index1] != null && queue2[index2] != null) {
                    if (queue3[index3] != null) {
                        System.out.println("The queues are full!");
                    } else {
                        queue3[index3] = foodie;
                        System.out.println("Customer added to queue three!");
                    }

                } else if (queue1[index1] != null ) {
                    shortest = Math.min(index2, index3);
                    if (shortest == index2) {
                        queue2[index2] = foodie;
                        System.out.println("Customer added to queue two!");
                    } else {
                        queue3[index3] = foodie;
                        System.out.println("Customer added to queue three!");
                    }

                } else  {
                    queue1[index1] = foodie;
                    System.out.println("Customer added to queue one!");
                }


            } else if (shortest == index2) {
                queue2[index2] = foodie;
                System.out.println("Customer added to queue two!");


            } else {
                queue3[index3] = foodie;
                System.out.println("Customer added to queue three!");
            }



        }

    }




    public void addingToWaitingQueue(FoodQueue foodie) {

        // Checking if the queue is full
        int nextRear = (rear + 1) % size;
        if (nextRear == front) {
            System.out.println("Waiting queue is full.");
        } else {
            if (front == -1) {
                front = 0;
            }
            rear = nextRear;
            waitingList[rear] = foodie;
            System.out.println("Adding Customer to the waiting queue!");
        }
    }


    public void removeCustomerFromAQueue() {
        Scanner input = new Scanner(System.in);

        // Getting the user input regarding the queue
        System.out.println("Enter the queue the customer should be removed from: 1,2 or 3? ");
        String queue = input.nextLine();

        String customer;

        // Determining the queue the customer get removed
        switch (queue) {
            case "1" -> {
                // Determining which customer in the queue 1 is getting removed
                System.out.println("Enter which customer should be removed: 1 or 2? ");
                customer = input.nextLine();
                switch (customer) {
                    case "1" -> {
                        //Determining whether the spot is empty or not
                        if (queue1[0] != null) {
                            queue1[0] = null; // Removing customer 1 from queue 1
                            System.out.println("Customer removed from the queue one first spot!");

                            // Shifting forward the remaining customers to fill the space left by removed customer
                            bubbleSort(queue1);
                        } else {
                            System.out.println("There are no customers in the spot. ");
                        }

                    }
                    case "2" -> {
                        //Determining whether the spot is empty or not
                        if (queue1[1] != null) {
                            queue1[1] = null; // Removing customer 2 from queue 1
                            System.out.println("Customer removed from the queue one last spot!");
                        } else {
                            System.out.println("There are no customers in the spot. ");
                        }

                    }
                    default -> System.out.println("What you entered is not clear.");
                }
            }
            case "2" -> {
                // Determining which customer in the queue 2 is getting removed
                System.out.println("Enter which customer should be removed: 1, 2, or 3? ");
                customer = input.nextLine();
                switch (customer) {
                    case "1" -> {
                        //Determining whether the spot is empty or not
                        if (queue2[0] != null) {
                            queue2[0] = null; // Removing customer 1 from queue 2
                            System.out.println("Customer removed from the queue two first spot!");

                            // Shifting forward the remaining customers to fill the space left by removed customer
                            bubbleSort(queue2);
                        } else {
                            System.out.println("There are no customers in the spot. ");
                        }

                    }
                    case "2" -> {
                        //Determining whether the spot is empty or not
                        if (queue2[1] != null) {
                            queue2[1] = null; // Removing customer 2 from queue 2
                            System.out.println("Customer removed from the queue two second spot!");

                            // Shifting forward the remaining customers to fill the space left by removed customer
                            bubbleSort(queue2);
                        } else {
                            System.out.println("There are no customers in the spot. ");
                        }

                    }
                    case "3" -> {
                        //Determining whether the spot is empty or not
                        if (queue2[2] != null) {

                            queue2[2] = null; // Removing customer 3 from queue 2
                            System.out.println("Customer removed from the queue two last spot!");

                        } else {
                            System.out.println("There are no customers in the spot. ");
                        }

                    }
                    default -> System.out.println("What you entered is not clear.");
                }
            }
            case "3" -> {
                // Determining which customer in the queue 3 is getting removed
                System.out.println("Enter which customer should be removed: 1, 2, 3, 4, or 5? ");
                customer = input.nextLine();
                switch (customer) {
                    case "1" -> {
                        //Determining whether the spot is empty or not
                        if (queue3[0] != null) {

                            queue3[0] = null; // Removing customer 1 from queue 3
                            System.out.println("Customer removed from queue three, first spot!");

                            // Shifting forward the remaining customers to fill the space left by removed customer
                            bubbleSort(queue3);

                        } else {
                            System.out.println("There are no customers in the spot. ");
                        }

                    }
                    case "2" -> {
                        //Determining whether the spot is empty or not
                        if (queue3[1] != null) {

                            queue3[1] = null; // Removing customer 2 from queue 3
                            System.out.println("Customer removed from queue three, second spot!");

                            // Shifting forward the remaining customers to fill the space left by removed customer
                            bubbleSort(queue3);

                        } else {
                            System.out.println("There are no customers in the spot. ");
                        }

                    }
                    case "3" -> {
                        //Determining whether the spot is empty or not
                        if (queue3[2] != null) {

                            queue3[2] = null; // Removing customer 3 from queue 3
                            System.out.println("Customer removed from queue three, third spot!");

                            // Shifting forward the remaining customers to fill the space left by removed customer
                            bubbleSort(queue3);

                        } else {
                            System.out.println("There are no customers in the spot. ");
                        }

                    }
                    case "4" -> {
                        //Determining whether the spot is empty or not
                        if (queue3[3] != null) {

                            queue3[3] = null; // Removing customer 4 from queue 3
                            System.out.println("Customer removed from queue three, fourth spot!");

                            // Shifting forward the remaining customers to fill the space left by removed customer
                            bubbleSort(queue3);

                        } else {
                            System.out.println("There are no customers in the spot. ");
                        }

                    }
                    case "5" -> {
                        //Determining whether the spot is empty or not
                        if (queue3[4] != null) {

                            queue3[4] = null; // Removing customer 5 from queue 3
                            System.out.println("Customer removed from queue three, last spot!");

                        } else {
                            System.out.println("There are no customers in the spot. ");
                        }

                    }
                    default -> System.out.println("What you entered is not clear.");
                }
            }
        }

    }



    public void removeAServedCustomer() {

        Scanner input = new Scanner(System.in);


        // Getting the user input regarding the queue
        System.out.println("Enter from which queue a served customer should be removed: 1, 2, or 3? ");
        String queue = input.nextLine(); // Read and store the queue number entered by the user


        // determining whether queues are full.
        boolean queuesFull = queue1[1] != null && queue2[2] != null && queue3[4] != null;




        // Determining whether the burger stock is 0
        if (burgerStock != 0) {

            // Determining the queue from which a served customer should be removed
            switch (queue) {
                case "1" -> {
                    // Determining whether queue is empty
                    if (queue1[0] != null){

                        //Checking if there are enough burgers in stock to serve the customer
                        if (burgerStock > queue1[0].customerInfo.numberOfBurgers) {

                            burgerStock -= queue1[0].customerInfo.numberOfBurgers; // Reducing the burger stock
                            soldBurgers1 += queue1[0].customerInfo.numberOfBurgers; // Storing number of burgers sold
                            servedCustomers1 += 1; // Storing the number of customers served
                            queue1[0] = null; // Removing the served customer from queue 1
                            System.out.println("A served customer has been removed from queue one!"); // Printing a message indicating the removal
                            bubbleSort(queue1); // Sorting the remaining customers in queue 1 using the bubble sort algorithm

                        } else {
                            System.out.println(queue1[0].customerInfo.numberOfBurgers + "burgers are required by the customer. The number of burgers available are less than what required. Please restock and try again");
                        }

                    } else {
                        System.out.println("There are no customers in queue one. ");
                    }

                }
                case "2" -> {
                    // Determining whether queue is empty
                    if (queue2[0] != null) {

                        //Checking if there are enough burgers in stock to serve the customer
                        if (burgerStock > queue2[0].customerInfo.numberOfBurgers) {

                            burgerStock -= queue2[0].customerInfo.numberOfBurgers; // Reducing the burger stock
                            soldBurgers2 += queue2[0].customerInfo.numberOfBurgers; // Storing number of times burgers are sold
                            servedCustomers2 += 1; // Storing the number of customers served
                            queue2[0] = null; // Removing the served customer from queue 2
                            System.out.println("A served customer has been removed from queue two!"); // Printing a message indicating the removal
                            bubbleSort(queue2); // Sorting the remaining customers in queue 1 using the bubble sort algorithm

                        } else {
                            System.out.println(queue2[0].customerInfo.numberOfBurgers + "burgers are required by the customer. The number of burgers available are less than what required. Please restock and try again");
                        }


                    } else {
                        System.out.println("There are no customers in queue two.");
                    }

                }
                case "3" -> {
                    // Determining whether queue is empty
                    if (queue3[0] != null) {

                        //Checking if there are enough burgers in stock to serve the customer
                        if (burgerStock > queue3[0].customerInfo.numberOfBurgers) {

                            burgerStock -= queue3[0].customerInfo.numberOfBurgers; // Reducing the burger stock
                            soldBurgers3 += queue3[0].customerInfo.numberOfBurgers; // Storing number of times burgers are sold
                            servedCustomers3 += 1; // Storing the number of customers served
                            queue3[0] = null; // Removing the served customer from queue 3
                            System.out.println("A served customer has been removed from queue three!"); // Printing a message indicating the removal
                            bubbleSort(queue3); // Sorting the remaining customers in queue 1 using the bubble sort algorithm

                        } else {
                            System.out.println(queue3[0].customerInfo.numberOfBurgers + "burgers are required by the customer. The number of burgers available are less than what required. Please restock and try again");
                        }

                    } else  {
                        System.out.println("There are no customers in queue three.");
                    }

                }
            }

            // Warning the user if the burger stock is 0
        } else {
            System.out.println("There are no burgers left! Please restock.");
        }


        // Getting the next customer from the waiting list
        FoodQueue foodie = removingFromWaitingQueue();

        // Checking if all queues were full and if there's a customer from the waiting list
        if (queuesFull && foodie != null) {

            if (queue1[1] == null) {
                queue1[1] = foodie;
                System.out.println("New customer added to queue one from waiting list.");
            } else if (queue2[2] == null) {
                queue2[2] = foodie;
                System.out.println("New customer added to queue two from waiting list.");
            } else if (queue3[4] == null){
                queue3[4] = foodie;
                System.out.println("New customer added to queue three from waiting list.");
            }
        }

    }


    public FoodQueue removingFromWaitingQueue() {
        if (front == -1) {
            // Queue is empty
            System.out.println("Waiting queue is empty.");
            return null;
        }

        FoodQueue deQueuedCustomer = waitingList[front];
        waitingList[front] = null;

        if (front == rear && waitingList[front] != null) {
            // Resetting 'front' and 'rear' to -1 to indicate an empty queue
            front = -1;
            rear = -1;
        } else {
            // Moving 'front' to the next position
            front = (front + 1) % size;
        }

        return deQueuedCustomer;
    }




    // Creating this method to shift forward the remaining customers
    // to fill the space left by removed customer
    public void bubbleSort(FoodQueue[] array) {

        int length = array.length;


        // loop to access each array element
        for (int i = 0; i < length - 1; i++)

            // loop to compare array elements
            for (int j = 0; j < length - i - 1; j++)

                // checking whether a customer is available
                if (array[j] == null) {

                    // swapping if a customer is not available

                    FoodQueue temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }

    }



    public void viewCustomerSorted() {
        ArrayList<String> fullNames = new ArrayList<>();


        for (int i = 0; i < 2; i++) {
            if (queue1[i] != null) {
                String fullName = queue1[i].customerInfo.firstName + " " + queue1[i].customerInfo.lastName;
                fullNames.add(i, fullName);
            }
        }

        for (int i = 0; i < 3; i++) {
            if (queue2[i] != null) {
                String fullName = queue2[i].customerInfo.firstName + " " + queue2[i].customerInfo.lastName;
                fullNames.add(i, fullName);
            }
        }


        for (int i = 0; i < 5; i++) {
            if (queue3[i] != null) {
                String fullName = queue3[i].customerInfo.firstName + " " + queue3[i].customerInfo.lastName;
                fullNames.add(i, fullName);
            }
        }



        for (int i = 0; i < fullNames.size() - 1; i++) {
            for (int j = i + 1; j < fullNames.size(); j++) {
                // Compares each e of the arraylist to all the remaining elements
                int value = compareStrings(fullNames.get(i), fullNames.get(j));
                //compares each element of the arraylist to all the remaining elements
                if (value > 0) {
                    //swapping arraylist elements
                    String temp = fullNames.get(i);
                    fullNames.set(i, fullNames.get(j));
                    fullNames.set(j, temp);
                }
            }
        }

        //prints the sorted arraylist in ascending order
        System.out.println(fullNames);

    }




    int compareStrings(String s, String t){

        int minLength = Math.min(s.length(), t.length());

        for (int i = 0; i < minLength; i++) {
            if (s.charAt(i) < t.charAt(i)) {
                return -1; // s is lexicographically smaller than t
            } else if (s.charAt(i) > t.charAt(i)) {
                return 1; // s is lexicographically greater than t
            }
        }

        if (s.length() < t.length()) {
            return -1; // s is a proper prefix of t
        } else if (s.length() > t.length()) {
            return 1; // t is a proper prefix of s
        }

        return 0; // s and t are equal
    }



    public void storingDataIntoFile() {



        int totalBurgersSold = soldBurgers1 + soldBurgers2 + soldBurgers3;
        int totalServedCustomers = servedCustomers1 + servedCustomers2 + servedCustomers3;

        try {
            FileWriter writeData = new FileWriter("programData.txt");

            writeData.write("Foodies Fave Food center\n\n\n");
            writeData.write("\nBurger details");
            writeData.write("\n\nNumber of burgers sold in first queue: " + soldBurgers1);
            writeData.write("\nNumber of burgers sold in second queue: " + soldBurgers2);
            writeData.write("\nNumber of burgers sold in third queue: " + soldBurgers3);
            writeData.write("\nNumber of burgers sold: " + totalBurgersSold);
            writeData.write("\nNumber of burgers left: " + burgerStock);
            writeData.write("\n\nCustomer details");
            writeData.write("\n\nNumber of customers served in first queue: " + servedCustomers1);
            writeData.write("\nNumber of customers served in second queue: " + servedCustomers2);
            writeData.write("\nNumber of customers served in third queue: " + servedCustomers3);
            writeData.write("\nTotal customers served: " + totalServedCustomers);
            writeData.close();
            System.out.println("Data storing is successful");


        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }



    }



    public  void loadProgramData() {

        try {

            File dataFile = new File("programData.txt");
            Scanner programData = new Scanner(dataFile);
            while (programData.hasNextLine()) {
                String data = programData.nextLine();
                System.out.println(data);
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
    }



    public void viewRemainingBurgers() {
        System.out.println(burgerStock + " burgers available in the stock"); // Display the current burger stock

        if (burgerStock <= 10) {  // Display a warning message if the stock is 10 or fewer
            System.out.println("The stock is running low. please restock soon!");
        }
    }




    public void addBurgersToStock() {
        Scanner input = new Scanner(System.in); // Create a Scanner object to read user input


        System.out.println("Enter the number of burgers added to stock: ");
        int burgerNumber = input.nextInt(); // Read and store the number of burgers entered by the user

        // Determining whether new stock with the old stock exceeds the threshold
        if ((burgerNumber + burgerStock) > 50) {
            System.out.println("Couldn't proceed. That is too much burgers to the stock.");
        } else {
            burgerStock += burgerNumber; // Add the entered number of burgers to the current burger stock

            // Display a message confirming the successful addition of burgers
            System.out.println(burgerNumber + " burgers added to the stock!");
        }
    }



    public void viewIncomeOfEachQueue() {

        final int burgerPrice = 650;

        System.out.println();
        System.out.println("Income of first queue: " + burgerPrice * soldBurgers1 );
        System.out.println("Income of Second queue: " + burgerPrice * soldBurgers2 );
        System.out.println("Income of third queue: " + burgerPrice * soldBurgers3 );

    }
}


