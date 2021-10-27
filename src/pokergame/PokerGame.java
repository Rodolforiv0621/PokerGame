package pokergame;
import java.util.*;
public class PokerGame {
        static String[] communityCards = new String[5];
        static String[] player1Hand = new String[5];
        static String[] player2Hand = new String[5];
        static String[] player3Hand = new String[5];
        static int player1HandRank;
        static int player2HandRank;
        static int player3HandRank;
        
    public static void main(String[] args) {
        int counter = 0;
        //Assign hand to each player
        for(int i = 0;i<args.length;i++){
            
            if(counter >= 5){
                counter = 0;
            }
            if(i<5){
                communityCards[counter] = args[i];
            }else if(i<10){
                player1Hand[counter] = args[i];
            }else if(i<15){
                player2Hand[counter] = args[i];
            }else if(i<20){
                player3Hand[counter] = args[i];
            }
           counter++;
        }
       //Assign Rank to each hand
       player1HandRank = findHandRank(player1Hand);
        System.out.println(player1HandRank);
        
    }//End main
    
    
    public static int findHandRank(String[] hand){
        int handRank = 16;
        if(isDinnerParty(hand)){
            return 16;
        }else{
            handRank--;
        }
        if(isPolitics(hand)){
            return 15;
        }else{
            handRank--;
        }
        if(isOrgy(hand)){
            return 14;
        }else{
            handRank--;
        }
        if(isKingdom(hand)){
            return 13;
        }else{
            handRank--;
        }
        if(isHomosapiens(hand)){
            return 12;
        }else{
            handRank--;
        }
        if(isOverfullHouse(hand)){
            return 11;
        }else{
            handRank--;
        }
        if(isTriplets(hand)){
            return 10;
        }else{
            handRank--;
        }
        return handRank;
    }
    
    public static boolean isDinnerParty(String[] hand){
        int kings = 0;
        int queens = 0;
        int playerCardNumber = 0;
        int communityCardNumber = 0;
        for(int i = 0;i<10;i++){
            if(i<5){
                if(communityCardNumber < 3){
                if(communityCards[i].charAt(0) == 'Q'){
                    queens++;
                    communityCardNumber++;
                }else if(communityCards[i].charAt(0) == 'K'){
                    kings++;
                    communityCardNumber++;
                }
               }
            }else if(i<10){
               if(playerCardNumber <3){
                if(hand[i-5].charAt(0) == 'Q'){
                    queens++;
                    playerCardNumber++;
                }else if(hand[i-5].charAt(0) == 'K'){
                    kings++;
                    playerCardNumber++;
                }
               }
            }
        }
        if(kings + queens >=6){
            return true;
        }
        return false;
    }
    
    public static boolean isPolitics(String[] hand){
        int kings = 0;
        int queens = 0;
        int jacks = 0;
        int playerCardNumber = 0;
        int communityCardNumber = 0;
        for(int i = 0;i<10;i++){
            if(i<5){
                if(communityCardNumber <= 3){
                if(communityCards[i].charAt(0) == 'Q' && queens < 2){
                  queens++;
                  communityCardNumber++;
                }else if(communityCards[i].charAt(0) == 'K' && kings < 2){
                   kings++;
                   communityCardNumber++;
                }else if(communityCards[i].charAt(0) == 'J' && jacks <2){
                    jacks++;
                    communityCardNumber++;
                }
               }
            }else if(i<10){
               if(playerCardNumber <3){
                if(hand[i-5].charAt(0) == 'Q' && queens < 2){
                    queens++;
                    playerCardNumber++;
                }else if(hand[i-5].charAt(0) == 'K' && kings < 2){
                    kings++;
                    playerCardNumber++;
                }else if(hand[i-5].charAt(0) == 'J' && jacks <2){
                    jacks++;
                    playerCardNumber++;
                }
               }
            }
        }      
        if(jacks >= 2 && queens >= 2 && kings >= 2){
            return true;
        }
        return false;
    }
    
