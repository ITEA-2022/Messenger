import entity.Chat;
import entity.ChatType;
import entity.ChatTypeEnum;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class TestAnotherVersion {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().
                configure().build();
        SessionFactory factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        //create a Chat
        Chat chat1 = new Chat();
        chat1.setName("channel");
        chat1.setDescription("This is the channel");

        //create Chat type
        ChatType chatType1 = new ChatType();
        chatType1.setChatType(ChatTypeEnum.CHANNEL);

        //begin transaction
        session.beginTransaction();
        session.persist(chat1);
        session.persist(chatType1);

        transaction.commit();

        session.close();
        factory.close();
    }
}
