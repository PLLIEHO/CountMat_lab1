import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class IOService {
    public static List<List<Float>> matrix = new ArrayList<>();
    public static int size;
    private static int maxLine = 0;

    public static void readFromConsole(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите матрицу построчно, разделяя элементы пробелом. В конце ввода, введите символ 's'");

        while(true){
            List<Float> matrixLine = new ArrayList<>();
            String number = sc.nextLine();
            String[] subStr;
            String delimeter = "\s";
            subStr = number.split(delimeter);
            if(subStr[0].equals("s")){
                addNull();
                System.out.println(Arrays.toString(matrix.toArray()));
                break;
            }
            size++;
            for(int j = 0; j < subStr.length; j++) {
                    matrixLine.add(Float.parseFloat(subStr[j]));
                    if(subStr.length>maxLine) maxLine = subStr.length;
            }
            matrix.add(matrixLine);
        }
    }

    private static void addNull(){
        while(true) {
            if (maxLine < size + 1) {
                size -= 1;
                matrix.remove(size);
            } else {
                break;
            }
        }
        for(int i = 0; i<size; i++){
            if(matrix.get(i).size()<size){
                for(int j = matrix.get(i).size()-1; j<size; j++){
                    matrix.get(i).add((float) 0);
                }
            }
        }
    }

    public static void printFullMatrix(){
            System.out.println(Arrays.toString(matrix.toArray()));
    }
}
