package zoo;

import java.util.Random;

public class Voucher {

    private static GeneralDiscounts generalDiscounts;
    private String code;

    public Voucher() {

    }

    public GeneralDiscounts getGeneralDiscounts() {
        return generalDiscounts;
    }

    public String getCode() {
        return code;
    }

    public Voucher(int discountType) {
        generalDiscounts = new GeneralDiscounts(discountType);
        this.code = genCode();
    }

    /**
     * Method that generates voucher code form random letters and numbers
     * @return voucher code
     */
    private String genCode() {
        String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        int length = 10;
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(candidateChars.charAt(random.nextInt(candidateChars.length())));
        }
        return sb.toString();
    }
}
