package model.entities;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Integer room;
	private Date checkin;
	private Date checkout;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation(Integer room, Date checkin, Date checkout) {
		this.room = room;
		this.checkin = checkin;
		this.checkout = checkout;
	}
	public Integer getRoom() {
		return room;
	}
	public void setRoom(Integer room) {
		this.room = room;
	}
	public Date getCheckin() {
		return checkin;
	}
	public Date getCheckout() {
		return checkout;
	}
	
	public long duration() {
		long diff = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public String updateDates(Date checkin, Date checkout) {
		Date now = new Date();
		if(checkin.before(now) || checkout.before(now)) {
			return "Reservation dates for updates must be future dates!";
		}else if(!checkout.after(checkin)){
			return "Error in reservation: Check-out date must be after check-in date!";
		}else {
			this.checkin = checkin;
			this.checkout = checkout;
		}
		return null;
	}
	
  @Override
  
  public String toString() {
	  return "Room: " + room +
			  ", Checkin Date: " + sdf.format(checkin)
			  + ", checkout Date: " + sdf.format(checkout)
			  + ", duration: " + duration() + " nights";
  }
  
	
	
	
	
	
	
	
	
}
