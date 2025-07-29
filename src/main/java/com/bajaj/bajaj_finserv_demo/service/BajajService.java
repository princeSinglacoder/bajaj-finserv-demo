package com.bajaj.bajaj_finserv_demo.service;

import com.bajaj.bajaj_finserv_demo.controller.model.BajajRequest;
import com.bajaj.bajaj_finserv_demo.controller.model.BajajResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BajajService {

    public BajajResponse processData(BajajRequest bajajRequest) {

        List<String> data = bajajRequest.getData();
        try {
            List<String> oddNumbers = new ArrayList<>();
            List<String> evenNumbers = new ArrayList<>();
            List<String> alphabets = new ArrayList<>();
            List<String> specialCharacters = new ArrayList<>();

            int sum = 0;
            StringBuilder alphabetString = new StringBuilder();

            for (String item : data) {
                if (isNumeric(item)) {
                    int num = Integer.parseInt(item);
                    sum += num;

                    if (num % 2 == 0) {
                        evenNumbers.add(item);
                    } else {
                        oddNumbers.add(item);
                    }
                } else if (isAlphabetic(item)) {
                    alphabets.add(item.toUpperCase());
                    alphabetString.append(item);
                } else {
                    specialCharacters.add(item);
                }
            }

            String concatString = createAlternatingCapsString(alphabetString.toString());

            BajajResponse bajajResponse = new BajajResponse();
            bajajResponse.setSuccess(true);
            bajajResponse.setUserId(Constant.USER_ID);
            bajajResponse.setEmail(Constant.EMAIL);
            bajajResponse.setRollNumber(Constant.ROLL_NUMBER);
            bajajResponse.setOddNumbers(oddNumbers);
            bajajResponse.setEvenNumbers(evenNumbers);
            bajajResponse.setAlphabets(alphabets);
            bajajResponse.setSpecialCharacters(specialCharacters);
            bajajResponse.setSum(String.valueOf(sum));
            bajajResponse.setConcatString(concatString);
            return bajajResponse;

        } catch (Exception e) {

            BajajResponse bajajResponse = new BajajResponse();
            bajajResponse.setSuccess(false);
            bajajResponse.setUserId(Constant.USER_ID);
            bajajResponse.setEmail(Constant.EMAIL);
            bajajResponse.setRollNumber(Constant.ROLL_NUMBER);
            return bajajResponse;
        }
    }

    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isAlphabetic(String str) {
        if (str == null || str.isEmpty()) return false;
        return str.chars().allMatch(Character::isLetter);
    }

    private String createAlternatingCapsString(String alphabetString) {
        if (alphabetString.isEmpty()) {
            return "";
        }

        String reversed = new StringBuilder(alphabetString).reverse().toString();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < reversed.length(); i++) {
            char c = reversed.charAt(i);
            if (i % 2 == 0) {
                result.append(Character.toUpperCase(c));
            } else {
                result.append(Character.toLowerCase(c));
            }
        }

        return result.toString();
    }
}
