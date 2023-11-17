import java.io.*;

public class Main {
    static void print(){
        System.out.println("");
    }
    public static void main(String[] args) {
        print();
        File file = new File("C:\\Users\\User\\IdeaProjects\\AutomaticQA\\test");


        try (
                FileInputStream fis = new FileInputStream(file); //true fos добавляем текст к сущесвующиму в файле
                FileOutputStream fos = new FileOutputStream("C:\\Users\\User\\IdeaProjects\\AutomaticQA\\newFile",true);) {

            if (fis.available()>0) {
                try(BufferedInputStream red = new BufferedInputStream(fis);
                BufferedOutputStream wr= new BufferedOutputStream(fos)) {
                    int x;
                    while ((x = red.read()) != -1) {
                        System.out.print((char) x);
                        wr.write(x);
                    }
                }catch (IOException ex){
                    ex.printStackTrace();
                }

            }


        } catch (Exception e) {

        }

    }
}
