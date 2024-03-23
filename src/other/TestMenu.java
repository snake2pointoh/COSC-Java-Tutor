package src.other;


import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.Optional;

public class TestMenu extends Application
{

	private BorderPane obBP;
	private DrawPane obPane;
	private Stage currStage;
	
	@Override
	public void start(Stage stage) throws Exception 
	{
		obBP = new BorderPane();
		obPane  = new DrawPane();
		currStage = stage;
		
		obBP.setTop(getPrimaryBar());
		obBP.setCenter(obPane);
		
		stage.setScene(new Scene(obBP, 300,300));
		stage.show();
		
	}
	
	
	/**
	 * Helper method for establishing the MenuBar
	 * @return
	 */
	private MenuBar getPrimaryBar()
	{
		MenuBar obBar = new MenuBar();
		
		obBar.getMenus().addAll(getFileMenu(), getEditMenu(), getHelpMenu());

		return obBar;
		
	}
	
	/**
	 * Helper method for the File Menu
	 * @return
	 */
	private Menu getFileMenu()
	{
		Menu mnFile = new Menu("File");
		MenuItem mnuOpen= new MenuItem("Open");
		MenuItem mnuSave = new MenuItem("Save");
		MenuItem mnuExit = new MenuItem("Exit");

		mnuExit.setOnAction(e -> {
			Platform.exit();
		});


		mnuOpen.setOnAction(e -> {
			FileChooser obChooser = new FileChooser();

			obChooser.getExtensionFilters().addAll(
					new FileChooser.ExtensionFilter("Java Files", "*.java"),
					new FileChooser.ExtensionFilter("All Files", "*.*")
			);

			File obFile = obChooser.showOpenDialog(currStage);

			if (obFile != null)
			{
				System.out.printf("File is %s\n", obFile.getName());
			}

		});


		mnuSave.setOnAction(e -> {

			FileChooser obChooser = new FileChooser();

			obChooser.getExtensionFilters().addAll(
					new FileChooser.ExtensionFilter("Java Files", "*.java"),
					new FileChooser.ExtensionFilter("All Files", "*.*")
			);

			File obFile = obChooser.showSaveDialog(currStage);

			if (obFile != null)
			{
				System.out.printf("File is %s\n", obFile.getName());
			}

		});

		
		mnFile.getItems().addAll(mnuOpen,mnuSave,mnuExit);
		
		return mnFile;
	}


	public Menu getEditMenu()
	{
		Menu mnEdit = new Menu("Edit");
		Menu mnColor = new Menu("Color");
		Menu mnSize = new Menu("Size");


		MenuItem miRed = new MenuItem("Red");
		MenuItem miBlue = new MenuItem("Blue");
		MenuItem miGreen = new MenuItem("Green");

		MenuItem miOne = new MenuItem("1");
		MenuItem miThree = new MenuItem("3");
		MenuItem miFive = new MenuItem("5");

		mnColor.getItems().addAll(miRed, miBlue, miGreen);
		mnSize.getItems().addAll(miOne, miThree, miFive);

		miRed.setOnAction(e -> {
			obPane.curStyle = "-fx-stroke:red";
		});

		miBlue.setOnAction(e -> {
			obPane.curStyle = "-fx-stroke:blue";
		});

		miGreen.setOnAction(e -> {
			obPane.curStyle = "-fx-stroke:green";
		});

		miOne.setOnAction(e -> {
			obPane.dSize = 1;
		});

		miThree.setOnAction(e -> {
				obPane.dSize = 3;
		});

		miFive.setOnAction(e -> {
			obPane.dSize = 5;
		});

		mnEdit.getItems().addAll(mnColor, mnSize);

		return mnEdit;
	}
	
	/**
	 * Helper method for establishng the help menu
	 * @return
	 */
	private Menu getHelpMenu()
	{
		Menu mnHelp = new Menu("Help");
		MenuItem miAbout = new MenuItem("About");
		mnHelp.getItems().add(miAbout);

		miAbout.setOnAction(e -> {
			/*
			Alert obAlert = new Alert(Alert.AlertType.INFORMATION);
			obAlert.setTitle("My Information");
			obAlert.setHeaderText("Identifying author");
			obAlert.setContentText("Copyright: Bryce Barrie");
			*/

			/*
			Alert obAlert = new Alert(Alert.AlertType.WARNING);
			obAlert.setTitle("Danger Will Rodgers, Danger");
			obAlert.setHeaderText("");
			obAlert.setContentText("Danger Writing");
			 */

			/*
			Alert obAlert = new Alert(Alert.AlertType.CONFIRMATION);
			obAlert.setTitle("Are you sure you want to exit?");
			obAlert.setHeaderText("");
			obAlert.setContentText("Press okay to exit");
			Optional<ButtonType> obResult = obAlert.showAndWait();

			if (obResult.get() == ButtonType.OK)
			{
				Platform.exit();
			}

			obAlert.show();
			*/

			TextInputDialog dlgName = new TextInputDialog("Place your name here");
			dlgName.setTitle("Name Prompt");
			dlgName.setHeaderText("");
			dlgName.setContentText("Enter your Name");

			Optional<String> obResponse = dlgName.showAndWait();

			obResponse.ifPresent(name -> System.out.println(name));
		});



		return mnHelp;
		
		
	}

	public static void main(String[] args)
	{
		Application.launch(args);

	}

}
