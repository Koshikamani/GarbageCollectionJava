class Theatre{
    int totalSeats;
    public Theatre(int totalSeats){
        this.totalSeats=totalSeats;
    }
    public synchronized void bookTicket(String username,int seatstobook){
        System.out.println(username + " is trying to book " + seatstobook + " seat(s)...");
         try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            System.out.println("Booking interrupted for " + username);
        }
        if(seatstobook<=totalSeats){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
               
                e.printStackTrace();
            }
            System.out.println("User "+username+" Successfully booked "+seatstobook+" seats");
            totalSeats-=seatstobook;
            System.out.println("Seats left:"+totalSeats);
        }
        else{
            System.out.println(username+" Failed to book "+seatstobook+" Seats");
            System.out.println("remaining seats left:"+totalSeats);
        }
    }
}
class user extends Thread{
    Theatre theatre;
    int seatsNeeded;
    String username;
    public user(Theatre theatre,int seatsNeeded,String username){
        this.theatre=theatre;
        this.seatsNeeded=seatsNeeded;
        this.username=username;

    }
    public void run(){
        theatre.bookTicket(username, seatsNeeded);
    }
}

public class TicketBookingSystem {
    public static void main(String[] args) {
        Theatre theatre=new Theatre(20);
        user a=new user(theatre, 5, "raj");
        user b=new user(theatre, 6, "ram");
        user c=new user(theatre, 7, "john");
        user d=new user(theatre, 1, "snow");
        user e=new user(theatre, 2, "arya");
        user f=new user(theatre, 4, "stark");

        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
        f.start();

    }
}
