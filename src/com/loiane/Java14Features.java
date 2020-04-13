package com.loiane;

import java.util.ArrayList;

public class Java14Features {

    private enum DAY_OF_WEEK { MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY};

    public static void main(String[] args) {
        patternMatchingPreview();
        recordsPreview();

        enhancedSwitchCase(DAY_OF_WEEK.FRIDAY);
        switchJava14(DAY_OF_WEEK.SATURDAY);

        textBlocks();

        // need to add as parameter: -XX:+ShowCodeDetailsInExceptionMessages
        // helpfulNullPointerExceptions();
    }

    private static void patternMatchingPreview() {
        var person1 = new Person("Mary", 25);
        var person2 = new Person("John", 26);
        System.out.println(person1.equals(person2));
    }

    private static void helpfulNullPointerExceptions(){
        String[][] matrix = new String[5][5];
        matrix[1] = new String[5];

        if (matrix[1][0].toUpperCase().equals("S")) {

        }
    }

    private static void recordsPreview() {

        var product = new Product("Coffee", 10, 1.5);
        System.out.println(Product.count());

        var list = new ArrayList<>();
        list.add(new Product("Phone", 5, 1000));
        System.out.println(list);

        // "record" is not not keyword yet
        int record = 0;
    }

    private static String switchJava14(DAY_OF_WEEK dayOfWeek) {
        return switch (dayOfWeek) {
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
                yield "Weekday";
            case SATURDAY:
            case SUNDAY:
                yield "Weekend";
        };
    }

    private static String enhancedSwitchCase(DAY_OF_WEEK dayOfWeek) {
        return switch (dayOfWeek) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> "Weekday";
            case SATURDAY, SUNDAY -> "Weekend";
        };
    }

    private static void textBlocks() {

        String beforeQuery = "update products\n" +
                             "    set quantityInStock = ?\n" +
                             "    ,modifiedDate = ?\n" +
                             "    ,modifiedBy = ?\n" +
                             "where productCode = ?\n";

        String updateQuery = """
                update products
                    set quantityInStock = ?
                    ,modifiedDate = ?
                    ,modifiedBy = ?
                where productCode = ?
                """;
        System.out.println(updateQuery);
        System.out.println(".");

        // new in Java 14
        String updateQuery2 = """
                update products \
                    set quantityInStock = ?
                    ,modifiedDate = ?
                    ,modifiedBy = ?  \s
                where productCode = ?
                """;
        System.out.println(updateQuery2);
                System.out.println(".");        
    }
}
