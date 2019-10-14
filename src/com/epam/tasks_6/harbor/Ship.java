package com.epam.tasks_6.harbor;

public class Ship implements Runnable {
    private int capacity;
    private String name;
    private int numOfContainers;
    private boolean onLoad;

    public Ship(int capacity, String name, int numOfContainers, boolean onLoad) {
        if (capacity <= 0 || numOfContainers < 0) {
            throw new IllegalArgumentException("Capacity cannot be less or equals to 0 and number of containers cannot be less then 0");
        }

        if (numOfContainers > capacity) {
            throw new IllegalArgumentException("Ship cannot carry so many containers. The maximum amount is " + capacity);
        }

        this.capacity = capacity;
        this.name = name;
        this.numOfContainers = numOfContainers;
        this.onLoad = onLoad;
        run();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfContainers() {
        return numOfContainers;
    }

    public void setNumOfContainers(int numOfContainers) {
        this.numOfContainers = numOfContainers;
    }

    public void loadContainers(int numOfContainers) {

        if (Ship.this.getNumOfContainers() + numOfContainers > capacity) {
            System.out.printf("Cannot load so many containers the max available amount is: %s but you want to load %s for %s\n", (capacity - Ship.this.numOfContainers), numOfContainers, getName());
        } else {
            try {
                Harbor.getBerth(numOfContainers);
                Thread.sleep(numOfContainers * 10);
                Harbor.freeBerth(numOfContainers);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Ship.this.numOfContainers += numOfContainers;
            System.out.printf("Containers were successfully loaded, remaining amount is %d for %s\n", (capacity - Ship.this.numOfContainers), getName());
        }
    }


    public void unloadContainers(int numOfContainers) {
        int amount = 0;

        if (numOfContainers > Ship.this.numOfContainers) {

            try {

                Harbor.getBerth(Ship.this.numOfContainers);
                Thread.sleep(Ship.this.numOfContainers * 2);
                Harbor.freeBerth(Ship.this.numOfContainers);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            amount = Ship.this.numOfContainers;
            Ship.this.numOfContainers = 0;

        } else {
            try {
                Harbor.getBerth(numOfContainers);
                Thread.sleep(numOfContainers * 2);
                Harbor.freeBerth(numOfContainers);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Ship.this.numOfContainers -= numOfContainers;
            amount = numOfContainers;
        }
    }


    @Override
    public void run() {
        System.out.printf("The ship %s is on his way to harbor\n", getName());

        if (onLoad) {
            loadContainers(numOfContainers);
        } else unloadContainers(numOfContainers);
    }
}
