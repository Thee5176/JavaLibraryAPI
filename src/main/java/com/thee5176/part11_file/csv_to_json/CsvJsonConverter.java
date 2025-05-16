package com.thee5176.part11_file.csv_to_json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class CsvJsonConverter {
    public CsvJsonConverter(){}

    public static void parseUser(String filename) {
        //ファイル読み込み：try-with-resource
        String fullPath = "src/main/resources/" + filename;
        try (BufferedReader bf = new BufferedReader(new FileReader(fullPath));) {
            List<User> userList = new ArrayList<>();
            String line;
            while((line = bf.readLine()) != null) {
                String[] para = line.split(",");
                String json = new User(para[0], para[1], para[2], para[3]).toString();
                System.out.println(json);
            }
        } catch(FileNotFoundException e) {
            System.out.println("ファイルが見つかりません。"+ fullPath);
        } catch(IOException e) {
            System.out.println("ファイル読み込みエラー。");
        }
    }

    public static void main(String[] args){
        CsvJsonConverter.parseUser("user.csv");
    }
}
