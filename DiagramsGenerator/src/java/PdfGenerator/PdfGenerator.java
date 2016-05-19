package PdfGenerator;

import FisaCerintelor.UseCase.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import FisaCerintelor.FisaCerintelor;
import FisaCerintelor.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import static java.awt.SystemColor.text;

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
        document.addSubject(model.description.getDescription());
        document.addKeywords("Java, PDF, FisaCerintelor");
        for(Author author : model.authors){
            document.addAuthor(author.getAuthor());
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
        for(Author author : model.authors){
            p.add(new Paragraph(author.getAuthor(), textFont));
        }
        p.setIndentationLeft(400);
        document.add(p);

        document.newPage();

        p = new Paragraph("Description", subtitleFont);
        document.add(p);
        document.add(new Paragraph(model.description.getDescription(), textFont));

        p = new Paragraph("Domain", subtitleFont);
        document.add(p);
        document.add(new Paragraph(model.domain.getDomain(), textFont));

        p = new Paragraph("Stakeholders and Interests", subtitleFont);
        document.add(p);
        for(StakeholderAndInterest stakeholder : model.stakeholders){
            document.add(new Paragraph(stakeholder.getName(), boldFont));
            document.add(new Paragraph(stakeholder.getInterest(), textFont));
        }

        for(ActorAndObjective actor : model.actors){
            document.add(new Paragraph(actor.getName(), boldFont));
            document.add(new Paragraph(actor.getObjective(), textFont));
        }
    }

    public void addUseCases(Document document) throws DocumentException {
        Paragraph p = new Paragraph("Use Cases", subtitleFont);
        document.add(p);
        int i = 0;

        for (FCUseCase useCase : model.getUseCases()) {

            i += 1;
            document.add(new Paragraph(i + ". " + useCase.getTitle(), boldFont));
            document.add(new Paragraph(useCase.getObjectiveAndContext(), textFont));


            document.add(new Paragraph("Actors", boldFont));
            for (FCActor actor : useCase.getActors()) {
                document.add(new Paragraph(actor.getName(), textFont));
            }

            document.add(new Paragraph("Steps", boldFont));
            for (Step step : useCase.getSteps()) {
                document.add(new Paragraph(step.getTitleAction(), italicFont));
                document.add(new Paragraph(step.getDescription(), textFont));
            }

            document.add(new Paragraph("Extensions", boldFont));
            for (Extension extension : useCase.getExtensions()) {
                document.add(new Paragraph(extension.getExtensionTitle(), italicFont));
                document.add(new Paragraph(extension.getDescription(), textFont));
                document.add(new Paragraph(extension.getStepTitle(), textFont));
            }

            /*document.add(new Paragraph("Relashionships", boldFont));
            for (FCRelationship relationship : useCase.getRelationships()) {
                String relatie = relationship.getFrom() + "----" + relationship.getType() + "----" + relationship.getTo();
                document.add(new Paragraph(relatie, textFont));
            }*/

        }
    }
}
