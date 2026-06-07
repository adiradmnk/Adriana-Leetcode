// problem menentukan apakah dua string merupakan anagram
import java.util.ArrayList;
import java.util.Arrays;
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        // pertama kita menentukan setiap karakter dalam stringnya
        char[] listCharS = s.toCharArray();

        // terus kita akan nge samain setiap karakter 
        char[] listCharT = t.toCharArray();

        // cek size kedua string 
        int jumlahS = listCharS.length;
        int jumlahT = listCharT.length;
        if (jumlahS != jumlahT) {
            return false;
        }

        // ubah list character menjadi arraylist
        ArrayList<Character> listS = new ArrayList<>();
        ArrayList<Character> listT = new ArrayList<>();
        for (char i : listCharS) {
            listS.add(i);
        }

        for (char i : listCharT) {
            listT.add(i);
        }

        // membandingkan setiap characternya 
        for (char n : listS) {
            if (listT.contains(n)) {
                int index = listT.indexOf(n);
                listT.remove(index);
            } else {
                return false;
            }
        }
        return true;

    }
}
