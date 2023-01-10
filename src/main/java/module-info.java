module com.example.tnpslab {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires flanagan;

    opens com.example.tnpslab to javafx.fxml;
    exports com.example.tnpslab;
}