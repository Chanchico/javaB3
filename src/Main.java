import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<int[]> firstCell = new ArrayList<>();
        Grid game = new Grid(16, 16);
        
        firstCell.add(new int[]{3, 4});
        //firstCell.add(new int[]{3, 5});
       // firstCell.add(new int[]{3, 6});
        //firstCell.add(new int[]{3,-2});

        game.initFirstCells(firstCell);
        System.out.println(game.exiteOneCellAlive());
        game.printGrid();
    }
}