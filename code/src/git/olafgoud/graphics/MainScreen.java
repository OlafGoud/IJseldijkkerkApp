package git.olafgoud.graphics;

import git.olafgoud.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MainScreen {
	
	public Stage stage;
	public Main main;
	
	
	public MainScreen(Stage mainStage, Main main) {
		this.stage = mainStage;
		this.main = main;

	}
	
	@SuppressWarnings("deprecation")
	public void mainScreen() {
		FlowPane root = new FlowPane(10, 10);
		root.setPadding(new Insets(10));
		Button btn1 = new Button("Chat");
		btn1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg) {
				ChatChannel channel = new ChatChannel(stage, main);
				channel.ChatScreen();
				stage = channel.getStage();
				
			}
			
		});
		Button btn2 = new Button("open");
		btn2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg) {
				System.out.println("btn2");
			}
			
		});
		Button btn3 = new Button("open");
		btn3.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg) {
				System.out.println("btn3");
				
			}
			
		});
		
		
		
		
		HBox hbox = new HBox(10);
		hbox.getChildren().addAll(btn1, btn2, btn3 );
		root.getChildren().add(hbox);
		
		Scene scene = new Scene(root, 500, 700);
		stage.setScene(scene);
		
	}
	
	public Stage getStage() {
		return this.stage;
	}
	
}
