package models;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="post")
public class Post {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "post_id", nullable = false)
    private int postId;
    @Basic
    @Column(name = "title", nullable = true, length = 45)
    private String title;

    @OneToMany(mappedBy = "post")
    private Set<Comment> comments;

    public Post(String title) {
        this.title = title;
    }

    public Post() {
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return postId == post.postId && Objects.equals(title, post.title) && Objects.equals(comments, post.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, title, comments);
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", title='" + title + '\'' +
                ", comments=" + comments +
                '}';
    }
}
