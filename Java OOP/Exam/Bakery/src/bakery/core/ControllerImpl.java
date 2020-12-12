package bakery.core;

import bakery.core.interfaces.Controller;
import bakery.entities.bakedFoods.Bread;
import bakery.entities.bakedFoods.Cake;
import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.Tea;
import bakery.entities.drinks.Water;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.tables.InsideTable;
import bakery.entities.tables.OutsideTable;
import bakery.entities.tables.interfaces.Table;
import bakery.repositories.interfaces.*;

import java.util.List;
import java.util.stream.Collectors;

import static bakery.common.ExceptionMessages.*;
import static bakery.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private Repository<BakedFood> foodRepository;
    private Repository<Drink> drinkRepository;
    private Repository<Table> tableRepository;
    private double totalIncome;

    public ControllerImpl(FoodRepository<BakedFood> foodRepository, DrinkRepository<Drink> drinkRepository, TableRepository<Table> tableRepository) {
        this.foodRepository = foodRepository;
        this.drinkRepository = drinkRepository;
        this.tableRepository = tableRepository;
    }


    @Override
    public String addFood(String type, String name, double price) {
        BakedFood existing = this.foodRepository.getAll().stream().filter(f -> f.getName().equals(name)).findFirst().orElse(null);
        if (existing != null) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }

        BakedFood bakedFood = null;
        if (type.equals("Bread")) {
            bakedFood = new Bread(name, price);
        } else if (type.equals("Cake")) {
            bakedFood = new Cake(name, price);
        }

        this.foodRepository.add(bakedFood);
        return String.format(FOOD_ADDED, name, type);
    }

    @Override
    public String addDrink(String type, String name, int portion, String brand) {
        Drink existing = this.drinkRepository.getAll().stream().filter(d -> d.getName().equals(name)).findFirst().orElse(null);
        if (existing != null) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }
        Drink drink = null;
        if (type.equals("Tea")) {
            drink = new Tea(name, portion, brand);
        } else if (type.equals("Water")) {
            drink = new Water(name, portion, brand);
        }

        this.drinkRepository.add(drink);
        return String.format(DRINK_ADDED, name, brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        Table existing = this.tableRepository.getAll().stream().filter(t -> t.getTableNumber() == tableNumber).findFirst().orElse(null);
        if (existing != null) {
            throw new IllegalArgumentException(String.format(TABLE_EXIST, tableNumber));
        }

        Table table = null;
        if (type.equals("InsideTable")) {
            table = new InsideTable(tableNumber, capacity);
        } else if (type.equals("OutsideTable")) {
            table = new OutsideTable(tableNumber, capacity);
        }

        this.tableRepository.add(table);
        return String.format(TABLE_ADDED, tableNumber);
    }

    @Override
    public String reserveTable(int numberOfPeople) {
        Table table = this.tableRepository.getAll().stream()
                .filter(t -> !t.isReserved() && t.getCapacity() >= numberOfPeople)
                .findFirst().orElse(null);
        if (table == null) {
            return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
        } else {
            table.reserve(numberOfPeople);
            return String.format(TABLE_RESERVED, table.getTableNumber(), numberOfPeople);
        }
    }

    @Override
    public String orderFood(int tableNumber, String foodName) {
        Table table = this.tableRepository.getAll().stream().filter(t -> t.getTableNumber() == tableNumber).findFirst().orElse(null);
        if (table == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }
        BakedFood food = this.foodRepository.getAll().stream().filter(f -> f.getName().equals(foodName)).findFirst().orElse(null);
        if (food == null) {
            return String.format(NONE_EXISTENT_FOOD, foodName);
        }
        table.orderFood(food);
        return String.format(FOOD_ORDER_SUCCESSFUL, tableNumber, foodName);
    }

    @Override
    public String orderDrink(int tableNumber, String drinkName, String drinkBrand) {
        Table table = this.tableRepository.getAll().stream().filter(t -> t.getTableNumber() == tableNumber).findFirst().orElse(null);
        if (table == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }
        Drink drink = this.drinkRepository.getAll().stream().filter(d -> d.getName().equals(drinkName) && d.getBrand().equals(drinkBrand)).findFirst().orElse(null);
        if (drink == null) {
            return String.format(NON_EXISTENT_DRINK, drinkName, drinkBrand);
        }
        table.orderDrink(drink);
        return String.format(DRINK_ORDER_SUCCESSFUL, tableNumber, drinkName, drinkBrand);
    }

    @Override
    public String leaveTable(int tableNumber) {
        Table table = this.tableRepository.getAll().stream().filter(t -> t.getTableNumber() == tableNumber).findFirst().orElse(null);
        double bill = table.getBill();
        this.totalIncome += bill;
        table.clear();
        return String.format(BILL, tableNumber, bill);
    }

    @Override
    public String getFreeTablesInfo() {
        List<Table> freeTables = this.tableRepository.getAll().stream().filter(t -> !t.isReserved()).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        for (Table freeTable : freeTables) {
            sb.append(freeTable.getFreeTableInfo()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    @Override
    public String getTotalIncome() {
        return String.format(TOTAL_INCOME, totalIncome);
    }
}
