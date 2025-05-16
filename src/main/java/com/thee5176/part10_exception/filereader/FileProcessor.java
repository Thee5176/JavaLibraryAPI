package com.thee5176.part10_exception.filereader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//話題：チェーン例外
public class FileProcessor {
    private BufferedReader bf;

    public static void readFile(String filename) throws ProcessingException {
        //ファイルを開く
        String fullPath = "src/main/resources/" + filename;
        try (BufferedReader bf = new BufferedReader(new FileReader(fullPath));) {

            String line;
            while((line = bf.readLine()) != null) {
                System.out.println(line);
            }

        } catch(FileNotFoundException e){
            throw new ProcessingException("ファイルが見つかりません。"+ fullPath , e);
        } catch(IOException e){
            throw new ProcessingException("ファイル読み込みエラー。", e);
        }
    }


    public static void main(String[] args) {
        try {
            FileProcessor.readFile("notfound.txt");
        } catch (ProcessingException e){
            System.out.println("キャッチされた例外: " + e.getClass());
            System.out.println("例外の原因：" + e.getCause());
        }

        try {
            FileProcessor.readFile("file.txt");
        } catch (ProcessingException e){
            System.out.println("キャッチされた例外: " + e.getClass());
            System.out.println("例外の原因：" + e.getCause());
        }
    }
}
