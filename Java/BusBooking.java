import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Customer {
    private int id;
    private String name;
    private String password;
    private int age;
    private String gender;

    public Customer(int id, String name, String password, int age, String gender) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
}

class Seat {
    private String name;
    private Customer customer;

    public Seat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

class Bus {
    private String type;
    private int capacity;
    private List<Seat> seats;

    public Bus(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.seats = new ArrayList<>();
        initializeSeats();
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    private void initializeSeats() {
        if (type.equals("AC Seater")) {
            for (int i = 1; i <= 12; i++) {
                seats.add(new Seat("A" + i));
                seats.add(new Seat("C" + i));
            }
        } else if (type.equals("Non AC Seater")) {
            for (int i = 1; i <= 12; i++) {
                seats.add(new Seat("B" + i));
            }
        } else if (type.equals("AC Sleeper")) {
            for (int i = 1; i <= 6; i++) {
                seats.add(new Seat("A" + i));
                seats.add(new Seat("B" + i));
            }
        } else if (type.equals("Non AC Sleeper")) {
            for (int i = 1; i <= 6; i++) {
                seats.add(new Seat("A" + (i + 3)));
                seats.add(new Seat("B" + (i + 3)));
            }
        }
    }
}

class ZOBUS {
    private List<Customer> customers;
    private List<Bus> buses;

    public ZOBUS() {
        this.customers = new ArrayList<>();
        this.buses = new ArrayList<>();
        initializeData();
    }

    public void signUp() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        System.out.println("Enter your age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter your gender (M/F): ");
        String gender = scanner.nextLine();

        int id = customers.size() + 1;
        Customer customer = new Customer(id, name, password, age, gender);
        customers.add(customer);

        System.out.println("Sign up successful! Your ID is: " + id);
    }

    public Customer login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();

        for (Customer customer : customers) {
            if (customer.getId() == id && customer.getPassword().equals(password)) {
                System.out.println("Login successful! Welcome, " + customer.getName());
                return customer;
            }
        }

        System.out.println("Invalid credentials. Please try again.");
        return null;
    }

    public void displayBusOptions() {
        System.out.println("Bus options:");

        for (Bus bus : buses) {
            int remainingSeats = bus.getCapacity() - getFilledSeats(bus);
            System.out.println(bus.getType() + " - " + remainingSeats + " Seats");
        }
    }

    public void chooseSeats(Bus bus, Customer customer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Current status of the bus (Occupied seats are marked with 'X'):");

        for (Seat seat : bus.getSeats()) {
            if (seat.getCustomer() == null) {
                System.out.print(seat.getName() + " ");
            } else {
                System.out.print("X ");
            }
        }
        System.out.println();

        System.out.println("Enter the number of passengers: ");
        int numPassengers = Integer.parseInt(scanner.nextLine());

        if (numPassengers <= bus.getCapacity() - getFilledSeats(bus)) {
            for (int i = 0; i < numPassengers; i++) {
                System.out.println("Enter the name of passenger " + (i + 1) + ": ");
                String name = scanner.nextLine();
                System.out.println("Enter the gender of passenger " + (i + 1) + " (M/F): ");
                String gender = scanner.nextLine();

                Seat selectedSeat = selectSeat(bus, gender);
                if (selectedSeat != null) {
                    selectedSeat.setCustomer(new Customer(customer.getId(), name, customer.getPassword(), customer.getAge(), gender));
                    System.out.println("Seat " + selectedSeat.getName() + " booked for " + name);
                } else {
                    System.out.println("No suitable seat available for passenger " + name);
                }
            }
        } else {
            System.out.println("Number of passengers exceeds available seats. Please try again.");
        }
    }

