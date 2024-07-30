package com.iiht.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.*;

@Configuration
public class App {

    @Bean
    public Eggs egg1() {
        return new Eggs(12, "HappyFarm", 715);
    }

    @Bean
    public Eggs egg2() {
        return new Eggs(24, "FarmFresh", 21);
    }

    @Bean
    public Apples apple1() {
        return new Apples(20, "GreenAppleCo", 10);
    }

    @Bean
    public Apples apple2() {
        return new Apples(30, "RedAppleCo", 5);
    }

    @Bean
    public Milk milk1() {
        return new Milk(10, "DairyDelight", 25);
    }

    @Bean
    public Milk milk2() {
        return new Milk(15, "PureMilk", 20);
    }

    @Bean
    public Chocolate chocolate1() {
        return new Chocolate(50, "SweetTreats", 30);
    }

    @Bean
    public Chocolate chocolate2() {
        return new Chocolate(40, "ChocoDelights", 25);
    }

    @Bean
    public Bread bread1() {
        return new Bread(15, "BreadBakery", 720);
    }

    @Bean
    public Bread bread2() {
        return new Bread(10, "DailyBread", 805);
    }

    @Bean
    public ArrayList<Eggs> eggArrayList() {
        return new ArrayList<>(Arrays.asList(egg1(), egg2()));
    }

    @Bean
    public HashSet<Milk> milkHashSet() {
        return new HashSet<>(Arrays.asList(milk1(), milk2()));
    }

    @Bean
    public LinkedList<Chocolate> chocoLinkedList() {
        return new LinkedList<>(Arrays.asList(chocolate1(), chocolate2()));
    }

    @Bean
    public TreeSet<Apples> appleTree() {
        TreeSet<Apples> apples = new TreeSet<>();
        apples.add(apple1());
        apples.add(apple2());
        return apples;
    }

    @Bean
    public Queue<Bread> breadQueue() {
        return new LinkedList<>(Arrays.asList(bread1(), bread2()));
    }

    @Bean
    public HashMap<Integer, Collection<?>> storeMap() {
        HashMap<Integer, Collection<?>> map = new HashMap<>();
        map.put(1, eggArrayList());
        map.put(2, milkHashSet());
        map.put(3, chocoLinkedList());
        map.put(4, appleTree());
        map.put(5, breadQueue());
        return map;
    }
}
