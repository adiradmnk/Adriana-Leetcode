package LatihanUASDDP2.Praktikum6;

public class ExceptionPuzzle {
    public static void main(String[] args) {
        try {
            m1();// mencoba dulu exception untuk pertama 
        } catch (Exception e) {
            System.out.print(" UYEE");
        }
    }

    public static void m1() throws Exception { // Soal A
        try {
            m2(); // mengerjakan dulu m2
        } catch (NullPointerException e) {
            System.out.print(" FASILKOM");
            throw new RuntimeException();
        } finally {
            System.out.print(" BANGET");
        }
    }

    public static void m2() {
        try {
            m3(); // mengerjakna dulu m3
        } catch (IndexOutOfBoundsException e) { // Soal B
            System.out.print(" CINTA");
            throw new NullPointerException();
        // Sesuatu harus dilakukan di sini agar lanjut ke m1
        }
    }

    public static void m3() {
        try {
            System.out.print("SAYA"); //print SAY
            m4(); // mengerjakan m4
        } catch (ArithmeticException e) {
            throw new IndexOutOfBoundsException();
        } finally {
            // Logic finally
        }
    }

    public static void m4() {
        throw new ArithmeticException(); // Soal C
    }
}