    private Seat selectSeat(Bus bus, String gender) {
        for (Seat seat : bus.getSeats()) {
            if (seat.getCustomer() == null) {
                boolean adjacentSeatsOccupied = false;

                if (bus.getType().startsWith("AC")) {
                    adjacentSeatsOccupied = checkAdjacentSeatsAC(bus, seat.getName());
                } else if (bus.getType().startsWith("Non AC")) {
                    adjacentSeatsOccupied = checkAdjacentSeatsNonAC(bus, seat.getName());
                }

                if (!adjacentSeatsOccupied) {
                    return seat;
                }
            }
        }
        return null;
    }

    private boolean checkAdjacentSeatsAC(Bus bus, String seatName) {
        int seatIndex = Integer.parseInt(seatName.substring(1));

        if (seatName.charAt(0) == 'A' && seatIndex % 2 == 1) {
            Seat adjacentSeat = bus.getSeats().get(seatIndex);
            return adjacentSeat.getCustomer() != null;
        } else if (seatName.charAt(0) == 'B' && seatIndex % 2 == 0) {
            Seat adjacentSeat = bus.getSeats().get(seatIndex - 2);
            return adjacentSeat.getCustomer() != null;
        } else {
            return false;
        }
    }

    private boolean checkAdjacentSeatsNonAC(Bus bus, String seatName) {
        int seatIndex = Integer.parseInt(seatName.substring(1));

        if (seatName.charAt(0) == 'A' && seatIndex % 2 == 0) {
            Seat adjacentSeat = bus.getSeats().get(seatIndex);
            return adjacentSeat.getCustomer() != null;
        } else if (seatName.charAt(0) == 'B' && seatIndex % 2 == 1) {
            Seat adjacentSeat = bus.getSeats().get(seatIndex - 2);
            return adjacentSeat.getCustomer() != null;
        } else {
            return false;
        }
    }

    public double calculateFare(Bus bus, int numPassengers) {
        double fare = 0.0;

        if (bus.getType().startsWith("AC")) {
            if (bus.getType().contains("Sleeper")) {
                fare = 700.0;
            } else if (bus.getType().contains("Seater")) {
                fare = 550.0;
            }
        } else if (bus.getType().startsWith("Non AC")) {
            if (bus.getType().contains("Sleeper")) {
                fare = 600.0;
            } else if (bus.getType().contains("Seater")) {
                fare = 450.0;
            }
        }

        return fare * numPassengers;
    }

    public void confirmBooking(Customer customer, double fare) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Total fare: Rs " + fare);
        System.out.println("Do you want to confirm the booking? (Y/N)");

        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("Y")) {
            System.out.println("Booking confirmed!");
        } else {
            System.out.println("Booking canceled!");
        }
    }

    public void cancelTicket(Customer customer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("List of seats booked by you:");

        List<Seat> bookedSeats = new ArrayList<>();
        for (Bus bus : buses) {
            for (Seat seat : bus.getSeats()) {
                if (seat.getCustomer() != null && seat.getCustomer().getId() == customer.getId()) {
                    bookedSeats.add(seat);
                    System.out.println(seat.getName());
                }
            }
        }

        System.out.println("Enter the seat(s) you want to cancel (comma-separated): ");
        String input = scanner.nextLine();
        String[] seatNames = input.split(",");

        boolean cancelAll = input.equalsIgnoreCase("all");

        for (String seatName : seatNames) {
            for (Seat seat : bookedSeats) {
                if (cancelAll || seat.getName().equalsIgnoreCase(seatName.trim())) {
                    seat.setCustomer(null);
                    System.out.println("Seat " + seat.getName() + " canceled.");
                }
            }
        }
    }

    public void filterBuses(String type, String category) {
        List<Bus> filteredBuses = new ArrayList<>();
        for (Bus bus : buses) {
            if ((type.equalsIgnoreCase("AC") || type.equalsIgnoreCase("Both")) && bus.getType().startsWith("AC")) {
                if ((category.equalsIgnoreCase("Seater") || category.equalsIgnoreCase("Both")) && bus.getType().contains("Seater")) {
                    filteredBuses.add(bus);
                } else if ((category.equalsIgnoreCase("Sleeper") || category.equalsIgnoreCase("Both")) && bus.getType().contains("Sleeper")) {
                    filteredBuses.add(bus);
                }
            } else if ((type.equalsIgnoreCase("Non AC") || type.equalsIgnoreCase("Both")) && bus.getType().startsWith("Non AC")) {
                if ((category.equalsIgnoreCase("Seater") || category.equalsIgnoreCase("Both")) && bus.getType().contains("Seater")) {
                    filteredBuses.add(bus);
                } else if ((category.equalsIgnoreCase("Sleeper") || category.equalsIgnoreCase("Both")) && bus.getType().contains("Sleeper")) {
                    filteredBuses.add(bus);
                }
            }
        }

        System.out.println("Filtered buses:");
        for (Bus bus : filteredBuses) {
            int remainingSeats = bus.getCapacity() - getFilledSeats(bus);
            System.out.println(bus.getType() + " - " + remainingSeats + " Seats");
        }
    }

    private int getFilledSeats(Bus bus) {
        int filledSeats = 0;
        for (Seat seat : bus.getSeats()) {
            if (seat.getCustomer() != null) {
                filledSeats++;
            }
        }
        return filledSeats;
    }

    private void initializeData() {
        Bus bus1 = new Bus("AC Seater", 24);
        Bus bus2 = new Bus("Non AC Seater", 12);
        Bus bus3 = new Bus("AC Sleeper", 12);
        Bus bus4 = new Bus("Non AC Sleeper", 12);

        buses.add(bus1);
        buses.add(bus2);
        buses.add(bus3);
        buses.add(bus4);
    }
}

