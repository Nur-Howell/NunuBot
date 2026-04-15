


package chatbot;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;
import java.io.*;
import java.util.regex.*;
import chatbot.functions.FileFind;

class Bot {
    
    LocalTime time = LocalTime.now();
    LocalDate date = LocalDate.now();
     Random random = new Random();
    String randGreet [] = {"Hi!", "Salaams!", "Greetings!", "Hello!"};
    String commandList [] = {"Hello", "User", "Time", "Exit", "Date", "Clear", "Convert", "Search"};
    

    
    
    private User currentUser;
    
    private FileFind fileFinder = new FileFind();

    // Constructor to connect the User to the Bot
    public Bot(User user) {
        
        this.currentUser = user;
    }
    
    public String processMessage(String input) {
        
        String trimmedInput = input.trim();
       String command = input.trim().toLowerCase();
       
  if (command.startsWith("search")) {
        // Check if they just typed "search" or "search "
        if (command.equals("search") || command.equals("search ")) {
            return "Please tell me what to search for! Example: search Java";
        }
        // Safely extract the query
        String query = trimmedInput.substring(7).trim(); 
        return fileFinder.search(query, "src/chatbot/words.txt");
    }

    // Switch handles the exact single-word commands
    switch (command) {
        case "hello":
            int index = random.nextInt(randGreet.length);
            return randGreet[index];

        case "time":
            return "The current time is " + time;

        case "date":
            return "The current date is " + date;

        case "user":
            return "User is " + currentUser.getName();

        case "help":
            String list = "Available commands: ";
            for (int i = 0; i < commandList.length; i++) {
                list += commandList[i] + (i < commandList.length - 1 ? ", " : "");
            }
            return list;

        case "clear":
            return "COMMAND_CLEAR";

        default:
            return "Incorrect command!!!";
    }
}

      
        
}




