package POS;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class View {
	
	//Main Parts
	protected StackPane MainPane = new StackPane();
	protected Scene POSMain;
	protected GridPane grid = new GridPane();
	
	//Labels
	protected Label LabelName = new Label("Point of Sale System");
	protected Label TotalLabel = new Label("Total: P0.00 ");
	
	//textfields
	protected TextField searchField = new TextField();
	
	//Buttons
	protected Button searchButton = new Button();
	protected Button CheckOutButton = new Button("CHECKOUT");
	
	//Images
	protected Image searchIcon = new Image(getClass().getResourceAsStream("search-icon.png"));
	
	//Tables
	protected ListView<String> checkOutList = new ListView<String>();
	protected ScrollPane checkScroll = new ScrollPane(checkOutList);
	
	private final ObservableList<ProdInfo> prodRows = FXCollections.observableArrayList();
	protected TableView<ProdInfo> prodInfo = new TableView<>();
	protected ScrollPane ProdScroll = new ScrollPane(prodInfo);
	
	@SuppressWarnings("unchecked")
	public View(Stage primaryStage) throws Exception {
		primaryStage.setTitle("E&E Auto Supply");
		primaryStage.setResizable(false);
		
		LabelName.setFont(Font.font("Arial", FontWeight.BLACK, 17));
		LabelName.setPadding(new Insets(5));
		
		GridPane.setConstraints(LabelName, 0,0);
		
		TotalLabel.setFont(Font.font("Arial", FontWeight.BLACK, 15));
		LabelName.setPadding(new Insets(7));
		
		HBox searchBox = new HBox();
		searchField.setPromptText("Search...");
		ImageView searchView = new ImageView(searchIcon);
		searchView.setFitHeight(15);
		searchView.setFitWidth(15);	
		
		searchButton.setGraphic(searchView);
		searchButton.setStyle("-fx-background-radius: 0%;");
		searchBox.getChildren().addAll(searchField, searchButton);
		
		CheckOutButton.setAlignment(Pos.CENTER);
		CheckOutButton.setStyle("-fx-focus-color: transparent; "
				            + "-fx-background-radius: 0%;"
				            + "-fx-font-weight: bold");
		CheckOutButton.setPadding(new Insets(5));
		
		ObservableList<String> items = FXCollections.observableArrayList (
		        "A tire", "some engine", "gas");
		items.add("Some about oil");
		checkOutList.setItems(items);
		
		
		VBox leftSide = new VBox();
		leftSide.setPadding(new Insets(10,10,10,10));
		leftSide.setSpacing(10);
		leftSide.getChildren().addAll(searchBox, checkScroll, CheckOutButton);
		GridPane.setConstraints(leftSide, 0, 1);
		
		TableColumn<ProdInfo, String> CodeCol = new TableColumn<>("Code");
		CodeCol.setPrefWidth(50.0d); 
		CodeCol.setCellValueFactory(
				new PropertyValueFactory<ProdInfo, String>("productCode")
			);
		TableColumn<ProdInfo, String> DescCol = new TableColumn<>("Desc");
		DescCol.setPrefWidth(100.0d); 
		DescCol.setCellValueFactory(
				new PropertyValueFactory<ProdInfo, String>("description")
			);
		TableColumn<ProdInfo, String> SuppCol = new TableColumn<>("Supplier");
		SuppCol.setPrefWidth(75.0d); 
		SuppCol.setCellValueFactory(
				new PropertyValueFactory<ProdInfo, String>("Supplier")
			);		
		TableColumn<ProdInfo, String> QtyCol = new TableColumn<>("Qty");
		QtyCol.setPrefWidth(50.0d); 
		QtyCol.setCellValueFactory(
				new PropertyValueFactory<ProdInfo, String>("Qty")
			);	
		TableColumn<ProdInfo, String> PricCol = new TableColumn<>("Price");
		PricCol.setPrefWidth(50.0d); 
		PricCol.setCellValueFactory(
				new PropertyValueFactory<ProdInfo, String>("Price")
			);	
		
		prodRows.add( new ProdInfo("Tire", "A Tire", "Toyota", 15, "100.00"));
		prodRows.add( new ProdInfo("Oil", "Some Oil", "Hyondie", 10, "20.00"));
		
		prodInfo.setItems(prodRows);
		prodInfo.getColumns().addAll(CodeCol, DescCol,SuppCol, QtyCol, PricCol);
		
		VBox rightSide = new VBox();
		rightSide.getChildren().addAll(ProdScroll, TotalLabel);
		rightSide.setPadding(new Insets(10,10,10,10));
		rightSide.setSpacing(10);
		
		GridPane.setConstraints(rightSide, 1, 1);
		
		grid.setPrefSize(535, 350); 
		grid.getChildren().addAll(LabelName, leftSide, rightSide);
		grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(10);
		grid.setHgap(8);
		
		MainPane.getChildren().addAll(grid);
		MainPane.setAlignment(Pos.CENTER);
		POSMain = new Scene (MainPane, 535, 350);
		
		primaryStage.setScene(POSMain);
		primaryStage.show();
	}

}
