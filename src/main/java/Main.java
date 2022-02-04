import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        StudentGroup f = new StudentGroup(); //костыль, этот объект нужен для вызова getFromFile()
        StudentGroup IT11Z = f.getFromFile("input.txt"); //несортированный
        IT11Z.publish();
        IT11Z.sortGroup(); //сортировка по убыванию
        IT11Z.publish();
        IT11Z.publishToFile("output.txt");
    }
}

