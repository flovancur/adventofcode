import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

class Main {

    public boolean checkDecreasing(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] < arr[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean checkIncreasing(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean checkSafetyArray(int[] arr) {
        if (checkDecreasing(arr)) {
            for (int i = 1; i < arr.length; i++) {
                if (
                    arr[i - 1] - arr[i] < 1 || arr[i - 1] - arr[i] > 3
                ) return false;
            }
        }
        if (checkIncreasing(arr)) {
            for (int i = 1; i < arr.length; i++) {
                if (
                    arr[i - 1] - arr[i] > -1 || arr[i - 1] - arr[i] < -3
                ) return false;
            }
        }

        if (!checkDecreasing(arr) && !checkIncreasing(arr)) return false;

        return true;
    }

    public static void main(String[] args) {
        Main element = new Main();
        List<int[]> arrays = new ArrayList<int[]>();
        int count = 0;
        try {
            String filePath =
                "/home/florian/Dokumente/Development/AdventRiddles/data_day_2.txt";
            Path path = Path.of(filePath, args);
            List<String> lines = Files.readAllLines(path);

            lines.forEach(ele -> {
                String[] temp = ele.split(" ");
                int[] tempInt = new int[temp.length];
                for (int i = 0; i < temp.length; i++) {
                    tempInt[i] = Integer.parseInt(temp[i]);
                }
                arrays.add(tempInt);
            });
            for (int i = 0; i < arrays.get(4).length; i++) {
                System.out.println(arrays.get(4)[i]);
            }
            for (int[] e : arrays) {
                System.out.println(element.checkSafetyArray(e));
                if (element.checkSafetyArray(e)) {
                    count++;
                }
            }
            System.err.println(count);
        } catch (Exception e) {
            System.out.println("Ein fehler ist aufgetreten.");
        }
    }
}
