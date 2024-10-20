import java.util.ArrayList;
import java.util.Arrays;

public class Task3 {

    public static void main(String[] args) {
//        ArrayList<Object[]> products = new ArrayList<>();
//        products.add(new Object[]{"Laptop", 124200});
//        products.add(new Object[]{"Phone", 51450});
//        products.add(new Object[]{"Headphones", 13800});
//        ArrayList<Object[]> updatedProducts = sale(products, 25);
//        for (Object[] product : updatedProducts) {
//            System.out.println(product[0] + ": " + product[1]);
//        }
//    }
//        String[][] inventory = {
//                {"Скакалка", "550", "8"},
//                {"Шлем", "3750", "4"},
//                {"Мяч", "2900", "10"}
//        };
//        System.out.println(mostExpensive(inventory));
        System.out.println(doesBrickFit(1,2,2,1,1));

    }

    // таск 1
    public static boolean isStrangePair(String str1, String str2) {
        if (str1.isEmpty() && str2.isEmpty()) return true;
        if (str1.isEmpty() || str2.isEmpty()) return false;
        return str1.charAt(0) == str2.charAt(str2.length() - 1) && str1.charAt(str1.length() - 1) == str2.charAt(0);
    }

    // таск 2
    public static ArrayList<Object[]> sale(ArrayList<Object[]> products, int discount) {
        ArrayList<Object[]> result = new ArrayList<>();
        for (Object[] product : products) {
            String name = (String) product[0];
            int price = (int) product[1];
            int newPrice = Math.max((int) Math.round(price * (1 - discount / 100.0)), 1);
            result.add(new Object[]{name, newPrice});
        }
        return result;
    }

    // таск 3
    public static boolean successShoot(int x, int y, int r, int m, int n) {
        return Math.sqrt(Math.pow(m - x, 2) + Math.pow(n - y, 2)) <= r;
    }

    // таск 4
    public static boolean parityAnalysis(int num) {
        int sum = 0;
        int number = num;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return (number % 2 == sum % 2);
    }

    // таск 5
    public static String rps(String player1, String player2) {
        if (player1.equals(player2)) return "Tie";
        if ((player1.equals("rock") && player2.equals("scissors")) || (player1.equals("scissors") && player2.equals("paper")) || (player1.equals("paper") && player2.equals("rock"))) {
            return "Player 1 wins";
        }
        else { return "Player 2 wins"; }
    }

    // таск 6
    public static int bugger(int num) {
        int count = 0;
        while (num >= 10) {
            int product = 1;
            while (num > 0) {
                product *= num % 10;
                num /= 10;
            }
            num = product;
            count++;
        }
        return count;
    }

    // таск 7
    public static String mostExpensive(String[][] inventory) {
        String maxItem = "";
        int maxCost = 0;
        for (String[] item : inventory) {
            int price = Integer.parseInt(item[1]);
            int quantity = Integer.parseInt(item[2]);
            int cost = price * quantity;
            if (cost > maxCost) {
                maxCost = cost;
                maxItem = item[0];
            }
        }
        return "Наиб. общ. стоимость у предмета " + maxItem + " - " + maxCost;
    }

    // таск 8
    public static String longestUnique(String s) {
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            StringBuilder unique = new StringBuilder();
            for (int j = i; j < s.length(); j++) {
                if (unique.toString().contains(String.valueOf(s.charAt(j)))) {
                    break;
                }
                unique.append(s.charAt(j));
            }
            if (unique.length() > longest.length()) {
                longest = unique.toString();
            }
        }
        return longest;
    }

    // таск 9
    public static boolean isPrefix(String word, String prefix) {
        return word.startsWith(prefix.replace("-", ""));
    }

    public static boolean isSuffix(String word, String suffix) {
        return word.endsWith(suffix.replace("-", ""));
    }

    // таск 10
    public static boolean doesBrickFit(int a, int b, int c, int w, int h) {
        int[] brickDimensions = {a, b, c};
        Arrays.sort(brickDimensions);
        return brickDimensions[0] <= w && brickDimensions[1] <= h;
    }
}

