package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.rest.common.persistence.model.MtimeBrandDictT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.rest.model.cinema.bo.BrandBo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 品牌信息表 Mapper 接口
 * </p>
 *
 * @author EthanNew
 * @since 2019-06-04
 */

@Repository
public interface MtimeBrandDictTMapper extends BaseMapper<MtimeBrandDictT> {

    /**
     * 获取影院列表查询条件之影院条件
     * @param brandId
     * @return
     */
    List<BrandBo> getBrandList(Integer brandId);
}
