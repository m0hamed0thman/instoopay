package GUI;

import java.util.Random;

public class VerificationCodeGenerator {
    public static String generateCode(int length) {
        String digits = "0123456789";
        StringBuilder code = new StringBuilder();
        Random rnd = new Random();
        for (int i = 0; i < length; i++) {
            code.append(digits.charAt(rnd.nextInt(digits.length())));
        }
        return code.toString();
    }
}
