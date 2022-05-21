module tictactoe {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.management;

    opens tictactoe to javafx.fxml;
    exports tictactoe;
    exports tictactoe.guicontrollers;
    opens tictactoe.guicontrollers to javafx.fxml;
}