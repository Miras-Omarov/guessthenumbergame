package com.guessthenumber.game1;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public static int totalAttempts = 9999999;

    public static void main(String[] args) {
        midGame();
    }

    public static int level() {
        System.out.println("Select difficulty level\nEasy\nMedium\nHard\nVery Hard");
        Scanner scanner = new Scanner(System.in);
        String difficulty = scanner.nextLine();
        int maxNumber;
        switch(difficulty.toLowerCase().trim()) {
            case "easy": maxNumber = 21;
                break;
            case "medium": maxNumber = 51;
                break;
            case "hard": maxNumber = 101;
                break;
            case "very hard": maxNumber = 201;
                break;
            default:
                System.out.println("An error has occurred.");
                maxNumber = level();
        }
        return maxNumber;
    }

    public static void midGame() {
        Scanner scanner = new Scanner(System.in);
        int maxNumber = level();
        Random rand = new Random();
        int randomNumber = rand.nextInt(maxNumber), attempts = 1;
        System.out.println("Number has been guessed.\nPlease,enter a number from 0 to " + (maxNumber - 1));
        int inputNumber = scanner.nextInt();
        int border = (maxNumber - 1) / 5;
        if(inputNumber != randomNumber) {
            while(inputNumber != randomNumber) {
                attempts++;
                if(inputNumber > randomNumber + border) {
                    System.out.println("Your guess is too high.");
                }
                else if(inputNumber > randomNumber) {
                    System.out.println("Your guess is high");
                }
                else if(inputNumber + border < randomNumber) {
                    System.out.println("Your guess is too low");
                }
                else
                    System.out.println("Your guess is low");
                System.out.println("Please enter your next guess.");
                inputNumber = scanner.nextInt();
            }
        }
        System.out.println("Congratulations! You've won!\nTotal attempts: " + attempts + "\nWould you like to start again?\nYes|No");
        if(totalAttempts > attempts) {
            totalAttempts = attempts;
        }
        System.out.println("Your best score is: " + totalAttempts);
        reverse();
    }
    public static void reverse() {
        Scanner scanner = new Scanner(System.in);
        String startAgain = scanner.nextLine();
        if(startAgain.toLowerCase().trim().equals("yes")) {
            midGame();
        }
    }
}
