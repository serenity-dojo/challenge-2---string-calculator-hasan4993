package com.serenitydojo.calculator;

import com.google.common.base.Splitter;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.isNumeric;

public class Calculator {
    public int evaluate(@NotNull String expression) {
        if (expression.isEmpty()) {
            return 0;
        }
        /*Splitter Class provides various methods to handle splitting operations on string, objects
         * SplitsToList: sequence into string components and returns them as an immutable list.
         *  E.g: "4+5" it will Split it into "4" "+" "5"
         */
        List<String> signs;
        signs = Splitter.on(" ").splitToList(expression);
        int currentTotal = 0;
        String newOperator = "+";
// Here for Loop will be looking for the Sign if the Sign is gotten it will assign a new sign to the NewOperator
        for (String sign : signs) {
            if (!isNumeric(sign)) {
                newOperator = sign;
            } else {
                currentTotal = calculation(currentTotal, newOperator, sign);
            }
        }
        return currentTotal;

    }

    private int calculation(int currentTotal, @NotNull String newOperator, String sign) {
        switch (newOperator) {
            case "+":
                return currentTotal + Integer.parseInt(sign);
            case "-":
                return currentTotal - Integer.parseInt(sign);
            case "*":
                return currentTotal * Integer.parseInt(sign);
            case "/":
                return currentTotal / Integer.parseInt(sign);
            default:
                throw new ArithmeticException("Operator is Not Valid " + newOperator);
        }
    }
}
