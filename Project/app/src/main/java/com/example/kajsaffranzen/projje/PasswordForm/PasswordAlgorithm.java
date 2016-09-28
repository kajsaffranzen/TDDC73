package com.example.kajsaffranzen.projje.PasswordForm;

import android.widget.TableRow;

import java.util.Arrays;

/**
 * PasswordAlgorithm calculates how strong the typed in passoword is
 *the input is a String and it returns the strength of the password in
 * form of an int
 */
public class PasswordAlgorithm {

    /**Define the criteria for the passoword*/
    private int nrOfCharacters = 8;
    private int nrOfNumbers = 2;
    private int nrOfCapitalLetters = 2;
    private int strength = 0;

    public int CheckStrength(String input){

        int characters = checkCharacters(input, nrOfCharacters);
        int numbers = checkNumbers(input, nrOfNumbers);
        int capital = checkCapitalLetters(input, nrOfCapitalLetters);

        strength = characters + numbers + capital;
        if(strength >= 7) return 3;
        else if(strength <7 && strength >=5 ) return 2;
        else return 1;

    };

    /**check the length of the password*/
    private int checkCharacters(String input, int limit){

        int good = 3, middle = 2, bad =1;

        if(input.length() >= limit ) return good;
        else if(input.length() < 8 || input.length() >= 5) return middle;
        else return bad;
    }

    /**check how many digits the passoword consists of*/
    private int checkNumbers(String input, int limit){
        int good = 3, middle = 2, bad = 1, count = 0;

        for(int i = 0; i < input.length(); i++){
            if(Character.isDigit(input.charAt(i)))
                count++;
        }

        if(count >= limit) return good;
        else if (count == 1) return middle;
        else return bad;
    }

    /**check how many capital letters the passoword consists of*/
    private int checkCapitalLetters(String input, int limit){
        int good = 3, middle = 2, bad = 1, count = 0;

        for(int i = 0; i < input.length(); i++){
            if(Character.isDigit(input.charAt(i)))
                count++;
        }

        if(count >= limit) return good;
        else if (count == 1) return middle;
        else return bad;
    }


}
