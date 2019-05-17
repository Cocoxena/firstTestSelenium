package fr.Selenium.Coralie.CebronDeLisle;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException; //utilisation de TimeoutException
import org.openqa.selenium.WebDriver; //utilisation du WebDriver
import org.openqa.selenium.WebElement; //utilisation du WebElement
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait; //utilisation du WebDriverWait

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase
{
	private static final String URL ="https://www.fr.jal.co.jp/frl/en/";
	private static final String PATH_CHROME_DRIVER = "C:\\Program Files\\chromedriver_win32\\chromedriver.exe";
	public static WebDriver driver; //faire l'import pour utiliser WebDriver
		
	private static String villeDEPART;
	private static String villeARRIVEE;
	
	private static String dateDEPART;
	private static String flightNumberALLER;
	private static String flightNumberALLERConfirm;
	private static String horaireDepartALLER;
	private static String horaireArriveeALLER;
	private static String dureeTrajetALLER;
	private static String dureeTrajetALLERConfirm;
	
	private static String dateRETOUR;
	private static String flightNumberRETOUR;
	private static String flightNumberRETOURConfirm;
	private static String horaireDepartRETOUR;
	private static String horaireArriveeRETOUR;
	private static String dureeTrajetRETOUR;
	
	private static String prixTotal;
	private static String prixTotalConfirm;
	
	
	
	
	//création d'une pause avant de cliquer virtuellement sur le bouton "Continue"
    private static void pause(int seconds) {
    	try {
    		Thread.sleep(seconds *1000);
    	}
    	catch (InterruptedException ex) {
    		Thread.currentThread().interrupt();
    	}
    }
	
		
	public static void firstTest() {
		//changement des propriétés du WebDriver
		System.setProperty("webdriver.chrome.driver", PATH_CHROME_DRIVER); //System.setProperty(key, value)
		//création d'un nouvel objet WebDriver
    	driver = new ChromeDriver();
    	   
    	//temps d'attente imposé pour la récupération des données (faire l'import pour l'utilisation de TimeUnit)
    	// = implicite wait
    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    	
    	//agrandir la page de la taille de l'écran Maximize
    	driver.manage().window().maximize();
    	
    	//récupération de la page web
    	driver.get(URL);
    	
    	//fermeture de la page
    	//driver.close();
    	
    	pause(3);
	
    	//il faut récupérer l'élément dans l'inspecteur du bouton "Continue"
    	
    	//ne fonctionnent pas: 
    	//driver.findElement(By.linkText("/world/common_rn/img/btn_continue_en.gif"));
    	//driver.findElement(By.linkText("btn_continue_en.gif")).click();
    	
    	//fonctionne par la className
    	driver.findElement(By.className("JS_ciBox_submit")).click();
    	
    	//fonctionne par l'id du sélecteur
    	//prendre le 1er élément de l'ensemble d'éléments de l'id "JS_ciBox_contents";
    	
    	//driver.findElements(By.cssSelector("#JS_ciBox_contents img")).get(1).click();
    	 
    	//sélectionner des éléments définis dans les listes déroulantes
    	Select paysDepart = new Select(driver.findElement(By.id("mdlDepArea1")));
    	paysDepart.selectByValue("GB_CM");
    
    	Select villeDepart = new Select(driver.findElement(By.id("mdlDepLocation1")));
    	villeDepart.selectByValue("MAN");
    	        	
    	Select paysArrivee = new Select(driver.findElement(By.id("mdlArrArea1")));
    	paysArrivee.selectByValue("SG_CM");
    	
    	Select villeArrivee = new Select(driver.findElement(By.id("mdlArrLocation1")));
    	villeArrivee.selectByValue("SIN");
    	
    	Select moisDepart = new Select(driver.findElement(By.id("DEPARTURE_DATE_1_MONTH")));
    	moisDepart.selectByValue("10");
    	
    	Select jourDepart = new Select(driver.findElement(By.id("DEPARTURE_DATE_1_DAY")));
    	jourDepart.selectByValue("17");
    	
    	Select moisArrivee = new Select(driver.findElement(By.id("DEPARTURE_DATE_2_MONTH")));
    	moisArrivee.selectByValue("11");
    	
    	Select jourArrivee = new Select(driver.findElement(By.id("DEPARTURE_DATE_2_DAY")));
    	jourArrivee.selectByValue("5");
    	
    	Select travelClass = new Select(driver.findElement(By.id("CFF_1")));
    	travelClass.selectByValue("1JE");
    	
    	Select NbAdults = new Select(driver.findElement(By.id("mdlNbAdt")));
    	NbAdults.selectByValue("1");
    	
    	
    	
    	pause(3);
    	
    	
    	//récupération des éléments saisis dans le form
    	
//    	villeDEPART = driver.findElement(By.id("mdlDepLocation1")).getText();
//    	System.out.println("ville de départ: " + villeDEPART);
//    	villeARRIVEE = driver.findElement(By.id("mdlArrLocation1")).getText();
//    	System.out.println("ville d'arrivée:" + villeARRIVEE);
    	//flightNumberALLER = driver.findElement(By.id("")).getText();
    	
    	
    	
    	
    	driver.findElement(By.id("mdlFormSubmit")).click();
    	
    	//mettre une pause pour l'affichage de la fenêtre de sélection de la langue pour continuer
    	pause(3); //pourrait être remplacée par un implicite wait (voir au début de l'instanciation de firstTest)
    	driver.findElements(By.cssSelector(".ui-button.ui-widget.ui-state-default.ui-corner-all.ui-button-text-only")).get(1).click();
	
    	
    	//sélection des billets d'avion???
	
    	pause(3);
    	prixTotal = driver.findElement(By.id("sidebarPriceSummaryTotalPrice")).getText();
	    System.out.println("prix total: "+ prixTotal);
	    
	    
	    //dureeTrajetALLER = driver.findElements(By.cssSelector("list-summary.bound-footer.b")).get(0).getText();
	    //System.out.println("la durée du trajet à l'aller est de : " + dureeTrajetALLER);
	    
	    
    	
    	driver.findElement(By.id("continueButton")).click();
    	
    	
    	//passenger information
    	Select TitleAdult1 = new Select(driver.findElement(By.id("0-title")));
    	TitleAdult1.selectByValue("MRS");
	
    	driver.findElement(By.id("0-last-name")).sendKeys("CEBRON DE LISLE");
    	pause(3);
    	driver.findElement(By.id("0-first-name")).sendKeys("Coralie");
    	pause(3);
    	
    	Select GenderAdult1 = new Select(driver.findElement(By.id("0-gender")));
    	GenderAdult1.selectByValue("string:FEMALE");
    	
    	Select DD1 = new Select(driver.findElement(By.id("0-birth-date-day")));
    	DD1.selectByValue("string:05");
    	pause(2);
    	Select MM1 = new Select(driver.findElement(By.id("0-birth-date-month")));
    	MM1.selectByValue("string:10");
    	pause(2);
    	Select YY1= new Select(driver.findElement(By.id("0-birth-date-year")));
    	YY1.selectByValue("string:1977");
    	
    	driver.findElement(By.id("0-passport-number")).sendKeys("FR0205N1258PP");
    	
    	//données du paiement bancaire
    	Select IssuingCountry1= new Select(driver.findElement(By.id("0-issuing-country")));
    	IssuingCountry1.selectByValue("string:FR");
    	Select ValidityDD1 = new Select(driver.findElement(By.id("0-validity-day")));
    	ValidityDD1.selectByValue("string:25");
    	Select ValidityMM1 = new Select(driver.findElement(By.id("0-validity-month")));
    	ValidityMM1.selectByValue("string:01");
    	Select ValidityYY1= new Select(driver.findElement(By.id("0-validity-year")));
    	ValidityYY1.selectByVisibleText("2021");
    	    	
    	pause(3);
    	
    	Select Nationality1= new Select(driver.findElement(By.id("0-nationality")));
    	Nationality1.selectByValue("string:FR");
    	
    	//Select MembershipProgram1= new Select(driver.findElement(By.id("0-membership-select")));
    	//MembershipProgram1.selectByValue("string:AF");
    	
    	//driver.findElement(By.id("0-membership-input")).sendKeys("1258125157");
    	
    	pause(2);
    	
    	Select Phone1= new Select(driver.findElement(By.id("phone1-phone-type-0")));
    	Phone1.selectByValue("string:APM");
    	
    	Select IndexCountry1= new Select(driver.findElement(By.id("phone1-phone-country-0")));
    	IndexCountry1.selectByValue("FRA");
    	
    	driver.findElement(By.id("phone1-phone-number-0")).sendKeys("06.63.10.17.89");
    	
    	driver.findElement(By.id("email-guest-address")).sendKeys("coralie.cebron-de-lisle5@orange.fr");
    	driver.findElement(By.id("email-confirm-new")).sendKeys("coralie.cebron-de-lisle5@orange.fr");
    	//fin passenger infos
    	 
    	
    	
    	driver.findElement(By.id("continueButton")).click();
    	
    	pause(2);
    	
    	//passenger confirmation
    	driver.findElement(By.id("continueButton-PCOF")).click();
    	
    	//choix des sièges???
       	pause(2);
    	driver.findElement(By.id("seatContinue")).click();
    	
    	pause(3);
    	
    	//récupération des données concernant le vol
    	villeDEPART = driver.findElement(By.id("departureLocationSegmentCity-0-0")).getText();
    	System.out.println("ville de départ: " + villeDEPART);
    	villeARRIVEE = driver.findElement(By.id("segmentDestinationLocation-0-0")).getText();
	   	System.out.println("ville d'arrivée: " + villeARRIVEE);    		
	  	
	   	dateDEPART = driver.findElement(By.id("originDate-0")).getText();
	   	System.out.println(dateDEPART);
	   	flightNumberALLER = driver.findElement(By.id("flightNumber-0-0")).getText();
	   	System.out.println(flightNumberALLER);   
	   	horaireDepartALLER = driver.findElement(By.id("segmentOriginDate-0-0")).getText();
	   	System.out.println("heure départ aller: " + horaireDepartALLER);
	   	horaireArriveeALLER= driver.findElement(By.id("segmentDestinationDate-0-2")).getText();
	   	System.out.println("heure arrivée aller: " + horaireArriveeALLER);
	   	
	   	dateRETOUR = driver.findElement(By.id("originDate-1")).getText();
	   	System.out.println(dateRETOUR);
	   	flightNumberRETOUR = driver.findElement(By.id("flightNumber-1-0")).getText();
	   	System.out.println(flightNumberRETOUR);   
	   	horaireDepartRETOUR = driver.findElement(By.id("segmentOriginDate-1-0")).getText();
	   	System.out.println("heure départ retour: " + horaireDepartRETOUR);
	   	horaireArriveeRETOUR = driver.findElement(By.id("segmentDestinationDate-1-2")).getText();
	   	System.out.println("heure arrivée retour: " + horaireArriveeRETOUR);
	   	
	   	prixTotalConfirm = driver.findElement(By.id("sidebarPriceSummaryTotalPrice")).getText();
	    System.out.println("prix total: "+ prixTotalConfirm);
	    
	        	
	    //"go to Payment"
    	pause(2);
    	driver.findElement(By.id("purchaseButton")).click();	
    	
    	//page de paiement CB
		driver.findElement(By.id("CCnb")).sendKeys("4012888888881881");
		
		Select ExpiryMM1 = new Select(driver.findElement(By.id("expiration-month-id")));
		ExpiryMM1.selectByValue("number:5");
		Select ExpiryYY1= new Select(driver.findElement(By.id("expiration-year-id")));
		ExpiryYY1.selectByValue("number:2022");
		driver.findElement(By.id("sec-code")).sendKeys("123"); 	
		
		
		//recherche du n° de vol dans le bandeau à droite dans "Show/Hide Details"
				// ! sélection de l'id et de la classe
		//Explicit waits
	   	//import WebDriverWait + import TimeoutException
		try{
			System.out.println(LocalDateTime.now());
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#flightNumber-0-0 .flight-identifier"))); 
			System.out.println("J'ai bien trouvé ton WebElément.");
		}
		catch (TimeoutException e){
			System.out.println("Je n'ai pas trouvé ton WebElément!");
		}
		
		//Vol ALLER
		if(driver.findElement(By.cssSelector("#flightNumber-0-0 .flight-identifier")).isDisplayed()) {
			System.out.println("le flight number s'affiche"); 
		} else {
			System.out.println("le flight number ne s'affiche pas. On click pour l'afficher");
			driver.findElements(By.cssSelector(".medium-pattern.mb1.p5")).get(0).click();
		}
		flightNumberALLERConfirm = driver.findElement(By.cssSelector("#flightNumber-0-0 .flight-identifier")).getText();
	   	System.out.println("Voici le n° du vol aller: " + flightNumberALLERConfirm);   
		
	   	try{
			System.out.println(LocalDateTime.now());
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#flightNumber-0-0 .flight-identifier"))); 
			System.out.println("J'ai bien trouvé ton WebElément.");
		}
		catch (TimeoutException e){
			System.out.println("Je n'ai pas trouvé ton WebElément!");
		}
			   	
		
		//Vol RETOUR
		if(driver.findElement(By.cssSelector("#flightNumber-1-0 .flight-identifier")).isDisplayed()) {
			System.out.println("le flight number s'affiche"); 
		} else {
			System.out.println("le flight number ne s'affiche pas. On click pour l'afficher");
			driver.findElements(By.cssSelector(".medium-pattern.mb1.p5")).get(1).click();
		}
		flightNumberRETOURConfirm = driver.findElement(By.cssSelector("#flightNumber-1-0 .flight-identifier")).getText();
	   	System.out.println("Voici le n° du vol aller: " + flightNumberRETOURConfirm);   
	
	   	
	   	dureeTrajetALLERConfirm = driver.findElements(By.cssSelector(".list-summary b")).get(2).getText();
	    System.out.println("la durée du trajet à l'aller est de : "+ dureeTrajetALLERConfirm);
		
		/*
		//import Actions et WebElement
		
		WebElement elementContinuf=driver.findElement(By.id("continueButton"));

        elementContinuf.click();
		WebElement elementbb = driver.findElement(By.id("confirm"));
		Actions actions = new Actions(driver);
        actions.moveToElement(elementbb).click().build().perform();
        //purchase button
        WebElement elementContinufff=driver.findElement(By.id("continueButton"));
        elementContinufff.click();
		
		*/
		
		//driver.findElement(By.id("continueButton")).click();
	   	
	   	
	    
	    
    	//comparaison de valeurs entre les pages des formulaires
		
	    
	    assertEquals(prixTotal, prixTotalConfirm);
		//assertTrue(flightNumberALLERConfirm.contains(flightNumberALLER));
		//assertTrue(flightNumberRETOURConfirm.contains(flightNumberRETOUR));
		//assertEquals(dureeTrajetALLER, dureeTrajetALLERConfirm);
				
		//création d'un tableau pour récupérer une des données séparées par un espace
		//String [] tableauDureeTrajetALLER = dureeTrajetALLER.split(" ");
		//dureeTrajetALLER = tableauDureeTrajetALLER[1];
	
		String [] tableauflightNumberALLER = flightNumberALLER.split(" ");
		flightNumberALLER = tableauflightNumberALLER[1];
		System.out.println("Voici le n° du vol aller: " + flightNumberALLER);  
		
		//assertTrue(flightNumberALLERConfirm.contains(flightNumberALLER));
		
	
	}
		
    	
	
	
	
    
    
}
