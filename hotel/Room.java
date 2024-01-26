package hotel;

public class Room {
    private boolean reserved;
    private int maxPersons, price;

    public void setReserved(boolean res){
        this.reserved = res;
    }
    public void setMax(int max){
        this.maxPersons = max;
    }
    public void setPrice(int p){
        this.price = p;
    }
    public boolean getReserved(){
        return reserved;
    }
    public int getMax(){
        return maxPersons;
    }
    public int getPrice(){
        return price;
    }
}
