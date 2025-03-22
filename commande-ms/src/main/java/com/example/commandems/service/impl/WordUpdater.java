package com.example.commandems.service.impl;

import org.apache.poi.ss.usermodel.*;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.Text;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

@Service
public class WordUpdater {
    public  void replace() {
        try {
            // Charger le fichier Excel
            InputStream excelStream = getClass().getClassLoader().getResourceAsStream("note-licence.xlsx");

            Workbook workbook = WorkbookFactory.create(excelStream);
            Sheet sheet = workbook.getSheetAt(0);

            // Charger le document Word
            InputStream pvStream = getClass().getClassLoader().getResourceAsStream("pv.docx");

            WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(pvStream);
            MainDocumentPart documentPart = wordMLPackage.getMainDocumentPart();

            // Récupérer tout le texte du document
            List<Object> texts = documentPart.getJAXBNodesViaXPath("//w:t", true);

            int rowIndex = 0;
            for (Row row : sheet) {
                if (rowIndex == 0) { // Ignorer l'en-tête
                    rowIndex++;
                    continue;
                }

                String nom = row.getCell(0).getStringCellValue();
                String note = String.valueOf(row.getCell(1).getNumericCellValue());

                // Remplacer {nom} et {note} dans le document
                for (Object obj : texts) {
                    if (obj instanceof Text) {
                        Text textElement = (Text) obj;
                        String text = textElement.getValue();

                        if (text.contains("{etudiant}")) {
                            textElement.setValue(text.replace("{etudiant}", nom));
                        }
                        if (text.contains("{appoge}")) {
                            textElement.setValue(text.replace("{appoge}", note));
                        }
                    }
                }
            }

            // Sauvegarder le document Word modifié
            FileOutputStream out = new FileOutputStream("document_etudiants_rempli.docx");
            wordMLPackage.save(out);
            out.close();
            workbook.close();

            System.out.println("✅ Fichier Word mis à jour avec succès !");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
