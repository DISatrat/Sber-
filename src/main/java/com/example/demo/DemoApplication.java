package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws IOException {

        String file2="src/main/java/com/example/demo/city_ru1.csv";
        Path path2= Paths.get(file2);

        Scanner scanner1=new Scanner(path2);

        while(scanner1.hasNext()){

            City city=CreateCity(scanner1.nextLine());
            System.out.println(city.toString());

        }

        SpringApplication.run(DemoApplication.class, args);
    }
    private static City CreateCity( String line) {

        String[] ArrayLines;
        ArrayLines = line.split(";");

        String name = ArrayLines[1];
        String region = ArrayLines[2];
        String district = ArrayLines[3];
        String population = ArrayLines[4];
        String foundation ="неизвестно";
        if(ArrayLines.length==6) {foundation=ArrayLines[5];}

        DemoApplication jfs = new DemoApplication();

        return jfs.new City(name,region,district,population,foundation);
    }
    public class City {
        private String name;
        private String region;
        private String district;
        private String population;
        private String foundation;

        private City(String name, String region, String district, String population, String foundation) {
            this.name = name;
            this.region = region;
            this.district = district;
            this.population = population;
            this.foundation = foundation;
        }

        @Override
        public String toString(){
            return "City{name='"+this.name+"', region='"+this.region+"', district='"+this.district+"', population="+this.population+", foundation='"+this.foundation+"'}";

        }
    }


}
