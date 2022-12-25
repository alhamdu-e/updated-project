import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginPage extends Application {

    @Override
    public void start(Stage st) throws IOException {
        Tooltip tr,tr1;
        Group g=new Group();

        Label us=new Label("Username");
        us.setLayoutX(0);
        us.setLayoutY(50);
        us.setFont(Font.font("verdana",FontWeight.BOLD,22));
        TextField tt=new TextField();
        tr=new Tooltip("Enter  Username");
        tr.setFont(Font.font("new times roman",FontWeight.BOLD,14));
        tt.setTooltip(tr);
        tt.setLayoutX(130);
        tt.setLayoutY(50);
        tt.setPrefWidth(250);
        tt.setFont(Font.font("verdana",FontWeight.BOLD,14));
        Label p=new Label("Password");
        p.setLayoutX(0);
        p.setLayoutY(100);
        p.setFont(Font.font("verdana",FontWeight.BOLD,22));
        PasswordField ps=new PasswordField();
        tr1=new Tooltip("Enter Password");
        tr1.setFont(Font.font("new times roman",FontWeight.BOLD,14));
        ps.setTooltip(tr1);
        ps.setLayoutX(130);
        ps.setLayoutY(100);
        ps.setPrefWidth(250);
        ps.setFont(Font.font("verdana",FontWeight.BOLD,14));
        Button b=new Button("Submit");
        b.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBcon db = new DBcon();
                Connection cn = db.conMethod();
                Statement p;
                ResultSet res;
                String stt = tt.getText();
                String psss = ps.getText();
                String val = "Select* from verify where username='" + stt + "' and password='" + psss + "'";
                try {
                    p = cn.createStatement();
                    res = p.executeQuery(val);
                    try {
                        if (res.next()) {
                            Homepage hm = new Homepage();
                            hm.homepage();
                            st.close();

                        } else {
                            tt.setFont(Font.font("verdana", FontWeight.BOLD, 12));
                            tt.setText("invalid username or password!");
                            ps.setFont(Font.font("verdana", FontWeight.BOLD, 14));
                            tt.setStyle("-fx-text-inner-color: red;");
                            ps.setStyle("-fx-text-inner-color: red;");
                        }
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        b.setLayoutX(70);
        b.setLayoutY(200);
        b.setFont(Font.font("verdana",FontWeight.BOLD,18));
        Button bb=new Button("Cancel");
        bb.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
               tt.setText("");
               ps.setText("");
                tt.setStyle("-fx-text-inner-color: black;");
                ps.setStyle("-fx-text-inner-color: black;");

            }
        });
        bb.setLayoutX(240);
        bb.setLayoutY(200);
        bb.setFont(Font.font("verdana",FontWeight.BOLD,18));
        g.getChildren().addAll(us,p,tt,ps,b,bb);
        Scene sc=new Scene(g,450,300,Color.CHOCOLATE);
        st.setTitle("Login Page");
        st.setScene(sc);

        st.setResizable(false);
        st.show();

    }
    public static void main(String[] args) {

        launch(args);
    }
}