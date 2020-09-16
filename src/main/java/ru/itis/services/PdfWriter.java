package ru.itis.services;

import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;
import ru.itis.models.Passport;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.UUID;

public class PdfWriter {

    private final String FOLDER = "pdfs";
    private final SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

    public PdfWriter() {
    }

    public void writeOtchislPdf(Passport passport) {
        try {
            File pdf = new File(
                    FOLDER + "/otchisl/" + passport.getSurname() + "_" + UUID.randomUUID() + ".pdf");
            pdf.getParentFile().mkdirs();
            pdf.createNewFile();
            com.itextpdf.kernel.pdf.PdfWriter writer = new com.itextpdf.kernel.pdf.PdfWriter(pdf);
            PdfDocument pdfDocument = new PdfDocument(writer);
            Document document = new Document(pdfDocument);

            Paragraph textParagraph = new Paragraph();
            Paragraph headerParagraph = new Paragraph().setFontSize(16);

            String fontPath = getClass().getClassLoader().getResource("tnr.ttf").getPath();
            PdfFont timesNewRoman = PdfFontFactory.createFont(fontPath, "CP1251", true);

            document.setFont(timesNewRoman);
            document.setFontSize(14);

            headerParagraph.setBold();
            headerParagraph.setTextAlignment(TextAlignment.CENTER);
            headerParagraph.add("Заявление");

            textParagraph.add("Я, ");
            Text fio = new Text(passport.getSurname() + " " + passport.getName()).setUnderline();
            textParagraph.add(fio);
            textParagraph.add(" , прошу отчислить меня по собственному желанию.");

            Paragraph dataParagraph = new Paragraph();
            dataParagraph.add("Возраст: ");
            Text age = new Text(passport.getAge().toString()).setUnderline();
            dataParagraph.add(age);
            dataParagraph.add("\nПаспорт: ");
            Text passp = new Text(passport.getPassportSeries().toString() + " " + passport.getPassportNumber().toString()).setUnderline();
            dataParagraph.add(passp);
            dataParagraph.add("\nВыдан: ");
            Text dateGiven = new Text(format.format(passport.getPassportGiven())).setUnderline();
            dataParagraph.add(dateGiven);
            Paragraph credentialsParagraph = new Paragraph();
            credentialsParagraph.add("\nПодпись ________________");
            credentialsParagraph.add("\n\n");
            credentialsParagraph.add("Дата _____________________");

            document.add(headerParagraph);
            document.add(textParagraph);
            document.add(dataParagraph);
            document.add(credentialsParagraph);

            document.close();

        }catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public void writeMatpomoshPdf(Passport passport) {
        try {
            File pdf = new File(
                    FOLDER + "/matpomosh/" + passport.getSurname() + "_" + UUID.randomUUID() + ".pdf");
            pdf.getParentFile().mkdirs();
            pdf.createNewFile();
            com.itextpdf.kernel.pdf.PdfWriter writer = new com.itextpdf.kernel.pdf.PdfWriter(pdf);
            PdfDocument pdfDocument = new PdfDocument(writer);
            Document document = new Document(pdfDocument);

            Paragraph textParagraph = new Paragraph();
            Paragraph headerParagraph = new Paragraph().setFontSize(16);

            String fontPath = getClass().getClassLoader().getResource("tnr.ttf").getPath();
            PdfFont timesNewRoman = PdfFontFactory.createFont(fontPath, "CP1251", true);

            document.setFont(timesNewRoman);
            document.setFontSize(14);

            headerParagraph.setBold();
            headerParagraph.setTextAlignment(TextAlignment.CENTER);
            headerParagraph.add("Заявление");

            textParagraph.add("Согласно пункту 322 местного устава, я, ");
            Text fio = new Text(passport.getSurname() + " " + passport.getName()).setUnderline();
            textParagraph.add(fio);
            textParagraph.add(" , прошу выдать мне единоразовую материальную помощь в размере ");
            Text sum = new Text("5000 руб").setBold().setUnderline();
            textParagraph.add(sum);
            textParagraph.add(".");

            Paragraph dataParagraph = new Paragraph();
            dataParagraph.add("Возраст: ");
            Text age = new Text(passport.getAge().toString()).setUnderline();
            dataParagraph.add(age);
            dataParagraph.add("\nПаспорт: ");
            Text passp = new Text(passport.getPassportSeries().toString() + " " + passport.getPassportNumber().toString()).setUnderline();
            dataParagraph.add(passp);
            dataParagraph.add("\nВыдан: ");
            Text dateGiven = new Text(format.format(passport.getPassportGiven())).setUnderline();
            dataParagraph.add(dateGiven);
            Paragraph credentialsParagraph = new Paragraph();
            credentialsParagraph.add("\nПодпись ________________");
            credentialsParagraph.add("\n\n");
            credentialsParagraph.add("Дата _____________________");

            document.add(headerParagraph);
            document.add(textParagraph);
            document.add(dataParagraph);
            document.add(credentialsParagraph);

            document.close();

        }catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public void writeObshagaPdf(Passport passport) {
        try {
            File pdf = new File(
                    FOLDER + "/obshaga/" + passport.getSurname() + "_" + UUID.randomUUID() + ".pdf");
            pdf.getParentFile().mkdirs();
            pdf.createNewFile();
            com.itextpdf.kernel.pdf.PdfWriter writer = new com.itextpdf.kernel.pdf.PdfWriter(pdf);
            PdfDocument pdfDocument = new PdfDocument(writer);
            Document document = new Document(pdfDocument);

            Paragraph textParagraph = new Paragraph();
            Paragraph headerParagraph = new Paragraph().setFontSize(16);

            String fontPath = getClass().getClassLoader().getResource("tnr.ttf").getPath();
            PdfFont timesNewRoman = PdfFontFactory.createFont(fontPath, "CP1251", true);

            document.setFont(timesNewRoman);
            document.setFontSize(14);

            headerParagraph.setBold();
            headerParagraph.setTextAlignment(TextAlignment.CENTER);
            headerParagraph.add("Заявление на предоставление общежития");

            textParagraph.add("Я, ");
            Text fio = new Text(passport.getSurname() + " " + passport.getName()).setUnderline();
            textParagraph.add(fio);
            textParagraph.add(" , будучи иногородним студентом, прошу предоставить мне общежитие и" +
                    " обязуюсь исполнять приложенный договор.");

            Paragraph dataParagraph = new Paragraph();
            dataParagraph.add("Возраст: ");
            Text age = new Text(passport.getAge().toString()).setUnderline();
            dataParagraph.add(age);
            dataParagraph.add("\nПаспорт: ");
            Text passp = new Text(passport.getPassportSeries().toString() + " " + passport.getPassportNumber().toString()).setUnderline();
            dataParagraph.add(passp);
            dataParagraph.add("\nВыдан: ");
            Text dateGiven = new Text(format.format(passport.getPassportGiven())).setUnderline();
            dataParagraph.add(dateGiven);
            Paragraph credentialsParagraph = new Paragraph();
            credentialsParagraph.add("\nПодпись ________________");
            credentialsParagraph.add("\n\n");
            credentialsParagraph.add("Дата _____________________");

            document.add(headerParagraph);
            document.add(textParagraph);
            document.add(dataParagraph);
            document.add(credentialsParagraph);

            document.close();

        }catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
