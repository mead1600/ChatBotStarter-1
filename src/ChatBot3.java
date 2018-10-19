import java.util.Random;
import java.util.Scanner;
//This chatbot was created by Mead Gyawu
/**
 * A program to carry on conversations with a human user.
 * This version:
 * @author Brooklyn Tech CS Department
 * @version September 2018
 */
public class ChatBot3
{
	//emotion can alter the way our bot responds. Emotion can become more negative or positive over time.
	int emotion = 0;



	/**
	 * Runs the conversation for this particular chatbot, should allow switching to other chatbots.
	 * @param statement the statement typed by the user
	 */
	public void chatLoop(String statement)
	{
		Scanner in = new Scanner (System.in);
		System.out.println(help());
		System.out.println (getGreeting());


		while (!statement.equals("Bye"))
		{


			statement = in.nextLine();
			//getResponse handles the user reply
			if(statement.toLowerCase().equals("switch"))
			{
				System.out.println("Which chatbot would you like to switch to? Handball, Football, or Basketball?");
				break;
			}
			System.out.println(getResponse(statement));


		}

	}
	/**
	 * Get a default greeting
	 * @return a greeting
	 */
	public String getGreeting()
	{
		return "Do you like football?";
	}

	/**
	 * Returns the instructions for switching to another bot
	 * @return
	 */
	public String help()
	{
		return "\n\033[imtype: \"switch\" to switch to other chatbots \ntype: \"quit\" to stop chatting \nEnjoy!\n\033[0m";
	}

