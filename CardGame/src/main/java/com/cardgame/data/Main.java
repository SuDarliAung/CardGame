package com.cardgame.data;

import javax.smartcardio.Card;
import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        CardData[] game = new CardData[52];

        genCardDeck(game);
        shuffleCardDeck(game);

        CardData[] player1 = new CardData[3];
        CardData[] player2 = new CardData[3];
        CardData[] player3 = new CardData[3];
        CardData[] player4 = new CardData[3];

        dealCards(game,player1,player2,player3,player4);
        printCardDeck(game,player1,player2,player3,player4);
        checkWinner(player1,player2,player3,player4);
    }
    public static void genCardDeck(CardData[] deck) //Generate the deck
    {
        final String alphaNum[] = {"2","3","4", "5","6","7","8","9","10","J","Q","K","A"};
        final String symbol[] = {"@","#","^","*"};

        int i = 0;
        for (String a : alphaNum)
        {
            for (String s : symbol)
            {
                deck[i] = new CardData();
                deck[i].setCardNo(a+s);
                i++;
            }
        }
    }
    public static void printCardDeck(CardData[] deck, CardData[] player1,
                                     CardData[] player2, CardData[] player3, CardData[] player4) //Print out the deck
    {
        System.out.print("Player 1: "); //Print player 1
        for (CardData p1 : player1)
        {
            System.out.print(p1.getCardNo() + ", ");
        }
        System.out.println("\n");

        System.out.print("Player 2: "); //Print player 2
        for (CardData p2 : player2)
        {
            System.out.print(p2.getCardNo() + ", ");
        }
        System.out.println("\n");

        System.out.print("Player 3: "); //Print player 3
        for (CardData p3 : player3)
        {
            System.out.print(p3.getCardNo() + ", ");
        }
        System.out.println("\n");

        System.out.print("Player 4: "); //Print Skat
        for (CardData sk : player4)
        {
            System.out.print(sk.getCardNo() + ", ");
        }
        System.out.println("\n");
    }
    public static void shuffleCardDeck(CardData[] deck) //Shuffle the card deck
    {
        Random rand = new Random();
        for (int i = 0; i < deck.length; i++) {
            int randomNum = rand.nextInt(deck.length);
            CardData temp = deck[i];
            deck[i] = deck[randomNum];
            deck[randomNum] = temp;
        }
    }
    public static void dealCards(CardData[] deck, CardData[] player1,
                                 CardData[] player2, CardData[] player3, CardData[] player4) //Deal the cards
    {
        //Round 1
        int i;
        for(i=0;i<=11;i++)
        {
            if(i<3)
                player1[i]=deck[i]; //Player 1
            else if(i<6)
                player2[i-3]=deck[i]; //Player 2
            else if(i<9)
                player3[i-6]=deck[i]; //Player 3
            else
                player4[i-9] = deck[i];//Player 4
        }
    }
    public static void checkWinner(CardData[] player1,
                                 CardData[] player2, CardData[] player3, CardData[] player4) //Deal the cards
    {
        int p1 = 0,p2 = 0,p3 = 0,p4 = 0;
        for(int i = 0; i<2 ; i++){
            if(player1[i].getCardNo().compareTo(player2[i].getCardNo())>0){
                p1 += 1;
                if(player1[i].getCardNo().compareTo(player3[i].getCardNo())>0){
                    p1 += 1;
                }else{
                    p3 += 1;
                    if(player3[i].getCardNo().compareTo(player4[i].getCardNo())>0){
                        p3 += 1;
                    }else{
                        p4 += 1;
                    }
                }
                if(player1[i].getCardNo().compareTo(player4[i].getCardNo())>0){
                    p1 += 1;
                }
                else{
                    p4 += 1;
                }
            }
            else{
                p2 += 1;
                if(player2[i].getCardNo().compareTo(player3[i].getCardNo())>0){
                    p2 += 1;
                }else{
                    p3 += 1;
                    if(player3[i].getCardNo().compareTo(player4[i].getCardNo())>0){
                        p3+= 1;
                    }else{
                        p4 += 1;
                    }
                }
                if(player2[i].getCardNo().compareTo(player4[i].getCardNo())>0){
                    p2 += 1;
                }
                else{
                    p4 += 1;
                }
            }
        }
        if(p1 > p2){
            if(p1 > p3){
                if(p1 > p4){
                    System.out.println("The Winner is Player 1 !");
                }else{
                    System.out.println("The Winner is Player 4 !");
                }
            }else{
                if(p3 > p4){
                    System.out.println("The Winner is Player 3 !");
                }else{
                    System.out.println("The Winner is Player 4 !");
                }
            }
        }else{
            if(p2 > p3){
                if(p2 > p4){
                    System.out.println("The Winner is Player 2 !");
                }else{
                    System.out.println("The Winner is Player 4!");
                }
            }else{
                if(p3 > p4){
                    System.out.println("The Winner is Player 3 !");
                }else{
                    System.out.println("The Winner is Player 4 !");
                }
            }
        }
    }
}
