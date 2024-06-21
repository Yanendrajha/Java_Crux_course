package Exception_Handling;

public class Client {
    public static void main(String[] args){

        System.out.println("Hello");

        Student s1= new Student();
        try{s1.setAge(34);
            System.out.println("After trying");
        } catch (Exception e) {
            System.out.println("In catch block");
        }

        System.out.println("Bye");
        System.out.println(s1.getAge());
    }
}
