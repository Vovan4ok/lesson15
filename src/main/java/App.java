import models.Comment;
import models.Post;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.Arrays;
import java.util.HashSet;

public class App {
    public static void main( String[] args ) {
        Post post = new Post();
        post.setTitle("gmail");

        Comment comment1 = new Comment("volodymyr@gmail.com", post);
        Comment comment2 = new Comment("nastya@gmail.com", post);
        post.setComments(new HashSet<>(Arrays.asList(comment1, comment2)));

        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        session.save(post);
        session.save(comment1);
        session.save(comment2);

        transaction.commit();
        session.close();
    }
}
