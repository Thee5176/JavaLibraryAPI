package com.thee5176.part11_file.logfile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

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
//BufferedWriter（出力用）

public class LogFileAnalyzer {
    private BufferedReader bfReader;

    private static final String TIMESTAMP_PATTERN = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}";
    private static final Pattern ERROR_LOG_PATTERN = Pattern.compile(
            "(" + TIMESTAMP_PATTERN + ").*\\[ERROR] (.*)"
    );

    public LogFileAnalyzer(){}


    //Getter
    public BufferedReader getBfReader() {
        return bfReader;
    }

    //Method
    public List<String> analyzeLog(String file) {
        //完成のデータ：Map<>
        //#1:ファイルを開く
        try {
            bfReader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.out.println("Error: ファイルを開けない。");
        }

        //#2:ログファイルを1行ごとに読み込み
        List<String> reportList = new ArrayList<>();
        try {
            String logLine;

            while( (logLine = bfReader.readLine()) != null){
                Matcher errorLog = ERROR_LOG_PATTERN.matcher(logLine);
                if ( errorLog.matches() ){
                    String timestamp = errorLog.group(1);
                    String message = errorLog.group(2);
                    reportList.add(timestamp + " - " + message);
                }
            }
        } catch (IOException e) {
            System.out.println("Error: ファイルを読めない。");
        }

        return reportList;
    }

    public void writeReport(Path outputfile, List<String> content) {
        try {
            Files.write(outputfile, content);
            System.out.println("エラーレポートファイルを作成しました：error_report.txt");
        } catch (IOException e) {
            System.out.println("Error: ファイルを作成できません。。");
        }
    }

    public static void main(String[] args) {
        Path outputFile = Paths.get("error_report.txt");
        String myLogFile = "src/main/resources/logfile.txt";

        LogFileAnalyzer analyzer = new LogFileAnalyzer();
        List<String> logList = analyzer.analyzeLog(myLogFile);

        System.out.println("エラー状態：");
        if ( !logList.isEmpty() ) {
            for (String error : logList) {
                analyzer.writeReport(outputFile, logList);
                System.out.println(error);
            }
        } else {
            System.out.println("エラーはありません。お疲れ様です。");
        }
    }
}
