package page.base;

import org.testng.annotations.BeforeMethod;

import com.force.ui.base.ProjectHooks;

public class SalesforceHooks extends ProjectHooks{
	
	@BeforeMethod
	public void zLogin() {
		new LoginPage().doLogin();
	}
	
	public void typeInputField(String label, String value) {
		type("//label[text()='"+label+"']/following::input[1]", value, label);
	}
	
	public void typeInputInFrame(String label, String value) {
		typeInFrame("//label[text()='"+label+"']/following::input[1]", value, label);
	}

	public void chooseByText(String label, String value) {
		clickAndChoose("//label[text()='"+label+"']/following::lightning-base-combobox[1]", "(//label[text()='"+label+"']/following::lightning-base-combobox[1]//lightning-base-combobox-item//span[text()='"+value+"'])[1]", label, value);
	}
	
	public void chooseByTextInFrame(String label, String value) {
		clickAndChooseInFrame("//label[text()='"+label+"']/following::lightning-base-combobox[1]", "(//label[text()='"+label+"']/following::lightning-base-combobox[1]//lightning-base-combobox-item//span[text()='"+value+"'])[1]", label, value);
	}
	
	public void verifyMandatory(String label) {
		verifyAttribute("(//label[text()='"+label+"']/following::td[1]//div[1])[1]", "class","requiredInput");
	}
	
	public void verifyMandatoryInFrame(String label) {
		verifyAttributeInFrame("(//label[text()='"+label+"']/following::td[1]//div[1])[1]", "class","requiredInput");
	}
}


