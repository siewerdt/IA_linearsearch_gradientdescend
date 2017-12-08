import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// values to be applied in the function
		double a, b;
		// separate elements of the [x,y] array
		double x, y;
		// result of the third calculated dimension
		double currentResult = 0, previousResult = 200;

		@SuppressWarnings("resource")
		Scanner consoleReader = new Scanner(System.in);

		System.out.println("Initial entry (a or x1): ");
		a = consoleReader.nextDouble();
		System.out.println("Initial entry (b or x2): ");
		b = consoleReader.nextDouble();

		double alpha = 0.01;
		double tolerance = 0.0001;
		int iterationCounter = 0;

		// continues to search while the difference between current and previous is
		// higher than the tolerance
		while (Math.abs(currentResult - previousResult) > tolerance) {
			iterationCounter++;
			previousResult = currentResult;

			// considering that the gradient is [firstDerivateA(a,b),firstDerivateB(a,b)]
			x = a - alpha * firstDerivateA(a, b);
			y = b - alpha * firstDerivateB(a, b);

			// resulting value
			currentResult = function(x, y);
			System.out.println("\nIteration " + iterationCounter + " result: " + currentResult);

			// updating values to the next iteration
			a = x;
			b = y;
		}
	}

	public static double function(double a, double b) {
		return (4 - 2.1 * Math.pow(a, 2) + (1 / 3) * Math.pow(a, 4)) * Math.pow(a, 2) + a * b
				- 4 * (1 - Math.pow(b, 2)) * Math.pow(b, 2);
	}

	public static double firstDerivateA(double a, double b) {
		return 8 * a - 8.4 * Math.pow(a, 3) + 2 * Math.pow(a, 5) + b;
	}

	public static double firstDerivateB(double a, double b) {
		return a - 8 * b + 16 * Math.pow(b, 3);
	}

	/**
	 * Turns out this is unecessary because i'd have to create functions to subtract
	 * and multiply arrays, that's a lot of work, i'll simply use two separate
	 * variables representing [x,y]
	 */
	// public ArrayList<Double> gradient(double a, double b) {
	// ArrayList<Double> gradient = new ArrayList<Double>();
	// gradient.add(firstDerivateA(a, b));
	// gradient.add(firstDerivateB(a, b));
	// return gradient;
	// }
}