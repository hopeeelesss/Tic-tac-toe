module tictactoe {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.management;
    requires static lombok;
    exports tictactoe;
    exports tictactoe.controller;
    opens tictactoe.controller to javafx.fxml;
    exports tictactoe.controller.impl;
    opens tictactoe.controller.impl to javafx.fxml;
}