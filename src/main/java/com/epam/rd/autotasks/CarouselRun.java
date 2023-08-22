package com.epam.rd.autotasks;

public class CarouselRun {
    DecrementingCarousel decrementingCarousel;
    private int currentIndex;

    public CarouselRun(DecrementingCarousel decrementingCarousel) {
        this.decrementingCarousel = decrementingCarousel;
        currentIndex = -1;
    }

    public int next() {
        int next = -1;
        if (!isFinished()) {
            next = decrementingCarousel.getCarouselArray()[indexNextPositive()]--;
        }
        return next;
    }

    public boolean isFinished() {
        for (int i = 0; i <= decrementingCarousel.getIndex(); i++) {
            if (decrementingCarousel.getCarouselArray()[i] > 0) {
                return false;
            }
        }
        return true;
    }

    private int indexNextPositive() {
        while (true) {
            if (currentIndex >= decrementingCarousel.getIndex()) {
                currentIndex = -1;
            }
            if (decrementingCarousel.getCarouselArray()[++currentIndex] > 0) {
                return currentIndex;
            }
        }
    }
}
