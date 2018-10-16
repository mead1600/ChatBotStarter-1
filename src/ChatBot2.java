import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * A program to carry on conversations with a human user.
 * This version:
 * @author Brooklyn Tech CS Department
 * @version September 2018
 */
public class ChatBot2
{
	//emotion can alter the way our bot responds. Emotion can become more negative or positive over time.
	int emotion = 0;
	String[] emotions = {"Pleasant Feelings","OPEN","HAPPY","ALIVE","GOOD","understanding","great","playful","calm","confident","gay","courageous","peaceful","reliable","joyous","energetic","at ease","easy","lucky","liberated","comfortable","amazed","fortunate","optimistic","pleased","free","delighted","provocative","encouraged","sympathetic","overjoyed","impulsive","clever","interested","gleeful","free","surprised","satisfied","thankful","frisky","content","receptive","important","animated","quiet","accepting","festive","spirited","certain","kind","ecstatic","thrilled","relaxed","satisfied","wonderful","serene","glad","free and easy ","cheerful ","bright ","sunny ","blessed ","merry ","reassured ","elated  ","jubilant","LOVE","INTERESTED","POSITIVE","STRONG","loving","concerned","eager","impulsive","considerate","affected","keen","free","affectionate","fascinated","earnest","sure","sensitive","intrigued","intent","certain","tender","absorbed","anxious","rebellious","devoted","inquisitive","inspired","unique","attracted","nosy","determined","dynamic","passionate","snoopy","excited","tenacious","admiration","engrossed","enthusiastic","hardy","warm","curious","bold","secure","touched ","brave ","sympathy ","daring ","close ","challenged ","loved ","optimistic ","comforted","re-enforced ","drawn toward","confident ","hopeful","Difficult/Unpleasant Feelings","ANGRY","DEPRESSED","CONFUSED","HELPLESS","irritated","lousy","upset","incapable","enraged","disappointed","doubtful","alone","hostile","discouraged","uncertain","paralyzed","insulting","ashamed","indecisive","fatigued","sore","powerless","perplexed","useless","annoyed","diminished","embarrassed","inferior","upset","guilty","hesitant","vulnerable","hateful","dissatisfied","shy","empty","unpleasant","miserable","stupefied","forced","offensive","detestable","disillusioned","hesitant","bitter","repugnant","unbelieving","despair","aggressive","despicable","skeptical","frustrated","resentful","disgusting","distrustful","distressed","inflamed","abominable","misgiving","woeful","provoked","terrible","lost","pathetic","incensed","in despair","unsure","tragic","infuriated","sulky","uneasy","in a stew","cross","bad","pessimistic","dominated","worked up","a sense of loss","tense","boiling","fuming","indignant","INDIFFERENT","AFRAID","HURT","SAD","insensitive","fearful","crushed","tearful","dull","terrified","tormented","sorrowful","nonchalant","suspicious","deprived","pained","neutral","anxious","pained","grief","reserved","alarmed","tortured","anguish","weary","panic","dejected","desolate","bored","nervous","rejected","desperate","preoccupied","scared","injured","pessimistic","cold","worried","offended","unhappy","disinterested","frightened","afflicted","lonely","lifeless","timid","aching","grieved","shaky","victimized","mournful","restless","heartbroken","dismayed","doubtful","agonized ","threatened","appalled ","cowardly","humiliated ","quaking","wronged ","menaced","alienated ","wary"};

	/**
	 * Runs the conversation for this particular chatbot, should allow switching to other chatbots.
	 * @param statement the statement typed by the user
	 */
	public void chatLoop(String statement)
	{
		Scanner in = new Scanner (System.in);
		System.out.println (help());
		System.out.println (getGreeting());



		while (!statement.equals("Bye"))
		{

			statement = in.nextLine();
			if(statement.toLowerCase().equals("switch"))
			{
				System.out.println("Which chatbot would you like to switch to? Soccer, Football, or Basketball?");
				break;
			}
			//getResponse handles the user reply
			if(statement.toLowerCase().equals("quit"))
			{
				System.out.println("Have a nice day");
				System.exit(1);
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
		System.out.println("Hello, I'm the handball bot.");
		return "How are you feeling?";
	}
	public String help()
	{
		return"\n\033[1mtype: \"switch\" to switch to other chatbots \ntype: \"quit\" to stop chatting \nEnjoy!\n\033[0m";
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
			response = "Then why are you here?";
			emotion--;
		}

		// Response transforming I want to statement
		else if (findKeyword(statement, "I want to", 0) >= 0)
		{
			response = transformIWantToStatement(statement);
		}
		else if (findKeyword(statement, "I want",0) >= 0)
		{
			response = transformIWantStatement(statement);
		}

		else if()
		for(int i=0;i<emotions.length;i++)
		{
			(findKeyword(statement, emotions[i], 0)>=0));
			response = transformEmotion(statement);
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
	private String transformEmotion(String statement)
	{
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}


		for(int i = 0;i<emotions.length;i++)
		{
			int feeling = findKeyword(statement, emotions[i], 0);
			String restOfStatement = statement.substring(feeling + 1).trim();
			return "Why are you feeling " + restOfStatement + "today?";
		}
			return "";
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
			"So, would you like to go for a walk?",
			"Could you say that again?"
	};
	private String [] randomAngryResponses = {"Bahumbug.", "Harumph", "you're garbage", "stop talking to me"};
	private String [] randomHappyResponses = {"H A P P Y, what's that spell?", "Today is a good day", "You make me feel like a brand new pair of shoes."};

}
