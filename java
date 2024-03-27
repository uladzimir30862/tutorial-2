import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Museum!");

        System.out.print("Enter visitor's age: ");
        int age = scanner.nextInt();

        System.out.print("Enter visitor's city : ");
        String city = scanner.nextLine();

        System.out.print("Enter day of visit : ");
        String day = scanner.nextLine();
        double ticketPrice = calculateTicketPrice (age, city, day);

        System.out.println("\nClient data:");
        System.out.println("  - Age: " + age);
        System.out.println("  - City: " + city);
        System.out.println("  - Day: " + day);
        System.out.println();
        System.out.println("Ticket price: " + ticketPrice + " PLN");
        System.out.println("Discount: " + (ticketPrice == 40 ? "Free Entry" : (40 - ticketPrice) + " PLN"));
    }
    private static double calculateTicketPrice(int age, String city, String day) {
        double basePrice = 40.0;
        double discount = 0.0;

        if (age < 10) {
            discount = basePrice;
        } else if (age <= 18) {
            discount = basePrice * 0.5;
        }
        if (city.equalsIgnoreCase("Warsaw") && !"Thursday".equalsIgnoreCase(day)) {
            discount += discount > 0 ? discount * 0.1 : basePrice * 0.1;
        }
        if ("Thursday".equalsIgnoreCase(day)) {
            discount = basePrice;
        }
        return basePrice - discount;
    }
}

