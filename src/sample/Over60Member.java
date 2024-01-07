package sample;

public class Over60Member extends DefaultMember {
    private int Age;
    private static int OldAgeMember;
    private static String Type;

    public Over60Member(String Name, Date S_Date, int M_Age) {
        super(Name, S_Date);
        setAge(M_Age);
        OldAgeMember =+ 1;
    }

    public void setAge(int M_Age){
        if(M_Age > 60 && M_Age <100){
            Age = M_Age;
        }
        else {
             System.out.print("Age is wrong");
        }

    }

    public int getAge(){
        return Age;
    }

    public String getType(){
        Type = "Over60 Member";
        return Type;
    }

}
