public class Proj3_Squares {
	public static void main(String[] args) {
		//Check Args for Sanity
		if (args.length != 2) {
			System.out.println("Invalid input!, format is:");
			System.out.println("    Proj3_Squares num_from num_to");
			return;
		}
		for (int i = 0; i < args.length; i++) {
			//Check to see if the number can be converted to an int
			try {
				Integer.parseInt(args[i].trim());
			} catch (NumberFormatException e) {
				System.out.println(args[i] + " is not an int!");
				return;
			}
		}
		//Step through squares
		for (int i = Integer.parseInt(args[0].trim()); i <= Integer.parseInt(args[1].trim()); i++) {
			System.out.println("The square of " + i + " is " + (int) Math.pow(i, 2));
		}
	}
}