package com.shantanu.calculator.service;

import java.util.List;
import java.util.Map;

public interface ICalculatorServices {

    public Map<String,String> handleTwoNumbers(Double num1, Double num2,char operator);

    public Map<String,String> square(Double number);

    public Map<String,String> squareRoot(Double number);

    public Map<String,String> factorialOfNumber(Double number);

    public Map<String,Integer> findMaxAndMin(List<Integer> numbers);


}
