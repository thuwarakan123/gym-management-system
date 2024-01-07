package sample;

public class DefaultMember {
    private String MemberName;
    private static int MemberCount;
    private int MembershipNumber;
    private Date StartMembershipDate;
    private static String Type;


    public DefaultMember(String Name, Date S_Date ) {
        super();
        setMemberName(Name);
        StartMembershipDate = S_Date;
        MemberCount=MemberCount+1;
        MembershipNumber = 1000 + MemberCount;
    }

    public void setMemberName(String Name) {
        MemberName = Name;
    }

    public String getMemberName(){
        return MemberName;
    }

    public int getMembershipNumber(){
        return MembershipNumber;
    }

    public String getType(){
        Type = "Default Member";
        return Type;
    }

    public String getInformation(){
        String info = String.format("%6s %18s %15s %18s",MembershipNumber, MemberName, StartMembershipDate.getDate(), getType());
        return info;
    }

    public String writeFile(){
        return "Name = "+MemberName+"\nMembershipNumber = "+MembershipNumber+"\nStart Date = "+StartMembershipDate.getDate()
                +"\nType = "+getType();
    }

}