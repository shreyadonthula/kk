

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ArticleDashboard_DE {
	
	
	public static String RandomString() 
	    { 
	         int n=6;
	        // chose a Character random from this String 
	        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
	                                    + "0123456789"
	                                    + "abcdefghijklmnopqrstuvxyz"; 
	  
	        // create StringBuffer size of AlphaNumericString 
	        StringBuilder sb = new StringBuilder(n); 
	  
	        for (int i = 0; i < n; i++) { 
	  
	            // generate a random number between 
	            // 0 to AlphaNumericString variable length 
	            int index 
	                = (int)(AlphaNumericString.length() 
	                        * Math.random()); 
	  
	            // add Character one by one in end of sb 
	            sb.append(AlphaNumericString 
	                          .charAt(index)); 
	        } 
	  
	        return sb.toString(); 
	    } 
	
	  
	
	public static int getDecimalRandomNumber(){
        // create instance of Random class
        Random rand = new Random();
        // Generate and return Random number with decimal
        
        int nxt = rand.nextInt(100); 
        
       
        return nxt;
    }
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","E:\\selenium_new\\chromedriver.exe" );
  		
		WebDriver driver=new ChromeDriver();
  		driver.get("https://idam.metrosystems.net/web/Signin?nonce=1234&scope=openid&redirect_uri=https%3A%2F%2Fqacheck-dev.metrosystems.net&client_id=QACHECK_WEB&country_code=DE&realm_id=PHEONIX_RLM&user_type=EMP&DR-Trace-ID=52175f53-a72f-4027-a8b5-4a5a35db9807&response_type=code+id_token");
  		
  		 Thread.sleep(5000);
  		driver.manage().window().maximize();
  		 JavascriptExecutor js = (JavascriptExecutor) driver;
  		String CurrentUrl = driver.getCurrentUrl();  
  		System.out.println(CurrentUrl);
  		 Thread.sleep(5000);
  		  System.out.println(driver.getTitle());
  	     driver.findElement(By.xpath("//input[@id='user_id']")).sendKeys("sreedevi.mamidala@metronom-external.com");
  		  driver.findElement(By.id("password")).sendKeys("metroindia11.");
  	
  		  driver.findElement(By.id("submit")).click();
  		  System.out.println(driver.getTitle());
  		  Thread.sleep(5000);
  		  driver.getCurrentUrl();
  		  Thread.sleep(5000);
  		 driver.findElement(By.id("platform")).click();
  		Thread.sleep(5000);
		  driver.navigate().to("https://qacheck-dev.metrosystems.net/articles");
  		
  		 //profile
  		  Thread.sleep(10000);
    	//  driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div/div/div/div/div[8]/div[1]/button/*[name()='svg']")).click();
    	  Thread.sleep(5000);
    	  driver.findElement(By.xpath("//*[@id='root']/div/div/div[3]/div/nav/div[3]/div[7]/div[1]/a/div")).click();
    	  Thread.sleep(5000);
  		Select country=  new Select( driver.findElement(By.xpath("//*[@id='cou']")));
        country.selectByVisibleText("DE");
        
      //	driver.findElement(By.xpath("//*[@id='cou']/option[2]")).click();
   Thread.sleep(5000);
   Select language=  new Select( driver.findElement(By.xpath("//*[@id='language']")));
   language.selectByVisibleText("English");
   Thread.sleep(5000);
   try {
   Select warehouse=  new Select( driver.findElement(By.xpath("//*[@id='otherWarehouses']")));
   warehouse.selectByValue("Marl");
   }catch(Exception e) {}
   
   try {
	   Select warehouse=  new Select( driver.findElement(By.xpath("//*[@id='warehouses']")));
	   warehouse.selectByValue("Marl");
	   }catch(Exception e) {}
	   
	   
   
   driver.findElement(By.xpath("//*[@id='root']/div/div/div[3]/div/nav/div[3]/div[7]/div[1]/div/div/div[1]/div[1]/div/div/button/*[name()='svg']")).click();
  		int countofinspected_articles=0;
   int i=1;
  		 int k=1;
  		 int confirmclicked=0;
  		 int nextbutton= 2;
  		 //xpath of no. of pages 
  		//*[@id="root"]/div/div[2]/div[2]/div/div[2]/div[3]/div/div/div/div/div[2]/div/ul/a/li[text()='>']/parent::a//preceding-sibling::a
  		//to run all pages 
  		String s1="Pass";
			String s2="Rejected";
			String s3="Partially Rejected";
			String s4="Conditionally Accepted";
			String s5="Not Delivered";
			
		SHREYA:
  		 for(int j=1;j<=5;j++) {
  			
  			if(i>10){
				System.out.println("moved to next page");
				js.executeScript("window.scrollBy(0,2000)");	 
             	Thread.sleep(5000);
             	//move to next page since 10 rows are done
             	                            
             	                             //*[@id="root"]/div/div/div[2]/div/div[2]/div[3]/div/div/div/div/div[2]/div/ul/a[6]
             	driver.findElement(By.xpath("//*[@id='root']/div/div/div[2]/div/div[2]/div[3]/div/div/div/div/div[2]/div/ul/a/li[text()='>']")).click();
                Thread.sleep(5000);
			
  			}
  			i=1;
  			//to run a single page i.e., a page of 10 articles
  			
  			while(i<=10) {
  		
  			
  			 if(k==6)
  				 k=1;
  			try {
  				//to check whether action element is there are not (if exists go into loop)
  				 
  			 Thread.sleep(5000);                   
  			                              
  			                                 //*[@id="root"]/div/div/div[2]/div/div[2]/div[3]/div/div/div/div/div[1]/table/tbody/tr[2]/td[10]/svg
  			 
  			 if(driver.findElement(By.xpath("//*[@id='root']/div/div/div[2]/div/div[2]/div[3]/div/div/div/div/div[1]/table/tbody/tr["+i+"]/td[10]/*[name()='svg']"))!=null)
  			{
  				 
  				 String POU= driver.findElement(By.xpath("//*[@id='root']/div/div/div[2]/div/div[2]/div[3]/div/div/div/div/div[1]/table/tbody/tr["+i+"]/td[5]")).getText();
  	   			 System.out.println("POU="+POU);
  	   			
  				
		        System.out.println("image not null pageno: "+j+"row no  "+i);
		        js.executeScript("window.scrollBy(0,2000)");
		        Thread.sleep(5000);
		        //action element clicking
		         driver.findElement(By.xpath("//*[@id='root']/div/div/div[2]/div/div[2]/div[3]/div/div/div/div/div[1]/table/tbody/tr["+i+"]/td[10]/*[name()='svg']")).click();
		        System.out.println("action element clicked");
		        Thread.sleep(5000);
		    
		       String articlename= driver.findElement(By.xpath("//*[@id='root']/div/div/div[2]/div/div[1]/div[1]/div/div[1]/p[2]")).getText();
		       System.out.println("article name:"+articlename);
		       Thread.sleep(5000);
		       

		       for(int l=1;l<=38;l++) {
	   	        	 try {
	   	        		  js.executeScript("window.scrollBy(0,50)");
	   	        		  
	   	        		  
	   	        		                             //*[@id="root"]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[4]/div/div/div[2]/div/label/button
	   	        		driver.findElement(By.xpath("  //*[@id='root']/div/div/div[2]/div/div[1]/div[2]/div[2]/div["+l+"]/div/div/div[2]/div/label/button")).click();
	   	        		 
	   	        	 }
	   	        	 catch(Exception e) {}
	   	        	 
	   	         
			        	 if(l%2==1) {
			        		 if(l<=5) {
			        	 try {
			        		 Thread.sleep(1000);
			        		 Robot robot = new Robot();
					            
					            Thread.sleep(1000);
					            												 //*[@id="root"]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[3]/div/div/div[3]/div[1]/div/div/div/div/div[1]/img
					                                                             //*[@id="root"]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/div[3]/div[1]/div/div/div/div/div[1]/img
					            WebElement picEle = driver.findElement(By.xpath("//*[@id='root']/div/div/div[2]/div/div[1]/div[2]/div[2]/div["+l+"]/div/div/div[3]/div[1]/div/div/div/div/div[1]/img"));
					            String pic = picEle.getAttribute("value");
//					            test.pass(pic);
					           
					            picEle.click();
					            robot.setAutoDelay(2000);
					           
					            Thread.sleep(2000);
					            StringSelection selection = new StringSelection("E:\\selenium_new\\images\\img"+l+".jpg");
					            Thread.sleep(2000);
					            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
					           
					            robot.setAutoDelay(2000);
					           
					            robot.keyPress(KeyEvent.VK_CONTROL);
					            robot.keyPress(KeyEvent.VK_V);
					           
					            robot.keyRelease(KeyEvent.VK_CONTROL);
					            robot.keyRelease(KeyEvent.VK_V);
					           
					            robot.setAutoDelay(2000);
					           
					            robot.keyPress(KeyEvent.VK_ENTER);
					            robot.keyRelease(KeyEvent.VK_ENTER);
					            js.executeScript("window.scrollBy(0,300)");
					         
			        	 }
			        	 catch(Exception e){
			        		 
			        	 }
			        	 }}
			        
			     
			        
	   	        	 
	   	        	 
	   	        	 
	   	        	 
	   	        	 try {
	   	        		 
	   	        		 
	   	        		 
	   	        		//*[@id="root"]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[2]/div/div/div[4]/div/div[2]/div[2]/input
	   	        		  driver.findElement(By.xpath("//*[@id='root']/div/div/div[2]/div/div[1]/div[2]/div[2]/div["+l+"]/div/div/div[4]/div/div[2]/div[2]/input")).sendKeys("test1");
	   				   
	   	        	 }
	   	        	 catch(Exception e) {}
	   	        	 
//	   	        	 try {
//	   	        	 if(l<=5) {	 
//	   	        	 
//	   	        	 //                            driver.findElement(By.xpath("(//img[@id='MoveAllRight'])[2]")).click();
//	             	 Select passorfail=  new Select(driver.findElement(By.xpath("(//*[@id='addressType'])["+l+"]")));
//	                  passorfail.selectByIndex(1);
//	                  }
	   	        	// }catch(Exception e) {}
	   	        //		*[@id="root"]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[16]/div/div/div[4]/div/div[2]/div[2]/input
	   	        	 try {
	   	        	 
	   	        	 driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div[2]/div[2]/div["+l+"]/div/div[4]/div[2]/div/input")).sendKeys("test1");
	   	                                                           //*[@id="root"]/div/div[2]/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div[4]/div/div/input
	   	        	 											   //*[@id="root"]/div/div[2]/div[2]/div/div[1]/div[2]/div[2]/div[2]/div/div[4]/div[2]/div/input
	   	        	 												//*[@id="root"]/div/div[2]/div[2]/div/div[1]/div[2]/div[2]/div[3]/div/div[4]/div[2]/div/input
	   	       //*[@id="accordion__body-53"]/div/div/div[1]/div[1]/div[2]/div[36]/div/div[4]/div[2]/div/input
	   	        	 }
	   	        	 catch(Exception e) {}
	   	        	 
	   	        	 try {
		   	        	   	 
                     //*[@id="root"]/div/div/div[2]/div/div[1]/div[2]/div[2]/    div[1]/div/div/div[4]/div/div[1]/div[2]/input
	   driver.findElement(By.xpath("  //*[@id='root']/div/div/div[2]/div/div[1]/div[2]/div[2]/div["+l+"]/div/div/div[4]/div/div[1]/div[2]/input")).sendKeys(""+getDecimalRandomNumber());
	   	        	 }
	   	        	 catch(Exception e) {}
	   	        	 
		       }
		       
		       js.executeScript("window.scrollBy(0,-4300)");
		      
		  	 try {
	        	 
	        	 // selection option in criteria
	             List <WebElement> selectoption= driver.findElements(By.xpath("//*[@id='addressType']"));
	             selectoption.size();
	             for(int g=1;g<=34;g++) {
	            	 Thread.sleep(5000);
	            	                      //       By.xpath("(//img[@id='MoveAllRight'])[2]")
	            	 //                            driver.findElement(By.xpath("(//img[@id='MoveAllRight'])[2]")).click();
	             	 Select passorfail=  new Select(driver.findElement(By.xpath("(//*[@id='addressType'])["+g+"]")));
	                  passorfail.selectByIndex(1);
	             }
	        	 }catch(Exception e) {}
	        
//	        	 
	   	        	 
//    for(int z=0;z<=5;z++) {
//		        driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div/div[1]/div[2]/div[2]/div["+z+"]/div/div[2]/div/div/button")).click();
//		        	
//		        
//		        
//		      driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div/div[1]/div[2]/div[2]/div["+z+"]/div/div[4]/div[1]/div/input")).sendKeys("comment+"+z+"");
//		      								//*[@id="root"]/div/div[2]/div[2]/div/div[1]/div[2]/div[2]/div[3]/div/div[4]/div[1]/div/input
//		        
//		        }
		        //*[@id="root"]/div/div[2]/div[2]/div/div[1]/div[2]/div[2]/div[2]/div/div[2]/div/div/button
                Thread.sleep(5000);
                js.executeScript("window.scrollBy(0,3000)");
                
                
            
//		         String POU=    driver.findElement(By.xpath("//*[@id='accordion__title-"+i+"']/div/div/div[3]/p")).getText();
//		       
//		     //driver.findElement(By.xpath("//*[@id='accordion__body-"+i+"']/div/div/div[1]/div[2]/div[1]/div[2]/div/div[2]/input")).sendKeys(POU+1);
//		       System.out.print("Package units ordered:"+POU);
//		      
		      //Failed Criteria 
		       //Packaging Units checked
		      int pou= Integer.parseInt(POU);
		      if(pou>=2) {
		    	  pou=pou/2;
		      }
		      String strpou =Integer.toString(pou);
		      System.out.print("package units checked:"+strpou);
		      System.out.print("Failed package units checked ");
		      
		                                     //*[@id="root"]/div/div/div[2]/div/div[1]/div[3]/div[2]/div/div[2]/div/div[2]/input
                                        //   *[@id="root"]/div/div/div[2]/div/div[1]/div[3]/div[2]/div/div[2]/div/div[2]/input
		      driver.findElement(By.xpath("//*[@id='root']/div/div/div[2]/div/div[1]/div[3]/div[2]/div/div[2]/div/div[2]/input")).sendKeys(strpou);
		       
		       //Rejections 
		       System.out.print("Rejections:"+strpou);
		      driver.findElement(By.xpath("//*[@id='root']/div/div/div[2]/div/div[1]/div[3]/div[2]/div/div[3]/div/div[2]/input")).sendKeys(strpou);
		      System.out.print("Failed Number of rejections are more than packaging order units ");
		      
		      //Conditionally Accepted
		      System.out.print("Conditionally Accepted:"+strpou);
		      driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div[1]/div[3]/div[2]/div/div[4]/div/div[2]/input")).sendKeys(strpou);
		      System.out.print("Failed Number of Conditionally accepted orders ");
		     
		      
		   driver.findElement(By.xpath("//*[@id='root']/div/div/div[2]/div/div[1]/div[3]/div[2]/div/div[5]/div/div[2]/input")).sendKeys(""+getDecimalRandomNumber());
		   
		   driver.findElement(By.xpath("//*[@id='root']/div/div/div[2]/div/div[1]/div[3]/div[2]/div/div[6]/div/div[2]/input")).sendKeys(RandomString());
		 //  Thread.sleep(10000);
		      //Passed Criteria 
		      //Packaging Units checked
//		     int pou1= Integer.parseInt(POU)-1;
//		     String strpou1 =Integer.toString(pou1);
//		     System.out.print("passed package units checked");
//		     driver.findElement(By.xpath("//*[@id='accordion__body-"+i+"']/div/div/div[1]/div[2]/div[1]/div[2]/div/div[2]/input")).sendKeys(strpou1);
//		      
//		      //Rejections
//		      System.out.print("Rejections:"+strpou);
//		     driver.findElement(By.xpath("//*[@id='accordion__body-"+i+"']/div/div/div[1]/div[2]/div[1]/div[3]/div/div[2]/input")).sendKeys(strpou1);
//		     
//		     
                Thread.sleep(3000);
                Select inspection = new Select(driver.findElement(By.xpath("//select[@id='article status']")));
                System.out.println("select button clicked");

               
                Thread.sleep(5000);
    			String s[]={"Pass","Rejected","Partially Rejected","Conditionally Accepted","Not Delivered"};
    			
                inspection.selectByIndex(k);
                
                System.out.println("inspection result:"+s[k-1]);
                js.executeScript("window.scrollBy(0,600)");
                driver.findElement(By.xpath("//*[@id='root']/div/div/div[2]/div/div[1]/div[3]/div[2]/div/div[11]/div/div[2]/input")).sendKeys(s[k-1]);
                Thread.sleep(2000);
             
                if(k==1 || k==5) {
                	driver.findElement(By.xpath("//button[contains(text(),'Inform Buyer')]")).click();
                	 confirmclicked=1;
                     k++;
                     countofinspected_articles++;
                }
                else
                {
                Thread.sleep(2000);
                WebElement confirm = driver.findElement(                     
                		 By.xpath("//button[text()='Send Report']"));
                (confirm).click();
                confirmclicked=1;
                countofinspected_articles++;
                k++;
                }
             
                Thread.sleep(8000);  
                
                
                
                //search the article which is inspected
                driver.findElement(By.xpath("//*[@id='id']")).sendKeys(articlename);
                //click on search button to download report which is inspected
                Thread.sleep(5000);
                  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div[2]/div[2]/div/div/div[1]/div/div[1]/div/span[2]/*[name()='svg']")).click();
                
                Thread.sleep(5000);
                //click on report to download
                                             //*[@id="root"]/div/div/div[2]/div/div[2]/div[3]/div/div/div/div/div[1]/table/tbody/tr/td[9]/div/a/span/span
                driver.findElement(By.xpath("//*[@id='root']/div/div/div[2]/div/div[2]/div[3]/div/div/div/div/div[1]/table/tbody/tr/td[9]/div/a/span/span")).click();
                Thread.sleep(5000);
                
              WebElement searchbox= driver.findElement(By.xpath("//*[@id='id']"));
               
               searchbox.sendKeys(Keys.chord(Keys.CONTROL,"a"));
              searchbox.sendKeys(Keys.BACK_SPACE);
                Thread.sleep(5000);
                
                System.out.println("clear");
                //click on search button to download report which is inspected
                driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div[2]/div[2]/div/div/div[1]/div/div[1]/div/span[2]/*[name()='svg']")).click();
                
             //*[@id='root']/div/div[2]/div[2]/div/div[2]/div[2]/div/div[1]/div/div[1]/div/span[2]/a/*[name()='svg']
                Thread.sleep(8000);
                  
                
                if(countofinspected_articles==5)
                {
                	break SHREYA;
                }
                int z;
                js.executeScript("window.scrollBy(0,3000)");
                //To increment the page no after clicking confirm button
                for(z=1;z<j;z++) {
                 	Thread.sleep(5000);
                 	System.out.println("ok");
               
                 	
//                 	//Date Picker time code
//                 	 WebDriverWait wait = new WebDriverWait(driver, 60);
//                     Thread.sleep(5000);
//                     driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div/div/div/div/div[5]/div/img")).click();
//                     Thread.sleep(5000);
//                     driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div/div/div/div/div[6]/div/div[2]/div/nav[2]/img")).click();
//                     Thread.sleep(5000);
//                     // Create object of SimpleDateFormat class and decide the format
//                     DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy ");
//                     
//                     //get current date time with Date()
//                     Date date = new Date();
//                     
//                     // Now format the date
//                     String date1= dateFormat.format(date);
//                     
//                     // Print the Date
//                     System.out.println(date1);
//                     driver.findElement(By.xpath("//div[@aria-label='Tue Dec 01 2020']")).click();
//                   //  Thread.sleep(5000);
//                     driver.findElement(By.xpath("//div[@aria-label='Wed Dec 02 2020']")).click();
//                     Thread.sleep(5000);
//                     driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[6]/div[1]/div[2]/div[1]/nav[2]/a[1]/a[1]/a[1]/*[1]")).click();
//                   
//                     
//                     
//                     
//                 	System.exit(1);
//                 	System.out.println("clicked "+"pageno: "+j+" row no "+i);
                	driver.findElement(By.xpath("//*[@id='root']/div/div/div[2]/div/div[2]/div[3]/div/div/div/div/div[2]/div/ul/a/li[text()='>']")).click();
                    Thread.sleep(5000); js.executeScript("window.scrollBy(0,3000)");
                }
                //to know how many action elements are there in a page
                List<WebElement> elements = driver.findElements(By.xpath("//button[@class='m-iconButton trash-color icon-left']"));
 				 //action (edit)element
 				System.out.println("no. of action element size: "+elements.size());
 				if(elements.size()>0) {
 					i=1;
 					continue;
 				}
                
		    }
		      
  			 }
  		//	 if there is no action element just skip from exception
  			 catch(Exception e) {
  				System.out.println("no action element here, increment row "+"pageno: "+j+" rowno "+i+".");
  				Thread.sleep(1000);
  				
  				js.executeScript("window.scrollBy(0,1000)");
  			 }
  			 i++;
  		 }
  		
  		 }
  		 
		
	
	}

}
