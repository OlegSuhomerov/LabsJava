import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Sereliaz {
    private String fileName;

    public Sereliaz(String fileName) {
        this.fileName = fileName;
    }

    public Sereliaz() {
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public void ser(List<House> house){
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))){
            objectOutputStream.writeObject(house);
        }
        catch (IOException e) {
            System.out.println("Не записано в файл");
        }
        try {
            throw new MemoryException("Пример эксепшеона");
        } catch (MemoryException e) {
            e.printStackTrace();
        }

    }
    public List<House> deser(){
        List<House> house = new ArrayList<>();
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))){
            house = (List<House>) objectInputStream.readObject();


        }
        catch (IOException | ClassNotFoundException e){
            System.out.println("Не прочитан файл");
        }
        return house;
    }
}
