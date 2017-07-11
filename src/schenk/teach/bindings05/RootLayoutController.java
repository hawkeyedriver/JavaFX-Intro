package schenk.teach.bindings05;



import java.time.LocalDate;



import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.beans.value.ChangeListener;
import schenk.teach.bindings05.Utility;

public class RootLayoutController {
	
	//Example 1
	@FXML
	private Slider mySlider;	
	@FXML 
	private Slider myVSlider;	
	@FXML
	private Label myLabel;
	
	//Example 2
	@FXML
	private TextField myTextField1;	
	@FXML
	private RadioButton rbOne;	
	@FXML
	private RadioButton rbTwo;	
	@FXML
	private RadioButton rbThree;
	
	
	//Example 3
	@FXML
	private ImageView imgPic;
	@FXML
	private ChoiceBox<String> cmbImagePicker;
	
	
	//Example 4
	@FXML
	private WebView myWebView;
	@FXML
	private Button btnOne;
	@FXML
	private Button btnTwo;
	@FXML
	private Button btnThree;
	@FXML
	private ToggleButton myToggle;
	@FXML
	private DatePicker myDatePicker;
	@FXML
	private TextField txtDateSelected;
	@FXML
	private Label lblDateSelected;
	
	
	//***********************Experimental Section**********************************
	//The Cipher Lock Section
	@FXML
	private TextArea txtPlainText;
	@FXML
	private TextArea txtCipherText;
	@FXML
	private Spinner<Integer> mySpinner;
	@FXML
	private TextField txtKeyWord;
	@FXML
	private Button btnCaesar;
	@FXML
	private Button btnVigenere;
	@FXML
	private Button btnDeCaesar;
	@FXML
	private Button btnDeVigenere;
	
	
	
	
	
	// Reference to Main Application.
	//This is used by the main application to be able to pass a reference to itself to the controllers
	private Main mainApp;
		
		//Constructor that is empty
		public RootLayoutController() {
				//This is REQUIRED even if it has no commands.  The LOADER looks for this first, then will call initialize ONLY if initialize is decorated with @FXML
		}
			
