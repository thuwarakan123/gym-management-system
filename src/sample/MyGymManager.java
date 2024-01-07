package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;



public class MyGymManager implements GymManager   {
      public static ArrayList<DefaultMember> ListofMembers = new ArrayList<>();
      ArrayList<DefaultMember> ListofMembers_2 = new ArrayList<>();

      int count = 0;


    public void Add_Member(){
        try {
            Scanner get =new Scanner(System.in);
            if (count <100) {
                count = ListofMembers.size();
                int total = 100 - count;
                System.out.println("\n" + total + "more members can be add ");
                System.out.println("----select member type for adding member----\n");
                System.out.println("Enter 1 for Default member");
                System.out.println("Enter 2 for Student member");
                System.out.println("Enter 3 for Over60 member");
                System.out.print("\nNumber : ");
                int member_selector = get.nextInt();


                if (member_selector == 1) {
                    System.out.print("Enter member Name : ");
                    get.nextLine();
                    String obj_name = get.nextLine();
                    System.out.println("\nEnter StartMembershipDate (all inputs in numbers)");
                    System.out.print("Enter Start Year : ");
                    int year = get.nextInt();
                    System.out.print("Enter Start Month : ");
                    int month = get.nextInt();
                    System.out.print("Enter Start Day : ");
                    int day = get.nextInt();

                    Date date_start = new Date(year, month, day);
                    DefaultMember member = new DefaultMember(obj_name.toLowerCase(), date_start);
                    ListofMembers.add(member);
                    ListofMembers_2.add(member);
                    System.out.println("You Successfully added the member");

                } else if (member_selector == 2) {
                    System.out.print("Enter member Name : ");
                    get.nextLine();
                    String obj_name = get.nextLine();
                    System.out.println("\nEnter StartMembershipDate (all inputs in numbers)");
                    System.out.print("Enter Start Year : ");
                    int year = get.nextInt();
                    System.out.print("Enter Start Month : ");
                    int month = get.nextInt();
                    System.out.print("Enter Start Day : ");
                    int day = get.nextInt();
                    System.out.print("Enter member school name :");
                    get.nextLine();
                    String obj_school = get.nextLine();

                    Date date_start = new Date(year, month, day);
                    StudentMember member = new StudentMember(obj_name.toLowerCase(), date_start);
                    member.setSchoolName(obj_school.toLowerCase());
                    ListofMembers.add(member);
                    ListofMembers_2.add(member);
                    System.out.println("You Successfully added the member");

                } else if (member_selector == 3) {
                    System.out.print("Enter member Name : ");
                    get.nextLine();
                    String obj_name = get.nextLine();
                    System.out.println("\nEnter StartMembershipDate (all inputs in numbers)");
                    System.out.print("Enter Start Year : ");
                    int year = get.nextInt();
                    System.out.print("Enter Start Month : ");
                    int month = get.nextInt();
                    System.out.print("Enter Start Day : ");
                    int day = get.nextInt();
                    System.out.print("Enter member Age(in numbers) :");
                    int obj_age = get.nextInt();

                    Date date_start = new Date(year, month, day);
                    Over60Member member = new Over60Member(obj_name.toLowerCase(), date_start, obj_age);
                    ListofMembers.add(member);
                    ListofMembers_2.add(member);
                    System.out.println("You Successfully added the member");

                } else {
                    System.out.println("Wrong Number Please check your input");
                }

            } else {
                System.out.println("system can store max 100 members");
            }
        }
        catch (RuntimeException e){
            System.out.println("\nInvalid input");

        }
    }

    public void Delete_Member(){
        try{
            if(ListofMembers.size() != 0) {
                Scanner get = new Scanner(System.in);
                System.out.print("\nEnter deleting member MembershipNumber : ");
                int number = get.nextInt();

                if (number > 1000) {
                    for (int i = 0; i < ListofMembers.size(); i++) {
                        int check = ListofMembers.get(i).getMembershipNumber();
                        if (number == check) {
                            System.out.println("\nyou successfully deleted the " + ListofMembers.get(i).getType());
                            ListofMembers.remove(i);
                            ListofMembers_2.remove(i);
                            break;

                        } else {
                            System.out.println("\nYou input is not match with the values");
                        }
                    }
                } else {
                    System.out.println("\nInvalid Membership Number");
                }
            }
            else{
                System.out.println("\nYour total member count is 0 \nFirst add some members");
            }
        }
        catch(RuntimeException e){
                   System.out.println("\nInvalid input");
        }
    }

    public void print_Member() {
            if (ListofMembers.size() != 0) {
                System.out.println("\n Member No     Member Name        date            Type\n");
                for (int i = 0; i < ListofMembers.size(); i++) {
                    System.out.println(ListofMembers.get(i).getInformation());

                }
            } else {
                System.out.println("\nYour total member count is 0 \nFirst add some members");
            }
        }

    public void Sort_Member(){
        if(ListofMembers_2.size() != 0) {
            int length = ListofMembers_2.size();
            for(int i=0; i <length-1;i++) {
                for (int j = 0; j < length - (i + 1); j++) {
                    if (ListofMembers_2.get(j).getMemberName().compareTo(ListofMembers_2.get(j + 1).getMemberName()) > 0) {
                        DefaultMember part =ListofMembers_2.get(j);
                        ListofMembers_2.set(j,ListofMembers_2.get(j+1));
                        ListofMembers_2.set(j+1,part);
                    }
                }
            }
            System.out.println("\n Member No     Member Name        date            Type\n");
            for (int i = 0; i < ListofMembers_2.size(); i++) {
                System.out.println(ListofMembers_2.get(i).getInformation());
            }
        }
        else{
            System.out.println("Your total member count is 0 \nFirst add some members");
        }
    }

    public void Print_File() throws IOException {
        if(ListofMembers.size() != 0) {
            //File myfile = new File("C:\\Users\\thuwarakan\\Documents\\pp2-file\\memberFile.txt");
            File myfile = new File("memberFile.txt");
            FileWriter wrt = null;
            PrintWriter prt = null;
            try {
                wrt = new FileWriter(myfile, true);
                prt = new PrintWriter(wrt, true);

                for(int i = 0; i < ListofMembers.size();i++){
                    prt.println("\n"+ListofMembers.get(i).writeFile());


                }
            } catch (Exception e) {
                System.out.println("Something wrong");
            } finally {
                wrt.close();
                prt.close();
            }
        }
        else{
            System.out.println("Your total member is 0 \nFirst add some members");
        }
    }


    public String Search_Member(int Number){
        String set = null;
        for(int i = 0; i < ListofMembers.size(); i++){
            if(Number == ListofMembers.get(i).getMembershipNumber()){
                set = ListofMembers.get(i).writeFile();
                break;
            }
            else{
                set = "Invalid Number";
            }
        }
        return set;
    }

    public static ObservableList printTable() {
        ObservableList<DefaultMember> tableList = FXCollections.observableArrayList();
        for(DefaultMember member : ListofMembers) {
            tableList.add(member);
        }
        return  tableList;
    }
}
