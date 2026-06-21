package com.designpatterns.factory;

public class FactoryMethodTest {

    public static void main(String[] args) {

        System.out.println("Starting Factory Method Pattern Test...");

        System.out.println("\nWord Document: ");
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document word = wordFactory.createDocument();
        word.open();
        word.save();

        System.out.println("\nPDF Document: ");
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdf = pdfFactory.createDocument();
        pdf.open();
        pdf.save();

        System.out.println("\nExcel Document: ");
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excel = excelFactory.createDocument();
        excel.open();
        excel.save();

        System.out.println("\nVerification: ");
        System.out.println("Word document type   : " + word.getClass().getSimpleName());
        System.out.println("PDF document type    : " + pdf.getClass().getSimpleName());
        System.out.println("Excel document type  : " + excel.getClass().getSimpleName());
    }
}