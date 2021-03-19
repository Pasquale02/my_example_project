package com.service;

import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.domain.Post;
import com.exception.ApplicationException;

import io.opentracing.Span;

@Service
public class PdfService {

	public String createPdf(String headerRequestId, Post bodyRequest, Span span) throws ApplicationException {

		String result = "ERROR";
		span.log("RequestId: " + headerRequestId);
		System.out.println("Body request: " + bodyRequest);

		try {
			PDDocument document = new PDDocument();			
			PDPage infoPage = new PDPage();
			PDDocumentInformation pdd = document.getDocumentInformation();

			pdd.setAuthor("Pasquale Florio");
			pdd.setTitle("Sample document");
			pdd.setCreator("PDF Examples");
			pdd.setSubject("Example document");
			pdd.setKeywords("First example, sample, my pdf");
			
			Calendar date = new GregorianCalendar();
			date.set(2015, 11, 5);
			pdd.setCreationDate(date);
			date.set(2016, 6, 5);
			pdd.setModificationDate(date);

			document.addPage(infoPage);

			PDPageContentStream contentStream = new PDPageContentStream(document, infoPage);

			contentStream.beginText();
			contentStream.newLineAtOffset(25, 500);
			contentStream.setFont(PDType1Font.COURIER, 12);
			contentStream.showText("Hello World");
			// aggiunge l'offset alla riga esistente
			contentStream.newLineAtOffset(10,70);
			contentStream.showText("text2");
			contentStream.endText();
			contentStream.close();

			int noOfPages = document.getNumberOfPages();
			System.out.print(noOfPages);

			document.save("C:/Users/USER/Documents/progPoste/ms_my_examples/my_doc.pdf");
			document.close();
			
			// Aggiunta img nel file
			
			File file = new File("C:/Users/USER/Documents/progPoste/ms_my_examples/my_doc.pdf");
			PDDocument doc = PDDocument.load(file);
			PDPage drawPage = new PDPage();
			PDImageXObject pdImage = PDImageXObject.createFromFile("C:/Users/USER/Documents/progPoste/logo.jpg", doc);
			PDPageContentStream contentStreamImage = new PDPageContentStream(doc, drawPage);
			contentStreamImage.drawImage(pdImage, 10, 50);
			contentStreamImage.close();
			doc.addPage(drawPage);
			doc.save("C:/Users/USER/Documents/progPoste/ms_my_examples/my_doc.pdf");
			doc.close();
			
			// Crittazione documento
			
			File fileToCrit = new File("C:/Users/USER/Documents/progPoste/ms_my_examples/my_doc.pdf");
			PDDocument docToCrit = PDDocument.load(fileToCrit);
			AccessPermission accessPermission = new AccessPermission();
			StandardProtectionPolicy spp = new StandardProtectionPolicy("1234","1234",accessPermission);
			spp.setEncryptionKeyLength(128);
			spp.setPermissions(accessPermission);
			docToCrit.protect(spp);
			docToCrit.save("C:/Users/USER/Documents/progPoste/ms_my_examples/my_doc_crittato.pdf");
			docToCrit.close();
			
			result = "1) create pdf; 2) added image; 3) crittazione documento";
			
		} catch (Exception e) {
			throw new ApplicationException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
		return result;
	}
}
