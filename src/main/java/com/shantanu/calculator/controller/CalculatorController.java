package com.shantanu.calculator.controller;

import com.shantanu.calculator.models.ResponsePayload;
import com.shantanu.calculator.service.CalculatorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/calculatorapi/v1/")
public class CalculatorController {

    @Autowired
    private CalculatorImpl calImpl;


    @GetMapping("{operation}")
    public ResponseEntity<ResponsePayload> operationBasedCalculation(@PathVariable("operation") String operation, @RequestParam(name = "number1", required = false) Double number1, @RequestParam(required = false, name = "number2") Double number2) {
        ResponsePayload responsePayload = null;
        Map<String, String> result = new HashMap<>();
        if (number1 != null && number2 != null) {
            switch (operation) {
                case "addition":
                    result = calImpl.handleTwoNumbers(number1, number2, '+');
                    break;
                case "subtraction":
                    result = calImpl.handleTwoNumbers(number1, number2, '-');
                    break;
                case "multiplication":
                    result = calImpl.handleTwoNumbers(number1, number2, '*');
                    break;
                case "division":
                    result = calImpl.handleTwoNumbers(number1, number2, '/');
                    break;
                default:

            }
            responsePayload = new ResponsePayload(result, null, null, HttpStatus.OK);
        } else
            responsePayload = new ResponsePayload(new HashMap<>() {{
                put("error", "No Number Entered");
            }}, null, null, HttpStatus.NOT_ACCEPTABLE);

        return new ResponseEntity<>(responsePayload, responsePayload.getHttpStatus());
    }

    @GetMapping("square/{number}")
    public ResponseEntity<ResponsePayload> square(@PathVariable(name = "number", required = false) Double number) {
        ResponsePayload responsePayload = null;
        if (number != null)
            responsePayload = new ResponsePayload(calImpl.square(number), null, null, HttpStatus.OK);
        else
            responsePayload = new ResponsePayload(new HashMap<>() {{
                put("error", "No Number Entered");
            }}, null, null, HttpStatus.NOT_ACCEPTABLE);

        return new ResponseEntity<>(responsePayload, responsePayload.getHttpStatus());
    }

    @GetMapping("squareroot/{number}")
    public ResponseEntity<ResponsePayload> squareRoot(@PathVariable(name = "number", required = false) Double number) {
        ResponsePayload responsePayload = null;
        if (number != null)
            responsePayload = new ResponsePayload(calImpl.squareRoot(number), null, null, HttpStatus.OK);
        else
            responsePayload = new ResponsePayload(new HashMap<>() {{
                put("error", "No Number Entered");
            }}, null, null, HttpStatus.NOT_ACCEPTABLE);

        return new ResponseEntity<>(responsePayload, responsePayload.getHttpStatus());
    }

    @GetMapping("factorial/{number}")
    public ResponseEntity<ResponsePayload> factorialOfNumber(@PathVariable(name = "number", required = false) Double number) {
        ResponsePayload responsePayload = null;
        if (number != null)
            responsePayload = new ResponsePayload(calImpl.factorialOfNumber(number), null, null, HttpStatus.OK);
        else
            responsePayload = new ResponsePayload(new HashMap<>() {{
                put("error", "No Number Entered");
            }}, null, null, HttpStatus.NOT_ACCEPTABLE);

        return new ResponseEntity<>(responsePayload, responsePayload.getHttpStatus());
    }

    @GetMapping("min-max")
    public ResponseEntity<ResponsePayload> minAndMaxNumbers(@RequestBody Map<String, List<Integer>> request){
        ResponsePayload responsePayload = null;
        if (request.get("numbers") != null && !request.get("numbers").isEmpty())
            responsePayload = new ResponsePayload(calImpl.findMaxAndMin(request.get("numbers")), null, null, HttpStatus.OK);
        else
            responsePayload = new ResponsePayload(new HashMap<>() {{
                put("error", "No Number Entered");
            }}, null, null, HttpStatus.NOT_ACCEPTABLE);

        return new ResponseEntity<>(responsePayload, responsePayload.getHttpStatus());

    }

}
