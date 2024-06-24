package com.iit.coursework.courseworkwithjavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.HashMap;
import java.util.Map;

public class CourseworkController {
    private MyMethods myMethods;

    @FXML
    private TextField customerNameField;

    @FXML
    private Label queueLabel;

    @FXML
    private Label firstNameLabel;

    @FXML
    private Label lastNameLabel;

    @FXML
    private Label burgersOrderedLabel;

    @FXML
    private Label placeInQueueLabel;

    @FXML
    private void searchCustomer() throws Exception {
        String customerName = customerNameField.getText();

        // Simulating customer details retrieval
        Customer customer = findCustomerDetails(customerName);

        customerNameField.setText("");

        if (customer != null) {
            queueLabel.setText(customer.getQueue());
            placeInQueueLabel.setText(String.valueOf(customer.getPlaceInTheQueue()));
            firstNameLabel.setText(customer.getFirstName());
            lastNameLabel.setText(customer.getLastName());
            burgersOrderedLabel.setText(String.valueOf(customer.getBurgersOrdered()));
        } else {
            // Customer not found
            queueLabel.setText("");
            placeInQueueLabel.setText("");
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            burgersOrderedLabel.setText("");

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Customer Not Found");
            alert.setHeaderText(null);
            alert.setContentText("No customer details found for the searched name.");
            alert.showAndWait();
        }
    }


    // customer details retrieval
    private Customer findCustomerDetails(String name) throws Exception {
        try {
            Map<String, FoodQueue[]> foodQueues = myMethods.getFoodQueues() == null ? new HashMap<>() : myMethods.getFoodQueues();
            FoodQueue[] queue1 = foodQueues.get("queue1");
            FoodQueue[] queue2 = foodQueues.get("queue2");
            FoodQueue[] queue3 = foodQueues.get("queue3");

            for (int i = 0; i < queue1.length; i++) {
                if (queue1[i].customerInfo.firstName.concat(" ").concat(queue1[1].customerInfo.lastName).equalsIgnoreCase(name)){
                    return new Customer("Queue 1", i, queue1[i].customerInfo.firstName, queue1[i].customerInfo.lastName, queue1[i].customerInfo.numberOfBurgers);
                }
            }

            for (int i = 0; i < queue2.length; i++) {
                if (queue2[i].customerInfo.firstName.concat(" ").concat(queue2[1].customerInfo.lastName).equalsIgnoreCase(name)){
                    return new Customer("Queue 2", i, queue2[i].customerInfo.firstName, queue2[i].customerInfo.lastName, queue2[i].customerInfo.numberOfBurgers);
                }
            }

            for (int i = 0; i < queue3.length; i++) {
                if (queue3[i].customerInfo.firstName.concat(" ").concat(queue3[1].customerInfo.lastName).equalsIgnoreCase(name)){
                    return new Customer("Queue 3", i, queue3[i].customerInfo.firstName, queue3[i].customerInfo.lastName, queue3[i].customerInfo.numberOfBurgers);
                }
            }

            FoodQueue[] waitingQueue = myMethods.getWaitingList();

            for (int i = 0; i < waitingQueue.length; i++) {
                if (waitingQueue[i].customerInfo.firstName.concat(" ").equals(waitingQueue[1].customerInfo.lastName)){
                    return new Customer("Waiting List", i, waitingQueue[i].customerInfo.firstName, waitingQueue[i].customerInfo.lastName, waitingQueue[i].customerInfo.numberOfBurgers);
                }
            }

            return null;

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Occurred!");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
            throw new Exception(e.getMessage());
        }
    }


    public static class Customer {

        private final String queue;
        private final int placeInTheQueue;
        private final String firstName;
        private final String lastName;
        private final int burgersOrdered;

        public Customer(String queue, int placeInTheQueue, String firstName, String lastName, int burgersOrdered) {
            this.queue = queue;
            this.placeInTheQueue = placeInTheQueue;
            this.firstName = firstName;
            this.lastName = lastName;
            this.burgersOrdered = burgersOrdered;
        }

        public String getQueue() {
            return queue;
        }

        public int getPlaceInTheQueue() {
            return placeInTheQueue;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getBurgersOrdered() {
            return burgersOrdered;
        }
    }
}
