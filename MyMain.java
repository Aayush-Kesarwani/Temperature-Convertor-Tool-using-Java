package com.internshala.JavaFXapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain extends Application{

	public static void main(String[] args){
		System.out.println("Main");
		launch(args);
	}

	@Override
	public void init() throws Exception {
		System.out.println("init");
		super.init();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println("Start");

		FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();

		MenuBar menuBar = createMenu();
		rootNode.getChildren().add(0, menuBar);

		Scene scene = new Scene(rootNode);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Converter Tool");
		primaryStage.show();
	}

	private MenuBar createMenu(){
		// File menu
		Menu fileMenu = new Menu("File");
		MenuItem newMenuItem = new MenuItem("New");

		newMenuItem.setOnAction(event -> System.out.println("New menu item clicked."));

		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
		MenuItem quitMenuItem = new MenuItem("Quit");

		quitMenuItem.setOnAction(event -> {
			Platform.exit();
			System.exit(0);
		});

		fileMenu.getItems().addAll(newMenuItem, separatorMenuItem, quitMenuItem);

		// Help menu
		Menu helpMenu = new Menu("Help");
		MenuItem aboutApp = new MenuItem("About");
		aboutApp.setOnAction(event -> aboutApp());
		
		helpMenu.getItems().addAll(aboutApp);

		//Menu bar
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu, helpMenu);

		return menuBar;
	}

	private void aboutApp() {
		Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("My first desktop application");
		alertDialog.setHeaderText("Learning JavaFX");
		alertDialog.setContentText("Hey this is Aayush Kesarwani and this is my first ever application ever created.");

		ButtonType yesButton = new ButtonType("Yes");
		ButtonType noButton = new ButtonType("No");

		alertDialog.getButtonTypes().setAll(yesButton, noButton);

		Optional<ButtonType> clickedButton =  alertDialog.showAndWait();

		if (clickedButton.isPresent() && clickedButton.get() == yesButton){
			System.out.println("Yes button clicked");
		}

		else{
			System.out.println("NO button clicked");
		}
	}

	@Override
	public void stop() throws Exception {
		System.out.println("Stop");
		super.stop();
	}
}