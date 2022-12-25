
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Homepage {
    Label lb;
    Button b,b1,b2,b3,b4,b5;
    public void homepage(){
        Stage stage=new Stage();
        Group vb=new Group();
        lb=new Label("AA Car Rental PLC");
        lb.setLayoutX(120);
        lb.setLayoutY(40);
        lb.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.ITALIC,40));
        b=new Button("Customer Register");
        b.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                CustomerReg cg=new CustomerReg();
                cg.CustReg();
                stage.close();
            }
        });
        b.setPrefWidth(400);
        b.setLayoutX(100);
        b.setLayoutY(130);
        b.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,22));
        //b.setBackground(Background.fill(Color.LIGHTSKYBLUE));
        b1=new Button("Car  Register");
        b1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                CarReg carr=new CarReg();
                carr.carreg();
                stage.close();
            }
        });
        b1.setPrefWidth(400);
        //b1.setBackground(Background.fill(Color.LIGHTSKYBLUE));
        b1.setLayoutX(100);
        b1.setLayoutY(200);
        b1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,22));
        b2=new Button("Car Rental");
        b2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Carrenatl cr=new Carrenatl();
                cr.carrental();
                stage.close();

            }
        });
        b2.setPrefWidth(400);
        b2.setLayoutX(100);
        b2.setLayoutY(270);
        b2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,22));
        b3=new Button("Car Return");
        b3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                CarReturn car=new CarReturn();
                car.carreturn();
                stage.close();
            }
        });
        b3.setPrefWidth(400);
        b3.setLayoutX(100);
        b3.setLayoutY(340);
        b3.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,22));
        b5=new Button("Delete Customer");
        b5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DeleteCustomer dd=new DeleteCustomer();
                dd.deletecust();
                stage.close();
            }
        });
        b5.setPrefWidth(400);
        b5.setLayoutX(100);
        b5.setLayoutY(410);
        b5.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,22));
        vb.getChildren().addAll(b,b1,b2,b3,b5,lb);
        Scene scene = new Scene(vb,600, 600, Color.OLIVE);
        stage.setTitle("Car Rental System");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();


    }


}
