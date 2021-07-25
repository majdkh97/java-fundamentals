import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        System.out.println("helloooo");

        int dogCount = 1;
        System.out.println("I own " + dogCount + " " + pluralize("dog", dogCount) + ".");

        int catCount = 2;
        System.out.println("I own " + catCount + " " + pluralize("cat", catCount) + ".");

        int turtleCount = 0;
        System.out.println("I own " + turtleCount + " " + pluralize("turtle", turtleCount) + ".");

        flipNHeads(3);

        clock();
    }

    public static String pluralize(String word, int num){
        if(num == 1){
            return word;
        }
        else{
            return word+"s";
        }
    }

    public static void flipNHeads(int n){
        int counter = 0 ;
        int i = 0 ;
        while(counter!=n){
            double randomNum = Math.random();
            if(randomNum<0.5){
                System.out.println("tails");
                i++;
                counter = 0;
            }
            else{
                System.out.println("heads");
                i++;
                counter++;
            }
        }
        System.out.println("It took " + i +" flips to flip " + counter + " heads in a row ");
    }

    public static void clock(){
        while(true){
            LocalDateTime now = LocalDateTime.now();
            String time = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            System.out.println(time);
            try{
                Thread.sleep(1000);
            }
            catch(Exception e) {

            }
        }
    }

}

