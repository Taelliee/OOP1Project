package bg.tu_varna.sit.а1.f23621652.commands;

import bg.tu_varna.sit.а1.f23621652.interfaces.Command;
import bg.tu_varna.sit.а1.f23621652.models.ShapesFile;

import java.io.IOException;
import java.util.Scanner;

public class OpenFile implements Command {
    //Всички останали команди могат да се изпълняват само ако има успешно зареден файл.
    private static String fileContent = "";

    public static String getFileContent() {
        return fileContent;
    }

    @Override
    public void execute(String[] arguments) {
        try {
            if(ShapesFile.getFile().exists()){
                Scanner reader = new Scanner(ShapesFile.getFile());
                StringBuilder data = new StringBuilder();
                while (reader.hasNextLine() ) {
                    data.append(reader.nextLine());
                }
                reader.close();
                fileContent = data.toString();
                reader.close();
                System.out.println("Successfully opened " + ShapesFile.getFile().getName());
                System.out.println(fileContent);
            }
            else {
                if (ShapesFile.getFile().createNewFile()) {
                    System.out.println("Successfully created " + ShapesFile.getFile().getName());
                } else {
                    System.out.println("Failed to create file.");
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
