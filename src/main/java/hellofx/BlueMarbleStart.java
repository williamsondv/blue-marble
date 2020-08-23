package hellofx;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.imageio.ImageIO;

import com.sun.javafx.scene.SceneUtils;

import javafx.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;


public class BlueMarbleStart extends Application {

	
	


public static void main(String[] args) throws SQLException, InterruptedException {
	
    Application.launch(args);
		
	}

@Override
public void start(Stage primaryStage) throws Exception {
	
	
	Parent root;
	root = FXMLLoader.load(getClass().getResource("blueMarble.fxml"));
	primaryStage.setScene(new Scene(root, 1000, 610));
	primaryStage.show();
	
	
	
	
	
}

}
