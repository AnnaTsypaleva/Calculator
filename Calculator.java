package Calculator;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Number numbers;				// неизвестно арабик или роман, поэтому пишем намбэр
        String oper;
        boolean exit = false;
        boolean arabic = false;


        Scanner sInput = new Scanner(System.in);

        while (true) {


            System.out.println("Введите запрос: ");

            String[] inputArray = new String[3];				//  [null,null,null]

            int i = 0;
            try {
                while (i < 3) {
                    if (i < 3)
                        inputArray[i] = sInput.next();			// ["2","+","3"]
                    i++;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                sInput.close();
                System.out.println("Слишком длинное выражение.");
                System.exit(0);
            }


            oper = inputArray[1];

            try {

                if (!(oper.equals("+") || oper.equals("-") || oper.equals("*") || oper.equals("/"))) {
                    throw new Exception();
                }

                try {
                    int firstNumber = Integer.parseInt(inputArray[0]);	          // преобразовываем строку в int
                    int secondNumber = Integer.parseInt(inputArray[2]);

                    numbers = new Arabic(firstNumber,secondNumber);
                    arabic = true;

                } catch (NumberFormatException n) {				// возможно ввели римские цифры?? проверим
                    int j = 1;
                    boolean firstRomanFound = false;
                    boolean secondRomanFound = false;
                    while (j < 11 && (firstRomanFound == false || secondRomanFound == false)) { // пока не нашли, ищем
                        if (inputArray[0].equals(Roman.getRomanUnits()[j]))
                            firstRomanFound = true;
                        if (inputArray[2].equals(Roman.getRomanUnits()[j]))
                            secondRomanFound = true;
                        j++;
                    }

                    if (firstRomanFound && secondRomanFound)
                        numbers = new Roman(inputArray[0],inputArray[2]);		// создаём объект с римскими цифрами

                    else throw new Exception();
                }


            } catch (Exception e) {
                System.out.println("Введено неверно.");
                continue;
            }



            if (oper.equals("+")) {
                numbers.add();					// сложение выполняется внутри класса
                System.out.println(numbers.getStringResult());
            }
            else if (oper.equals("-")) {
                numbers.subtract();
                System.out.println(numbers.getStringResult());

            }
            else if (oper.equals("*")) {
                numbers.multiply();
                System.out.println(numbers.getStringResult());
            }
            else if (oper.equals("/")) {
                numbers.divide();
                System.out.println(numbers.getStringResult());
            }


        }
    }
}