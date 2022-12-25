
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


public class Carrenatl {
    Tooltip t11 ;
    Label l,l1,l2,l3,l5,l4,l6,l7,l8;
    Button b,b1,b2,b3;
    DatePicker d;
    TextField t,t1,t2,t3,t4;
    CheckBox ch;
    String stt,st1,st2,st3,st45;
    String st="C00";

    public void carrental(){
        Group g=new Group();
        Long id1= Long.valueOf(0);
        Stage stage=new Stage();
        Scene scc=new Scene(g,530,600, Color.CHOCOLATE);
        stage.setTitle("Car Rental Form");
        b2=new Button("Homepage");
        b2.setLayoutX(430);
        b2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Homepage hm1=new Homepage();
                hm1.homepage();
                stage.close();
            }
        });
        l8 =new Label();
        l8.setLayoutX(120);
        l8.setLayoutY(550);
        l8.setFont(Font.font("verdana", FontWeight.LIGHT, FontPosture.ITALIC, 12));
        b2.setLayoutY(10);
      //  b2.setBackground(Background.fill(Color.WHITE));
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
        l3 = new Label("Mobile Number");
        l3.setLayoutX(0);
        l3.setLayoutY(170);
        l3.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        t3 = new TextField();
        t3.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        t3.setLayoutY(170);
        t3.setLayoutX(200);
        l4 = new Label("Car ID");
        l4.setLayoutX(0);
        l4.setLayoutY(220);
        l4.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        t4 = new TextField();
        t4.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        t4.setLayoutY(220);
        t4.setLayoutX(200);
        t4.setText(st+id1.toString());
        l5 = new Label("Rental Date");
        l5.setLayoutX(0);
        l5.setLayoutY(270);
        l5.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        d=new DatePicker();
        d.setLayoutX(200);
        d.setPrefWidth(206);
        d.setLayoutY(270);
        d.setStyle("-fx-font-size:16");
        b = new Button("Cancel");
        b.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                t.setText("");
                t1.setText("");
                t3.setText("");
                t4.setText("");
                d.setValue(null);
                l8.setText("");
            }
        });
        b.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        b.setLayoutX(300);
        b.setLayoutY(500);
        ch=new CheckBox();
        ch.setLayoutX(2);
        ch.setLayoutY(370);
        ch.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));
        b1 = new Button("Rent");
        b1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (ch.isSelected()) {


                    stt = t.getText();
                    st1 = t1.getText();
                    st2 = t3.getText();
                    st3 = String.valueOf(d.getValue());
                    st45 = t4.getText();

                    try {
                        String query = "DELETE FROM Car_list WHERE CAR_ID='" + st45 + "'";
                        System.out.println(query);
                        DBcon db = new DBcon();
                        Connection connection = db.conMethod();

                        Statement statement = connection.createStatement();

                        statement.execute(query);

                    } catch (Exception e) {
                        System.out.println("error" + e);
                    }

                    try {
                        String query = "Insert into rental_list(Customer_name,Customer_id,car_id,Customer_phone,Rental_date) VALUES('" + stt + "', '" + st1 + "', '" + st45 + "', '" + st2 + "','" + st3 + "')";
                        DBcon db = new DBcon();
                        Connection connection = db.conMethod();

                        Statement statement = connection.createStatement();
                        boolean status = statement.execute(query);
                        Alert al = new Alert(Alert.AlertType.INFORMATION);
                        if (!status) {
                            al.setContentText("successfully excuted");
                            al.showAndWait();
                        } else {
                            al.setContentText("Not successfully excuted");
                            al.showAndWait();
                        }

                    } catch (Exception e) {
                        System.out.println("error" + e);
                    }
                }

                else

            {
                l8.setText("Please Accept Terms and Condition ");
            }

        }

        });
        b1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        b1.setLayoutX(90);
        b1.setLayoutY(500);
        l6 =new Label("Read Terms and Condition");
        l6.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                stage.close();
                Stage stt=new Stage();
                Group ggg=new Group();
              Button  b2 = new Button("Homepage");
                b2.setLayoutX(430);
                b2.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        carrental();

                    }
                });
                b2.setLayoutY(10);
                Scene scc=new Scene(ggg,500,500,Color.CHOCOLATE);
                TextArea textArea=new TextArea();
                textArea.setEditable(false);
                textArea.setLayoutX(20);
                textArea.setLayoutY(70);
                textArea.setPrefWidth(460);
                textArea.setPrefHeight(420);
                textArea.setWrapText(true);
                textArea.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
                textArea.setText("1.The Rental Agreement: These Rental Terms and Conditions, the rental document you receive when you are given access to the car you are renting (the \"Rental Contract\") any additional agreement signed by you, any documents or agreements (or links to on-line documents or agreements) sent to you electronically in connection with your rental, the Privacy Notice.\n" +
                        "2. Return of the Car: You agree to return the car to us in the same condition you received it, ordinary wear and tear excepted, on the date, at the time and to the location specified in the Rental Contract.\n" +
                        "\n" +
                        "3. Return of the Car: You agree to return the car to us in the same condition you received it, ordinary wear and tear excepted, on the date, at the time and to the location specified in the Rental Contract.\n" +
                        "4. Who May Drive The Car: We reserve the right to deny rentals based upon (i) information about your license status, (ii) authenticity of your driver's license or other credentials, (iii) the inability to verify your identity or payment methods, (iv) your driving record provided by the Motor Vehicle Department of the jurisdiction that issued your license.\n" +
                        "5.Damage to/Loss of the Car:If you do not accept  Loss Damage Waiver, or if the car is lost or damaged as a direct or indirect result of a violation of paragraph 14, or damaged as a result of an act of nature, you are responsible and you will pay us for all loss of or damage to the car regardless of cause, or who, or what caused it.by Affiliate." );
                ggg.getChildren().addAll(textArea,b2);
                stt.setScene(scc);
                stt.showAndWait();
            }
        });
        b3=new Button("inc");
        b3.setLayoutX(410);
        b3.setLayoutY(220);
        b3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                save();
            }
        });
        l6.setLayoutX(30);
        l6.setLayoutY(360);
        l6.setFont(Font.font("verdana", FontWeight.LIGHT, FontPosture.ITALIC, 12));
        l7 =new Label("Accept Terms and Condition");
        l7.setLayoutX(30);
        l7.setLayoutY(380);
        l7.setFont(Font.font("verdana", FontWeight.LIGHT, FontPosture.ITALIC, 12));
        g.getChildren().addAll(l,l1,t,t1,l3,t3,l4,t4,l5,b,b1,d,b2,l6,l7,ch,l8,b3);
        stage.setScene(scc);
        stage.show();
    }
    final AtomicLong identifier = new AtomicLong(0);

    public void save(){

        Long id = identifier.incrementAndGet();
        t4.setText(st+id.toString());
    }

}
