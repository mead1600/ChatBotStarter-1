import java.util.Scanner;

/**
 * A simple class to run our chatbot teams.
 * @author Brooklyn Tech CS Department
 * @version September 2018
 */
public class ChatBotRunner
{

	/**
	 * Create instances of each chatbot, give it user input, and print its replies. Switch chatbot responses based on which chatbot the user is speaking too.
	 */
	public static void main(String[] args)
	{
		ChatBot1 chatbot1 = new ChatBot1();
		ChatBot2 chatbot2 = new ChatBot2();
		ChatBot3 chatbot3 = new ChatBot3();
		ChatBot4 chatbot4 = new ChatBot4();


		Scanner in = new Scanner (System.in);
		System.out.println("Welcome to the sport chatbot, nice to meet you.");
		String statement = in.nextLine();
        System.out.println("Which topic would you like to learn about? Soccer, Handball, Football, or Basketball");

		while (!statement.toLowerCase().equals("bye"))
		{
			while (statement.toLowerCase().equals("soccer"))
			{
				chatbot1.chatLoop(statement);
				statement = in.nextLine();
			}
			while (statement.toLowerCase().equals("handball"))
			{
				chatbot2.chatLoop(statement);
				statement = in.nextLine();
			}
			while (statement.toLowerCase().equals("football"))
			{
				chatbot3.chatLoop(statement);
				statement = in.nextLine();
			}
			while (statement.toLowerCase().equals("basketball"))
			{
				chatbot4.chatLoop(statement);
				statement = in.nextLine();
			}
		}
	}

}
