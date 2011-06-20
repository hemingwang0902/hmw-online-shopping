package com.baizhi.scorelevel.action;

import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;
import com.baizhi.commons.support.Elements;
import com.baizhi.commons.support.StringUtils;
import com.baizhi.scorelevel.service.ScoreLevelService;
/**
 * 
 * 类名：ScoreLevelSave.java
 * 描述： 积分级别信息表控制类，负责处理新增、修改操作
 * 创建者：江红
 * 创建日期： 2011-06-21 00:43:41
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class SaveScoreLevel extends ScoreLevelForm{
	
	private ScoreLevelService scoreLevelService;//积分级别信息表业务类
	
	public ScoreLevelService getScoreLevelService() {
		return scoreLevelService;
	}

	public void setScoreLevelService(ScoreLevelService scoreLevelService) {
		this.scoreLevelService = scoreLevelService;
	}
	
	@Override
	public String execute() throws Exception {
		Element element = null;
		String keyid="";
		//如果积分级别信息表ID为""，则为新增积分级别信息表，否则更新积分级别信息表
		if(StringUtils.isNotEmpty(this.getSCORELEVEL_ID())){
			element = scoreLevelService.getScoreLevelEleById("SCORELEVEL_ID");
			Elements.setElementValue(element, "SCORELEVEL_ID", this.getSCORELEVEL_ID());// 积分级别ID
			Elements.setElementValue(element, "NAME", this.getNAME());// 级别名称
			Elements.setElementValue(element, "SOCRE_UP", this.getSOCRE_UP());// 积分上限
			Elements.setElementValue(element, "SOCRE_DOWN", this.getSOCRE_DOWN());// 积分下限
			Elements.setElementValue(element, "REMARK", this.getREMARK());// 备注
			
			//如果保存成功，返回主键
			keyid = scoreLevelService.saveOrUpdateScoreLevel(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				this.setMessage("积分级别信息表信息编辑成功");
				return UPDATESUCCESS;
			}
		}else{
			element = new DefaultElement("T_SCORE_LEVEL");
			Elements.setElementValue(element, "NAME", this.getNAME());// 级别名称
			Elements.setElementValue(element, "SOCRE_UP", this.getSOCRE_UP());// 积分上限
			Elements.setElementValue(element, "SOCRE_DOWN", this.getSOCRE_DOWN());// 积分下限
			Elements.setElementValue(element, "REMARK", this.getREMARK());// 备注
			//如果保存成功，返回主键
			keyid = scoreLevelService.saveOrUpdateScoreLevel(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				return SUCCESS;
			}
		}
		return ERROR;
	}

}
