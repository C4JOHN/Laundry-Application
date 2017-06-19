
package laundryapplication;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author removevirus
 */
public class SceneBuilder{
     static GridPane root1;
     static Scene scene;
        
   public static void customerScene(){
       root1 =new GridPane();
       
       ColumnConstraints col1=new ColumnConstraints();
                         col1.setPercentWidth(100);
        RowConstraints row1=new RowConstraints();
        RowConstraints row2=new RowConstraints();
        RowConstraints row3=new RowConstraints();
        RowConstraints row4=new RowConstraints();
                        row1.setPercentHeight(10);
                        row2.setPercentHeight(60);
                        row3.setPercentHeight(20);
                        row4.setPercentHeight(10);
        root1.getColumnConstraints().addAll(col1);
        root1.getRowConstraints().addAll(row1,row2,row3,row4);
                    
       
         scene = new Scene(root1, 1000, 600, Color.rgb(0, 0, 0, 0));
          setTable();
        LaundryApplication.scene.setRoot(root1);
                }
public static void setTable(){
        Label topLabel=new Label("List of Customers"); 
        topLabel.setFont( Font.font("ALGERIAN",50));
        GridPane.setHalignment(topLabel, HPos.CENTER);
        topLabel.setPadding(new Insets(20,0,10,0));
        TableView<Customer> customerTabView=new TableView();
    
         customerTabView.setMinWidth(scene.getWidth()/2);
         customerTabView.setPrefWidth(300);
         customerTabView.setMaxWidth(scene.getWidth());
         GridPane.setHalignment(customerTabView, HPos.CENTER);
         
          // to remove extra columns
         customerTabView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
         customerTabView.setPadding(new Insets(0,0,40,0));
        // customerTabView.setPrefHeight(30);
         
         
         customerTabView.setPrefHeight(20);
         //customerTabView.getSelectionModel().setCellSelectionEnabled(true);
         customerTabView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
         
         customerTabView.setItems(Data.getCustomers());
         
         TableColumn<Customer,String> nameCol=new TableColumn("Name");
         nameCol.setCellValueFactory(new PropertyValueFactory("name"));
         
         TableColumn<Customer,String> noCol=new TableColumn("Phone Number");
         noCol.setCellValueFactory(new PropertyValueFactory("phoneNumber"));
         
         TableColumn<Customer,String> addCol=new TableColumn("Address");
         addCol.setCellValueFactory(new PropertyValueFactory("address"));
         
         customerTabView.getColumns().addAll(nameCol,noCol,addCol);
         
         root1.add(topLabel, 0,0);
         root1.add(customerTabView, 0,1);
         
         HBox hbox=new HBox();

         JFXTextField nameField=new JFXTextField();
         nameField.setPromptText("Enter Your Name here");
         
         JFXTextField numField=new JFXTextField();
         numField.setPromptText("Enter Phone Number");
         numField.setPadding(new Insets(0,10,0,10));
         
         JFXTextField addressField=new JFXTextField();
         addressField.setPromptText("Enter Customer's Address");
         
         Label warningLabel=new Label();
         
         JFXButton addBtn=new JFXButton("Add");
         addBtn.setOnAction(event->{
             if((nameField.getText()!=null) && (numField.getText()!=null )&& (addressField.getText()!=null) 
                   ){
                 Data.addCustomers(nameField.getText(), numField.getText(), addressField.getText());
                 nameField.setText(null);
                 numField.setText(null);
                 addressField.setText(null);
             }
         });
         
         JFXButton deleteBtn=new JFXButton("Delete");
         deleteBtn.setOnAction(event->{
             if(AlertBox.display("Delete Customer","Do you want to delete this entry?")){
             ObservableList<Customer> selected=customerTabView.getSelectionModel().getSelectedItems();
             ObservableList<Customer> list=Data.customersList;
               list.removeAll(selected);
          }
           event.consume();
         });
         
       hbox.getChildren().addAll(nameField,numField,addressField,addBtn,deleteBtn);
       hbox.setPadding(new Insets(10,10,10,10));
       hbox.setAlignment(Pos.CENTER);
       root1.add(hbox, 0, 2);
       root1.add(warningLabel, 0, 3);
}
}

