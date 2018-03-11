package com.cfl.service.impl;

import com.cfl.common.PageQuery;
import com.cfl.common.StatusQuery;
import com.cfl.dao.MaterialDAO;
import com.cfl.service.MaterialService;
import com.cfl.vo.MaterialVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chenfeilong on 2018/3/11.
 */
@Service
public class MaterialServiceImpl implements MaterialService{
    @Resource
    private MaterialDAO materialDAO;
    @Override
    public void save(MaterialVo materialVo) {
        materialDAO.save(materialVo);
    }

    @Override
    public void remove(MaterialVo materialVo) {
        materialDAO.remove(materialVo);
    }

    @Override
    public void removeById(Long id) {
        materialDAO.removeById(id);
    }

    @Override
    public void update(MaterialVo materialVo) {
        materialDAO.update(materialVo);
    }

    @Override
    public void updateStatus(StatusQuery statusQuery) {
        materialDAO.updateStatus(statusQuery);
    }

    @Override
    public MaterialVo getById(Long id) {
        return materialDAO.getById(id);
    }

    @Override
    public List<MaterialVo> listAll() {
        return materialDAO.listAll();
    }

    @Override
    public List<MaterialVo> listPage(PageQuery pageQuery) {
        return materialDAO.listPage(pageQuery);
    }

    @Override
    public long count(PageQuery pageQuery) {
        return materialDAO.count(pageQuery);
    }
}
