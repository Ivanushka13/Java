public class LetterCount {
    public static void main(String[] args) {
        String str = "Hello, World!";
        countLetter(str);
    }

    public static void countLetter(String str) {
        char[] vowel = "aeiou".toCharArray();
        char[] cons = "bcdfghjklmnpqrstvwxyz".toCharArray();
        int vowelCount = 0;
        int consCount = 0;
        char[] chars = str.toLowerCase().toCharArray();
        for (char el : chars) {
            for (char vow : vowel) {
                if (el == vow) {
                    vowelCount += 1;
                    break;
                }
            }
            for (char con : cons) {
                if (el == con) {
                    consCount += 1;
                }
            }
        }
        System.out.print("The number of vowels: ");
        System.out.println(vowelCount);
        System.out.print("The number of cons: ");
        System.out.println(consCount);
    }
}
