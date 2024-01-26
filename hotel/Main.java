package hotel;

public class Main {
    public static void main(String[] args){
        final int max_rooms = 300;
        Room[] rooms = new Room[max_rooms];
        for(int i = 0; i < max_rooms / 2; i++){ //Create 2 person rooms, price 150 / night
            rooms[i] = new Room();
            rooms[i].setMax(2);
            rooms[i].setPrice(150);
            rooms[i].setReserved(false);
        }
        for(int i = max_rooms / 2; i < max_rooms; i++){ //Create 3 person rooms, price 200 / night
            rooms[i] = new Room();
            rooms[i].setMax(3);
            rooms[i].setPrice(200);
            rooms[i].setReserved(false);
        }
        for(int i = 0; i < max_rooms; i++){
            System.out.println("\n");
            System.out.println(i+1);
            System.out.println(rooms[i].getMax());
            System.out.println(rooms[i].getPrice());
            System.out.println(rooms[i].getReserved());
        }

    }
}
