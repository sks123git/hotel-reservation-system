import java.util.ArrayList;
import java.util.Scanner;

//Program to show best deals in hotel reservation.
public class HotelReservationSystem {
    public ArrayList<Hotels> hotelList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int flag = -1;
        System.out.println("Welcome to hotel reservation system");
        HotelReservationSystem reservationSystem = new HotelReservationSystem();
        reservationSystem.hotelList.add(
                new Hotels("Lakewood","3",90,110,80,80));
        reservationSystem.hotelList.add(
                new Hotels("Bridgewood","4",60,160,50,110));
        reservationSystem.hotelList.add(
                new Hotels("Ridgewood","5",150,220,40,100));
        reservationSystem.hotelList.forEach(System.out::println);
        while (flag!=0){
            int rewardType;
            System.out.println("Enter details\nIf reward customer press 1 or else press 0 if regular");
            rewardType = scanner.nextInt();
        }
    }
}