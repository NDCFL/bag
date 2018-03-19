package com.cfl.service;

import com.cfl.vo.BagTypeVo;
import com.cfl.vo.Select2Vo;

import java.util.List;

public interface BagTypeService extends BaseService<BagTypeVo>{
    List<Select2Vo> getBagType();
}
