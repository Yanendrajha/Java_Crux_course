import java.lang.reflect.Array;
import java.util.Arrays;

public class SOE_Prime_Method {

    public static void main(String[] args){
        SOE(25);
    }
    public static void SOE(int n){
        Boolean[] primes = new Boolean[n+1];
        Arrays.fill(primes,true);

        primes[0] = false; primes[1] = false;

        for(int table  = 2; table <= Math.sqrt(n); table++){

            if(!primes[table]){
                continue;}

            for(int mult = 2; table * mult <= n; mult++){
                primes[table*mult] = false;}}

        for(int i =0 ;i<n+1; i++){
            if(primes[i]){
                System.out.print(i+ " ");
            }
    }}}
