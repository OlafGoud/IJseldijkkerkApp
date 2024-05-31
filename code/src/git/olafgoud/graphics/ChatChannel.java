package git.olafgoud.graphics;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ChatChannel {
	
	public Stage stage;
	
	public ChatChannel(Stage mainStage) {
		this.stage = mainStage;

	}
	
	public void ChatScreen() {
		//borders
		Border textBorder = new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));

		
		//objects
		FlowPane root = new FlowPane(10, 10);
		root.setPadding(new Insets(10));
		
		
		//chatscreen
		
		VBox chatScreen = new VBox(5);
		chatScreen.setBorder(textBorder);

		Label text1 = new Label("dasf");
		Label text2 = new Label("ädsf");
		
		text1.setBorder(textBorder);
		text2.setBorder(textBorder);
		
		chatScreen.getChildren().addAll(text1, text2);
		
		//chatinput
		TextField chatBar = new TextField();
		chatBar.lengthProperty().add(20);

		Button sendButton = new Button("send");
		sendButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg) {
				System.out.println(chatBar.getText());
				
			}
			
		});		
		
		//gridpane
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(30));
		gridPane.setVgap(10);
		gridPane.setHgap(15);
		gridPane.setBorder(textBorder);
		
		
		VBox.setVgrow(gridPane, Priority.ALWAYS);
		
		gridPane.add(chatScreen, 0, 0);
		gridPane.add(chatBar, 0, 21);
		gridPane.add(sendButton, 2, 21);
		gridPane.setConstraints(chatBar, 0, 0, 2, 1, HPos.LEFT, VPos.TOP, Priority.SOMETIMES, Priority.ALWAYS);
		gridPane.setConstraints(chatScreen, 0, 0, 2, 20, HPos.LEFT, VPos.TOP, Priority.SOMETIMES, Priority.ALWAYS);
		
		gridPane.setGridLinesVisible(true);
		
		
		
		
		
		
		
		
		
		
		
		root.getChildren().add(gridPane);
		root.setAlignment(Pos.BASELINE_CENTER);
		
		Scene scene = new Scene(root, 500, 700);
		stage.setScene(scene);
		
	}
	
	public Stage getStage() {
		return this.stage;
	}
	
	
	
	
	
	
	
}
