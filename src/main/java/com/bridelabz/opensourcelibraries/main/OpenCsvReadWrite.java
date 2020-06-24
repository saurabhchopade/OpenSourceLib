package com.bridelabz.opensourcelibraries.main;

import com.bridelabz.opensourcelibraries.util.OpenCsv;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class OpenCsvReadWrite {
    private static final String FILE = "/home/saurabh/IdeaProjects/OpenSourceLibraries/src/main/java/com/bridelabz/opensourcelibraries/main/data.csv";
    private static final String FILE1 = "/home/saurabh/IdeaProjects/OpenSourceLibraries/src/main/java/com/bridelabz/opensourcelibraries/main/newData.csv";

    public static void main(String[] args) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {

        try (
                Reader reader = Files.newBufferedReader(Paths.get(FILE));
                //  CSVReader csvReader = new CSVReader(reader);
        ) {
            CsvToBean<OpenCsv> csvToBean = new CsvToBeanBuilder(reader).withType(OpenCsv.class).withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<OpenCsv> csvIterator = csvToBean.iterator();
            while (csvIterator.hasNext()) {
                OpenCsv openCsv = csvIterator.next();
                System.out.println("Name = " + openCsv.getName());
                System.out.println("Email = " + openCsv.getEmail());
                System.out.println("Phone = " + openCsv.getPhoneNo());
                System.out.println("Country = " + openCsv.getCountry());
                System.out.println("++++++++++++++++++++++++++++++++++");
            }
            try (
                    Writer writer = Files.newBufferedWriter(Paths.get(FILE1));

                    CSVWriter csvWriter = new CSVWriter(writer,
                            CSVWriter.DEFAULT_SEPARATOR,
                            CSVWriter.NO_QUOTE_CHARACTER,
                            CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                            CSVWriter.DEFAULT_LINE_END);
            ) {
                String[] coulumName = {"Name", "Email", "Phone", "Country"};
                csvWriter.writeNext(coulumName);

                csvWriter.writeNext(new String[]{"raj shekhar", "123@gmail.com", "111111111", "India"});
                csvWriter.writeNext(new String[]{"sam waikar", "sam@outlook.com", "+1-1111111112", "India"});
            }

        }
    }
}

