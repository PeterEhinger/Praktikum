package edu.unibw.se.gdp.praktikum01;

public class Zeichenketten {
    public static void main(String[] args) {
        String a = "Andrea Baumann";
        String b = "Andrea" + " " + "Baumann";
        String c = "Andrea".concat(" ").concat("Baumann");

        int d = a.length();

        String e = " ";

        String f = a.substring(0,6);

        String g = "\uD834\uDD1E";

        char h = a.charAt(3);
        boolean i = (a.charAt(3) == b.charAt(2));

        //more
        String completeString = "Radiergummi";
        String partString1 = completeString.substring(0,6);
        String partString2 = completeString.substring(6);
        String fullString = partString1 + partString2;

        System.out.println(fullString);

    }
}
