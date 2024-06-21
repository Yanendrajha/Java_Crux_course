public class hashTable_Client {
    public static void main(String[] args) throws Exception{
        HashTable<String,Integer> map = new HashTable<>(4);
        map.put("USA",100);
        map.put("UK",150);
        map.put("India",300);
        map.put("India",325);
        map.display();
        map.put("China",350);
        map.display();


/*        map.put("Swedan", 54);
        //map.display();

        map.put("Korea", 325);
        map.display();

        map.put("Japan", 231);
        map.display();*/

//        System.out.println("*************Get*************");
//        System.out.println(map.get("India"));
//        map.display();
//
//        System.out.println("((((((((((((((((removed item)))))))))))))))))");
//        System.out.println(map.remove("USA"));
//        map.display();
    }
}
