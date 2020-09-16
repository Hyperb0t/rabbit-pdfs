package ru.itis.services;

import ru.itis.models.Passport;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class PassportGenerator {

    private final static int FEMALE = 0;
    private final static int MALE = 1;
    private List<List<String>> genderSplitNames;
    private List<List<String>> genderSplitSurnames;
    private Random r = new Random();

    public PassportGenerator() {
        try {
            genderSplitNames = new ArrayList<>();
            genderSplitNames.add(Files.readAllLines(Paths.get("names_f.txt")));
            genderSplitNames.add(Files.readAllLines(Paths.get("names_m.txt")));

            genderSplitSurnames = new ArrayList<>();
            genderSplitSurnames.add(Files.readAllLines(Paths.get("surnames_f.txt")));
            genderSplitSurnames.add(Files.readAllLines(Paths.get("surnames_m.txt")));
        }
        catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public Passport generate() {
        int gender = r.nextInt(2);
        String name = genderSplitNames.get(gender).get(r.nextInt(genderSplitNames.get(gender).size()));
        String surname = genderSplitSurnames.get(gender).get(r.nextInt(genderSplitSurnames.get(gender).size()));
        Integer age = 18 + r.nextInt(52);
        Date given = Date.from(Instant.now().minus(Duration.ofDays(r.nextInt(365*30))));
        int series = 1000 + r.nextInt(8999);
        int number = 100000 + r.nextInt(899999);
        return Passport.builder()
                .name(name)
                .surname(surname)
                .age(age)
                .passportSeries(series)
                .passportNumber(number)
                .passportGiven(given)
                .build();
    }
}
