import java.awt.*;

public class Cell extends Rectangle{
    boolean state; //vrai cellule vivante,  faux cellule morte
    Rectangle rectangle = new Rectangle(10, 10);
    Cell(boolean b){

        this.state = b;
    }
    public void kill(  ){
        this.state = false;
    }
    public void giveBirth() {
        this.state = true;
    }



}