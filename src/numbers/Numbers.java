package numbers;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;

public class Numbers extends Application {
	public static void main(String[] args) {
		
	launch(args);
	
		
	}

	@Override
	public void start(Stage arg0) throws Exception { 
		
		
		 new NumberWindow(arg0).showWindow();
		 
	}
	
}

	