public class Main {
    public static void main(String[] args) {
        ZOBUS zobus = new ZOBUS();
        Scanner scanner = new Scanner(System.in);
        Customer customer = null;

        while (true) {
            System.out.println("ZOBUS - Online Bus Booking Application");
            System.out.println("1. Sign up");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.println("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    zobus.signUp();
                    break;
                case 2:
                    customer = zobus.login();
                    break;
                case 3:
                    System.out.println("Thank you for using ZOBUS. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            if (customer != null) {
                while (true) {
                    System.out.println("1. Book a ticket");
                    System.out.println("2. Cancel a ticket");
                    System.out.println("3. Filter buses");
                    System.out.println("4. Logout");
                    System.out.println("Enter your choice: ");
                    int userChoice = Integer.parseInt(scanner.nextLine());

                    switch (userChoice) {
                        case 1:
                            zobus.displayBusOptions();
                            System.out.println("Enter the type of bus (AC/Non AC/Both): ");
                            String type = scanner.nextLine();
                            System.out.println("Enter the category of bus (Seater/Sleeper/Both): ");
                            String category = scanner.nextLine();
                            zobus.filterBuses(type, category);
                            System.out.println("Enter the bus type you want to book: ");
                            String busType = scanner.nextLine();
                            Bus selectedBus = null;
                            for (Bus bus : zobus.buses) {
                                if (bus.getType().equalsIgnoreCase(busType)) {
                                    selectedBus = bus;
                                    break;
                                }
                            }
                            if (selectedBus != null) {
                                zobus.chooseSeats(selectedBus, customer);
                                int numPassengers = Integer.parseInt(scanner.nextLine());
                                double fare = zobus.calculateFare(selectedBus, numPassengers);
                                zobus.confirmBooking(customer, fare);
                            } else {
                                System.out.println("Invalid bus type. Please try again.");
                            }
                            break;
                        case 2:
                            zobus.cancelTicket(customer);
                            break;
                        case 3:
                            System.out.println("Enter the type of bus (AC/Non AC/Both): ");
                            String filterType = scanner.nextLine();
                            System.out.println("Enter the category of bus (Seater/Sleeper/Both): ");
                            String filterCategory = scanner.nextLine();
                            zobus.filterBuses(filterType, filterCategory);
                            break;
                        case 4:
                            customer = null;
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                            break;
                    }

                    if (customer == null) {
                        break;
                    }
                }
            }
        }
    }
}

