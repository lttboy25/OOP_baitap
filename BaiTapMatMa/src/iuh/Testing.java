package iuh;

public class Testing {
	    public static void main(String[] args) {
	        System.out.println("=== 1. CAESAR CIPHER ===");
	        test1Caesar("HELLO", 3);
	        test1Caesar("HELLO WORLD", 5);
	        test1Caesar("ATTACK AT DAWN", 7);

	        System.out.println("\n=== 2. MONOALPHABETIC CIPHER ===");
	        String key2 = "QWERTYUIOPASDFGHJKLZXCVBNM";
	        test2Mono("HELLO", key2);
	        test2Mono("ATTACK AT DAWN", key2);
	        test2Mono("SECURITY", key2);

	        System.out.println("\n=== 3. VIGENERE CIPHER ===");
	        test3Vigenere("ATTACKATDAWN", "LEMON");
	        test3Vigenere("HELLO", "KEY");
	        test3Vigenere("SECURITY", "HELLO");

	        System.out.println("\n=== 4. PLAYFAIR CIPHER ===");
	        test4Playfair("INSTRUMENTS", "MONARCHY");
	        test4Playfair("HELLO", "PLAYFAIREXAMPLE");
	        test4Playfair("ATTACKATDAWN", "SECURITY");

	        System.out.println("\n=== 5. ONE-TIME PAD ===");
	        test5OTP("HELLO", "XMCKL");
	        test5OTP("ATTACK", "QWERTY");
	        test5OTP("SECURITY", "ABCDEFGH");

	        System.out.println("\n=== 6. RAIL FENCE CIPHER ===");
	        test6Rail("WEAREDISCOVEREDFLEEATONCE", 3);
	        test6Rail("HELLOWORLD", 4);
	        test6Rail("ATTACKATDAWN", 2);
	    }

	    static void test1Caesar(String plain, int key) {
	        String c = ClassicalCiphers.caesarEncrypt(plain, key);
	        String d = ClassicalCiphers.caesarDecrypt(c, key);
	        System.out.printf("Plaintext=%-20s Key=%-3d Ciphertext=%-20s Decrypted=%s%n", plain, key, c, d);
	    }

	    static void test2Mono(String plain, String key) {
	        String c = ClassicalCiphers.monoEncrypt(plain, key);
	        String d = ClassicalCiphers.monoDecrypt(c, key);
	        System.out.printf("Plaintext=%-20s Ciphertext=%-20s Decrypted=%s%n", plain, c, d);
	    }

	    static void test3Vigenere(String plain, String key) {
	        String c = ClassicalCiphers.vigenereEncrypt(plain, key);
	        String d = ClassicalCiphers.vigenereDecrypt(c, key);
	        System.out.printf("Plaintext=%-20s Key=%-10s Ciphertext=%-20s Decrypted=%s%n", plain, key, c, d);
	    }

	    static void test4Playfair(String plain, String key) {
	        String c = ClassicalCiphers.playfairEncrypt(plain, key);
	        String d = ClassicalCiphers.playfairDecrypt(c, key);
	        System.out.printf("Plaintext=%-20s Key=%-16s Ciphertext=%-20s Decrypted=%s%n", plain, key, c, d);
	    }

	    static void test5OTP(String plain, String key) {
	        String c = ClassicalCiphers.otpEncrypt(plain, key);
	        String d = ClassicalCiphers.otpDecrypt(c, key);
	        System.out.printf("Plaintext=%-20s Key=%-10s Ciphertext=%-20s Decrypted=%s%n", plain, key, c, d);
	    }

	    static void test6Rail(String plain, int rails) {
	        String c = ClassicalCiphers.railFenceEncrypt(plain, rails);
	        String d = ClassicalCiphers.railFenceDecrypt(c, rails);
	        System.out.printf("Plaintext=%-28s Rails=%-3d Ciphertext=%-28s Decrypted=%s%n", plain, rails, c, d);
	    }
	}
