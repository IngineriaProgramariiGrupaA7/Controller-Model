package PdfGenerator;

import FisaCerinte.ActorAndObjective;
import FisaCerinte.FisaCerintelor;
import FisaCerinte.StakeholderAndInterest;
import FisaCerinte.UseCase.Extension;
import FisaCerinte.UseCase.FCUseCase;
import FisaCerinte.UseCase.Step;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by Cosmin on 5/17/2016.
 */
public class PdfGenerator {
    private FisaCerintelor model;
    private static Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 45, Font.BOLD);
    private static Font subtitleFont = new Font(Font.FontFamily.TIMES_ROMAN, 22, Font.BOLD);
    private static Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
    private static Font italicFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.ITALIC);
    private static Font textFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);

    public PdfGenerator(FisaCerintelor model){
        this.model=model;
    }

    public void generatePdf(String where){
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(where));
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
        document.addSubject(model.description);
        document.addKeywords("Java, PDF, FisaCerintelor");
        for(String author : model.authors){
            document.addAuthor(author);
        }
    }

    private void addFirstFields(Document document) throws DocumentException {
        Paragraph paragraph = new Paragraph();
        Paragraph p = new Paragraph(model.title, titleFont);
        p.setAlignment(Element.ALIGN_CENTER);
        p.setLeading(250);
        document.add(p);

        p = new Paragraph("Authors", subtitleFont);
        p.setIndentationLeft(400);
        p.setLeading(200);
        document.add(p);

        p = new Paragraph();
        for(String author : model.authors){
            p.add(new Paragraph(author, textFont));
        }
        p.setIndentationLeft(400);
        document.add(p);

        document.newPage();

        p = new Paragraph("Description", subtitleFont);
        document.add(p);
        document.add(new Paragraph(model.description, textFont));

        p = new Paragraph("Domain", subtitleFont);
        document.add(p);
        document.add(new Paragraph(model.domain, textFont));

        p = new Paragraph("Stakeholders and Interests", subtitleFont);
        document.add(p);
        for(StakeholderAndInterest stakeholder : model.stakeholdersAndInterests){
            document.add(new Paragraph(stakeholder.getName(), boldFont));
            document.add(new Paragraph(stakeholder.getInterests(), textFont));
        }

        for(ActorAndObjective actor : model.actorsAndObjectives){
            document.add(new Paragraph(actor.getName(), boldFont));
            document.add(new Paragraph(actor.getObjectives(), textFont));
            document.add(new Paragraph(actor.getInherits(), textFont));
        }
    }

    public void addUseCases(Document document) throws DocumentException {
        Paragraph p = new Paragraph("Use Cases", subtitleFont);
        document.add(p);
        int i = 0;

        for (FCUseCase useCase : model.getUsecases()) {

            i += 1;
            document.add(new Paragraph(i + ". " + useCase.getTitle(), boldFont));
            document.add(new Paragraph(useCase.getObjective(), textFont));


            document.add(new Paragraph("Actors", boldFont));
            for (String actor : useCase.getActors()) {
                document.add(new Paragraph(actor, textFont));
            }

            document.add(new Paragraph("Steps", boldFont));
            for (Step step : useCase.getSteps()) {
                document.add(new Paragraph(step.getTitle(), italicFont));
                document.add(new Paragraph(step.getDescription(), textFont));
            }

            document.add(new Paragraph("Extensions", boldFont));
            for (Extension extension : useCase.getExtensions()) {
                document.add(new Paragraph(extension.getTitle(), italicFont));
                document.add(new Paragraph(extension.getDescription(), textFont));
                document.add(new Paragraph(extension.getStep(), textFont));
            }

            /*document.add(new Paragraph("Relashionships", boldFont));
            for (FCRelationship relationship : useCase.getRelationships()) {
                String relatie = relationship.getFrom() + "----" + relationship.getType() + "----" + relationship.getTo();
                document.add(new Paragraph(relatie, textFont));
            }*/

        }
    }
}
