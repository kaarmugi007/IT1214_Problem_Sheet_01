class BookingSystem {
    private static class Ticket {
        private int ticketNumber;
        private String customerName;
        private int seatNumber;


        public Ticket(int ticketNumber, String customerName, int seatNumber) {
            this.ticketNumber = ticketNumber;
            this.customerName = customerName;
            this.seatNumber = seatNumber;
        }

        public int getSeatNumber(){ 
			return seatNumber; 
		}
		
        public int getTicketNumber(){ 
			return ticketNumber; 
		}
		
		public String getCustomerName(){
			return customerName;
		}
		
       /* public String toString() {
            return String.format("Ticket %d: %s (Seat %d)", ticketNumber, customerName, seatNumber);
        }*/
    }
	
	private Ticket[] tickets = new Ticket[10];
    private int count = 0;
	
    public boolean bookTicket(Ticket ticket) {
        for (int i = 0; i < count; i++) {
            if (tickets[i].getSeatNumber() == ticket.getSeatNumber()) 
				return false;
        }
		
        if (count < 10) {
            tickets[count++] = ticket;
            return true;
        }
        return false;
    }

    public void cancelTicket(int ticketNumber) {
        for (int i = 0; i < count; i++) {
            if (tickets[i].getTicketNumber() == ticketNumber) {
                for (int j = i; j < count - 1; j++) tickets[j] = tickets[j + 1];
                count--;
                break;
            }
        }
    }

    public void displayBookings() {
        for (int i = 0; i < count; i++){ 
			Ticket t = tickets[i];
			
			System.out.println("Ticket: " + t.getTicketNumber());
			System.out.println("Customer Name: " + t.getCustomerName());
			System.out.println("Seat Number: " + t.getSeatNumber());
		}
    }

    public static void main(String[] args) {
        BookingSystem bookingSystem = new BookingSystem();
        bookingSystem.bookTicket(new Ticket(1, "Customer A", 1));
        bookingSystem.bookTicket(new Ticket(2, "Customer B", 2));
        bookingSystem.bookTicket(new Ticket(3, "Customer C", 3));

        bookingSystem.cancelTicket(2);
        bookingSystem.bookTicket(new Ticket(4, "Customer D", 2));
        bookingSystem.displayBookings();
    }
}
