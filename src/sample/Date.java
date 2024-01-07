package sample;

public class Date {
    private int Day;
    private int Month;
    private int Year;


    public Date(int S_year, int S_Month, int S_Day){
          setYear(S_year);
          setMonth(S_Month);
          setDay(S_Day);
    }

    private void setYear(int S_Year){
        if(S_Year>2000 && S_Year<2030 ){
            Year = S_Year;
        }
        else{
            System.out.println("\nYou enter a wrong year");
        }
    }

    private void setMonth(int S_Month){
            if (S_Month > 0 && S_Month <= 12) {
                Month = S_Month;
            }
            else {
                System.out.println("\nInvalid Month");
            }
      }

    private void setDay(int S_Day){
        int DaysinMonth[] = {31,29,31,30,31,30,31,31,30,31,30,31};
        if(S_Day <= DaysinMonth[Month-1]){
            if(Month==2 && S_Day == 29) {
                if(Year%4 == 0){
                    Day = S_Day;
                }
                else{
                    System.out.println("\n"+Year+" is not a leap year");
                }
            }
            else{
                Day = S_Day;
            }
        }
        else{

            System.out.println("\n Invalid Day");
        }
    }

    public String getDate(){
        String Date = Day+"/"+Month+"/"+Year;
        return Date;
    }

}