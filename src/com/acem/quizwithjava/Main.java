package com.acem.quizwithjava;

import java.util.Scanner;
import java.io.IOException;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import com.acem.quizwithjava.questions.*;

public class Main {
    static float highestScore = 0;
    static String again;

    public static void main (String argss[]) throws InterruptedException, IOException
    {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        Scanner input = new Scanner(System.in);
        System.out.println("May we have your name please");
        String name = input.nextLine();
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println("Welcome: "+ name);
        System.out.println("At first lets understand how the evaluation is done:\na) If you gave incorrect answer then you will score 0\nb)If you give the correct answer you will be evaluated under time bound\n\t: If you provide within 20 seconds you will score full marks i.e. 2\n\t:If you take more than 60 seconds you will get '0'\n\t:If between 20 and 60 seconds linear scoring will be done.");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("Don't take more than 60 seconds.You will not be evaluated if that happens!");
        System.out.println("\n\n\nBest of luck,"+name);
       
        
        do
        {
        
        System.out.println("\nPress and Enter\n1 to see current highest score\nPress 2 to play \nPress 3 to exit");
        String choice = input.nextLine();
        if (choice.equals("1"))
            System.out.println("Current high score is: "+ highestScore);
        else if (choice.equals(("2")))
        {
            Questions questions = new Questions();
            Answers answers = new Answers();
            float currentScore = 0;
            
            
            
            for(int i=0;i<10;i++)
            {
                
                System.out.println(questions.question(i));
                LocalTime t0 =java.time.LocalTime.now() ;
                
                String response = input.nextLine();
                LocalTime t1 =java.time.LocalTime.now() ;
                
                if(response.equals(answers.answer(i)))
                {   

                    
                    double diff = t0.until(t1,ChronoUnit.SECONDS);
                    
                    
                    if(diff<20)
                        currentScore+=2;
                    else if(diff>60)
                        System.out.println("You took more than a minute.");
                    else{
                        System.out.println("diff: ="+diff);
                        double score = 2.0*((60.0-diff)/40.0);
                        System.out.println("score:"+score);
                        currentScore += score;
                        System.out.println(currentScore);
                    }
                        
                }
                
            }
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            if (currentScore>highestScore){
                highestScore = currentScore;
                System.out.println("New high score alert! :"+highestScore);
            }
            else 
                System.out.println("Your current score is: "+ currentScore);
        }
        else if (choice.equals("3"))
            System.exit(0);
        else 
            System.out.println("Make a proper choice");
        System.out.println("Want to make a round again?'Y' for yes else other");
        again = input.nextLine();
        }while(again.equals("Y") || again.equals("y"));
        }
}
