/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ip.finder;

/**
 *
 * @author pc
 */
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @web http://zoranpavlovic.blogspot.com/
 */
public class IpFinder extends Application {

    String user = "JavaFX2";
// String pw = "password";
    String checkUser;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Ip Finder");

        BorderPane bp = new BorderPane();
        bp.setPadding(new Insets(10, 50, 50, 50));

        //Adding HBox
        HBox hb = new HBox();
        hb.setPadding(new Insets(20, 20, 20, 30));

        //Adding GridPane
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        //Implementing Nodes for GridPane
        Label lblAddress = new Label("address");
        final TextField txtAddress = new TextField();
        Button btnFind = new Button("find");
        final Label lblMessage = new Label();

        //Adding Nodes to GridPane layout
        gridPane.add(lblAddress, 0, 0);
        gridPane.add(txtAddress, 1, 0);

        gridPane.add(btnFind, 2, 0);
        gridPane.add(lblMessage, 1, 2);

        //Reflection for gridPane
        Reflection r = new Reflection();
        r.setFraction(0.7f);
        gridPane.setEffect(r);

        //DropShadow effect 
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(5);
        dropShadow.setOffsetY(5);

        //Adding text and DropShadow effect to it
        Text text = new Text("JavaFX Ip Finder");
        text.setFont(Font.font("Courier New", FontWeight.BOLD, 28));
        text.setEffect(dropShadow);

        //Adding text to HBox
        hb.getChildren().add(text);

        btnFind.setOnAction(new EventHandler() {
//        

            @Override
            public void handle(Event t) {

                //       lblMessage.setText("");
                try {
                    String text = txtAddress.getText();
                    lblMessage.setText(InetAddress.getByName(text).getHostAddress());
                } catch (UnknownHostException ex) {
                    lblMessage.setText("inknwns address ");

                }
            }
        });

        //Add HBox and GridPane layout to BorderPane Layout
        bp.setTop(hb);
        bp.setCenter(gridPane);

        //Adding BorderPane to the scene and loading CSS
        Scene scene = new Scene(bp);
        scene.getStylesheets().add("style.css");
        primaryStage.setScene(scene);
        primaryStage.titleProperty().bind(
                scene.widthProperty().asString().
                concat(" : ").
                concat(scene.heightProperty().asString()));
        //primaryStage.setResizable(false);
        primaryStage.show();
    }
}
