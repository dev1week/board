package com.example.board.controller;



import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@DisplayName("뷰 컨트롤러 - 게시글 테스트")
@WebMvcTest(ArticleController.class)
class ArticleControllerTest {
    private final MockMvc mvc;

    public ArticleControllerTest(@Autowired MockMvc mvc){
        this.mvc = mvc;
    }

    @DisplayName("view get 게시글 리스트 (게시판) 페이지 정상호출")
    @Test
    public void given_whenRequstingView_thenReturnsArticlesView() throws Exception {
        //given
        //when
        //then
        mvc.perform(get("/articles"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                //키가 았는지 없는지 확인
                .andExpect(model().attributeExists("articles"));

    }
    @DisplayName("view get 게시글 리스트 (게시판) 상세 페이지 정상호출")
    @Test
    public void given_whenRequstingView_thenReturnsArticleView() throws Exception {
        //given
        //when
        //then
        mvc.perform(get("/articles/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                //키가 았는지 없는지 확인
                .andExpect(model().attributeExists("article"));

    }
    @DisplayName("view get 게시글 리스트 (게시판) 검색 페이지 정상호출")
    @Test
    public void given_whenRequstingView_thenReturnsSearchArticleView() throws Exception {
        //given
        //when
        //then
        mvc.perform(get("/articles/search"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML));
    }
    @DisplayName("view get 게시글 리스트 해시태그 검색 페이지 정상호출")
    @Test
    public void given_whenRequstingView_thenReturnsHashtagSearchArticleView() throws Exception {
        //given
        //when
        //then
        mvc.perform(get("/articles/search-hashtag"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML));
    }
}