package ControllersAndServices.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ControllersAndServices.service.CarService;
import ControllersAndServices.service.CarServiceImpl;
@Controller
public class CarsController {
    private final CarService carService;
@Autowired
    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "cars")
    public String cars(@RequestParam(value = "count",defaultValue = "5") int count,
                       Model model){

        model.addAttribute("list", carService.carsCount(count));
        return "cars";
    }
}
