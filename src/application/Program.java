package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reservation;



public class Program {

	public static void main(String[] args) throws ParseException{
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf =  new SimpleDateFormat("dd/MM/yyyy");
		Date now = new Date();
		System.out.println("Enter with the number room:");
		Integer room = sc.nextInt();
		System.out.println("\nEnter with Checkin Date:");
		Date checkin = sdf.parse(sc.next());
		System.out.println("\nEnter with Checkout Date:");
		Date checkout = sdf.parse(sc.next());
		if(!checkout.after(checkin) || checkin.before(now) && checkout.before(now)) {
			System.out.println("Error in reservation: Invalide Dates!");
		}else {
		Reservation res = new Reservation(room, checkin, checkout);
		System.out.println(res.toString() + "\n");
		
		System.out.println("Enter with upDate checkin:");
		checkin = sdf.parse(sc.next());
		System.out.println("\nEnter with upDate checkout:");
		checkout = sdf.parse(sc.next());
		String error = res.updateDates(checkin, checkout);
		if(error != null) {
			System.out.println("Error in reservation: " + error);
		}else {
			System.out.println("\nUpdates in reservetion: " + res.toString());
		}
		}
		
		
	}

}


