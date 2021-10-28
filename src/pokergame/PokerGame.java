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
        Map<Integer, String> map = new HashMap<Integer, String>();
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
       player2HandRank = findHandRank(player2Hand);
       player3HandRank = findHandRank(player3Hand);
           
//        System.out.println(player1HandRank);
//        System.out.println(player2HandRank);
//        System.out.println(player3HandRank);
        
        if(player1HandRank == player2HandRank && player1HandRank == player3HandRank){
            System.out.println("1: Player 1");
            System.out.println("2: Player 2");
            System.out.println("3: Player 3");
        }else{
        
       map.put(player1HandRank, "Player 1");
       map.put(player2HandRank, "Player 2");
       map.put(player3HandRank, "Player 3");
               
               
               
        PriorityQueue<Integer> playerRankings = new PriorityQueue<>(Collections.reverseOrder());
        playerRankings.add(player1HandRank);
        playerRankings.add(player2HandRank);
        playerRankings.add(player3HandRank);
        System.out.println("1: "+map.get(playerRankings.poll()));
        System.out.println("2: "+map.get(playerRankings.poll()));
        System.out.println("3: "+map.get(playerRankings.poll()));
        }
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
        if(isFlush(hand)){
            return 9;
        }else{
            handRank--;
        }
        if(isOdd(hand)){
            return 8;
        }else{
            handRank--;
        }
        if(isEven(hand)){
            return 7;
        }else{
            handRank--;
        }
        if(isMonarchy(hand)){
            return 6;
        }else{
            handRank--;
        }
        if(is3Pair(hand)){
            return 5;
        }else{
            handRank--;
        }
        if(isMonochromatic(hand)){
            return 4;
        }else{
            handRank--;
        }
        if(isSwingers(hand)){
            return 3;
        }else{
            handRank--;
        }
        if(isRainbow(hand)){
            return 2;
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
    
    public static boolean isFlush(String[] hand){
        int cloves = 0, spades = 0, diamonds =0,hearts = 0,communityCardNumber = 0, playerCardNumber=0;
        int cloves2 = 0, spades2 = 0,diamonds2=0,hearts2=0;
        for(int i = 0;i<10;i++){           
              if(i<5){
               if(communityCardNumber < 6){
                 if(communityCards[i].charAt(1) == 's'){
                    spades++;
                    
                    communityCardNumber++;
                 }else if(communityCards[i].charAt(1) == 'h'){
                    hearts++;
                   
                    communityCardNumber++;
                 }else if(communityCards[i].charAt(1) == 'd'){
                    diamonds++;
                    
                    communityCardNumber++;
                 }else if(communityCards[i].charAt(1) == 'c'){
                    cloves++;
                    
                    communityCardNumber++;
                 }
               }
               
            }else if(i<10){
               if(playerCardNumber <6){
                if(hand[i-5].charAt(1) == 's'){
                    spades2++;
                    
                    playerCardNumber++;
                }else if(hand[i-5].charAt(1) == 'h'){
                    hearts2++;
                    
                    playerCardNumber++;
                }else if(hand[i-5].charAt(1) == 'd'){
                    diamonds2++;
                    
                    playerCardNumber++;
                }else if(hand[i-5].charAt(1) == 'c'){
                    cloves2++;
                    
                    playerCardNumber++;
                }
               }
            }
        }
        if(cloves >=4 && cloves2 >= 2 || cloves>=3 && cloves2 >=3|| diamonds >=4 && diamonds2 >= 2 ||diamonds >=3 && diamonds2 >= 3|| hearts >=3 && hearts2 >=3 || hearts >=4 && hearts2 >=2|| spades >=3  && spades2 >=3|| spades >=4  && spades2 >=2){
            return true;
        }
        return false;
    }
    
    public static boolean isOdd(String[] hand){
        int odd = 0,odd2 = 0,communityCardNumber = 0, playerCardNumber=0;
        
        for(int i = 0;i<10;i++){           
              if(i<5){
               if(communityCardNumber < 6){
                 if(communityCards[i].charAt(0) == '3' ||communityCards[i].charAt(0) == '5'|| communityCards[i].charAt(0) == '7'||communityCards[i].charAt(0) == '9'){
                    odd++;
                    
                    communityCardNumber++;
                 }
               }
               
            }else if(i<10){
               if(playerCardNumber <6){
                if(hand[i-5].charAt(0) == '3'||hand[i-5].charAt(0) == '5'||hand[i-5].charAt(0) == '7'||hand[i-5].charAt(0) == '9'){
                    odd2++;
                    
                    playerCardNumber++;
                }
               }
            }
        }
        if(odd >=4 && odd2 >= 2 || odd>=3 && odd2 >=3){
            return true;
        }
        return false;
    }
    
    public static boolean isEven(String[] hand){
        int even = 0,even2 = 0,communityCardNumber = 0, playerCardNumber=0;
        
        for(int i = 0;i<10;i++){           
              if(i<5){
               if(communityCardNumber < 6){
                 if(communityCards[i].charAt(0) == '2' ||communityCards[i].charAt(0) == '4'|| communityCards[i].charAt(0) == '6'||communityCards[i].charAt(0) == '8'||communityCards[i].charAt(0) == 'T'){
                    even++;
                    
                    communityCardNumber++;
                 }
               }
               
            }else if(i<10){
               if(playerCardNumber <6){
                if(hand[i-5].charAt(0) == '2'||hand[i-5].charAt(0) == '4'||hand[i-5].charAt(0) == '6'||hand[i-5].charAt(0) == '8'||hand[i-5].charAt(0) == 'T'){
                    even2++;
                    
                    playerCardNumber++;
                }
               }
            }
        }
        if(even >=4 && even2 >= 2 || even>=3 && even2 >=3){
            return true;
        }
        return false;
    }
    
    public static boolean isMonarchy(String[] hand){
        int kings = 0;
        int queens = 0;
        int jacks = 0;
        int nonfaceCards = 0;
        int playerCardNumber = 0;
        int communityCardNumber = 0;
        for(int i = 0;i<10;i++){
            if(i<5){
                
                if(communityCards[i].charAt(0) == 'Q'){
                  queens++;
                  communityCardNumber++;
                }else if(communityCards[i].charAt(0) == 'K' ){
                   kings++;
                   communityCardNumber++;
                }else if(communityCards[i].charAt(0) == 'J' ){
                    jacks++;
                    communityCardNumber++;
                }else {
                    nonfaceCards++;
                }
               
            }else if(i<10){
               
                if(hand[i-5].charAt(0) == 'Q'){
                    queens++;
                    playerCardNumber++;
                }else if(hand[i-5].charAt(0) == 'K'){
                    kings++;
                    playerCardNumber++;
                }else if(hand[i-5].charAt(0) == 'J'){
                    jacks++;
                    playerCardNumber++;
                }else{
                    nonfaceCards++;
                }
               
            }
        }      
        if(jacks == 1 && queens == 1 && kings == 1 && nonfaceCards>=3){
            return true;
        }
        return false;
    }
    
    public static boolean is3Pair(String[] hand){
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
        PriorityQueue<Integer> table1 = new PriorityQueue<>(Collections.reverseOrder());
        table1.add(two);
        table1.add(three);
        table1.add(four);
        table1.add(five);
        table1.add(six);
        table1.add(seven);
        table1.add(eight);
        table1.add(t);
        table1.add(nine);
        table1.add(jack);
        table1.add(king);
        table1.add(queen);
        table1.add(ace);
        if(table1.poll() >=2 && table1.poll() >= 2 && table1.poll() >=2){
            return true;
        }
        return false;
    }
    
    public static boolean isMonochromatic(String[] hand){
        int red = 0,red2 = 0, black=0,black2=0,communityCardNumber = 0, playerCardNumber=0;
        
        for(int i = 0;i<10;i++){           
              if(i<5){              
                 if(communityCards[i].charAt(1) == 'h' ||communityCards[i].charAt(1) == 'd'){
                    red++;                                     
                 }else if(communityCards[i].charAt(1) == 's' ||communityCards[i].charAt(1) == 'c') {
                     black++;
                 }                           
            }else if(i<10){
               
                if(hand[i-5].charAt(1) == 'h'||hand[i-5].charAt(1) == 'd'){
                    red2++;                                    
                }else if(hand[i-5].charAt(1) == 's'||hand[i-5].charAt(1) == 'c'){
                    black2++;
                }
               
            }
        }
        if(red >=4 && red2 >= 2 || red>=3 && red2 >=3 || black >=4 && black2 >= 2 || black>=3 && black2 >=3){
            return true;
        }
        return false;
    }
    
    public static boolean isSwingers(String[] hand){
        int kings = 0, kings2=0;
        int queens = 0,queens2=0;             
        int playerCardNumber = 0;
        int communityCardNumber = 0;
        for(int i = 0;i<10;i++){
            if(i<5){
                
                if(communityCards[i].charAt(0) == 'Q'){
                  queens++;
                  communityCardNumber++;
                }else if(communityCards[i].charAt(0) == 'K' ){
                   kings++;
                   communityCardNumber++;
                }
               
            }else if(i<10){
               
                if(hand[i-5].charAt(0) == 'Q'){
                    queens2++;
                    playerCardNumber++;
                }else if(hand[i-5].charAt(0) == 'K'){
                    kings2++;
                    playerCardNumber++;
                }
               
            }
        }      
        if(queens >=2 && kings>=2 || queens >=2 && kings2>=2||kings>=2&&queens2>=2){
            return true;
        }
        return false;
    }
    
    public static boolean isRainbow(String[] hand){
        int cloves = 0, spades = 0, diamonds =0,hearts = 0;
        int cloves2 = 0, spades2 = 0,diamonds2=0,hearts2=0;
        for(int i = 0;i<10;i++){           
              if(i<5){
               
                 if(communityCards[i].charAt(1) == 's'){
                    spades++;
                    
                    
                 }else if(communityCards[i].charAt(1) == 'h'){
                    hearts++;
                   
                    
                 }else if(communityCards[i].charAt(1) == 'd'){
                    diamonds++;
                    
                  
                 }else if(communityCards[i].charAt(1) == 'c'){
                    cloves++;
                    
                   
                 }
               
               
            }else if(i<10){
              
                if(hand[i-5].charAt(1) == 's'){
                    spades2++;
                    
                    
                }else if(hand[i-5].charAt(1) == 'h'){
                    hearts2++;
                    
                    
                }else if(hand[i-5].charAt(1) == 'd'){
                    diamonds2++;
                    
                    
                }else if(hand[i-5].charAt(1) == 'c'){
                    cloves2++;
                    
                    
                }
               
            }
        }
        if(cloves >=1&&diamonds>=1&&hearts>=1&&spades>=1 || cloves+cloves2>=1 && diamonds+diamonds2>=1 && spades+spades2>=1 && hearts+hearts2>=1){
            return true;
        }
        return false;
    }
}//End Class

