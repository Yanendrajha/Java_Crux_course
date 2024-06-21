public class HE_Client {
    public static void main(String[] args) {
        String str= "abbccda";
        Haffman_Encoder hf = new Haffman_Encoder(str);
        String coded_String =  hf.encode(str);
        System.out.println(coded_String);

        String output = hf.decode(coded_String);
        System.out.println(output);
    }
}
