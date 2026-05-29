// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// You can return the answer in any order.
// Example 1:
// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

// jadi dikasih sebuah array yang bentuknya integer dan 
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] hasil = new int[2]; // ini tempat penyimpanan untuk hasil
        // iterasi untuk setiap angka dalam array yang diberikan 
        for (int i = 0; i < nums.length; i++) {
            int n = target - nums[i]; // nyimpen dulu untuk angka yang harus ditemukan sebagai pasangan 
            // mencari angka n
            for (int k = i + 1; k < nums.length; k++) {
                // kalau angkanya sama menyimpan indeks utnuk angka pertama dan angka kedua di array, dan return array tersebut
                if (nums[k] == n) {
                    hasil[0] = i;
                    hasil[1] = k;
                } else { // kalau gk ketemu lanjut
                    continue;
                }
            }
        }
        return hasil;
    }
}
