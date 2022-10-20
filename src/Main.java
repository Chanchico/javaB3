import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<int[]> coordonne = new ArrayList<>();


    public static void main(String[] args) {
        coordonne.add(new int[]{-1, -1});
        coordonne.add(new int[]{-1, 0});
        coordonne.add(new int[]{-1, 1});
        coordonne.add(new int[]{0, -1});
        coordonne.add(new int[]{0, 0});
        coordonne.add(new int[]{0, 1});
        coordonne.add(new int[]{1, -1});
        coordonne.add(new int[]{1, 0});
        coordonne.add(new int[]{1, 1});
        List<int[]> firstCell = new ArrayList<>();
        Grid game = new Grid(16, 16);
        
        firstCell.add(new int[]{3, 4});
        firstCell.add(new int[]{3, 5});
        firstCell.add(new int[]{3, 6});
        //Throw an ERROR firstCell.add(new int[]{3,-2});

        game.initFirstCells(firstCell);
        System.out.println(game.exiteOneCellAlive());
        game.printGrid();
    }

    private void game(Grid game){

        int x = 0;
        int y = 0;
        while(game.exiteOneCellAlive()) {
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    int cellAlive;
                    Cell cell = game.grid[i][j];
                    try {
                        coordonne.forEach();
                    }
                    catch(Exception e){
                        e.getMessage();
                    }
                }
            }
        }
    }
}