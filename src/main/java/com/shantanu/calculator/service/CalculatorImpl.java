package com.shantanu.calculator.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CalculatorImpl implements ICalculatorServices {

    @Override
    public Map<String, String> handleTwoNumbers(Double num1, Double num2, char operator) {
        Double result = 0.0d;
        switch (operator){
            case '+':
                result=num1 + num2;
                break;
            case '-':
                result=num1-num2;
                break;
            case '*':
                result=num1*num2;
                break;
            case '/':
                result=num1/num2;
                break;
            default:
        }
        Double finalResult = result;
        return new HashMap<>() {{
            put("answer", String.format("%.2f", finalResult));
            put("detail", String.format("%s %c %s = %s", String.valueOf(num1), operator,String.valueOf(num2), String.format("%.2f", finalResult)));
        }};
    }

    @Override
    public Map<String, String> square(Double number) {
        return new HashMap<>() {{
            put("answer", String.format("%d",number*number));
            put("detail", String.format("Square of %d is = %d", number, number*number));
        }};
    }

    @Override
    public Map<String, String> squareRoot(Double number) {
        return new HashMap<>() {{
            put("answer", String.format("%1$,.2f", Math.sqrt(number)));
            put("detail", String.format("Square root of %1$,.2f is = %2$,.2f ", number, Math.sqrt(number)));
        }};
    }

    @Override
    public Map<String, String> factorialOfNumber(Double number) {
        int result = 1;
        for (int i = 1; i <= number.intValue(); i++) {
            result = result * i;
        };
        int finalResult = result;
        return new HashMap<>() {{
            put("answer", String.valueOf(finalResult));
            put("detail", String.format("Factorial of %d is = %d", number, finalResult));
        }};
    }

    @Override
    public Map<String, Integer> findMaxAndMin(List<Integer> numbers) {
        return new HashMap<>() {{
            put("Max", numbers.stream().max(Integer::compareTo).get());
            put("Min", numbers.stream().min(Integer::compareTo).get());
        }};
    }
}
