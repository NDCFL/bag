package com.cfl.controller;

import com.cfl.common.Message;
import com.cfl.common.PageQuery;
import com.cfl.common.PagingBean;
import com.cfl.common.StatusQuery;
import com.cfl.enums.ActiveStatusEnum;
import com.cfl.service.MaterialService;
import com.cfl.vo.MaterialVo;
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
@RequestMapping("material")
public class MaterialController {

    @Resource
    private MaterialService materialService;
    @RequestMapping("materialList")
    @ResponseBody
    public PagingBean materialList(int pageSize, int pageIndex, String searchVal, HttpSession session) throws  Exception{
        UserVo userVo = (UserVo) session.getAttribute("userVo");
        PageQuery pageQuery = new PageQuery();
        PagingBean pagingBean = new PagingBean();
        pageQuery.setSearchVal(searchVal);
        pagingBean.setTotal(materialService.count(pageQuery));
        pagingBean.setPageSize(pageSize);
        pagingBean.setCurrentPage(pageIndex);
        pageQuery.setPageNo(pagingBean.getStartIndex());
        pageQuery.setPageSize(pagingBean.getPageSize());
        pagingBean.setrows(materialService.listPage(pageQuery));
        return pagingBean;
    }
    @RequestMapping("/materialAddSave")
    @ResponseBody
    public Message addSavematerial(MaterialVo material, HttpSession session) throws  Exception {
        try{
            UserVo userVo = (UserVo) session.getAttribute("userVo");
            material.setIsActive(ActiveStatusEnum.ACTIVE.getValue().byteValue());
            materialService.save(material);
            return  Message.success("新增成功!");
        }catch (Exception E){
            return Message.fail("新增失败!");
        }

    }
    @RequestMapping("/findMaterial/{id}")
    @ResponseBody
    public MaterialVo findmaterial(@PathVariable("id") long id){
        MaterialVo material = materialService.getById(id);
        return material;
    }
    @RequestMapping("/materialUpdateSave")
    @ResponseBody
    public Message updatematerial(MaterialVo material) throws  Exception{
        try{
            materialService.update(material);
            return  Message.success("修改成功!");
        }catch (Exception e){
            return Message.fail("修改失败!");
        }
    }
    @RequestMapping("/deleteManyMaterial")
    @ResponseBody
    public Message deleteManymaterial(@Param("manyId") String manyId,Integer status) throws  Exception{
        try{
            String str[] = manyId.split(",");
            for (String s: str) {
                materialService.updateStatus(new StatusQuery(Long.parseLong(s),status));
            }
            return Message.success("批量修改状态成功!");
        }catch (Exception e){
            e.printStackTrace();
            return  Message.fail("批量修改状态失败!");
        }
    }
    @RequestMapping("/deleteMaterial/{id}")
    @ResponseBody
    public Message deletematerial(@PathVariable("id") long id) throws  Exception{
        try{
            materialService.removeById(id);
            return Message.success("删除成功!");
        }catch (Exception e){
            e.printStackTrace();
            return Message.fail("删除失败!");
        }
    }
    @RequestMapping("/materialPage")
    public String table() throws  Exception{
        return "bag/materialList";
    }
    @RequestMapping("updateStatus/{id}/{status}")
    @ResponseBody
    public Message updateStatus(@PathVariable("id") long id,@PathVariable("status") int status) throws  Exception{
        try{
            materialService.updateStatus(new StatusQuery(id,status));
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
