package com.epam.programming_with_classes.agregation_and_composition.travel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

/*
Туристические путевки. Сформировать набор предложений клиенту по выбору туристической путевки
различного типа (отдых, экскурсии, лечение, шопинг, круиз и т. д.) для оптимального выбора. Учитывать
возможность выбора транспорта, питания и числа дней. Реализовать выбор и сортировку путевок.
 */
public class VacationHelper {
    private ArrayList<Vacation> vacations = new ArrayList<>();

    void addVacation(Vacation vacation) {
        vacations.add(vacation);
    }

    ArrayList<Vacation> getVacations() {
        return vacations;
    }

    ArrayList<Vacation> getVacationsByType(VacationType vacationType) {
        return vacations.stream()
                .filter(vacation -> vacation.getVacationType().equals(vacationType))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    ArrayList<Vacation> getVacationsByTransport(String transportType) {
        return vacations.stream()
                .filter(vacation -> vacation.getTransportType().equals(transportType))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    ArrayList<Vacation> getVacationsByNumberOfDays(int numberOfDays) {
        return vacations.stream()
                .filter(vacation -> vacation.getNumberOfDays() == numberOfDays)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    void sortVacationsByCountry() {
        vacations.sort(Comparator.comparing(Vacation::getCountry));
    }

    void printAllVacations() {
        vacations.forEach(System.out::println);
    }
}
