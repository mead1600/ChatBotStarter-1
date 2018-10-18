import java.util.Random;
import java.util.Scanner;

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
		System.out.println (getGreeting());


		while (!statement.equals("Bye"))
		{


			statement = in.nextLine();
			//getResponse handles the user reply
			System.out.println(teamQuestions(statement));


		}

	}
	/**
	 * Get a default greeting 	
	 * @return a greeting
	 */	
	public String getGreeting()
	{
		return "What is your favorite football team?";
	}

	public String teamQuestions(String statement)
	{
		String response = "";
		if (statement.length() == 0)
		{
			response = "Say something, please.";
			return response;
		}
		else if (statement.equals("I don't have a favorite team"))
		{
			response = transformIDontToStatement(statement);
			return response;
		}
		else if (statement.equals("I dont have a favorite team" ))
		{
			String tempWord = statement.substring(0,5) + "'" + statement.substring(5);
			response = transformIDontToStatement(tempWord);
			return response;
		}
		else{
			response = teamResponse(statement);
			System.out.println(response);
			return finalEnthusiasticResponse(response);
			}

		}
	private String transformIDontToStatement(String statement)
	{
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		return "Why don't you have a favorite team?";
	}

	private String teamResponse(String statement)
	{
		double questionNum = Math.random();
		String response = "";
		if(questionNum >= 0.5)
		{
			return "Why is " + statement + " your favorite team?";
		}
		else
		{
			return "Would you like to go with me to a " + statement + "'s game?";
		}
	}

	private String finalEnthusiasticResponse(String response)
	{
		Scanner reason = new  Scanner(System.in);
		String reasonOut = reason.nextLine();
		if(response.substring(0,6).equals("Why is"))
		{
			return "Man, I'm glad that you have a team that you can love that much";
		}
		else if(response.substring(0,6).equals("Would "))
		{
			if(reasonOut.toLowerCase().equals("no"))
			{
				return "Oh ok. I just wanted a friend to hang out with :(";
			}
			else if(reasonOut.toLowerCase().equals("nope"))
			{
				return "Oh ok. I just wanted a friend to hang out with :(";
			}
			else if(reasonOut.toLowerCase().equals("nah"))
			{
				return "Oh ok. I just wanted a friend to hang out with :(";
			}
			else if(reasonOut.toLowerCase().equals("naw"))
			{
				return "Oh ok. I just wanted a friend to hang out with :(";
			}
			else if(reasonOut.toLowerCase().equals("yes"))
			{
				return "AWSOME! ITS GONNA BE A BLAST";
			}
			else if(reasonOut.toLowerCase().equals("yep"))
			{
				return "AWSOME! ITS GONNA BE A BLAST";
			}
			else if(reasonOut.toLowerCase().equals("yeah"))
			{
				return "AWSOME! ITS GONNA BE A BLAST";
			}
			else if(reasonOut.toLowerCase().equals("uh huh"))
			{
				return "AWSOME! ITS GONNA BE A BLAST";
			}
			else if(reasonOut.toLowerCase().equals("yas"))
			{
				return "AWSOME! ITS GONNA BE A BLAST";
			}
			else if(reasonOut.toLowerCase().equals("yassssssssssssssssssss"))
			{
				return "AWSOME! ITS GONNA BE A BLAST";
			}
			else
			{
				return "please answer my question :(";
			}
		}
		else
		{
			return "please answer my question :(";
		}
	}
	/*private String transformBecauseStatement(String statement)
	{
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "because", 0);
		String restOfStatement = statement.substring(psn + 6).trim();
		if(statement.substring(8,16).equals("they are"))
		return "Why";
	}*/
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
			"Do you really think so?",
			"You don't say.",
			"It's all boolean to me.",
			"So, would you like to go for a walk?",
			"Could you say that again?"
	};
	private String [] randomAngryResponses = {"Bahumbug.", "Harumph", "The rage consumes me!"};
	private String [] randomHappyResponses = {"H A P P Y, what's that spell?", "Today is a good day", "You make me feel like a brand new pair of shoes."};
	
}
