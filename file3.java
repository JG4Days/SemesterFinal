/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jasonfinal;

import java.util.Scanner;
import java.util.ArrayList;

//
/**
 *
 * @author fred
 */
public class Jasonfinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Random r = new Random();
        ArrayList<Raven> ravens = new ArrayList();
        for (int i = 0; i < 3; i++) {
            ravens.add(new Raven(2 + i, 3 - i));
        }

        Harpies harpies = new Harpies(0, 0);
        Goats goats = new Goats(2, 2);
        //initialized/declared my char
        char field[][] = new char[10][10];
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
        String text = Userinput.nextLine();
        boolean play = false;
        while (!play) {
            //Sets the feild to basic symbols
            for (int k = 0; k < 5; k++) {
                for (int l = 0; l < 5; l++) {
                    field[k][l] = '_';
                }
            }
            if (text.contains("w")) {
                harpies.moveup();
                goats.moveup();
            }
            if (text.contains("s")) {
                harpies.movedown();
                goats.movedown();
            }
            if (text.contains("d")) {
                harpies.moveright();
                goats.moveright();
            }
            if (text.contains("a")) {
                goats.moveleft();
                harpies.moveleft();
            }
            // This is where the raven is pased through the goat value. 

            for (Raven Huginn : ravens) {
                Huginn.Collect(goats);
                field[Huginn.getY()][Huginn.getX()] = 'R';
            }

            // This is checking for intersections between the goat and raven
            for (Raven Huginn : ravens) {
                if (goats.getX() == Huginn.getX() && goats.getY() == Huginn.getY()) {
                    field[Huginn.getY()][Huginn.getX()] = 'R';
                    Huginn.Collect();
                    Huginn.Goaway(goats, harpies);

                }
            }
            for (Raven Muninn : ravens) {
                Muninn.Collecting(harpies);
                field[Muninn.getY()][Muninn.getX()] = 'S';
            }

            // This is checking for intersections between the harpie and raven
            for (Raven Muninn : ravens) {
                if (harpies.getX() == Muninn.getX() && harpies.getY() == Muninn.getY()) {
                    field[Muninn.getY()][Muninn.getX()] = 'S';
                    Muninn.Collect();
                    Muninn.Goaway(goats, harpies);
                }
            }

            //This sets the duck position to the duck symbol
            field[harpies.y][harpies.x] = harpies.symbol;
            field[goats.y][goats.x] = goats.symbol;

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

            text = Userinput.nextLine(); //waits for next input
        }
    }
}

class Harpies {

    int x, y;
    char symbol = 'H';

    Harpies(int x, int y) {
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

class Goats {

    int x, y;
    char symbol = 'G';

    Goats(int x, int y) {
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

    int x, y;
    char symbol = 'R';

    public char showSymbol() {
        return this.symbol;
    }

    Raven(int x, int y) {
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

    //ALL OF THESE ARE METHODS IF THEY START WITH MOVE it moves my enemy 
    public void finddown() {
        this.y += 1;
    }

    public void findright() {
        this.x += 1;
    }

    public void findup() {
        this.y -= 1;
    }

    public void findleft() {
        this.x -= 1;
    }

    public void Collect() {
        this.x = 0;
        this.y = 0;

    }

    public void Collect(Goats goats) {
        if (goats.x > this.x) {
            this.findright();
        }
        if (goats.y > this.y) {
            this.finddown();
        }
        if (goats.x < this.x) {
            this.findleft();
        }
        if (goats.y < this.y) {
            this.findup();
        }
    }

    public void Collecting(Harpies harpies) {
        if (harpies.x > this.x) {
            this.findright();
        }
        if (harpies.y > this.y) {
            this.finddown();
        }
        if (harpies.x < this.x) {
            this.findleft();
        }
        if (harpies.y < this.y) {
            this.findup();
        }
    }

    public void findReset() {
        this.x = 0;
        this.y = 0;
    }

    public void Goaway(Goats goats, Harpies harpies) {
        if (harpies.x == goats.x) {
            this.x = 0;
        }
        if (harpies.y == goats.y) {
            this.y = 0;
        }
    }
}
