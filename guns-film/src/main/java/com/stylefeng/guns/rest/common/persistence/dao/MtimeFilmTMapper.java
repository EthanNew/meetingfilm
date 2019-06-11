package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.api.film.vo.FilmDetailVO;
import com.stylefeng.guns.rest.common.persistence.model.MtimeFilmT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.rest.model.cinema.bo.FilmBO;
import com.stylefeng.guns.rest.model.cinema.bo.FilmInfoBO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * <p>
 * 影片主表 Mapper 接口
 * </p>
 *
 * @author alex
 * @since 2019-06-05
 */
public interface MtimeFilmTMapper extends BaseMapper<MtimeFilmT> {

    FilmDetailVO getFilmDetailByName(@Param("filmName") String filmName);

    FilmDetailVO getFilmDetailById(@Param("uuid") String uuid);

    FilmInfoBO getFilmByFieldId(@Param("fieldId") int fieldId);

    List<FilmBO> getFilmList();
}
