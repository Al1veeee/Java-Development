package ru.week2.day4;

public class ReverseNumber {
    public static int reverseNumber(int number) {
        if (number == 0) return 0;  // Базовый случай для 0
        return reverseHelper(number, 0);
    }
    private static int reverseHelper(int num, int rev) {
        if (num == 0) return rev; // Базовый случай
        int lastDigit = num % 10; // Последняя цифра
        int rest = num / 10; // Остаток от числа
        return reverseHelper(rest, rev * 10 + lastDigit);
    }

    public static void main(String[] args) {
        System.out.println(reverseNumber(12345));
    }
}

// "Шаг" ,"Вызов"                    ,"num"    ,"rev (до)" ,"lastDigit"    ,"rest"            ,"rev (новый)"      ,"Возврат"
// "1"   ,"reverseHelper(12345, 0)"  ,"12345"  ,"0"        ,"5 (12345%10)" ,"1234 (12345/10)" ,"0*10+5=5"         ,"→ шаг 2"
// "2"   ,"reverseHelper(1234, 5)"   ,"1234"   ,"5"        ,"4"            ,"123"             ,"5*10+4=54"        ,"→ шаг 3"//
// "3"   ,"reverseHelper(123, 54)"   ,"123"    ,"54"       ,"3"            ,"12"              ,"54*10+3=543"      ,"→ шаг 4"//
// "4"   ,"reverseHelper(12, 543)"   ,"12"     ,"543"      ,"2"            ,"1"               ,"543*10+2=5432"    ,"→ шаг 5"//
// "5"   ,"reverseHelper(1, 5432)"   ,"1"      ,"5432"     ,"1"            ,"0"               ,"5432*10+1=54321"  ,"→ шаг 6"//
// "6"   ,"reverseHelper(0, 54321)"  ,"0"      ,"54321"    ,"-"            ,"-"               ,"-"                ,"Возврат 54321(база)"