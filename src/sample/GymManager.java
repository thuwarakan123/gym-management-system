package sample;



import java.io.IOException;
import java.util.ArrayList;

public interface GymManager {

    public void Add_Member();
    public void Delete_Member();
    public void print_Member();
    public void Sort_Member();
    public void Print_File() throws IOException;
    public String Search_Member(int Number);



    ArrayList<DefaultMember> ListofMembers = new ArrayList<>();
    ArrayList<DefaultMember> ListofMembers_2 = new ArrayList<>();
    int count = 0;



}