	/**
	 * Gives a response to a user statement
	 *
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{
		String response = "";

		if (statement.length() == 0)
		{
			response = "Say something, please.";
		}

		else if (findKeyword(statement, "no") >= 0)
		{
			response = "Why did you choose football then?";
			emotion--;
		}
		else if (findKeyword(statement, "nope") >= 0)
		{
			response = "Why did you choose football then?";
			emotion--;
		}

		else if (findKeyword(statement, "nah") >= 0)
		{
			response = "Why did you choose football then?";
			emotion--;
		}

		else if (findKeyword(statement, "naw") >= 0)
		{
			response = "Why did you choose football then?";
			emotion--;
		}

		else if (findKeyword(statement, "you suck") >= 0)
		{
			response = "Why are you so mean to me?";
			emotion--;
		}
		else if (findKeyword(statement, "yes") >= 0)
		{
			emotion++;
			response = "really? Awesome! "+getRandomResponse();
		}

		else if (findKeyword(statement, "yep") >= 0)
		{
			response = "really? Awesome! "+getRandomQuestion();
			emotion++;
		}
		else if (findKeyword(statement, "yeah") >= 0)
		{
			response = "really? Awesome! "+getRandomQuestion();
			emotion++;
		}
		else if (findKeyword(statement, "yea") >= 0)
		{
			emotion++;
			response = "really? Awesome! "+getRandomResponse();
		}
		else if(findKeyword(statement, "I don't know") >= 0)
		{
			response = "c'mon man you have to know";
		}
		else if(findKeyword(statement, "I dont know") >= 0)
		{
			response = "c'mon man you have to know";
		}
		else if(findKeyword(statement, "I do not know") >= 0)
		{
			response = "c'mon man you have to know";
		}
		else if (findKeyword(statement, "I love to", 0) >= 0)
		{
			response = transformIWantToStatement(statement);
		}

		else if (findKeyword(statement,"because i am") >= 0)
		{
			response = transformBecauseIAm(statement);
		}
		else if (findKeyword(statement,"because it") >= 0)
		{
			response = transformBecauseIt(statement);
		}

		else if (findKeyword(statement,"because you are") >= 0)
		{
			response = transformBecauseYouAre(statement);
		}
		else if (findKeyword(statement,"because you") >= 0)
		{
			response = transformBecauseYou(statement);
		}
		else if (findKeyword(statement, "because i") >= 0)
		{
			response = transformBecauseI(statement);
		}
		else if (findKeyword(statement,"because") >= 0)
		{
			response = "why?";
		}
		else if (findKeyword(statement,"cuz you are") >= 0)
		{
			response = transformCuzYouAre(statement);
		}
		else if (findKeyword(statement,"cuz you") >= 0)
		{
			response = transformCuzYou(statement);
		}
		else if (findKeyword(statement,"cuz") >= 0)
		{
			response = "why?";
		}
		else if (findKeyword(statement, "you", 0) >= 0)
		{
			response = transformIYouStatement(statement);
		}
		else if (findKeyword(statement, "I",0) >= 0)
		{
			if (findKeyword(statement, "you") >= 0)
			{
				response = 	transformIYouStatement(statement);
			}
			else {
				response = transformIWantStatement(statement);
			}
		}
		else
		{
			response = getRandomResponse();
		}

		return response;
	}

	/**
	 * Finds 'because it' in the user's input and creates a response
	 * @param statement
	 * @return
	 */
	private String transformBecauseIt(String statement)
	{
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "because it", 0);
		String restOfStatement = statement.substring(psn + 10).trim();
		return "Why is it " + restOfStatement + "?";
	}
	/**
	 * Finds 'because i' in the user's input and creates a response
	 * @param statement
	 * @return
	 */
	private String transformBecauseI(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "because i", 0);
		String restOfStatement = statement.substring(psn + 9).trim();
		return "Why do you " + restOfStatement + "?";
	}
	/**
	 * Finds 'because i am' in the user's input and creates a response
	 * @param statement
	 * @return
	 */
	private String transformBecauseIAm(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "because i am", 0);
		String restOfStatement = statement.substring(psn + 12).trim();
		return "Why are you " + restOfStatement + "?";
	}
	/**
	 * Finds 'because you' in the user's input and creates a response
	 * @param statement
	 * @return
	 */
	private String transformBecauseYou(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "because you", 0);
		String restOfStatement = statement.substring(psn + 11).trim();
		return "Why do I " + restOfStatement + "?";
	}
	/**
	 * Finds 'because you are' in the user's input and creates a response
	 * @param statement
	 * @return
	 */
	private String transformBecauseYouAre(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "because you are", 0);
		String restOfStatement = statement.substring(psn + 15).trim();
		return "Why do I " + restOfStatement + "?";
	}

	/**
	 * Finds the phrase "cuz you" in the user's input and creates a response
	 * @param statement
	 * @return
	 */
	private String transformCuzYou(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "cuz you", 0);
		String restOfStatement = statement.substring(psn + 7).trim();
		return "Why do I " + restOfStatement + "?";
	}
	/**
	 * Finds the phrase "cuz you are" in the user's input and creates a response
	 * @param statement
	 * @return
	 */
	private String transformCuzYouAre(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "cuz you are", 0);
		String restOfStatement = statement.substring(psn + 11).trim();
		return "Why do I " + restOfStatement + "?";
	}

	/**
	 * Take a statement with "I want to <something>." and transform it into
	 * "Why do you want to <something>?"
	 * @param statement the user statement, assumed to contain "I want to"
	 * @return the transformed statement
	 */
	private String transformIWantToStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "I want to", 0);
		String restOfStatement = statement.substring(psn + 9).trim();
		return "Why do you want to " + restOfStatement + "?";
	}


	/**
	 * Take a statement with "I want <something>." and transform it into
	 * "Would you really be happy if you had <something>?"
	 * @param statement the user statement, assumed to contain "I want"
	 * @return the transformed statement
	 */
	private String transformIWantStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "I want", 0);
		String restOfStatement = statement.substring(psn + 6).trim();
		return "Would you really be happy if you had " + restOfStatement + "?";
	}


	/**
	 * Take a statement with "I <something> you" and transform it into
	 * "Why do you <something> me?"
	 * @param statement the user statement, assumed to contain "I" followed by "you"
	 * @return the transformed statement
	 */
	private String transformIYouStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}

		int psnOfI = findKeyword (statement, "I", 0);
		int psnOfYou = findKeyword (statement, "you", psnOfI);

		String restOfStatement = statement.substring(psnOfI + 1, psnOfYou).trim();
		return "Why do you " + restOfStatement + " me?";
	}




	/**
	 * Search for one word in phrase. The search is not case
	 * sensitive. This method will check that the given goal
	 * is not a substring of a longer string (so, for
	 * example, "I know" does not contain "no").
	 *
	 * @param statement
	 *            the string to search
	 * @param goal
	 *            the string to search for
	 * @param startPos
	 *            the character of the string to begin the
	 *            search at
	 * @return the index of the first occurrence of goal in
	 *         statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal,
							int startPos)
	{
		String phrase = statement.trim().toLowerCase();
		goal = goal.toLowerCase();

		// The only change to incorporate the startPos is in
		// the line below
		int psn = phrase.indexOf(goal, startPos);

		// Refinement--make sure the goal isn't part of a
		// word
		while (psn >= 0)
		{
			// Find the string of length 1 before and after
			// the word
			String before = " ", after = " ";
			if (psn > 0)
			{
				before = phrase.substring(psn - 1, psn);
			}
			if (psn + goal.length() < phrase.length())
			{
				after = phrase.substring(
						psn + goal.length(),
						psn + goal.length() + 1);
			}

			// If before and after aren't letters, we've
			// found the word
			if (((before.compareTo("a") < 0) || (before
					.compareTo("z") > 0)) // before is not a
					// letter
					&& ((after.compareTo("a") < 0) || (after
					.compareTo("z") > 0)))
			{
				return psn;
			}

			// The last position didn't work, so let's find
			// the next, if there is one.
			psn = phrase.indexOf(goal, psn + 1);

		}

		return -1;
	}

	/**
	 * Search for one word in phrase.  The search is not case sensitive.
	 * This method will check that the given goal is not a substring of a longer string
	 * (so, for example, "I know" does not contain "no").  The search begins at the beginning of the string.
	 * @param statement the string to search
	 * @param goal the string to search for
	 * @return the index of the first occurrence of goal in statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal)
	{
		return findKeyword (statement, goal, 0);
	}



	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse ()
	{
		Random r = new Random ();
		if (emotion == 0)
		{
			return randomNeutralResponses [r.nextInt(randomNeutralResponses.length)];
		}
		if (emotion < 0)
		{
			return randomAngryResponses [r.nextInt(randomAngryResponses.length)];
		}
		return randomHappyResponses [r.nextInt(randomHappyResponses.length)];
	}

	private String [] randomNeutralResponses = {"Interesting, tell me more",
			"Hmmm.",
			"Is that what most people think?",
			"You don't say.",
			"I'm having trouble understanding. Could you elaborate?",
	};
	private String [] randomAngryResponses = {"Well if wee can't have a nice discussion about football, then we cannot be friends.", "Your favorite football team sucks", "I am tired of your disrespect for the great game of football"};
	private String [] randomHappyResponses = {"Why don't we go to a football game together? :)", "Talking with you has been a real touch down, you know what I mean?", "You know our relationship is so strong.WE SHOULD GO TO THE SUPER BOWL TOGETHER"};
	private String getRandomQuestion()
	{
		Random r = new Random ();
		return randomQuestions [r.nextInt(randomQuestions.length)];
	}
	private String [] randomQuestions = {"When can we meet up some other time to talk about this even more?","How are you feeling right now?","What is your favorite team?","What do you think of the giants?","How big of a football fan are you?"};
}
