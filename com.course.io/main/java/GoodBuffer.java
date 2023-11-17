import java.io.*;

public class GoodBuffer {
// читаем пишем через буфер

    public static void main(String[] args) {
    File file = new File("C:\\Users\\User\\IdeaProjects\\AutomaticQA\\test");


        try (
                FileReader fis = new FileReader(file); //true fos добавляем текст к сущесвующиму в файле
                FileWriter fos = new FileWriter("newFile.txt");
                BufferedReader br = new BufferedReader(fis);
                BufferedWriter bw = new BufferedWriter(fos))
        {
            StringBuilder builderStr= new StringBuilder();

            int i;
            while ((i=br.read())!=-1){
                builderStr.append((char) i);
            }
            bw.write(builderStr.toString());


            }catch (IOException ex){
                ex.printStackTrace();
            }
}
}
