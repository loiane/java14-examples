package com.loiane;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public record Product(
        @NotNull String name,
        int quantity,
        @Min(1) double price)
        implements Comparable<Product> {

    private static int COUNT = 0;

    public Product {
        if (quantity < 1) {
            throw new IllegalArgumentException("Product needs to have at least 1 quantity");
        }
        COUNT++;
    }

    static int count() {
        return COUNT;
    }

    @Override
    public int compareTo(Product o) {
        return 0;
    }
}
