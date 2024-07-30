package com.iiht.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.*;

public class TestStore {

    public static void main(String[] args) {
        // Initialize the Spring application context
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);

        // Retrieve beans from the application context
        ArrayList<Eggs> eggArrayList = context.getBean("eggArrayList", ArrayList.class);
        HashSet<Milk> milkHashSet = context.getBean("milkHashSet", HashSet.class);
        LinkedList<Chocolate> chocoLinkedList = context.getBean("chocoLinkedList", LinkedList.class);
        TreeSet<Apples> appleTree = context.getBean("appleTree", TreeSet.class);
        Queue<Bread> breadQueue = context.getBean("breadQueue", LinkedList.class); // Queue and LinkedList both refer to the same bean here
        HashMap<Integer, Collection<?>> storeMap = context.getBean("storeMap", HashMap.class);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("UST Store");
            System.out.println("Select an Option:\n1.Seller\n2.Customer\n3.Exit");

            int opt = sc.nextInt();
            sc.nextLine();  // Consume the leftover newline character

            if (opt == 1) {
                System.out.println("What do you want to enter?\n1.Eggs\n2.Milk\n3.Chocolates\n4.Apples\n5.Bread");
                int opt1 = sc.nextInt();
                sc.nextLine();  // Consume the leftover newline character

                System.out.println("Enter the number of varieties you want to enter:");
                int var = sc.nextInt();
                sc.nextLine();  // Consume the leftover newline character

                switch (opt1) {
                    case 1:
                        while (var-- > 0) {
                            System.out.println("Enter Company, quantity and expiryDays");
                            String company = sc.nextLine();
                            int quantity = sc.nextInt();
                            int expiryDays = sc.nextInt();
                            sc.nextLine();  // Consume the leftover newline character
                            eggArrayList.add(new Eggs(quantity, company, expiryDays));
                        }
                        break;
                    case 2:
                        while (var-- > 0) {
                            System.out.println("Enter Company, quantity and expiryDays");
                            String company = sc.nextLine();
                            int quantity = sc.nextInt();
                            int expiryDays = sc.nextInt();
                            sc.nextLine();  // Consume the leftover newline character
                            milkHashSet.add(new Milk(quantity, company, expiryDays));
                        }
                        break;
                    case 3:
                        while (var-- > 0) {
                            System.out.println("Enter Company, quantity and expiryDays");
                            String company = sc.nextLine();
                            int quantity = sc.nextInt();
                            int expiryDays = sc.nextInt();
                            sc.nextLine();
                            chocoLinkedList.add(new Chocolate(quantity, company, expiryDays));
                        }
                        break;
                    case 4:
                        while (var-- > 0) {
                            System.out.println("Enter Company, quantity and expiryDays");
                            String company = sc.nextLine();
                            int quantity = sc.nextInt();
                            int expiryDays = sc.nextInt();
                            sc.nextLine();  // Consume the leftover newline character
                            appleTree.add(new Apples(quantity, company, expiryDays));
                        }
                        break;
                    case 5:
                        while (var-- > 0) {
                            System.out.println("Enter Company, quantity and expiryDays");
                            String company = sc.nextLine();
                            int quantity = sc.nextInt();
                            int expiryDays = sc.nextInt();
                            sc.nextLine();  // Consume the leftover newline character
                            breadQueue.add(new Bread(quantity, company, expiryDays));
                        }
                        break;
                    default:
                        System.out.println("Invalid option");
                        break;
                }
            } else if (opt == 2) {
                while (true) {
                    System.out.println("Customer Options:");
                    System.out.println("1. View All Items");
                    System.out.println("2. Buy an Item");
                    System.out.println("3. Exit");
                    int customerOption = sc.nextInt();
                    sc.nextLine();  // Consume the leftover newline character

                    if (customerOption == 1) {
                        System.out.println("Items available in the store:");
                        System.out.println("Eggs: " + eggArrayList);
                        System.out.println("Milk: " + milkHashSet);
                        System.out.println("Chocolates: " + chocoLinkedList);
                        System.out.println("Apples: " + appleTree);
                        System.out.println("Bread: " + breadQueue);
                    } else if (customerOption == 2) {
                        System.out.println("What do you want to buy?\n1.Eggs\n2.Milk\n3.Chocolates\n4.Apples\n5.Bread");
                        int itemChoice = sc.nextInt();
                        sc.nextLine();  // Consume the leftover newline character

                        switch (itemChoice) {
                            case 1:
                                if (eggArrayList.isEmpty()) {
                                    System.out.println("No eggs available.");
                                } else {
                                    System.out.println("Available eggs: ");
                                    for (int i = 0; i < eggArrayList.size(); i++) {
                                        System.out.println((i + 1) + ". " + eggArrayList.get(i));
                                    }
                                    System.out.println("Enter the index of the egg to buy:");
                                    int index = sc.nextInt() - 1;
                                    if (index >= 0 && index < eggArrayList.size()) {
                                        Eggs egg = eggArrayList.get(index);
                                        System.out.println("Bought " + egg.getQuantity() + " eggs from " + egg.getCompany());
                                        eggArrayList.remove(index);
                                    } else {
                                        System.out.println("Invalid index.");
                                    }
                                }
                                break;
                            case 2:
                                if (milkHashSet.isEmpty()) {
                                    System.out.println("No milk available.");
                                } else {
                                    System.out.println("Available milk: ");
                                    int count = 1;
                                    for (Milk milk : milkHashSet) {
                                        System.out.println(count++ + ". " + milk);
                                    }
                                    System.out.println("Enter the index of the milk to buy:");
                                    int milkIndex = sc.nextInt() - 1;
                                    sc.nextLine();  // Consume the leftover newline character
                                    if (milkIndex >= 0 && milkIndex < milkHashSet.size()) {
                                        Milk[] milkArray = milkHashSet.toArray(new Milk[0]);
                                        Milk milk = milkArray[milkIndex];
                                        System.out.println("Bought " + milk.getQuantity() + " milk from " + milk.getCompany());
                                        milkHashSet.remove(milk);
                                    } else {
                                        System.out.println("Invalid index.");
                                    }
                                }
                                break;
                            case 3:
                                if (chocoLinkedList.isEmpty()) {
                                    System.out.println("No chocolates available.");
                                } else {
                                    System.out.println("Available chocolates: ");
                                    for (int i = 0; i < chocoLinkedList.size(); i++) {
                                        System.out.println((i + 1) + ". " + chocoLinkedList.get(i));
                                    }
                                    System.out.println("Enter the index of the chocolate to buy:");
                                    int chocoIndex = sc.nextInt() - 1;
                                    sc.nextLine();
                                    if (chocoIndex >= 0 && chocoIndex < chocoLinkedList.size()) {
                                        Chocolate chocolate = chocoLinkedList.get(chocoIndex);
                                        System.out.println("Bought " + chocolate.getQuantity() + " chocolates from " + chocolate.getCompany());
                                        chocoLinkedList.remove(chocoIndex);
                                    } else {
                                        System.out.println("Invalid index.");
                                    }
                                }
                                break;
                            case 4:
                                if (appleTree.isEmpty()) {
                                    System.out.println("No apples available.");
                                } else {
                                    System.out.println("Available apples: ");
                                    int count = 1;
                                    for (Apples apple : appleTree) {
                                        System.out.println(count++ + ". " + apple);
                                    }
                                    System.out.println("Enter the index of the apple to buy:");
                                    int appleIndex = sc.nextInt() - 1;
                                    sc.nextLine();  // Consume the leftover newline character
                                    if (appleIndex >= 0 && appleIndex < appleTree.size()) {
                                        Apples[] appleArray = appleTree.toArray(new Apples[0]);
                                        Apples apple = appleArray[appleIndex];
                                        System.out.println("Bought " + apple.getQuantity() + " apples from " + apple.getCompany());
                                        appleTree.remove(apple);
                                    } else {
                                        System.out.println("Invalid index.");
                                    }
                                }
                                break;
                            case 5:
                                if (breadQueue.isEmpty()) {
                                    System.out.println("No bread available.");
                                } else {
                                    System.out.println("Available bread: ");
                                    int count = 1;
                                    for (Bread bread : breadQueue) {
                                        System.out.println(count++ + ". " + bread);
                                    }
                                    System.out.println("Enter the index of the bread to buy:");
                                    int breadIndex = sc.nextInt() - 1;
                                    sc.nextLine();  // Consume the leftover newline character
                                    if (breadIndex >= 0 && breadIndex < breadQueue.size()) {
                                        Bread[] breadArray = breadQueue.toArray(new Bread[0]);
                                        Bread bread = breadArray[breadIndex];
                                        System.out.println("Bought " + bread.getQuantity() + " bread from " + bread.getCompany());
                                        breadQueue.remove(bread);
                                    } else {
                                        System.out.println("Invalid index.");
                                    }
                                }
                                break;
                            default:
                                System.out.println("Invalid option.");
                                break;
                        }
                    } else if (customerOption == 3) {
                        break;  // Exit customer options loop
                    } else {
                        System.out.println("Invalid option.");
                    }
                }
            } else if (opt == 3) {
                break;  // Exit the main loop
            } else {
                System.out.println("Invalid option.");
            }
        }

        sc.close();
    }
}
