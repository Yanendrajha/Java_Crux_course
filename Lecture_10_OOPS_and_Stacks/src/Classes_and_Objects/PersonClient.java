package Classes_and_Objects;

public class PersonClient {
    public static void main(String[] args){
        Person p1 = new Person();
        Person p2 = new Person();
//        System.out.println(p1.name);
//        System.out.println((p1.age));
        System.out.println(p1.getName());
        System.out.println(p1.getAge());


        p2.setName("Yanendnra");
        p2.setAge(22);

        System.out.println(p2.getName());
        System.out.println(p2.getAge());
    }
}
