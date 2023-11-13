package models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="comment")
public class Comment {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "comment_id", nullable = false)
    private int commentId;
    @Basic
    @Column(name = "author_name", nullable = true, length = 45)
    private String authorName;
    @ManyToOne
    @JoinColumn(name="post_id", nullable = false)
    private Post post;

    public Comment(String authorName, Post post) {
        this.authorName = authorName;
        this.post = post;
    }

    public Comment(int commentId, String authorName, Post post) {
        this.commentId = commentId;
        this.authorName = authorName;
        this.post = post;
    }

    public Comment() {
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return commentId == comment.commentId && Objects.equals(authorName, comment.authorName) && Objects.equals(post, comment.post);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, authorName, post);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", authorName='" + authorName + '\'' +
                ", post=" + post +
                '}';
    }
}
