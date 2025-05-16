package com.thee5176.part10_exception.filereader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//話題：チェーン例外
public class FileProcess {
    private BufferedReader bf;

    public FileProcess(){};

    public void readFile(String filename) throws ProcessingException {
        //ファイルを開く
        try {
            filename = "src/main/resources/" + filename;
            bf = new BufferedReader(new FileReader(filename));
        } catch(FileNotFoundException e){
            throw new ProcessingException("Error: ファイルを開けない。" , e);
        }

        //ファイルを読み込む
        try {
            while(bf.ready()) {
                String file = bf.readLine();
                System.out.println(file);
            }
        } catch(IOException e){
            throw new ProcessingException("Error: ファイルを読めない。", e);
        }
    }


    public static void main(String[] args) {
        FileProcess myProcessor = new FileProcess();
        try {
            myProcessor.readFile("notfound.txt");
        } catch (ProcessingException e){
            System.out.println("キャッチされた例外: " + e.getClass());
            System.out.println("例外の原因：" + e.getCause());
        }

        try {
            myProcessor.readFile("file.txt");
        } catch (ProcessingException e){
            System.out.println("キャッチされた例外: " + e.getClass());
            System.out.println("例外の原因：" + e.getCause());
        }
    }
}
