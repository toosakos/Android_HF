package com.example.hf06;

public class Currency {
    private String code;
    private String name;
    private double buyRate;
    private double sellRate;
    private int flagResId;

    public Currency(String code, String name, double buyRate, double sellRate, int flagResId) {
        this.code = code;
        this.name = name;
        this.buyRate = buyRate;
        this.sellRate = sellRate;
        this.flagResId = flagResId;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public double getBuyRate() { return buyRate; }
    public double getSellRate() { return sellRate; }
    public int getFlagResId() { return flagResId; }
}
