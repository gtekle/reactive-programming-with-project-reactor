package com.dailycodebuffer.reactiveprogramming.services;

import com.dailycodebuffer.reactiveprogramming.exception.BookException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BookServiceMockTest {

    @InjectMocks
    private BookService bookService;
    @Mock
    private BookInfoService bookInfoService;
    @Mock
    private ReviewService reviewService;

    @Test
    void getBooksMock() {
        Mockito.when(bookInfoService.getBooks())
                .thenCallRealMethod();
        Mockito.when(reviewService.getReviews(Mockito.anyLong()))
                .thenCallRealMethod();

        var books = bookService.getBooks();

        StepVerifier.create(books)
                .expectNextCount(3)
                .verifyComplete();

    }

    @Test
    void getBooksMockOnError() {
        Mockito.when(bookInfoService.getBooks())
                .thenCallRealMethod();
        Mockito.when(reviewService.getReviews(Mockito.anyLong()))
                .thenThrow(new IllegalStateException("exception using mocked test"));

        var books = bookService.getBooks();

        StepVerifier.create(books)
                .expectError(BookException.class)
                .verify();

    }
}