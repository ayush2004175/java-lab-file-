public class DataTypeAndControlDemo {
    public static void main(String[] args) {

        // -----------------------------
        // 1. DATA TYPES
        // -----------------------------
        int age = 21;
        double salary = 45000.50;
        char grade = 'A';
        boolean isActive = true;
        String name = "Alice";

        System.out.println("=== Data Types Demo ===");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);
        System.out.println("Grade: " + grade);
        System.out.println("Active Employee: " + isActive);

        // -----------------------------
        // 2. IF-ELSE STATEMENT
        // -----------------------------
        System.out.println("\n=== If-Else Demo ===");
        if (age >= 18) {
            System.out.println(name + " is an adult.");
        } else {
            System.out.println(name + " is a minor.");
        }

        // -----------------------------
        // 3. SWITCH CASE
        // -----------------------------
        System.out.println("\n=== Switch Case Demo ===");
        int day = 3;
        switch (day) {
            case 1:
                System.out.println("Sunday");
                break;
            case 2:
                System.out.println("Monday");
                break;
            case 3:
                System.out.println("Tuesday");
                break;
            case 4:
                System.out.println("Wednesday");
                break;
            default:
                System.out.println("Invalid day");
        }

        // -----------------------------
        // 4. FOR LOOP
        // -----------------------------
        System.out.println("\n=== For Loop Demo ===");
        for (int i = 1; i <= 5; i++) {
            System.out.println("For Loop Count: " + i);
        }

        // -----------------------------
        // 5. WHILE LOOP
        // -----------------------------
        System.out.println("\n=== While Loop Demo ===");
        int count = 5;
        while (count > 0) {
            System.out.println("While Loop Count: " + count);
            count--;
        }
    }
}

