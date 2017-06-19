/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laundryapplication;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;

/**
 *
 * @author removevirus
 */
public class LaundryApplication extends Application {
    
    public static Stage Primary_Stage;
    public static Scene scene;
    public static GridPane grid;
    public static BorderPane pane;
    public static TableView<Services> servicesTable;
    
    @Override
    public void start(Stage primaryStage) {
        // setting up the containers
       Primary_Stage=primaryStage;
       grid=new GridPane();
       pane=new BorderPane();
       scene=new Scene(pane,1000,600,Color.rgb(0,0,0,0));
       // decorating the containers
       pane.setCenter(grid);
       scene.getStylesheets().add(getClass().getResource("LaundryCss.css").toExternalForm());
       scene.setFill(Color.ALICEBLUE);
       
       // calling other decoration methods
       firstScene();
       addMenus();
      
      
        primaryStage.setTitle("Business Laundry");
        setFirstScene();
        Primary_Stage.setFullScreenExitHint("press excape to leave full screen");
        Primary_Stage.setFullScreen(true);
        Primary_Stage.getIcons().add(new Image(LaundryApplication.class.getResourceAsStream("rewind.png")) );
        Primary_Stage.show();
    }
   public static void firstScene(){
   
        // setting up columns for the grid
       ColumnConstraints col1=new ColumnConstraints();
                             col1.setPercentWidth(100);
                             
        //setting up the rows for the grid
        RowConstraints row1=new RowConstraints();
        RowConstraints row2=new RowConstraints();
        RowConstraints row3=new RowConstraints();
        RowConstraints row4=new RowConstraints();
        RowConstraints row5=new RowConstraints();
                        row1.setPercentHeight(20);
                        row2.setPercentHeight(10);
                        row3.setPercentHeight(50);
                        row4.setPercentHeight(10);
                        row5.setPercentHeight(10);
                        
        // adding constraints to grid
         grid.getColumnConstraints().addAll(col1);
         grid.getRowConstraints().addAll(row1,row2,row3,row4,row5);
        
         // the business label
         Text business=new Text("Lopsium Laundries and Home making");
         business.setFont( Font.font("ALGERIAN",50));
         GridPane.setHalignment(business, HPos.CENTER);
         grid.add(business,0,0,1,1);      
         
         Text services=new Text("Our Services");
         services.setFont(new Font("monospace",30));
         GridPane.setHalignment(services, HPos.CENTER);
         grid.add(services,0,1);
         addTable();
   }
   public static void addTable(){       
         //initializing the table
         servicesTable=new TableView();
         servicesTable.setId("table");
         servicesTable.setMinWidth(scene.getWidth()/2);
         servicesTable.setPrefWidth(300);
         servicesTable.setMaxWidth(scene.getWidth());
         servicesTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
         servicesTable.setPadding(new Insets(0,0,40,0));
        // servicesTable.setPrefHeight(30);
         
         
         servicesTable.setPrefHeight(20);
         //servicesTable.getSelectionModel().setCellSelectionEnabled(true);
         servicesTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
         
         servicesTable.setItems(Data.getServices());
         //initializing the table Columns
         TableColumn<Services,String> tabCol1=new TableColumn("Service");
         tabCol1.setCellValueFactory(new PropertyValueFactory("name"));
         
         TableColumn<Services,String> tabCol2=new TableColumn("Description");
         tabCol2.setCellValueFactory(new PropertyValueFactory("description"));
         tabCol2.setMinWidth(400);
         tabCol2.setCellFactory(new Callback<TableColumn<Services,String>,TableCell<Services,String>>(){

           @Override
           public TableCell<Services, String> call(TableColumn<Services, String> param) {
           TableCell<Services,String> cell=new TableCell();
           Text text=new Text();
           cell.setGraphic(text);
            cell.setPrefHeight(Control.USE_COMPUTED_SIZE);
           text.textProperty().bind(cell.itemProperty());
           text.wrappingWidthProperty().bind(tabCol2.widthProperty());
                   return cell;
           }
       
   });
         
         TableColumn<Services,Double> tabCol3=new TableColumn("Cost");
         tabCol3.setCellValueFactory(new PropertyValueFactory("price"));
         
         TableColumn<Services,Duration>tabCol4=new TableColumn("Duration");
         tabCol4.setCellValueFactory(new PropertyValueFactory("duration"));
         
         servicesTable.getColumns().addAll(tabCol1,tabCol2,tabCol3,tabCol4);
         GridPane.setHalignment(servicesTable, HPos.CENTER);
         
         grid.add(servicesTable, 0, 2);
         addingServices();
         
   }
   public static void addingServices(){
       HBox hbox=new HBox();
       JFXTextField servName=new JFXTextField();
       servName.setPromptText("Enter Name of Service");
       JFXTextField servDes=new JFXTextField();
       servDes.setPromptText("Describe the service");
       servDes.setPadding(new Insets(0,10,0,10));
       JFXTextField servPrice=new JFXTextField();
       servPrice.setPromptText("How Much Is This Service");
       Label label=new Label();
       JFXTextField dur=new JFXTextField();
       dur.setPromptText("Enter Duration of service");
       dur.setPadding(new Insets(0,10,0,10));
       JFXButton addBtn=new JFXButton("Add Service");
       addBtn.setOnAction(event->{
           if((servName.getText()!=null) && (servDes.getText()!=null )&& (servPrice.getText()!=null) 
                   && (dur.getText()!=null) ){   
               Data.addServices(servName.getText(),servDes.getText(),Double.parseDouble(servPrice.getText()),
                       new Duration(Integer.parseInt(dur.getText())));
               servName.setText(null);
               servDes.setText(null);
               servPrice.setText(null);
               dur.setText(null);
               label.setText(null);
           }else{
               label.setText("Enter Values into all fields");
           }
       });
       //deleting services
       JFXButton deleteBtn=new JFXButton("Delete Service");
       deleteBtn.setOnAction(event->{
          if(AlertBox.display("Delete Service","Do you want to delete this entry?")){
             ObservableList<Services> serv=servicesTable.getSelectionModel().getSelectedItems();
           ObservableList<Services> list=Data.servicesList;
               list.removeAll(serv);
          }
           event.consume();
       });
       hbox.getChildren().addAll(servName,servDes,servPrice,dur,addBtn,deleteBtn);
       hbox.setPadding(new Insets(10,10,10,10));
       hbox.setAlignment(Pos.CENTER);
       grid.add(hbox, 0, 3);
       grid.add(label,0,4);
       
   }
  
