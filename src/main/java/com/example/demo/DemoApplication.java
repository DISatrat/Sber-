package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws IOException {




        String file2 = "src/main/java/com/example/demo/city_ru1.csv";
        Path path2 = Paths.get(file2);
        Scanner scanner1 = new Scanner(path2);

        //вывод всех городов

//        while(scanner1.hasNext()){
//
//            City city=CreateCity(scanner1.nextLine());
//            System.out.println(city.toString());
//
//        }

        // сортировка гордов в алфавитном порядке

//        ArrayList<City> cities=new ArrayList<>();
//        while(scanner1.hasNext()){
//
//        City city=CreateCity(scanner1.nextLine());
//        cities.add(city);
//
//        }
//
//        cities.sort(Comparator.comparing(City::getName));
//        for (int i = 0; i < cities.size(); i++) {
//            System.out.println(cities.get(i));
//        }

        // сортировка городов по округу и имени

//        ArrayList<City>cities2=new ArrayList<>();
//        while (scanner1.hasNext()){
//            City city=CreateCity(scanner1.nextLine());
//            cities2.add(city);
//        }
//        cities2.sort(Comparator.comparing(City::getDistrict).thenComparing(City::getName));
//
//
//        for (int i = 0; i < cities2.size(); i++) {
//            System.out.println(cities2.get(i));
//        }

        //максимальное число жителей

        ArrayList<City>cities2=new ArrayList<>();
        while (scanner1.hasNext()){
            City city=CreateCity(scanner1.nextLine());
            cities2.add(city);
        }

        int max=0;
        int maxId=0;

        for (int i = 0; i < cities2.size(); i++) {
            int pop=Integer.parseInt(cities2.get(i).population);
            if(pop>max){
            max=pop;
                maxId=Integer.parseInt(cities2.get(i).id)-1;
            }


        }
        System.out.println("["+maxId+"]"+" = "+max);


        SpringApplication.run(DemoApplication .class,args);
}

    private static City CreateCity(String line) {

        String[] ArrayLines;
        ArrayLines = line.split(";");

        String id=ArrayLines[0];

        String name = ArrayLines[1];
        String region = ArrayLines[2];
        String district = ArrayLines[3];
        String population = ArrayLines[4];
        String foundation = "неизвестно";
        if (ArrayLines.length == 6) {
            foundation = ArrayLines[5];
        }

        return new City(id,name,region,district,population,foundation);
    }
    public static void PopulousCity() throws IOException {

        String file2 = "src/main/java/com/example/demo/city_ru1.csv";
        Path path2 = Paths.get(file2);
        Scanner scanner1 = new Scanner(path2);
        String[] Cities;
        while(scanner1.hasNext()){

        }

//        int max=0;
//
//        while (scanner1.hasNext()){
//            String line2=scanner1.nextLine();
//            String[]lines;
//            lines=line2.split(";");
//
//            int pop=Integer.parseInt(lines[4]);
//
//            if(pop>max){
//                max=pop;
//                System.out.println("["+id+"]"+" = "+max);
//            }
//
//        }
    }

    public static class City extends ArrayList<City> {
        private String id;
        private String name;
        private String region;
        private String district;
        private String population;
        private String foundation;

        private City(String id,String name, String region, String district, String population, String foundation) {
            this.id=id;
            this.name = name;
            this.region = region;
            this.district = district;
            this.population = population;
            this.foundation = foundation;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public String getPopulation() {
            return population;
        }

        public void setPopulation(String population) {
            this.population = population;
        }

        public String getFoundation() {
            return foundation;
        }

        public void setFoundation(String foundation) {
            this.foundation = foundation;
        }

        @Override
        public String toString() {
            //return "City{name='" + this.name + "', region='" + this.region + "', district='" + this.district + "', population=" + this.population + ", foundation='" + this.foundation + "'}";
            return this.id+" "+this.name+" "+this.region+" "+this.district+" "+this.population+" "+this.foundation;
        }
    }
}
