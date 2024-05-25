package Exam03;

import java.util.*;
import java.io.*;

public class Exam_1620 {
    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);

        HashMap<String, Integer> pokemonByName = new HashMap<>();
        ArrayList<String> pokemonByNumber = new ArrayList<>(N + 1);
        pokemonByNumber.add("");

        for (int i = 1; i <= N; i++) {
            String pokemonName = br.readLine();
            pokemonByName.put(pokemonName, i);
            pokemonByNumber.add(pokemonName);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String query = br.readLine();
            if (isNumeric(query)) {
                int number = Integer.parseInt(query);
                sb.append(pokemonByNumber.get(number)).append("\n");
            } else {
                sb.append(pokemonByName.get(query)).append("\n");
            }
        }

        System.out.print(sb.toString());
    }
}
