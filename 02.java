class ParkingLot {

    private static class Vehicle {
        private String licensePlate;
        private String ownerName;
        private int hoursParked;

        public Vehicle(String licensePlate, String ownerName, int hoursParked) {
            this.licensePlate = licensePlate;
            this.ownerName = ownerName;
            this.hoursParked = hoursParked;
        }

        public String getLicensePlate(){ 
			return licensePlate; 
		}
		
        public String getOwnerName(){ 
			return ownerName; 
		}
		
        public int getHoursParked(){ 
			return hoursParked; 
		}
    }

	private Vehicle[] vehicles = new Vehicle[5];
    private int count = 0;
	
    public void parkVehicle(Vehicle vehicle) {
        if (count < 5) {
			vehicles[count++] = vehicle;
		}
    }

    public void removeVehicle(String licensePlate) {
        for (int i = 0; i < count; i++) {
            if (vehicles[i].getLicensePlate().equals(licensePlate)) {
                for (int j = i; j < count - 1; j++){ 
					vehicles[j] = vehicles[j + 1];
					count--;
					count--;
				}
                return;
            }
        }
		
        System.out.println("Vehicle not found.");
    }

	public void displayParkedVehicles() {
        for (int i = 0; i <= count; i++) {
            Vehicle v = vehicles[i];
			
            System.out.println("Licence Plate Number: " + v.getLicensePlate());
			System.out.println("Owner: " + v.getOwnerName());
			System.out.println("Hours Parked: " + v.getHoursParked());
        }
    }
		
			
			

    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot();
		
        parkingLot.parkVehicle(new Vehicle("ABC123", "John Doe", 2));
        parkingLot.parkVehicle(new Vehicle("XYZ789", "Jane Smith", 4));
        parkingLot.parkVehicle(new Vehicle("LMN456", "Bob Brown", 1));

        parkingLot.removeVehicle("XYZ789");
		
        parkingLot.displayParkedVehicles();
    }
}
