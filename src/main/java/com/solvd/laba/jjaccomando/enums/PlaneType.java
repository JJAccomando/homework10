package com.solvd.laba.jjaccomando.enums;

public enum PlaneType {
    A380(16, 4, 90, 
    6, 410, 10, 518, "Airbus", "A380", "A"),
    A320(14, 2, 20, 
    4, 112, 7, 146, "Airbus", "A320","A"),
    B737(4, 2, 12, 
    4, 102, 6, 118, "Boeing", "737","B");

    public final int seatsInFirst;
    public final int seatsInBusiness;
    public final int seatsInEcon;
    public final int totalSeats;
    public final int numColumnsFirst;
    public final int numColumnsBusiness;
    public final int numColumnsEcon;

    public final String company;
    public final String classification;
    public final String abbreviation;

    PlaneType(int seatsInFirst, int numColumnFirst, int seatsInBusiness, int numColumnBus, 
    int seatsInEcon, int numColumnEcon, int totalSeats, String company, String classification, String abbreviation) {
        this.seatsInFirst = seatsInFirst;
        this.seatsInBusiness = seatsInBusiness;
        this.seatsInEcon = seatsInEcon;
        this.totalSeats = totalSeats;
        this.company = company;
        this.classification = classification;
        this.abbreviation = abbreviation;
        this.numColumnsFirst = numColumnFirst;
        this.numColumnsBusiness = numColumnBus;
        this.numColumnsEcon = numColumnEcon;
    }

}
