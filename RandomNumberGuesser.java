import java.util.Scanner;
public class RandomNumberGuesser{

	public static void main(String[] args){
		Scanner userInput = new Scanner(System.in);
		Scanner userInput1 = new Scanner(System.in);
		int randomNumber;
		int nextGuess;
		int lowGuess = 0;
		int highGuess = 100; 
		randomNumber = RNG.rand();
		System.out.println("Enter a number between 0 and 100: ");
		nextGuess = userInput.nextInt();
		while(nextGuess != randomNumber){
			if ((int)RNG.getCount()/2 != 0){
				System.out.println("Your guess count is " +(int)RNG.getCount()/2);
			}
			while(!RNG.inputValidation(nextGuess, lowGuess, highGuess)){
				nextGuess = userInput.nextInt();
			}
			if (nextGuess > randomNumber){
				highGuess = nextGuess;
			}
			else if (nextGuess < randomNumber) {
				lowGuess = nextGuess;
			}
			if (nextGuess == randomNumber){
				System.out.println("Congratulations, you guessed correctly");
				System.out.println("Try again? (yes or no)");
				String a = userInput1.nextLine();
				if (a.equals("yes")){
					RNG.resetCount();
					main(args);
				}
				else if(a.equals("no")){
					System.out.println("Thanks for playing...");
					System.out.println("PROGRAMMER: Alan Duong");
					System.exit(0);
				}
			}
		}
		userInput.close();
		userInput1.close();
	}
}