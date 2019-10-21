package com.self.cainiao.command;

public class SellStock implements Order {
    private Stock stock;

    @Override
    public void excute() {
        stock.sell();
    }
    public SellStock(Stock stock) {
        this.stock = stock;
    }
}
