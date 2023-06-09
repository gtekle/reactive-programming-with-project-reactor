package com.dailycodebuffer.reactiveprogramming.services;

import com.dailycodebuffer.reactiveprogramming.domain.Book;
import com.dailycodebuffer.reactiveprogramming.domain.BookInfo;
import com.dailycodebuffer.reactiveprogramming.domain.Review;
import com.dailycodebuffer.reactiveprogramming.exception.BookException;
import lombok.extern.slf4j.Slf4j;
import reactor.core.Exceptions;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;
import reactor.util.retry.RetryBackoffSpec;

import java.time.Duration;
import java.util.List;

@Slf4j
public class BookService {
    private final BookInfoService bookInfoService;
    private final ReviewService reviewService;

    public BookService(BookInfoService bookInfoService, ReviewService reviewService) {
        this.bookInfoService = bookInfoService;
        this.reviewService = reviewService;
    }

    public Flux<Book> getBooks() {
        var allBooks = bookInfoService.getBooks();

        return allBooks
                .flatMap(bookInfo -> {
                    Mono<List<Review>> reviews = reviewService.getReviews(bookInfo.getBookId()).collectList();
                    return reviews.map(review -> new Book(bookInfo, review));
                })
                .onErrorMap(throwable -> {
                    log.error("Exception is : " + throwable);
                    return new BookException("Exception occurred while fetching books!");
                })
                .log();
    }

    public Flux<Book> getBooksRetry() {
        var allBooks = bookInfoService.getBooks();

        return allBooks
                .flatMap(bookInfo -> {
                    Mono<List<Review>> reviews = reviewService.getReviews(bookInfo.getBookId()).collectList();
                    return reviews.map(review -> new Book(bookInfo, review));
                })
                .onErrorMap(throwable -> {
                    log.error("Exception is : " + throwable);
                    return new BookException("Exception occurred while fetching books!");
                })
                .retry(3)
                .log();
    }

    public Flux<Book> getBooksRetryWhen() {
        var allBooks = bookInfoService.getBooks();

        return allBooks
                .flatMap(bookInfo -> {
                    Mono<List<Review>> reviews = reviewService.getReviews(bookInfo.getBookId()).collectList();
                    return reviews.map(review -> new Book(bookInfo, review));
                })
                .onErrorMap(throwable -> {
                    log.error("Exception is : " + throwable);
                    return new BookException("Exception occurred while fetching books!");
                })
                .retryWhen(getRetryBackoffSpec())
                .log();
    }

    private static RetryBackoffSpec getRetryBackoffSpec() {
        return Retry.backoff(
                        3,
                        Duration.ofMillis(1000)
                ).filter(throwable -> throwable instanceof BookException)
                .onRetryExhaustedThrow((retryBackoffSpec, retrySignal) ->
                        Exceptions.propagate(retrySignal.failure())
                );
    }

    public Mono<Book> getBookById(long bookId) {
        var bookInfo = bookInfoService.getBookById(bookId);
        var reviews = reviewService.getReviews(bookId).collectList();

        return bookInfo.zipWith(reviews, Book::new);
    }
}
