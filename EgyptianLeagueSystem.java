import java.util.Scanner;
import java.util.Random;

public class EgyptianLeagueSystem {
    static String[] teams = {
        "Al Ahly", "Zamalek", "Pyramids", "Al Masry", "Al Ittihad", "Modern Future", 
        "Smouha", "ZED FC", "Ismaily", "National Bank", "Enppi", "Arab Contractors",
        "El Gouna", "Pharco FC", "Baladiyat Mahalla", "Tala'ea Gaish", "El Dakhleya", "Ceramica"
    };
    static String[] stadiums = {"Cairo Stadium", "Borg El Arab", "Suez Canal", "Al Salam", "Alexandria"};
    
    static String[] week26 = new String[9];
    static String[] week27 = new String[9];
    static String[] week28 = new String[9];

    static String[] bookPhone = new String[1000];
    static String[] bookMatch = new String[1000];
    static int[] bookQty =  new int[1000];
    static double[] bookPrice = new double[1000];
    static int totalBookings = 0;

    static Scanner sc = new Scanner(System.in);
    static Random r = new Random();

    public static void main(String[] args) {
        generateWeek(week26, 3);
        generateWeek(week27, 10);
        generateWeek(week28, 17);

        int choice = 0;
        while (choice != 4) {
            System.out.println("\n===== EGYPTIAN LEAGUE TICKETING =====");
            System.out.println("1. Book Tickets");
            System.out.println("2. View My Bookings");
            System.out.println("3. Refund Tickets");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();

            if (choice == 1) createBooking();
            else if (choice == 2) viewBooking();
            else if (choice == 3) refundBooking();
        }
    }

    static void generateWeek(String[] week, int startDay) {
        for (int i = 0; i < teams.length; i++) {
            int target = r.nextInt(teams.length);
            String temp = teams[i];
            teams[i] = teams[target];
            teams[target] = temp;
        }

        for (int i = 0; i < 9; i++) {
            String home = teams[i * 2];
            String away = teams[i * 2 + 1];
            String stadium = stadiums[r.nextInt(stadiums.length)];
            String date = (startDay + (i / 3)) + "/04/2026";
            String time = (18 + r.nextInt(3)) + ":00";
            week[i] = home + " vs " + away + " | " + stadium + " | " + date + " @ " + time;
        }
    }

    static void createBooking() {
        String ph = "";
        while (true) {
            System.out.print("Enter Phone (11 digits): ");
            ph = sc.next();
            if (ph.length() == 11) break;
            System.out.println("Error: Must be 11 digits!");
        }

        System.out.println("\nSelect Game Week: 1) Game Week 26  2) Game Week 27  3) Game Week 28");
        int w = sc.nextInt();
        String[] selectedWeek = (w == 1) ? week26 : (w == 2) ? week27 : week28;

        System.out.println("\n--- Available Matches ---");
        for (int i = 0; i < 9; i++) {
            System.out.println((i + 1) + ". " + selectedWeek[i]);
        }

        System.out.print("Select Match ID (1-9): ");
        int mId = sc.nextInt() - 1;

        System.out.println("Category: 1.VIP(500) 2.First(150) 3.Third(75)");
        int cat = sc.nextInt();
        double p = (cat == 1) ? 500 : (cat == 2) ? 150 : 75;

        System.out.print("Quantity: ");
        int q = sc.nextInt();

        bookPhone[totalBookings] = ph;
        bookMatch[totalBookings] = selectedWeek[mId];
        bookQty[totalBookings] = q;
        bookPrice[totalBookings] = p * q;
        totalBookings++;

        System.out.println(">> Done! Booking Saved.\n");
        System.out.println(">> ! We will send you an instant payment reference code within one hour..\n");
    }

    static void viewBooking() {
        System.out.print("Enter Phone: ");
        String ph = sc.next();
        boolean found = false;
        for (int i = 0; i < totalBookings; i++) {
            if (bookPhone[i].equals(ph)) {
                System.out.println("\n- " + bookMatch[i]);
                System.out.println("  Tickets: " + bookQty[i] + " | Total: " + bookPrice[i] + " EGP");
                found = true;
            }
        }
        if (!found) System.out.println("No records found.");
    }

    static void refundBooking() {
        System.out.print("Enter Phone to Refund: ");
        String ph = sc.next();
        int count = 0;
        
        for (int i = 0; i < totalBookings; i++) {
            if (bookPhone[i].equals(ph)) {
                for (int j = i; j < totalBookings - 1; j++) {
                    bookPhone[j] = bookPhone[j + 1];
                    bookMatch[j] = bookMatch[j + 1];
                    bookQty[j] = bookQty[j + 1];
                    bookPrice[j] = bookPrice[j + 1];
                }
                totalBookings--;
                i--; 
                count++;
            }
        }
        if (count > 0) System.out.println(">> " + count + " Booking(s) Refunded.");
        else System.out.println(">> Not found.");
    }
}