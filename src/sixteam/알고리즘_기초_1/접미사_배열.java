package sixteam.알고리즘_기초_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class 접미사_배열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < S.length(); i++) {
            list.add(S.substring(i));
        }

        Collections.sort(list);

        for (String s : list) {
            System.out.println(s);
        }
    }
}
