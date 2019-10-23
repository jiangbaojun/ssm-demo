package com.ssm.common.support;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.github.pagehelper.PageInfo;
import com.ssm.common.ParameterHolder;
import com.ssm.common.constant.ConfigConstant;
import com.ssm.common.enums.MsgStateEnum;

/**
 * 基础controller
 */
public abstract class BaseController {

    /**
     * 操作成功提示信息
     * @param msg 提示消息内容
     */
	public Map successMessage(String msg) {
        Map<String, Object> map = new HashMap<String, Object>();
		map.put("msg", msg);
		map.put("flag", MsgStateEnum.SUCCESS.getValue());
		return map;
	}

    /**
     * 操作失败提示信息
     * @param msg 提示消息内容
     */
	public Map failMessage(String msg) {
        Map<String, Object> map = new HashMap<String, Object>();
		map.put("msg", msg);
		map.put("flag", MsgStateEnum.ERROR.getValue());
		return map;
	}

   
	/**
     * 获得处理后的前台请求参数
	 */
	public Map<String, Object> getParameterMap(HttpServletRequest request) {
		Map<String, Object> params= ParameterHolder.getFormParameter(request);
        return params;
	}

    /**
     * 获得前台所需要的结果集
     * @param list 结果数据
     */
	public Map<String, Object> getResultMap(List<?> list) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
        PageInfo page = null;
		if(list instanceof PageInfo){
            page = (PageInfo) list;
        }else{
            page = new PageInfo(list);
        }
		resultMap.put(ConfigConstant.RESULT_LIST_KEY, page.getList());
		resultMap.put(ConfigConstant.PAGE_PAGE_KEY, page.getPageNum());
		resultMap.put(ConfigConstant.PAGE_SIZE_KEY, page.getSize());
		resultMap.put(ConfigConstant.PAGE_TOTAL_KEY, page.getTotal());
		return resultMap;
	}

    /**
     * 获得前台所需要的结果集,手动指定total和page
     * @param list 数据
     * @param page 页码
     * @param total 总数据条数
     * @return
     */
	public Map<String, Object> getResultMap(List list,Object page,Object total) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put(ConfigConstant.RESULT_LIST_KEY, list);
		if(page!=null && total!=null) {
			if(page instanceof Integer) {
				int myPage = (int)page;
				resultMap.put(ConfigConstant.PAGE_PAGE_KEY, myPage==0?1:myPage);
			}
			if(total instanceof Integer) {
				int myTotal= (int)total;
				resultMap.put(ConfigConstant.PAGE_TOTAL_KEY, myTotal);
			}
		}
		return resultMap;
	}
}