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

	//Session的key
	String SESSION_USERINFO="userinfo";
	String SESSION_USER_ID="USER_ID";
	String SESSION_USER_ID_ENCODE="USER_ID_ENCODE";
	String SESSION_CHANGE_TYPE="CHANGE_TYPE";
	String SESSION_CITY = "CITY";
	
	/**cookie 的名称*/
	String COOKIE_REMEBER_ME  = "BAIZHI-LOGIN-REMEBERME";
	
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
	
	/**切换城市/省份的类型：省份*/
	int CHANGE_TYPE_PROVINCE=1;
	/**切换城市/省份的类型：城市*/
	int CHANGE_TYPE_CITY=2;
	
	/**用户类型：普通会员*/
	int USER_TYPE_MEMBER = 1;
	/**用户类型：系统管理员*/
	int USER_TYPE_ADMIN = 3;
	
	/**新增积分的业务类型：会员邀请朋友注册获得积分*/
	String DYNAMIC_TYPE_INVITE = "1";
	/**新增积分的业务类型：提问题*/
	String DYNAMIC_TYPE_ADD_PROBLEM = "2";
	/**新增积分的业务类型：回答问题*/
	String DYNAMIC_TYPE_ADD_ANSWER = "3";
	
	/**
	 * 通知类型 <br>
	 * 创建日期：2012-2-15
	 * @author  <a href="mailto:hemw@mochasoft.com.cn">何明旺</a>
	 */
	enum NoticeType{
	    /**有人关注了我*/
	   attentionMe(1, 1),
	    /**有人问了我一个问题*/
	   askMe(2, 1),
	    /**有人邀请我回答一个问题*/
	   inviteMe(3, 1),
	    /**我关注的问题有了新答案*/
	   newAnswer(4, 1),
	    /**有人关注了我的品牌*/
	   attentionBrand(5, 1),
	    /**谁可以给我发私信，默认为我关注的人*/
	   sendPrivate(6, 4),
	    /**有人关注了我品牌下的问题*/
	   attentionProblemBrand(7, 1),
	    /**我关注的品牌下的问题有了新答案*/
	   newAnswerBrand(8, 1),
	   /**谁可以查看我给收、发过的私信动态，默认为关注我的人*/
	   viewPrivate(9, 5),
	   /**谁可以查看我的心情随记，默认为关注我的人*/
	   viewMood(10, 5) ;
	    
	    public final int key;
	    public final int defaultVal;
	    
        private NoticeType(int key, int defaultVal) {
            this.key = key;
            this.defaultVal = defaultVal;
        }

        @Override
        public String toString() {
            return "" + this.key;
        }
	}
}
