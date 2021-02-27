import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class BasicInterface extends Application {
	
	//setup all of the layout variables
	private Menu menu = new Menu("Menu");
	private MenuItem printDAndT = new MenuItem("Print Current Date and Time");
	private MenuItem saveDAndT = new MenuItem("Save Current Date and Time");
	private MenuItem colorChange = new MenuItem("Change Background Color");
	private MenuItem quitApp = new MenuItem("Quit");
	private MenuBar menuBar = new MenuBar();
	private Label currentDAndT;
	private Label saveConfirm;
	
	//setup the stage
	@Override
	public void start(Stage applicationStage) throws IOException {
		
		//dimension and assign variables for the stage
		Scene scene = null;
		BorderPane borderPane = new BorderPane();
		scene = new Scene(borderPane);
		FileWriter fstream = new FileWriter("log.txt", true);
		PrintWriter outFS = new PrintWriter(fstream);
		LocalDateTime currentDate = LocalDateTime.now();
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
		
		//add items to menu and menu to the bar
		menu.getItems().add(printDAndT);
		menu.getItems().add(saveDAndT);
		menu.getItems().add(colorChange);
		menu.getItems().add(quitApp);
		menuBar.getMenus().add(menu);
		
		//dimension the labels
		currentDAndT = new Label("");
		saveConfirm = new Label ("");

		//format the border pane
		borderPane.setPadding(new Insets(10, 10, 10, 10));
		borderPane.setMinWidth(500);
		borderPane.setMinHeight(500);
		
		//position objects within the border pane
		borderPane.setTop(menuBar);
		borderPane.setCenter(currentDAndT);
		borderPane.setBottom(saveConfirm);
		
		//set the scene for the stage
		applicationStage.setScene(scene);
		
		//action event for displaying date and time
		printDAndT.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				currentDAndT.setText("" + currentDate.format(dateFormat));
			}
		});
		
		//action event for saving date and time to a file
		saveDAndT.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				outFS.append(currentDate.format(dateFormat) + "\n");
				outFS.flush();
				saveConfirm.setText("Date and time saved to file!");
			}
		});
		
		//action event for changing the background color
		colorChange.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				int gValue = ThreadLocalRandom.current().nextInt(10, 250);
				Color greenShade = Color.rgb(0, gValue, 0);
				borderPane.setBackground(new Background(new BackgroundFill(greenShade, CornerRadii.EMPTY, Insets.EMPTY)));
			}
		});
		
		//action event for quitting the application
		quitApp.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.exit(0);
			}
		});
		
		//title and display the stage
		applicationStage.setTitle("Basic User Interface");
		applicationStage.show();
	}

	//main method to run the GUI
	public static void main(String[] args) {
		launch(args);
	}
}
