
# Queue management system

This project is a queue management system for a fictional fast food restaurant called Foodie Fave which was done as accoursework submission for my university. The system manages three queues of customers waiting for their orders. Each queue can hold a different number of customers and the system includes additional functionality for managing a waiting list, sorting customers, and displaying customer information via a GUI.


## Features

- View All Queues (100 or VFQ):
    Displays the current status of all queues.
- View All Empty Queues (101 or VEQ):
    Displays all queues that are currently empty.
- Add Customer to a Queue (102 or ACQ):
    Adds a customer to the queue with the minimum length. If all queues are full, the customer is added to the waiting list.
- Remove a Customer from a Queue (103 or RCQ):
    Removes a customer from a specific location in the queue.
- Remove a Served Customer (104 or PCQ):
    Removes the first customer in the queue. If there are customers in the waiting list, the next customer is moved to the queue.
- View Customers Sorted Alphabetically (105 or VCS):
    Displays all customers sorted in alphabetical order without using a library sort routine.
- Store Program Data into File (106 or SPD):
    Saves the current state of the program data to a file.
- Load Program Data from File (107 or LPD):
    Loads the program data from a file.
- View Remaining Burgers Stock (108 or STK):
    Displays the remaining number of burgers in stock.
- Add Burgers to Stock (109 or AFS):
    Adds burgers to the current stock.
- Exit the Program (999 or EXT):
    Exits the program.
- Print Income for Each Queue (110 or IFQ):
    Displays the total income for each queue based on the number of burgers sold (price per burger: 650).
- Graphical User Interface (112 or GUI):
    Launches the GUI for viewing and managing the queue system.


## Classes
### FoodQueue Class
- Manages a single food queue.
- Holds information about customers in the queue.
- Handles queue operations such as adding, removing, and displaying customers.

### Customer Class
- Represents a customer.
- Contains information about the customer such as first name, second name, and the number of burgers required.
## Queue Management
- The system manages three queues in parallel.
- Each queue has a different maximum capacity (2, 3, 5 customers respectively).
- When adding a customer, the system selects the queue with the minimum length.


## Waiting List
- If all queues are full, new customers are added to a waiting list.
- When a customer is removed from the queue, the next customer from the waiting list is moved to the queue.
## Graphical User Interface (JavaFX)
- Displays the status of the food queues and the waiting list.
- Allows the operator to search for customer details.
- GUI can be launched via the command prompt using the command 112 or GUI.

Run -> Run 'Main'.
Usage
Run the main class to start the command-line interface (CLI) for the queue management system.
Use the commands listed in the features section to interact with the system.
To launch the GUI, use the command 112 or GUI in the CLI.
