package com.cfl.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by chenfeilong on 2018/3/11.
 */
public class MaterialVo implements Serializable {
    private  Long id;
    private  Long bagTypeId;//'包型编号',
    private  String shopName;//'产品名称',
    private  String materialName;//'材料名称',
    private  String materialGuige;//'材料规格',
    private  String materialColor;//'材料颜色',
    private  String materialUnit;//'材料单位',
    private  Double materialYongliang;//'材料用量',
    private  Double materialHaosun;//'材料耗损',
    private  Double materialPrice;//'材料单价',
    private  Double materialMoney;//'材料总金额',
    private  String materialRemark;//'材料说明',
    private  Byte isActive;//'材料状态',
    private Date createTime;//创建时间
    private String bagTypeName;
    private String jisuan;
    private BagTypeVo bagTypeVo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBagTypeId() {
        return bagTypeId;
    }

    public void setBagTypeId(Long bagTypeId) {
        this.bagTypeId = bagTypeId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getMaterialGuige() {
        return materialGuige;
    }

    public void setMaterialGuige(String materialGuige) {
        this.materialGuige = materialGuige;
    }

    public String getMaterialColor() {
        return materialColor;
    }

    public void setMaterialColor(String materialColor) {
        this.materialColor = materialColor;
    }

    public String getMaterialUnit() {
        return materialUnit;
    }

    public void setMaterialUnit(String materialUnit) {
        this.materialUnit = materialUnit;
    }

    public Double getMaterialYongliang() {
        return materialYongliang;
    }

    public void setMaterialYongliang(Double materialYongliang) {
        this.materialYongliang = materialYongliang;
    }

    public Double getMaterialHaosun() {
        return materialHaosun;
    }

    public void setMaterialHaosun(Double materialHaosun) {
        this.materialHaosun = materialHaosun;
    }

    public Double getMaterialPrice() {
        return materialPrice;
    }

    public void setMaterialPrice(Double materialPrice) {
        this.materialPrice = materialPrice;
    }

    public Double getMaterialMoney() {
        return materialMoney;
    }

    public void setMaterialMoney(Double materialMoney) {
        this.materialMoney = materialMoney;
    }

    public String getMaterialRemark() {
        return materialRemark;
    }

    public void setMaterialRemark(String materialRemark) {
        this.materialRemark = materialRemark;
    }

    public Byte getIsActive() {
        return isActive;
    }

    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BagTypeVo getBagTypeVo() {
        return bagTypeVo;
    }

    public void setBagTypeVo(BagTypeVo bagTypeVo) {
        this.bagTypeVo = bagTypeVo;
    }

    public String getBagTypeName() {
        return bagTypeName;
    }

    public void setBagTypeName(String bagTypeName) {
        this.bagTypeName = bagTypeName;
    }

    public String getJisuan() {
        return jisuan;
    }

    public void setJisuan(String jisuan) {
        this.jisuan = jisuan;
    }
}
