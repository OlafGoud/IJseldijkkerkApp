package git.olafgoud;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {
	
	private Stage stage;
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage setupStage) throws Exception {
		this.stage = setupStage;
		FlowPane root = new FlowPane(10, 10);
		root.setPadding(new Insets(10));
		Button btn1 = new Button("open");
		btn1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg) {
				System.out.println("btn1");
				
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
		hbox.getChildren().addAll(btn1, btn2, btn3);
		root.getChildren().add(hbox);
		
		
		
		Scene scene = new Scene(root, 500, 400);
		stage.setScene(scene);
		stage.show();

	}

}
