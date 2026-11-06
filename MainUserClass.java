import java.util.*;
import java.io.*;

/** Created a Stack interface that declares all the methods the Stack class would have inside it to demonstrate LIFO */
interface StackInterface {
    void push(String item);
    String pop();
    String viewNext();
    boolean isEmpty();
    int size();
    Iterator<String> Stack_Iter();
}

/** Created a Queue interface that declares all the methods the Queue class would have inside it to demonstrate FIFO */
interface QueueInterface {
    void enqueue(String item);
    String dequeue();
    String viewNext();
    boolean isEmpty();
    int size();
    Iterator<String> Queue_Iter();
}

/** Created a Dequeue interface that declares all the methods the Dequeue class would have inside it, remove from top or bottom */
interface DequeInterface {
    void addHead(String item);
    void addTail(String item);
    String removeHead();
    String removeTail();
    String viewNextFirst();
    String viewNextLast();
    boolean isEmpty();
    int size();
    Iterator<String> Deque_Iter();
}

class Stack extends ArrayList<String> implements StackInterface {
    /**
     * Adds Item to Head
     * @param item the string item to be pushed onto the stack
     */
    public void push(String item) {
        add(item);
    }

    /**
     * Removes Item From Head
     *@return the item removed or null if the stack is empty
     */
    public String pop() {
        if (!isEmpty()) {
            return removeLast();
        } else return null;
    }

    /** A method that views the next item to be removed from the stack.
     */
    public String viewNext() {
        if (!isEmpty()) {
            return get(size() - 1);
        } else return null;
    }

    public Iterator<String> Stack_Iter() {
        /* Starts the pointer here */
        return new Iterator<String>() {
            int currentIndex = size() - 1;

            /** A method that checks for a next item and returns it. Ends the loop if there are no more items. Keeps checking until the first element (0).*/
            public boolean hasNext() {
                return currentIndex >= 0;
            }

            /** A method that decrements until there are no more items left. Last to First */
            public String next() {
                return get(currentIndex--);
            }

        };
    }
}

class Queue extends ArrayList<String> implements QueueInterface {
    /** Adds Item to Tail
     * @param item the string item to be added in the queue
     * */
    public void enqueue(String item) {
        add(item);
    }
    /** Removes Item from Head
     * @return the item removed or null if the stack is empty
     * */
    public String dequeue() {
        if (!isEmpty()) {
            return removeFirst();
        } else return null;
    }
    /** A method that views the next item to be removed
     * The next item to be removed is the first item in queue
     * */
    public String viewNext() {
        if (!isEmpty()) {
            return get(0);
        } else return null;
    }

    public Iterator<String> Queue_Iter() {
        /* Starts the pointer here */
        return new Iterator<String>() {
            int currentIndex = 0;

            /** A method that checks for a next item and returns it. Ends the loop if there are no more items. Keeps checking until the last element. */
            public boolean hasNext() {
                return currentIndex < size();
            }

            /** A method that increments until there are no more items left.. First to Last */
            public String next() {
                return get(currentIndex++);
            }
        };
    }
}
class Deque extends ArrayList<String> implements DequeInterface {
    /**
     * Adds Item to Head
     */
    public void addHead(String item) {
        addFirst(item);
    }

    /**
     * Adds Item to Tail
     */
    public void addTail(String item) {
        addLast(item);
    }

    /**
     * Removes Item From Head
     * @return the item removed from the head or null if the stack is empty
     */
    public String removeHead() {
        if (!isEmpty()) {
            return removeFirst();
        } else return null;
    }

    /**
     * Removes Item From Tail
     * @return the item removed from the tail or null if the stack is empty
     */
    public String removeTail() {
        if (!isEmpty()) {
            return removeLast();
        } else return null;
    }

    /**
     * A method that views the next item to be removed
     * The next item to be removed at the top
     */
    public String viewNextFirst() {
        if (!isEmpty()) {
            return get(0);
        } else return null;
    }