    public static boolean isOrgy(String[] hand){
        int jacks = 0;
        int queens = 0;
        int playerCardNumber = 0;
        int communityCardNumber = 0;
        for(int i = 0;i<10;i++){           
              if(i<5){
               if(communityCardNumber < 3){
                 if(communityCards[i].charAt(0) == 'Q'){
                    queens++;
                    communityCardNumber++;
                 }else if(communityCards[i].charAt(0) == 'J'){
                    jacks++;
                    communityCardNumber++;
                 }
               }
            }else if(i<10){
               if(playerCardNumber <3){
                if(hand[i-5].charAt(0) == 'Q'){
                    queens++;
                    playerCardNumber++;
                }else if(hand[i-5].charAt(0) == 'J'){
                    jacks++;
                    playerCardNumber++;
                }
               }
            }
        }
        if(jacks + queens >=6){
            return true;
        }
        return false;
    }
    
    public static boolean isKingdom(String[] hand){
        int spades = 0;
        int hearts = 0;
        int diamonds = 0;
        int cloves = 0;       
        int cloveJack=0,cloveKing=0,cloveQueen=0;
        int spadeJack=0,spadeKing=0,spadeQueen=0;
        int diamondJack=0,diamondKing=0,diamondQueen=0;
        int heartsJack=0,heartsKing=0,heartsQueen=0;
        int playerCardNumber = 0;
        int communityCardNumber = 0;
        for(int i = 0;i<10;i++){           
              if(i<5){
               if(communityCardNumber < 6){
                 if(communityCards[i].charAt(1) == 's'){
                    spades++;
                    if(communityCards[i].charAt(0) == 'K') spadeKing++;
                    if(communityCards[i].charAt(0) == 'Q') spadeQueen++;
                    if(communityCards[i].charAt(0) == 'J') spadeJack++;
                    communityCardNumber++;
                 }else if(communityCards[i].charAt(1) == 'h'){
                    hearts++;
                    if(communityCards[i].charAt(0) == 'K') heartsKing++;
                    if(communityCards[i].charAt(0) == 'Q') heartsQueen++;
                    if(communityCards[i].charAt(0) == 'J') heartsJack++;
                    communityCardNumber++;
                 }else if(communityCards[i].charAt(1) == 'd'){
                    diamonds++;
                    if(communityCards[i].charAt(0) == 'K') diamondKing++;
                    if(communityCards[i].charAt(0) == 'Q') diamondQueen++;
                    if(communityCards[i].charAt(0) == 'J') diamondJack++;
                    communityCardNumber++;
                 }else if(communityCards[i].charAt(1) == 'c'){
                    cloves++;
                    if(communityCards[i].charAt(0) == 'K') cloveKing++;
                    if(communityCards[i].charAt(0) == 'Q') cloveQueen++;
                    if(communityCards[i].charAt(0) == 'J') cloveJack++;
                    communityCardNumber++;
                 }
               }
               
            }else if(i<10){
               if(playerCardNumber <6){
                if(hand[i-5].charAt(1) == 's'){
                    spades++;
                    if(hand[i-5].charAt(0) == 'K') spadeKing++;
                    if(hand[i-5].charAt(0) == 'Q') spadeQueen++;
                    if(hand[i-5].charAt(0) == 'J') spadeJack++;
                    playerCardNumber++;
                }else if(hand[i-5].charAt(1) == 'h'){
                    hearts++;
                    if(hand[i-5].charAt(0) == 'K') heartsKing++;
                    if(hand[i-5].charAt(0) == 'Q') heartsQueen++;
                    if(hand[i-5].charAt(0) == 'J') heartsJack++;
                    playerCardNumber++;
                }else if(hand[i-5].charAt(1) == 'd'){
                    diamonds++;
                    if(hand[i-5].charAt(0) == 'K') diamondKing++;
                    if(hand[i-5].charAt(0) == 'Q') diamondQueen++;
                    if(hand[i-5].charAt(0) == 'J') diamondJack++;
                    playerCardNumber++;
                }else if(hand[i-5].charAt(1) == 'c'){
                    cloves++;
                    if(hand[i-5].charAt(0) == 'K') cloveKing++;
                    if(hand[i-5].charAt(0) == 'Q') cloveQueen++;
                    if(hand[i-5].charAt(0) == 'J') cloveJack++;
                    playerCardNumber++;
                }
               }
            }
        }
        if(spades>=6){
            if(spadeKing >=1 && spadeQueen >=1 && spadeJack >= 1){
                return true;
            }
        }else if(hearts >=6){
            if(heartsKing >=1 && heartsQueen >=1 && heartsJack >= 1){
                return true;
            }
        }else if(diamonds >=6){
            if(diamondKing >=1 && diamondQueen >=1 && diamondJack >= 1){
                return true;
            }
        }
        
        return false;
    }
    
