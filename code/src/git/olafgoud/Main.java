package git.olafgoud;

import git.olafgoud.graphics.MainScreen;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	private Stage stage;
	
	private Main main;
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		launch(args);
	}

	@Override
	public void start(Stage setupStage) throws Exception {
		this.stage = setupStage;
		this.main = this;
		
		MainScreen main = new MainScreen(stage, this.main);
		main.mainScreen();
		
		stage = main.getStage();
		stage.show();

	}
	
	
	public Stage getStage() {
		return this.stage;
	}
	
	
	public void setStage(Stage stage) {
		this.stage = stage;
	}

}
