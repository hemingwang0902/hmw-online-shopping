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
	
	/**通知类型：有人关注了我*/
	int NOTICE_TYPE_ATTENTION_ME = 1;
	/**通知类型：有人问了我一个问题*/
	int NOTICE_TYPE_ASK_ME = 2;
	/**通知类型：有人邀请我回答一个问题*/
	int NOTICE_TYPE_INVITE_ME = 3;
	/**通知类型：我关注的问题有了新答案*/
	int NOTICE_TYPE_NEW_ANSWER = 4;
	/**通知类型：有人关注了我的品牌*/
	int NOTICE_TYPE_ATTENTION_BRAND = 5;
	/**通知类型：谁可以给我发私信*/
	int NOTICE_TYPE_SEND_PRIVATE = 6;
	/**通知类型：有人关注了我品牌下的问题*/
	int NOTICE_TYPE_ATTENTION_PROBLEM_BRAND = 7;
	/**通知类型：我关注的品牌下的问题有了新答案*/
	int NOTICE_TYPE_NEW_ANSWER_BRAND = 8;
	
}
