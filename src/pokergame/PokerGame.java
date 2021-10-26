package pokergame;
public class PokerGame {
        static String[] communityShield = new String[5];
        static String[] Player1;
        static String[] Player2;
        String[] Player3;
        String[] Player4;
        String[] Player5;
    public static void main(String[] args) {
        
        for(int i = 0;i<args.length;i++){
            if(i<5){
                communityShield[i] = args[i];
            }
            
        }
        for(int j = 0;j<communityShield.length;j++){
            System.out.println(communityShield[j].charAt(1));
        }
    }
    
}
