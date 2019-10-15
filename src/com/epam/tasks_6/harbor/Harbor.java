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

    public void addShipForLoading(Ship ship, int containersNum) {
        Thread thread = new Thread(ship) {
            @Override
            public void run() {
                while (shipsInHarbor + 1 > berthCount || containersInHarbor + containersNum > capacity) {
                    System.out.printf("(%s) - All berth are busy or not enough capacity left. We will try again in 10 sec \n", ship.getName());
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                getBerth(containersNum);
                ship.loadContainers(containersNum);
                freeBerth(containersNum);
            }
        };
        thread.start();
    }

    public void addShipForUnloading(Ship ship, int containersNum) {
        Thread thread = new Thread(ship) {
            @Override
            public void run() {
                while (shipsInHarbor + 1 > berthCount || containersInHarbor + containersNum > capacity) {
                    System.out.printf("(%s) - All berth are busy or not enough capacity left. We will try again in 10 sec \n", ship.getName());
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                getBerth(containersNum);
                ship.unloadContainers(containersNum);
                freeBerth(containersNum);
                System.out.printf("containers were unload for %s\n", ship.getName());
            }
        };
        thread.start();

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
