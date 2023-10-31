import java.util.Scanner;
public class error {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sum = 0;
        System.out.print("Enter start:");
        int start = input.nextInt();
        System.out.print("Enter end:");
        int end = input.nextInt();
        if (start>end) {
            System.out.print("Error!");
        }
        else{
                while (start<=end){
                    sum = sum + start;
                    start+=1;
                }
                System.out.printf("Sum is %d",sum);   
                
        }
        input.close();
    }
}