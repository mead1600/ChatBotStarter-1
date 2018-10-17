import java.util.Random;
import java.util.Scanner;

/**
 * A program to carry on conversations with a human user.
 * This version:
 * @author Brooklyn Tech CS Department
 * @version September 2018
 */
public class ChatBot1
{
	//emotion can alter the way our bot responds. Emotion can become more negative or positive over time.
	int emotion = 0;
	int respond = 0;

	/**
	 * Runs the conversation for this particular chatbot, should allow switching to other chatbots.
	 * @param statement the statement typed by the user
	 */
	public void chatLoop(String statement)
	{
		Scanner in = new Scanner (System.in);
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
		return "What a coincidence, I like soccer too! Do you often play soccer? ";
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
			response = "Where are you?";
		}

		else if (findKeyword(statement, "no") >= 0)
		{
			response = "Why not?";
			emotion--;
		}
		else if (findKeyword(statement, "ok") >= 0)
		{
			response = "Good choice!";
			emotion++;
		}
		else if (findKeyword(statement, "yes") >= 0)
		{
			response = "Why so?";
			emotion++;
		}
		else if (findKeyword(statement, "I don't know") >= 0)
		{
			response = "What don't you know?";
		}
		else if (findKeyword(statement, "It is fun") >= 0)
		{
			response = "Yes, it is fun! How fun is it?";
			emotion++;
		}
		else if (findKeyword(statement, "I don't like soccer") >= 0)
		{
			response = "Really?";
			emotion--;
		}
        else if (findKeyword(statement, "I don't care") >= 0)
        {
            response = "Why don't you care?";
            emotion--;
        }
        else if (findKeyword(statement, "so what") >= 0)
        {
            response = "Why so rude?";
            emotion--;
        }
		// Response transforming I want to statement
		else if (findKeyword(statement, "I love to", 0) >= 0)
		{
			response = transformIWantToStatement(statement);
		}
		else if (findKeyword(statement, "you", 0) >= 0)
		{
			response = transformYouStatement(statement);
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
	 * Take a statement with "I want to <something>." and transform it into 
	 * "Why do you want to <something>?"
	 * @param statement the user statement, assumed to contain "I love to"
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
		int psn = findKeyword (statement, "I love to", 0);
		String restOfStatement = statement.substring(psn + 9).trim();
		return "Why do you love to " + restOfStatement + "?";
	}

	private String transformYouStatement(String statement)
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
		int psn = findKeyword (statement, "you said", 0);
		String restOfStatement = statement.substring(psn + 8).trim();
		return "Did I say " + restOfStatement + "?";
	}
	/**
	 * Take a statement with "I want <something>." and transform it into 
	 * "Would you really be happy if you had <something>?"
	 * @param statement the user statement, assumed to contain "I love"
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
		int psn = findKeyword (statement, "I", 0);
		String restOfStatement = statement.substring(psn + 1).trim();
		return "Why do you " + restOfStatement + "?";
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
	
	private String [] randomNeutralResponses = {"Tell me more.",
			"Cool!",
			"So, would you like to play soccer with me?",
            "That's interesting.",
			"Say it again."



	};
	private String [] randomAngryResponses = {"Why did you choose soccer?", "You should switch to another sport", "You sound like you aren't good in soccer.", "You are probably trash in soccer."};
	private String [] randomHappyResponses = {"How about we play soccer in the park?", "Today is a good day to play!", "Do you want to play soccer today?"};
	private String [] FinishResponses = {"Ok! See you there!"};
	


	private String Response(String statement)
	{
		String response2 = "";
		Random r = new Random();

		if (findKeyword(statement, "Yes") >= 0) 
		{
			respond++;
		}
		if (findKeyword(statement, "ok") >= 0) {
            respond++;
		}	
		else if (findKeyword(statement, "No") >= 0) 
		{
            respond--;
		} else 
			{
			response2 = "Yes or No?";
		}
		return decide();
	}

    private String decide()
    {
        Random r = new Random();
        if (respond > 0)
        {
            return FinishResponses[r.nextInt(FinishResponses.length)];
        }
        else
        {
            return randomAngryResponses [r.nextInt(randomAngryResponses.length)];
        }
    }
}	