    public static boolean isHomosapiens(String[] hand){
        int kings = 0;
        int queens = 0;
        int jacks = 0;
        int playerCardNumber = 0;
        int communityCardNumber = 0;
        for(int i = 0;i<10;i++){
            if(i<5){
                if(communityCardNumber<3){
                if(communityCards[i].charAt(0) == 'Q'){
                    queens++;
                    communityCardNumber++;
                }else if(communityCards[i].charAt(0) == 'K'){
                    kings++;
                    communityCardNumber++;
                }else if(communityCards[i].charAt(0) == 'J'){
                    jacks++;
                    communityCardNumber++;
                }
               }
            }else if(i<10){
               if(playerCardNumber <3){
                if(hand[i-5].charAt(0) == 'Q'){
                    queens++;
                    playerCardNumber++;
                }else if(hand[i-5].charAt(0) == 'K'){
                    kings++;
                    playerCardNumber++;
                }else if(hand[i-5].charAt(0) == 'J'){
                    jacks++;
                    playerCardNumber++;
                }
               }
            }
        }
        if(kings + queens + jacks >=6){
            return true;
        }
        return false;
    }
    
    public static boolean isOverfullHouse(String[] hand){
        int two = 0;
        int three = 0;
        int four = 0;
        int five = 0;
        int six = 0;
        int seven = 0;
        int eight = 0;
        int nine = 0;
        int t = 0;
        int jack = 0;
        int king = 0;
        int queen = 0;
        int ace = 0;
        int playerCardNumber = 0;
        int communityCardNumber = 0;
        for(int i = 0;i<10;i++){
            if(i<5){
               //if(communityCardNumber<3){
                if(communityCards[i].charAt(0) == '2') two++;                                   
                if(communityCards[i].charAt(0) == '3') three++;
                if(communityCards[i].charAt(0) == '4') four++;
                if(communityCards[i].charAt(0) == '5') five++;                                   
                if(communityCards[i].charAt(0) == '6') six++;
                if(communityCards[i].charAt(0) == '7') seven++;
                if(communityCards[i].charAt(0) == '8') eight++;                                   
                if(communityCards[i].charAt(0) == '9') nine++;
                if(communityCards[i].charAt(0) == 'T') t++;
                if(communityCards[i].charAt(0) == 'J') jack++;
                if(communityCards[i].charAt(0) == 'K') king++;
                if(communityCards[i].charAt(0) == 'Q') queen++;
                if(communityCards[i].charAt(0) == 'A') ace++; 
                communityCardNumber++;
               //}
            }else if(i<10){
               //if(playerCardNumber <3){
                if(hand[i-5].charAt(0) == '2') two++;                                    
                if(hand[i-5].charAt(0) == '3') three++;
                if(hand[i-5].charAt(0) == '4') four++;
                if(hand[i-5].charAt(0) == '5') five++;                                   
                if(hand[i-5].charAt(0) == '6') six++;
                if(hand[i-5].charAt(0) == '7') seven++;
                if(hand[i-5].charAt(0) == '8') eight++;                                     
                if(hand[i-5].charAt(0) == '9') nine++;
                if(hand[i-5].charAt(0) == 'T') t++;
                if(hand[i-5].charAt(0) == 'J') jack++;
                if(hand[i-5].charAt(0) == 'K') king++;
                if(hand[i-5].charAt(0) == 'Q') queen++;
                if(hand[i-5].charAt(0) == 'A') ace++;
                playerCardNumber++;
               //}
            }
        }
        PriorityQueue<Integer> table = new PriorityQueue<>(Collections.reverseOrder());
        table.add(two);
        table.add(three);
        table.add(four);
        table.add(five);
        table.add(six);
        table.add(seven);
        table.add(eight);
        table.add(t);
        table.add(nine);
        table.add(jack);
        table.add(king);
        table.add(queen);
        table.add(ace);
        if(table.poll()>=4 && table.poll()>=2){
            return true;
        }
        return false;
    }
    
