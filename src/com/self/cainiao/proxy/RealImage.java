package com.self.cainiao.proxy;

public class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        LoadFromDisk(fileName);
    }
    private void LoadFromDisk(String fileName) {
        System.out.println("Loading" + fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }
}
