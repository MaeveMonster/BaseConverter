/**Author: Katie Roy
 * Date: Jun 3, 2015
 * Assignment: KMRFinalProject.java
 */

import java.util.Scanner;

public class KMR_Final_Project_2 {

	public static void main(String[] args) {
		String str1, str2, str3;
		int numBase10;
		int base1 = getValidBase("Enter the starting base. ");
		System.out.print("Starting base: " + base1);
		System.out.println("");
		str1 = getValidNum(base1);
		numBase10 = fromBaseXToBaseTen(str1, base1);
		System.out.println("\n" + str1 + " in base " + base1 + " is " + numBase10 + " in base 10.");
		System.out.println("");
		int base2 = getValidBase("Enter the ending base. ");
		System.out.print("Ending base: " + base2);
		System.out.println("");
		str2 = fromBaseTenToBaseY(numBase10, base2);
		System.out.println("");
		System.out.print(numBase10 + " in base 10 is " + str2 + " in base " + base2 + ".");
		System.out.println("");
		str3 = fromBaseXToBaseY(base1, str1, base2);
		System.out.println("");
		System.out.print(str1 + " in base " + base1 + " is " + str3 + " in base " + base2 + ".");

	}
	/**
	 * pre: str represents which base is being read (a prompt for the input)
	 * post: returns a valid base, such that 2<=base<=16
	 */
	public static int getValidBase (String str){
		Scanner input = new Scanner(System.in);
		int base;
		System.out.print(str);

		do{
			System.out.print("Base must be an INTEGER between 2 and 16: ");
			if(!input.hasNextInt()){
				System.out.print("Not an integer. Try again. ");
				base = -1;
				input.next();
			}
			else{
				base = input.nextInt();
				if ((2 > base) || (base > 16))
					System.out.print("Invalid range. Try again: ");
			}
		}while ((2 > base) || (base > 16));

		return base;
	}
	/**
	 * pre: charArr contains characters representing digits, i.e. '3' represents 3 and 'A' or 'a' both represent 10
	 * post: returns array of int values of each digit, if a given character cannot represent a digit -1 is stored
	 */
	private static int[] toIntArray (char[] charArr){
		int [] intArr = new int[charArr.length];
		for (int i = 0; i < charArr.length; i++){
			if (charArr[i] == '0')
				intArr[i] = 0;
			if (charArr[i] == '1')
				intArr[i] = 1;
			if (charArr[i] == '2')
				intArr[i] = 2;
			if (charArr[i] == '3')
				intArr[i] = 3;
			if (charArr[i] == '4')
				intArr[i] = 4;
			if (charArr[i] == '5')
				intArr[i] = 5;
			if (charArr[i] == '6')
				intArr[i] = 6;
			if (charArr[i] == '7')
				intArr[i] = 7;
			if (charArr[i] == '8')
				intArr[i] = 8;
			if (charArr[i] == '9')
				intArr[i] = 9;
			if (charArr[i] == 'a' || charArr[i] == 'A')
				intArr[i] = 10;
			if (charArr[i] == 'b' || charArr[i] == 'B')
				intArr[i] = 11;
			if (charArr[i] == 'c' || charArr[i] == 'C')
				intArr[i] = 12;
			if (charArr[i] == 'd' || charArr[i] == 'D')
				intArr[i] = 13;
			if (charArr[i] == 'e' || charArr[i] == 'E')
				intArr[i] = 14;
			if (charArr[i] == 'f' || charArr[i] == 'F')
				intArr[i] = 15;
			if (charArr[i] == 'g' || charArr[i] == 'G')
				intArr[i] = -1;
			if (charArr[i] == 'h' || charArr[i] == 'H')
				intArr[i] = -1;
			if (charArr[i] == 'i' || charArr[i] == 'I')
				intArr[i] = -1;
			if (charArr[i] == 'j' || charArr[i] == 'J')
				intArr[i] = -1;
			if (charArr[i] == 'k' || charArr[i] == 'K')
				intArr[i] = -1;
			if (charArr[i] == 'l' || charArr[i] == 'L')
				intArr[i] = -1;
			if (charArr[i] == 'm' || charArr[i] == 'M')
				intArr[i] = -1;
			if (charArr[i] == 'n' || charArr[i] == 'N')
				intArr[i] = -1;
			if (charArr[i] == 'o' || charArr[i] == 'O')
				intArr[i] = -1;
			if (charArr[i] == 'p' || charArr[i] == 'P')
				intArr[i] = -1;
			if (charArr[i] == 'q' || charArr[i] == 'Q')
				intArr[i] = -1;
			if (charArr[i] == 'r' || charArr[i] == 'R')
				intArr[i] = -1;
			if (charArr[i] == 's' || charArr[i] == 'S')
				intArr[i] = -1;
			if (charArr[i] == 't' || charArr[i] == 'T')
				intArr[i] = -1;
			if (charArr[i] == 'u' || charArr[i] == 'U')
				intArr[i] = -1;
			if (charArr[i] == 'v' || charArr[i] == 'V')
				intArr[i] = -1;
			if (charArr[i] == 'w' || charArr[i] == 'W')
				intArr[i] = -1;
			if (charArr[i] == 'x' || charArr[i] == 'X')
				intArr[i] = -1;
			if (charArr[i] == 'y' || charArr[i] == 'Y')
				intArr[i] = -1;
			if (charArr[i] == 'z' || charArr[i] == 'Z')
				intArr[i] = -1;

		}
		return intArr;
	}
	/**
	 * pre: needs the base (between 2 and 16 inclusive) the number should be i to check validity, i.e. a number in base 5 can only contain digits 0-4
	 * post: returns a string representing a number valid in the given base
	 */
	public static String getValidNum (int base){
		Scanner input = new Scanner(System.in);
		String str1 = "";
		int [] intArr;
		do{
			System.out.print("\nEnter a number in base " + base + ": ");
			str1 = input.nextLine();

			char [] charArr = new char[str1.length()];
			intArr = new int [str1.length()];

			for (int i = 0; i < str1.length(); i++)
				charArr [i] = str1.charAt(i);

			for (int i = 0 ; i < intArr.length; i++)
				intArr [i] = (toIntArray(charArr)) [i];

			if (intArrayBaseCheck(base, intArr) == false){
				System.out.print("Invalid for base " + base + ". Try again.");

			}


		}while (intArrayBaseCheck(base, intArr) == false);

		return str1;
	}
	/**
	 * pre: needs the number to convert to and the current base
	 * post: returns the base 10 equivalent
	 */
	private static int fromBaseXToBaseTen (String num, int base){
		char [] charArr = new char[num.length()];
		int [] intArr = new int [num.length()];
		int base10 = 0;

		for (int i = 0; i < num.length(); i++)
			charArr [i] = num.charAt(i);

		for (int i = 0; i < intArr.length; i++)
			intArr [i] = (toIntArray(charArr)) [i];

		for (int i = 0; i < ((int)intArr.length/2); i++){
			int tempStore = intArr[i];
			intArr [i] = intArr [intArr.length - i - 1];
			intArr [intArr.length - i - 1] = tempStore;
		}

		for (int i = 0; i < intArr.length; i++)
			base10 += intArr[i] * (int)Math.pow(base, (i));

		return base10;
	}
	/**
	 * pre: needs a base 10 number and the base to convert it to which must be between 2 and 16 inclusive 
	 * post: returns a String version of the number in the given base
	 * comments: this freaking method. If I ever have to look at it again I'm going to burn my computer.
	 */
	private static String fromBaseTenToBaseY (int num, int base){
		int x = 0;
		String str = "";
		while (num > 0){
			x = num%base;
			num = num/base;
			str = String.valueOf(x) + str;
		}
		return str;
	}

	/**
	 * pre: needs 2<=baseX<=16, a valid number in baseX and 2<=baseY<=16
	 * post: returns a String representation of the number in baseY
	 */
	public static String fromBaseXToBaseY (int baseX, String num, int baseY){
		int temp = fromBaseXToBaseTen(num,baseX);
		String str = fromBaseTenToBaseY(temp, baseY);
		return str;

	}

	/**
	 * pre: must receive an int base and an int array
	 * post: returns true if all elements of given int array are int representations of valid digits in the base given
	 */
	public static boolean intArrayBaseCheck (int base, int [] intArr){
		int count = 0;
		for (int i = 0; i<intArr.length; i++){
			if ((intArr[i] >= base) || (intArr[i] == -1))
				count++;
		}	
		if (count == 0)
			return true;
		else
			return false;
	}
}

/**
* Enter the starting base. Base must be an INTEGER between 2 and 16: 16
* Starting base: 16
*
* Enter a number in base 16: f
*
* f in base 16 is 15 in base 10.
*
* Enter the ending base. Base must be an INTEGER between 2 and 16: 2
* Ending base: 2
*
* 15 in base 10 is 1111 in base 2.
*
* f in base 16 is 1111 in base 2.
**/