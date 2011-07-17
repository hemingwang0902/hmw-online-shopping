package com.baizhi;

/**
 * 类名： IConstants<br>
 * 描述：常量接口<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-7-5<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public interface IConstants {

	int DEFAULT_PAGE_SIZE = 10;

	/**回复投票类型：赞成*/
	String ANSWER_VOTE_AGREE = "Agree";
	/**回复投票类型：反对*/
	String ANSWER_VOTE_DISAGREE = "DisAgree";
	/**回复投票类型：感谢作者*/
	String ANSWER_VOTE_THANK = "Thank";
	/**回复投票类型：没有帮助*/
	String ANSWER_VOTE_DISTHANK = "Disthank";

	/**品牌状态：未申请*/
	int BRAND_STAUS_UNAPPLY = 1;
	/**品牌状态：申请*/
	int BRAND_STAUS_APPLIED = 2;
	/**品牌状态：通过*/
	int BRAND_STAUS_PASSED = 3;
	/**品牌状态：未通过*/
	int BRAND_STAUS_UNPASS = 4;
	
	/**问题话题关联表中的类型：话题*/
	int TALK_TYPE_TALK = 1;
	/**问题话题关联表中的类型：品牌*/
	int TALK_TYPE_BRAND = 2;
}
