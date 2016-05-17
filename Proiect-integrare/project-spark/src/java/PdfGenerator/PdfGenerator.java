package PdfGenerator;

import FisaCerintelor.UseCase.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import FisaCerintelor.FisaCerintelor;
import FisaCerintelor.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by Cosmin on 5/17/2016.
 */
public class PdfGenerator {
    private FisaCerintelor model;
    private static Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 22, Font.BOLD);
    private static Font subtitleFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    private static Font textFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);

    public PdfGenerator(FisaCerintelor model){
        this.model=model;
    }

    public void generatePdf(){
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("E:\\FisaCerinte.pdf"));
            document.open();
            addMetaData(document);
            addFirstFields(document);
            addUseCases(document);
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void addMetaData(Document document) {
        document.addTitle(model.title);
        document.addSubject(model.description.getDescription());
        document.addKeywords("Java, PDF, FisaCerintelor");
        for(Author author : model.authors){
            document.addAuthor(author.getAuthor());
        }
    }

    private void addFirstFields(Document document) {
        Paragraph paragraph = new Paragraph();
        paragraph.add(new Paragraph(model.title, titleFont));

        paragraph.add(new Paragraph("Authors", titleFont));
        for(Author author : model.authors){
            paragraph.add(new Paragraph(author.getAuthor(), textFont));
        }

        paragraph.add(new Paragraph("Description", titleFont));
        paragraph.add(new Paragraph(model.description.getDescription(), textFont));

        paragraph.add(new Paragraph("Domain", titleFont));
        paragraph.add(new Paragraph(model.domain.getDomain(), textFont));

        paragraph.add(new Paragraph("Stakeholders and Interests", titleFont));
        for(StakeholderAndInterest stakeholder : model.stakeholders){
            paragraph.add(new Paragraph(stakeholder.getName(), textFont));
            paragraph.add(new Paragraph(stakeholder.getInterest(), textFont));
        }

        paragraph.add(new Paragraph("Actors and Objectives", titleFont));
        for(ActorAndObjective actor : model.actors){
            paragraph.add(new Paragraph(actor.getName(), textFont));
            paragraph.add(new Paragraph(actor.getObjective(), textFont));
        }

        try {
            document.add(paragraph);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public void addUseCases(Document document){
        Paragraph paragraph = new Paragraph();
        paragraph.add(new Paragraph("Use Cases", titleFont));


        for(FCUseCase useCase : model.getUseCases()){

            paragraph.add(new Paragraph("Use Case", titleFont));
            paragraph.add(new Paragraph(useCase.getTitle(), textFont));
            paragraph.add(new Paragraph(useCase.getObjectiveAndContext(), textFont));


            paragraph.add(new Paragraph("Actors", titleFont));
            for(FCActor actor : useCase.getActors()){
                paragraph.add(new Paragraph(actor.getName(), textFont));
            }

            paragraph.add(new Paragraph("Steps", titleFont));
            for(Step step : useCase.getSteps()){
                paragraph.add(new Paragraph(step.getTitleAction(), textFont));
                paragraph.add(new Paragraph(step.getDescription(), textFont));
            }

            paragraph.add(new Paragraph("Extensions", titleFont));
            for(Extension extension : useCase.getExtensions()){
                paragraph.add(new Paragraph(extension.getExtensionTitle(), textFont));
                paragraph.add(new Paragraph(extension.getDescription(), textFont));
                paragraph.add(new Paragraph(extension.getStepTitle(), textFont));
            }

            paragraph.add(new Paragraph("Relashionships", titleFont));
            for(FCRelationship relationship : useCase.getRelationships()){
                String relatie = relationship.getFrom() + ' ' + relationship.getType() + ' ' + relationship.getTo();
                paragraph.add(new Paragraph(relatie, textFont));
            }

        }

        try {
            document.add(paragraph);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
