package com.dailycodebuffer.reactiveprogramming.services;

import com.dailycodebuffer.reactiveprogramming.domain.BookInfo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class BookInfoService {
    public Flux<BookInfo> getBooks() {
        var bookInfoList = List.of(
                new BookInfo(1, "Book One", "Author One", "121212"),
                new BookInfo(2, "Book Two", "Author Two", "131313"),
                new BookInfo(3, "Book Three", "Author Three", "141414")
        );

        return Flux.fromIterable(bookInfoList);
    }

    public Mono<BookInfo> getBookById(long bookId) {
        var bookInfo = new BookInfo(bookId, "Book One", "Author One", "121212");

        return Mono.just(bookInfo);
    }
}
