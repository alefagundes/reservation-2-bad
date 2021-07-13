package application;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reservation;
import model.exception.DomainException;



public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.println("Room Number:");
			Integer room = sc.nextInt();
			System.out.println("\nCheck-in Date (dd/MM/yyyy):");
			Date checkin = sdf.parse(sc.next());
			System.out.println("\nCheck-out Date (dd/MM/yyyy):");
			Date checkout = sdf.parse(sc.next());
	
			Reservation res = new Reservation(room, checkin, checkout);
			System.out.println(res.toString() + "\n");
	
			System.out.println("Update check-in (dd/MM/yyyy):");
			checkin = sdf.parse(sc.next());
			System.out.println("\nUpdate check-out(dd/MM/yyyy):");
			checkout = sdf.parse(sc.next());
	
			res.updateDates(checkin, checkout);
			System.out.println("\n Update reservation: " + res.toString());
		}
		catch(ParseException e) {
			System.out.println("Invalid date formar!");
		
		}catch(DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		
		}catch(RuntimeException e) {
			System.out.println("Unexpected error!");
		
	  }
	}
}



