import java.util.Scanner;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;

public class deader {
	private static void DisplayMenu(){
		// Completed subprogram that displays the menu 
		System.out.println("                Menu               ");
		System.out.println("-----------------------------------");
		System.out.println("[1] Add player name");
		System.out.println("[2] Play guess the capital city");
		System.out.println("[3] End game");
		System.out.println("-----------------------------------");
	}
	// End of DisplayMenu()-------------------------------------------------------------------
	private static int GetMenuChoice(Scanner input){
    // Completed subprogram that gets and validates the menu choice 
		int mChoice = 0;
		
		// Menu choice is validated 
		while (mChoice != 1 && mChoice != 2 && mChoice != 3)
		{
			System.out.print("Enter your menu choice ");
			mChoice = input.nextInt();
		}

    	// Valid menu option returned to the main menu 
		return mChoice;
	}
	// End of GetMenuChoice()--------------------------------------------------------------------
	private static String AddPlayerName(Scanner input){
    /* Add your code to: 
         ensure a player name is input
         return the player name to the main menu */
		
		String playerName = input.next();
		System.out.println("Thank you for adding name");
    	return  playerName;

  	}
	// End of AddPlayerName()---------------------------------------------------------------------
	private static int guessCapital(Scanner input){
		/* Partially completed subprogram to:
         display questions
         check guesses
         return final score */

    	// Arrays holding question numbers, countries and their capitals 
		int[] questions = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		String[] countries = { "England", "France", "Spain", "Italy", "Germany", "Scotland", "Wales", "United Arab Emirates", "China" };
        String[] capitals = { "London", "Paris", "Madrid", "Rome", "Berlin", "Edinburgh", "Cardiff", "Abu Dhabi", "Beijing" };
		
        // Add your code here 
        int questionCount = 0;
        int questionScore = 0;
		int[] selectedQuestionNumbers = {}; 
		
		
		
		HashMap<String, Boolean> questionsAsked = new HashMap<String, Boolean>();
		while (questionCount < 5) {
			
			// Input question number
			System.out.println("Enter the question number from (1-9)");
			int questionNumber = input.nextInt();
			
			// Once a question is asked, 
			//	-	check if it's already asked
			//		-	if already asked
			//			-	display error msg
			//		-	if not already asked
			//			-	store it's index in the hashmap (questionsAsked)
			//			-	display and input the question
			//			-	get user answer
			//			-	process user answer - compare it with the actual answer
			//			-	Match found?
			//				-	Display msg
			//				-	increment score
			//				-	otherwise display msg
			//			-	incremement questionCount
			
			
			
			// incremement questionCount ONLY if the question is NOT ALREADY asked
			
			int numQuestionsAsked = questionsAsked.size();
			
			Boolean bAlreadyAsked = null;
			if(numQuestionsAsked > 0) {
				bAlreadyAsked = questionsAsked.get("" + questionNumber);
			}
			
			// System.out.println("questionsAsked: " + questionsAsked + ", questionNumber: " + questionNumber + ", numQuestionsAsked: " + numQuestionsAsked + ", bAlreadyAsked: " + bAlreadyAsked);
			
			if(bAlreadyAsked != null) {
				System.out.println("Question " + questionNumber + " has already been asked!");
			} else {
				questionsAsked.put("" + questionNumber, true);
				System.out.println("What is the capital of " + countries[questionNumber - 1]);
				String usersAnswer = input.next().toLowerCase();
				String actualAnswer = capitals[questionNumber - 1].toLowerCase();
				if(usersAnswer.equals(actualAnswer)) {
					System.out.println("Correct!: ");
					questionScore++;
				} else {
					System.out.println("Wrong! Correct answer: " + actualAnswer);
				}
				questionCount++;
			}
		}
		
		return questionScore;
	}
	

	// End of GuessCapital()------------------------------------------------------------------------
	public static void main(String[] args) throws Exception{
		int menuChoice = 0;
		int score = 0;
		String playerName = "";
		Scanner input = new Scanner(System.in);
		
		while (menuChoice != 3)
		{
			DisplayMenu();
			menuChoice = GetMenuChoice(input);
			
			/* Add your code to:
           call the relevant subprogram if the menu choice is 1 or 2
           display the player name and score  if the menu choice is 3 */
		
			if (menuChoice == 1) {
			 playerName = AddPlayerName(input);
			}
			else if (menuChoice==2) {
			score = guessCapital(input);
			}
			else {
				System.out.println("Player name" + " " + playerName + " " + "- Score:" + " " + score + "/5");
			}
		}
		input.close();
	}
}