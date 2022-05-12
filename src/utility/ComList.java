package utility;

import java.util.HashMap;

public enum ComList {  // enum - класс с перечислением констант
    HELP ("help", "Enter for help commands"),
    TEXT_MODE("ett", "Enter the text and analyze it"),
    FILE_MODE("efp", "Enter text-file path like \"C:\\\\Users\\\\iantaman\\\\Desktop\\\\new 1.txt\" and analyze it"),
    FIND_THE_WORD ("ftw", "find word"),
    NUMBER_OF_WORDS("now", "Numbers of words"),
    NUMBER_OF_SENTENCE("nos", "Numbers of sentence"),
    VOWELS_AND_CONSONANTS("nvc", "Numbers of vowels and consonants"),
    NUMBER_OF_SYMBOLS("numsym", "To find the word"),
    SORTING_BY_NUM_OF_SYM("srtfsym","Sorting text by number of symbols"),
    EXIT("exit", "Exit from applications"),
    WRITE("wr","write to file");


    private String description;
    private String shortCommand;

    ComList(String shortCommand, String description) {
        this.shortCommand = shortCommand; //*  this позволяет не вводить новые переменные для обозначения одного и того же
        this.description = description;

    }
    public String getDescription() {

        return description;
    }

    public String getShortCommand() {

        return shortCommand;
    }
    private static HashMap<String, ComList> stringEnumMap = new HashMap<String, ComList>();

    static {
        for (ComList e : ComList.values()) {
            if (e.getShortCommand() != null) {
                stringEnumMap.put(e.getShortCommand(), e);
            } else {
                stringEnumMap.put(e.getDescription().toLowerCase(), e);
            }
        }
    }

    public static HashMap<String, ComList> getStringEnumMap() {
        return stringEnumMap;
    }

    @Override
    public String toString() {
        return shortCommand + "(description)" + "=" + description; //
    }
}