    /**
     * A method that views the next item to be removed
     * The next item to be removed at the bottom
     */
    public String viewNextLast() {
        if (!isEmpty()) {
            return get(size() - 1);
        } else return null;
    }

    public Iterator<String> Deque_Iter() {
        /* Starts the pointer here */
        return new Iterator<String>() {
            int currentIndex = 0;

            /** If there's a next item, return it, if not end the loop. Keeps checking until the last element. */
            public boolean hasNext() {
                return currentIndex < size();
            }

            /** Go down the list because there is a next item. First to Last */
            public String next() {
                return get(currentIndex++);
            }
        };
    }
}

/** The main method creates the main menu and declares each data structure variable, using a do/while loop and if else statements to prompt the user */
    public class mainuserclass {
        public static void main(String[] args) {
            Scanner stdin = new Scanner(System.in);
            Stack stack = new Stack();
            Queue queue = new Queue();
            Deque deque = new Deque();

            int mainChoice = 0;

            do {
                System.out.println("==================================================");
                System.out.println("              DATA STRUCTURES MENU                ");
                System.out.println("==================================================");
                System.out.println("1. Stack (LIFO)");
                System.out.println("2. Queue (FIFO)");
                System.out.println("3. Deque (Double-Ended");
                System.out.println("4. Exit");
                System.out.println("Choose your Data Structure (1-4): ");

                /** If there's a next item, make the next input integer the main number */
                if (stdin.hasNextInt()) {
                    mainChoice = stdin.nextInt();
                    stdin.nextLine();
                } else {
                    System.out.println("Invalid Input. Please Try Again!"); /* If the input is not a number */
                    stdin.next();
                }

/* The choices being made in the Main Menu and calling methods so that the main method isn't long and confusing */
                if (mainChoice == 1) {
                    runStackMenu(stdin, stack);
                } else if (mainChoice == 2) {
                    runQueueMenu(stdin, queue);
                } else if (mainChoice == 3) {
                    runDequeMenu(stdin, deque);
                } else if (mainChoice == 4) {
                    System.out.println("Exiting to Main Menu ");
                } else {
                    System.out.println("Please enter a valid number (1-4).");
                }
                System.out.println();

/* Do this while the number is not 4 and if it's anything else print invalid */
            } while (mainChoice != 4);

            stdin.close();
        }

        /** Method to run the Stack Submenu similar to the main menu using each method declared in the Stack class and using a scanner to prompt the user
         * for input */
        public static void runStackMenu(Scanner stdin, Stack stack) {
            int choice = 0;

            do {
                System.out.println("==================================================");
                System.out.println("                   STACK MENU                     ");
                System.out.println("==================================================");
                System.out.println("1. Push item");
                System.out.println("2. Pop item");
                System.out.println("3. View next item");
                System.out.println("4. Iterate through the stack");
                System.out.println("5. Check the size");
                System.out.println("6. Back to Main Menu");

                System.out.println("Please enter a number (1-6)");
                choice = stdin.nextInt();
                stdin.nextLine();

                if (choice == 1) {
                    System.out.println("Enter number");
                    String item = stdin.nextLine();
                    stack.push(item);
                    System.out.println("Pushed successfully.");
                } else if (choice == 2) {
                    System.out.println("Popped item: " + stack.pop());
                } else if (choice == 3) {
                    System.out.println("Next item to pop is: " + stack.viewNext());
                } else if (choice == 4) {
                    System.out.println("Stack Iteration for Stack ");
                    Iterator<String> it = stack.Stack_Iter();
                    if (!it.hasNext()) {
                        System.out.println("(Stack is empty)");
                    }
                        while (it.hasNext()) {
                            System.out.println("-> " + it.next());
                        }
                } else if (choice == 5) {
                    System.out.println("Is Empty? " + stack.isEmpty() + "| Size: " + stack.size());
                } else if (choice == 6) {
                    System.out.println("Returning to Main Menu");
                } else {
                    System.out.println("Invalid option");
                }
            } while (choice != 6);
        }

        /** Method to run the Queue Submenu similar to the main menu using each method declared in the Queue class and a scanner to input from the keyboard */
        public static void runQueueMenu(Scanner stdin, Queue queue) {
            int choice = 0;

            do {
                System.out.println("==================================================");
                System.out.println("                   Queue MENU                     ");
                System.out.println("==================================================");
                System.out.println("1. Enqueue item");
                System.out.println("2. Dequeue item");
                System.out.println("3. View next item");
                System.out.println("4. Iterate through the queue");
                System.out.println("5. Check the size");
                System.out.println("6. Back to Main Menu");

                System.out.println("Please enter a number (1-6)");
                choice = stdin.nextInt();
                stdin.nextLine();

                if (choice == 1) {
                    System.out.println("Enter number");
                    String item = stdin.nextLine();
                    queue.enqueue(item);
                    System.out.println("Queued item successfully");
                } else if (choice == 2) {
                    System.out.println("Dequeued item: " + queue.dequeue());
                } else if (choice == 3) {
                    System.out.println("Next item to dequeue is: " + queue.viewNext());
                } else if (choice == 4) {
                    System.out.println("Stack Iteration for Queue");
                    Iterator<String> it = queue.Queue_Iter();
                    if (!it.hasNext()) {
                        System.out.println("Queue is empty");
                    }
                        while (it.hasNext()) {
                            System.out.println("-> " + it.next());
                        }

                } else if (choice == 5) {
                    System.out.println("Is Empty? " + queue.isEmpty() + "| Size: " + queue.size());
                } else if (choice == 6) {
                    System.out.println("Returning to Main Menu.");
                } else {
                    System.out.println("Invalid option.");
                }
            } while (choice != 6);
        }


        /** Method to run the Deque Submenu similar to the main menu using each method declared in the Deque class and a scanner to input from the keyboard */
        public static void runDequeMenu(Scanner stdin, Deque deque) {
            int choice = 0;

            do {
                System.out.println("==================================================");
                System.out.println("                   DEQUE MENU");
                System.out.println("==================================================");
                System.out.println("1. Add to Head.");
                System.out.println("2. Add to Tail.");
                System.out.println("3. Remove from Head.");
                System.out.println("4. Remove from Tail.");
                System.out.println("5. View next head.");
                System.out.println("6. View next tail.");
                System.out.println("7. Iterate through the Deque..");
                System.out.println("8. Check the size.");
                System.out.println("9. Back to Main Menu.");

                System.out.println("Please enter a number (1-9)");
                choice = stdin.nextInt();
                stdin.nextLine();

                /* Did both Head and Tail Options for adding, removing and viewing */
                if (choice == 1) {
                    System.out.println("Enter number");
                    String item = stdin.nextLine();
                    deque.addHead(item);
                    System.out.println("Added to head successfully.");
                } else if (choice == 2) {
                    System.out.println("Enter number");
                    String item = stdin.nextLine();
                    deque.addTail(item);
                    System.out.println("Added to tail successfully.");
                } else if (choice == 3) {
                    System.out.println("Removed item from head successfully: " + deque.removeHead());
                } else if (choice == 4) {
                    System.out.println("Removed item from tail successfully: " + deque.removeTail());
                } else if (choice == 5) {
                    System.out.println("View next head: " + deque.viewNextFirst());
                } else if (choice == 6) {
                    System.out.println("View next tail: " + deque.viewNextLast());
                } else if (choice == 7) {
                    System.out.println("Stack Iteration for Deque ");
                    Iterator<String> it = deque.Deque_Iter();
                    if (!it.hasNext()) {
                        System.out.println("(Deque is empty)");
                    }
                    while (it.hasNext()) {
                        System.out.println("-> " + it.next());
                    }

                } else if (choice == 8) {
                    System.out.println("Is Empty? " + deque.isEmpty() + "| Size: " + deque.size());
                } else if (choice == 9) {
                    System.out.println("Returning to Main Menu");
                } else {
                    System.out.println("Invalid option");
                }
            } while (choice != 9);
        }
    }
