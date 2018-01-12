package in.siva.pdf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class GeneratePDF {

  public static void main(String[] args) throws Exception  {
   Document document=new Document();
   OutputStream os=new FileOutputStream(new File("/home/vamsoft/Desktop/siva_pdf_resources/test1.pdf"));
   PdfWriter.getInstance(document, os );
   document.open();
   Image img = Image.getInstance("flipkart_old_icon.png");
   
   //img.setAbsolutePosition(90, 0);
   float f=img.getAbsoluteX();
   float f1=img.getAbsoluteY();
   System.out.println(f+"       "+f1);
  // img.getInstance(30, 20, data, globals)
   Paragraph paragraph=new Paragraph("Sample 1: This is simple image demo.");
   paragraph.setAlignment(120);
   document.add(paragraph);
   document.add(img);
   document.close();
   System.out.println("created");
   
  }

}
