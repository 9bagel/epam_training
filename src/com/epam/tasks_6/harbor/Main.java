package com.epam.tasks_6.harbor;
/*
Задание 4. Многопоточность. Порт . Корабли заходят в порт для разгрузки/загрузки контейнеров.
Число контейнеров, находящихся в текущий момент в порту и на корабле, должно быть неотрицательным и превышающим заданную
 грузоподъемность судна и вместимость порта.
В порту работает несколько причалов. У одного причала может стоять один корабль. Корабль может загружаться у причала
или разгружаться.

 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Harbor harbor = new Harbor(10000, 1);

        Ship ship1 = new Ship(1000, "ship1", 800,true);
        Ship ship2 = new Ship(3000, "ship2", 2000, true);
        Ship ship3 = new Ship(4000, "ship3", 3000,false);
        Ship ship4 = new Ship(3000, "ship4", 2500,true);
        Ship ship5 = new Ship(2000, "ship5", 1500,false);
        Ship ship6 = new Ship(1000, "ship6", 800,false);
        Ship ship7 = new Ship(8000, "ship7", 8000,true);

        //harbor.addShipForLoading(ship1, 200);
        //harbor.addShipForLoading(ship2, 800);
        //harbor.addShipForLoading(ship3, 1000);
        //harbor.addShipForLoading(ship4, 600);
//
        //harbor.addShipForUnloading(ship5, 1000);
        //harbor.addShipForUnloading(ship6, 500);
        //harbor.addShipForUnloading(ship7, 9000);
    }
}
