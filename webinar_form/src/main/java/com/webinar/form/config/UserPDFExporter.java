package com.webinar.form.config;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

public class UserPDFExporter {	
   
     
    public void export(HttpServletResponse response, String studentName) throws DocumentException, IOException {
       
    	String serverPath = "http://app.ysminfosolution.com/img/certificate/"; 
    	String serverFontPath = "http://app.ysminfosolution.com/img/certificate/"; 
    	
    	Document document = new Document(PageSize.A4);
        PdfWriter writer = PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
		      
		String bgImageFilePath = serverPath+"certificate.png";
		
		PdfContentByte canvas = writer.getDirectContentUnder();
	    Image image = Image.getInstance(bgImageFilePath);
	    image.scaleToFit(PageSize.A4.getWidth(), PageSize.A4.getHeight());
	    image.setAbsolutePosition(0, 0);	        
	    canvas.addImage(image);

	    String logoImageFilePath = serverPath+"ysm1.png";     
	    Image image1 = Image.getInstance(logoImageFilePath);
	    image1.scaleToFit(187, 180);
	    image1.setAbsolutePosition(200, 650);	    
	    canvas.addImage(image1);
	    
	    
	    FontFactory.register(serverFontPath+"Montserrat-Bold_0.ttf","certificate_font");        
	  	Font font = FontFactory.getFont("certificate_font");
	  	font.setSize(12); 		
	  	font.setColor(new BaseColor(3,34, 64)); // #011d6b
	  	font.setStyle(Font.BOLD);
	  		 
	  	String certImageFilePath = serverPath+"cert.png";	     
	    Image image2 = Image.getInstance(certImageFilePath);
	    image2.scaleToFit(207, 200);
	    image2.setAbsolutePosition(190, 590);	    
	    canvas.addImage(image2);
	    
		String appreImageFilePath = serverPath+"appre1.png";	     
	    Image image3 = Image.getInstance(appreImageFilePath);
	    image3.scaleToFit(160, 155);
	    image3.setAbsolutePosition(220, 520);	    
	    canvas.addImage(image3);
	    		
	    FontFactory.register(serverFontPath+"tt0140m.ttf","title_font");        
	  	Font font1 = FontFactory.getFont("title_font");
	  	font1.setSize(22); 		
	  	font1.setColor(new BaseColor(177,135, 27)); // #011d6b 
	  	font1.setStyle(Font.BOLD);
	  		    
		ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, new  Phrase(studentName, font1), 300, 490, 0); 
		     
		String symbolImageFilePath1 = serverPath+"kotlin1.png";	     
		Image image8 = Image.getInstance(symbolImageFilePath1);
		image8.scaleToFit(390, 390);
		image8.setAbsolutePosition(120,370);	    
		canvas.addImage(image8);
	     				
		String symbolImageFilePath = serverPath+"sign-cc.png";	     
		Image image7 = Image.getInstance(symbolImageFilePath);
		image7.scaleToFit(250, 150);
		image7.setAbsolutePosition(200,150);	    
		canvas.addImage(image7);	
								
		String footerImageFilePath = serverPath+"footer11.png";	     
		Image image5 = Image.getInstance(footerImageFilePath);
		image5.scaleToFit(435, 400);
		image5.setAbsolutePosition(80,75);	    
		canvas.addImage(image5);
		
        document.close();
         
    }
    
   
}
