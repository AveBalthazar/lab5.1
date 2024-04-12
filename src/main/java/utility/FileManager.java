package utility;
import com.opencsv.*;
import data.Coordinates;
import data.*;
import exception.CollectionException;
import exception.NullEnvException;

import java.io.*;
import java.util.Collection;
import java.util.Scanner;

import static utility.UniversalUtility.CommandFormat;

/**
 * Класс управляет записью/чтением из файлов
 */
public class FileManager {
    /**
     * Переменная окружения
     */
    private String env;
    protected void setEnv(String env) {this.env = env;}
    public String getEnv() {return this.env;}
    private static FileManager FILE_MANAGER = new FileManager();
    public static FileManager getInstance() {
        return FILE_MANAGER;
    }
    private utility.CollectionManager collectionManager = JavaCollectionManager.getInstance();
    /**
     * Сохранить коллекцию в файл
     */
    public void saveCollection() throws IOException {
        BufferedWriter bWriter;
        CSVWriter writer = null;
        try {
            if (System.getenv(env) == null) throw new NullEnvException();
            OutputStream os = new FileOutputStream(System.getenv(env));
            bWriter = new BufferedWriter(new OutputStreamWriter(os));
            char escaped_character = CSVWriter.NO_QUOTE_CHARACTER;
            char separator = CSVWriter.DEFAULT_SEPARATOR;
            writer = new CSVWriter(bWriter,
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.NO_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END
            );
            writer.writeAll(JavaCollectionManager.getStringStudyGroupCollection());
        } catch (NullEnvException | FileNotFoundException e) {
            System.out.println(e.toString());
        } finally {
            writer.close();
            System.out.println("Коллекция успешно сохранена в " + System.getenv(env) + ".");
            collectionManager.saveTimeCollection();
        }
    }

    /**
     * Загрузить коллекцию из файла
     */
    public void readCollection() {
        BufferedReader reader = null;
        String[] line;
        try {
            if (System.getenv(env) == null) throw new NullEnvException();
            reader = new BufferedReader(new FileReader(System.getenv(env)));
            CSVParser parser = new CSVParserBuilder()
                    .withSeparator(',')
                    .withIgnoreQuotations(true)
                    .build();
            CSVReader csvReader = new CSVReaderBuilder(reader)
                    .withSkipLines(0)
                    .withCSVParser(parser)
                    .build();
            while ((line = csvReader.readNext()) != null) {
                for (int i = 0; i < line.length; i++) {
                    line[i] = line[i].trim().toLowerCase();
                }
                if (line.length != 16) {
                    throw new CollectionException();
                }
                collectionManager.getStudyGroupCollection().add(new StudyGroup(line[0], line[1],
                        new Coordinates(Long.parseLong(line[2]), Long.parseLong(line[3])), line[4],
                        Long.parseLong(line[5]), Integer.parseInt(line[6]), UniversalUtility.findFormOfEducationByKey(CommandFormat(line[7])),
                        UniversalUtility.findSemesterByKey(CommandFormat(line[8])), new Person(line[9], Double.parseDouble(line[10]), line[11],
                        new Location(Long.parseLong(line[12]), Float.parseFloat(line[13]), Long.parseLong(line[14]), line[15]))));
            }
        } catch (NullEnvException e) {
            System.out.println(e.toString());
        } catch (CollectionException e) {
            System.out.println(e.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println(e.toString());
            }
        }
    }

    /**
     * Выполнить скрипт из файла
     *
     * @param fileName
     */
    public void readScript(String fileName) {
        BufferedReader reader = null;
        try {
            File file = new File(fileName);
            reader = new BufferedReader(new FileReader(file));
            InputStream fileInput = new FileInputStream(file);
            Scanner userScanner = new Scanner(fileInput);
            ConsoleManager.setUserScanner(userScanner);
            while ((reader.readLine()) != null) {
                ConsoleManager.interactiveMode();
            }
            userScanner = new Scanner(System.in);
            ConsoleManager.setUserScanner(userScanner);
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println(e.toString());
            }
        }
    }

}