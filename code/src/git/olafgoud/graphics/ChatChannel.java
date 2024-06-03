package git.olafgoud.graphics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

import git.olafgoud.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ChatChannel {
	
	public Stage stage;
	public Main main;
	
	
	public ChatChannel(Stage mainStage, Main main) {
		this.stage = mainStage;
		this.main = main;

	}
	
	@SuppressWarnings("deprecation")
	public void ChatScreen() {
		//borders
		Border textBorder = new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
		URL url;
		try {
			url = new URL("http://127.0.0.1:5000/api/chats?chat=mainchat");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer content = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				
				content.append(inputLine);
			}			
			
			JSONObject json = new JSONObject(("{\"text\":" + content.toString() + "}"));
			
			System.out.println(json.toString());
			
			
			
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		
		
		
		//objects
		GridPane root = new GridPane(10, 10);
		root.setPadding(new Insets(10));
		
		GridPane pane = new GridPane();
		
		//text
		Label label = new Label();
		
		
		ColumnConstraints col = new ColumnConstraints();
        col.setPercentWidth( 20 );
        pane.getColumnConstraints().addAll(col, col, col, col, col );
	
		
		
		//chatinput
		TextField chatBar = new TextField();

		Button sendButton = new Button("send");
		sendButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg) {
				System.out.println(chatBar.getText());
				String message = chatBar.getText();
				if (message == "") {
					return;
				}
				try {
					URL url = new URL("http://127.0.0.1:5000/get-user/" + chatBar.getText());
					
					HttpURLConnection con = (HttpURLConnection) url.openConnection();
					con.setRequestMethod("GET");
					con.getInputStream();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			
		});
		Button backButton = new Button("back");
		backButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg) {
				System.out.println(false);

				MainScreen mainn = new MainScreen(stage, main);
				mainn.mainScreen();
				
				stage = mainn.getStage();
				
				
			}
			
		});		
		label.setBorder(textBorder);
		
		root.add(backButton, 0, 0);
		GridPane.setColumnSpan(backButton, 2);
		root.add(label, 0, 1);
		root.add(chatBar, 0, 21);
		GridPane.setColumnSpan(chatBar, 3);
		GridPane.setRowSpan(label, 20);
		root.add(sendButton, 4, 21);
		
		
		
		
		
		root.getChildren().add(pane);
		root.setAlignment(Pos.BASELINE_CENTER);
		
		Scene scene = new Scene(root, 500, 700);
		stage.setScene(scene);
		
	}
	
	public Stage getStage() {
		return this.stage;
	}
	
	
	
	
	
	
	
}
