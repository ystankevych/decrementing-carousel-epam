package com.epam.rd.autotasks;

public class DecrementingCarousel {
    CarouselRun carouselRun;
    private int[] carouselArray;
    private int index;

    public DecrementingCarousel(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity is negative");
        }
        carouselArray = new int[capacity];
        index = -1;
    }

    public boolean addElement(int element) {
        if (element > 0 && !isRun() && !isFull()) {
            carouselArray[++index] = element;
            return true;
        }
        return false;
    }

    public CarouselRun run() {
        if (!isRun()) {
            carouselRun = new CarouselRun(this);
            return carouselRun;
        }
        return null;
    }

    private boolean isRun() {
        return carouselRun != null;
    }

    private boolean isFull() {
        return index == carouselArray.length - 1;
    }

    public int[] getCarouselArray() {
        return carouselArray;
    }

    public int getIndex() {
        return index;
    }
}
