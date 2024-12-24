import java.io.*;
import java.util.*;

public class RestaurantMenu {

    static List<Food> foodList = new ArrayList<>();
    static List<Drink> drinkList = new ArrayList<>();

    public static void showMenu() {
        System.out.println("\n==== Menu Nhà Hàng ====");
        System.out.println("1. Thêm món ăn");
        System.out.println("2. Thêm nước uống");
        System.out.println("3. Hiển thị danh sách món ăn");
        System.out.println("4. Hiển thị danh sách nước uống");
        System.out.println("5. Xóa món ăn");
        System.out.println("6. Xóa nước uống");
        System.out.println("7. Sửa món ăn");
        System.out.println("8. Sửa nước uống");
        System.out.println("9. Đọc từ file CSV");
        System.out.println("10. Ghi vào file CSV");
        System.out.println("11. Thoát");
        System.out.print("Vui lòng chọn: ");
    }
    public static void addFood(Scanner scanner) {
        System.out.print("Nhập tên món ăn: ");
        String name = scanner.nextLine();
        System.out.print("Nhập giá món ăn (VNĐ): ");
        double price = Double.parseDouble(scanner.nextLine());

        Food food = new Food(name, price);
        foodList.add(food);
        System.out.println("Đã thêm món ăn: " + name);
    }
    public static void addDrink(Scanner scanner) {
        System.out.print("Nhập tên nước uống: ");
        String name = scanner.nextLine();
        System.out.print("Nhập giá nước uống (VNĐ): ");
        double price = Double.parseDouble(scanner.nextLine());

        Drink drink = new Drink(name, price);
        drinkList.add(drink);
        System.out.println("Đã thêm nước uống: " + name);
    }
    public static void showFoods() {
        System.out.println("\nDanh sách món ăn:");
        if (foodList.isEmpty()) {
            System.out.println("Chưa có món ăn nào.");
        } else {
            for (Food food : foodList) {
                food.display();
            }
        }
    }
    public static void showDrinks() {
        System.out.println("\nDanh sách nước uống:");
        if (drinkList.isEmpty()) {
            System.out.println("Chưa có nước uống nào.");
        } else {
            for (Drink drink : drinkList) {
                drink.display();
            }
        }
    }
    public static void readFromCSV() {
        readFoodFromCSV("foods.csv");
        readDrinkFromCSV("drinks.csv");
    }
    public static void writeToCSV() {
        writeFoodToCSV("foods.csv");
        writeDrinkToCSV("drinks.csv");
    }
    private static void writeFoodToCSV(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Tên Món Ăn, Giá\n");  // Header of CSV file
            for (Food food : foodList) {
                writer.write(food.getName() + "," + food.getPrice() + "\n");
            }
            System.out.println("Đã ghi danh sách món ăn vào file " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void writeDrinkToCSV(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Tên Nước Uống, Giá\n");  // Header of CSV file
            for (Drink drink : drinkList) {
                writer.write(drink.getName() + "," + drink.getPrice() + "\n");
            }
            System.out.println("Đã ghi danh sách nước uống vào file " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void readFoodFromCSV(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            reader.readLine(); // Skip header line
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 2) {
                    String name = data[0];
                    double price = Double.parseDouble(data[1]);
                    Food food = new Food(name, price);
                    foodList.add(food);
                }
            }
            System.out.println("Đã đọc danh sách món ăn từ file " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void readDrinkFromCSV(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            reader.readLine(); // Skip header line
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 2) {
                    String name = data[0];
                    double price = Double.parseDouble(data[1]);
                    Drink drink = new Drink(name, price);
                    drinkList.add(drink);
                }
            }
            System.out.println("Đã đọc danh sách nước uống từ file " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Xóa món ăn theo tên
    public static void deleteFood(Scanner scanner) {
        System.out.print("Nhập tên món ăn muốn xóa: ");
        String name = scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < foodList.size(); i++) {
            if (foodList.get(i).getName().equalsIgnoreCase(name)) {
                foodList.remove(i);
                System.out.println("Đã xóa món ăn: " + name);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy món ăn: " + name);
        }
    }

    // Xóa nước uống theo tên
    public static void deleteDrink(Scanner scanner) {
        System.out.print("Nhập tên nước uống muốn xóa: ");
        String name = scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < drinkList.size(); i++) {
            if (drinkList.get(i).getName().equalsIgnoreCase(name)) {
                drinkList.remove(i);
                System.out.println("Đã xóa nước uống: " + name);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy nước uống: " + name);
        }
    }
    public static void editFood(Scanner scanner) {
        System.out.print("Nhập tên món ăn muốn sửa: ");
        String name = scanner.nextLine();

        boolean found = false;
        for (Food food : foodList) {
            if (food.getName().equalsIgnoreCase(name)) {
                System.out.print("Nhập tên mới cho món ăn: ");
                food.setName(scanner.nextLine());
                System.out.print("Nhập giá mới cho món ăn (VNĐ): ");
                food.setPrice(Double.parseDouble(scanner.nextLine()));
                System.out.println("Đã sửa món ăn: " + food.getName());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy món ăn: " + name);
        }
    }
    public static void editDrink(Scanner scanner) {
        System.out.print("Nhập tên nước uống muốn sửa: ");
        String name = scanner.nextLine();

        boolean found = false;
        for (Drink drink : drinkList) {
            if (drink.getName().equalsIgnoreCase(name)) {
                System.out.print("Nhập tên mới cho nước uống: ");
                drink.setName(scanner.nextLine());
                System.out.print("Nhập giá mới cho nước uống (VNĐ): ");
                drink.setPrice(Double.parseDouble(scanner.nextLine()));
                System.out.println("Đã sửa nước uống: " + drink.getName());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy nước uống: " + name);
        }
    }
}
