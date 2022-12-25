
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
import java.util.concurrent.atomic.AtomicLong;

public class CarReturn {
    Label l,l1,l2,l3,l4,l5,l6;
    Button b,b1,b2,b3,b4;
    DatePicker d1;
    TextField t,t1,t2,t4,t5,t6;
    String sttt="C00";
    String stt,st1,st2,st3,st4,st5,st6,st7;

    public void carreturn(){
        Long id1= Long.valueOf(0);
        Stage st=new Stage();
        Group gg=new Group();
        b2=new Button("Homepage");
        b2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Homepage hm1=new Homepage();
                hm1.homepage();
                st.close();
            }
        });
        b2.setLayoutX(430);
        b2.setLayoutY(10);
        l = new Label("Customer Name");
        l.setLayoutX(0);
        l.setLayoutY(70);
        l.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        t = new TextField();
        t.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        t.setLayoutY(70);
        t.setLayoutX(200);
        l2 = new Label("Customer ID");
        l2.setLayoutX(0);
        l2.setLayoutY(120);
        l2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        t2 = new TextField();
        t2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        t2.setLayoutY(120);
        t2.setLayoutX(200);
        l1 = new Label("Car ID");
        l1.setLayoutX(0);
        l1.setLayoutY(170);
        l1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        t1 = new TextField();
        t1.setText(sttt+id1.toString());
        t1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        t1.setLayoutY(170);
        t1.setLayoutX(200);
        l3 = new Label("Return Date");
        l3.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        l3.setLayoutX(0);
        l3.setLayoutY(220);
        d1=new DatePicker();
        d1.setLayoutX(200);
        d1.setPrefWidth(206);
        d1.setStyle("-fx-font-size:16");
        d1.setLayoutY(220);
        l4 = new Label("Car Model");
        l4.setLayoutX(0);
        l4.setLayoutY(270);
        l4.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        t4 = new TextField();
        t4.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        t4.setLayoutY(270);
        t4.setLayoutX(200);
        l5 = new Label("Car Brand");
        l5.setLayoutX(0);
        l5.setLayoutY(320);
        l5.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        t5 = new TextField();
        t5.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        t5.setLayoutY(320);
        t5.setLayoutX(200);
        l6 = new Label("Car Year");
        l6.setLayoutX(0);
        l6.setLayoutY(370);
        l6.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        t6 = new TextField();
        t6.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        t6.setLayoutY(370);
        t6.setLayoutX(200);
        b = new Button("Cancel");
        b.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                t.setText("");
                t1.setText("");
                t2.setText("");
                d1.setValue(null);

            }
        });
        b3=new Button("inc");
        b3.setLayoutX(410);
        b3.setLayoutY(170);
        b3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                save();
            }
        });

        b.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        b.setLayoutX(300);
        b.setLayoutY(500);
        b1 = new Button("Return Car");
        b1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stt = t1.getText();
                st1 = t4.getText();
                st2 = t5.getText();
                st4 = t6.getText();
                st5 = t.getText();
                st6 = t2.getText();
                st7= String.valueOf(d1.getValue());
                try {
                    String query = "Insert into Car_list(Car_ID,Car_Model,Car_Brand,production_year) VALUES('" + stt + "', '" + st1 + "', '" + st2 + "', '" + st4 + "')";
                    DBcon db = new DBcon();
                    Connection connection = db.conMethod();

                    Statement statement= connection.createStatement();

                    boolean status = statement.execute(query);
                    Alert al = new Alert(Alert.AlertType.INFORMATION);
                    if (!status) {
                        al.setContentText("successfully returned");
                        al.showAndWait();
                    } else {
                        al.setContentText("Not successfully returned");
                        al.showAndWait();
                    }

                } catch (Exception e) {
                    System.out.println("error" + e);
                }
                try {
                    String quer = "Insert into inforeturn(Customer_name,customer_id,Car_id,return_date) VALUES('" + st5 + "', '" + st6 + "', '" + stt + "', '" + st7 + "')";
                    DBcon db = new DBcon();
                    Connection connection = db.conMethod();

                    Statement statement=connection.createStatement();

                     statement.execute(quer);

                } catch (Exception e) {
                    System.out.println("error" + e);
                }

            }


        });
        b1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        b1.setLayoutX(90);
        b1.setLayoutY(500);


        gg.getChildren().addAll(l,t,l1,t1,l2,t2,l3,d1,b1,b,b2,b3,l4,l5,l6,t4,t5,t6);
        Scene cs=new Scene(gg,530,620,Color.CHOCOLATE);
        st.setScene(cs);
        st.setTitle("Car Return");
        st.show();

    }
    final AtomicLong identifier = new AtomicLong(0);

    public void save(){

        Long id = identifier.incrementAndGet();
        t1.setText(sttt+id.toString());
    }

}