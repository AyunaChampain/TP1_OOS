package com.example.TP1.OOS;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Dates {

    @Column(name = "date_begin")
    private String begin;

    @Column(name = "date_end")
    private String end;

    public Dates() {}

    public Dates(String begin, String end) {
        this.begin = begin;
        this.end = end;
    }

    public String getBegin() { return begin; }
    public void setBegin(String begin) { this.begin = begin; }

    public String getEnd() { return end; }
    public void setEnd(String end) { this.end = end; }
}