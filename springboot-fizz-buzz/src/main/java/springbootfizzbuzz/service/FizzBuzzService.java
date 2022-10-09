package springbootfizzbuzz.service;

import org.springframework.stereotype.Service;

@Service
public class FizzBuzzService {
    public boolean accept(String arg){

        if(arg == null){
            System.out.println("User Input is null ");
            return false;
        }

        if(arg.equals("")){
            System.out.println("User Input is empty ");
            return false;
        }

        if(arg.startsWith("-") && arg.replace("-","").matches("[0-9]+")){
            System.out.println("User Input needs to be positive number " + arg);
            return false;
        }

        if(arg.startsWith("0") && arg.matches("[0-9]+")){
            System.out.println("User Input cannot start with 0 " + arg);
            return false;
        }
        if(!arg.matches("[0-9]+")){
            System.out.println("User Input is not a digit " + arg);
            return false;
        }

        return true;
    }

    /**
     * - If argument divisible by 3, print Fizz
     * - If argument divisible by 5, print Buzz
     * - If argument divisible by 3 and 5, print FizzBuzz
     */
    public String perform(String arg){
        if(accept(arg)){
            try{
                int numFromArg = Integer.parseInt(arg);

                if(numFromArg % 15 == 0){
                    return "FizzBuzz";
                } else if (numFromArg % 5 == 0) {
                    return "Buzz";
                } else if (numFromArg % 3 == 0){
                    return "Fizz";
                }

            } catch (Exception e){
                System.out.println("Error in FizzBuzz");
            }
        }

        return "-1";
    }
}
