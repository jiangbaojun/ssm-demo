package com.ssm.common.support;

import java.util.Map;
import java.util.UUID;

import com.github.pagehelper.PageHelper;
import com.ssm.common.constant.ConfigConstant;

/**
 * 基础Service
 */
public abstract class BaseService {

    /**
     * 开始分页
     * @param params
     */
    public void startPage(Map<String, Object> params){
        int page = ConfigConstant.PAGE_DEFAULT_PAGE_VALUE;
        int size = ConfigConstant.PAGE_DEFAULT_SIZE_VALUE;
        String sort = null;
        if(params!=null){
            Object pageObj = params.get(ConfigConstant.PAGE_PARAM_PAGE_KEY);
            Object sizeObj = params.get(ConfigConstant.PAGE_PARAM_SIZE_KEY);
            Object sortObj = params.get(ConfigConstant.PAGE_PARAM_SORT_KEY);
            if(pageObj!=null){
                try {
                    int t = Integer.parseInt(pageObj.toString());
                    page = t;
                } catch (NumberFormatException e) {}
            }
            if(sizeObj!=null){
                try {
                    int t = Integer.parseInt(sizeObj.toString());
                    size = t;
                } catch (NumberFormatException e) {}
            }
            if(sortObj!=null){
               sort = sortObj.toString();
            }
        }
        if(sort!=null && !"".equals(sort)){
            PageHelper.startPage(page, size, sort);
        }else{
            PageHelper.startPage(page, size);
        }
    }

    /**
     * 生成数据id
     * @return
     */
    public String getDataId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}