package com.epam.tasks_6.harbor;

public class Harbor {
    private int capacity;
    private int berthCount;
    private static volatile int shipsInHarbor;
    private static volatile int containersInHarbor;

    public Harbor(int capacity, int berthCount) {
        if (capacity <= 0 || berthCount <= 0) {
            throw new IllegalArgumentException("Capacity or berth count cannot be less or equals to 0");
        }

        this.capacity = capacity;
        this.berthCount = berthCount;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getBerthCount() {
        return berthCount;
    }

    public void setBerthCount(int berthCount) {
        this.berthCount = berthCount;
    }

    public void addShipForLoading(Ship ship, int containersNum) throws InterruptedException {

        while (shipsInHarbor + 1 > berthCount || containersInHarbor + containersNum > capacity) {
            System.out.printf("Message for ship %s\n", ship.getName());
            System.out.println("All berth are busy or not enough capacity left. We will try again in 10 sec");
            Thread.sleep(10000);
        }

        ship.loadContainers(containersNum);
    }

    public void addShipForUnloading(Ship ship, int containersNum) throws InterruptedException {

        while (shipsInHarbor + 1 > berthCount || containersInHarbor + containersNum > capacity) {
            System.out.printf("Message for ship %s\n", ship.getName());
            System.out.println("All berth are busy or not enough capacity left. We will try again in 10 sec");
            Thread.sleep(10000);
        }

        ship.unloadContainers(containersNum);

        System.out.printf("containers were unload for %s\n", ship.getName());

    }

    public static synchronized void getBerth(int containersNum) {
        containersInHarbor += containersNum;
        shipsInHarbor++;
    }

    public static synchronized void freeBerth(int containersNum) {
        containersInHarbor -= containersNum;
        shipsInHarbor--;
    }
}
