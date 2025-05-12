public class PrimeNumber {
    public static void main(String[] args) {
        System.out.println("So nguyen to < 100 la :");
        for (int i = 2; i <100 ; i++) {
            if(isPrimeNumber(i)){
                System.out.print(i + " ");
            }
        }
    }
    public static boolean isPrimeNumber(int number){
        if(number < 2) return false;
        for(int i=2; i<= Math.sqrt(number); i++){
            if(number % i == 0) return false;
        }
        return true;
    }
}
