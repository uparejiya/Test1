import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SauceLabExample {

	public static final String USERNAME = "rock1234";
	public static final String AUTOMATE_KEY = "28bfabf9-101b-4081-b165-85759318834b";
	public static final String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@ondemand.saucelabs.com:80/wd/hub";
	// public static final String URL = "http://10.124.130.221:4444/wd/hub";
	private List<WebElement> foundUrls = new ArrayList<WebElement>();
	private List<String> visitedUrls = new ArrayList<String>();
	private List<String> adsUrlText = new ArrayList<String>();
	public int flushVisitedURLs = 2;

	public static WebDriver driver;

	public static void main(String[] args) throws Exception {
		try {

			System.out.println(getRandomNumber(5, 3));
			System.out.println("Execution started....");
			System.setProperty("webdriver.chrome.driver", "./crx/chromedriver.exe");
			DesiredCapabilities caps = DesiredCapabilities.chrome();
			ChromeOptions options = new ChromeOptions();
			options.addExtensions(new File("./crx/plugin.crx"));
			options.setBinary("D:/Program Files/chrome45/chrome.exe");
			// options.addExtensions(new
			// File("D:\\Users\\uparejiy\\Documents\\test1.crx"));
			// options.addArguments("load-extension=D:\\Users\\uparejiy\\Documents\\test1");
			// options.addExtensions(new File("D:\\Development\\Chrome Plugin
			// Dev\\Sample Plugin.crx"));
			// caps.setCapability("platform", "Windows 10");
			// caps.setCapability("version", "55");

			Map<String, String> mobileEmulation = new HashMap<String, String>();
			mobileEmulation.put("deviceName", "Google Nexus 5");

			Map<String, Object> chromeOptions = new HashMap<String, Object>();
			chromeOptions.put("mobileEmulation", mobileEmulation);
		//	caps.setPlatform(Platform.WINDOWS);
			// caps.setCapability("platform", "Windows");
			caps.setCapability("version", "49");
			caps.setBrowserName("chrome");
			caps.setCapability("name", "Sauce Sample Test");
			//caps.setCapability("idleTimeout ", "250");
			caps.setCapability(ChromeOptions.CAPABILITY, options);

			driver = new RemoteWebDriver(caps);

			/**
			 * Goes to Sauce Lab's guinea-pig page and prints title
			 */
			driver.get("http://ipinfo.io/"); 
			
			new SauceLabExample().closeOtherWindows(); 
			driver.manage().deleteAllCookies();
			/*
			//
			 * driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			 * driver.manage().deleteAllCookies(); WebElement ipBlock =
			 * driver.findElement(By.xpath("//*[@class='table table-striped']"
			 * )); String ip =
			 * driver.findElement(By.xpath("//*[@id='heading']")).getText();
			 * String locTable = ipBlock.findElement(By.xpath(
			 * ".//*[contains(text(),'City')]/following-sibling::td"))
			 * .getText(); System.out.println("IP: " + ip); System.out.println(
			 * "IP Location Details: " + locTable); // File screenShotFile =
			 * ((TakesScreenshot) // driver).getScreenshotAs(OutputType.FILE);
			 * // FileUtils.copyFile(screenShotFile, new //
			 * File("D:/testsaucelabs1.jpg")); System.out.println("Passed 1...."
			 * );
			 * 
			 * // driver.get("http://whatismyipaddress.com"); // //
			 * driver.manage().timeouts().pageLoadTimeout(10, //
			 * TimeUnit.SECONDS); // // WebElement ipBlock =
			 * driver.findElement(By.id("section_left")); // String ip = //
			 * ipBlock.findElement(By.xpath(".//div[2]/a")).getText(); // String
			 * locTable = //
			 * ipBlock.findElement(By.xpath(".//table")).getText(); //
			 * System.out.println("IP: "+ip); // System.out.println(
			 * "IP Location Details: "+locTable); // File screenShotFile =
			 * ((TakesScreenshot) // driver).getScreenshotAs(OutputType.FILE);
			 * // FileUtils.copyFile(screenShotFile, new //
			 * File("D:/testsaucelabs1.jpg")); // System.out.println(
			 * "Passed 1....");
			 * 
			 * 
			 * 
			 * 
			 * 
			 */

			WebDriverWait wait = new WebDriverWait(driver, 30);

			// driver.navigate().to("chrome-extension://neldmjjbbngjmcjmdpojbhealachjiol/js/popup.html");
//			try {
//				driver.navigate().to("http://hola.org/access/ipinfo.io/using/vpn-us?go=2");
//			} catch (Exception e) {
//			}

			 driver.navigate().to("chrome-extension://pibeppmeikklkgfgkncigcmpngnaenfe/js/popup.html");
			 System.out.println("loaded");
			 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Most popular')]")));
			  System.out.println("loaded1");
			 driver.findElement(By.xpath("//*[@class='form-control search auto tt-input']")) .sendKeys("http://ipinfo.io");
			 // driver.findElement(By.xpath("//*[@class='form-control search auto tt-input']")).submit();
			 ((JavascriptExecutor)driver).executeScript("arguments[0].click();",driver.findElement(By.xpath("//*[@class='popup-search-trigger']") ));

			// driver.findElement(By.xpath("//*[@class='popup-search-trigger']")).click();
			// Thread.sleep(20000);
			// wait.until(ExpectedConditions.urlToBe("http://ipinfo.io"));
			Thread.sleep(7000);
			 smartWait(30);
			// wait.until(ExpectedConditions.urlContains("ipinfo"));
			// ipBlock = driver.findElement(By.id("section_left"));
			// ip = ipBlock.findElement(By.xpath(".//div[2]/a")).getText();
			// locTable = ipBlock.findElement(By.xpath(".//table")).getText();
			// System.out.println("IP: "+ip);
			// System.out.println("IP Location Details: "+locTable);
			// screenShotFile = ((TakesScreenshot)
			// driver).getScreenshotAs(OutputType.FILE);
			// FileUtils.copyFile(screenShotFile, new
			// File("D:/testsaucelabs2.jpg"));
			 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='heading']")));
			 String ip;
//		String ip = ((JavascriptExecutor) driver).executeScript("return arguments[0].textContent",
//					driver.findElement(By.xpath("//*[@class='table table-striped']"))).toString();
			 WebElement ipBlock = driver.findElement(By.xpath("//*[@class='table table-striped']"));
			 ip =driver.findElement(By.xpath("//*[@id='heading']")).getText();
			// ip =ipBlock.findElement(By.xpath(".//*[contains(text(),'Route')]/following-sibling::td")).getText();
			 String locTable =ipBlock.findElement(By.xpath(".//*[contains(text(),'City')]/following-sibling::td")).getText();
			System.out.println("IP: " + ip); System.out.println("IP Location Details: " + locTable);
			// screenShotFile = ((TakesScreenshot)
			// driver).getScreenshotAs(OutputType.FILE);
			// FileUtils.copyFile(screenShotFile, new
			// File("D:/testsaucelabs2.jpg"));
			System.out.println("Passed 2....");

			driver.navigate().to("http://hola.org/access/knownotion.com/using/vpn-us?go=2");

			
//			  driver.navigate().to("chrome-extension://pibeppmeikklkgfgkncigcmpngnaenfe/js/popup.html");
//			  System.out.println("loaded");
//			  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Most popular')]"))); 
//			  // Thread.sleep(10000); 
//			  System.out.println("loaded1"); 
//			  //screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); 
//			  //FileUtils.copyFile(screenShotFile, new File("D:/testsaucelabs3.jpg")); 
//			  driver.findElement(By.xpath("//*[@class='form-control search auto tt-input']")).sendKeys("http://www.knownotion.com"); 
//			  ((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@class='popup-search-trigger']")));
//			

			// driver.findElement(By.xpath("//*[@class='popup-search-trigger']")).click();
			// Thread.sleep(15000);
			// wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'Know
			// Notion')]"))));
			// wait.until(ExpectedConditions.urlToBe("http://www.knownotion.com"));
			System.out.println("Passed 3....");
			Thread.sleep(5000);
			// Thread.sleep(10000);
			smartWait(30);
			// wait.until(ExpectedConditions.presenceOfElementLocated(
			// By.xpath("//*[@class='widget-title' and
			// text()='IP']/following-sibling::div")));
			String siteIP = driver
					.findElement(By.xpath("//*[@class='widget-title' and text()='IP']/following-sibling::div"))
					.getText().trim();
			System.out.println(siteIP);
			if (siteIP.contains(ip)) {
				System.out.println("IPs matched. Safe to go ahead.");
				if (!ipUpdate(ip)) {
					new SauceLabExample().monkeyTest("www.knownotion.com", "content.ad", SauceLabExample.class);
				} else {
					System.out.println("IP already exists");
				}

			} else {
				System.out.println("Ips are different.");
			}
			System.out.println("Passed 4....");
			// screenShotFile = ((TakesScreenshot)
			// driver).getScreenshotAs(OutputType.FILE);
			// FileUtils.copyFile(screenShotFile, new
			// File("D:/testsaucelabs4.jpg"));
			System.out.println("title of page is: " + driver.getTitle());

			// System.out.println("earlier: " +
			// driver.getWindowHandles().toString());
			// WebElement adnowElement = driver
			// .findElement(By.xpath("//*[@id='text-5' and
			// ./h3[contains(text(),'Other Contents')]]"));
			// List<WebElement> allTRs = adnowElement
			// .findElements(By.xpath(".//table//td[@class='SC_TBlock_269184_td']//tr[1]/td//a"));
			// for (WebElement ele : allTRs) {
			// System.out.println(ele.getAttribute("title"));
			// ele.click();
			// System.out.println("after: " +
			// driver.getWindowHandles().toString());
			// break;
			// }
			// *[@id='text-5' and ./h3[contains(text(),'Other
			// Contents')]]//table//td[@class='SC_TBlock_269184_td']//tr[1]/td//a
			Thread.sleep(7000);
		} catch (Exception e) {
			System.out.println("Test Failed: " + e.getMessage());
			e.printStackTrace();
		} finally {
			File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenShotFile, new File("D:/testsaucelabs5.jpg"));
			driver.quit();
		}
	}

	public static boolean ipUpdate(String ip) throws IOException {
		StringBuffer stringBuffer = new StringBuffer();
		boolean state = false;
		try {
			File file = new File("input.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String line;
			while ((line = bufferedReader.readLine()) != null) {
				if (line != ip) {
					stringBuffer.append(line);
					stringBuffer.append("\n");
				} else {
					state = true;
				}
			}
			fileReader.close();
			if (state) {
				return state;
			} else {
				stringBuffer.append(ip);
			}

			System.out.println("Contents of file:");
			System.out.println(stringBuffer.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			BufferedWriter bwr = new BufferedWriter(new FileWriter(new File("demo.txt")));

			// write contents of StringBuffer to a file
			bwr.write(stringBuffer.toString());

			// flush the stream
			bwr.flush();

			// close the stream
			bwr.close();
			return state;
		}

	}

	@SuppressWarnings("null")
	public static void test() throws UnknownHostException {
		InetAddress ip = InetAddress.getLocalHost();
		System.out.println("Current IP address : " + ip.getHostAddress());

		WebServiceContext wsContext = null;
		MessageContext mc = wsContext.getMessageContext();
		HttpServletRequest req = (HttpServletRequest) mc.get(MessageContext.SERVLET_REQUEST);
		System.out.println("Client IP = " + req.getRemoteAddr());
	}

	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("X-Real-IP");
		if (null != ip && !"".equals(ip.trim()) && !"unknown".equalsIgnoreCase(ip)) {
			return ip;
		}
		ip = request.getHeader("X-Forwarded-For");
		if (null != ip && !"".equals(ip.trim()) && !"unknown".equalsIgnoreCase(ip)) {
			// get first ip from proxy ip
			int index = ip.indexOf(',');
			if (index != -1) {
				return ip.substring(0, index);
			} else {
				return ip;
			}
		}
		return request.getRemoteAddr();
	}

	public static void smartWait(int TimeInSeconds) {

		try {
			ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver webDriver) {

					JavascriptExecutor js = (JavascriptExecutor) webDriver;
					String val1 = js.executeScript("return document.readyState;").toString();
					System.out.println(val1);
					if (val1.equalsIgnoreCase("complete"))
						return true;
					return false;
				}
			};

			Wait<WebDriver> wait = new WebDriverWait(driver, TimeInSeconds);
			try {
				wait.until(expectation);
			} catch (Exception e) {
				throw e;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int getRandomNumber(int max, int min) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}

	public void monkeyTest(Object Url, Object extURL, Class<?> clsName) throws InterruptedException, IOException {
		closeOtherWindows();
		System.out.println("Monkey job started");
		String extURLStr = extURL.toString();
		String url = Url.toString();
		String baseUrl = url;
		// this.foundUrls.add(url);
		int adsClickSlot = 0;
		boolean started = false;
		boolean adsState = false;
		// int num = 0;
		int pageNeedsToCrawl = getRandomNumber(4, 3);
		int adPageCrawl = 0;
		while (adsClickSlot <= 3) {

			WebElement currentUrl = null;
			String currentUrl1 = null;
			if (!started) {
				currentUrl1 = "Start the code";

			} else {
				if (pageNeedsToCrawl == 0) {
					pageNeedsToCrawl = getRandomNumber(4, 3);
					checkAndClickAds();
					adsClickSlot = adsClickSlot + 1;
				}

				currentUrl = this.nextUrl();
			}

			if (currentUrl1 == "URL FINISHED") {
				break;
			} else if (currentUrl1 == "Start the code") {
				started = true;
				this.foundUrls.addAll(getUrls(baseUrl, extURLStr));
			} else {
				//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: \"end\", behavior: \"smooth\"});", currentUrl);
				//Thread.sleep(2000);
				
				//currentUrl.click();
				checkElementIsClickable(currentUrl);
				this.foundUrls.clear();
				pageNeedsToCrawl = pageNeedsToCrawl - 1;
				smartWait(30);
				Thread.sleep(getRandomNumber(7, 5) * 1000);
				this.foundUrls.addAll(getUrls(baseUrl, extURLStr));
			}
		}
		// driver.quit();
	}
	
	public void checkElementIsClickable(WebElement ele){
		boolean visible = false;
		do{
			try{
				WebDriverWait wait = new WebDriverWait(driver, 4); 
				System.out.println("Ele displayed: "+ele.isDisplayed());
				System.out.println("Ele enabled: "+ele.isEnabled());
				WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ele));
				
				element.sendKeys(Keys.ENTER);;
				visible = true;
			}catch(Exception e){
				System.out.println("Got Exception");
				visible = false;
			}
			if(visible){
				System.out.println("visible break now");
				break;
			}else{
				System.out.println("JS executed");
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",ele);
			}
			
		}while(!visible);
		
		
	}

	public void closeOtherWindows() {
		System.out.println("Closing all other windows....");
		String mainHandle = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			if (!mainHandle.equalsIgnoreCase(winHandle)) {
				driver.switchTo().window(winHandle);
				driver.close();
				driver.switchTo().window(mainHandle);
			}
		}
	}

	public void checkAndClickAds() {
		closeOtherWindows();
		System.out.println("Clicking on adNow Ads....");
		WebElement adnowElement = driver
				.findElement(By.xpath("//*[@id='text-5' and ./h3[contains(text(),'Other Contents')]]"));
		List<WebElement> allTRs = adnowElement
				.findElements(By.xpath(".//table//td[@class='SC_TBlock_269184_td']//tr[1]/td//a"));
		boolean adState = false;
		do {
			WebElement el = getRandomElement(allTRs);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", el);
			if (this.adsUrlText.contains(el.getAttribute("title"))) {
				adState = false;
			} else {
				adState = true;
				el.click();
				try {
					Thread.sleep(getRandomNumber(5, 3) * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} while (adState == false);
		// for (WebElement ele : allTRs) {
		// System.out.println(ele.getAttribute("title"));
		// ele.click();
		// System.out.println("after: " + driver.getWindowHandles().toString());
		// break;
		// }
	}

	public WebElement nextUrl() {
		System.out.println("Next Url");
		WebElement nextUrl = null;
		String nextUrl1;
		if(flushVisitedURLs==0){
			this.visitedUrls.clear();
			flushVisitedURLs = 2;
		}
		do {
			if (this.foundUrls.size() > 0) {
				this.foundUrls.remove(0);
				Collections.shuffle(this.foundUrls);
				nextUrl = getRandomElement(this.foundUrls);
				nextUrl1 = nextUrl.getAttribute("href");
			} else {
				nextUrl1 = "URL FINISHED";
			}
		} while (this.visitedUrls.contains(nextUrl1));

		System.out.println("URL to visit: "+nextUrl1);
		this.visitedUrls.add(nextUrl1);
		flushVisitedURLs = flushVisitedURLs -1;
		return nextUrl;
	}

	public static <T> T getRandomElement(Collection<T> c) {
		int random = (int) (Math.random() * c.size());
		Iterator<T> it = c.iterator();
		for (int i = 0; i < random; i++) {
			it.next();
		}
		return it.next();
	}

	public boolean urlValidate(String baseUrl, String extURLStr, String href) {

		String host = hostFind(baseUrl);
		String exUrl = ".*(" + extURLStr + ").*";
		String base = ".*(" + host + ").*";
		if (Pattern.matches(exUrl, href)) {
			return false;
		} else {
			if (href.startsWith("http://") || href.startsWith("https://")) {
				if (Pattern.matches(base, href)) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
	}

	public List<WebElement> getUrls(String baseUrl, String extURLStr) {
		System.out.println("Getting urls");
		List<WebElement> links = new ArrayList<WebElement>();
		//List<WebElement> list = driver.findElements(By.xpath("//a[contains(@href,'knownotion.com')][@title=not('')][not(@rel)][text()]"));// driver.findElements(By.cssSelector("a"));
		List<WebElement> list = driver.findElements(By.xpath("//a[contains(@href,'knownotion.com')][@title=not('')][not(@rel)][text()][not(contains(@title,'topic'))]"));// driver.findElements(By.cssSelector("a"));
		
		links = list;
		// for (int i = 0; i < list.size(); i++) {
		// String href = list.get(i).getAttribute("href");
		// if (list.get(i).isDisplayed()) {
		// links.add(list.get(i));
		// }
		// // if (href == null) {
		// //
		// // } else {
		// // boolean urlCheck = urlValidate(baseUrl, extURLStr, href);
		// // if (urlCheck == true && list.get(i).isDisplayed()) {
		// // links.add(list.get(i));
		// // }
		// // }
		// }
		return links;
	}

	public String hostFind(String url) {
		String host = null;
		try {
			if (!url.startsWith("http://")) {
				url = "http://" + url;
			}
			URL urlWith = new URL(url);
			String fullHost = urlWith.getHost();
			host = fullHost.substring(4);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return host;
	}
}
