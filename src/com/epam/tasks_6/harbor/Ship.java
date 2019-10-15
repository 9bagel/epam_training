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

        if (this.numOfContainers + numOfContainers > capacity) {
            System.out.printf("Cannot load so many containers the max available amount is: %s but you want to load %s for %s\n", (capacity - this.numOfContainers), numOfContainers, getName());
        } else {
            System.out.printf("(%s) - is now loading\n", this.name);
            try {
                Harbor.getBerth(numOfContainers);
                Thread.sleep(numOfContainers * 10);
                Harbor.freeBerth(numOfContainers);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.numOfContainers += numOfContainers;
            System.out.printf("Containers were successfully loaded, remaining amount is %d for %s\n", (capacity - this.numOfContainers), getName());
        }
    }


    public void unloadContainers(int numOfContainers) {
        System.out.printf("(%s) - is now unloading\n", this.name);
        if (numOfContainers > this.numOfContainers) {

            try {

                Thread.sleep(this.numOfContainers * 2);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.numOfContainers = 0;

        } else {
            try {

                Thread.sleep(numOfContainers * 2);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.numOfContainers -= numOfContainers;
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
