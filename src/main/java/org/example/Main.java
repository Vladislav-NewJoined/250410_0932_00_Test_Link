package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Программа запущена. Обработка CSV...");

        try {
            CsvProcessor processor = new CsvProcessor();
            String inputPath = "data/input.csv";
            String outputPath = "data/output.csv";

            // Проверка существования файлов
            if (!processor.checkFileExists(inputPath)) {
                System.err.println("Ошибка: входной файл не найден!");
                return;
            }

            // Основная обработка
            processor.process(inputPath, outputPath);

            System.out.println("Обработка успешно завершена. Результат сохранён в " + outputPath);
            System.out.println("Hello, World!");
            System.out.println("Проверяем наличие ошибок в проекте");
        } catch (IOException e) {
            System.err.println("Критическая ошибка: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Непредвиденная ошибка: " + e.getMessage());
        }
    }
}
