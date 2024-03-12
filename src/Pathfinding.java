import jdk.jfr.Unsigned;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



public class Pathfinding {
    static byte[][] map  = {
            {0 ,0 ,0 ,0 ,0 ,0 },
            {0 ,0 ,0 ,1 ,0 ,0 },
            {0 ,1 ,1 ,0 ,0 ,0 },
            {0 ,0 ,0 ,0 ,0 ,0 },
    };
    static Field start = new Field( null,new Position(2,1),fieldType.START);
    static Field finish = new Field( null,new Position(5,3),fieldType.FINISH);
    static Field current = start;




    public static boolean menu(){

        System.out.println("Karte Ausgeben..........0");
        System.out.println("Nachbarn vom Feld.......1");
        System.out.println("Program Beenden........-1");
        Scanner scan = new Scanner(System.in);

        addToMap(start);
        addToMap(finish);

        switch (scan.nextByte()){
            case 0 -> printMap(map);
            case 1 -> printNeighbours();
            case 2 -> manhattanHeuristic(current, finish);
            case -1 -> {
                return true;
            }

        }

        return false;
    }

    public static void printMap(byte[][] map){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1) System.out.printf(Util.RED +"%1$3s",  "◼︎");
                else if (map[i][j] == 2) System.out.printf(Util.GREEN +"%1$3s",  "◼︎");
                else if (map[i][j] == 3) System.out.printf(Util.PURPLE +"%1$3s",  "◼︎");
                else if (map[i][j] == 4) System.out.printf(Util.CYAN +"%1$3s",  "◼︎");
                else if (map[i][j] == 5) System.out.printf(Util.BLUE +"%1$3s",  "◼︎");
                else System.out.printf(Util.RESET + "%1$3s", "◼︎");
            }
            System.out.println(Util.RESET);
        }

    }
    public static void addToMap(Field pos){
        Pathfinding.map[pos.getPosition().getY()][pos.getPosition().getX()] = pos.getVal();
    }

    public static ArrayList<Field> getNeighbours(Field pos){
        ArrayList<Field> neighbors = new ArrayList<>();
        int[] dx = {1, -1, 0, 0, 1, -1, 1, -1}; // Movement in x-direction (including diagonals)
        int[] dy = {0, 0, 1, -1, 1, -1, -1, 1}; // Movement in y-direction (including diagonals)


        for (int i = 0; i < dx.length; i++) {
            int neighborX = pos.getPosition().getX() + dx[i];
            int neighborY = pos.getPosition().getY() + dy[i];

            // Check if the neighbor is within the grid bounds
            if (neighborX >= 0 && neighborX < Pathfinding.map.length &&
                    neighborY >= 0 && neighborY < Pathfinding.map[0].length) {

                int startCost = 10;
                if (Math.abs(dx[i]) == Math.abs(dy[i])) startCost = 14;
                Field neighbour = new Field(pos,new Position(neighborX, neighborY ),fieldType.values()[    Pathfinding.map[neighborY][neighborX]   ]);
                neighbour.setHeuristik(manhattanHeuristic(neighbour,Pathfinding.finish));
                neighbour.setCostToStart(pos.getCostToStart()+startCost);
                neighbors.add(neighbour);
            }
        }


        return neighbors;
    }

    public static void printNeighbours(){
        ArrayList<Field> neighbours = getNeighbours(current);
        for (int i = 0; i < neighbours.size(); i++) {
            System.out.printf("X: %d, Y: %d, Cost %s, g \n",neighbours.get(i).getPosition().getX(),  neighbours.get(i).getPosition().getY(), neighbours.get(i).getFieldCost());
        }
    }
    public static int manhattanHeuristic(Field pos,Field destination){
        int xDiff = Math.abs( destination.getPosition().getX() - pos.getPosition().getX());
        int yDiff = Math.abs( destination.getPosition().getY() - pos.getPosition().getY());
        return (xDiff+yDiff) * 10;
    }
}
