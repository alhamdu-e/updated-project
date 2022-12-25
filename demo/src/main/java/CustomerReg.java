import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.Statement;

public class CustomerReg  {

    Label l,l1,l2,l3;
    Button b,b1,b2;
    TextField t,t1,t2;
    TextArea t3;
    String st,st1,st2,st3;

    public void CustReg() {
        Stage stage = new Stage();
        Group gr = new Group();
        Scene sc = new Scene(gr, 530, 500, Color.CHOCOLATE);
        b2 = new Button("Homepage");
        b2.setLayoutX(430);
        b2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Homepage hm1 = new Homepage();
                hm1.homepage();
                stage.close();
            }
        });
        b2.setLayoutY(10);
        //b2.setBackground(Background.fill(Color.WHITE));
        l = new Label("Customer Name");
        l.setLayoutX(0);
        l.setLayoutY(70);
        l.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        t = new TextField();
        t.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        t.setLayoutY(70);
        t.setLayoutX(200);
        l1 = new Label("Customer ID");
        l1.setLayoutX(0);
        l1.setLayoutY(120);
        l1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        t1 = new TextField();
        t1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        t1.setLayoutY(120);
        t1.setLayoutX(200);
        l2 = new Label("Customer Mobile");
        l2.setLayoutX(0);
        l2.setLayoutY(170);
        l2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        t2 = new TextField();
        t2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        t2.setLayoutY(170);
        t2.setLayoutX(200);
        l3 = new Label("Customer Adress");
        l3.setLayoutX(0);
        l3.setLayoutY(225);
        l3.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        t3 = new TextArea();
        t3.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        t3.setLayoutY(220);
        t3.setLayoutX(200);
        t3.setWrapText(true);
        t3.setPrefWidth(206);
        t3.setPrefHeight(50);
        b = new Button("Add");
        b.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                st = t.getText();
                st1 = t1.getText();
                st2 = t2.getText();
                st3 = t3.getText();

                 try {
                    String query = "Insert into Customer_list(Customer_Name,Customer_ID,Customer_Phone,Customer_Adress) VALUES('" + st + "', '" + st1 + "', '" + st2 + "', '" + st3 + "')";
                    DBcon db = new DBcon();
                     Connection connection = db.conMethod();

                     Statement statement=statement = connection.createStatement();

                     boolean status = statement.execute(query);
                     Alert al = new Alert(Alert.AlertType.INFORMATION);
                    if (!status) {
                        al.setContentText("successfully Registered");
                        al.showAndWait();
                    } else {
                        al.setContentText("Not successfully Registered");
                        al.showAndWait();
                    }

                } catch (Exception e) {
                    System.out.println("error" + e);
                }
            }

        });


        b.setLayoutX(90);
        b.setLayoutY(350);
        b.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,20));
        b1=new Button("Cancel");
        b1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                t.setText("");
                t1.setText("");
                t2.setText("");
                t3.setText("");
            }
        });
        b1.setLayoutX(300);
        b1.setLayoutY(350);
        b1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,20));
        gr.getChildren().addAll(l,t,l1,t1,t2,l2,l3,t3,b,b1,b2);
        stage.setScene(sc);
        stage.setTitle("Customer Register");
        stage.show();

    }

}

