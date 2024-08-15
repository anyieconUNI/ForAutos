module co.forautos {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.mapstruct;


    opens co.edu.uniquindio.forautos to javafx.fxml;
    exports co.edu.uniquindio.forautos;
    exports co.edu.uniquindio.forautos.viewController;
    opens co.edu.uniquindio.forautos.viewController to javafx.fxml;
    opens co.edu.uniquindio.forautos.controller;
    opens co.edu.uniquindio.forautos.mapping.dto;
    opens co.edu.uniquindio.forautos.mapping.mappers;
    opens co.edu.uniquindio.forautos.model;

}