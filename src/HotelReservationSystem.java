import java.time.LocalDate;
import java.util.*;

//Program to show best deals in hotel reservation.
public class HotelReservationSystem {
    public ArrayList<Hotels> hotelList = new ArrayList<>();
    public static HotelReservationSystem reservationSystem = new HotelReservationSystem();
    public void findCheapestHotel(){
        int n;
        Scanner scanner = new Scanner(System.in);
        System.out.println("For how many days you want to book room");
        n = scanner.nextInt();
        String[] dateRange  = new String[n];
        System.out.println("Enter dates (eg. 12jan2022)");
        for (int i = 0; i < n; i++) {
            dateRange[i] = scanner.next();
        }
        int[] totalWeekAndWeekends = new int[n];
        totalWeekAndWeekends =  checkDay(dateRange);
        int[] totalRate = new int[]{0,0,0};
        for (int j = 0; j < totalRate.length; j++) {
            for (int i = 0; i < totalWeekAndWeekends.length; i++) {
                if (totalWeekAndWeekends[i] == 1) {
                        totalRate[j] += hotelList.get(j).getRegularWeekdayRates();
                    }
                else {
                    totalRate[j] += hotelList.get(j).getRegularWeekendRates();
                }
            }
        }
        String display = reservationSystem.compareAndGetCheapPrice(totalRate,reservationSystem.hotelList);
        System.out.println("-----------Hotels List-----------");
        System.out.println("Hotel Name\n"+display);
        System.out.println("-----------Hotels List-----------");
    }
    public void findCheapestHotelForRewardCustomer(){
        int n;
        Scanner scanner = new Scanner(System.in);
        System.out.println("For how many days you want to book room");
        n = scanner.nextInt();
        String[] dateRange  = new String[n];
        System.out.println("Enter dates (eg. 12jan2022)");
        for (int i = 0; i < n; i++) {
            dateRange[i] = scanner.next();
        }
        int[] totalWeekAndWeekends2 = new int[n];
        totalWeekAndWeekends2 =  checkDay(dateRange);
        int[] totalRate = new int[]{0,0,0};
        for (int j = 0; j < totalRate.length; j++) {
            for (int i = 0; i < totalWeekAndWeekends2.length; i++) {
                if (totalWeekAndWeekends2[i] == 1) {
                    totalRate[j] += hotelList.get(j).getRewardWeekdayRates();
                }
                else {
                    totalRate[j] += hotelList.get(j).getRewardWeekendRates();
                }
            }
        }
        String display = reservationSystem.compareAndGetCheapPrice(totalRate,reservationSystem.hotelList);
        System.out.println("-----------Hotels List-----------");
        System.out.println("Hotel Name\n"+display);
        System.out.println("-----------Hotels List-----------");
    }
    public int[] checkDay(String[] dates){
        int[] totalweeksAndweekends = new int[dates.length];
        int monthindex=0;
        int flag = 0;
        String[] month = {"jan","feb","mar","apr","may","jun","jul","aug","sep","oct","nov","dec"};
        String[] weekdays = {"MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY"};
        //storing weekday and weekend in array totalweekday and weekend
        for (int k = 0; k < dates.length; k++) {
            String q = dates[k].substring(2, 5);
            String dayOfMonth = dates[k].substring(0, 2);
            String year = dates[k].substring(5, dates[k].length());
            for (int i = 0; i < month.length; i++) {
                if (month[i].equals(q))
                    monthindex = i + 1;
            }
            //calculating which day from given date
            LocalDate localDate = LocalDate.of(Integer.parseInt(year), monthindex, Integer.parseInt(dayOfMonth));
            java.time.DayOfWeek dayOfWeek = localDate.getDayOfWeek();
            //checking and tracking weekday or weekend
            for (int i = 0; i < weekdays.length; i++) {
                if (dayOfWeek.toString().equals(weekdays[i]))
                { totalweeksAndweekends[flag] = 1;
                flag++;}
            }
        }

        return totalweeksAndweekends;
    }
    //comparing total prices
    public String  compareAndGetCheapPrice(int[] rate, ArrayList<Hotels> hotelList){
        if(rate[0]<rate[1] && rate[0]<rate[2])
            return reservationSystem.hotelList.get(0).getName()+", Rates:"+rate[0];
        else if(rate[1]<rate[2] && rate[1]<rate[0])
            return reservationSystem.hotelList.get(1).getName()+", Rates:"+rate[1];
        else
            return reservationSystem.hotelList.get(2).getName()+", Rates:"+rate[2];
    }
    public void findBestRatedHotel(){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < hotelList.size(); i++) {
            list.add(hotelList.get(i).getRating());
        }
        Collections.sort(list);
        Iterator<Hotels> iterator = hotelList.iterator();
        while (iterator.hasNext()){
            Hotels h1 = iterator.next();
            if(h1.getRating() == list.get(list.size()-1)){
                System.out.println(h1);
            }
        }
    }
//Updating the rates of each hotel
    public void updateRates(){
        System.out.println("Which hotel rate you want to update enter 0, 1 or 2");
        reservationSystem.hotelList.forEach(System.out::println);
        Scanner scanner =new Scanner(System.in);
        int choice = scanner.nextInt();
        System.out.println("Enter regular weekdays rate");
        reservationSystem.hotelList.get(choice).setRegularWeekdayRates(scanner.nextInt());
        System.out.println("Enter regular weekend rates");
        reservationSystem.hotelList.get(choice).setRegularWeekendRates(scanner.nextInt());
        System.out.println("Enter reward weekdays rates");
        reservationSystem.hotelList.get(choice).setRewardWeekdayRates(scanner.nextInt());
        System.out.println("Enter reward weekend rates");
        reservationSystem.hotelList.get(choice).setRewardWeekendRates(scanner.nextInt());
    }
    //feature to give rating to hotels
    public void rateHotels(){
        System.out.println("Which hotel do you want to rate enter 0, 1 or 2");
        reservationSystem.hotelList.forEach(System.out::println);
        Scanner scanner =new Scanner(System.in);
        int choice = scanner.nextInt();
        System.out.println("Enter regular weekdays rate");
        reservationSystem.hotelList.get(choice).setRating(scanner.next());
    }
    public void displayHotelList(){
        System.out.println("-----------Hotels List-----------");
        reservationSystem.hotelList.forEach(System.out::println);
        System.out.println("---------------------------------");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int flag = -1;
        System.out.println("Welcome to hotel reservation system");
        reservationSystem.hotelList.add(
                new Hotels("Lakewood","3",90,110,80,80));
        reservationSystem.hotelList.add(
                new Hotels("Bridgewood","4",60,160,50,110));
        reservationSystem.hotelList.add(
                new Hotels("Ridgewood","5",150,220,40,100));
        reservationSystem.displayHotelList();

        while (flag!=0){
            System.out.println("Enter choices \n1. Find budget hotel\n2. Update rates\n3. Give Rating\n4. Display list of hotels\n" +
                    "5. Find best rated hotel\n6. Find budget hotel for reward customers\n0. Exit  ");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:reservationSystem.findCheapestHotel();
                break;
                case 2:reservationSystem.updateRates();
                break;
                case 3:reservationSystem.rateHotels();
                break;
                case 4:reservationSystem.displayHotelList();
                break;
                case 5:reservationSystem.findBestRatedHotel();
                break;
                case 6:reservationSystem.findCheapestHotelForRewardCustomer();
                break;
                case 0:flag=0;
            }
        }

    }
}