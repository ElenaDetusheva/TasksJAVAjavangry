package TaskNG;

import java.util.Arrays;
import java.util.OptionalInt;

public class tasks_grpoup {


    public static void main(String[] args) {

//    Написать код, который принимает число и выдает true,
//    если число является степенью двойки и false - если нет

        System.out.println(isPowerOf2(129));


//    Даны 4 числа, надо найти наибольшее.
//    if использовать нельзя, код должен быть не больше 10 строк

        System.out.println(isMaxOf4Num(1, 5, 3, 4).getAsInt());


//    Проверить, является ли фраза палиндромом
        String strPalin = "А роза упала на лапу Азора";

        System.out.println(strPalin + "  " + strIsPalin(strPalin));


//    Дан набор целочисленных значений от 1 до n, причем n вам известен. И вы точно знаете,
//    что все числа в этом наборе есть.
//    Также все числа перемешаны. Из набора забрали одно число, и вам надо его найти.

        Integer[] arrN = {1, 3, 5, 4, 2, 6, 7, 8};
        Integer[] arrNew = {1, 3, 5, 4, 2, 7, 8};
        Arrays.sort(arrN);


        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < arrN.length; i++) {
            sum1 += arrN[i];
        }
        for (int i = 0; i < arrNew.length; i++) {
            sum2 += arrNew[i];
        }
        int xNum = 0;
        xNum = sum1 - sum2;
        System.out.println(xNum);

//        Немного по-другому
        int res = 0;
        for (int i = 0; i < arrNew.length; i++) {
            res += arrN[i] - arrNew[i];
        }
        xNum = res + arrN[arrN.length - 1];
        System.out.println(xNum);

//      Очень по-другом 1
        Arrays.sort(arrN);
        for (int i = 0; i < arrNew.length; i++) {
            arrN[arrNew[i] - 1] = 0;
        }
        res = 0;
        for (int i = 0; i < arrN.length; i++) {
            res += arrN[i];
        }
        System.out.println(res);
        System.out.println(Arrays.toString(arrN));

//      Очень по-другом 2
        Arrays.sort(arrNew);
        res = 0;
        for (int i = 0; i < arrNew.length - 1; i++) {
            if (arrNew[i + 1] - arrNew[i] != 1) {
                System.out.println(i + 1 + 1);
            }
        }
//решение с помощью бинарного поиска
        int n = 8;
        int low = 0;
        int high = n-1;
        int mid = 0;
        int result = 0;
        if (arrNew[n-2]!=n){
            result=n;
        }else {
            while (low < high && high > 1) {
                mid = (low + high) / 2;
                if (arrNew[mid - 1] == mid) {
                    low = mid + 1;
                    result = high;
                } else {
                    high = mid;
                    result = mid;
                }
            }
        }
        System.out.println("mid " +result );
//        (Продолжение 6.2) Написать калькулятор,
//        который понимает римские и арабские цифры,
//        для упрощения - достаточно, чтобы принимал числа до 10

        String [] rimNum = {"","I","II","III","IV","V","VI","VII","VIII","IX","X"};
        String rimNum1 = "III";
        String rimNum2 = "VII";
        int index1 = Arrays.asList(rimNum).indexOf(rimNum1);
        int index2 = Arrays.asList(rimNum).indexOf(rimNum2);
        int idx = 0;
//        idx = index1 + index2;
        idx = index1 * index2;
        if (idx<= 10 ){
            System.out.println(rimNum[idx]);
        } else if ( idx> 10 && idx<= 20) {
            System.out.println("X"+rimNum[idx-10]);
        }else if( idx> 20 && idx<=30) {
            System.out.println(rimNum1 + " * " + rimNum2 + " = XX"+rimNum[idx-20]);
        }



//        Дан массив с числами типа Integer. Вам нужно написать функцию,
//        которая на входе получит исходный массив, а на выходе вернет массив,
//        в котором каждое значение получено путем произведения всех значений
//        исходного массива с отличным от текущего индексом.
//
//                Расчет значений происходит следующим образом:
//[7*3*4, 1*3*4, 1*7*4, 1*7*3]
//
        int [] arr ={1, 7, 3, 4};
        System.out.println(Arrays.toString(multNotI (arr)));

//        Со звездочкой для тех кто решил - нельзя использовать деление.

        System.out.println(Arrays.toString(multNotIStar (arr)));


//        Arrays.asList(s).indexOf
    }



    public static OptionalInt isMaxOf4Num (int a, int b, int c, int d){
        int[] abcd = new int[]{a,b,c,d};
//        OptionalInt max =Arrays.stream(abcd).max();
//       return max;
        return Arrays.stream(abcd).max();

    }

//    Написать код, который принимает число и выдает true,
//    если число является степенью двойки и false - если нет
    public static boolean isPowerOf2 (float num){
        while(num%2 == 0){
            num = num/2;
        }
        return num == 1;
    }

//    Проверить, является ли фраза палиндромом

    public static boolean strIsPalin (String strPalin){
        strPalin = strPalin.toLowerCase().replaceAll(" ", "");
        int i = 0;
        while(strPalin.charAt(i) == strPalin.charAt(strPalin.length()-1-i) && i< strPalin.length()/2){
            i++;
          }
        return i==strPalin.length()/2;

        }


//        Дан массив с числами типа Integer. Вам нужно написать функцию,
//        которая на входе получит исходный массив, а на выходе вернет массив,
//        в котором каждое значение получено путем произведения всех значений
//        исходного массива с отличным от текущего индексом.
//
//                Расчет значений происходит следующим образом:
//[7*3*4, 1*3*4, 1*7*4, 1*7*3]


    public static int [] multNotI (int [] arr){
        int mult = 1;
      for ( int i = 0; i<arr.length ; i++){
         mult *= arr[i];
      }
      int [] resArr ;
      resArr = new int[arr.length];
      for (int i = 0; i<arr.length; i++){
          resArr[i] = mult/arr[i];
      }
        return resArr;

    }

    //        Со звездочкой для тех кто решил - нельзя использовать деление.
    public static int [] multNotIStar (int [] arr){
        int mult = 1;
        int [] resArr ;
        resArr = new int[arr.length];
        for ( int i = 0; i<arr.length ; i++){
            mult = 1;
            for(int j = 0; j<arr.length ; j++){
                if(j!=i){
                    mult *= arr[j];
                }
                resArr[i] = mult;
            }
        }
        return resArr;
    }

    }


