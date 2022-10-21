import javax.swing.*;
import java.awt.*;

public class DisplayGrid extends JComponent
{
    Grid grid;
    DisplayGrid(Grid grid){
        this.grid = grid;
    }
    public void paint(Graphics _g){
        Color brown = new Color(227, 45, 45);
        Color white = new Color(220,204,204);
        Color border = new Color(26, 25, 24);
        Graphics2D g = (Graphics2D) _g;
        for (int i = 0; i < grid.height; i++) {
            for (int j = 0; j < grid.width; j++) {
                g.setColor(grid.grid[i][j].state ? brown : white);
                grid.grid[i][j].rectangle.setLocation(10*j, 10*i);
                g.fill(grid.grid[i][j].rectangle);
                g.setColor(border);
                g.draw( grid.grid[i][j].rectangle);


            }
        }
    }
}
