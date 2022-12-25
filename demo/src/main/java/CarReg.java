import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.Statement;
import java.util.concurrent.atomic.AtomicLong;

public class CarReg {
    TextField t,t1,t2,t3,t4;
    Label l,l1,l2,l3,l4;
    Button b,b1,b2,b3;
    String st="C00";
    String stt,st1,st2,st3,st4;

    public  void carreg() {
        Stage stage = new Stage();
        b2=new Button("Homepage");
        b2.setLayoutX(430);
        b2.setLayoutY(10);
        b2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Homepage hm1=new Homepage();
                hm1.homepage();
                stage.close();
            }
        });
        Long id1= Long.valueOf(0);
        Group gr = new Group();
        Scene sc = new Scene(gr, 530, 500, Color.CHOCOLATE);
        l = new Label("Car ID");
        l.setLayoutX(0);
        l.setLayoutY(70);
        l.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        t = new TextField();
        t.setEditable(false);
        t.setText(st+id1.toString());
        t.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        t.setLayoutY(70);
        t.setLayoutX(150);
        l1 = new Label("Car Model");
        l1.setLayoutX(0);
        l1.setLayoutY(120);
        l1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        t1 = new TextField();
        t1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        t1.setLayoutY(120);
        t1.setLayoutX(150);
        l2 = new Label("Car Brand");
        l2.setLayoutX(0);
        l2.setLayoutY(170);
        l2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        t2 = new TextField();
        t2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        t2.setLayoutY(170);
        t2.setLayoutX(150);
        l3 = new Label("Car Year");
        l3.setLayoutX(0);
        l3.setLayoutY(220);
        l3.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        t3 = new TextField();
        t3.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        t3.setLayoutY(220);
        t3.setLayoutX(150);
        b = new Button("Cancel");
        b.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                t.setText("");
                t1.setText("");
                t2.setText("");
                t3.setText("");

            }
        });
        //b.setBackground(Background.fill(Color.PERU));
        b.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        b.setLayoutX(300);
        b.setLayoutY(350);

        b1 = new Button("Register");
        b3=new Button("inc");
        b3.setLayoutX(360);
        b3.setLayoutY(70);
        b3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                save();
            }
        });
        b1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                stt = t.getText();
                st1 = t1.getText();
                st2 = t2.getText();
                st3 = t3.getText();


                try {
                    String query = "Insert into Car_list(Car_ID,Car_Model,Car_Brand,Production_Year) VALUES('" + stt + "', '" + st1 + "', '" + st2 + "', '" + st3 + "')";
                    DBcon db = new DBcon();
                    Connection connection = db.conMethod();
                    Statement statement=statement = connection.createStatement();
                    boolean status = statement.execute(query);
                    Alert al = new Alert(Alert.AlertType.INFORMATION);
                    if (!status) {
                        al.setContentText("successfully registered");
                        al.showAndWait();
                    } else {
                        al.setContentText("Not successfully registered");
                        al.showAndWait();
                    }

                } catch (Exception e) {
                    System.out.println("error" + e);
                }
            }


        });
       // b1.setBackground(Background.fill(Color.PERU));
        b1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        b1.setLayoutX(90);
        b1.setLayoutY(350);

        gr.getChildren().addAll(l,t,l1,t1,l2,t2,t3,l3,b,b1,b2,b3);
        stage.setScene(sc);
        stage.setTitle("Car Registration");
        stage.show();
    }
    final AtomicLong identifier = new AtomicLong(0);

    public void save(){

        Long id = identifier.incrementAndGet();
        t.setText(st+id.toString());
    }
}


