package edu.unibw.se.gdp.Praktikum07;

public class DLLInt {
    public DLLInt prev;
    public int value;
    public DLLInt next;

    public DLLInt(DLLInt prev, int value, DLLInt next) {
        this.prev = prev;
        this.value = value;
        this.next = next;
    }
}
