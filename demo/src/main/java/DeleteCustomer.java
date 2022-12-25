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

import javax.swing.*;
import java.sql.Connection;
import java.sql.Statement;

public class DeleteCustomer {

        public void deletecust(){
            TextField t1 = new TextField();
            Stage stage=new Stage();
           Button b2=new Button("Homepage");
            b2.setLayoutX(420);
            b2.setLayoutY(10);
            b2.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Homepage hm=new Homepage();
                    hm.homepage();
                    stage.close();
                }
            });
           Label l1 = new Label("Customer ID");
            Button bt=new Button("Delete Customer");
            bt.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                   String st45=t1.getText();
                    try {
                        String query = "DELETE FROM Customer_list WHERE Customer_ID='" + st45 + "'";
                        System.out.println(query);
                        DBcon db = new DBcon();
                        Connection connection = db.conMethod();
                        Statement statement = connection.createStatement();

                        boolean status = statement.execute(query);
                        Alert al = new Alert(Alert.AlertType.INFORMATION);
                        if (!status) {
                            al.setContentText("successfuly deleted");
                            al.showAndWait();
                        } else {
                            al.setContentText("not successfuly deleted");
                            al.showAndWait();
                        }

                    } catch (Exception e) {
                        System.out.println("error" + e);
                    }

                }
            });
            l1.setLayoutX(20);
            bt.setLayoutX(150);
            bt.setLayoutY(250);
            bt.setFont(Font.font("verdana",FontWeight.BOLD,16));
            l1.setLayoutY(100);
            l1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

            t1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
            t1.setLayoutY(100);
            t1.setLayoutX(200);
            Group ggg=new Group();
            ggg.getChildren().addAll(l1,t1,bt,b2);
            Scene sc=new Scene(ggg,500,500, Color.CHOCOLATE);
            stage.show();
            stage.setScene(sc);
        }
    }

