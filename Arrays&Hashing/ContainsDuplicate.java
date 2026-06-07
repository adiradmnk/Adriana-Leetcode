import java.util.ArrayList;
import java.util.HashSet;

public class ContainsDuplicate {
    // SOLUSI TRY I : TIME LIMIT EXCEEDED
    public boolean containsduplicate(int[] nums) {
        // bikin tempat untuk ngetrack 
        ArrayList<Integer> memory = new ArrayList<>();

        // iterasi setiap angka di nums dan ngecek apakah udah ada di memory, kalau udha ada berarti duplikasi, kalau gk ada di masukin ke memory
        for (int i : nums) {
            if (memory.contains(i)) { // dalam java contains tuh (O(N)) jadi kalau aku punya n elemen di array butuh n waktu untuk mengiterasinya, karena mengiterasi setiap iterasi berarti O(N2)
                return true;
            } else {
                memory.add(i);
            }
        }
        return false;
    }

    // SOLUSI TRY II : NOT TIME EXCEEDED
    public boolean containsDuplicate(int[] nums) {
        // struktur data yang tidak mengizinkan duplikat adalah hashset
        HashSet<Integer> map = new HashSet<Integer>();
        for (int i : nums) {
            map.add(i);
        }

        // daripada mengecek isi nya, kit amembandingkan panjang dari set dengan panjang asli nums, jika ada duplikat berarti jumlah int akan lebih besar dan tidak sama dnegan jumlah int awal
        if (map.size() == nums.length) {
            return false;
        } else {
            return true;
        }


    } 
}
