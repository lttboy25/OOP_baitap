package iuh;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * BÀI TẬP: CÀI ĐẶT CÁC THUẬT TOÁN MẬT MÃ CỔ ĐIỂN
 * ------------------------------------------------
 * Chương trình cài đặt 6 thuật toán mật mã cổ điển, có menu lựa chọn,
 * cho phép người dùng nhập plaintext/ciphertext, key và chọn mã hóa/giải mã.
 *
 * Các thuật toán:
 *   1. Caesar Cipher
 *   2. Monoalphabetic Substitution Cipher
 *   3. Vigenère Cipher
 *   4. Playfair Cipher
 *   5. One-Time Pad (OTP)
 *   6. Rail Fence Cipher
 *
 * Quy ước xử lý chung: các thuật toán làm việc trên bảng chữ cái A-Z
 * (chữ hoa). Ký tự không phải chữ cái (khoảng trắng, dấu câu, số) sẽ
 * được giữ nguyên, không bị mã hóa (trừ Playfair/OTP/RailFence yêu cầu
 * chuỗi thuần chữ cái theo đặc thù thuật toán, sẽ được loại bỏ ký tự
 * không hợp lệ trước khi xử lý).
 */
public class ClassicalCiphers {

    public static void main(String[] args) {
        // Ép luồng xuất chuẩn dùng UTF-8 để hiển thị tiếng Việt đúng
        // (trên Windows CMD nên chạy thêm lệnh "chcp 65001" trước khi chạy chương trình).
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);
        int choice;
        do {
            printMenu();
            choice = readInt(sc, "Chọn chức năng: ");
            switch (choice) {
                case 1: runCaesar(sc); break;
                case 2: runMonoalphabetic(sc); break;
                case 3: runVigenere(sc); break;
                case 4: runPlayfair(sc); break;
                case 5: runOTP(sc); break;
                case 6: runRailFence(sc); break;
                case 7: System.out.println("Tạm biệt!"); break;
                default: System.out.println("Lựa chọn không hợp lệ!");
            }
            System.out.println();
        } while (choice != 7);
        sc.close();
    }

    private static void printMenu() {
        System.out.println("========================================");
        System.out.println(" CHƯƠNG TRÌNH MẬT MÃ CỔ ĐIỂN");
        System.out.println("========================================");
        System.out.println("1. Caesar Cipher");
        System.out.println("2. Monoalphabetic Cipher");
        System.out.println("3. Vigenere Cipher");
        System.out.println("4. Playfair Cipher");
        System.out.println("5. One-Time Pad");
        System.out.println("6. Rail Fence Cipher");
        System.out.println("7. Thoát");
    }

    // ============================================================
    // HÀM TIỆN ÍCH CHUNG
    // ============================================================

    private static int readInt(Scanner sc, String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextInt()) {
            System.out.print("Vui lòng nhập số nguyên hợp lệ: ");
            sc.next();
        }
        int val = sc.nextInt();
        sc.nextLine(); // xóa ký tự newline còn lại
        return val;
    }

    private static String readLine(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    /** Chỉ giữ lại các ký tự chữ cái A-Z, chuyển về chữ hoa. */
    private static String onlyLetters(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toUpperCase().toCharArray()) {
            if (c >= 'A' && c <= 'Z') sb.append(c);
        }
        return sb.toString();
    }

    private static int chooseMode(Scanner sc) {
        System.out.println("1. Mã hóa (Encrypt)");
        System.out.println("2. Giải mã (Decrypt)");
        return readInt(sc, "Chọn chế độ: ");
    }

    // ============================================================
    // 1. CAESAR CIPHER
    // Nguyên lý: dịch chuyển mỗi ký tự trong bản rõ đi k vị trí trong
    // bảng chữ cái (mod 26). Giải mã là dịch ngược lại k vị trí.
    // ============================================================

    private static void runCaesar(Scanner sc) {
        String text = readLine(sc, "Nhập văn bản: ");
        int key = readInt(sc, "Nhập khóa (số nguyên): ");
        int mode = chooseMode(sc);
        String result = (mode == 1) ? caesarEncrypt(text, key) : caesarDecrypt(text, key);
        printResult(text, String.valueOf(key), mode, result);
    }

    static String caesarEncrypt(String text, int key) {
        return caesarShift(text, key);
    }

    static String caesarDecrypt(String text, int key) {
        return caesarShift(text, 26 - (key % 26));
    }

    private static String caesarShift(String text, int key) {
        key = ((key % 26) + 26) % 26;
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isUpperCase(c)) {
                sb.append((char) ('A' + (c - 'A' + key) % 26));
            } else if (Character.isLowerCase(c)) {
                sb.append((char) ('a' + (c - 'a' + key) % 26));
            } else {
                sb.append(c); // giữ nguyên khoảng trắng, ký tự đặc biệt
            }
        }
        return sb.toString();
    }

    // ============================================================
    // 2. MONOALPHABETIC SUBSTITUTION CIPHER
    // Nguyên lý: mỗi chữ cái trong bảng chữ cái gốc (A-Z) được ánh xạ
    // 1-1 sang một chữ cái khác theo bảng khóa (permutation của A-Z).
    // ============================================================

    private static void runMonoalphabetic(Scanner sc) {
        String text = readLine(sc, "Nhập văn bản: ");
        String key = readLine(sc, "Nhập bảng khóa (24-26 ký tự, hoán vị của ABCDEFGHIJKLMNOPQRSTUVWXYZ): ");
        key = onlyLetters(key);
        if (key.length() != 26) {
            System.out.println("Lỗi: bảng khóa phải gồm đúng 26 chữ cái, mỗi chữ xuất hiện đúng 1 lần!");
            return;
        }
        int mode = chooseMode(sc);
        String result = (mode == 1) ? monoEncrypt(text, key) : monoDecrypt(text, key);
        printResult(text, key, mode, result);
    }

    static String monoEncrypt(String text, String cipherAlphabet) {
        String plain = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            char upper = Character.toUpperCase(c);
            int idx = plain.indexOf(upper);
            if (idx == -1) {
                sb.append(c);
            } else {
                char mapped = cipherAlphabet.charAt(idx);
                sb.append(Character.isLowerCase(c) ? Character.toLowerCase(mapped) : mapped);
            }
        }
        return sb.toString();
    }

    static String monoDecrypt(String text, String cipherAlphabet) {
        String plain = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            char upper = Character.toUpperCase(c);
            int idx = cipherAlphabet.indexOf(upper);
            if (idx == -1) {
                sb.append(c);
            } else {
                char mapped = plain.charAt(idx);
                sb.append(Character.isLowerCase(c) ? Character.toLowerCase(mapped) : mapped);
            }
        }
        return sb.toString();
    }

    // ============================================================
    // 3. VIGENERE CIPHER
    // Nguyên lý: khóa là 1 chuỗi ký tự, được lặp lại tương ứng với độ
    // dài bản rõ (chỉ tính trên các ký tự chữ cái). Mỗi ký tự bản rõ
    // được dịch chuyển theo giá trị của ký tự khóa tương ứng (A=0,...).
    // ============================================================

    private static void runVigenere(Scanner sc) {
        String text = readLine(sc, "Nhập văn bản: ");
        String key = onlyLetters(readLine(sc, "Nhập khóa (chuỗi chữ cái): "));
        if (key.isEmpty()) {
            System.out.println("Lỗi: khóa không hợp lệ!");
            return;
        }
        int mode = chooseMode(sc);
        String result = (mode == 1) ? vigenereEncrypt(text, key) : vigenereDecrypt(text, key);
        printResult(text, key, mode, result);
    }

    static String vigenereEncrypt(String text, String key) {
        StringBuilder sb = new StringBuilder();
        int k = 0;
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                boolean lower = Character.isLowerCase(c);
                char base = lower ? 'a' : 'A';
                int shift = Character.toUpperCase(key.charAt(k % key.length())) - 'A';
                char enc = (char) (base + (Character.toUpperCase(c) - 'A' + shift) % 26);
                sb.append(enc);
                k++;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    static String vigenereDecrypt(String text, String key) {
        StringBuilder sb = new StringBuilder();
        int k = 0;
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                boolean lower = Character.isLowerCase(c);
                char base = lower ? 'a' : 'A';
                int shift = Character.toUpperCase(key.charAt(k % key.length())) - 'A';
                char dec = (char) (base + ((Character.toUpperCase(c) - 'A' - shift) + 26) % 26);
                sb.append(dec);
                k++;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    // ============================================================
    // 4. PLAYFAIR CIPHER
    // Nguyên lý: xây dựng ma trận khóa 5x5 từ từ khóa (I/J gộp chung).
    // Bản rõ được tách thành từng cặp ký tự (digraph). Với mỗi cặp:
    //  - Cùng hàng   -> thay bằng ký tự bên phải (encrypt) / trái (decrypt)
    //  - Cùng cột    -> thay bằng ký tự bên dưới (encrypt) / trên (decrypt)
    //  - Khác hàng/cột (hình chữ nhật) -> đổi chéo cột, giữ nguyên hàng
    // ============================================================

    private static void runPlayfair(Scanner sc) {
        String text = readLine(sc, "Nhập văn bản: ");
        String key = onlyLetters(readLine(sc, "Nhập khóa: "));
        if (key.isEmpty()) {
            System.out.println("Lỗi: khóa không hợp lệ!");
            return;
        }
        int mode = chooseMode(sc);
        String result = (mode == 1) ? playfairEncrypt(text, key) : playfairDecrypt(text, key);
        printResult(text, key, mode, result);
    }

    /** Xây dựng ma trận khóa 5x5 (I và J dùng chung 1 ô). */
    static char[][] buildPlayfairMatrix(String key) {
        boolean[] used = new boolean[26];
        StringBuilder seq = new StringBuilder();
        for (char c : key.toUpperCase().toCharArray()) {
            if (c == 'J') c = 'I';
            int idx = c - 'A';
            if (!used[idx]) {
                used[idx] = true;
                seq.append(c);
            }
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            if (c == 'J') continue;
            int idx = c - 'A';
            if (!used[idx]) {
                used[idx] = true;
                seq.append(c);
            }
        }
        char[][] matrix = new char[5][5];
        int p = 0;
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                matrix[i][j] = seq.charAt(p++);
        return matrix;
    }

    private static int[] findPosition(char[][] m, char c) {
        if (c == 'J') c = 'I';
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                if (m[i][j] == c) return new int[]{i, j};
        return null;
    }

    /** Chuẩn hóa chuỗi thành các cặp digraph theo luật Playfair. */
    private static String prepareDigraphs(String text) {
        String letters = onlyLetters(text).replace('J', 'I');
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < letters.length()) {
            char a = letters.charAt(i);
            char b = (i + 1 < letters.length()) ? letters.charAt(i + 1) : 'X';
            if (a == b) {
                sb.append(a).append('X');
                i++;
            } else {
                sb.append(a).append(b);
                i += 2;
            }
        }
        if (sb.length() % 2 != 0) sb.append('X');
        return sb.toString();
    }

    static String playfairEncrypt(String text, String key) {
        char[][] m = buildPlayfairMatrix(key);
        String prepared = prepareDigraphs(text);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < prepared.length(); i += 2) {
            char a = prepared.charAt(i), b = prepared.charAt(i + 1);
            int[] pa = findPosition(m, a), pb = findPosition(m, b);
            if (pa[0] == pb[0]) { // cùng hàng
                sb.append(m[pa[0]][(pa[1] + 1) % 5]);
                sb.append(m[pb[0]][(pb[1] + 1) % 5]);
            } else if (pa[1] == pb[1]) { // cùng cột
                sb.append(m[(pa[0] + 1) % 5][pa[1]]);
                sb.append(m[(pb[0] + 1) % 5][pb[1]]);
            } else { // hình chữ nhật
                sb.append(m[pa[0]][pb[1]]);
                sb.append(m[pb[0]][pa[1]]);
            }
        }
        return sb.toString();
    }

    static String playfairDecrypt(String text, String key) {
        char[][] m = buildPlayfairMatrix(key);
        String letters = onlyLetters(text).replace('J', 'I');
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i + 1 < letters.length(); i += 2) {
            char a = letters.charAt(i), b = letters.charAt(i + 1);
            int[] pa = findPosition(m, a), pb = findPosition(m, b);
            if (pa[0] == pb[0]) {
                sb.append(m[pa[0]][(pa[1] + 4) % 5]);
                sb.append(m[pb[0]][(pb[1] + 4) % 5]);
            } else if (pa[1] == pb[1]) {
                sb.append(m[(pa[0] + 4) % 5][pa[1]]);
                sb.append(m[(pb[0] + 4) % 5][pb[1]]);
            } else {
                sb.append(m[pa[0]][pb[1]]);
                sb.append(m[pb[0]][pa[1]]);
            }
        }
        return sb.toString();
    }

    // ============================================================
    // 5. ONE-TIME PAD (OTP)
    // Nguyên lý: khóa có độ dài bằng đúng bản rõ, dùng 1 lần duy nhất.
    // Cài đặt bằng phép cộng modulo 26 trên các ký tự chữ cái:
    //   C = (P + K) mod 26   (encrypt)
    //   P = (C - K) mod 26   (decrypt)
    // ============================================================

    private static void runOTP(Scanner sc) {
        String text = readLine(sc, "Nhập văn bản: ");
        String plainLetters = onlyLetters(text);
        String key = readLine(sc, "Nhập khóa (độ dài phải bằng số ký tự chữ cái của văn bản = "
                + plainLetters.length() + "): ");
        key = onlyLetters(key);
        if (key.length() != plainLetters.length()) {
            System.out.println("Lỗi: khóa phải có độ dài bằng đúng độ dài bản rõ (chỉ tính chữ cái)!");
            return;
        }
        int mode = chooseMode(sc);
        String result = (mode == 1) ? otpEncrypt(text, key) : otpDecrypt(text, key);
        printResult(text, key, mode, result);
    }

    static String otpEncrypt(String text, String key) {
        StringBuilder sb = new StringBuilder();
        int k = 0;
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                boolean lower = Character.isLowerCase(c);
                char base = lower ? 'a' : 'A';
                int shift = key.charAt(k) - 'A';
                sb.append((char) (base + (Character.toUpperCase(c) - 'A' + shift) % 26));
                k++;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    static String otpDecrypt(String text, String key) {
        StringBuilder sb = new StringBuilder();
        int k = 0;
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                boolean lower = Character.isLowerCase(c);
                char base = lower ? 'a' : 'A';
                int shift = key.charAt(k) - 'A';
                sb.append((char) (base + ((Character.toUpperCase(c) - 'A' - shift) + 26) % 26));
                k++;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    // ============================================================
    // 6. RAIL FENCE CIPHER
    // Nguyên lý: viết bản rõ theo hình zig-zag trên "rails" hàng,
    // sau đó đọc theo từng hàng để tạo bản mã. Giải mã: xác định lại
    // vị trí zig-zag, điền ciphertext vào đúng vị trí rồi đọc zig-zag.
    // ============================================================

    private static void runRailFence(Scanner sc) {
        String text = readLine(sc, "Nhập văn bản: ");
        int rails = readInt(sc, "Nhập số hàng (rails): ");
        if (rails < 2) {
            System.out.println("Lỗi: số hàng phải >= 2!");
            return;
        }
        int mode = chooseMode(sc);
        String result = (mode == 1) ? railFenceEncrypt(text, rails) : railFenceDecrypt(text, rails);
        printResult(text, String.valueOf(rails), mode, result);
    }

    static String railFenceEncrypt(String text, int rails) {
        StringBuilder[] fence = new StringBuilder[rails];
        for (int i = 0; i < rails; i++) fence[i] = new StringBuilder();
        int row = 0, dir = 1;
        for (char c : text.toCharArray()) {
            fence[row].append(c);
            if (row == 0) dir = 1;
            else if (row == rails - 1) dir = -1;
            row += dir;
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder line : fence) sb.append(line);
        return sb.toString();
    }

    static String railFenceDecrypt(String text, int rails) {
        int n = text.length();
        int[] rowOf = new int[n];
        int row = 0, dir = 1;
        for (int i = 0; i < n; i++) {
            rowOf[i] = row;
            if (row == 0) dir = 1;
            else if (row == rails - 1) dir = -1;
            row += dir;
        }
        // Đếm số ký tự mỗi hàng để biết cần lấy bao nhiêu ký tự từ ciphertext
        int[] rowCount = new int[rails];
        for (int i = 0; i < n; i++) rowCount[rowOf[i]]++;

        char[][] rowsChars = new char[rails][];
        int pos = 0;
        for (int r = 0; r < rails; r++) {
            rowsChars[r] = text.substring(pos, pos + rowCount[r]).toCharArray();
            pos += rowCount[r];
        }
        int[] idxInRow = new int[rails];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int r = rowOf[i];
            sb.append(rowsChars[r][idxInRow[r]++]);
        }
        return sb.toString();
    }

    // ============================================================
    // HIỂN THỊ KẾT QUẢ
    // ============================================================
    private static void printResult(String input, String key, int mode, String output) {
        System.out.println("----------------------------------------");
        if (mode == 1) {
            System.out.println("Plaintext      : " + input);
            System.out.println("Key            : " + key);
            System.out.println("Ciphertext     : " + output);
        } else {
            System.out.println("Ciphertext     : " + input);
            System.out.println("Key            : " + key);
            System.out.println("Decrypted text : " + output);
        }
        System.out.println("----------------------------------------");
    }
}