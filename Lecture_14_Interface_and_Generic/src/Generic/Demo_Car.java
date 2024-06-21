package Generic;

public class Demo_Car implements Comparable<Generic.Demo_Car>{
        int speed;
        int price;
        String color;
        public Demo_Car(int speed,int price, String color){
            this.speed = speed;
            this.price = price;
            this.color = color;
        }

        public String toString(){
            return "S: " + this.speed +" P: "+this.price + " C: " + this.color;
        }

    @Override
    public int compareTo(Generic.Demo_Car other) {
            return this.speed - other.speed;
    }

}
