package secfunct;

import com.sun.net.httpserver.Authenticator;
import scanner.Scanforuser;
import utility.Context;
import utility.ComList;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static utility.ComList.*;
import static utility.ComList.getStringEnumMap;

public class Console {
    private Context userContext;
    private Scanforuser scannerInputText;

    public Console (Scanforuser scannerInputText) {
        this.scannerInputText = scannerInputText;
        userContext = new Context();
    }

    public boolean scanningProcess() {
        System.out.println("Enter the command please");
        String command = scannerInputText.nextLine();

        ComList enumCommand = getStringEnumMap().get(command);
        if (enumCommand != null) {
            switch (enumCommand) {

                case TEXT_MODE:
                case FILE_MODE:
                    if (readContext(enumCommand)) {
                        return true;
                    }
                    break;

                case NUMBER_OF_WORDS:
                    AnalyzerFunct.numWords(userContext.getInputText());
                    break;

                case NUMBER_OF_SENTENCE:
                    AnalyzerFunct.numberOfSentence(userContext.getInputText());
                    break;

                case VOWELS_AND_CONSONANTS:
                    AnalyzerFunct.consandwowels(userContext.getInputText());
                    break;

                case FIND_THE_WORD:
                    System.out.println("Write the word which u wanna find");
                    String searchWord = scannerInputText.nextLine();
                    AnalyzerFunct.findWord(userContext.getInputText(), searchWord);
                    break;

                case SORTING_BY_NUM_OF_SYM:
                    AnalyzerFunct.sorttext(userContext.getInputText());
                    break;

                case WRITE:

                    System.out.print("Input a text: ");
                    String text = scannerInputText.nextLine();
                    System.out.print("Add path: ");
                    String new_path = scannerInputText.nextLine();
                    System.out.print("Add to file: ");
                    Boolean value = scannerInputText.nextBoolean();
                    TextWriter line = new TextWriter ( new_path, value );
                    try {
                        line.fileWriter(text);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Success");
                    break;

                case NUMBER_OF_SYMBOLS:
                    AnalyzerFunct.numberOfSymbols(userContext.getInputText());
                    break;

                case HELP:
                    help();
                    break;

                case EXIT:
                    System.out.println("Bay!");
                    return true;

                default:
                    System.out.println("This command has not included into processing command list yet");
            }
        } else {
            System.out.println("The are incorrect command (help)");
        }

        return scanningProcess();
    }

    private boolean readContext(ComList command) {
        System.out.println(command.getDescription());
        String inputText = scannerInputText.nextLine();
        if ((EXIT.getShortCommand()).equals(inputText)) {
            System.out.println("Bay");
            return true;
        }
        switch (command) {
            case TEXT_MODE:
                userContext.setInputText(inputText);
                break;
            case FILE_MODE:
                readFile(inputText);
                break;
        }
        return false;
    }

    private void readFile(String filePath) {
        Path file = Paths.get(filePath);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = Files.newBufferedReader(file)) {
            String nextLine;
            while ((nextLine = bufferedReader.readLine()) != null) {
                stringBuilder.append(nextLine);
                stringBuilder.append("\n");
            }
            userContext.setInputText(stringBuilder.toString());
            System.out.print(userContext.getInputText());
            System.out.println("Successful scan");
        } catch (FileNotFoundException e) {
            System.out.println("Non-correct file path");
            readFile(scannerInputText.nextLine());
        } catch (IOException e) {
            System.out.println("Can't scanning file! Please check file settings and entering the correct file directory:");
            readFile(scannerInputText.nextLine());
        } catch (Exception e) {
            System.out.println("Something going wrong. Please try again");
        }

    }

    private void help() {
        System.out.println("This is \"text analyzer\" which can analyzing the text.\n" +
                "At first u have to choose how r u going to analyze text: from file or has entered in console.\n" +
                "After that u can choose methods to analyze\n" +
                "When the analyze has finished u may exit from applications\n" +
                "If u already had choose variable of text, please, don't enter this command: ett, efp");
        for (ComList command : ComList.values())
            System.out.println(command.toString());
    }
}