import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.function.Supplier;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StudentGroup {
    private ArrayList<Student> group;

    public StudentGroup(ArrayList<Student> group) {
        this.group = group;
    }
    public StudentGroup(){
    }

    public ArrayList<Student> getGroup() {
        return group;
    }

    public void setGroup(ArrayList<Student> group) {
        this.group = group;
    }

    public void sortGroup() {
        Student temp;
        for (int i = 0; i < this.group.size(); i++)
            for (int j = i; j < this.group.size(); j++)
                if (this.group.get(i).getAverageMark() < this.group.get(j).getAverageMark()) {
                    temp = this.group.get(i);
                    this.group.set(i, this.group.get(j));
                    this.group.set(j, temp);
                }
    }

    public void publish() throws IOException {
        /*Logger logger = Logger.getLogger(StudentGroup.class.getName());
        logger.setLevel(Level.FINER);
        logger.addHandler(new FileHandler("./output.txt"));
        logger.addHandler(new ConsoleHandler());
        logger.log(Level.SEVERE,"this", this);
        logger.log(Level.SEVERE,"this", this);
        logger.log(Level.CONFIG, (Supplier<String>) this);*/
        for (int i = 0; i < this.group.size(); i++) {
            System.out.println(this.group.get(i).getName() + " " + this.group.get(i).getAverageMark());
            //logger.info("" + this.group.get(i).getName() + " " + this.group.get(i).getAverageMark());
        }

    }
    public String toJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(this);
    }

    public void publishToFile(String filePath) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        writer.write(this.toJson());
        writer.close();
    }

    public StudentGroup getFromFile(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(Files.readString(Path.of(filePath)), StudentGroup.class);
    }

}

