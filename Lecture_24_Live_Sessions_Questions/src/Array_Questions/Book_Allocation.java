package Array_Questions;
import java.util.Scanner;

public class Book_Allocation {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int nob = scn.nextInt();
        int nos = scn.nextInt();

        int[] pages = new int[nob];

        for (int i = 0; i < pages.length; i++) {
            pages[i] = scn.nextInt();
        }

        // logic
        int lo = 0;
        int hi = 0;
        for (int val : pages) {
            hi += val;
        }

        int ans = 0;

        while (lo <= hi) {

            int mid = (lo + hi) / 2;

            if (is_It_Possible(pages, nos, mid)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        System.out.println(ans);
    }

    public static boolean is_It_Possible(int[] pages, int nos, int mid) {
        int students = 1;
        int pagesRead = 0;

        int i = 0; // I denote the book which is to be read.

        while (i < pages.length) {
            if (pagesRead + pages[i] <= mid) {
                pagesRead += pages[i];
                i++;
            } else {
                students ++;
                pagesRead = 0;
            }
            if (students > nos) {
                return false;
            }
        }
        return true;
    }
}