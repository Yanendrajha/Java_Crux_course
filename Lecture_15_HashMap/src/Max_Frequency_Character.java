import java.util.HashMap;

public class Max_Frequency_Character {
    public static void main(String[] args){
        HashMap<Character, Integer> char_map = new HashMap<>();
        String str = "aabbaaabcdda";
        for(int i = 0; i< str.length(); i++){
            char ch = str.charAt(i);
            char_map.put(ch,char_map.get(ch) +1);
        }
        System.out.println(char_map);
    }
}
