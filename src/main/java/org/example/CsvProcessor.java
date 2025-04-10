package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class CsvProcessor {

    public boolean checkFileExists(String filePath) {
        return Files.exists(Paths.get(filePath));
    }

    public void process(String inputPath, String outputPath) throws IOException {
        // 1. Чтение файла
        List<String> lines = readFile(inputPath);
        System.out.println("Прочитано строк: " + lines.size());

        // 2. Обработка данных (пример: удаление пустых строк)
        List<String> processedLines = lines.stream()
                .filter(line -> !line.trim().isEmpty())
                .toList();

        // 3. Запись результата
        writeFile(outputPath, processedLines);
    }

    private List<String> readFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        return Files.readAllLines(path);
    }

    private void writeFile(String filePath, List<String> lines) throws IOException {
        Path path = Paths.get(filePath);

        // Создаём директории, если их нет
        Files.createDirectories(path.getParent());

        // Записываем данные с перезаписью существующего файла
        Files.write(
                path,
                lines,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING
        );
    }
}