    public static boolean isTriplets(String[] hand){
        int two = 0;
        int three = 0;
        int four = 0;
        int five = 0;
        int six = 0;
        int seven = 0;
        int eight = 0;
        int nine = 0;
        int t = 0;
        int jack = 0;
        int king = 0;
        int queen = 0;
        int ace = 0;
        int playerCardNumber = 0;
        int communityCardNumber = 0;
        for(int i = 0;i<10;i++){
            if(i<5){
               //if(communityCardNumber<3){
                if(communityCards[i].charAt(0) == '2') two++;                                   
                if(communityCards[i].charAt(0) == '3') three++;
                if(communityCards[i].charAt(0) == '4') four++;
                if(communityCards[i].charAt(0) == '5') five++;                                   
                if(communityCards[i].charAt(0) == '6') six++;
                if(communityCards[i].charAt(0) == '7') seven++;
                if(communityCards[i].charAt(0) == '8') eight++;                                   
                if(communityCards[i].charAt(0) == '9') nine++;
                if(communityCards[i].charAt(0) == 'T') t++;
                if(communityCards[i].charAt(0) == 'J') jack++;
                if(communityCards[i].charAt(0) == 'K') king++;
                if(communityCards[i].charAt(0) == 'Q') queen++;
                if(communityCards[i].charAt(0) == 'A') ace++; 
                communityCardNumber++;
               //}
            }else if(i<10){
               //if(playerCardNumber <3){
                if(hand[i-5].charAt(0) == '2') two++;                                    
                if(hand[i-5].charAt(0) == '3') three++;
                if(hand[i-5].charAt(0) == '4') four++;
                if(hand[i-5].charAt(0) == '5') five++;                                   
                if(hand[i-5].charAt(0) == '6') six++;
                if(hand[i-5].charAt(0) == '7') seven++;
                if(hand[i-5].charAt(0) == '8') eight++;                                     
                if(hand[i-5].charAt(0) == '9') nine++;
                if(hand[i-5].charAt(0) == 'T') t++;
                if(hand[i-5].charAt(0) == 'J') jack++;
                if(hand[i-5].charAt(0) == 'K') king++;
                if(hand[i-5].charAt(0) == 'Q') queen++;
                if(hand[i-5].charAt(0) == 'A') ace++;
                playerCardNumber++;
               //}
            }
        }
        PriorityQueue<Integer> table = new PriorityQueue<>(Collections.reverseOrder());
        table.add(two);
        table.add(three);
        table.add(four);
        table.add(five);
        table.add(six);
        table.add(seven);
        table.add(eight);
        table.add(t);
        table.add(nine);
        table.add(jack);
        table.add(king);
        table.add(queen);
        table.add(ace);
        if(table.poll()>=3 && table.poll()>=3){
            return true;
        }
        return false;
    }
}//End Class
















//        for(int j = 0;j<20;j++){
//            
//            if(counter >= 5){
//                counter = 0;
//            }
//            if(j<5){
//                System.out.println(j+": "+communityShield[counter]);
//
//            }else if(j<10){
//                System.out.println(j+": "+player1[counter]);
//            }else if(j<15){
//                System.out.println(j+": "+player2[counter]);
//            }else if(j<20){
//                System.out.println(j+": "+player3[counter]);
//            }
//            
//            counter++;
//            
//        }