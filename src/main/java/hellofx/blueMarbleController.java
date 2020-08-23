package hellofx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;

import javafx.event.*;

public class blueMarbleController implements Initializable {

	BlueMarble blueMarble = new BlueMarble();
	
    @FXML
    private Button blackAndWhiteButton;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Button enhancedViewButton;

    public ImageView getBlueMarbleImageView() {
		return blueMarbleImageView;
	}

	public void setBlueMarbleImageView(ImageView blueMarbleImageView) {
		this.blueMarbleImageView = blueMarbleImageView;
	}

	@FXML
    private ImageView blueMarbleImageView;
	
	 @FXML
	    private Button displayEarthButton;

    @FXML
    void selectDate(ActionEvent event) {
    	try {
    		
        	
        	
        	
        	try {
        	if (datePicker.getValue().isBefore(LocalDate.of(2016, 01, 01))) {
        		Alert alert = new Alert(AlertType.WARNING);
        		alert.setTitle("Invalid Date");
        		
        		alert.setContentText("Dates before 01/01/2016 are not available. Please select a date between 01/01/2016 and today's date. Thank you!");

        		alert.showAndWait();
        		
        	} else if (datePicker.getValue().isAfter(LocalDate.of(2015, 12, 31)))
        	blueMarble.setDate(datePicker.getValue().toString());
        	//get Image to display
       
        	BufferedImage image = ImageIO.read(blueMarble.getImage());
        	
        	
        	
        	//initialize and create file
    	    File initialImage = new File("src/main/java/hellofx/blueMarbleImage.jpg");
            initialImage.createNewFile();
            
            //Convert file to image and display
    		ImageIO.write(image, "jpg", new File("src/main/java/hellofx/blueMarbleImage.jpg"));
            FileInputStream inputstream = new FileInputStream("src/main/java/hellofx/blueMarbleImage.jpg");
    	    Image image1 = new Image(inputstream);
    	    blueMarbleImageView.setImage(image1);
    	    
        	} catch (java.lang.RuntimeException e) {
        		Alert alert = new Alert(AlertType.WARNING);
        		alert.setTitle("Invalid Date");
        		
        		alert.setContentText("Dates in the future are not available. Please select a date between 01/01/2016 and today's date. Thank you!");

        		alert.showAndWait();
        	}
        	
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} finally {
    			
    		}
    	}
    

    @FXML
    void showEnhancedView(ActionEvent event) throws IOException {
    	
    	
    	
    	
    	if (datePicker.getValue().isBefore(LocalDate.of(2018, 06, 01))) {
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("Invalid Date");
    		
    		alert.setContentText("Enhanced Images are only available until June of 2018. Thank you!");

    		alert.showAndWait();
    		
    	} else if (datePicker.getValue().isAfter(LocalDate.of(2018, 05, 31))) {
    		blueMarble.setEnhanced(true);
    		//initialize and create file
    	    File initialImage = new File("src/main/java/hellofx/blueMarbleImage.jpg");
            initialImage.createNewFile();
            
          //get Image to display
        	BufferedImage image = ImageIO.read(blueMarble.getImage());
            
            //Convert file to image and display
    		ImageIO.write(image, "jpg", new File("src/main/java/hellofx/blueMarbleImage.jpg"));
            FileInputStream inputstream = new FileInputStream("src/main/java/hellofx/blueMarbleImage.jpg");
    	    Image image1 = new Image(inputstream);
    	    blueMarbleImageView.setImage(image1);
    		
    	}
    }

    @FXML
    void showInBlackAndWhite(ActionEvent event) throws IOException {
    	
    		if (datePicker.getValue() == null) {
    			BufferedImage image = ImageIO.read(blueMarble.getMostRecentImage());
            	
            	BufferedImage result = new BufferedImage(
                        image.getWidth(),
                        image.getHeight(),
                        BufferedImage.TYPE_BYTE_BINARY);

                Graphics2D graphic = result.createGraphics();
                graphic.drawImage(image, 0, 0, Color.WHITE, null);
                graphic.dispose();
                
                //Convert file to image and display
        		ImageIO.write(result, "jpg", new File("src/main/java/hellofx/blueMarbleImage.jpg"));
                FileInputStream inputstream = new FileInputStream("src/main/java/hellofx/blueMarbleImage.jpg");
        	    Image image1 = new Image(inputstream);
        	    blueMarbleImageView.setImage(image1);
    		}
    		
    		//initialize and create file
    	    File initialImage = new File("src/main/java/hellofx/blueMarbleImage.jpg");
            initialImage.createNewFile();
            
          //get Image to display
        	BufferedImage image = ImageIO.read(blueMarble.getImage());
        	
        	BufferedImage result = new BufferedImage(
                    image.getWidth(),
                    image.getHeight(),
                    BufferedImage.TYPE_BYTE_BINARY);

            Graphics2D graphic = result.createGraphics();
            graphic.drawImage(image, 0, 0, Color.WHITE, null);
            graphic.dispose();
            
            //Convert file to image and display
    		ImageIO.write(result, "jpg", new File("src/main/java/hellofx/blueMarbleImage.jpg"));
            FileInputStream inputstream = new FileInputStream("src/main/java/hellofx/blueMarbleImage.jpg");
    	    Image image1 = new Image(inputstream);
    	    blueMarbleImageView.setImage(image1);
    		
    	}
    
    
    @FXML
    void displayEarth(ActionEvent event) throws IOException {
    	
    }
   
   

	@Override
	public void initialize(java.net.URL location, ResourceBundle resources) {
		
		try {
		//Instantiate class objects
		blueMarbleController blueMarbleController = new blueMarbleController();
    	BlueMarble blueMarble = new BlueMarble();
    	
    	
    	
    	
    	//get Image to display
    	BufferedImage image = ImageIO.read(blueMarble.getMostRecentImage());
    	
    	//initialize and create file
	    File initialImage = new File("src/main/java/hellofx/blueMarbleImage.jpg");
        initialImage.createNewFile();
        
        //Convert file to image and display
		ImageIO.write(image, "jpg", new File("src/main/java/hellofx/blueMarbleImage.jpg"));
        FileInputStream inputstream = new FileInputStream("src/main/java/hellofx/blueMarbleImage.jpg");
	    Image image1 = new Image(inputstream);
	    blueMarbleImageView.setImage(image1);
    	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}
	}
      
    }
    
