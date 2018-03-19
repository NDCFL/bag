package com.cfl.dao;

import com.cfl.vo.BagTypeVo;
import com.cfl.vo.Select2Vo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BagTypeDAO  extends BaseDAO<BagTypeVo>{
    List<Select2Vo> getBagType();
}
