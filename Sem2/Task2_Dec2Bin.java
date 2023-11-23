public class Task2_Dec2Bin {
    public static void main(String[] args) {
        int dec = 100;
        int base = 16;
        System.out.println(dec + " in BIN: " + decToBin(dec));
        System.out.println(dec + " in BASE x" + base +": " + decToBase(dec,base));
    }

    public static String decToBin(int dec){
        String result = "";
        int rest;
        do {
            rest = dec % 2;
            result = Integer.toString(rest) + result;
            dec = dec/2;
        } while (dec > 0);
        return result;
    }

    public static String decToBase(int dec, int base){
        String result = "";
        int rest;
        do {
            rest = dec % base;
            String restChar = "";
            if(rest > 9) restChar = String.valueOf((char) (rest + 55));
            else restChar = Integer.toString(rest);

            result = restChar + result;
            dec = dec/base;
        } while (dec > 0);
        return result;
    }
}
