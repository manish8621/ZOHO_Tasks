import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//level 1
// got result [1+2+3+4=10, 1*2*3+4=10]

class Forte {
    static char[] operators = { '+', '-','*','/'};

    public static void main(String[] args) {
        int n = 10;
        int[] numbers = {1,2,3,4};
        Set<String> result = new HashSet<>(); 

        for (int i = 0; i < operators.length; i++) 
            toExpression(n,numbers,0,i,"",result);
        System.out.println(result);
  
    }




    //try bruteforcing permutaions of operators and numbers

    private static void toExpression(int n,int[] nums,int numsIndex,int operatorIndex,String expression,Set<String> result) {
        //base
        if(numsIndex==nums.length)
            return;
        else
        {
            //add the number to expression if number is 
            expression += (nums[numsIndex]);
            //can check here for valid exp
            if(evalExpression(expression)==n) result.add(expression+"="+n);
            expression += ((numsIndex!=nums.length-1)?operators[operatorIndex]:"");
            
            for (int i = 0; i < operators.length; i++)
                toExpression(n, nums, numsIndex+1, i, expression,result);
        
        }
    }

    // had to improve for ()s
    static int evalExpression(String expression) {
        // should be digit for now
        int evaluated = 0,index = 0;
        String number = "";
        Character pendingOperation = '+';
        while (index < expression.length()) {
            // get the number
            while (Character.isDigit(expression.charAt(index))) {
                
                number += String.valueOf(expression.charAt(index++));
                //if end of string evaluate and return 
                if (expression.length() == index) return eval(evaluated, pendingOperation, Integer.parseInt(number));
            }
            //eval 
                evaluated = eval(evaluated,pendingOperation,Integer.parseInt(number));
                number = "";
            //store current operator as pending
                pendingOperation = expression.charAt(index++);
        }
        return evaluated;
    }

    private static int eval(int number1, Character Operation, int number2) {
        switch (Operation) {
            case '+':
                return number1 + number2;
            case '-':
                return number1 - number2;
            case '*':
                return number1 * number2;
            case '/':
                return number1 / number2;

            default:
                return 0;
        }
    }
}
