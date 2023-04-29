package com.bonsai.client.setting;

import com.bonsai.common.entity.setting.Setting;
import com.bonsai.common.entity.setting.SettingCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SettingRepository extends CrudRepository<Setting, String> {
	
	public List<Setting> findByCategory(SettingCategory category);
	
}
