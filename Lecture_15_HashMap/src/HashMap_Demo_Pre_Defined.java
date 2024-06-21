import java.util.*;

public class HashMap_Demo_Pre_Defined {
    public static void main(String[] args){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("USA",100);
        map.put("UK",150);
        map.put("India",300);
        map.put("China",350);
        System.out.println(map);

        map.put("Sweden",100);
        System.out.println(map);

        map.put("India",325);
        System.out.println(map);

        System.out.println(map.get("India"));
        System.out.println(map.get("Africa"));

        System.out.println(map.remove("USA"));

        System.out.println(map.containsKey("India"));

        // Set cannot have duplicate values
        Set<String> keys_set = map.keySet();

        System.out.println("******Keys******");
        System.out.println(keys_set);
        for(String key:keys_set){
            System.out.println(key);
        }

        //Getting the Key_values set
        Collection<Integer> values_set = map.values();
        System.out.println("******Values******");
        for(Integer Val:values_set){
            System.out.println(Val);
        }

        System.out.println("*****Entry Set******");
        Set<Map.Entry<String,Integer>> entries = map.entrySet();
        for(Map.Entry<String,Integer> entry :  entries){
            System.out.print(entry.getKey()+" => " + entry.getValue());
        }

//
//        System.out.println("*****Max Occuring Character******");
//        String str = "aabbaaabcdda";
//        System.out.println(Get_Max_Frequency(str));

        // 2 Array Intersection
        int[] arr1 = {5,1,3,4,7};
        int[] arr2 = {2,4,3,5,7,10,15};
        ArrayList<Integer> ans = Interaction_2_Array(arr1,arr2);
        for(int i : ans){
            System.out.print(ans+" ");
        }
    }

    public static char Get_Max_Frequency(String str){
            HashMap<Character, Integer> char_map = new HashMap<>();
            for(int i = 0; i< str.length(); i++){
                char ch = str.charAt(i);
                if(char_map.containsKey(ch)){
                    char_map.put(ch,char_map.get(ch)+1);
                } else {
                    char_map.put(ch,1);
            }
        }
            char maxchar = '\0'; // Represents Null character
            int max = 0;
            Set<Map.Entry<Character,Integer>> entries = char_map.entrySet();
            for(Map.Entry<Character,Integer> entry : entries){
                if(entry.getValue() > max){
                    max = entry.getValue();
                    maxchar = entry.getKey();
                }
            }
        return maxchar;
    }

    public static ArrayList<Integer> Interaction_2_Array(int[] arr1, int[] arr2){
        HashMap<Integer,Boolean> array_data = new HashMap<>();

        //  Getting data of arr1 in a hashmap
        for(int i : arr1){
            array_data.put(i,false);
        }

        // ticking out the common data
        for(int j : arr2){
            if(array_data.containsKey(j)){
                array_data.put(j,true);
            }
        }

        // Creating a arraylist of answer
        ArrayList<Integer> ans = new ArrayList<>();
        Set<Map.Entry<Integer,Boolean>> datas = array_data.entrySet();
        for(Map.Entry<Integer,Boolean> data : datas){
            if(data.getValue().equals(true)){
                ans.add(data.getKey());
            }
        }
        return ans;
    }
}
