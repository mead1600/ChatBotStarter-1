import java.util.Arrays;
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
	String[] emotions = {"Pleasant Feelings","mad","OPEN","fine","HAPPY","ALIVE","GOOD","understanding","great","playful","calm","confident","gay","courageous","peaceful","reliable","joyous","energetic","at ease","easy","lucky","liberated","comfortable","amazed","fortunate","optimistic","pleased","free","delighted","provocative","encouraged","sympathetic","overjoyed","impulsive","clever","interested","gleeful","free","surprised","satisfied","thankful","frisky","content","receptive","important","animated","quiet","accepting","festive","spirited","certain","kind","ecstatic","thrilled","relaxed","satisfied","wonderful","serene","glad","free and easy ","cheerful ","bright ","sunny ","blessed ","merry ","reassured ","elated  ","jubilant","LOVE","INTERESTED","POSITIVE","STRONG","loving","concerned","eager","impulsive","considerate","affected","keen","free","affectionate","fascinated","earnest","sure","sensitive","intrigued","intent","certain","tender","absorbed","anxious","rebellious","devoted","inquisitive","inspired","unique","attracted","nosy","determined","dynamic","passionate","snoopy","excited","tenacious","admiration","engrossed","enthusiastic","hardy","warm","curious","bold","secure","touched ","brave ","sympathy ","daring ","close ","challenged ","loved ","optimistic ","comforted","re-enforced ","drawn toward","confident ","hopeful","Difficult/Unpleasant Feelings","ANGRY","DEPRESSED","CONFUSED","HELPLESS","irritated","lousy","upset","incapable","enraged","disappointed","doubtful","alone","hostile","discouraged","uncertain","paralyzed","insulting","ashamed","indecisive","fatigued","sore","powerless","perplexed","useless","annoyed","diminished","embarrassed","inferior","upset","guilty","hesitant","vulnerable","hateful","dissatisfied","shy","empty","unpleasant","miserable","stupefied","forced","offensive","detestable","disillusioned","hesitant","bitter","repugnant","unbelieving","despair","aggressive","despicable","skeptical","frustrated","resentful","disgusting","distrustful","distressed","inflamed","abominable","misgiving","woeful","provoked","terrible","lost","pathetic","incensed","in despair","unsure","tragic","infuriated","sulky","uneasy","in a stew","cross","bad","pessimistic","dominated","worked up","a sense of loss","tense","boiling","fuming","indignant","INDIFFERENT","AFRAID","HURT","SAD","insensitive","fearful","crushed","tearful","dull","terrified","tormented","sorrowful","nonchalant","suspicious","deprived","pained","neutral","anxious","pained","grief","reserved","alarmed","tortured","anguish","weary","panic","dejected","desolate","bored","nervous","rejected","desperate","preoccupied","scared","injured","pessimistic","cold","worried","offended","unhappy","disinterested","frightened","afflicted","lonely","lifeless","timid","aching","grieved","shaky","victimized","mournful","restless","heartbroken","dismayed","doubtful","agonized ","threatened","appalled ","cowardly","humiliated ","quaking","wronged ","menaced","alienated ","wary"};
	String[] emotionsHappy = {"bland","blissful","blithe","calm","capricious","captivated","cheerful","cheery","chipper","chirpy","confident","content","convivial","dazed","delighted","delightful","ecstatic","elated","enchanted","epicurean","euphoric","excited","exstatic","exuberant","exultant ","fain","fanciful","felicitous","flying high","formidable","glad","gleeful","glorious","gratified ","happy","hilarious","hopeful","humorous ","in high spirits","intoxicated","jolly","joyful","joyous","jubilant","laughing","light","lively","lunatic","lucky","merry","mirthful","on cloud nine","optimistic","overwhelmed","peaceful","peppyperky","playful","pleased","providential","positive","sanguine","satisfied","sensuous","solemn","sparkling","splendid","sprightly","spruce","stoked","sunny","sybaritic","thrilled","upbeat","voluptuous","walking on air","zestful"};
	String[] emotionsSad = {"abandoned","abused","accused","addicted","afraid","aggravated","aggressive","alone","angry","anguish","annoyed","anxious","apprehensive","argumentative","artificial","ashamed","assaulted","at a loss","at risk","atrocious","attacked","avoided","awful","awkward","bad","badgered","baffled","banned","barren","beat","beaten down","belittled","berated","betrayed","bitched at","bitter","bizzare","blacklisted","blackmailed","blamed","bleak","blown away","blur","bored","boring","bossed-around","bothered","bothersome","bounded","boxed-in","broken","bruised","brushed-off","bugged","bullied","bummed","bummed out","burdened","burdensome","burned","burned-out","caged in","careless","chaotic","chased","cheated","cheated on","chicken","claustrophobic","clingy","closed","clueless","clumsy","coaxed","codependent","coerced","cold","cold-hearted","combative","commanded","compared","competitive","compulsive","conceited","concerned","condescended to","confined","conflicted","confronted","confused","conned","consumed","contemplative","contempt","contentious","controlled","convicted","cornered","corralled","cowardly","crabby","cramped","cranky","crap","crappy","crazy","creeped out","creepy","critical","criticized","cross","crowded","cruddy","crummy","crushed","cut-down","cut-off","cynical","damaged","damned","dangerous","dark","dazed","dead","deceived","deep","defamed","defeated","defective","defenseless","defensive","defiant","deficient","deflated","degraded","dehumanized","dejected","delicate","deluded","demanding","demeaned","demented","demoralized","demotivated","dependent","depleted","depraved","depressed","deprived","deserted","deserving of pain/punishment","desolate","despair","despairing","desperate","despicable","despised","destroyed","destructive","detached","detest","detestable","detested","devalued","devastated","deviant","devoid","diagnosed","dictated to","different","difficult","directionless","dirty","disabled","disagreeable","disappointed","disappointing","disapproved of","disbelieved","discardable","discarded","disconnected","discontent","discouraged","discriminated","disdain","disdainful","disempowered","disenchanted","disgraced","disgruntled","disgust","disgusted","disheartened","dishonest","dishonorable","disillusioned","dislike","disliked","dismal","dismayed","disorganized","disoriented","disowned","displeased","disposable","disregarded","disrespected","dissatisfied","distant","distracted","distraught","distressed","disturbed","dizzy","dominated","doomed","double-crossed","doubted","doubtful","down","down and out","down in the dumps","downhearted","downtrodden","drained","dramatic","dread","dreadful","dreary","dropped","drunk","dry","dumb","dumped","dumped on","duped","edgy","egocentric","egotistic","egotistical","elusive","emancipated","emasculated","embarrassed","emotional","emotionless","emotionally bankrupt","empty","encumbered","endangered","enraged","enslaved","entangled","evaded","evasive","evicted","excessive","excluded","exhausted","exploited","exposed","failful","fake","false","fear","fearful","fed up","flawed","forced","forgetful","forgettable","forgotten","fragile","freaked out","frightened","frigid","frustrated","furious","gloomy","glum","gothic","grey","grief","grim","gross","grossed-out","grotesque","grouchy","grounded","grumpy","guilt-tripped","guilty","harassed","hard","hard-hearted","harmed","hassled","hate","hateful","hatred","haunted","heartbroken","heartless","heavy-hearted","helpless","hesitant","hideous","hindered","hopeless","horrible","horrified","horror","hostile","hot-tempered","humiliated","hung up","hung over","hurried","hurt","hysterical","idiotic","ignorant","ignored","ill","ill-tempered","imbalanced","imposed-upon","impotent","imprisoned","impulsive","in the dumps","in the way","inactive","inadequate","incapable","incommunicative","incompetent","incompatible","incomplete","incorrect","indecisive","indifferent","indoctrinated","inebriated","ineffective","inefficient","inferior","infuriated","inhibited","inhumane","injured","injusticed","insane","insecure","insignificant","insincere","insufficient","insulted","intense","interrogated","interrupted","intimidated","intoxicated","invalidated","invisible","irrational","irritable","irritated","isolated","jaded","jealous","jerked around","joyless","judged","kept apart","kept away","kept in","kept out","kept quiet","labeled","laughable","laughed at","lazy","leaned on","lectured to","left out","let down","lied about","lied to","limited","little","lonely","lonesome","longing","lost","lousy","loveless","low","mad","made fun of","man handled","manipulated","masochistic","messed with","messed up","messy","miffed","miserable","misled","mistaken","mistreated","mistrusted","misunderstood","mixed-up","mocked","molested","moody","nagged","needy","negative","nervous","neurotic","nonconforming","numb","nuts","nutty","objectified","obligated","obsessed","obsessive","obstructed","odd","offended","on display","opposed","oppressed","out of place","out of touch","over-controlled","over-protected","overwhelmed","pain","panic","paranoid","passive","pathetic","pessimistic","petrified","phony","picked on","pissed","pissed off","plain","played with","pooped","poor","powerless","pre-judged","preached to","preoccupied","predjudiced","pressured","prosecuted","provoked","psychopathic","psychotic","pulled apart","pulled back","punished","pushed","pushed away","put down","puzzled","quarrelsome","queer","questioned","quiet","rage","raped","rattled","regret","rejected","resented","resentful","responsible","retarded","revengeful","ridiculed","ridiculous","robbed","rotten","sad","sadistic","sarcastic","scared","scarred","screwed","screwed over","screwed up","self-centered","self-conscious","self-destructive","self-hatred","selfish","sensitive","shouted at","shy","singled-out","slow","small","smothered","snapped at","spiteful","stereotyped","strange","stressed","stretched","stuck","stupid","submissive","suffering","suffocated","suicidal","superficial","suppressed","suspicious"};
	String[] timePastTense = {"yesterday","last week","past week"};
	String[] time= {"now","right now"};
	String[] yes = {"ye","yah","yep","yeh","yuh","yes","YES"};
	String[] no = {"nah","nope","nop","naw","nu","no"};
	String temp;
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

		// Response transforming I want to statement
		else if (findKeyword(statement, "I want to", 0) >= 0)
		{
			response = transformIWantToStatement(statement);
		}
		else if (findKeyword(statement, "I want",0) >= 0)
		{
			response = transformIWantStatement(statement);
		}

		else if (Arrays.stream(emotionsHappy).filter(v -> statement.toLowerCase().indexOf(v.toLowerCase()) > -1).count() > 0 || Arrays.stream(emotionsSad).filter(v -> statement.toLowerCase().indexOf(v.toLowerCase()) > -1).count() > 0) {
			System.out.println(transformEmotion(statement));
		}
		else if(temp!=null)
		{
			if (Arrays.stream(yes).filter(v -> statement.toLowerCase().indexOf(v.toLowerCase()) > -1).count() > 0) {
				for (int i = 0; i < emotionsHappy.length; i++) {
					if (temp.equals(emotionsHappy[i])) {
						Random r = new Random();
						System.out.println(randomHappyResponses[r.nextInt(randomHappyResponses.length)] + temp);
					}
				}
				for (int i = 0; i < emotionsSad.length; i++) {
					if (temp.equals(emotionsSad[i])) {
						Random r = new Random();
						System.out.println(randomAngryResponses[r.nextInt(randomAngryResponses.length)]);
					}
				}
			}
			else if (Arrays.stream(no).filter(v -> statement.toLowerCase().indexOf(v.toLowerCase()) > -1).count() > 0)
			{
				for (int i = 0; i < emotionsSad.length; i++)
				{
					if (temp.equals(emotionsSad[i]))
					{
						String[] randomReliefResponses = {"Whew, I knew it wouldn't be handball's fault. I can't help that you're " + temp + ',' + " maybe another bot could help?(type \'switch\')", "Sorry that you're " + temp + ',' + " but I can't help you"};
						Random r = new Random();
						System.out.println(randomReliefResponses[r.nextInt(randomReliefResponses.length)]);
					}
				}
				for (int i = 0; i < emotionsHappy.length; i++)
				{
					if (temp.equals(emotionsHappy[i]))
					{
						Random r = new Random();
						return randomAngryResponses[r.nextInt(randomAngryResponses.length)];
					}
				}

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
	private String whenEmotionSad(String statement)
	{
		if(Arrays.stream(emotionsSad).filter(v -> statement.toLowerCase().indexOf(v.toLowerCase()) > -1).count() > 0)
		{
			for(int i = 0;i<emotionsSad.length;i++)
			{
				if(statement.contains(emotionsSad[i]))
				{
					String feelin = emotionsSad[i];
					System.out.println("What about handball makes you feel" + feelin);
					break;
				}
			}
		}
		return "";
	}
	private String whenEmotionHappy(String statement)
	{
		return"";
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
		System.out.println(restOfStatement);
		return "Would you really be happy if you had " + restOfStatement + "?";
	}
	private String transformEmotion(String statement)
	{
		boolean sad = true;
		boolean ran = true;
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		for(int i = 0;i<emotionsHappy.length - 1;i++)
		{
			if(statement.contains(emotionsHappy[i].toLowerCase()))
			{
				sad = false;
				for (int x = 0; x < time.length - 1; x++)
				{
					if (statement.contains(time[x]))
					{
						int feeling = findKeyword(statement, emotionsHappy[i], 0);
						String restOfStatement = statement.substring(feeling).trim();
						System.out.println("Why are you feeling " + restOfStatement);
						ran = false;
						temp = emotionsHappy[i];
						break;
					}
				}
				for (int t = 0; t < timePastTense.length - 1; t++)
				{
					if (statement.contains(timePastTense[t]))
					{
						int feeling = findKeyword(statement, emotionsHappy[i], 0);
						String restOfStatement = statement.substring(feeling).trim();
						System.out.println("Why were you feeling " + restOfStatement);
						ran = false;
						temp = emotionsHappy[i];
						break;
					}
				}
				if(ran == true)
				{
					int feeling = findKeyword(statement, emotionsHappy[i], 0);
					String restOfStatement = statement.substring(feeling).trim();
					System.out.println("Why are you feeling " + restOfStatement + " today?");
					temp = emotionsHappy[i];
				}
			}
		}
		if (sad == true) {
			for (int i = 0; i < emotionsSad.length - 1; i++) {
				if (statement.contains(emotionsSad[i].toLowerCase())) {
					for (int x = 0; x < time.length - 1; x++) {
						if (statement.contains(time[x])) {
							int feeling = findKeyword(statement, emotionsSad[i], 0);
							String restOfStatement = statement.substring(feeling).trim();
							System.out.println("Why are you feeling " + restOfStatement);
							ran = false;
							temp = emotionsSad[i];
							break;
						}
					}
					for (int t = 0; t < timePastTense.length - 1; t++) {
						if (statement.contains(timePastTense[t])) {
							int feeling = findKeyword(statement, emotionsSad[i], 0);
							String restOfStatement = statement.substring(feeling).trim();
							System.out.println("Why were you feeling " + restOfStatement);
							ran = false;
							temp = emotionsSad[i];
							break;
						}
					}
					if (ran == true) {
						int feeling = findKeyword(statement, emotionsSad[i], 0);
						String restOfStatement = statement.substring(feeling).trim();
						System.out.println("Why are you feeling " + restOfStatement + " today?");
						temp = emotionsSad[i];
					}
				}
			}
		}
		return "Is it because of handball?";
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

	private String [] randomNeutralResponses = {"You wanna talk about handball or not?",
			"Stop dodging the question",
			"Can you answer me?",
			"You're mad fake",
			"Hello? Are you there?",
			"WOW THE WIND IS STRONG TODAY",
			"Is someone talking?",
			"I'm feeling lonely by myself",
	};
	private String [] randomAngryResponses = {"Don't talk to me then, say sorry","I'll continue to talk with you if you say sorry","I won't forgive you unless you say sorry"};
	private String [] randomHappyResponses = {"What about handball makes you feel ","Why does handball make you feel "};

}
