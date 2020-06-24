package com.bridelabz.opensourcelibraries.main;

import com.bridelabz.opensourcelibraries.util.MyUser;
import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CsvToJson {
    private static final String CSVFILENAME = "/home/saurabh/IdeaProjects/OpenSourceLibraries/src/main/java/com/bridelabz/opensourcelibraries/main/data.csv";
    static String JSONFILENAME = "/home/saurabh/IdeaProjects/OpenSourceLibraries/src/main/java/com/bridelabz/opensourcelibraries/main/jsonData.csv";

    public static void main(String[] args) throws IOException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(CSVFILENAME));
            CsvToBeanBuilder<MyUser> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(MyUser.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<MyUser> csvToBean = csvToBeanBuilder.build();
            List<MyUser> myUsers = csvToBean.parse();
            Gson gson = new Gson();
            String json = gson.toJson(myUsers);
            FileWriter writer = new FileWriter(JSONFILENAME);
            writer.write(json);
            writer.close();
        } catch (IOException e) {

        }

    }
}
