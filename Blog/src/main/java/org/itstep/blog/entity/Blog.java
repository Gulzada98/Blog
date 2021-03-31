package org.itstep.blog.entity;

import java.time.LocalDate;

public class Blog {

    private Long id;
    private String title;
    private String content;
    private User author;
    private LocalDate postDate;

    public Blog(Long id, String title, String content, User author, String postDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.postDate = LocalDate.parse(postDate);
    }

    public Blog(Long id, String title, String content, User author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public User getAuthor() {
        return author;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author=" + author +
                ", date=" + postDate +
                '}';
    }
}
