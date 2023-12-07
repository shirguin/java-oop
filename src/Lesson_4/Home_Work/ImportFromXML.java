package Lesson_4.Home_Work;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImportFromXML {
    public List<Task> tasks = new ArrayList<>();

    public ImportFromXML(File fName) {
        try (Scanner reader = new Scanner(new BufferedReader(new FileReader(fName)))) {
            StringBuilder stringBuilder = new StringBuilder();
            while (reader.hasNext()) {
                stringBuilder.append(reader.nextLine());
            }
            String str = stringBuilder.toString();
            str = str.replace("\n", "");
            int startIndex = 0;
            while (startIndex < str.length()) {
                int index1 = str.indexOf("<", startIndex);
                int index2 = str.indexOf(">", index1);
                String temp = new String();
                if (index1 < 0) {
                    index2 = str.length();
                    temp = "endOfFile";
                } else {
                    temp = str.substring(index1, index2 + 1);
                }

                if (temp.equals("<task>")) {
                    LocalDate createData = LocalDate.now();
                    LocalDate deadLine = LocalDate.now();
                    LocalTime createTime = LocalTime.now();
                    String author = new String();
                    String description = new String();
                    boolean taskNotEnded = true;
                    while (taskNotEnded) {
                        int tagIndexStart = str.indexOf("<", index2 + 1);
                        int tagIndexStop = str.indexOf(">", tagIndexStart);
                        String tag = str.substring(tagIndexStart, tagIndexStop + 1);
                        int nextTag = str.indexOf("<", tagIndexStop);
                        String tagValue = str.substring(tagIndexStop + 1, nextTag);
                        switch (tag) {
                            case ("<createDate>") -> {
                                createData = LocalDate.parse(tagValue);
                                index2 = nextTag + tag.length();
                            }
                            case ("<createTime>") -> {
                                createTime = LocalTime.parse(tagValue);
                                index2 = nextTag + tag.length();
                            }
                            case ("<deadline>") -> {
                                deadLine = LocalDate.parse(tagValue);
                                index2 = nextTag + tag.length();
                            }
                            case ("<author>") -> {
                                author = tagValue;
                                index2 = nextTag + tag.length();
                            }
                            case ("<taskDescription>") -> {
                                description = tagValue;
                                index2 = nextTag + tag.length();
                            }
                            case ("</task>") -> {
                                taskNotEnded = false;
                                index2 = tagIndexStop;
                            }
                        }

                    }

                    tasks.add(new Task(createData, createTime, deadLine, author, description));
                }
                startIndex = index2;
            }
            TaskTree.addAll(tasks);

        } catch (Exception e) {
            System.out.println("Ups! Tasks wasn`t imported from disk");
            System.out.println(e);
        }
    }
}