   // adding the menus for the application
   public static void addMenus(){
       MenuBar menuBar=new MenuBar();
       
       Menu file=new Menu("_Files");
       file.setMnemonicParsing(true);
       // adding a menu item to obtain customers  and services as spreadsheet as spreahsheet
       MenuItem custSpreadSheet=new MenuItem("Obtain Customers List");
       custSpreadSheet.setOnAction(event->{
           // enter code here
       });
       MenuItem servicesSheet=new MenuItem("Obtain Services List");
       servicesSheet.setOnAction(event->{
           // enter event code here
       });
       file.getItems().addAll(custSpreadSheet,servicesSheet);
      
       
       
       Menu services=new Menu("_Services");
       services.setMnemonicParsing(true);
       services.setOnAction(event->{
           firstScene();
       });
       
       Menu customers=new Menu("_Customers");
       customers.setMnemonicParsing(true);
       MenuItem customersItem=new MenuItem("Goto Customers View");
       customersItem.setOnAction(event->{
           // enter event response here
          SceneBuilder.customerScene();
       });
       customers.getItems().add(customersItem);
       
       Menu delivs=new Menu("_Deliveries");
       delivs.setMnemonicParsing(true);
       delivs.setOnAction(event->{
           // event code goes here
       });
       
       Menu comDeliveries=new Menu("_Completed Deliveries");
       comDeliveries.setMnemonicParsing(true);
       comDeliveries.setOnAction(event->{
           // event code goes here
       });
       
       menuBar.getMenus().addAll(file,services,customers,comDeliveries,delivs);
       pane.setTop(menuBar);
       
               }
    public static void main(String[] args) {
        launch(args);
    }
    public void setFirstScene(){
        Primary_Stage.setScene(scene);
    }
}
