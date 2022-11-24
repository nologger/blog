package kim.blog.common.Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Digest {

    /**
     * 입력받은 value에 대해 SHA256 알고리즘을 적용시키고 16진수로 표현되는 문자열을 반환한다.
     * @param value
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String SHA256(String value) throws NoSuchAlgorithmException {
        // encrypt
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(value.getBytes());
        byte[] encrypted = messageDigest.digest();
        return bytesToHex(encrypted);
    }

    /**
     * 전달받은 bytes[]에 대해 16진수 문자열로 변환하다.
     * @param bytes
     * @return
     */
    private static String bytesToHex(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes) {
            stringBuilder.append(String.format("%02x", b));
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(SHA256("admin"));
    }
}
