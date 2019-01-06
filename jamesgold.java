package xdravenxd;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class XDRavenXD {

    public static void main(String[] args) {
        Goat goat = new Goat(4, 3);
        Raven Huginn = new Raven(0, 0);
        Raven Muninn = new Raven(9, 9);
        ArrayList<Raven> ravenz = new ArrayList();
        ravenz.add(Huginn);
        ravenz.add(Muninn);
        char[][] ray = new char[10][10];
        for (Raven r : ravenz) {
            ray[r.getY()][r.getX()] = r.getSymbol();
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                ray[i][j] = '.';
                System.out.print(ray[0][j]);
                System.out.print(" ");
            }
            System.out.println(ray[i][0]);
        }

        Random Randy = new Random();
        Scanner Userinput = new Scanner(System.in);
        String text = Userinput.nextLine();
        boolean play = true;
        while (play) {
            for (Raven r : ravenz) {
                ray[r.getY()][r.getX()] = r.getSymbol();

                if (text.contains("w")) {
                    r.moveup();
                }
                if (text.contains("s")) {
                    r.movedown();
                }
                if (text.contains("d")) {
                    r.moveright();
                }
                if (text.contains("a")) {
                    r.moveleft();
                    ray[r.getY()][r.getX()] = r.getSymbol();
                }
            }
            for (Raven r : ravenz) {
                ray[r.getY()][r.getX()] = r.getSymbol();
            }
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    ray[i][j] = '.';
                    System.out.print(ray[0][j]);
                    System.out.print(" ");
                }
            }

        }

    }

    class Raven {

        int y, x;
        char symbol = '7';

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

        public char getSymbol() {
            return symbol;
        }

        public void movedown() {
            this.y += 1;
        }

        public void moveright() {
            this.x += 1;
        }

        public void moveup() {
            this.y -= 1;
        }

        public void moveleft() {
            this.x -= 1;
        }
    }

    class Harpy {

        int y, x;
        char symbol = '7';

        Harpy(int x, int y) {
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
    }

    class Goat {

        int y, x;
        boolean isAlive;
        char symbol = '7';

        Goat(int x, int y) {
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
    }
