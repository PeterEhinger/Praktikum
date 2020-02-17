package edu.unibw.se.gdp.praktikum06;

public class SLLInt {
    public int value;
    public SLLInt next;

    // SLLInt: Single Linked List (Element)
    // Wert im aktuellen Element
    // Referenz auf den Rest der Liste
    public SLLInt(int value, SLLInt next) {
        this.value = value;
        this.next = next;
    }

    public SLLInt(int value) {
        this.value = value;
        next = null;
    }
}
