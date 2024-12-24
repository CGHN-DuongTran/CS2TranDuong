import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            RestaurantMenu.showMenu();
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    RestaurantMenu.addFood(scanner);
                    break;
                case 2:
                    RestaurantMenu.addDrink(scanner);
                    break;
                case 3:
                    RestaurantMenu.showFoods();
                    break;
                case 4:
                    RestaurantMenu.showDrinks();
                    break;
                case 5:
                    RestaurantMenu.deleteFood(scanner);
                    break;
                case 6:
                    RestaurantMenu.deleteDrink(scanner);
                    break;
                case 7:
                    RestaurantMenu.editFood(scanner);
                    break;
                case 8:
                    RestaurantMenu.editDrink(scanner);
                    break;
                case 9:
                    RestaurantMenu.readFromCSV();
                    break;
                case 10:
                    RestaurantMenu.writeToCSV();
                    break;
                case 11:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }

        } while (choice != 11);

        scanner.close();
    }
}
