package aula08;

public class Ex01 {

    public static String substringStr( String[] input) {
        for(String substring : input){
            return substring;
        }
        return "substring";
    }

    public static void main(String[] args) {
        String array[] = {"as", "mas", "amor", "amoreco"};

        System.out.println(substringStr(array));
    }
}
