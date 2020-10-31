package GreedyTimes;

import java.util.HashMap;
import java.util.Map;

public class Bag {
    private long totalGold;
    private long totalGems;
    Map<String, Long> gems;
    private long totalCash;
    Map<String, Long> cash;
    private long capacity;

    public Bag(long capacity) {
        this.capacity = capacity;
        this.totalGold = 0;
        this.totalGems = 0;
        this.totalCash = 0;
        this.gems = new HashMap<>();
        this.cash = new HashMap<>();
    }

    public void addCash(String cash, long quantity) {
        if (isEnoughCapacity(quantity)) {
            if (this.totalCash + quantity <= this.totalGems) {
                this.totalCash += quantity;
                if (this.cash.containsKey(cash)) {
                    this.cash.put(cash, this.cash.get(cash) + quantity);
                } else {
                    this.cash.put(cash, quantity);
                }
            }
        }
    }

    public void addGem(String gem, long quantity) {
        if (isEnoughCapacity(quantity)) {
            if (this.totalGems + quantity <= this.totalGold) {
                this.totalGems += quantity;
                if (this.gems.containsKey(gem)) {
                    this.gems.put(gem, this.gems.get(gem) + quantity);
                } else {
                    this.gems.put(gem, quantity);
                }
            }
        }
    }

    boolean isGoldAdded = false;

    public void addGold(long quantity) {
        if (isEnoughCapacity(quantity)) {
            this.totalGold += quantity;
            isGoldAdded = true;
        }
    }

    private boolean isEnoughCapacity(long quantity) {
        return this.totalCash + this.totalGems + this.totalGold + quantity <= this.capacity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (isGoldAdded) {
            sb.append(String.format("<Gold> $%d", this.totalGold)).append(System.lineSeparator())
                    .append(String.format("##Gold - %d", this.totalGold)).append(System.lineSeparator());

        }

        if (this.gems.size() > 0) {
            sb.append(String.format("<Gem> $%d", this.totalGems)).append(System.lineSeparator());
            this.gems.entrySet().stream()
                    .sorted((f, s) -> {
                        int result = s.getKey().compareTo(f.getKey());
                        if (result == 0) {
                            result = f.getValue().compareTo(s.getValue());
                        }
                        return result;
                    })
                    .forEach(entry -> {
                        sb.append(String.format("##%s - %d", entry.getKey(), entry.getValue())).append(System.lineSeparator());
                    });
        }

        if (this.cash.size() > 0) {
            sb.append(String.format("<Cash> $%d", this.totalCash)).append(System.lineSeparator());
            this.cash.entrySet().stream()
                    .sorted((f, s) -> {
                        int result = s.getKey().compareTo(f.getKey());
                        if (result == 0) {
                            result = f.getValue().compareTo(s.getValue());
                        }
                        return result;
                    })
                    .forEach(entry -> {
                        sb.append(String.format("##%s - %d", entry.getKey(), entry.getValue())).append(System.lineSeparator());
                    });
        }

        return sb.toString().trim();
    }
}
