import entity.Chat;
import entity.ChatType;
import entity.ChatTypeEnum;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

public class Test {
    public static void main(String[] args) {
        //get SessionFactory
        SessionFactory factory = HibernateUtil.getSessionFactory();
        //get the session
        Session session = HibernateUtil.getSession();
        try (factory;session) {
            //create a Chat
            Chat chat1 = new Chat();
            chat1.setName("chat");
            chat1.setDescription("This is the chat");

            //create Chat type
            ChatType chatType1 = new ChatType();
            chatType1.setChatType(ChatTypeEnum.GROUP_CHAT);

            //begin transaction
            session.beginTransaction();
            session.persist(chat1);
            session.persist(chatType1);

            //commit transaction
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
