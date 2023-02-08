import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите 1, если хотите ввести матрицу самостоятельно. Введите 2, если хотите прочитать файл.");
        int number = sc.nextInt();
        switch(number){
            case 1:
                IOService.readFromConsole();
                CoreService service = new CoreService();
                service.gaussTriangle(3);
                break;
            default:
                break;
        }
    }
}