package aula07;

public class Ex02 {
    public static void main(String[] args) {
        System.out.println(fatorial(5));
        System.out.println(fatorialRecursivo(5));
    }

    public static int fatorial(int n){
        int fatorial = 1;
        for (int i = n ; i > 0; i--){
            fatorial = fatorial * i;
        }
        return fatorial;
    }
    public static int fatorialRecursivo (int limite){
        if(limite == 0){
            return 1;
        }

        return limite * fatorialRecursivo(limite - 1);
    }
}
