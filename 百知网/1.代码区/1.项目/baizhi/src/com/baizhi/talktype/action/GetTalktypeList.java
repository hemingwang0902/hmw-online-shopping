package com.baizhi.talktype.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.baizhi.talktype.service.TalktypeService;
/**
 * 类名： TalktypeList.java<br>
 * 描述：  获取话题类型表列表信息
 * 创建者：江红
 * 创建日期： 2011-08-13 22:34:26
 * 版本：V0.9 
 * 修改者：
 * 修改日期：
 */
public class GetTalktypeList extends TalktypeForm {
	
	private static final long serialVersionUID = 4219762204644668707L;
	
	private TalktypeService talktypeService;//话题类型表业务类
	
	public TalktypeService getTalktypeService() {
		return talktypeService;
	}

	public void setTalktypeService(TalktypeService talktypeService) {
		this.talktypeService = talktypeService;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		//设置查询条件
		this.setMap(params, "TALKTYPE_ID=?", this.getTALKTYPE_ID());// 话题类型ID
		if(this.getTYPE_NAME()!=null&&!this.getTYPE_NAME().trim().equals("")){
			this.setMap(params, "TYPE_NAME like ?", "%"+this.getTYPE_NAME()+"%");// 类型名称
		}
		
		this.setMap(params, "REMARK=?", this.getREMARK());// 备注
		this.setMap(params, "CREATE_TIME=?", this.getCREATE_TIME());// 创建时间
		this.setMap(params, "MODIFY_TIME=?", this.getMODIFY_TIME());// 修改时间
		// 查询话题类型表列表
		Map<String, Object> returnMap = talktypeService.getTalktypeList(params, this.getNowPage(), this.getOnePageCount());
		//判断是否存在查询记录
		if (returnMap != null && returnMap.size() != 0) {
			//判断是否存在列表数据，如果存在列表数据，则将日期格式转换
			if(returnMap.get("list")!=null&&((List<Map<String,Object>>)returnMap.get("list")).size()>0){
				List<Map<String, Object>> list = (List<Map<String,Object>>)returnMap.get("list");
				for (int i = 0; i < list.size(); i++) {
					Map<String, Object> newmap = list.get(i);
					newmap.put("CREATE_TIME", getTime(newmap, "CREATE_TIME"));
				}
				
			}
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}

	
	
}