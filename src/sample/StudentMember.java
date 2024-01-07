package sample;

public class StudentMember extends DefaultMember {
    private String SchoolName;
    private static int StudentCount;
    private static String Type;

    public StudentMember(String Name ,Date S_Date) {
        super(Name, S_Date);
        StudentCount = StudentCount +1;
    }

    public void setSchoolName(String S_Name){
        SchoolName = S_Name;
    }

    public String getSchoolName(){
        return SchoolName;
    }

    public String getType(){
        Type = "Student Member";
        return Type;
    }
}
