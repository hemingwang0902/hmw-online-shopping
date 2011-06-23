package com.baizhi.talk.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.baizhi.talk.service.TalkService;
/**
 * 类名： TalkList.java<br>
 * 描述：  获取话题信息表列表信息
 * 创建者：江红
 * 创建日期： 2011-06-20 23:49:03
 * 版本：V0.9 
 * 修改者：
 * 修改日期：
 */
public class GetTalkList extends TalkForm {
	
	private static final long serialVersionUID = -8472641085073099878L;
	
	private TalkService talkService;//话题信息表业务类
	
	public TalkService getTalkService() {
		return talkService;
	}

	public void setTalkService(TalkService talkService) {
		this.talkService = talkService;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		//设置查询条件
		this.setMap(params, "CONTENT=?", this.getCONTENT());// 内容
		// 查询话题信息表列表
		Map<String, Object> returnMap = talkService.getTalkList(params, this.getNowPage(), this.getOnePageCount());
		//判断是否存在查询记录
		//判断是否存在查询记录
		if (returnMap != null && returnMap.size() != 0) {
			//判断是否存在列表数据，如果存在列表数据，则将日期格式转换
			if(returnMap.get("list")!=null&&((List<Map<String,Object>>)returnMap.get("list")).size()>0){
				List<Map<String, Object>> list = (List<Map<String,Object>>)returnMap.get("list");
				for (int i = 0; i < list.size(); i++) {
					Map<String, Object> newmap = list.get(i);
					String CREATE_TIME=getTime(newmap, "CREATE_TIME");
					String MODIFY_TIME=getTime(newmap, "MODIFY_TIME");
					newmap.put("CREATE_TIME", CREATE_TIME);
					newmap.put("MODIFY_TIME", MODIFY_TIME.equals("")?"&nbsp;":MODIFY_TIME);
				}
				
			}
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}

	
	
}