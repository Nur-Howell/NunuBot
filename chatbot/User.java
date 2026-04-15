
package chatbot;


class User {
    
    public String name;
    public int conversationScore;
    public String lastInput;
    
    public User(String name) { // constructer for taking user input
    
    this.name = name; //saves user name
    this.conversationScore = 0; //saves score
        
}
    public void updateScore() {
        
        this.conversationScore++;
        System.out.println("(System: " + name + "'s score is " + conversationScore + ")");
        
    }
     public String getName() {
        return name;
    }
}
