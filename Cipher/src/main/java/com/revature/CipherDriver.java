//101619 0216p
package com.revature;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.models.Comment;
import com.revature.models.Forums;
import com.revature.models.IUser;
import com.revature.models.User;
import com.revature.repositories.IForumsDAO;
import com.revature.repositories.IUserDAO;
import com.revature.repositories.UserDAO;

public class CipherDriver {

	private static Configuration configuration;
	private static StandardServiceRegistryBuilder ssrb;
	private static SessionFactory sf;
	private static Session session;
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

		IUserDAO userDAO = (IUserDAO) ac.getBean("userDAO");
		IForumsDAO forumDAO = (IForumsDAO) ac.getBean("forumsDAO"); 
		List<User> users = userDAO.findAll();
		
		for(User u : users) {
			System.out.println(u);
		}
		
//		User lan = userDAO.findOne(1);
//		lan.setUseremail("LHikari@rockmanexe.com");
//		userDAO.update(lan);
//		
//		User user2 = userDAO.findOne(2);
//		user2.setUseremail("LHikari@rockmanexe.com");
//		userDAO.update(user2);
//		
//		User user7 = userDAO.findOne(7);
//		user7.setUseremail("LHikari@rockmanexe.com");
//		userDAO.update(user7);
		
//		String jackie = "LightningPunch@gmail.com";
//		User checkEmail = userDAO.findByEmail(jackie);
//		System.out.println(checkEmail);
//		Forums pastchat = forumDAO.findOne(1);
//		pastchat.setUser(checkEmail);
//		forumDAO.update(pastchat);
		
//		Forums chatroom = new Forums();
//		chatroom.setUser(checkEmail);
//		chatroom.setForumstopic("Microsoft Stock Rises");
//		chatroom.setForumscomment("Shocking");
//		forumDAO.save(chatroom);
		List<Forums> chatlist = forumDAO.findAll();
		ArrayList<Forums> chatsorted = new ArrayList(chatlist);
		
//		for (Forums chattopic : chatlist) {
//			System.out.println(chattopic.getForumsid());
//			System.out.println(chattopic.getForumscomment());
//			System.out.println(chattopic.getForumstopic());
//			System.out.println(chattopic.getUser().getUserfirstname());
//		}
		ArrayList<Comment> commentlist = new ArrayList();
		for (Forums f : chatlist) {
			Comment c = new Comment(f.getUser().getUserid(), f.getForumsid(),
					f.getForumstopic(), f.getForumscomment());
			commentlist.add(c);
		}
		System.out.println(commentlist);
	//	User roll = userDAO.findOne(3);
	//	System.out.println(roll);
	//	User newUser = new User();
//		newUser.setUserlastname("Sakurai");
//		newUser.setUserfirstname("Meiru");
//		newUser.setUseremail("MSeiru@rockmanexe.com");
//		newUser.setUserpassword("Heart");
	//	newUser.setUserlastname("Morgan");
	//	newUser.setUserfirstname("JP");
	//	newUser.setUseremail("JPMorgan@yahoo.com");
	//	newUser.setUserpassword("Chase");
	//	userDAO.save(newUser);
		((ClassPathXmlApplicationContext) ac).close();
		
	}

}
