package ua.goit.java.spring.mvc.Controllers;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.spring.mvc.dao.DishDao;
import ua.goit.java.spring.mvc.model.Dish;
import ua.goit.java.spring.mvc.model.DishCategory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Daniel Solo on 15.09.2016.
 */
public class DishController {

    private DishDao dishDao;

    @Transactional
    public void createDish(){
        Dish risotto = new Dish();
        risotto.setName("Risotto");
        risotto.setCategory(DishCategory.MAIN);
        risotto.setPrice(4.99F);
        risotto.setWeight(300F);

        Dish carbonara = new Dish();
        carbonara.setName("Carbonara");
        carbonara.setCategory(DishCategory.SIDE_DISH);
        carbonara.setPrice(6.50F);
        carbonara.setWeight(400F);

        Dish mushroomSoup = new Dish();
        mushroomSoup.setName("Mushroom Soup");
        mushroomSoup.setCategory(DishCategory.SOUP);
        mushroomSoup.setPrice(1.99F);
        mushroomSoup.setWeight(350F);

        Dish panacotta = new Dish();
        panacotta.setName("Panacotta");
        panacotta.setCategory(DishCategory.DESSERT);
        panacotta.setPrice(2.99F);
        panacotta.setWeight(150F);

        Set<Dish> dishes = new HashSet<>(dishDao.findAllDishes());
        if (!dishes.contains(risotto)) {
            dishDao.save(risotto);
        }
        if (!dishes.contains(carbonara)) {
            dishDao.save(carbonara);
        }
        if (!dishes.contains(mushroomSoup)) {
            dishDao.save(mushroomSoup);
        }
        if (!dishes.contains(panacotta)) {
            dishDao.save(panacotta);
        }

    }

    @Transactional
    public List<Dish> getAllDishes(){
        return dishDao.findAllDishes();
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }
}
