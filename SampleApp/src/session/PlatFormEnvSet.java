package session;

public class PlatFormEnvSet {

	String testCaseName;
	String platform;
	boolean executionStatus;
	int startScriptDataRow;
	int endSriptDataRow;

	boolean desktopWeb;
	boolean androidWeb;
	boolean androidApp;
	boolean backEndWeb;
	String IP;

	public boolean isBackEndWeb() {
		return backEndWeb;
	}

	public void setBackEndWeb(boolean backEndWeb) {
		this.backEndWeb = backEndWeb;
	}

	boolean apiStatus;
	String browserName;

	public int getEndSriptDataRow() {
		return endSriptDataRow;
	}

	public void setEndSriptDataRow(int endSriptDataRow) {
		this.endSriptDataRow = endSriptDataRow;
	}

	public boolean isDesktopWeb() {
		return desktopWeb;
	}

	public void setDesktopWeb(boolean desktopWeb) {
		this.desktopWeb = desktopWeb;
	}

	public boolean isAndroidWeb() {
		return androidWeb;
	}

	public void setAndroidWeb(boolean androidWeb) {
		this.androidWeb = androidWeb;
	}

	public boolean isAndroidApp() {
		return androidApp;
	}

	public void setAndroidApp(boolean androidApp) {
		this.androidApp = androidApp;
	}

	public void setAPIStaus(boolean APIStatus) {
		this.apiStatus = APIStatus;
	}

	public boolean isAPIStatus() {
		return apiStatus;
	}

	public int getStartScriptDataRow() {
		return startScriptDataRow;
	}

	public void setStartScriptDataRow(int startScriptDataRow) {
		this.startScriptDataRow = startScriptDataRow;
	}

	public int getEndScriptDataRow() {
		return endSriptDataRow;
	}

	public void setEndScriptDataRow(int endSriptDataRow) {
		this.endSriptDataRow = endSriptDataRow;
	}

	public String getTestCaseName() {
		return testCaseName;
	}

	public void setTestCaseName(String testCaseName) {
		this.testCaseName = testCaseName;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public boolean getExecutionStatus() {
		return executionStatus;
	}

	public void setExecutionStatus(boolean executionStatus) {
		this.executionStatus = executionStatus;
	}

	public void setDesktopWebBrowserName(String browserName) {
		this.browserName = browserName;
	}

	public String getDesktopWebBrowserName() {
		return browserName;
	}

	public void setIP(String ip) {
		this.IP = ip;
	}

	public String getIP() {
		return IP;
	}
}