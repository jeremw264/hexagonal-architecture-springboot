package com.jeremw.hexagonal.adapter.book;

import com.jeremw.hexagonal.adapter.util.BaseMapper;
import com.jeremw.hexagonal.domain.Book;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

/**
 * Mapper interface for converting between {@link Book} and {@link BookEntity}.
 *
 * @author Jérémy Woirhaye
 * @version 1.0
 * @since 26/10/2024
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookMapper extends BaseMapper<Book, BookEntity> {
    /**
     * Singleton instance of {@link BookMapper}.
     */
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);
}
