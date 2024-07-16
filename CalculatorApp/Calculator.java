import java.util.Scanner;

public class Calculator {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        print("Welcome to the Complex and Rational Number Calculator!");
        print("This calculator can handle both complex and rational numbers.");
        print("");
        print("Examples of valid inputs:");
        print("Complex numbers: '1 + 2i', '-3.5 - 4.2i', '2/3 + 5/6i'");
        print("Rational numbers: '1/2', '-3/4', '5', '2.5'");
        print("");
        while (true) {
            print("Enter the first number (complex or rational, or 'q' to quit):");
            String input1 = scanner.nextLine();
            if (input1.equalsIgnoreCase("q")) {
                break;
            }

            print("Enter the operation (+, -, *, /):");
            String operation = scanner.nextLine();

            print("Enter the second number (complex or rational):");
            print("Examples: '-2.5 + 3.7i', '1/3 + 1/4i', '2/3', '4'");
            String input2 = scanner.nextLine();

            Complex c1 = new Complex(input1);
            Complex c2 = new Complex(input2);
            Complex result;

            switch (operation) {
                case "+":
                    result = c1.add(c2);
                    break;
                case "-":
                    result = c1.subtract(c2);
                    break;
                case "*":
                    result = c1.multiply(c2);
                    break;
                case "/":
                    result = c1.divide(c2);
                    break;
                default:
                    print("Invalid operation");
                    continue;
            }

            print("Result: " + result);
            print("");
        }

        print("Calculator closed.");
        scanner.close();
    }
    public static void print(String s){
		System.out.println(s);

	}
}