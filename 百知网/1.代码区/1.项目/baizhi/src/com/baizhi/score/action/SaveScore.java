package com.baizhi.score.action;

import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;
import com.baizhi.commons.support.Elements;
import com.baizhi.commons.support.StringUtils;
import com.baizhi.score.service.ScoreService;
/**
 * 
 * 类名：ScoreSave.java
 * 描述： 积分信息表控制类，负责处理新增、修改操作
 * 创建者：江红
 * 创建日期： 2011-08-07 18:51:46
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class SaveScore extends ScoreForm{
	
	private static final long serialVersionUID = -4579841381918356723L;
	
	private ScoreService scoreService;//积分信息表业务类
	
	public ScoreService getScoreService() {
		return scoreService;
	}

	public void setScoreService(ScoreService scoreService) {
		this.scoreService = scoreService;
	}
	
	@Override
	public String execute() throws Exception {
		Element element = null;
		String keyid="";
		//如果积分信息表ID为""，则为新增积分信息表，否则更新积分信息表
		if(StringUtils.isNotEmpty(this.getSCORE_ID())){
			element = scoreService.getScoreEleById("SCORE_ID");
			Elements.setElementValue(element, "SCORE_ID", this.getSCORE_ID());// 积分ID
			Elements.setElementValue(element, "NAME", this.getNAME());// 积分名称
			Elements.setElementValue(element, "SOCRE_TYPE", this.getSOCRE_TYPE());// 积分类型(1、会员邀请朋友注册获得积分2、提问题3、回答问题)
			Elements.setElementValue(element, "SOCRE", this.getSOCRE());// 积分
			Elements.setElementValue(element, "IS_VALID", this.getIS_VALID());// 是否禁用
			Elements.setElementValue(element, "REMARK", this.getREMARK());// 备注
			
			//如果保存成功，返回主键
			keyid = scoreService.saveOrUpdateScore(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				this.setMessage("积分信息表信息编辑成功");
				return UPDATESUCCESS;
			}
		}else{
			element = new DefaultElement("T_SCORE");
			Elements.setElementValue(element, "NAME", this.getNAME());// 积分名称
			Elements.setElementValue(element, "SOCRE_TYPE", this.getSOCRE_TYPE());// 积分类型(1、会员邀请朋友注册获得积分2、提问题3、回答问题)
			Elements.setElementValue(element, "SOCRE", this.getSOCRE());// 积分
			Elements.setElementValue(element, "IS_VALID", this.getIS_VALID());// 是否禁用
			Elements.setElementValue(element, "REMARK", this.getREMARK());// 备注
			//如果保存成功，返回主键
			keyid = scoreService.saveOrUpdateScore(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				return SUCCESS;
			}
		}
		return ERROR;
	}

}
