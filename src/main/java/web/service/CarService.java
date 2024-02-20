package web.service;

import org.springframework.stereotype.Service;
import web.controller.CarController;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    public List<Car> getCarList(int count) {
        if (count <= 0) {
            return null;
        } else if (count >= carList().size()) {
            return carList();
        } else {
            List<Car> countList = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                countList.add(carList().get(i));
            }
            return countList;
        }
    }

    private List<Car> carList() {

        List<Car> carList = new ArrayList<>();

        Car car1 = new Car(1L, "Mazda", 3);
        Car car2 = new Car(2L, "BMW", 5);
        Car car3 = new Car(3L, "Audi", 1);
        Car car4 = new Car(4L, "Ferrari", 2);
        Car car5 = new Car(5L, "KIA", 3);

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.add(car4);
        carList.add(car5);

        return carList;
    }
}
