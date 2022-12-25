import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.DriverManager;
public class DBcon {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String USERNAME = "AHLAMA";
    private static final String PASSWORD = "1234";
    Connection connection = null;
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    public Connection conMethod() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (Exception e) {


            alert.setContentText(e.toString());
        }

        return connection;
    }

}
