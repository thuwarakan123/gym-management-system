package sample;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.*;
import java.util.Scanner;
import static sample.MyGymManager.printTable;

public class Main extends Application {

    @Override
    public void start(Stage ManagerUI) throws Exception {
        ManagerUI.setTitle("UI for Manager");
        TabPane UIforManager = new TabPane();

        Tab List_of_members = new Tab("Search Members");

        TableView table = new TableView();

        TableColumn<DefaultMember, Integer> column1 = new TableColumn<>("Member Id");
        column1.setMinWidth(100);
        column1.setCellValueFactory(new PropertyValueFactory<>("MembershipNumber"));

        TableColumn<DefaultMember, String> column2 = new TableColumn<>("Name");
        column2.setMinWidth(150);
        column2.setCellValueFactory(new PropertyValueFactory<>("MemberName"));

        TableColumn<DefaultMember, String> column3 = new TableColumn<>("Type");
        column3.setMinWidth(150);
        column3.setCellValueFactory(new PropertyValueFactory<>("Type"));

        table.getColumns().addAll(column1, column2, column3);
        table.setItems(printTable());

        VBox vbox = new VBox(table);
        Pane base_1 = new Pane(vbox);
        List_of_members.setContent(base_1);
        //--------------------------------------------------------------------------------------------------------
        Tab Search_member = new Tab("Search Members");

        Label label_1 = new Label();
        label_1.setText("Welcome!\nYou can search members from here.\nBy members membership number ");
        label_1.setLayoutY(20);
        label_1.setLayoutX(15);
        label_1.setStyle("-fx-text-fill: black;-fx-font:bold 14px 'arialblack'");

        TextField search = new TextField();
        search.setLayoutX(45);
        search.setLayoutY(100);
        search.setStyle("-fx-font:bold 18px 'arialblack';-fx-background-radius:22px");

        Button get = new Button("Search");
        get.setLayoutX(300);
        get.setLayoutY(98);
        get.setStyle("-fx-background-color:darkslateblue;-fx-text-fill: white;-fx-background-radius:28px;" +
                "-fx-padding:8px;-fx-font:bold 16px 'arialblack'");

        Label label_2 = new Label();
        label_2.setLayoutY(175);
        label_2.setLayoutX(80);
        label_2.setStyle("-fx-text-fill: black;-fx-font:bold 14px 'arialblack'");

        Pane base_2 = new Pane();
        base_2.setStyle("-fx-background-color:lightblue;");
        base_2.getChildren().addAll(label_1,search,get,label_2);
        Search_member.setContent(base_2);

       get.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                MyGymManager manage = new MyGymManager();
                try {
                    int number = Integer.parseInt(search.getText());
                    if (number > 1000) {
                         label_2.setText(manage.Search_Member(number));
                    } else {
                        label_2.setText("Invalid Number");
                    }
                } catch (RuntimeException e) {
                    label_2.setText("System only accept Integer number");
                }
            }
        });
        //--------------------------------------------------------------------------------------------------------

        UIforManager.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        UIforManager.getTabs().addAll(List_of_members, Search_member);
        ManagerUI.setScene(new Scene(UIforManager, 400, 400));

        ManagerUI.show();
    }

    
    public static void main(String[] args) throws IOException {
        MyGymManager manager_1 = new MyGymManager();

        while (true) {
            System.out.println("\n============================ Welcome ===========================");
            System.out.println("\nYou can select which method you Want\nby Entering Number\n ");
            System.out.println("1 = Adding members (this method will help you to add members.)");
            System.out.println("2 = Deleting members (this method will help you to Delete members by there MembershipNumber)");
            System.out.println("3 = Print member details (this method will print a list of members with details.)");
            System.out.println("4 = Sort member (this method will help you to sort members by there name.)");
            System.out.println("5 = Write File  (this method will help you to Write and Save member details in file.)");
            System.out.println("6 = Open UI (this method will help you to Search members and display members list.)");
            try {
                Scanner input = new Scanner(System.in);
                System.out.print("\nEnter the method Number : ");
                int method_no = input.nextInt();

                switch (method_no) {
                    case 1:
                        manager_1.Add_Member();
                        break;
                    //case 1 is finish
                    case 2:
                        manager_1.Delete_Member();
                        break;
                    // case 2 is finish
                    case 3:
                        manager_1.print_Member();
                        break;
                    // case 3 is finish
                    case 4:
                        manager_1.Sort_Member();
                        break;
                    // case 4 is finish
                    case 5:
                        manager_1.Print_File();
                        break;
                    //case 5 is finish
                    case 6:
                        launch(args);
                        break;
                    //case 6 is finish
                    default:
                        System.out.println("\nYou Enter a wrong number ");


                }

            } catch (RuntimeException e) {
                System.out.println("\nThe System only accept 'Integer' Value");
            }
        }



    }



}






