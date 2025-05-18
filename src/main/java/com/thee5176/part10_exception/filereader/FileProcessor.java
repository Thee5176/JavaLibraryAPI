package com.thee5176.part10_exception.filereader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//目的: サーバーログファイルを解析し、タイムスタンプとエラーメッセージを抽出してレポートを作成する。

//手順:
//ログファイルを1行ずつ読み込む。
//正規表現（Pattern と Matcher）でタイムスタンプとエラーメッセージを抽出。
//抽出したデータを新しいファイルに書き出す。

//ヒント:
//タイムスタンプ用の正規表現例: \d{4}-\d{2}-\d{2} \d{2}:\d{2}:\d{2}
//Files.write() で簡単にファイル書き込みが可能。

//必要なツール:
//java.util.regex（正規表現）

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
