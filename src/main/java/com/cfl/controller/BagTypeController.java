package com.cfl.controller;

import com.cfl.common.Message;
import com.cfl.common.PageQuery;
import com.cfl.common.PagingBean;
import com.cfl.common.StatusQuery;
import com.cfl.enums.ActiveStatusEnum;
import com.cfl.service.BagTypeService;
import com.cfl.vo.BagTypeVo;
import com.cfl.vo.UserVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by chenfeilong on 2017/10/21.
 */
@Controller
@RequestMapping("bagType")
public class BagTypeController {

    @Resource
    private BagTypeService bagTypeService;
    @RequestMapping("bagTypeList")
    @ResponseBody
    public PagingBean bagTypeList(int pageSize, int pageIndex, String searchVal, HttpSession session) throws  Exception{
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        PageQuery pageQuery = new PageQuery();
        PagingBean pagingBean = new PagingBean();
        pageQuery.setSearchVal(searchVal);
        pagingBean.setTotal(bagTypeService.count(pageQuery));
        pagingBean.setPageSize(pageSize);
        pagingBean.setCurrentPage(pageIndex);
        pageQuery.setPageNo(pagingBean.getStartIndex());
        pageQuery.setPageSize(pagingBean.getPageSize());
        pagingBean.setrows(bagTypeService.listPage(pageQuery));
        return pagingBean;
    }
    @RequestMapping("/bagTypeAddSave")
    @ResponseBody
    public Message addSavebagType(BagTypeVo bagType, HttpSession session) throws  Exception {
        try{
            UserVo userVo = (UserVo) session.getAttribute("userVo");
            bagType.setIsActive(ActiveStatusEnum.ACTIVE.getValue().byteValue());
            bagTypeService.save(bagType);
            return  Message.success("新增成功!");
        }catch (Exception E){
            return Message.fail("新增失败!");
        }

    }
    @RequestMapping("/findBagType/{id}")
    @ResponseBody
    public BagTypeVo findbagType(@PathVariable("id") long id){
        BagTypeVo bagType = bagTypeService.getById(id);
        return bagType;
    }
    @RequestMapping("/bagTypeUpdateSave")
    @ResponseBody
    public Message updatebagType(BagTypeVo bagType) throws  Exception{
        try{
            bagTypeService.update(bagType);
            return  Message.success("修改成功!");
        }catch (Exception e){
            return Message.fail("修改失败!");
        }
    }
    @RequestMapping("/deleteManyBagType")
    @ResponseBody
    public Message deleteManybagType(@Param("manyId") String manyId,Integer status) throws  Exception{
        try{
            String str[] = manyId.split(",");
            for (String s: str) {
                bagTypeService.updateStatus(new StatusQuery(Long.parseLong(s),status));
            }
            return Message.success("批量修改状态成功!");
        }catch (Exception e){
            e.printStackTrace();
            return  Message.fail("批量修改状态失败!");
        }
    }
    @RequestMapping("/deleteBagType/{id}")
    @ResponseBody
    public Message deletebagType(@PathVariable("id") long id) throws  Exception{
        try{
            bagTypeService.removeById(id);
            return Message.success("删除成功!");
        }catch (Exception e){
            e.printStackTrace();
            return Message.fail("删除失败!");
        }
    }
    @RequestMapping("/bagTypePage")
    public String table() throws  Exception{
        return "bag/bagTypeList";
    }
    @RequestMapping("updateStatus/{id}/{status}")
    @ResponseBody
    public Message updateStatus(@PathVariable("id") long id,@PathVariable("status") int status) throws  Exception{
        try{
            bagTypeService.updateStatus(new StatusQuery(id,status));
            return Message.success("ok");
        }catch (Exception e){
            return  Message.fail("fail");
        }
    }
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
