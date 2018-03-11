package com.cfl.service.impl;

import com.cfl.common.PageQuery;
import com.cfl.common.StatusQuery;
import com.cfl.dao.BagTypeDAO;
import com.cfl.service.BagTypeService;
import com.cfl.vo.BagTypeVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class BagTypeServiceImpl implements BagTypeService {
    @Resource
    private BagTypeDAO bagTypeDAO;
    @Override
    public void save(BagTypeVo bagTypeVo) {
        bagTypeDAO.save(bagTypeVo);
    }

    @Override
    public void remove(BagTypeVo bagTypeVo) {
        bagTypeDAO.remove(bagTypeVo);
    }

    @Override
    public void removeById(Long id) {
        bagTypeDAO.removeById(id);
    }

    @Override
    public void update(BagTypeVo bagTypeVo) {
        bagTypeDAO.update(bagTypeVo);
    }

    @Override
    public void updateStatus(StatusQuery statusQuery) {
        bagTypeDAO.updateStatus(statusQuery);
    }

    @Override
    public BagTypeVo getById(Long id) {
        return bagTypeDAO.getById(id);
    }

    @Override
    public List<BagTypeVo> listAll() {
        return bagTypeDAO.listAll();
    }

    @Override
    public List<BagTypeVo> listPage(PageQuery pageQuery) {
        return bagTypeDAO.listPage(pageQuery);
    }

    @Override
    public long count(PageQuery pageQuery) {
        return bagTypeDAO.count(pageQuery);
    }
}
