import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        boolean repeat = true;

        while (repeat) {

            country(scan);
            scan.nextLine();

            System.out.println("Do you want to make another transaction? (Y/N): ");
            String answer = scan.nextLine();

            if (!answer.equalsIgnoreCase("Y")) {
                repeat = false;
            }
        }

        myText("Thanks for choosing, CJ Airlines");
    }

    public static void myText(String text) {
        System.out.println(text);

    }

    public static void country(Scanner scan) {
        myText("Country Name    Adult Price   Children Price");
        myText("Singapore       $500          $300");
        myText("Canada          $700          $500");
        myText("Thailand        $500          $500");
        myText("Australia       $800          $600");
        myText("Hongkong        $400          $300");
        myText("Vietnam         $500          $400");
        myText("Brunei          $600          $500");
        myText("China           $700          $600");
        myText("Indonesia       $300          $300");
        myText("Taiwan          $500          $300");

        double adult = 0;
        double children = 0;

        System.out.print("\nEnter a country: ");
        String country = scan.nextLine();
        int adults = 0;
        int childrenCount = 0;
        try {
            System.out.println("Enter number of adults: ");
            adults = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Numbers only!! ");
            scan.nextLine();
            return;
        }
        System.out.println("Enter number of children: ");
        childrenCount = scan.nextInt();
        switch (country) {

            case "Singapore":
                adult = 500;
                children = 300;
                break;
            case "Canada":
                adult = 700;
                children = 300;
                break;
            case "Thailand":
                adult = 500;
                children = 300;
                break;
            case "Australia":
                adult = 800;
                children = 300;
                break;
            case "Hongkong":
                adult = 400;
                children = 300;
                break;
            case "Vietnam":
                adult = 500;
                children = 400;
                break;
            case "Brunei":
                adult = 600;
                children = 500;
                break;
            case "China":
                adult = 700;
                children = 600;
                break;
            case "Indonesia":
                adult = 300;
                children = 300;
                break;
            case "Taiwan":
                adult = 500;
                children = 300;
                break;
            default:
                System.out.println("Invalid country.");
                return;
        }

        double totalAdult = adults * adult;
        double totalChildren = childrenCount * children;
        double discountChildren = 10 / 100.0;
        double discount = discountChildren * totalChildren;
        double finalChildrenPrice = totalChildren - discount;
        double total = totalAdult + finalChildrenPrice;

        System.out.println("Adult price: $" + totalAdult);
        System.out.println("Children price: $" + finalChildrenPrice);
        System.out.println("Discount price: $" + discount);
        System.out.println("Total Rate: $" + total);

        try {
            FileWriter writer = new FileWriter("transaction.txt");
            writer.write("Country: " + country + "\n");
            writer.write("Adults: " + adults + "\n");
            writer.write("Children: " + childrenCount + "\n");
            writer.write("Discount: $" + discount + "\n");
            writer.write("Total: $" + total + "\n");
            writer.close();
            System.out.println("Transaction saved.");
        } catch (IOException e) {
            System.out.println("Error writing file.");
        }
    }
}