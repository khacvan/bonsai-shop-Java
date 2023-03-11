package com.shoppingcart.common.entity;

import java.util.List;

//SettingBag chứa list settings, trong class này khai báo phương thức lấy value từ một key bất kỳ
public class SettingBag {
	private List<Setting> listSettings;//chứa list tất cả settings, mỗi setting là một đối tượng chứa key,value,SettingCategory. Ví dụ: [Setting [key=MAIL_FROM, value=nhbtuyen2702@gmail.com], Setting [key=MAIL_HOST, value=smtp.gmail.com], Setting [key=MAIL_PASSWORD, value=gpctiolgpwrabzxn], Setting [key=MAIL_PORT, value=587], Setting [key=MAIL_SENDER_NAME, value=Shopping Team], Setting [key=MAIL_USERNAME, value=nhbtuyen2702@gmail.com], Setting [key=SMTP_AUTH, value=true], Setting [key=SMTP_SECURED, value=true]]

	public SettingBag(List<Setting> listSettings) {
		this.listSettings = listSettings;
	}
	
	public Setting get(String key) {
		int index = listSettings.indexOf(new Setting(key));
		if (index >= 0) {
			return listSettings.get(index);
		}
		
		return null;
	}
	
	public String getValue(String key) {
		Setting setting = get(key);
		if (setting != null) {
			return setting.getValue();
		}
		
		return null;
	}
	
	public void update(String key, String value) {
		Setting setting = get(key);
		if (setting != null && value != null) {
			setting.setValue(value);
		}
	}
	
	public List<Setting> list() {
		return listSettings;
	}
	
}