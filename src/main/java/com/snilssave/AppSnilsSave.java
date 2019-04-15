package com.snilssave;

import com.snilssave.service.SnilsParser;

import java.io.File;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AppSnilsSave {
    public static void main(String[] args) throws Exception {
        SnilsParser snilsParser = new SnilsParser();
        //Path path = Paths.get("C:\\SmevAdapter\\integration\\files\\542202_3s\\in\\snils");
        Path path = Paths.get("\\\\Srv-term03\\542202_3s\\in\\snils");
        File oiFile;
        while(true){
            DirectoryStream<Path> stream  = Files.newDirectoryStream(path);
            for(Path file : stream){
                oiFile = file.toFile();
                try {
                    if (oiFile.isFile() && oiFile.canRead()) {
                        //ToDo add loging
                        System.out.println(oiFile.getName());
                        snilsParser.snilsDataParser(oiFile);

                        //Files.copy(file, Paths.get("C:\\SmevAdapter\\integration\\files\\542202_3s\\in\\snilsSaved" + File.separator + file.getFileName().toString()));
                        Files.copy(file, Paths.get("\\\\Srv-term03\\542202_3s\\in\\snilsSaved" + File.separator + file.getFileName().toString()));
                        Files.delete(file);
                    }
                } catch (Exception e){
                    //ToDo add loging
                    System.out.println("Есть не обрабатываемые файлы. Проверь папку snilsError");
                    //Files.copy(file, Paths.get("C:\\SmevAdapter\\integration\\files\\542202_3s\\in\\snilsError" + File.separator + file.getFileName().toString()));
                    Files.copy(file, Paths.get("\\\\Srv-term03\\542202_3s\\in\\snilsError" + File.separator + file.getFileName().toString()));
                    Files.delete(file);
                } finally {
                    stream.close();
                }
            }
        }
    }
}
