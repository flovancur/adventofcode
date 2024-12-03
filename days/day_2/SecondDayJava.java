import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main {

    public boolean checkDecreasing(List<Integer> arr) {
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i - 1) < arr.get(i)) return false;
        }
        return true;
    }

    public boolean checkIncreasing(List<Integer> arr) {
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i - 1) > arr.get(i)) return false;
        }
        return true;
    }

    public boolean checkSafetyArray(List<Integer> arr) {
        if (checkDecreasing(arr)) {
            for (int i = 1; i < arr.size(); i++) {
                if (arr.get(i - 1) - arr.get(i) < 1 || arr.get(i - 1) - arr.get(i) > 3) return false;
            }
            return true;
        }

        if (checkIncreasing(arr)) {
            for (int i = 1; i < arr.size(); i++) {
                if (arr.get(i - 1) - arr.get(i) > -1 || arr.get(i - 1) - arr.get(i) < -3) return false;
            }
            return true;
        }

        return false;
    }

    public boolean isSafeWithOneRemoval(List<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            List<Integer> modifiedArr = new ArrayList<>(arr);
            modifiedArr.remove(i);
            if (checkSafetyArray(modifiedArr)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Main element = new Main();
        List<Integer[]> arrays = new ArrayList<>();
        int count = 0;

        try {
            String filePath = "data_day_2.txt";
            Path path = Path.of(filePath);
            List<String> lines = Files.readAllLines(path);

            for (String line : lines) {
                String[] temp = line.split(" ");
                Integer[] tempInt = new Integer[temp.length];
                for (int i = 0; i < temp.length; i++) {
                    tempInt[i] = Integer.parseInt(temp[i]);
                }
                arrays.add(tempInt);
            }

            for (Integer[] e : arrays) {
                List<Integer> list = Arrays.asList(e);
                if (element.checkSafetyArray(list) || element.isSafeWithOneRemoval(list)) {
                    count++;
                }
            }

            System.out.println(count);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
