import java.util.Scanner;
import java.util.zip.DataFormatException;
public class class2 {
    public static void main(String[] args) throws DataFormatException {

        String name;
        boolean isRoman=false;
        Scanner in = new Scanner(System.in);
        name = in.nextLine();
        in.close();

        if ((name.indexOf(".") != -1 ) || (name.indexOf(",") != -1 )) {
            throw new DataFormatException("Только целые числа");
            // System.out.println ("Ошибка. встретилась точка запятая!");
            // System.exit(0);
        }

        int pointOfOp=-1;
        // DONE сделать поиски всех возможных из 4 действий независимо, добавить проверку того что действие только одно
        int pointofPlus=name.indexOf(" + ");
        int pointofMinus=name.indexOf(" - ");
        int pointofDiv=name.indexOf(" / ");
        int pointofMul=name.indexOf(" * ");

        if (
                pointofPlus == -1 && pointofMinus == -1 && pointofMul == -1 && pointofDiv == -1 //нет никаких знаков операции
        ) {throw new DataFormatException("Используйте знак +, -, * или / С ПРОБЕЛАМИ");
            //System.out.println("Ошибка. Нет ни одного знака операции");
            // System.exit(0);
        }

        if ( ! (
                (pointofPlus != -1 && pointofMinus == -1 && pointofMul == -1 && pointofDiv == -1 //есть только плюс
                        && name.indexOf(" + ", pointofPlus+1) == -1 //и плюс только один
                ) ||
                (pointofPlus == -1 && pointofMinus != -1 && pointofMul == -1 && pointofDiv == -1 //есть только минус
                        && name.indexOf(" - ", pointofMinus+1) == -1 //и минус только один
                ) ||
                (pointofPlus == -1 && pointofMinus == -1 && pointofMul != -1 && pointofDiv == -1 //есть только умножить
                        && name.indexOf(" * ", pointofMul+1) == -1 //и умножить только один
                ) ||
                (pointofPlus == -1 && pointofMinus == -1 && pointofMul == -1 && pointofDiv != -1 //есть только разделить
                        && name.indexOf(" / ", pointofDiv+1) == -1 //и разделить только один
                ) )
        ) {throw new DataFormatException("Используйте только один знак операции");
            //System.out.println("Ошибка. Больше одного знака операции");
            //System.exit(0);
        }

        if (pointofDiv!=-1) { pointOfOp = pointofDiv; }
        if (pointofPlus!=-1) { pointOfOp = pointofPlus; }
        if (pointofMinus!=-1) { pointOfOp = pointofMinus; }
        if (pointofMul!=-1) { pointOfOp = pointofMul; }

//        if (pointOfOp==-1) {
//            System.out.println ("Ошибка. Нет операции");
//            System.exit(0);
//        }

        //System.out.println (pointOfOp);

        //System.out.println(name);
        String c1=name.substring (0,pointOfOp);
        //if (с1.) {
            //System.out.println ("Ошибка. Не число");
            //System.exit(0);

        //  DONE	Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления с двумя числами: a + b, a - b, a * b, a / b
        //	DONE 2	Калькулятор умеет работать как с арабскими (1,2,3,4,5…), так и с римскими (I,II,III,IV,V…) числами.
        //	DONE 3	Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более. На выходе числа не ограничиваются по величине и могут быть любыми.
        //	DONE 5	Калькулятор умеет работать только с арабскими или римскими цифрами одновременно, при вводе пользователем строки вроде 3 + II калькулятор должен выбросить исключение и прекратить свою работу.
        //	DONE 6	При вводе римских чисел, ответ должен быть выведен римскими цифрами, соответственно, при вводе арабских - ответ ожидается арабскими.
        //	DONE 7	При вводе пользователем неподходящих чисел приложение выбрасывает исключение и завершает свою работу.
        //	DONE 8	При вводе пользователем строки, не соответствующей одной из вышеописанных арифметических операций, приложение выбрасывает исключение и завершает свою работу.
        //  DONE убрать тестовые выводы в консоль
        //	DONE 9	Результатом операции деления является целое число, остаток отбрасывается. (потестировать)
        //	DONE 10	Результатом работы калькулятора с арабскими числами могут быть отрицательные числа и ноль.
        //	DONE    Результатом работы калькулятора с римскими числами могут быть только положительные числа, если результат работы меньше единицы, выбрасывается исключение
        //  DONE автотесты
        //  DONE разобраться с исключениями (послушать лекцию об исключениях из материалов Кати)
        //  DONE потестировать работу с дробями

        int v1=0;
        try {
            v1=Integer.parseInt(c1);
            // System.out.println("число");
            isRoman=false;
        } catch(NumberFormatException e) {
            switch (c1) {
                case "X":   v1=10;isRoman=true; break;
                case "IX":  v1=9; isRoman=true; break;
                case "VIII":v1=8; isRoman=true; break;
                case "VII": v1=7; isRoman=true; break;
                case "VI":  v1=6; isRoman=true; break;
                case "V":   v1=5; isRoman=true; break;
                case "IV":  v1=4; isRoman=true; break;
                case "III": v1=3; isRoman=true; break;
                case "II":  v1=2; isRoman=true; break;
                case "I":   v1=1; isRoman=true; break;
                default: {
                    throw new DataFormatException("Введите арабские или римские цифры");
                    //System.out.println ("Ошибка. Введите арабские или римские цифры");
                    //System.exit(0);
                }
            }
            // System.out.println("не число");
        }
        if (v1 <1 || v1>10) {
            throw new DataFormatException("Первое число должно быть от 1 до 10");
            //System.out.println ("Ошибка. Первое число должно быть от 1 до 10");
            //System.exit(0);
        }
        //int v1=Integer.valueOf(c1);

        //System.out.println(v1);
        String c2=name.substring (pointOfOp, pointOfOp+3);
        //System.out.println(c2);
        String c3=name.substring (pointOfOp+3);
        int v3=0;
        try {
            v3=Integer.parseInt(c3);
            // System.out.println("число");
            if (isRoman) {
                throw new DataFormatException("Первая цифра римская, вторая арабская");
                //System.out.println ("Ошибка. Первая римская, вторая арабская");
                //System.exit(0);
            }
        } catch(NumberFormatException e) {
            switch (c3) {
                case "X":   v3=10;break;
                case "IX":  v3=9; break;
                case "VIII":v3=8; break;
                case "VII": v3=7; break;
                case "VI":  v3=6; break;
                case "V":   v3=5; break;
                case "IV":  v3=4; break;
                case "III": v3=3; break;
                case "II":  v3=2; break;
                case "I":   v3=1; break;
                default: {
                    throw new DataFormatException("Введите арабские или римские цифры");
                    //System.out.println("Ошибка. Введите арабские или римские цифры");
                    //System.exit(0);
                }
            }

            if (isRoman==false) {
                throw new DataFormatException("Первая цифра арабская, вторая римская");
                //System.out.println("Ошибка. Первая арабская, вторая римская");
                //System.exit(0);
            }
        }
            // System.out.println("не число");

        if (v3 <1 || v3>10) {
            throw new DataFormatException("Второе число должно быть от 1 до 10");
            //System.out.println ("Ошибка. Второе число должно быть от 1 до 10");
            //System.exit(0);
        }
        //System.out.println(v3);
        int result=0;
        // System.out.println(c2);
        if (c2.equals(" + ")) result = (v1+v3);
        if (c2.equals(" - ")) result = (v1-v3);
        if (c2.equals(" * ")) result = (v1*v3);
        if (c2.equals(" / ")) result = (v1/v3);

        if (isRoman) {
            if (result <1) {
                throw new DataFormatException("Ответ в римских цифрах не может быть меньше 1");
                //System.out.println ("Ошибка. Римская меньше единицы");
                //System.exit(0);
            }
        }

        if (isRoman==false) {
            System.out.println(result);
            //System.exit(0);
        }
        else {
            //DONE Форматировать вывод римскими или арабскими в зависимости от ввода
            // result=98;
            int numOnes = result % 10; // последнее число, кол-во единиц
            int numTens = (result / 10) % 10; // второе число, кол-во десятков
            int numHundreds = (result / 100) % 10; // третье число, кол-во сотен

//            System.out.print(numHundreds);
//            System.out.print(numTens);
//            System.out.println(numOnes);

            // печатает разряд сотен римскими
            if (numHundreds == 1) System.out.print("C");

            // печатает разряд десятков римскими
            if (numTens == 9) System.out.print("XC");
            if (numTens == 8) System.out.print("LXXX");
            if (numTens == 7) System.out.print("LXX");
            if (numTens == 6) System.out.print("LX");
            if (numTens == 5) System.out.print("L");
            if (numTens == 4) System.out.print("XL");
            if (numTens == 3) System.out.print("XXX");
            if (numTens == 2) System.out.print("XX");
            if (numTens == 1) System.out.print("X");

            // печатает единицы римскими
            if (numOnes == 9) System.out.print("IX");
            if (numOnes == 8) System.out.print("VIII");
            if (numOnes == 7) System.out.print("VII");
            if (numOnes == 6) System.out.print("VI");
            if (numOnes == 5) System.out.print("V");
            if (numOnes == 4) System.out.print("IV");
            if (numOnes == 3) System.out.print("III");
            if (numOnes == 2) System.out.print("II");
            if (numOnes == 1) System.out.print("I");
        }
    }
}