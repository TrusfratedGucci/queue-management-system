module com.iit.coursework.courseworkwithjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.iit.coursework.courseworkwithjavafx to javafx.fxml;
    exports com.iit.coursework.courseworkwithjavafx;
}