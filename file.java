/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jasonfinal;
import java.util.Scanner;
        

/**
 *
 * @author fred
 */
public class Jasonfinal {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        Duck duck = new Duck(0,0);
        Raven raven = new Raven(0,0);
        //initialized/declared my char
        char field[][] = new char[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                field[i][j] = '_';
                //This is creating the row
              System.out.print(field[0][j]);
              //This is putting a space between the underscore
                System.out.print(" ");
            }
            //this is creating the colomn
            System.out.println(field[i][0]);
        }
       Scanner Userinput = new Scanner(System.in);
       String text  = Userinput.nextLine();
       boolean play = false;
       while (!play){
           
           if (text.contains("w")){
               duck.moveup();
           }
              if (text.contains("s")){
               duck.movedown();
           }
                 if (text.contains("d")){
               duck.moveright();
           }
                    if (text.contains("a")){
               duck.moveleft();
           }
           //Sets the feild to basic symbols
           for (int k = 0; k < 5; k++) {
            for (int l = 0; l < 5; l++) {
                field[k][l] = '_';
            }}
           //This sets the duck position to the duck symbol
           field[duck.y][duck.x]= duck.symbol;
           for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                //This prints out the row on the field
                System.out.print(field[y][x]);
                //This is creating a space between the row
                System.out.print(" ");
            }
            //This goes to the next line b4 prints out
               System.out.println();
           }
           System.out.println();
         //  text  = Userinput.nextLine(); //waits for next input
       }
}
}
class Duck {
    int x,y;
    char symbol = '<';
    Duck(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
   
    public void moveleft() {
        if (this.x >= 1) {
            this.x -= 1;
        } else {
            //   This is an boundary to tell the player he cant go past the array if he does it subracts 1
            this.x = this.x + 1;
        }
    }

    public void moveright() {
        if (this.x < 3) {
            this.x += 1;
        } else {
            // This is an boundary to tell the player he cant go past the array if he does it adds 1
            this.x -= 1;
        }
    }

    public void moveup() {
        if (this.y == 0) {
            this.y += 1;
        } else {
            // This is an boundary to tell the player he cant go past the array if he does it adds 1
            this.y -= 1;
        }
    }

    public void movedown() {
        if (this.y == 4) {
            this.y -= 1;
        } else {
            // This is an boundary to tell the player he cant go past the array if he does it subracts 1
            this.y += 0;
        }
    }
}
class Raven {
    int x,y;
    char symbol = '<';
    Raven(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
   
    public void moveleft() {
        if (this.x >= 1) {
            this.x -= 1;
        } else {
            //   This is an boundary to tell the player he cant go past the array if he does it subracts 1
            this.x = this.x + 1;
        }
    }

    public void moveright() {
        if (this.x < 3) {
            this.x += 1;
        } else {
            // This is an boundary to tell the player he cant go past the array if he does it adds 1
            this.x -= 1;
        }
    }

    public void moveup() {
        if (this.y == 0) {
            this.y += 1;
        } else {
            // This is an boundary to tell the player he cant go past the array if he does it adds 1
            this.y -= 1;
        }
    }

    public void movedown() {
        if (this.y == 4) {
            this.y -= 1;
        } else {
            // This is an boundary to tell the player he cant go past the array if he does it subracts 1
            this.y += 0;
        }
    }
}
