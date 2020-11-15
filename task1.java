
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;




public class task1 {
    public static void main(String[] args) throws IOException {
        ArrayList<String> list1 = new ArrayList<String>();

        BufferedReader reader = new BufferedReader(new FileReader("test2"));        // чтение из файла данных и запись в коллекцию
        String str;
        while ((str = reader.readLine()) != null) {
            if (!str.isEmpty()) {
                list1.add(str);
            }
        }
        ArrayList<Integer> newList = new ArrayList<Integer>();
        for(int i = 0; i < list1.size(); i++) {
            newList.add(Integer.parseInt(list1.get(i)));
        }
        String maxRes = new DecimalFormat("#0.00").format(Collections.max(newList));
        String minRes = new DecimalFormat("#0.00").format(Collections.min(newList));
        String averRes = new DecimalFormat("#0.00").format(average(newList));
        String medianRes = new DecimalFormat("#0.00").format(getMedian(newList));
        String percRes = new DecimalFormat("#0.00").format(percentile(newList,90));
        System.out.println(percRes+"\n");
        System.out.println(medianRes+"\n");
        System.out.println(maxRes+ "\n");
        System.out.println(minRes+ "\n");
        System.out.println(averRes+"\n");

    }
    public static Double average(ArrayList<Integer> newList) {  // среднее значение
        int sum = 0;
        for (int i=0; i< newList.size(); i++) {
            sum += newList.get(i);
        }
        double avg =(double) sum/newList.size();
        return avg;
    }
    public static double getMedian(ArrayList<Integer> newList) {
        Collections.sort(newList);
        int middle = newList.size() / 2;
        middle = middle > 0 && middle % 2 == 0 ? middle - 1 : middle;
        return newList.get(middle);
    }
    public static double percentile(ArrayList<Integer> newList, double percentile) {
        Collections.sort(newList);
        double n = (double)((percentile*(newList.size()-1)/100)+1);
        int index = (int) n;
        double valueP1 = (double)(newList.get(index)+(n-index)*(newList.get(index)));
        return valueP1;
    }
    /*
    double valueP1 = (double)(newList.get(index)+(n-index)*(newList.get(index+1)-newList.get(index)));
   */


}