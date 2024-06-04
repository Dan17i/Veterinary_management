module co.edu.uniquindio.gestionveterinaria.gestionveterinaria {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.gestionveterinaria.gestionveterinaria to javafx.fxml;
    exports co.edu.uniquindio.gestionveterinaria.gestionveterinaria;
}