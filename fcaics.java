import java.util.Scanner;

public class fcaics {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String phone, password;

        System.out.println("===== Welcome to FCAI Cash =====");
        System.out.println("Set up your wallet first.");
        System.out.print("Enter your phone number: ");
        phone = sc.nextLine();
        System.out.print("Set a new password: ");
        password = sc.nextLine();

        String inputPhone, inputPass;
        double balance = 0;
        int mainChoice;

        
        String[] charities = {"Egyptian Red Crescent", "Save Gaza", "Baheya Hospital"};

        do {
            System.out.println("\n===== Main Menu =====");
            System.out.println("1- Login");
            System.out.println("2- Forgot Password");
            System.out.println("3- Exit");
            System.out.print("Choose: ");
            mainChoice = sc.nextInt();
            sc.nextLine(); 

            if(mainChoice == 1) {
                System.out.print("Enter phone number: ");
                inputPhone = sc.nextLine();
                System.out.print("Enter password: ");
                inputPass = sc.nextLine();

                if(inputPhone.equals(phone) && inputPass.equals(password)) {
                    System.out.println("\nLogin successful!");
                    int choice;

                    do {
                        System.out.println("\n===== FCAI Cash Menu =====");
                        System.out.println("1- Deposit");
                        System.out.println("2- Withdraw");
                        System.out.println("3- Check Balance");
                        System.out.println("4- Donate");
                        System.out.println("5- Logout");
                        System.out.print("Enter your choice: ");
                        choice = sc.nextInt();
                        sc.nextLine(); 

                        if(choice == 1) {
                            System.out.print("Enter amount to deposit: ");
                            double deposit = sc.nextDouble();
                            sc.nextLine();
                            if(deposit > 0) {
                                balance += deposit;
                                System.out.println("Deposit successful. Current balance: " + balance);
                            } else {
                                System.out.println("Invalid amount.");
                            }

                        } else if(choice == 2) {
                            System.out.print("Enter amount to withdraw: ");
                            double withdraw = sc.nextDouble();
                            sc.nextLine();
                            if(withdraw > 0 && withdraw <= balance) {
                                balance -= withdraw;
                                System.out.println("Withdrawal successful. Current balance: " + balance);
                            } else {
                                System.out.println("Insufficient balance or invalid amount.");
                            }

                        } else if(choice == 3) {
                            System.out.println("Current balance: " + balance);

                        } else if(choice == 4) {
                            System.out.println("Choose charity to donate:");
                            for(int i=0; i<3; i++) {
                                System.out.println((i+1) + "- " + charities[i]);
                            }
                            System.out.print("Enter choice: ");
                            int charityChoice = sc.nextInt();
                            sc.nextLine();
                            if(charityChoice >= 1 && charityChoice <= 3) {
                                System.out.print("Enter amount to donate: ");
                                double donateAmount = sc.nextDouble();
                                sc.nextLine();
                                if(donateAmount > 0 && donateAmount <= balance) {
                                    balance -= donateAmount;
                                    System.out.println("Donation successful! Remaining balance: " + balance);
                                } else {
                                    System.out.println("Insufficient balance or invalid amount.");
                                }
                            } else {
                                System.out.println("Invalid charity choice.");
                            }

                        } else if(choice == 5) {
                            System.out.println("Logged out successfully.");
                        } else {
                            System.out.println("Invalid choice.");
                        }

                    } while(choice != 5);

                } else {
                    System.out.println("Wrong phone or password.");
                }

            } else if(mainChoice == 2) {
                System.out.print("Enter your phone number to reset password: ");
                String recoveryPhone = sc.nextLine();
                if(recoveryPhone.equals(phone)) {
                    System.out.print("Enter new password: ");
                    password = sc.nextLine();
                    System.out.println("Password changed successfully.");
                } else {
                    System.out.println("Phone number not found.");
                }

            } else if(mainChoice == 3) {
                System.out.println("Thank you for using FCAI Cash.");
            } else {
                System.out.println("Invalid choice.");
            }

        } while(mainChoice != 3);

        sc.close();
    }
}