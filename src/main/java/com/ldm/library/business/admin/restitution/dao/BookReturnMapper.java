package com.ldm.library.business.admin.restitution.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;
import com.ldm.library.business.admin.restitution.domain.entity.BookReturn;
import com.ldm.library.business.admin.restitution.domain.vo.BookReturnVo;
import org.apache.ibatis.annotations.Param;

public interface BookReturnMapper extends BaseMapper<BookReturn> {
    Page<BookReturnVo> list(@Param("returnName") String returnName);
}