package onlineShop.models.products.computers;

import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;

import static onlineShop.common.constants.ExceptionMessages.*;
import static onlineShop.common.constants.OutputMessages.*;

public abstract class BaseComputer extends BaseProduct implements Computer {
    private List<Component> components;
    private List<Peripheral> peripherals;

    protected BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    @Override
    public double getOverallPerformance() {
        double averageComponentPerformance = this.components.stream()
                .mapToDouble(Component::getOverallPerformance)
                .average()
                .orElse(0);

        return super.getOverallPerformance() + averageComponentPerformance;
    }

    @Override
    public double getPrice() {
        double totalComponentPrice = components.stream()
                .mapToDouble(Component::getPrice)
                .sum();

        double totalPeripheralPrice = peripherals.stream()
                .mapToDouble(Peripheral::getPrice)
                .sum();

        return super.getPrice() + totalComponentPrice + totalPeripheralPrice;
    }

    @Override
    public List<Component> getComponents() {
        return this.components;
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return this.peripherals;
    }

    @Override
    public void addComponent(Component component) {
        if (this.components.stream()
                .anyMatch(c -> c.getClass().getSimpleName().equals(component.getClass().getSimpleName()))) {
            throw new IllegalArgumentException(String.format(EXISTING_COMPONENT, component.getClass().getSimpleName(),
                    this.getClass().getSimpleName(), this.getId()));
        }
        this.components.add(component);
    }

    @Override
    public Component removeComponent(String componentType) {
        if (this.components.stream()
                .noneMatch(c -> c.getClass().getSimpleName().equals(componentType))) {
            throw new IllegalArgumentException(String.format(NOT_EXISTING_COMPONENT, componentType,
                    this.getClass().getSimpleName(), this.getId()));
        }

        int index = 0;
        for (int i = 0; i < components.size(); i++) {
            if (components.get(i).getClass().getSimpleName().equals(componentType)) {
                index = i;
                break;
            }
        }
        return components.remove(index);
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {
        if (this.peripherals.stream()
                .anyMatch(p -> p.getClass().getSimpleName().equals(peripheral.getClass().getSimpleName()))) {
            throw new IllegalArgumentException(String.format(EXISTING_PERIPHERAL, peripheral.getClass().getSimpleName(),
                    this.getClass().getSimpleName(), this.getId()));
        }
        this.peripherals.add(peripheral);
    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {
        if (this.peripherals.stream()
                .noneMatch(p -> p.getClass().getSimpleName().equals(peripheralType))) {
            throw new IllegalArgumentException(String.format(NOT_EXISTING_PERIPHERAL, peripheralType,
                    this.getClass().getSimpleName(), this.getId()));
        }

        int index = 0;
        for (int i = 0; i < peripherals.size(); i++) {
            if (peripherals.get(i).getClass().getSimpleName().equals(peripheralType)) {
                index = i;
                break;
            }
        }
        return peripherals.remove(index);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString()).append(System.lineSeparator());
        builder.append(" ").append(String.format(COMPUTER_COMPONENTS_TO_STRING, this.components.size()))
        .append(System.lineSeparator());

        for (Component component : components) {
            builder.append(component.toString()).append(System.lineSeparator());
        }

        builder.append(" ").append(String.format(COMPUTER_PERIPHERALS_TO_STRING, this.peripherals.size()
                , this.peripherals.stream()
        .mapToDouble(Peripheral::getOverallPerformance).average().orElse(0)))
        .append(System.lineSeparator());

        for (Peripheral peripheral : peripherals) {
            builder.append(peripherals.toString()).append(System.lineSeparator());
        }

        return builder.toString().trim();
    }
}
