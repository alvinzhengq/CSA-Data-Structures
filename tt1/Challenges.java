package tt1;

import tt1.lib.Queue;
import tt1.lib.Stack;

import java.util.*;

public class Challenges {
    static void challenge1() {
        String[] strings = { "seven", "slimy", "snakes", "sallying", "slowly", "slithered", "southward" };
        Queue<String> q = new Queue<>();

        for (String s : strings) {
            q.add(s);
        }
        for (int i = 0; i < strings.length; i++) {
            q.delete();
        }
    }

    static void challenge2() {
        Queue<Integer> q = new Queue<>();
        q.add(1);
        q.add(4);
        q.add(5);
        q.add(8);

        Queue<Integer> q2 = new Queue<>();
        q2.add(2);
        q2.add(3);
        q2.add(6);
        q2.add(7);

        Queue<Integer> sortedQueue = new Queue<>();
        while (true) {
            if (q.getHead() != null && q2.getHead() != null) {
                int a = q.getHead().getData();
                int b = q2.getHead().getData();

                if (a < b) {
                    sortedQueue.add(a);
                    q.delete();
                } else {
                    sortedQueue.add(b);
                    q2.delete();
                }
                
            } else {
                while (q.getHead() != null) {
                    sortedQueue.add(q.getHead().getData());
                    q.delete();
                }

                while (q2.getHead() != null) {
                    sortedQueue.add(q2.getHead().getData());
                    q2.delete();
                }

                break;
            }
        }

        System.out.print("Sorted Queue: ");
        for (int i : sortedQueue) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static void challenge3() {
        Queue<Integer> q = new Queue<>();
        q.add(1);
        q.add(2);
        q.add(3);

        Stack<Integer> s = new Stack<>();
        for (Integer i : q) {
            s.push(i);
        }

        System.out.println(s);
    }

    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        Scanner s = new Scanner(System.in);

        System.out.println("Enter Challenge Number: ");
        int choice = s.nextInt();

        switch (choice) {
            case 1:
                challenge1();
                break;

            case 2:
                challenge2();
                break;

            case 3:
                challenge3();
                break;

            default:
                System.out.println("Error");
                break;
        }

        s.close();
    }
}
