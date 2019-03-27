package parking_lot;

class Assistant {
    private Display display;

    Assistant(Display display) {
        this.display = display;
    }

    void updateDisplay(String name, int noOfCars) {
        display.update(name, noOfCars);
    }
}
