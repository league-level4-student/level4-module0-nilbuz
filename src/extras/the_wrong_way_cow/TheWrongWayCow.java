//https://www.codewars.com/kata/the-wrong-way-cow
//
//Task
//Given a field of cows find which one is the Wrong-Way Cow and return her position.
//
//Notes:
//
//There are always at least 3 cows in a herd
//There is only 1 Wrong-Way Cow!
//Fields are rectangular
//The cow position is zero-based [x,y] of her head (i.e. the letter c)
//Examples
//Ex1
//
//cow.cow.cow.cow.cow
//cow.cow.cow.cow.cow
//cow.woc.cow.cow.cow
//cow.cow.cow.cow.cow
//Answer: [6,2]
//
//Ex2
//
//c..........
//o...c......
//w...o.c....
//....w.o....
//......w.cow
//Answer: [8,4]
//
//Notes
//The test cases will NOT test any situations where there are "imaginary" cows, so your solution does not need to worry about such things!
//
//To explain - Yes, I recognize that there are certain configurations where an "imaginary" cow may appear that in fact is just made of three other "real" cows.
//In the following field you can see there are 4 real cows (3 are facing south and 1 is facing north). There are also 2 imaginary cows (facing east and west).
//
//...w...
//..cow..
//.woco..
//.ow.c..
//.c.....

package extras.the_wrong_way_cow;

public class TheWrongWayCow {

	public static int[] findWrongWayCow(final char[][] field) {
		// Fill in the code to return the x,y coordinate position of the
		// head (letter 'c') of the wrong way cow!

		int nCows = 0;
		int eCows = 0;
		int sCows = 0;
		int wCows = 0;

		int[] lastNCowCoords = new int[2];
		int[] lastECowCoords = new int[2];
		int[] lastSCowCoords = new int[2];
		int[] lastWCowCoords = new int[2];

		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {

				if (field[i][j] == "c".charAt(0)) {

					// north
					if (j - 1 >= 0) {
						if (field[i][j - 1] == "o".charAt(0)) {
							if (j - 2 >= 0) {
								if (field[i][j - 2] == "w".charAt(0)) {

									nCows++;
									lastNCowCoords[0] = j;
									lastNCowCoords[1] = i;

								}
							}
						}
					}

					// east
					if (i + 1 < field.length) {
						if (field[i + 1][j] == "o".charAt(0)) {
							if (i + 2 < field.length) {
								if (field[i + 2][j] == "w".charAt(0)) {

									eCows++;
									lastECowCoords[0] = j;
									lastECowCoords[1] = i;

								}
							}
						}
					}

					// south
					if (j + 1 < field[i].length) {
						if (field[i][j + 1] == "o".charAt(0)) {
							if (j + 2 < field[i].length) {
								if (field[i][j + 2] == "w".charAt(0)) {

									sCows++;
									lastSCowCoords[0] = j;
									lastSCowCoords[1] = i;

								}
							}
						}
					}

					// west
					if (i - 1 >= 0) {
						if (field[i - 1][j] == "o".charAt(0)) {
							if (i - 2 >= 0) {
								if (field[i - 2][j] == "w".charAt(0)) {

									wCows++;
									lastWCowCoords[0] = j;
									lastWCowCoords[1] = i;

								}
							}
						}
					}

				}

			}
		}

		if (nCows == 1) {
			System.out.println(lastNCowCoords[0] + " " + lastNCowCoords[1]);
			return lastNCowCoords;
		} else if (eCows == 1) {
			System.out.println(lastECowCoords[0] + " " + lastECowCoords[1]);
			return lastECowCoords;
		} else if (sCows == 1) {
			System.out.println(lastSCowCoords[0] + " " + lastSCowCoords[1]);
			return lastSCowCoords;
		} else if (wCows == 1) {
			System.out.println(lastWCowCoords[0] + " " + lastWCowCoords[1]);
			return lastWCowCoords;
		}

		return null;
	}
}
