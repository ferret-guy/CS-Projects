public class Proj3_Repeat {
	public static void main(String[] args) {
		//Check Args for Sanity
		if (args.length == 0 || args.length % 2 != 0) {
			System.out.println("Invalid input!, format is:");
			System.out.println("    Proj3_Repeat word1 <# of times> word 2 <# of times> ect...");
			return;
		}
		for (int i = 0; i < args.length; i += 2) {
			//Check to see if the number can be converted to an int
			try {
				Integer.parseInt(args[i + 1].trim());
			} catch (NumberFormatException e) {
				System.out.println(args[i + 1] + " is not an int!");
				return;
			}

			//Check to see if arg is negitive
			if (Integer.parseInt(args[i + 1].trim()) < 1) {
				System.out.println(args[i + 1] + " is negitive or invalid");
				return;
			}
		}
		//Step through arguments
		for (int i = 0; i < args.length; i += 2) {
			for (int n = Integer.parseInt(args[i + 1].trim()); n > 0; n--) {
				System.out.println(args[i]);
			}
		}
	}
}