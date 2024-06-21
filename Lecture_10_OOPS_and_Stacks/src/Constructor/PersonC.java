package Constructor;
//Access specifiers
//default - Can be seen anywhere inside the package.
// Private -  Visible inside the same class
// Public -  Visible everywhere.
// Protected -  To be studied later
public class PersonC{
    private String name;
    private int age;

    public PersonC() {
        System.out.println("I am the default Constructor");}
    public PersonC(int age) {
        System.out.println("I am the Argument Constructor");
        this.age = age;}
    public PersonC(String name, int age){
        System.out.println("I have two params");
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
