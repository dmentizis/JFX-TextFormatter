package Sample;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TextFormatter extends Application {
  protected Text text = new Text(50, 50, "");
  
  Font fontBoldItalic = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20);
  Font fontBold = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 20);
  Font fontItalic = Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.ITALIC, 20);
  Font fontNormal = Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 20);
        
  
  protected class HBoxWithTextField extends HBox {
      public HBoxWithTextField(){
        super(20);
        setPadding(new Insets(5, 5, 5, 5)); 
        Label lbl = new Label("Text input:");
        TextField tf = new TextField();
        tf.setPromptText("Enter your text here");
        tf.setPrefWidth(250);
        getChildren().addAll(lbl, tf);
        setAlignment(Pos.CENTER);
        setStyle("-fx-border-color: green");
        tf.setOnAction(e ->  text.setText(tf.getText()));
      }
      
  }
   protected class HBoxWithButtons extends HBox {      
      public HBoxWithButtons(){
        super(20);
        setPadding(new Insets(5, 5, 5, 5));
        Button btLeft = new Button("Left", new ImageView("image/left.gif"));
        Button btRight = new Button("Right", new ImageView("image/right.gif"));
        getChildren().addAll(btLeft, btRight);
        setAlignment(Pos.CENTER);
        setStyle("-fx-border-color: green");
        btLeft.setOnAction(e -> text.setLayoutX(text.getLayoutX() - 10));
        btRight.setOnAction(e -> text.setLayoutX(text.getLayoutX() + 10));
	}      
  }
   
  protected class VBoxWithRadioButtons extends VBox {
      public VBoxWithRadioButtons(){
        super(20);
        setPadding(new Insets(5, 5, 5, 5)); 
        
        RadioButton rbRed = new RadioButton("Red");
        RadioButton rbGreen = new RadioButton("Green");
        RadioButton rbBlue = new RadioButton("Blue");
        
        rbRed.setOnAction(e -> text.setFill(Color.RED));
        rbGreen.setOnAction(e -> text.setFill(Color.GREEN));
        rbBlue.setOnAction(e -> text.setFill(Color.BLUE));
        
        ToggleGroup group = new ToggleGroup();
        rbRed.setToggleGroup(group);
        rbGreen.setToggleGroup(group);
        rbBlue.setToggleGroup(group);
        getChildren().addAll(rbRed, rbGreen, rbBlue);
        setStyle("-fx-border-color: green");
      }

  
  }
  
  protected class VBoxWithCheckBoxes extends VBox { 
      public VBoxWithCheckBoxes(){
          super(20);
          setPadding(new Insets(5, 5, 5, 5));
          
          CheckBox chkBold = new CheckBox("Bold");        
          CheckBox chkItalic = new CheckBox("Italic");   
          
          chkBold.setOnAction(e -> text.setStyle("-fx-font-weight: bold"));
          chkItalic.setOnAction(e -> text.setStyle("-fx-font-style: italic"));
          
          getChildren().addAll(chkBold, chkItalic);
          setStyle("-fx-border-color: green");
      }
  } 
    
  
  
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
      
    BorderPane borderPane = new BorderPane();    
    
    text.setFont(fontNormal);
    Pane paneForText = new Pane();
    paneForText.getChildren().add(text);
    
    borderPane.setCenter(paneForText);    
    borderPane.setTop(new HBoxWithTextField());            
    borderPane.setBottom(new HBoxWithButtons());
    borderPane.setLeft(new VBoxWithRadioButtons());        
    borderPane.setRight(new VBoxWithCheckBoxes());
    
    // Create a scene and place it in the stage
    Scene scene = new Scene(borderPane, 450, 200);
    primaryStage.setTitle("Text Formatter"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage

  }

  public static void main(String[] args) {
    launch(args);
  }
    
}