import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Task3 {
    private static ArrayList<String> readFile(String fileName) throws IOException {
        ArrayList<String> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String str = "";
        while ((str = reader.readLine()) != null) {
            if (!str.isEmpty()) {
                list.add(str);
            }
        }

        return list;
    }

    private static ArrayList<Double> convertList(ArrayList<String> list) {
        ArrayList<Double> newList = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            newList.add(Double.parseDouble(list.get(i)));
        }

        return newList;
    }


    public static Double maxVisitors(ArrayList<Double> ... arrayLists) {
        Double temp = 0.0;
        int place = 0;

        for(ArrayList<Double> info : arrayLists) {
            for (int i = 0; i < info.size(); i++) {
                if (info.get(i)>temp){
                    temp=info.get(i);
                    place = i+1;
                }
            }
            System.out.println(place);
        }
        return temp;
    }

    public static void main(String[] args) throws IOException {

        ArrayList<Double> cash1 = convertList(readFile("Cash1.txt"));
        ArrayList<Double> cash2 = convertList(readFile("Cash2.txt"));
        ArrayList<Double> cash3 = convertList(readFile("Cash3.txt"));
        ArrayList<Double> cash4 = convertList(readFile("Cash4.txt"));
        ArrayList<Double> cash5 = convertList(readFile("Cash5.txt"));

        ArrayList<Double> sumList = new ArrayList<>();
        for(int i = 0; i < cash1.size(); i++) {
            sumList.add(cash1.get(i) + cash2.get(i) + cash3.get(i) + cash4.get(i) + cash5.get(i));
        }

        maxVisitors(sumList);
    }
}