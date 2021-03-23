import java.util.Scanner;
import java.util.HashMap;
import java.util.*; 


public class Chatbot
{
   int responseLevel = 0;
   public String[] keywordsList = {"planet", "Mercury", "Venus","Earth","Mars",
   "Jupiter",
   "Saturn",
   "Neptune",
   "Uranus",
   "Sun",
   "star",
   "Constellation",
   "Big Dipper",
   "Black hole",
   "astronaut",
   "galaxy",
   "moon",
   "Asteroid",
   "meteor",
   "space",
   "NASA",
   "SpaceX",
   "Rocket",
   "Spaceship",
   "Sky",
  };

 

  // public String[] keywordsQuestions = {"What is your favorite planet?", 
  //   "What do you like about Mercury?",
  //   "What do you like about Venus?",
  //   "What do you like about Earth?",
  //   "What do you like about Mars?",
  //   "What do you like about Jupiter?",
  //   "What do you like about Saturn?", 
  //   "What do you like about Uranus?", 
  //   "What do you like about Neptune?", 
  //   "What is your favorite constellation?",
  //   "What do you like about stars?",
  //   "Would you ever go to space?",
  //   };

    // public String[] keywordsQuestionsAnswers = {
    //     "My favorite planet is Saturn", 
    //     "I like the fact that one Hemisphere of Mercury is insanely hot, and the other sides are insanely cold", 
    //     "I like that the upper atmospheres of Venus have just the right pressures and temperatures for life to exist", 
    //     "Obviously, I like the fact that Earth is the only planet where life can exist", 
    //     "I like Mars’s red crust",
    //     "I like Jupiter’s cloud patterns and Red Spot",
    //     "I like Saturn's large rings",
    //     "I like Uranus’s axis of rotation, and its name",
    //     "I like Neptune’s Deep blue colors",
    //     "My favorite constellation is Orion, as it has a cool shape, and it is prominent throughout the world",
    //     "I like the fact that many of the chemicals that make up our planet and even the chemicals inside our body originated from Stars"   ,
    //     "Yes, Earth is incomparably small compared to outer space, I would like to explore beyond"
        
    // };

   
    
    

    
    
 
   
   public String getGreeting()
   {
     return "Hi, I am SpaceBot. Let's talk about space objects";
   }

   public String getResponse(String statement)
   {
     String response = "";
     if (statement.indexOf("no") >= 0) {
       response = "Why so negative?";
     } 
     else {
       int nono_counter = 0;
        for (String keyword:keywordsList) {
            if (statement.contains(keyword) || (statement.contains(keyword.toLowerCase())) 
            || (statement.contains(keyword.toUpperCase())) ) {
                response = keywordResponse(keyword, response);
            }
            else {
                nono_counter += 1;
            }
        }
        if (nono_counter == keywordsList.length) {
            response = getRandomResponse();
        }
     }
     return response;
   }

   private String getRandomResponse()
   {
     final int NUMBER_OF_RESPONSES = 4;
     double r = Math.random();
     int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
     String response = "";

     if (whichResponse == 0) {
       response = "Interesting, tell me more.";
     } else if (whichResponse == 1) {
       response = "Hmmm.";
     } else if (whichResponse == 2) {
       response = "Do you really think so?";
     } else if (whichResponse == 3) {
       response = "You don't say.";
     }
     return response;
         }

    public String keywordResponse(String keyword, String response) {
      
      HashMap<String, String> KeywordAnswers = new HashMap<String, String>();
        KeywordAnswers.put("What is your favorite planet?", "My favorite planet is Saturn");
        KeywordAnswers.put("What do you like about Mercury?", "I like the fact that one Hemisphere of Mercury is insanely hot, and the other sides are insanely cold");
        KeywordAnswers.put("What do you like about Venus?", "I like that the upper atmospheres of Venus have just the right pressures and temperatures for life to exist");
        KeywordAnswers.put("What do you like about Earth?", "Obviously, I like the fact that Earth is the only planet where life can exist");
        KeywordAnswers.put("What do you like about Mars?", "I like Mars’s red crust");
        KeywordAnswers.put("What do you like about Jupiter?", "I like Jupiter’s cloud patterns and Red Spot");
        KeywordAnswers.put("What do you like about Saturn?", "I like Saturn's large rings");
        KeywordAnswers.put("What do you like about Uranus?", "I like Uranus’s axis of rotation, and its name");
        KeywordAnswers.put("What do you like about Neptune?", "I like Neptune’s Deep blue colors");
        KeywordAnswers.put("What is your favorite constellation?", "My favorite constellation is Orion, as it has a cool shape, and it is prominent throughout the world");
        KeywordAnswers.put("What do you like about stars?", "I like the fact that many of the chemicals that make up our planet and even the chemicals inside our body originated from stars");
        KeywordAnswers.put("Would you ever go to space?", "Yes, Earth is incomparably small compared to outer space, I would like to explore beyond");
        
        for (Map.Entry<String, String> entry : KeywordAnswers.entrySet()) {
            String question = entry.getKey();
            String answer = entry.getValue();
            
            if (question.contains(keyword) && responseLevel%2 == 1) {
              response = answer + "\nWhat other space object do you want to talk about?";
              responseLevel += 1;
              return response;
              
            }
            
            else if (question.contains(keyword) && responseLevel%2 == 0) {
                response = question;
                responseLevel += 1;
                return response;
                
                
                
                  
            }
            

            
        }
        // for (String question:keywordsQuestions ) {
        //     if (question.contains(keyword) && responseLevel == 0) {
        //         response = question;  
        //     }
        //     else if (question.contains(keyword) && responseLevel == 1) {
        //         response = "Whats up fuckers";
        //     }
        // }
        
        return response; 
    }

   public static void main(String[] args)
   {
     Chatbot spacebot = new Chatbot();

     
     System.out.println (spacebot.getGreeting());
     Scanner in = new Scanner (System.in);
     String statement = in.nextLine();

     while (!statement.equals("Bye"))
     {
        System.out.println (spacebot.getResponse(statement));
        statement = in.nextLine();
     }

   }
}