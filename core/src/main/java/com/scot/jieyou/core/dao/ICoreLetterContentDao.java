package com.scot.jieyou.core.dao;

import com.scot.jieyou.core.entity.LetterContentEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("letterContentDao")
public interface ICoreLetterContentDao {

    int deleteById(Long id);

    int insert(LetterContentEntity letterContentEntity);

    LetterContentEntity selectById(Long id);

    int update(LetterContentEntity letterContentEntity);

    List<LetterContentEntity> select(LetterContentEntity content);

}