		@FXML 
		private void initialize()
		{
			
			//Example 1 Setup Code
			mySlider.setMin(-30);
			mySlider.setMax(30);
			mySlider.setMajorTickUnit(10);
			mySlider.setMinorTickCount(1);
			mySlider.setValue(5);
			
			myVSlider.setMin(-30);
			myVSlider.setMax(30);
			myVSlider.setMajorTickUnit(10);
			myVSlider.setMinorTickCount(1);
			myVSlider.setValue(4);			
			
			myLabel.scaleXProperty().bindBidirectional(mySlider.valueProperty());                   //bindBidirectional(mySlider.valueProperty());
			myLabel.scaleYProperty().bindBidirectional(myVSlider.valueProperty());
			
			
			//Example 2 Setup Code
			ToggleGroup group = new ToggleGroup();
			rbOne.setToggleGroup(group);
			rbTwo.setToggleGroup(group);
			rbThree.setToggleGroup(group);
			
			group.selectToggle(rbOne);
						
			myTextField1.textProperty().setValue(((RadioButton) group.getSelectedToggle()).getText());
			
			group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			      public void changed(ObservableValue<? extends Toggle> ov,
			          Toggle old_toggle, Toggle new_toggle) {
			        if (group.getSelectedToggle() != null) {
			          myTextField1.textProperty().setValue(((RadioButton) group.getSelectedToggle()).getText());
			        }
			      }
			    });		
			
			
			//Example 3 Setup Code			
			cmbImagePicker.setItems(FXCollections.observableArrayList(
				    "Sailboat", "Jet", "Choo Choo", "Bike")
				);
			
			
			cmbImagePicker.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			      @Override
			      public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
			        
			    	  switch (cmbImagePicker.getItems().get((Integer) number2)) {
			    	  			    	
			    	  case "Sailboat" :  {
			    	  				Image image = new Image("file:resources/sailboat.png");
			    	  				imgPic.setImage(image);
			    	  				break;
			    	  			 }
			    	  case "Jet" :  {
	    	  				Image image = new Image("file:resources/jet.png");
	    	  				imgPic.setImage(image);
	    	  				break;
	    	  			 }
			    	  case "Choo Choo" :  {
	    	  				Image image = new Image("file:resources/choochoo.png");
	    	  				imgPic.setImage(image);
	    	  				break;
	    	  			 }
			    	  case "Bike" :  {
	    	  				Image image = new Image("file:resources/bike.png");
	    	  				imgPic.setImage(image);
	    	  				break;
	    	  			 }
			    	  
			    	  }
			      }
			    });
			
			
			//Example 4
			ToggleGroup group2 = new ToggleGroup();
			myToggle.setToggleGroup(group2);
			group2.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
			    public void changed(ObservableValue<? extends Toggle> ov,
			        Toggle toggle, Toggle new_toggle) {
			            if (new_toggle == null){
			            	handleCalendar();
			            }
			                
			            else {
			               handleCalendar();
			            }
			    }});
			
			myDatePicker.setVisible(false);
			txtDateSelected.setVisible(false);
			lblDateSelected.setVisible(false);
			
			//Handling the change event for a DatePicker
			  myDatePicker.valueProperty().addListener(new ChangeListener<LocalDate>() {
					@Override
					public void changed(ObservableValue<? extends LocalDate> arg0, LocalDate arg1, LocalDate arg2) {
						txtDateSelected.textProperty().setValue(arg2.toString());						
					}
			    });

			  
			  
			  
			//***********************Advanced Section********************************** 
			//The Cipher Lock Section
			mySpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(
			        0, 26, 13));
					
		}
	
	
		@FXML
		private void HandleFox(){
			WebEngine webEngine = myWebView.getEngine();
			webEngine.load("http://www.foxnews.com/?nomobile");			
		}
				
		@FXML
		private void HandleCnn(){
			WebEngine webEngine = myWebView.getEngine();
			webEngine.load("http://www.cnn.com");			
		}
		
		@FXML
		private void handleGoogle() {
			WebEngine webEngine = myWebView.getEngine();
			webEngine.load("http://www.google.com");			
		}
		
		@FXML
		private void handleCalendar() {
			if (!myToggle.isSelected()) {
				myDatePicker.setVisible(false);
				txtDateSelected.setVisible(false);
				lblDateSelected.setVisible(false);
				
			}
			else {
				myDatePicker.setVisible(true);
				txtDateSelected.setVisible(true);
				lblDateSelected.setVisible(true);				
			}
			//txtDateSelected.setText(myDatePicker.getValue().toString());
			LocalDate date = myDatePicker.getValue();
			System.out.println(date);
			if (date!=null){
				txtDateSelected.textProperty().setValue(date.toString());
			}
			else {
				txtDateSelected.textProperty().setValue(" ");
			}
		}
		
		
		@FXML
		private void handleCaesar() {
			txtCipherText.setText(Utility.encryptCaesar(mySpinner.getValue(), txtPlainText.getText()));		
		}
		
		
		@FXML
		private void handleVigenere() {
			txtCipherText.setText(Utility.encryptVigenere(txtKeyWord.getText(), txtPlainText.getText()));		
		}
		
		@FXML
		private void handleDeCaesar() {
			txtPlainText.setText(Utility.decryptCaesar(mySpinner.getValue(), txtCipherText.getText()));
		}
		
		@FXML
		private void handleDeVigenere() {
			txtPlainText.setText(Utility.decryptVigenere(txtKeyWord.getText(), txtCipherText.getText()));
		}
		
		
		
		// @param mainApp
		public void setMainApp(Main mainApp) {
	    	
			//This sets the field for this controller to the application passed in:  
			//This allows the main application to have a pointer to itself by setting its own pointer into the controller's field
			this.mainApp = mainApp;
		}
	
	
	
	
	
	
	
	
	
	
}
